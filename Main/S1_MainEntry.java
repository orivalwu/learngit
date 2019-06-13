package Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class S1_MainEntry extends Application {
    private static Stage stage = new Stage();
    public Stage getStage() {
        return stage;
    }
    public static void main(String... args) {
        Application.launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/view/Stage1_Start.fxml"));
            Scene scene = new Scene(root, 705, 415);
            scene.getStylesheets().add("/view/stylesheet1.css");
            primaryStage.setScene(scene);
            primaryStage.setTitle("±£¡‰«Ú”Œœ∑");
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
