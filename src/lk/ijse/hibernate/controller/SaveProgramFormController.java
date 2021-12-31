/**
 * Powered By : MINDARTLK.
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
import lk.ijse.hibernate.dto.ProgramDTO;
import lk.ijse.hibernate.entity.Program;

import java.io.IOException;
import java.net.URL;

public class SaveProgramFormController {
    public AnchorPane rootContext;
    public JFXTextField txtId;
    public JFXTextField txtProgram;
    public JFXTextField txtDuration;
    public JFXTextField txtFee;
    private final ProgramBOImpl programBO = (ProgramBOImpl) BOFactory.getBoFactory().getBo(BOFactory.BoTypes.PROGRAM);

    public void saveProgramOnAction(ActionEvent actionEvent) {
        ProgramDTO p1 = new ProgramDTO(
                txtId.getText(), txtProgram.getText(), txtDuration.getText(), Double.parseDouble(txtFee.getText())
        );
        Program program = new Program(p1.getProgramId(), p1.getProgramName(), p1.getDuration(), p1.getFee());
        boolean addCustomer = programBO.saveProgram(program);

        if (addCustomer) {
            new Alert(Alert.AlertType.CONFIRMATION, "Saved Data..", ButtonType.OK).showAndWait();
        } else {
            new Alert(Alert.AlertType.WARNING, "Try again...", ButtonType.OK).showAndWait();
        }

        txtId.clear();
        txtProgram.clear();
        txtDuration.clear();
        txtFee.clear();
    }

    public void navigateToBack(MouseEvent mouseEvent) throws IOException {
        URL resource = this.getClass().getResource("../view/ProgramForm.fxml");
        Parent root = FXMLLoader.load(resource);
        Scene scene = new Scene(root);
        Stage primaryStage = (Stage) (this.rootContext.getScene().getWindow());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Program Form | Sipsewana Institute");
        primaryStage.centerOnScreen();
        primaryStage.setFullScreen(false);
        primaryStage.setResizable(false);
        Platform.runLater(() -> primaryStage.sizeToScene());
    }
}
