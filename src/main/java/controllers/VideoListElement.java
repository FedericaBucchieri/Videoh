package controllers;

import EventManagement.DeleteVideoEvent;
import EventManagement.Listener;
import entities.Video;
import model.VideoListElementModel;
import view.VideoElementUI;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class VideoListElement extends JPanel{
    private VideoListElementModel model;
    private VideoElementUI ui;
    private Video video;
    private List<Listener> listeners = new ArrayList<>();

    public VideoListElement(Video video, VideoList videoList) {
        this.video = video;

        this.model = new VideoListElementModel(video);
        this.listeners.add(videoList);

        this.ui = new VideoElementUI();
        this.ui.installUI(this);
    }


    public Video getVideo() {
        return video;
    }

    public void deleteVideo(){
        dispatchDeleteVideoEvent(this.ui.getMainPanel(), this.getVideo());
        model.deleteVideo();
    }

    private void dispatchDeleteVideoEvent(JPanel videoPanel, Video video){
        for (Listener listener : listeners)
            listener.listen(new DeleteVideoEvent(videoPanel, video));
    }

    public void handleModifyRequest(){
        //@TODO
        System.out.println("Modify Request");
    }

    public void handleStatisticRequest(){
        //@TODO
        System.out.println("Statistic request");
    }

    public void paintComponent(Graphics pen) {
        add(this.ui.getMainPanel());
    }

}
