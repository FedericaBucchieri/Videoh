package controllers;

import EventManagement.Event;
import EventManagement.Listener;
import entities.Professor;
import model.DetailPanelModel;
import sceneManager.Utils;
import view.DetailPanelUI;

import javax.swing.*;
import java.awt.*;

public class DetailPanel extends JPanel implements Listener  {
    private DetailPanelModel model;
    private DetailPanelUI ui;


    public DetailPanel(Professor professor) {
        this.model = new DetailPanelModel(professor);
        this.ui = new DetailPanelUI();
        this.ui.installUI(this);
    }

    public String getProfessorUsername(){
       return model.getProfessor().getUsername();
    }

    @Override
    public void listen(Event event) {

    }

    @Override
    protected void paintComponent(Graphics g) {
        add(this.ui.getMainPanel());
    }


    public Dimension getMinimumSize() { return getPreferredSize(); }
    public Dimension getPreferredSize() {
        return new Dimension(250, Utils.JFRAME_HEIGHT);
    }
    public Dimension getMaximumSize() { return getPreferredSize(); }
}
