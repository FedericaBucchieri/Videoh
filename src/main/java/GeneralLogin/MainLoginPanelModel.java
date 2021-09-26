package GeneralLogin;

import javax.swing.*;
import java.awt.*;

public class MainLoginPanelModel { //model
    MainLoginPanel controller;
    private ImageIcon studIcon;


    private ImageIcon profIcon;


    public MainLoginPanelModel(MainLoginPanel controller){
        this.controller = controller;

        studIcon = new ImageIcon(new ImageIcon("resources/stud.png").getImage().getScaledInstance(90, 120, Image.SCALE_SMOOTH));
        profIcon = new ImageIcon(new ImageIcon("resources/prof.png").getImage().getScaledInstance(90, 120, Image.SCALE_SMOOTH));
    }

    public ImageIcon getStudIcon() {
        return studIcon;
    }

    public ImageIcon getProfIcon() {
        return profIcon;
    }

}
