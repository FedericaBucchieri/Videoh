package model;

import EventManagement.*;
import entities.Professor;
import entities.Video;
import exceptions.UpdateVideoException;
import sceneManager.Utils;
import services.VideoService;

import java.util.ArrayList;
import java.util.List;

public class VideoListElementModel {
    private Video video;
    private List<Listener> listeners = new ArrayList<>();

    public VideoListElementModel(Video video) {
        this.video = video;
    }

    public void addListener(Listener listener){
        listeners.add(listener);
    }


    public void deleteVideo(){
        dispatchDeleteVideoEvent(video);

        VideoService videoService = new VideoService();
        videoService.deleteVideo(video.getId());
    }

    /*
    TODO Non va qui
    public void updateVideo(String title, String description, String preview){
        VideoService videoService = new VideoService();

        try {
            videoService.updateVideo(video, title, description, preview);
            dispatchUpdateVideoEvent(video);
        } catch (UpdateVideoException e) {
            dispatchErrorEvent(e.getMessage());
        }

    }

     */

    private void dispatchDeleteVideoEvent(Video video){
        for (Listener listener : listeners)
            listener.listen(new DeleteVideoEvent(video));
    }
}
