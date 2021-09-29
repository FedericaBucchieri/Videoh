package EventManagement;

import uk.co.caprica.vlcj.player.media.Media;

public class GoToVideoEvent implements Event {
    private String videoPath;
    private String username;

    public GoToVideoEvent (String videoPath, String username){
        this.videoPath = videoPath;
        this.username = username;
    }

    public Media getMedia() {
        return media;
    }


    public String getUsername() {
        return this.username;
    }
}
