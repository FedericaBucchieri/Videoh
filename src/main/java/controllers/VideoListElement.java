package controllers;

import EventManagement.Event;
import EventManagement.Listener;
import entities.Video;
import model.VideoListElementModel;
import sceneManager.Utils;
import view.VideoListElementUI;

import javax.swing.*;
import java.awt.*;

public class VideoListElement extends JPanel{
    private VideoListElementModel model;
    private VideoListElementUI ui;
    private Video video;

    public VideoListElement(Video video, VideoList videoList) {
        this.video = video;

        this.model = new VideoListElementModel(video);
        this.model.addListener(videoList);

        this.ui = new VideoListElementUI();
        this.ui.installUI(this);
    }

    public Video getVideo() {
        return video;
    }

    public void deleteVideo(){
        model.deleteVideo();
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

    public Dimension getMinimumSize() { return getPreferredSize(); }
    public Dimension getPreferredSize() {
        return new Dimension(500, 500);
    }
    public Dimension getMaximumSize() { return getPreferredSize(); }

}
