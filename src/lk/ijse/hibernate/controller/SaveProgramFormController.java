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
import lk.ijse.hibernate.dto.ProgramDTO;
import lk.ijse.hibernate.dto.StudentDTO;

import java.io.IOException;
import java.net.URL;

public class SaveProgramFormController {
    public JFXTextField txtId;
    public JFXTextField txtProgram;
    public JFXTextField txtDuration;
    public JFXTextField txtFee;
    public AnchorPane rootContext;

    private final ProgramBOImpl programBO = (ProgramBOImpl) BOFactory.getBoFactory().getBo(BOFactory.BoTypes.PROGRAM);

    public void saveProgramOnAction(ActionEvent actionEvent) {
        String id = txtId.getText();
        String proName = txtProgram.getText();
        String duration = txtDuration.getText();
        double fee = Double.parseDouble(txtFee.getText());

        /*System.out.println(id);
        System.out.println(proName);
        System.out.println(duration);
        System.out.println(fee);*/
        try {
            if (programBO.saveProgram(new ProgramDTO(
                    id,
                    proName,
                    duration,
                    fee
            ))) ;
            {
                new Alert(Alert.AlertType.CONFIRMATION, "Do you wanna Save it?").showAndWait();
                txtId.clear();
                txtProgram.clear();
                txtDuration.clear();
                txtDuration.clear();
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Something Happened. try again carefully!").showAndWait();
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
        Platform.runLater(() -> primaryStage.sizeToScene());
    }
}
