package StudentHomePage;

import uk.co.caprica.vlcj.player.media.Media;

public class StudentHomePageModel {
    private StudentHomePage controller;
    private Media media;
    private String username;

    public StudentHomePageModel (StudentHomePage controller, Media media, String username){
        this.controller = controller;
        this.media = media;
        this.username = username;
    }


    public Media getMedia() {
        return media;
    }


}
