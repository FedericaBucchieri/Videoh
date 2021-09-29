package StudentHomePage;

import StudentLogin.StudentLoginPanel;
import sceneManager.Scene;
import sceneManager.SceneManager;
import uk.co.caprica.vlcj.player.media.Media;

import javax.swing.*;

public class StudentHomePageScene implements Scene {
    private StudentHomePage studentHomePage;
    private String username;

    public StudentHomePageScene(SceneManager sceneManager, Media media, String username) {
        studentHomePage = new StudentHomePage(sceneManager, media, username);
        this.username = username;
    }

    public String getUsername(){return this.username;}
    public JPanel getMainPanel() {return studentHomePage.getMainPanel();}

}
