package sceneManager;

import EventManagement.Event;
import EventManagement.Listener;
import EventManagement.LoginEvent;
import entities.Professor;
import exceptions.CredentialsException;
import exceptions.UserNotRegisteredException;
import scenes.ProfessorHomePage;
import services.ProfessorService;
import javax.swing.*;
import java.awt.*;



public class SceneManager extends JFrame implements Listener {
    private JPanel currentScene;

    public SceneManager() {
        super("VIDEOH");
        setPreferredSize(new Dimension(Utils.JFRAME_WIDTH, Utils.JFRAME_HEIGHT));
        setLocation(300,100);
        initializeFirstScene();
        pack();
    }

    private void initializeFirstScene(){

        ProfessorService service = new ProfessorService();
        Professor professor = null;
        try {
            professor = service.checkCredentials("prof1", "pass1");
        } catch (CredentialsException e) {
            e.printStackTrace();
        } catch (UserNotRegisteredException e) {
            e.printStackTrace();
        }

        ProfessorHomePage professorHomePage = new ProfessorHomePage(this, professor);
        currentScene = professorHomePage.getMainPanel();
        add(professorHomePage.getMainPanel());


        /*

        ProfessorLoginScene professorLoginScene = new ProfessorLoginScene(this);
        professorLoginScene.setVisible(true);
        currentScene = professorLoginScene;
        add(professorLoginScene);


         */

    }

    @Override
    public void listen(Event event) {
        if(event.getClass().equals(LoginEvent.class)) {
            goToVideoManagementScene(((LoginEvent) event).getProfessor());
        }
    }

    private void goToVideoManagementScene(Professor professor){
        remove(currentScene);
        invalidate();

        ProfessorHomePage professorHomePage = new ProfessorHomePage(this, professor);
        currentScene = professorHomePage.getMainPanel();
        add(professorHomePage.getMainPanel());
        repaint();
    }

}
