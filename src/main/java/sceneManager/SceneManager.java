package sceneManager;

import EventManagement.*;
import EventManagement.Event;
import GeneralLogin.GeneralLoginScene;
import GeneralLogin.MainLoginPanel;
import StudentLogin.StudentLoginScene;
import entities.Professor;
import exceptions.CredentialsException;
import exceptions.UserNotRegisteredException;
import scenes.ProfessorHomePage;
import scenes.ProfessorLoginScene;

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
                /*
        ProfessorService service = new ProfessorService();
        Professor professor = null;
        try {
            professor = service.checkCredentials("prof1", "pass1");
        } catch (CredentialsException e) {
            e.printStackTrace();
        } catch (UserNotRegisteredException e) {
            e.printStackTrace();
        }

        HomePageTest test = new HomePageTest(this, professor);
        add(test.getMainPanel());
        ProfessorHomePage professorHomePage = new ProfessorHomePage(this, professor);
        professorHomePage.setVisible(true);
        currentScene = professorHomePage;
        add(professorHomePage, BorderLayout.CENTER);

         */


//        ProfessorLoginScene professorLoginScene = new ProfessorLoginScene(this);
//        professorLoginScene.setVisible(true);
//        currentScene = professorLoginScene;
//        add(professorLoginScene);

        GeneralLoginScene generalLoginScene = new GeneralLoginScene(this);
        generalLoginScene.setVisible(true);
        currentScene = generalLoginScene;
        add(generalLoginScene);

//        StudentLoginScene studentLoginScene = new StudentLoginScene(this);
//        studentLoginScene.setVisible(true);
//        currentScene = studentLoginScene;
//        add(studentLoginScene);




    }

    @Override
    public void listen(Event event) {
        if(event.getClass().equals(LoginEvent.class)) {
            goToVideoManagementScene(((LoginEvent) event).getProfessor());
        }

        if(event.getClass().equals(LoginStudEvent.class)){
            goToStudLoginPage();

        }

        if (event.getClass().equals(LoginProfEvent.class)){
            goToProfLoginPage();

        }
    }

    private void goToStudLoginPage() {
        remove(currentScene);
        invalidate();
        StudentLoginScene studentLoginScene = new StudentLoginScene(this);
        studentLoginScene.setVisible(true);
        currentScene = studentLoginScene;
        add(studentLoginScene);
    }

    private void goToProfLoginPage() {

        remove(currentScene);
        invalidate();
        ProfessorLoginScene professorLoginScene = new ProfessorLoginScene(this);
        professorLoginScene.setVisible(true);
        currentScene = professorLoginScene;
        add(professorLoginScene);
        super.repaint();
        repaint();



    }

    private void goToVideoManagementScene(Professor professor){
        remove(currentScene);
        invalidate();

        ProfessorHomePage professorHomePage = new ProfessorHomePage(this, professor);
        currentScene = professorHomePage.getMainPanel();
        add(professorHomePage.getMainPanel());
        revalidate();
        this.repaint();
    }

}
