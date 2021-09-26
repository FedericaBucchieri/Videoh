package controllers;

import EventManagement.CancelEvent;
import EventManagement.Listener;
import EventManagement.NewVideoEvent;
import EventManagement.NewVideoRequestEvent;
import entities.Video;
import model.AddVideoFormModel;
import sceneManager.Utils;
import scenes.ProfessorHomePage;
import view.AddVideoFormUI;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class AddVideoForm extends JComponent {
    private AddVideoFormModel model;
    private AddVideoFormUI ui;
    private List<Listener> listeners = new ArrayList<>();

    public AddVideoForm(ProfessorHomePage professorHomePage) {
        this.listeners.add(professorHomePage);
        this.setLayout(new BorderLayout());

        this.model = new AddVideoFormModel(professorHomePage.getProfessor());
        this.ui = new AddVideoFormUI(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
       add(this.ui.getMainPanel());
    }

    public void handleNewVideoRequest(String title, String description, String previewImage, File file){
        Video newVideo = model.createNewVideo(title, description, previewImage, file);
        dispatchNewVideoEvent(newVideo);
    }

    private void dispatchNewVideoEvent(Video video){
        for (Listener listener : listeners)
            listener.listen(new NewVideoEvent(video));
    }

    public void handleCancelRequest(){
        dispatchCancelEvent();
    }

    private void dispatchCancelEvent(){
        for (Listener listener : listeners)
            listener.listen(new CancelEvent());
    }

    public Dimension getMinimumSize() { return getPreferredSize(); }
    public Dimension getPreferredSize() {
        return new Dimension(800, Utils.JFRAME_HEIGHT);
    }
    public Dimension getMaximumSize() { return getPreferredSize(); }
}
