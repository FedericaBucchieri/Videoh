package StudentHomePage;

import uk.co.caprica.vlcj.discovery.NativeDiscovery;

import javax.swing.*;
import java.awt.*;

public class StudentHomePageUI {
    private StudentHomePage controller;
    private JPanel mainPanel;
    private VideoBox videoBox;
    private JPanel settingsPanel;

    public StudentHomePageUI(StudentHomePage controller){
        this.controller = controller;

        setupMainPanel();
        setupVideoBox();
        setupSettingsPanel();

    }

    private void setupSettingsPanel() {
        settingsPanel = new JPanel();
        settingsPanel.setBackground(Color.GRAY); //to remove
        mainPanel.add(settingsPanel, BorderLayout.EAST);

    }

    private void setupMainPanel() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(Color.blue); //to remove
    }

    private void setupVideoBox() {
        new NativeDiscovery().discover();
        videoBox = new VideoBox(controller.getModel().getMedia());
        mainPanel.add(videoBox.getUI().getMainPanel(), BorderLayout.CENTER);

    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

}
