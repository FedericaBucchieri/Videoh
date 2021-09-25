package view;

import controllers.DetailPanel;

import javax.swing.*;

public class DetailPanelUI {
    private JPanel mainPanel;
    private JLabel profName;
    private JButton addNewVideoButton;
    private JButton updateProfileButton;
    private DetailPanel controller;

    public void installUI(DetailPanel controller){
        this.controller = controller;
        profName.setText(controller.getProfessorUsername());
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
