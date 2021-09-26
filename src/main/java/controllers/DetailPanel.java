package controllers;

import EventManagement.Event;
import EventManagement.Listener;
import EventManagement.NewVideoRequestEvent;
import EventManagement.RepaintEvent;
import entities.Professor;
import model.DetailPanelModel;
import sceneManager.Utils;
import scenes.ProfessorHomePage;
import view.DetailUI;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class DetailPanel extends JComponent {
    private DetailPanelModel model;
    private DetailUI ui;
    private List<Listener> listeners = new ArrayList<>();


    public DetailPanel(Professor professor, ProfessorHomePage professorHomePage) {
        this.listeners.add(professorHomePage);

        this.model = new DetailPanelModel(professor);
        this.ui = new DetailUI();
        this.ui.installUI(this);
        this.setLayout(new BorderLayout());
    }

    public String getProfessorUsername(){
       return model.getProfessor().getUsername();
    }


    public void handleNewVideoRequest(){
        dispatchNewVideoRequestEvent();
    }

    private void dispatchNewVideoRequestEvent(){
        for (Listener listener : listeners)
            listener.listen(new NewVideoRequestEvent());
    }

    @Override
    protected void paintComponent(Graphics g) {
        add(this.ui.getMainPanel());
    }


    public Dimension getMinimumSize() { return getPreferredSize(); }
    public Dimension getPreferredSize() {
        return new Dimension(Utils.DETAILPANEL_WIDTH, Utils.DETAILPANEL_HEIGHT);
    }
    public Dimension getMaximumSize() { return getPreferredSize(); }
}
