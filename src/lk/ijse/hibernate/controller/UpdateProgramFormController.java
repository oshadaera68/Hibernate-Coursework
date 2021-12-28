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
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.hibernate.bo.custom.Impl.BOFactory;
import lk.ijse.hibernate.bo.custom.Impl.ProgramBOImpl;
import lk.ijse.hibernate.dto.ProgramDTO;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.regex.Pattern;

public class UpdateProgramFormController {
    public AnchorPane rootContext;
    public JFXTextField txtProgramId;
    public JFXTextField txtProgramName;
    public JFXTextField txtDuration;
    public JFXTextField txtFee;
    ProgramBOImpl programBO = (ProgramBOImpl) BOFactory.getBoFactory().getBo(BOFactory.BoTypes.PROGRAM);
    LinkedHashMap<TextField, Pattern> map = new LinkedHashMap<>();
    Pattern idregEx = Pattern.compile("^(S00-)[0-9]{3,20}$");

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

    public void searchProgram(ActionEvent actionEvent) {
    }

    public void updateProgramOnAction(ActionEvent actionEvent) {
       /* ProgramDTO programDto = new ProgramDTO(txtProgramId.getText(), txtProgramName.getText(), txtDuration.getText(), Double.parseDouble(txtFee.getText()));
        try {
            if (programBO.updateProgram(programDto)) {
                new Alert(Alert.AlertType.INFORMATION, "Update Successfull..!").show();
            } else {
                new Alert(Alert.AlertType.ERROR, "Update Failed....!").show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }
}