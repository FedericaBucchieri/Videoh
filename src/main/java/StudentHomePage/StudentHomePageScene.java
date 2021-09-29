package StudentHomePage;

import StudentLogin.StudentLoginPanel;
import sceneManager.Scene;
import sceneManager.SceneManager;

import javax.swing.*;

public class StudentHomePageScene implements Scene {
    StudentHomePage studentHomePage;

    public StudentHomePageScene(SceneManager sceneManager, String path) {
        studentHomePage = new StudentHomePage(sceneManager, path);
    }

    public JPanel getMainPanel() {return studentHomePage.getMainPanel();}

}
