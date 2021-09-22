package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class ProfessorLoginScene implements Scene{
    private JPanel mainPanel;
    private JTextField textField1;
    private JButton loginButton;
    private JPasswordField passwordField1;
    private JLabel errorLabel;
    private View view;

    public ProfessorLoginScene(View view) {
        this.view = view;
        setupUI();
    }

    private void setupUI(){
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.handleProfessorLogin(textField1.getText(), passwordToString(passwordField1.getPassword()));
            }
        });
    }

    private String passwordToString(char[] password){
        String newPass = "";
        for (char c: password) {
            newPass += c;
        }
        return newPass;
    }

    @Override
    public JPanel getMainPanel() {
        return mainPanel;
    }

    @Override
    public void displayError(String error) {
        this.errorLabel.setText(error);
    }
}
