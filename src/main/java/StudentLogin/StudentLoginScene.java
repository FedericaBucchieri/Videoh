package StudentLogin;

import GeneralLogin.MainLoginPanel;
import sceneManager.SceneManager;

import javax.swing.*;
import java.awt.*;

public class StudentLoginScene extends JPanel {
    private StudentLoginPanel studentLoginPanel; //costituirà il main panel

    public StudentLoginScene (SceneManager sceneManager) {
        setupUI();
        studentLoginPanel = new StudentLoginPanel(sceneManager);
        add(studentLoginPanel, BorderLayout.CENTER);

    }

    private void setupUI() {

//        setPreferredSize(new Dimension(600, 800)); //to substitute getting size from model
//        setMinimumSize(getPreferredSize());
        setLayout(new BorderLayout());
        setVisible(true);

    }
}
