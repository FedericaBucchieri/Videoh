package StudentLogin;

import javax.swing.*;
import java.awt.*;

public class StudentLoginPanelView {
    private StudentLoginPanel controller;

    private JPanel mainPanel;
    private JLabel studLogo;
    private JTextField nameTextField;
    private JButton studLoginButt;

    public StudentLoginPanelView(StudentLoginPanel controller){
        this.controller = controller;


        setupMainPanel();
        setupStudLogo();
        setupNameTextField();
        setupLoginButt();

    }

    private void setupMainPanel() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(Color.YELLOW);
        mainPanel.setAlignmentX(Component.CENTER_ALIGNMENT);

    }

    private void setupStudLogo() {
        studLogo = new JLabel();
        studLogo.setIcon(new ImageIcon(new ImageIcon("resources/stud.png").getImage().getScaledInstance(170, 170, Image.SCALE_SMOOTH)));
        studLogo.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 40)));
        mainPanel.add(studLogo);

    }

    private void setupNameTextField(){
        nameTextField = new JTextField("insert an username");
        nameTextField.setAlignmentX(Component.CENTER_ALIGNMENT);
        nameTextField.setPreferredSize(new Dimension(180, 40));
        nameTextField.setMaximumSize(nameTextField.getPreferredSize());
        nameTextField.setHorizontalAlignment(SwingConstants.CENTER);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 40)));
        mainPanel.add(nameTextField);
    }

    private void setupLoginButt() {
        studLoginButt = new JButton("Login");
        studLoginButt.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 40)));
        mainPanel.add(studLoginButt);
    }

    public JPanel getMainPanel() {return mainPanel;}


}
