package StudentHomePage;

import EventManagement.BackEvent;
import EventManagement.Listener;
import sceneManager.SceneManager;
import uk.co.caprica.vlcj.player.media.Media;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class StudentHomePage extends JComponent { //controler
    private StudentHomePageModel model;
    private StudentHomePageUI UI;
    private List<Listener> listeners = new ArrayList<>();

    public StudentHomePage(SceneManager sceneManager, Media media, String username) {
        this.listeners.add(sceneManager);
        model = new StudentHomePageModel(this, media, username);
        UI = new StudentHomePageUI(this);
    }


    public StudentHomePageUI getView () {
            return UI;
    }

        public JPanel getMainPanel () {
            return UI.getMainPanel();
        }

        public void goToStudentInsertCode () {
            for (Listener listener : listeners)
                listener.listen(new BackEvent());
        }

    public StudentHomePageModel getModel() {
        return model;
    }
}
