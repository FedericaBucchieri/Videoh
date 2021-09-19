public class Controller {
    private Model model;
    private View view;

    public Controller() {
        this.model = new Model();
        this.view = new View(this);
        this.view.setVisible(true);
    }

    public Model getModel() {
        return model;
    }

    public void handleStudentLogIn(String nickname){
        model.studentLogin(nickname);
    }

    public void handleProfessorLogin(String usr, String psw){
        //model.professorLogin();
    }
}
