package view;

import controller.Controller;
import entities.Professor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    public void displayVideoManagementScene(){
        VideoManagementScene videoManagamentScene = new VideoManagementScene(this);
        currentScene.getMainPanel().setVisible(false);
        currentScene = videoManagamentScene;
        add(currentScene.getMainPanel());
        currentScene.getMainPanel().setVisible(true);
    }


    public void handleProfessorLogin(String usr, String pwd){
        controller.handleProfessorLogin(usr, pwd);
    }

    public void displayError(String error){
        currentScene.displayError(error);
    }



}
