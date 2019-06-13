package controller;

import Main.*;
import entity.GroupStrategy;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class S2_Controller {
    private int status=0;
    @FXML
    private Button back;
    @FXML
    private Button singleGame;
    @FXML
    private Button doubleGame;
    @FXML
    private Button tripleGame;
    @FXML
    private Button pentaGame;
    @FXML
    private Button omniunGame;
    @FXML
    private Button eliteGame;

    private GroupStrategy groupStrategy;

    public S2_Controller() {
        groupStrategy = GroupStrategy.getInstance();
    }

    public void back() throws Exception{
        S1_MainEntry s1=new S1_MainEntry();
        s1.start(s1.getStage());
        close();
    }
    public void setSingleGame() throws Exception {
        this.status=1;
        groupStrategy.grouping(status);
        openS3(status);
    }
    public void setDoubleGame() throws Exception {
        this.status=2;
        groupStrategy.grouping(status);
        openS3(status);
    }
    public  void setTripleGame() throws Exception {
        this.status=3;
        groupStrategy.grouping(status);
        openS3(status);
    }
    public void setPentaGame() throws Exception {
        this.status=5;
        groupStrategy.grouping(status);
        openS3(status);
    }

    public void setEliteGame() throws Exception{
        this.status = 1;
        groupStrategy.grouping(status);
        for(int i =0;i<groupStrategy.getList().size();i++){
            groupStrategy.getList().get(i).setGroup("精英赛");
        }
        openS3(status);
    }
    public void setomniunGame()throws  Exception{
        this.status = 1;
        groupStrategy.grouping(status);
        for(int i =0;i<groupStrategy.getList().size();i++){
            groupStrategy.getList().get(i).setGroup("全能赛");
        }
        openS3(status);
    }

    public void openS3(int status) throws Exception {
        S3_Entry s3=new S3_Entry();
        s3.setStatus(status);
        s3.start(s3.getStage());
        close();
    }
    public void close(){
        Stage stage=(Stage)back.getScene().getWindow();
        stage.close();
    }
}
