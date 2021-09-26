package StudentLogin;

import EventManagement.Listener;
import GeneralLogin.MainLoginPanelModel;
import sceneManager.SceneManager;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class StudentLoginPanel extends JPanel { //controler
    private StudentLoginPanelModel model;
    private StudentLoginPanelView view;
//    private List<Listener> listeners = new ArrayList<>();

    public StudentLoginPanel (SceneManager sceneManager){
        model = new StudentLoginPanelModel(this);
        view = new StudentLoginPanelView(this);

        setPreferredSize(new Dimension(600, 800));
        setMinimumSize(getPreferredSize());
    }

    public StudentLoginPanelModel getModel() {
        return model;
    }

    @Override
    public void paintComponent(Graphics pen) {
        //aggiungi al pannello che chiama il main panel
        repaint();
        add(view.getMainPanel(), BorderLayout.CENTER);
    }
}

