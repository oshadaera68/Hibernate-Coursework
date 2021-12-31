/**
 * Powered By : MINDARTLK.
 * version:0.1.0
 */
package lk.ijse.hibernate.controller;

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

public class StudentFormController {
    public AnchorPane rootContext;
    public ImageView imgAdd;
    public ImageView imgSearch;
    public ImageView imgUpdate;
    public ImageView imgDelete;
    public ImageView imgSelectAll;
    public ImageView imgHome;
    public Label lblMenu;
    public Label lblDescription;

    public void navigate(MouseEvent mouseEvent) throws IOException {
        if (mouseEvent.getSource() instanceof ImageView) {
            ImageView icon = (ImageView) mouseEvent.getSource();
            Parent root = null;

            switch (icon.getId()) {
                case "imgAdd":
                    root = FXMLLoader.load(getClass().getResource("../view/SaveStudentForm.fxml"));
                    break;
                case "imgSearch":
                    root = FXMLLoader.load(getClass().getResource("../view/SearchStudentForm.fxml"));
                    break;

                case "imgUpdate":
                    root = FXMLLoader.load(getClass().getResource("../view/UpdateStudentForm.fxml"));
                    break;

                case "imgDelete":
                    root = FXMLLoader.load(getClass().getResource("../view/DeleteStudentForm.fxml"));
                    break;

                case "imgSelectAll":
                    root = FXMLLoader.load(getClass().getResource("../view/SelectAllStudentForm.fxml"));
                    break;
            }

            if (root != null) {
                Scene subScene = new Scene(root);
                Stage primaryStage = (Stage) this.rootContext.getScene().getWindow();
                primaryStage.setTitle("Student Form | Sipsewana institute");
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
                    lblMenu.setText("Add Students");
                    lblDescription.setText("Add Students in this system.");
                    break;
                case "imgSearch":
                    lblMenu.setText("Search Students");
                    lblDescription.setText("Search Students in this system.");
                    break;

                case "imgUpdate":
                    lblMenu.setText("Update Students");
                    lblDescription.setText("Update Students in this system.");
                    break;

                case "imgDelete":
                    lblMenu.setText("Delete Students");
                    lblDescription.setText("Delete Students in this system.");
                    break;

                case "imgSelectAll":
                    lblMenu.setText("All Students Table");
                    lblDescription.setText("All Students showing in this system.");
                    break;
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
            lblMenu.setText("Welcome To Student Section");
            lblDescription.setText("Please select one of above main operations to proceed");
        }
    }

    public void backToHome(MouseEvent mouseEvent) throws IOException {
        URL resource = this.getClass().getResource("../view/DashBoardForm.fxml");
        Parent root = FXMLLoader.load(resource);
        Scene scene = new Scene(root);
        Stage primaryStage = (Stage) (this.rootContext.getScene().getWindow());
        primaryStage.setScene(scene);
        primaryStage.setFullScreen(false);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Sipsewana institute | MINDARTLK Creations");
        primaryStage.centerOnScreen();
        Platform.runLater(() -> primaryStage.sizeToScene());
    }
}