package controller;

import entity.*;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.*;

public class S4_Controller implements Initializable {
    @FXML
    private TableView details;
    @FXML
    private TableColumn<Competitor, String> TC_id;
    @FXML
    private TableColumn<Competitor,String> TC_competition;
    @FXML
    private TableColumn<Competitor, String> TC_info;
    @FXML
    private TableColumn<Competitor, String> TC_grade;
    @FXML
    private TableColumn<Competitor, String> TC_level;
    @FXML
    private Button exit;
    @FXML
    private Button save;

    private String str="";
    private ObservableList<Competitor> cellData = FXCollections.observableArrayList();

    public S4_Controller() {
        GroupStrategy.getInstance();
        Collections.sort(GroupStrategy.getList(),(e1,e2)->{
            return -(e1.getTotalScore()-e2.getTotalScore());
        });
        for(int i=0;i<GroupStrategy.getList().size();i++){
            str+=GroupStrategy.getList().get(i).toString()+"\n";
            cellData.add(i,GroupStrategy.getList().get(i));
            cellData.get(i).setlever(i+1);
        }

    }

    public void exit() {
        Stage stage = (Stage) exit.getScene().getWindow();
        stage.close();
    }

    public void finalPlay() {
        //��ɾ��cellDate�еļ�¼
        Iterator<Competitor> it = cellData.iterator();
        while(it.hasNext()){
            Competitor competitor = it.next();
            it.remove();
        }
        GroupStrategy.getInstance();
        //��Ϊ�Ѿ��ź�����ȡǰ24λ���о�Ӣ��
        for(int i=0;i<24;i++){
                if(GroupStrategy.getList().get(i).getGroup().equals("��Ӣ��")){
                    Calculation calcutlation = new Calculation();
                    calcutlation.calcScore();
                    GroupStrategy.getList().get(i).setTotalScore(calcutlation.getScore());
                    cellData.add(GroupStrategy.getList().get(i));
            }
                else{
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("��ʾ");
                    alert.setContentText("����ģʽ���󣬸ò������޾�Ӣ��");
                    alert.show();
                }
        getItems();
        }

    }
    public void getItems(){
        TC_id.setCellValueFactory(cellData->new ReadOnlyObjectWrapper(cellData.getValue().getNumber()));
        TC_competition.setCellValueFactory(cellData->new ReadOnlyObjectWrapper(cellData.getValue().getRoundCount()));
        TC_info.setCellValueFactory(cellData->new ReadOnlyObjectWrapper(cellData.getValue().getRoundScore()));
        TC_grade.setCellValueFactory(cellData->new ReadOnlyObjectWrapper(cellData.getValue().getTotalScore()));
        TC_level.setCellValueFactory(cellData->new ReadOnlyObjectWrapper(cellData.getValue().getlever()));
        details.setItems(cellData);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        getItems();
    }
    public void writeHistory(String content){
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("txt","gif");
        //�����ļ�����
        chooser.setFileFilter(filter);
        //��ѡ�����
        int returnVal = chooser.showSaveDialog(new JPanel());
        if(returnVal == JFileChooser.APPROVE_OPTION){
            String path = chooser.getSelectedFile().getPath();
            File file  = new File(path+".txt");
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                FileOutputStream out = new FileOutputStream(file);
                out.write(content.getBytes());
                out.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
    public void saving(){
        save.setOnAction(e->{
            writeHistory(str);
        });

    }



}
