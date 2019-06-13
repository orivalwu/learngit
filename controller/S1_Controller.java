package controller;

import Main.S2_Entry;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.io.File;
import java.io.IOException;


public class S1_Controller {
    @FXML
    private VBox pane;
    @FXML
    private Button history;
    @FXML
    private Button exitGame;
    public void play() throws Exception{
        S2_Entry s2=new S2_Entry();
        s2.showS2();
        exit();
    }
    public void exit(){
        Stage stage = (Stage) exitGame.getScene().getWindow();
        stage.close();
    }
    public void showHistory(){
        JFileChooser jf = new JFileChooser();
        FileSystemView fsv = FileSystemView.getFileSystemView();
        jf.setCurrentDirectory(fsv.getHomeDirectory());
        jf.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        jf.showDialog(new JLabel(),"х╥хо");
        File file = jf.getSelectedFile();
        if(Desktop.isDesktopSupported()){
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.open(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
