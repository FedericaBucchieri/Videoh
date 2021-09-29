package EventManagement;

public class GoToVideoEvent implements Event {
    private String videoPath;
    private String username;

    public GoToVideoEvent (String videoPath, String username){
        this.videoPath = videoPath;
        this.username = username;
    }

    public String getVideoPath() {
        return videoPath;
    }


    public String getUsername() {
        return this.username;
    }
}
