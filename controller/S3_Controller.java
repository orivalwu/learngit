package controller;

import entity.*;
import Main.*;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class S3_Controller implements Initializable {
    @FXML
    private Button back;
    @FXML
    private Button play;
    @FXML
    private Button details;
    @FXML
    private TableColumn<Competitor, String> TC_cId;
    @FXML
    private TableColumn<Competitor, String> TC_cName;
    @FXML
    private TableColumn<Competitor, String> TC_cGroup;
    @FXML
    private TableColumn<Competitor, String> TC_Grade;
    @FXML
    private TableView<Competitor> TV_information;
    private ObservableList<Competitor> cellData = FXCollections.observableArrayList();
    public S3_Controller() {
        GroupStrategy.getInstance();
        drawShow();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        getItems();
    }

    public void getItems() {

        TC_cId.setCellValueFactory(cellData ->new ReadOnlyObjectWrapper(cellData.getValue().getNumber()) );
        TC_cName.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getName()));
        TC_cGroup.setCellValueFactory(cellData->new ReadOnlyStringWrapper(cellData.getValue().getGroup()));
        TV_information.setItems(cellData);
    }

    public void playGame() {
        TC_Grade.setCellValueFactory(cellData->new ReadOnlyObjectWrapper(cellData.getValue().getTotalScore()));

    }

    public void showDetails() throws Exception {
        S4_Entry s4 = new S4_Entry();
        s4.showWindow();
    }

    public void back() throws Exception{
        GroupStrategy.clearInstance();
        S2_Entry s2=new S2_Entry();
        s2.showS2();
    }
    public void drawShow(){
        int total = 0;
        GroupStrategy.getInstance();
        Calculation calculation = new Calculation();
        for(int i= 0 ;i<GroupStrategy.getList().size();i++){
            List<Integer> array = new ArrayList<>();
            ArrayList<Integer> arrayList = new ArrayList<>();
            if(GroupStrategy.getList().get(i).getGroup().equals("精英赛")||GroupStrategy.getList().get(i).getGroup().equals("全能赛")){
                for(int j = 0; j< 24 ;j++){
                    calculation.calcScore();
                    array.add(calculation.getScore());
                    arrayList.add(j+1);
                    total+=array.get(j);
                }
            }
            else{
                for(int j =0;j<6;j++){
                    calculation.calcScore();
                    array.add(calculation.getScore());
                    arrayList.add(j+1);
                    total+=array.get(j);
                }
            }
            GroupStrategy.getList().get(i).setRoundScore(array);
            GroupStrategy.getList().get(i).setTotalScore(total);
            GroupStrategy.getList().get(i).setRoundCount(arrayList);
            this.cellData.add(GroupStrategy.getList().get(i));
            total = 0;

        }
    }
}
