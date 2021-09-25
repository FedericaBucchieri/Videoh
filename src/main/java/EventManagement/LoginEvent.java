package EventManagement;

import entities.Professor;

public class LoginEvent implements Event{
    private Professor professor;

    public LoginEvent(Professor professor) {
        this.professor = professor;
    }

    public Professor getProfessor() {
        return professor;
    }
}
