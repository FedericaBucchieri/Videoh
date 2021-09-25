package view;

import controllers.VideoList;
import controllers.VideoListElement;
import entities.Video;
import sceneManager.Utils;

import javax.swing.*;
import java.util.List;

public class VideoListUI {
    private JPanel mainPanel;
    private JPanel listPanel;
    private JScrollPane scrollPane;
    private VideoList controller;
    private List<Video> videoList;

    public void installUI(VideoList controller) {
        this.controller = controller;
        this.videoList = controller.getVideoList();
        paint();
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void displayError(String error){

    }


    public void paint(){
        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.PAGE_AXIS));

        if(videoList.isEmpty())
            displayError(Utils.ERROR_EMPTY_LIST);
        else {
            for (Video video: videoList) {
                VideoListElement videoListElement = new VideoListElement(video, controller);
                listPanel.add(videoListElement);
            }
        }
    }
}
