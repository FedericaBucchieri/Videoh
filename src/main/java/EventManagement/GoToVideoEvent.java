package EventManagement;

public class GoToVideoEvent implements Event {
    private String videoPath;

    public GoToVideoEvent (String videoPath){
        this.videoPath = videoPath;
    }

    public String getVideoPath() {
        return videoPath;
    }


}
