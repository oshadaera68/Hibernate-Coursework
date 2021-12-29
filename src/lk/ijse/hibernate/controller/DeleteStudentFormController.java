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
import lk.ijse.hibernate.bo.custom.Impl.StudentBOImpl;
import lk.ijse.hibernate.dto.StudentDTO;
import lk.ijse.hibernate.entity.Student;

import java.io.IOException;
import java.net.URL;

public class DeleteStudentFormController {
    public JFXTextField txtId;
    public JFXTextField txtName;
    public JFXTextField txtNIC;
    public JFXTextField txtEmail;
    public JFXTextField txtAddress;
    public JFXTextField txtContactNo;
    public AnchorPane rootContext;
    private final StudentBOImpl studentBO = (StudentBOImpl) BOFactory.getBoFactory().getBo(BOFactory.BoTypes.STUDENT);

    public void navigateToBack(MouseEvent mouseEvent) throws IOException {
        URL resource = this.getClass().getResource("../view/StudentForm.fxml");
        Parent root = FXMLLoader.load(resource);
        Scene scene = new Scene(root);
        Stage primaryStage = (Stage) (this.rootContext.getScene().getWindow());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Student Form | Sipsewana Institute");
        primaryStage.centerOnScreen();
        primaryStage.setResizable(false);
        primaryStage.setFullScreen(false);
        Platform.runLater(() -> primaryStage.sizeToScene());
    }

    void setData(Student s){
        txtId.setText(s.getId());
        txtName.setText(s.getName());
        txtNIC.setText(s.getNic());
        txtEmail.setText(s.getEmail());
        txtAddress.setText(s.getAddress());
        txtContactNo.setText(s.getContactNo());
    }

    public void searchStudent(ActionEvent actionEvent) {
        String studentId = txtId.getText();
        Student student = studentBO.getStudent(studentId);
        if (student == null) {
            new Alert(Alert.AlertType.WARNING, "Empty Result Set", ButtonType.OK).showAndWait();
        } else {
            setData(student);
        }
    }

    public void deleteStudentOnAction(ActionEvent actionEvent) {
         boolean deleteStudent = studentBO.deleteStudent(txtId.getText());

        if (deleteStudent) {
            new Alert(Alert.AlertType.CONFIRMATION, "Deleted..").show();
        } else {
            new Alert(Alert.AlertType.WARNING, "Try Again").show();
        }

        txtId.clear();
        txtName.clear();
        txtNIC.clear();
        txtEmail.clear();
        txtAddress.clear();
        txtContactNo.clear();
    }
}
