package EventManagement;

import uk.co.caprica.vlcj.player.media.Media;

public class GoToVideoEvent implements Event {
    private Media media;
    private String username;

    public GoToVideoEvent (Media media, String username){
        this.media = media;
        this.username = username;
    }

    public Media getMedia() {
        return media;
    }


    public String getUsername() {
        return this.username;
    }
}
