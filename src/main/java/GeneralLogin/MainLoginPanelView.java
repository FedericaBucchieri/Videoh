package GeneralLogin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainLoginPanelView { //view
    private MainLoginPanel controller;

    private JPanel mainPanel;
    private JPanel studProfPanel;
    private JButton helpButton;
    private JButton studLoginButton;
    private JButton profLoginButton;




    public MainLoginPanelView(MainLoginPanel controller){
        this.controller = controller;
        System.out.println("Main login panel View constructor");
        setupMainPanel();


    }

    private void setupMainPanel() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        setupWelcomeLabel();
        setupStudProfPanel();
        setupProblemButton();//any problem
        //add(mainPanel, BorderLayout.CENTER);
        //pack();
    }

    private void setupProblemButton() {
        JPanel problemPanel = new JPanel();
        problemPanel.setLayout(new BoxLayout(problemPanel, BoxLayout.Y_AXIS));
        helpButton = new JButton("Need an help?");
        helpButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        //setupHelpButton
        problemPanel.add(helpButton);
        problemPanel.add(Box.createRigidArea(new Dimension(0, 80)));

        mainPanel.add(Box.createRigidArea(new Dimension(0, 100)));
        mainPanel.add(problemPanel);

        //add(problemPanel, BorderLayout.SOUTH);

    }

    private void setupWelcomeLabel() {
        mainPanel.add(Box.createRigidArea(new Dimension(0, 80)));
        JLabel welcomeLabel = new JLabel("Welcome");
        welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        //to add welcome icon
        mainPanel.add(welcomeLabel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 80)));

    }

    private void setupStudProfPanel() {//questo contiene sia i loghi che i due bottoni
        studProfPanel = new JPanel();
        studProfPanel.setLayout(new BoxLayout(studProfPanel, BoxLayout.Y_AXIS));
        studProfPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

        studProfPanel.add(setupLogos());//setupLogos contiene solo contiene solo le due immagini
        studProfPanel.add(setupLoginButtons());
        mainPanel.add(studProfPanel);

    }

    private JPanel setupLoginButtons() {
        JPanel loginButtonsPanel = new JPanel();
        loginButtonsPanel.setLayout(new BoxLayout(loginButtonsPanel, BoxLayout.X_AXIS));
        studLoginButton = new JButton("student");
        studLoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.dispatchStudentLoginPressed();
            }
        });

        loginButtonsPanel.add(studLoginButton);

        profLoginButton = new JButton("professor");
        profLoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.dispatchProfLoginPressed();

            }
        });

        loginButtonsPanel.add(profLoginButton);

        return loginButtonsPanel;

    }

    private JPanel setupLogos() {
        JPanel logos = new JPanel();
        logos.setLayout(new BoxLayout(logos, BoxLayout.X_AXIS));
        JLabel studLabel = new JLabel();
        studLabel.setIcon(controller.getModel().getStudIcon());
        logos.add(studLabel);

        JLabel profLabel = new JLabel();
        profLabel.setIcon(controller.getModel().getProfIcon());
        logos.add(profLabel);
        return  logos;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }


}
