package StudentHomePage;

import StudentLogin.StudentLoginPanel;
import sceneManager.Scene;
import sceneManager.SceneManager;
import uk.co.caprica.vlcj.player.media.Media;

import javax.swing.*;

public class StudentHomePageScene implements Scene {
    StudentHomePage studentHomePage;

    public StudentHomePageScene(SceneManager sceneManager, Media media) {
        studentHomePage = new StudentHomePage(sceneManager, media);
    }

    public JPanel getMainPanel() {return studentHomePage.getMainPanel();}

}
