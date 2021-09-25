package model;

import entities.Professor;
import entities.Video;
import services.VideoService;

import java.util.List;

public class VideoListModel {
    private Professor professor;

    public VideoListModel(Professor professor) {
        this.professor = professor;
    }


    public List<Video> getVideoList() {
        VideoService service = new VideoService();
        return service.findVideosByProfessor(professor.getId());
    }

}
