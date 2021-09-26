package controllers;

import EventManagement.ErrorEvent;
import EventManagement.Event;
import EventManagement.Listener;
import model.LoginFormModel;
import sceneManager.SceneManager;
import sceneManager.Utils;
import view.LoginFormUI;

import javax.swing.*;
import java.awt.*;

public class LoginForm extends JPanel implements Listener {
    private LoginFormModel model;
    private LoginFormUI ui;

    public LoginForm(SceneManager sceneManager) {
        this.model = new LoginFormModel();
        this.model.addlisteners(sceneManager);
        this.model.addlisteners(this);

        this.ui = new LoginFormUI();
        this.ui.installUI(this);
    }

    public LoginFormModel getModel() {
        return model;
    }

    public void checkCredential(String usr, String pwd){
        model.checkCredential(usr, pwd);
    }

    @Override
    public void listen(Event event) {
        if(event.getClass().equals(ErrorEvent.class)) {
            this.ui.displayError(((ErrorEvent) event).getMessage());
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        add(this.ui.getMainPanel());
    }


    public Dimension getMinimumSize() { return getPreferredSize(); }
    public Dimension getPreferredSize() {
        return new Dimension(Utils.JFRAME_WIDTH, Utils.JFRAME_HEIGHT);
    }
    public Dimension getMaximumSize() { return getPreferredSize(); }
}
