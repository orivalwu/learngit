package Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class S3_Entry extends Application {
    private static Stage stage = new Stage();
    private static int status=0;

    public Stage getStage() {
        return stage;
    }

    public static int getStatus() {
        return status;
    }

    public  void setStatus(int status) {
        this.status = status;
    }

    public void start(Stage primaryStage) throws Exception {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/view/Stage3_Info.fxml"));
            Scene scene = new Scene(root, 690, 520);
            primaryStage.setScene(scene);
            scene.getStylesheets().add("/view/stylesheet2.css");
            primaryStage.setTitle("比赛前信息");
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
