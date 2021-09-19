import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame {
    private JPanel currentScene;
    private Controller controller;

    public View(Controller controller){
        super("VideoH");
        this.controller = controller;
        displayWelcomeScene();
        setupUI();
    }

    private void setupUI(){
        setPreferredSize(new Dimension(600,400));
        setMinimumSize(new Dimension(600,400));
        pack();
    }

    private void displayWelcomeScene(){
        JPanel welcomePanel = new JPanel();
        currentScene = welcomePanel;
        add(currentScene);

        JButton studentButton = new JButton("Login as a Student");
        studentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentScene.setVisible(false);
                displayStudentLoginScene();
            }
        });
        welcomePanel.add(studentButton);
        JButton professorButton = new JButton("Login as a Professor");
        welcomePanel.add(professorButton);
    }

    private void displayStudentLoginScene(){
        JPanel studentLoginPanel = new JPanel();
        currentScene = studentLoginPanel;
        currentScene.setVisible(true);
        add(currentScene);

        JTextField nickNameField = new JTextField("insert your nickname");
        studentLoginPanel.add(nickNameField);
        JButton loginButton = new JButton("Login");
        studentLoginPanel.add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.handleStudentLogIn(nickNameField.getText());
            }
        });

    }





}
