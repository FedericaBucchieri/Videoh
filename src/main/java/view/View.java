package view;

import controller.Controller;
import entities.Video;

import java.io.File;
import java.util.List;
import javax.swing.*;

public class View extends JFrame {
    private Scene currentScene;
    private final Controller controller;

    public View(Controller controller){
        super("VideoH");
        this.controller = controller;
        displayProfessorLoginScene();
        setupUI();
    }

    private void setupUI(){

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                controller.closeConnections();
                System.exit(0);
            }
        });

        pack();
    }

    public void displayProfessorLoginScene(){
        currentScene = new ProfessorLoginScene(this);
        add(currentScene.getMainPanel());
        currentScene.getMainPanel().setVisible(true);
    }

    public void displayVideoManagementScene(String username, List<Video> videoList){
        VideoManagementScene videoManagamentScene = new VideoManagementScene(this, username, videoList);
        currentScene.getMainPanel().setVisible(false);
        currentScene = videoManagamentScene;
        add(currentScene.getMainPanel());
        currentScene.getMainPanel().setVisible(true);
    }


    public void handleProfessorLogin(String usr, String pwd){
        controller.validateProfessorLogin(usr, pwd);
    }

    public void displayError(String error){
        currentScene.displayError(error);
    }

    public void handleAddNewVideo(String title, String description, String previewImage, File videoFile){
        controller.addNewVideo(title, description, previewImage, videoFile);
    }


}
