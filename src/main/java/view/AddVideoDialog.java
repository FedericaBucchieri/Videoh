package view;

import javax.swing.*;
import java.awt.event.*;
import java.io.File;

public class AddVideoDialog extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField titleField;
    private JTextField descriptionField;
    private JLabel fileSelected;
    private JButton uploadButton;
    private JTextField previewField;
    private File newVideoFile;
    private View view;

    public AddVideoDialog(View view) {
        this.view = view;
    }


    public AddVideoDialog() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        setUpUploadButton();
    }

    private void setUpUploadButton(){
        uploadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
                int result = fileChooser.showOpenDialog(contentPane);
                if (result == JFileChooser.APPROVE_OPTION) {
                    newVideoFile = fileChooser.getSelectedFile();
                    fileSelected.setText(newVideoFile.getName());
                }
            }
        });
    }


    private void onOK() {
        view.handleAddNewVideo(titleField.getText(), descriptionField.getText(), previewField.getText(), newVideoFile);
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public void openAddVideoDialogue(AddVideoDialog dialog){
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    public static void main(String[] args) {
        AddVideoDialog dialog = new AddVideoDialog();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
