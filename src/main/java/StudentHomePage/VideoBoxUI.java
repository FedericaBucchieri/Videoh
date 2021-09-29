package StudentHomePage;

import uk.co.caprica.vlcj.component.DirectMediaPlayerComponent;
import uk.co.caprica.vlcj.player.direct.*;
import uk.co.caprica.vlcj.player.direct.format.RV32BufferFormat;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class VideoBoxUI {
    private VideoBox controller;



    private JPanel mainPanel;
    private JPanel videoSurface;
    private BufferedImage image;
    private DirectMediaPlayerComponent mediaPlayerComponent;

    public VideoBoxUI(VideoBox controller) {
        this.controller = controller;
        videoSurface = new VideoSurfacePanel();
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(videoSurface, BorderLayout.CENTER);
        setupImage();
        mediaPlayerComponent.getMediaPlayer().playMedia(this.controller.getModel().getPath());

    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    private void setupImage() {
        image = GraphicsEnvironment
                .getLocalGraphicsEnvironment()
                .getDefaultScreenDevice()
                .getDefaultConfiguration()
                .createCompatibleImage(controller.getModel().getWidth() , controller.getModel().getHeight());
        BufferFormatCallback bufferFormatCallback = new BufferFormatCallback() {
            @Override
            public BufferFormat getBufferFormat(int sourceWidth, int sourceHeight) {
                return new RV32BufferFormat(controller.getModel().getWidth(), controller.getModel().getHeight());
            }
        };
        mediaPlayerComponent = new DirectMediaPlayerComponent(bufferFormatCallback) {
            @Override
            protected RenderCallback onGetRenderCallback() {
                return new TutorialRenderCallbackAdapter();
            }
        };


    }


    private class TutorialRenderCallbackAdapter extends RenderCallbackAdapter {

        private TutorialRenderCallbackAdapter() {
            //TO-DO: remove magic number
            super(new int[1200 * 800]);
        }

        @Override
        protected void onDisplay(DirectMediaPlayer mediaPlayer, int[] rgbBuffer) {
            // Simply copy buffer to the image and repaint
            //TO-DO: remove magic number
            image.setRGB(0, 0, 1200, 800, rgbBuffer, 0, 1200);
            videoSurface.repaint();
        }
    }

    private class VideoSurfacePanel extends JPanel {

        private VideoSurfacePanel() {
            setBackground(Color.black);
            setOpaque(true);
            setPreferredSize(new Dimension(1200, 800));
            setMinimumSize(new Dimension(1200, 800));
            setMaximumSize(new Dimension(1200, 800));
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D)g;
            g2.drawImage(image, null, 0, 0);
        }
    }

}
