package StudentHomePage;

import EventManagement.Listener;
import sceneManager.SceneManager;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class StudentHomePage extends JComponent { //controler
    private StudentHomePageModel model;
    private StudentHomePageUI UI;
    private List<Listener> listeners = new ArrayList<>();

    public StudentHomePage (SceneManager sceneManager, String path) {
        this.listeners.add(sceneManager);
        model = new StudentHomePageModel(this, path);
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
