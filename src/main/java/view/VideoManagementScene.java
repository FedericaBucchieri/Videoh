package view;

import entities.Video;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class VideoManagementScene implements Scene{
    private JPanel mainPanel;
    private JLabel professorNameLabel;
    private JLabel iconLabel;
    private JPanel rightPanel;
    private JButton addVideoButton;
    private JButton manageProfileButton;
    private JPanel centerPanel;
    private JScrollPane scrollPane;
    private JPanel videoListPanel;
    private View view;
    private List<Video> videoList;
    private static final int PREVIEW_WIDTH = 100;
    private static final int PREVIEW_HEIGHT = 70;
    private static final int STANDARD_BORDER = 10;
    // @TODO: resolve this problem of the path
    private static final String ROUTE_PATH = "src/main/resources/";

    public VideoManagementScene(View view, String username, List<Video> videoList) {
        this.view = view;
        this.professorNameLabel.setText(username);
        this.videoList = videoList;

        this.videoListPanel.setLayout(new BoxLayout(videoListPanel, BoxLayout.PAGE_AXIS));
        createVideoList();
        addVideoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddVideoDialog addVideoDialog = new AddVideoDialog(view);
                addVideoDialog.openAddVideoDialogue(addVideoDialog);
            }
        });
    }



    @Override
    public JPanel getMainPanel() {
        return mainPanel;
    }

    @Override
    public void displayError(String error) {

    }

    private void createVideoList(){

        for (Video video: videoList) {
            System.out.println(video.getTitle());

            JPanel videoPanel = new JPanel();
            videoPanel.setLayout(new BoxLayout(videoPanel, BoxLayout.X_AXIS));
            videoPanel.setBorder(new EmptyBorder(STANDARD_BORDER, 0,STANDARD_BORDER,0));

            // left side of each video description
            JPanel videoDetailsPanel = new JPanel();
            videoDetailsPanel.setLayout(new BoxLayout(videoDetailsPanel, BoxLayout.PAGE_AXIS));
            videoPanel.add(videoDetailsPanel);

            ImageIcon videoIcon = new ImageIcon(ROUTE_PATH + video.getPreviewImage());
            Image videoIconScaled = videoIcon.getImage().getScaledInstance(PREVIEW_WIDTH, PREVIEW_HEIGHT, java.awt.Image.SCALE_SMOOTH);
            videoIcon.setImage(videoIconScaled);
            JLabel videoIconLabel = new JLabel(videoIcon);
            videoIconLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            videoDetailsPanel.add(videoIconLabel);

            JLabel videoTitle = new JLabel(video.getTitle());
            videoTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
            videoDetailsPanel.add(videoTitle);

            JLabel videoDescription = new JLabel(video.getDescription());
            videoDescription.setAlignmentX(Component.CENTER_ALIGNMENT);
            videoDetailsPanel.add(videoDescription);

            JLabel videoDate = new JLabel(video.getDate().toString());
            videoDate.setAlignmentX(Component.CENTER_ALIGNMENT);
            videoDetailsPanel.add(videoDate);


            // right side of each video description
            JPanel videoCommandPanel = new JPanel();
            videoCommandPanel.setLayout(new BoxLayout(videoCommandPanel, BoxLayout.PAGE_AXIS));
            videoPanel.add(videoCommandPanel);

            JButton statisticsButton = new JButton("See Statistics");
            videoCommandPanel.add(statisticsButton);

            JButton manageButton = new JButton("Manage Options");
            videoCommandPanel.add(manageButton);

            JLabel videoCode = new JLabel("Video Code:" + video.getCode());
            videoCommandPanel.add(videoCode);

            videoListPanel.add(videoPanel);
        }
    }
}
