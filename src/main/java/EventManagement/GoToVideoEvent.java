package EventManagement;

import uk.co.caprica.vlcj.player.media.Media;

public class GoToVideoEvent implements Event {
    private Media media;

    public GoToVideoEvent (Media media){
        this.media = media;
    }

    public Media getMedia() {
        return media;
    }
}
