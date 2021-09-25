package view;

import controllers.LoginForm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class LoginFormUI {
    private JPanel mainPanel;
    private JTextField usernameField;
    private JButton loginButton;
    private JPasswordField passwordField;
    private JLabel errorLabel;
    private LoginForm controller;

    public LoginFormUI(){
    }

    public void installUI(LoginForm controller){
        this.controller = controller;

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(usernameField.getText() != null && passwordField.getPassword() != null)
                    controller.checkCredential(usernameField.getText(), passwordToString(passwordField.getPassword()));
            }
        });


        usernameField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if(usernameField.getText() != null && passwordField.getPassword() != null)
                        controller.checkCredential(usernameField.getText(), passwordToString(passwordField.getPassword()));
                }
            }
        });

        passwordField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                    if (usernameField.getText() != null && passwordField.getPassword() != null)
                        controller.checkCredential(usernameField.getText(), passwordToString(passwordField.getPassword()));
                }
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

    public void displayError(String error){
        errorLabel.setText(error);
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
