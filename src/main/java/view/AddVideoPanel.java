package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class AddVideoPanel {

    private JPanel mainPanel;
    private JTextField previewImageField;
    private JTextField descriptionField;
    private JButton uploadVideoButton;
    private JLabel uploadVideoName;
    private JButton addVideoButton;
    private JTextField titleField;
    private JLabel errorLabel;

    private File newVideoFile;

    public AddVideoPanel() {

        setupUploadButton();
        //setupAddVideoButton();

        mainPanel.setBorder(new EmptyBorder(20,20,20,20));
    }

    private void setupUploadButton(){
        uploadVideoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
                int result = fileChooser.showOpenDialog(mainPanel);
                if (result == JFileChooser.APPROVE_OPTION) {
                    newVideoFile = fileChooser.getSelectedFile();
                    uploadVideoName.setText(newVideoFile.getName());
                }
            }
        });
    }

    /*
    private void setupAddVideoButton(){
        addVideoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.handleAddNewVideo(titleField.getText(), descriptionField.getText(), previewImageField.getText(), newVideoFile);
            }
        });


    }

    @Override
    public void displayError(String error) {
        errorLabel.setText(error);
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }


     */


}
