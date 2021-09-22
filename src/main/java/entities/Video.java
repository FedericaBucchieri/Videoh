package entities;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Entity
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String title;
    private String previewImage;
    private String description;
    private String code;

    // @TODO
    // The video is missing -> Binary data type?

    @Temporal(TemporalType.DATE)
    private Date date;

    @ManyToOne
    @JoinColumn(name = "professor")
    private Professor professor;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "video", cascade = CascadeType.ALL)
    private List<Interaction> interactionList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "video", cascade = CascadeType.ALL)
    private List<Question> questionList;


    public Video() {
    }

    public Video(String title, String description, String previewImage, Professor professor) {
        this.title = title;
        this.description = description;
        this.previewImage = previewImage;
        this.date = new Timestamp(System.currentTimeMillis());
        this.professor = professor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public List<Interaction> getInteractionList() {
        return interactionList;
    }

    public void setInteractionList(List<Interaction> interactionList) {
        this.interactionList = interactionList;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }

    public String getPreviewImage() {
        return previewImage;
    }

    public void setPreviewImage(String previewImage) {
        this.previewImage = previewImage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
