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
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.hibernate.bo.custom.Impl.BOFactory;
import lk.ijse.hibernate.bo.custom.Impl.ProgramBOImpl;
import lk.ijse.hibernate.dto.ProgramDTO;
import lk.ijse.hibernate.entity.Program;
import lk.ijse.hibernate.entity.Student;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.regex.Pattern;

public class UpdateProgramFormController {
    public AnchorPane rootContext;
    public JFXTextField txtDuration;
    public JFXTextField txtFee;
    public JFXTextField txtId;
    public JFXTextField txtProName;
    ProgramBOImpl programBO = (ProgramBOImpl) BOFactory.getBoFactory().getBo(BOFactory.BoTypes.PROGRAM);

    public void searchProgram(ActionEvent actionEvent) {
        String programId = txtId.getText();
        Program program = programBO.searchById(programId);
        if (program  == null) {
            new Alert(Alert.AlertType.WARNING, "Empty Result Set", ButtonType.OK).showAndWait();
        } else {
            setData(program);
        }
    }

    void setData(Program p) {
        txtId.setText(p.getProgramId());
        txtProName.setText(p.getProgramName());
        txtDuration.setText(p.getDuration());
        txtFee.setText(String.valueOf(p.getFee()));
    }

    public void updateProgramOnAction(ActionEvent actionEvent) {
        ProgramDTO programDTO = new ProgramDTO(
                txtId.getText(), txtProName.getText(), txtDuration.getText(),
                Double.parseDouble(txtFee.getText())
        );

        Program program = new Program(programDTO.getProgramId(), programDTO.getProgramName(), programDTO.getDuration(), programDTO.getFee());
        boolean updateProgram = programBO.updateProgram(program);

        if (updateProgram) {
            new Alert(Alert.AlertType.CONFIRMATION, "Updated..").show();
        } else {
            new Alert(Alert.AlertType.WARNING, "Try Again").show();
        }

        txtId.clear();
        txtProName.clear();
        txtDuration.clear();
        txtFee.clear();
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
}