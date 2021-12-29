/**
 * Powered By:MINDARTLK.
 * version:0.1.0
 */

package lk.ijse.hibernate.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.hibernate.bo.custom.Impl.BOFactory;
import lk.ijse.hibernate.bo.custom.Impl.ProgramBOImpl;
import lk.ijse.hibernate.entity.Program;

import java.io.IOException;
import java.net.URL;

public class SaveProgramFormController {
    private final ProgramBOImpl programBO = (ProgramBOImpl) BOFactory.getBoFactory().getBo(BOFactory.BoTypes.PROGRAM);
    public JFXTextField txtId;
    public JFXTextField txtProgram;
    public JFXTextField txtDuration;
    public JFXTextField txtFee;
    public AnchorPane rootContext;

    public void saveProgramOnAction(ActionEvent actionEvent) {
        String id = txtId.getText();
        String proName = txtProgram.getText();
        String duration = txtDuration.getText();
        double fee = Double.parseDouble(txtFee.getText());

        Program program = new Program(
                id, proName, duration, fee
        );

        if (programBO.saveProgram(program)) {
            new Alert(Alert.AlertType.CONFIRMATION, "Saved").show();
        } else {
            new Alert(Alert.AlertType.CONFIRMATION, "Try Again").show();
        }
    }

    public void navigateToBack(MouseEvent mouseEvent) throws IOException {
        URL resource = this.getClass().getResource("../view/ProgramForm.fxml");
        Parent root = FXMLLoader.load(resource);
        Scene scene = new Scene(root);
        Stage primaryStage = (Stage) (this.rootContext.getScene().getWindow());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Program Form | Sipsewana Institute");
        primaryStage.centerOnScreen();
        primaryStage.setResizable(false);
        primaryStage.setFullScreen(false);
        Platform.runLater(() -> primaryStage.sizeToScene());
    }
}
