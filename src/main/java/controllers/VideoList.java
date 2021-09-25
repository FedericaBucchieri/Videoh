package controllers;

import EventManagement.DeleteVideoEvent;
import EventManagement.Event;
import EventManagement.Listener;
import EventManagement.LoginEvent;
import entities.Professor;
import entities.Video;
import model.VideoListModel;
import sceneManager.Utils;
import view.VideoListUI;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class VideoList extends JPanel implements Listener {
    private VideoListModel model;
    private VideoListUI ui;

    public VideoList(Professor professor) {
        this.model = new VideoListModel(professor);
        this.ui = new VideoListUI();
        this.ui.installUI(this);
    }

    public List<Video> getVideoList(){
        return model.getVideoList();
    }

    @Override
    public void listen(Event event) {
        if(event.getClass().equals(DeleteVideoEvent.class)) {
            getVideoList().remove(((DeleteVideoEvent) event).getVideo());
            repaint();
        }
    }

    @Override
    public void paintComponent(Graphics pen) {
        add(this.ui.getMainPanel());
    }

    public Dimension getMinimumSize() { return getPreferredSize(); }
    public Dimension getPreferredSize() {
        return new Dimension(Utils.VIDEOLIST_WIDTH, Utils.VIDEOLIST_HEIGHT);
    }
    public Dimension getMaximumSize() { return getPreferredSize(); }
}
