package view;

import controllers.AddVideoForm;
import sceneManager.Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class AddVideoFormUI {
    private JPanel mainPanel;
    private JTextField previewImageField;
    private JTextField descriptionField;
    private JTextField titleField;
    private JButton uploadVideoButton;
    private JLabel uploadVideoName;
    private JButton addVideoButton;
    private JButton backButton;
    private JLabel errorLabel;
    private File newVideoFile;
    private AddVideoForm controller;

    public AddVideoFormUI(AddVideoForm controller) {
        this.controller = controller;
        setupUI();

        uploadVideoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
                int result = fileChooser.showOpenDialog(mainPanel);
                if (result == JFileChooser.APPROVE_OPTION) {
                    newVideoFile = fileChooser.getSelectedFile();
                    uploadVideoName.setText("File Selected: " + newVideoFile.getName());
                }
            }
        });

        addVideoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.handleNewVideoRequest(titleField.getText(), descriptionField.getText(), previewImageField.getText(), newVideoFile);
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.handleCancelRequest();
            }
        });
    }

    private void setupUI(){
        this.mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));

        JLabel title = new JLabel("Add new Video");
        title.setFont(new Font(Font.SANS_SERIF,  Font.BOLD, Utils.TITLE_WIDTH));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(title);

        mainPanel.add(Box.createVerticalStrut(Utils.STANDARD_BORDER));

        setupForm(mainPanel);
        setupVideoUpload(mainPanel);

        mainPanel.add(Box.createVerticalStrut(Utils.STANDARD_BORDER));

        addVideoButton = new JButton("Add Video");
        addVideoButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(addVideoButton);

        backButton = new JButton("Cancel");
        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(backButton);
    }

    private void setupForm(JPanel mainPanel){

        JLabel title = new JLabel("Title");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleField = new JTextField();
        titleField.setMaximumSize(new Dimension(Utils.STANDARD_TEXT_FIELD_WIDTH, Utils.STANDARD_TEXT_FIELD_HEIGHT));
        titleField.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(title);
        mainPanel.add(titleField);

        JLabel description = new JLabel("Description");
        description.setAlignmentX(Component.CENTER_ALIGNMENT);
        descriptionField = new JTextField();
        descriptionField.setMaximumSize(new Dimension(Utils.STANDARD_TEXT_FIELD_WIDTH, Utils.STANDARD_TEXT_FIELD_HEIGHT));
        descriptionField.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(description);
        mainPanel.add(descriptionField);

        JLabel preview = new JLabel("Preview Image");
        preview.setAlignmentX(Component.CENTER_ALIGNMENT);
        previewImageField = new JTextField();
        previewImageField.setMaximumSize(new Dimension(Utils.STANDARD_TEXT_FIELD_WIDTH, Utils.STANDARD_TEXT_FIELD_HEIGHT));
        previewImageField.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(preview);
        mainPanel.add(previewImageField);
    }

    private void setupVideoUpload(JPanel mainPanel){
        uploadVideoButton = new JButton("Browse Video");
        uploadVideoButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(uploadVideoButton);

        uploadVideoName = new JLabel();
        uploadVideoName.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(uploadVideoName);
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
