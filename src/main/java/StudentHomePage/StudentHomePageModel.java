package StudentHomePage;

import uk.co.caprica.vlcj.player.media.Media;

public class StudentHomePageModel {
    private StudentHomePage controller;
    private Media media;
    private String videoPath; //va cancellato e messo un video da prendere dal DB
    private String username;

    public StudentHomePageModel (StudentHomePage controller, Media media){
        this.controller = controller;
        this.media = media;
        this.videoPath = videoPath;
        this.username = username;
    }


    public Media getMedia() {
        return media;
    }


}
