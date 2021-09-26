package controllers;

import EventManagement.DeleteVideoEvent;
import EventManagement.Event;
import EventManagement.Listener;
import EventManagement.RepaintEvent;
import entities.Professor;
import entities.Video;
import model.VideoListModel;
import sceneManager.Utils;
import scenes.ProfessorHomePage;
import view.VideoListUI;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class VideoList extends JComponent implements Listener {
    private VideoListModel model;
    private VideoListUI ui;
    private List<Listener> listeners = new ArrayList<>();

    public VideoList(Professor professor, ProfessorHomePage professorHomePage) {
        this.listeners.add(professorHomePage);
        this.model = new VideoListModel(professor);
        this.ui = new VideoListUI();
        this.ui.installUI(this);

        this.setLayout(new BorderLayout());
    }

    public List<Video> getVideoList(){
        return model.getVideoList();
    }

    @Override
    public void listen(Event event) {
        if(event.getClass().equals(DeleteVideoEvent.class)) {
            Video toBeRemoved = ((DeleteVideoEvent) event).getVideo();
            model.removeVideo(toBeRemoved);
            this.ui.setVideoList(model.getProfessor().getVideoList());
            this.ui.getListPanel().repaint();
            this.ui.paint();
            repaint();
            dispatchRepaintEvent();
        }
    }

    @Override
    public void paintComponent(Graphics pen) {
        this.ui.paint();
        add(this.ui.getMainPanel(), BorderLayout.CENTER);
    }

    private void dispatchRepaintEvent(){
        for (Listener listener : listeners)
            listener.listen(new RepaintEvent());
    }

    public Dimension getMinimumSize() { return getPreferredSize(); }
    public Dimension getPreferredSize() {
        return new Dimension(Utils.VIDEOLIST_WIDTH, Utils.VIDEOLIST_HEIGHT);
    }
    public Dimension getMaximumSize() { return getPreferredSize(); }
}
