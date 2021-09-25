package scenes;

import controllers.LoginForm;
import sceneManager.SceneManager;
import sceneManager.Utils;

import javax.swing.*;
import java.awt.*;

public class ProfessorLoginScene extends JPanel{
    private LoginForm loginForm;

    public ProfessorLoginScene(SceneManager sceneManager) {
        loginForm = new LoginForm(sceneManager);
        add(loginForm, BorderLayout.CENTER);
    }

    public Dimension getMinimumSize() { return getPreferredSize(); }
    public Dimension getPreferredSize() {
        return new Dimension(Utils.JFRAME_WIDTH, Utils.JFRAME_HEIGHT);
    }
    public Dimension getMaximumSize() { return getPreferredSize(); }

}
