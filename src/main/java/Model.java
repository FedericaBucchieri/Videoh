import entities.Interaction;
import entities.Professor;
import entities.Question;
import entities.Video;
import services.InteractionService;
import services.ProfessorService;
import services.QuestionService;
import services.VideoService;

import java.util.List;

public class Model {
    private String student;
    private Professor professor;
    private boolean isProfessor;
    private Video currentVideo;
    private List<Interaction> interactionList;
    private List<Question>  questionList;
    private ProfessorService professorService;
    private QuestionService questionService;
    private InteractionService interactionService;
    private VideoService videoService;

    public Model() {
    }

    public void studentLogin(String nickname){
        this.isProfessor = false;
        this.student = nickname;
        System.out.println(nickname);
    }

    public void professorLogin(Professor professor){
        this.isProfessor = true;
        this.professor = professor;
    }

    public Video getCurrentVideo() {
        return currentVideo;
    }

    public void setCurrentVideo(Video currentVideo) {
        this.currentVideo = currentVideo;
    }

    public String getStudent() {
        return student;
    }

    public Professor getProfessor() {
        return professor;
    }

    public boolean isProfessor() {
        return isProfessor;
    }

    public List<Interaction> getInteractionList() {
        return interactionList;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void addInteractionToCurrentSession(Interaction interaction){
        interactionList.add(interaction);
    }

    public void addQuestionToCurrentSession(Question question){
        questionList.add(question);
    }
}
