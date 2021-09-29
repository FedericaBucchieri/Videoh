package StudentHomePage;

import uk.co.caprica.vlcj.player.media.Media;

public class StudentHomePageModel {
    private StudentHomePage controller;
    private Media media;

    public StudentHomePageModel (StudentHomePage controller, Media media){
        this.controller = controller;
        this.media = media;
    }

    public Media getMedia() {
        return media;
    }
}
