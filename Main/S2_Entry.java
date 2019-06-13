package Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class S2_Entry extends Application {
    private static Stage stage = new Stage();

    public Stage getStage() {
        return stage;
    }
    public void start(Stage primaryStage) throws Exception {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/view/Stage2_Mode.fxml"));
            Scene scene = new Scene(root, 690, 520);
            scene.getStylesheets().add("/view/stylesheet1.css");
            primaryStage.setScene(scene);
            primaryStage.setTitle("游戏模式选择");
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void showS2() throws Exception{
        start(stage);
    }
}
