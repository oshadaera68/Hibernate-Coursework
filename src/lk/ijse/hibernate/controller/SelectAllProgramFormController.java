/**
 * Powered By : MINDARTLK.
 * version:0.1.0
 */
package lk.ijse.hibernate.controller;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.hibernate.bo.custom.Impl.BOFactory;
import lk.ijse.hibernate.bo.custom.Impl.ProgramBOImpl;
import lk.ijse.hibernate.entity.Program;
import lk.ijse.hibernate.view.tdm.ProgramTM;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class SelectAllProgramFormController {
    private final ProgramBOImpl programBO = (ProgramBOImpl) BOFactory.getBoFactory().getBo(BOFactory.BoTypes.PROGRAM);
    public AnchorPane rootContext;
    public TableView tblProgram;
    public TableColumn colProgramId;
    public TableColumn colProgramName;
    public TableColumn colDuration;
    public TableColumn colFee;

    public void initialize() {
        colProgramId.setCellValueFactory(new PropertyValueFactory<>("programId"));
        colProgramName.setCellValueFactory(new PropertyValueFactory<>("programName"));
        colDuration.setCellValueFactory(new PropertyValueFactory<>("duration"));
        colFee.setCellValueFactory(new PropertyValueFactory<>("fee"));

        try {
            ArrayList<Program> allPrograms = programBO.getAllPrograms();
            for (Program allProgram : allPrograms) {
                tblProgram.getItems().add(new ProgramTM(allProgram.getProgramId(), allProgram.getProgramName(), allProgram.getDuration(), allProgram.getFee()));
            }
        } catch (Exception e) {
            e.printStackTrace();
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
        primaryStage.setFullScreen(false);
        primaryStage.setResizable(false);
        Platform.runLater(() -> primaryStage.sizeToScene());
    }
}
