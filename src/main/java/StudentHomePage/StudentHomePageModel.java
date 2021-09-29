package StudentHomePage;

public class StudentHomePageModel {
    private StudentHomePage controller;
    private String videoPath; //va cancellato e messo un video da prendere dal DB

    public StudentHomePageModel (StudentHomePage controller, String videoPath){
        this.controller = controller;
        this.videoPath = videoPath;
    }

    public String getVideoPath() {
        return videoPath;
    }


}
