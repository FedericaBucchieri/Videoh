package StudentHomePage;

public class StudentHomePageModel {
    private StudentHomePage controller;
    private String videoPath; //va cancellato e messo un video da prendere dal DB
    private String username;

    public StudentHomePageModel (StudentHomePage controller, String videoPath, String username){
        this.controller = controller;
        this.videoPath = videoPath;
        this.username = username;
    }


    public String getVideoPath() {
        return videoPath;
    }


}
