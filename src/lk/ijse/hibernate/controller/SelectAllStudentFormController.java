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
import lk.ijse.hibernate.bo.custom.Impl.StudentBOImpl;
import lk.ijse.hibernate.entity.Program;
import lk.ijse.hibernate.entity.Student;
import lk.ijse.hibernate.view.tdm.ProgramTM;
import lk.ijse.hibernate.view.tdm.StudentTM;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class SelectAllStudentFormController {
    public AnchorPane rootContext;
    public TableView tblStudent;
    public TableColumn colId;
    public TableColumn colName;
    public TableColumn colNic;
    public TableColumn colEmail;
    public TableColumn colAddress;
    public TableColumn colContactNo;
    private final StudentBOImpl studentBO = (StudentBOImpl) BOFactory.getBoFactory().getBo(BOFactory.BoTypes.STUDENT);

    public void initialize() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colNic.setCellValueFactory(new PropertyValueFactory<>("nic"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colContactNo.setCellValueFactory(new PropertyValueFactory<>("contactNo"));

        try {
            ArrayList<Student> students = studentBO.getAllStudents();
            for (Student allStudent : students) {
                tblStudent.getItems().add(new StudentTM(allStudent.getId(), allStudent.getName(), allStudent.getNic(), allStudent.getEmail(), allStudent.getAddress(), allStudent.getContactNo()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void navigateToBack(MouseEvent mouseEvent) throws IOException {
        URL resource = this.getClass().getResource("../view/StudentForm.fxml");
        Parent root = FXMLLoader.load(resource);
        Scene scene = new Scene(root);
        Stage primaryStage = (Stage) (this.rootContext.getScene().getWindow());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Student Form | Sipsewana Institute");
        primaryStage.centerOnScreen();
        primaryStage.setFullScreen(false);
        primaryStage.setResizable(false);
        Platform.runLater(() -> primaryStage.sizeToScene());
    }
}
