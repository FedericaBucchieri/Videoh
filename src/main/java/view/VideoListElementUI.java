package view;

import controllers.VideoListElement;
import entities.Video;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VideoListElementUI {
    private JPanel mainPanel;
    private JLabel videoTitle;
    private JLabel videoPreview;
    private JTextArea videoDescription;
    private JLabel videoCode;
    private JButton seeStatisticsButton;
    private JButton modifyButton;
    private JButton deleteButton;
    private VideoListElement controller;

    public void installUI(VideoListElement controller) {
        this.controller = controller;
        setVideoInformation();

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.deleteVideo();
            }
        });

        modifyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.handleModifyRequest();
            }
        });

        seeStatisticsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.handleStatisticRequest();
            }
        });
    }

    private void setVideoInformation(){
        Video video = controller.getVideo();
        videoTitle.setText(video.getTitle());
        videoDescription.setText(video.getDescription());
        videoCode.setText(String.valueOf(video.getCode()));

        ImageIcon previewImage = new ImageIcon(video.getPreviewImage());
        JLabel previewLabel = new JLabel(previewImage);
        videoPreview.add(previewLabel);
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
