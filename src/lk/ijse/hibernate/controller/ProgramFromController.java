/**
 * Powered By:MINDARTLK.
 * version:0.1.0
 */

package lk.ijse.hibernate.controller;

import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;

public class ProgramFromController {
    public AnchorPane rootContext;
    public ImageView imgAdd;
    public ImageView imgHome;
    public Label lblMenu;
    public Label lblDescription;
    public ImageView imgSearch;
    public ImageView imgUpdate;
    public ImageView imgDelete;
    public ImageView imgSelectAll;

    public void initialize() {
        FadeTransition fadeIn = new FadeTransition(Duration.millis(2000), rootContext);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);
        fadeIn.play();
    }

    public void navigate(MouseEvent mouseEvent) throws IOException {
        if (mouseEvent.getSource() instanceof ImageView) {
            ImageView icon = (ImageView) mouseEvent.getSource();

            Parent root = null;

            switch (icon.getId()) {
                case "imgAdd":
                    root = FXMLLoader.load(getClass().getResource("../view/SaveProgramForm.fxml"));
                    break;
                case "imgUpdate":
                    root = FXMLLoader.load(getClass().getResource("../view/UpdateProgramForm.fxml"));
                    break;
                case "imgDelete":
                    root = FXMLLoader.load(getClass().getResource("../view/DeleteProgramForm.fxml"));
                    break;
                case "imgSelectAll":
                    root = FXMLLoader.load(getClass().getResource("../view/SelectAllProgramForm.fxml"));
                    break;
                case "imgSearch":
                    root = FXMLLoader.load(getClass().getResource("../view/SearchProgramForm.fxml"));
                    break;
            }

            if (root != null) {
                Scene subScene = new Scene(root);
                Stage primaryStage = (Stage) this.rootContext.getScene().getWindow();
                primaryStage.setTitle("Manage Students | Sipsewana Institute");
                primaryStage.setScene(subScene);
                primaryStage.centerOnScreen();

                TranslateTransition tt = new TranslateTransition(Duration.millis(350), subScene.getRoot());
                tt.setFromX(-subScene.getWidth());
                tt.setToX(0);
                tt.play();
            }
        }
    }

    public void playMouseEnterAnimation(MouseEvent mouseEvent) {
        if (mouseEvent.getSource() instanceof ImageView) {
            ImageView icon = (ImageView) mouseEvent.getSource();

            switch (icon.getId()) {
                case "imgAdd":
                    lblMenu.setText("Add Programs");
                    lblDescription.setText("Add Programs in the system.");
                    break;
                case "imgUpdate":
                    lblMenu.setText("Update Programs");
                    lblDescription.setText("Update Programs in the system.");
                    break;
                case "imgDelete":
                    lblMenu.setText("Delete Programs");
                    lblDescription.setText("Delete Programs in the system.");
                    break;
                case "imgSelectAll":
                    lblMenu.setText("All Programs Table");
                    lblDescription.setText("All Programs On the table in the system.");
                    break;
                case "imgSearch":
                    lblMenu.setText("Search Programs");
                    lblDescription.setText("Search Programs in the System.");
            }

            ScaleTransition scaleT = new ScaleTransition(Duration.millis(200), icon);
            scaleT.setToX(1.2);
            scaleT.setToY(1.2);
            scaleT.play();

            DropShadow glow = new DropShadow();
            glow.setColor(Color.CORNFLOWERBLUE);
            glow.setWidth(20);
            glow.setHeight(20);
            glow.setRadius(20);
            icon.setEffect(glow);
        }
    }

    public void playMouseExitAnimation(MouseEvent mouseEvent) {
        if (mouseEvent.getSource() instanceof ImageView) {
            ImageView icon = (ImageView) mouseEvent.getSource();
            ScaleTransition scaleT = new ScaleTransition(Duration.millis(200), icon);
            scaleT.setToX(1);
            scaleT.setToY(1);
            scaleT.play();

            icon.setEffect(null);
            lblMenu.setText("Welcome To Program Section");
            lblDescription.setText("Please select one of above main operations to proceed");
        }
    }

    public void backToHome(MouseEvent mouseEvent) throws IOException {
        URL resource = this.getClass().getResource("../view/DashBoardForm.fxml");
        Parent root = FXMLLoader.load(resource);
        Scene scene = new Scene(root);
        Stage primaryStage = (Stage) (this.rootContext.getScene().getWindow());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Sipsewana Institute | MINDARTLK Creations");
        primaryStage.centerOnScreen();
        Platform.runLater(() -> primaryStage.sizeToScene());
    }
}