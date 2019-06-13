package Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

    public class S4_Entry extends Application {
        private static Stage stage = new Stage();

        public static void main(String... args) {
            Application.launch(args);
        }

        public Stage getStage() {
            return stage;
        }

        @Override
        public void start(Stage primaryStage) {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("/view/Stage4_Details.fxml"));
                Scene scene = new Scene(root, 690, 520);
                primaryStage.setScene(scene);
                scene.getStylesheets().add("/view/stylesheet3.css");
                primaryStage.setTitle("±£¡‰«Ú”Œœ∑");
                primaryStage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void showWindow() throws Exception {
            start(stage);
        }
    }

