package StudentHomePage;

import uk.co.caprica.vlcj.player.media.Media;

public class VideoBoxModel {
    private VideoBox controller;
    private int width = 1200;
    private int height = 800;
    private Media media;

    public VideoBoxModel (Media media){
        this.media = media;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Media getMedia() {
        return media;
    }
}
