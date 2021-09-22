package controller;
import entities.Video;
import model.Model;
import view.View;

import java.io.File;
import java.util.List;

public class Controller {
    private Model model;
    private View view;

    public Controller() {
        this.model = new Model();
        this.view = new View(this);
        this.view.setVisible(true);
    }

    public Model getModel() {
        return model;
    }

    public void closeConnections(){
        model.closeConnections();
    }


    public void validateStudentLogIn(String nickname){
        model.studentLogin(nickname);
    }

    public void validateProfessorLogin(String usr, String psw){
        String error = model.professorLogin(usr, psw);

        if(error == null){
            List<Video> videoList = model.getVideoListByProfessor();
            view.displayVideoManagementScene(usr, videoList);
        }
        else{
            view.displayError(error);
        }
    }

    public void addNewVideo(String title, String description, String previewImage, File videoFile){
        model.createNewVideo(title, description, previewImage, videoFile);
    }

}
