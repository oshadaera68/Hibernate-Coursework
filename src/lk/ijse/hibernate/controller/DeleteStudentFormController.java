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
import lk.ijse.hibernate.bo.custom.Impl.StudentBOImpl;
import lk.ijse.hibernate.entity.Student;

import java.io.IOException;
import java.net.URL;

public class DeleteStudentFormController {
    public AnchorPane rootContext;
    public JFXTextField txtId;
    public JFXTextField txtName;
    public JFXTextField txtNIC;
    public JFXTextField txtEmail;
    public JFXTextField txtAddress;
    public JFXTextField txtContactNo;
    private final StudentBOImpl studentBO = (StudentBOImpl) BOFactory.getBoFactory().getBo(BOFactory.BoTypes.STUDENT);

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

    public void searchStudent(ActionEvent actionEvent) {
        String sId = txtId.getText();
        Student student = studentBO.getStudent(sId);

        if (student == null) {
            new Alert(Alert.AlertType.WARNING, "Empty Result Set", ButtonType.OK).showAndWait();
        } else {
            setData(student);
        }
    }

    void setData(Student student) {
        txtId.setText(student.getId());
        txtName.setText(student.getName());
        txtNIC.setText(student.getNic());
        txtEmail.setText(student.getEmail());
        txtAddress.setText(student.getAddress());
        txtContactNo.setText(student.getContactNo());
    }

    public void deleteStudentOnAction(ActionEvent actionEvent) {
        boolean deleteStudent = studentBO.deleteStudent(txtId.getText());

        if (deleteStudent) {
            new Alert(Alert.AlertType.CONFIRMATION, "Deleted", ButtonType.OK).show();
        } else {
            new Alert(Alert.AlertType.WARNING, "Try Again", ButtonType.OK).show();
        }

        txtId.clear();
        txtName.clear();
        txtNIC.clear();
        txtEmail.clear();
        txtAddress.clear();
        txtContactNo.clear();
    }
}
