package StudentHomePage;

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

    public StudentHomePage (SceneManager sceneManager, Media media) {
        this.listeners.add(sceneManager);
        model = new StudentHomePageModel(this, media);
        UI = new StudentHomePageUI(this);

    }

    public StudentHomePageModel getModel() {
        return model;
    }
    public StudentHomePageUI getView() {return UI;}


    public JPanel getMainPanel(){
        return UI.getMainPanel();
    }
}
