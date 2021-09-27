package StudentInsertCode;

import EventManagement.BackEvent;
import EventManagement.Listener;
import sceneManager.SceneManager;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class InsertCode extends JComponent {
    private InsertCodeModel model;
    private InsertCodeUI ui;
    private List<Listener> listeners = new ArrayList<>();

    public InsertCode(SceneManager sceneManager, String studentUsername) {
        this.listeners.add(sceneManager);

        this.model = new InsertCodeModel(this, studentUsername);
        this.ui = new InsertCodeUI(this);
        this.ui.installUI();
    }

    public JPanel getMainPanel(){
        return ui.getMainPanel();
    }

    public void goBackToGeneralLogin(){
        for (Listener listener : listeners)
            listener.listen(new BackEvent());
    }

    public String getStudentUsername(){
        return  model.getStudentUsername();
    }
}
