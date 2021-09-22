package model;

import entities.Interaction;
import entities.Professor;
import entities.Question;
import entities.Video;
import exceptions.CredentialsException;
import exceptions.UserNotRegisteredException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import services.InteractionService;
import services.ProfessorService;
import services.QuestionService;
import services.VideoService;

import java.io.File;
import java.util.List;

public class Model {
    private String student;
    private Professor professor;
    private boolean isProfessor;
    private Video currentVideo;
    private List<Interaction> interactionList;
    private List<Question>  questionList;
    private final ProfessorService professorService;
    private final QuestionService questionService;
    private final InteractionService interactionService;
    private final VideoService videoService;
    private final EntityManager entityManager;
    private final EntityManagerFactory entityManagerFactory;

    public Model() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("default");
        this.entityManager = entityManagerFactory.createEntityManager();
        this.professorService = new ProfessorService(entityManager);
        this.questionService = new QuestionService(entityManager);
        this.interactionService = new InteractionService(entityManager);
        this.videoService = new VideoService(entityManager);
    }

    public void closeConnections(){
        this.entityManager.close();
        this.entityManagerFactory.close();
        System.out.println("connection closed");
    }

    public void studentLogin(String nickname){
        this.isProfessor = false;
        this.student = nickname;
        System.out.println(nickname);
    }

    public String professorLogin(String usr, String psw){
        try {
            Professor professor = professorService.checkCredentials(usr, psw);
            if(professor != null) {
                this.professor = professor;
                this.isProfessor = true;
                return null; // empty string means no error
            }
        } catch (CredentialsException e) {
            return e.getMessage();
        } catch (UserNotRegisteredException e){
            return e.getMessage();
        }

        return null;
    }

    // @TODO Handle videoFile
    public void createNewVideo(String title, String description, String previewImage, File videoFile){
        videoService.createVideo(title, description, previewImage, professor);
    }

    public List<Video> getVideoListByProfessor(){
        return videoService.findVideosByProfessor(professor.getId());
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
