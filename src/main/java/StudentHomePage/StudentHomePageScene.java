package StudentHomePage;

import StudentLogin.StudentLoginPanel;
import sceneManager.Scene;
import sceneManager.SceneManager;
import uk.co.caprica.vlcj.player.media.Media;

import javax.swing.*;

public class StudentHomePageScene implements Scene {
    StudentHomePage studentHomePage;

    public StudentHomePageScene(SceneManager sceneManager, String path, String username) {
        studentHomePage = new StudentHomePage(sceneManager, path, username);
        this.username = username;
    }
    public String getUsername(){return this.username;}
    public JPanel getMainPanel() {return studentHomePage.getMainPanel();}

}
