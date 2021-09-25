package scenes;

import controllers.DetailPanel;
import controllers.VideoList;
import entities.Professor;
import sceneManager.SceneManager;
import sceneManager.Utils;

import javax.swing.*;
import java.awt.*;

public class ProfessorHomePage{
    private VideoList videoList;
    private DetailPanel detailPanel;
    private Professor professor;
    private JPanel mainPanel;


    public ProfessorHomePage(SceneManager sceneManager, Professor professor) {
        this.professor = professor;
        this.mainPanel = new JPanel();
        videoList = new VideoList(professor);
        mainPanel.add(videoList, BorderLayout.CENTER);

        detailPanel = new DetailPanel(professor);
        mainPanel.add(detailPanel, BorderLayout.EAST);
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public Dimension getMinimumSize() { return getPreferredSize(); }
    public Dimension getPreferredSize() {
        return new Dimension(Utils.JFRAME_WIDTH, Utils.JFRAME_HEIGHT);
    }
    public Dimension getMaximumSize() { return getPreferredSize(); }
}
