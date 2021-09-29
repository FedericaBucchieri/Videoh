package StudentHomePage;

public class VideoBoxModel {
    private VideoBox controller;
    private int width = 1200;
    private int height = 800;

    private String path;

    public VideoBoxModel (String path){
        this.path = path;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getPath() { return path;    }
}
