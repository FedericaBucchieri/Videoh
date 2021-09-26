package view;

import controllers.DetailPanel;
import sceneManager.Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DetailUI {
    private JPanel mainPanel;
    private JLabel profName;
    private JButton addNewVideoButton;
    private JButton updateProfileButton;
    private DetailPanel controller;

    public DetailUI() {
        this.mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
        mainPanel.setBackground(Color.decode("#4472CA"));


        JLabel welcome = new JLabel("Welcome");
        welcome.setAlignmentX(Component.CENTER_ALIGNMENT);
        welcome.setForeground(Color.white);
        welcome.setFont(new Font(Font.SANS_SERIF,  Font.BOLD, Utils.SUBTITLE_WIDTH));
        mainPanel.add(welcome);

        profName = new JLabel();
        profName.setAlignmentX(Component.CENTER_ALIGNMENT);
        profName.setForeground(Color.white);
        profName.setFont(new Font(Font.SANS_SERIF,  Font.BOLD, Utils.SUBTITLE_WIDTH));
        mainPanel.add(profName);

        mainPanel.add(Box.createVerticalStrut(200));

        addNewVideoButton = new JButton("Add New Video");
        addNewVideoButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(addNewVideoButton);

        updateProfileButton = new JButton("Update profile");
        updateProfileButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(updateProfileButton);
    }

    public void installUI(DetailPanel controller){
        this.controller = controller;
        profName.setText(controller.getProfessorUsername());

        addNewVideoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.handleNewVideoRequest();
            }
        });
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
