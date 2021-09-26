package scenes;

import EventManagement.*;
import EventManagement.Event;
import controllers.AddVideoForm;
import controllers.DetailPanel;
import controllers.VideoList;
import entities.Professor;
import entities.Video;
import sceneManager.SceneManager;

import javax.swing.*;
import java.awt.*;

public class ProfessorHomePage implements Listener {
    private VideoList videoList;
    private DetailPanel detailPanel;
    private AddVideoForm addVideoForm;
    private Professor professor;
    private JPanel mainPanel;


    public ProfessorHomePage(SceneManager sceneManager, Professor professor) {
        this.professor = professor;
        this.mainPanel = new JPanel(new BorderLayout());

        videoList = new VideoList(professor, this);
        mainPanel.add(videoList, BorderLayout.CENTER);

        detailPanel = new DetailPanel(professor, this);
        mainPanel.add(detailPanel, BorderLayout.EAST);

    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    @Override
    public void listen(Event event) {
        if(event.getClass().equals(RepaintEvent.class)) {
            videoList.repaint();
        }
        else if(event.getClass().equals(NewVideoRequestEvent.class)){
            openNewVideoForm();
        }
        else if(event.getClass().equals(NewVideoEvent.class)){
            updateVideoList(((NewVideoEvent) event).getVideo());
        }
        else if(event.getClass().equals(CancelEvent.class)){
            openVideoList();
        }
    }

    public Professor getProfessor() {
        return professor;
    }

    public void openNewVideoForm(){
        mainPanel.remove(videoList);
        mainPanel.repaint();

        addVideoForm = new AddVideoForm(this);
        mainPanel.add(addVideoForm, BorderLayout.CENTER);
        mainPanel.revalidate();
    }

    public void openVideoList(){
        mainPanel.remove(addVideoForm);
        mainPanel.repaint();

        mainPanel.add(videoList, BorderLayout.CENTER);
        mainPanel.revalidate();
    }

    public void updateVideoList(Video video){
        videoList.getVideoList().add(video);
        mainPanel.remove(addVideoForm);
        mainPanel.repaint();

        mainPanel.add(videoList, BorderLayout.CENTER);
        mainPanel.revalidate();
    }
}
