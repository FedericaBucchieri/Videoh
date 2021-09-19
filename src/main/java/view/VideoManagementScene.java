package view;

import javax.swing.*;

public class VideoManagementScene implements Scene{
    private JPanel mainPanel;
    private View view;

    public VideoManagementScene(View view) {
        this.view = view;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    @Override
    public void displayError(String error) {

    }
}
