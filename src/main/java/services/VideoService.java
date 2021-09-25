package services;

import entities.Professor;
import entities.Video;
import exceptions.UpdateVideoException;
import jakarta.persistence.*;
import sceneManager.Utils;

import java.util.List;
import java.util.Random;

public class VideoService {

    @PersistenceContext(unitName="default")
    private EntityManager em;
    private EntityManagerFactory entityManagerFactory;


    public VideoService() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("default");
        this.em = entityManagerFactory.createEntityManager();
    }

    public Video findVideoById(int videoId) {
        Video video = em.find(Video.class, videoId);
        return video;
    }

    public List<Video> findVideosByProfessor(int professorId){
        Professor professor = em.find(Professor.class, professorId);
        return professor.getVideoList();
    }

    public Video createVideo(String title, String description, String previewImage, Professor professor){
        Random random = new Random();
        int videoCode = random.nextInt(Utils.VIDEO_CODE_BOUND);

        Video video = new Video(title, description, previewImage, videoCode, professor);
        em.getTransaction().begin();
        em.persist(video);
        em.getTransaction().commit();

        return video;
    }

    public void deleteVideo(int videoId){
        Video video = em.find(Video.class, videoId);
        Professor professor = video.getProfessor();
        professor.removeVideo(video);
        em.remove(video);
    }

    public void updateVideo(Video video, String title, String description, String preview) throws UpdateVideoException {
        if(title != null)
            video.setTitle(title);

        if(description != null)
            video.setDescription(description);

        if(preview != null)
            video.setPreviewImage(preview);

        try {
            em.merge(video);
        } catch (PersistenceException e){
            throw new UpdateVideoException(Utils.ERROR_UPDATE_VIDEO);
        }
    }
}
