package view;

import controllers.VideoListElement;
import entities.Video;
import sceneManager.Utils;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VideoElementUI {
    private JPanel mainPanel;
    private JLabel videoTitle;
    private JLabel videoPreview;
    private JTextArea videoDescription;
    private JLabel videoCode;
    private JButton seeStatisticsButton;
    private JButton modifyButton;
    private JButton deleteButton;
    private VideoListElement controller;

    public VideoElementUI() {
        mainPanel = new JPanel(new BorderLayout());

        videoTitle = new JLabel();
        videoTitle.setFont(new Font(Font.SANS_SERIF,  Font.BOLD, Utils.SUBTITLE_WIDTH));
        mainPanel.add(videoTitle, BorderLayout.NORTH);

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.X_AXIS));
        leftPanel.setBorder(new EmptyBorder(new Insets(Utils.STANDARD_BORDER, Utils.STANDARD_BORDER, Utils.STANDARD_BORDER, Utils.STANDARD_BORDER)));
        mainPanel.add(leftPanel, BorderLayout.CENTER);

        videoPreview = new JLabel();
        videoPreview.setBorder(new LineBorder(Color.black,2));
        leftPanel.add(videoPreview);

        videoDescription = new JTextArea();
        videoDescription.setEditable(false);
        videoDescription.setWrapStyleWord(true);
        videoDescription.setLineWrap(true);
        videoDescription.setPreferredSize(new Dimension(300,150));
        leftPanel.add(videoDescription);

        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.PAGE_AXIS));
        mainPanel.add(rightPanel, BorderLayout.EAST);

        seeStatisticsButton = new JButton("See statistics");
        rightPanel.add(seeStatisticsButton);

        modifyButton = new JButton("Modify");
        rightPanel.add(modifyButton);

        deleteButton = new JButton("Delete");
        rightPanel.add(deleteButton);

        rightPanel.add(Box.createVerticalStrut(Utils.STANDARD_BORDER));

        videoCode = new JLabel();
        rightPanel.add(videoCode);

    }

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
        videoCode.setText("Code:" + String.valueOf(video.getCode()));

        ImageIcon previewImage = new ImageIcon("resources/" + video.getPreviewImage());
        videoPreview = new JLabel(previewImage);
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

}
