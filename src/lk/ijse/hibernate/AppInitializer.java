package lk.ijse.hibernate;

/**
 * Powered By:MINDARTLK.
 * Date:2021/12/04
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AppInitializer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("view/SplashScreenForm.fxml"))));
        primaryStage.setTitle("Welcome Screen");
        primaryStage.show();
    }
}
