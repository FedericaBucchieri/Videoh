package services;

import entities.Professor;
import entities.Video;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

public class VideoService {
    @PersistenceContext(unitName="default")
    private EntityManager em;

    public VideoService(EntityManager em) {
        this.em = em;
    }

    public Video findVideoById(int videoId) {
        Video video = em.find(Video.class, videoId);
        return video;
    }

    public List<Video> findVideosByProfessor(int professorId){
        Professor professor = em.find(Professor.class, professorId);
        return professor.getVideoList();
    }

    public void createVideo(String title, int professorId){
        Professor professor = em.find(Professor.class, professorId);
        Video video = new Video(title, professor);
        em.getTransaction().begin();
        em.persist(video);
        em.getTransaction().commit();
    }
}
