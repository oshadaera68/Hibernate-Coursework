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
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.hibernate.bo.custom.Impl.BOFactory;
import lk.ijse.hibernate.bo.custom.Impl.ProgramBOImpl;
import lk.ijse.hibernate.entity.Program;

import java.io.IOException;
import java.net.URL;

public class DeleteProgramFormController {
    private final ProgramBOImpl programBO = (ProgramBOImpl) BOFactory.getBoFactory().getBo(BOFactory.BoTypes.PROGRAM);
    public AnchorPane rootContext;
    public JFXTextField txtDuration;
    public JFXTextField txtFee;
    public JFXTextField txtId;
    public JFXTextField txtProName;

    void setData(Program p) {
        txtId.setText(p.getProgramId());
        txtProName.setText(p.getProgramName());
        txtDuration.setText(p.getDuration());
        txtFee.setText(String.valueOf(p.getFee()));
    }

    public void searchProgram(ActionEvent actionEvent) {
        String programId = txtId.getText();
        Program program = programBO.getProgram(programId);
        if (program == null) {
            new Alert(Alert.AlertType.WARNING, "Empty Result Set", ButtonType.OK).showAndWait();
        } else {
            setData(program);
        }
    }

    public void backToHome(MouseEvent mouseEvent) throws IOException {
        URL resource = this.getClass().getResource("../view/ProgramForm.fxml");
        Parent root = FXMLLoader.load(resource);
        Scene scene = new Scene(root);
        Stage primaryStage = (Stage) (this.rootContext.getScene().getWindow());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Program Form | Sipsewana Institute");
        primaryStage.centerOnScreen();
        Platform.runLater(() -> primaryStage.sizeToScene());
    }

    public void deleteProgramOnAction(ActionEvent actionEvent) {
        boolean deleteProgram = programBO.deleteProgram(txtId.getText());

        if (deleteProgram) {
            new Alert(Alert.AlertType.CONFIRMATION, "Deleted", ButtonType.OK).show();
        } else {
            new Alert(Alert.AlertType.WARNING, "Try Again", ButtonType.OK).show();
        }

        txtId.clear();
        txtProName.clear();
        txtDuration.clear();
        txtFee.clear();
    }
}