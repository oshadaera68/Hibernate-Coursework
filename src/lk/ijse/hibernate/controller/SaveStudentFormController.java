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
import lk.ijse.hibernate.bo.custom.Impl.StudentBOImpl;
import lk.ijse.hibernate.entity.Student;

import java.io.IOException;
import java.net.URL;

public class SaveStudentFormController {

    private final StudentBOImpl studentBo = (StudentBOImpl) BOFactory.getBoFactory().getBo(BOFactory.BoTypes.STUDENT);
    public AnchorPane rootContext;
    public JFXTextField txtId;
    public JFXTextField txtName;
    public JFXTextField txtNIC;
    public JFXTextField txtEmail;
    public JFXTextField txtAddress;
    public JFXTextField txtContactNo;

  /*  public void initialize() {

    }*/

    public void navigateToBack(MouseEvent mouseEvent) throws IOException {
        URL resource = this.getClass().getResource("../view/StudentForm.fxml");
        Parent root = FXMLLoader.load(resource);
        Scene scene = new Scene(root);
        Stage primaryStage = (Stage) (this.rootContext.getScene().getWindow());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Student Form | Sipsewana Institute");
        primaryStage.centerOnScreen();
        Platform.runLater(() -> primaryStage.sizeToScene());
    }

    public void saveStudentOnAction(ActionEvent actionEvent) {
        String id = txtId.getText();
        String name = txtName.getText();
        String nic = txtNIC.getText();
        String email = txtEmail.getText();
        String address = txtAddress.getText();
        String conNo = txtContactNo.getText();

       /* System.out.println(id);
        System.out.println(name);
        System.out.println(nic);
        System.out.println(email);
        System.out.println(address);
        System.out.println(conNo);*/

       /* try {
            if (studentBo.saveStudent(new StudentDTO(
                    id,
                    name,
                    nic,
                    email,
                    address,
                    conNo
            ))) ;
            {
                new Alert(Alert.AlertType.CONFIRMATION, "Do you wanna Save it?").showAndWait();
                txtId.clear();
                txtName.clear();
                txtNIC.clear();
                txtEmail.clear();
                txtAddress.clear();
                txtContactNo.clear();
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Something Happened. try again carefully!").showAndWait();
        }*/

        Student student = new Student(
                id, name, nic, email, address, conNo
        );

        if (studentBo.saveStudent(student)) {
new Alert(Alert.AlertType.CONFIRMATION,"");
        }else{

        }
    }
}
