/**
 * Powered By : MINDARTLK.
 * version:0.1.0
 */
package lk.ijse.hibernate.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.hibernate.bo.custom.Impl.BOFactory;
import lk.ijse.hibernate.bo.custom.Impl.ProgramBOImpl;
import lk.ijse.hibernate.bo.custom.Impl.StudentBOImpl;
import lk.ijse.hibernate.entity.Program;
import lk.ijse.hibernate.entity.Student;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public class RegisterFormController {
    private final StudentBOImpl studentBO = (StudentBOImpl) BOFactory.getBoFactory().getBo(BOFactory.BoTypes.STUDENT);
    private final ProgramBOImpl programBO = (ProgramBOImpl) BOFactory.getBoFactory().getBo(BOFactory.BoTypes.PROGRAM);
    public AnchorPane rootContext;
    public JFXComboBox<String> cmbStudentIds;
    public JFXComboBox<String> cmbProgramIds;
    public JFXTextField txtStudentName;
    public JFXTextField txtStudentNIC;
    public JFXTextField txtStudentEmail;
    public JFXTextField txtStudentAddress;
    public JFXTextField txtContactNo;
    public JFXTextField txtProgramName;
    public JFXTextField txtDuration;
    public JFXTextField txtFee;
    public JFXButton btnRegister;
    public JFXButton btnNewStudent;
    ObservableList<String> studentsList = FXCollections.observableArrayList();
    ObservableList<String> programsList = FXCollections.observableArrayList();

    public void initialize() {
        cmbStudentIds.requestFocus();
        //btnRegister.setDisable(true);

        try {

            List<Student> students = studentBO.getAllStudents();
            List<Program> programs = programBO.getAllPrograms();

            for (Student student : students) {
                studentsList.add(student.getId());
            }

            for (Program program : programs) {
                programsList.add(program.getProgramId());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        cmbStudentIds.getItems().setAll(studentsList);
        cmbProgramIds.getItems().setAll(programsList);

        cmbStudentIds.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                //btnNewStudent.setDisable(true);
                setStudentDetails(newValue);
            }
        });

        cmbProgramIds.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                setProgramDetails(newValue);

            }
        });

    }

    private void setProgramDetails(String newValue) {
        try {
            Program temProgram = programBO.getProgram(newValue);
            txtProgramName.setText(temProgram.getProgramName());
            txtDuration.setText(temProgram.getDuration());
            txtFee.setText(String.valueOf(temProgram.getFee()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setStudentDetails(String newValue) {
        try {
            Student tempStudent = studentBO.getStudent(newValue);
            txtStudentName.setText(tempStudent.getName());
            txtStudentNIC.setText(tempStudent.getNic());
            txtStudentEmail.setText(tempStudent.getEmail());
            txtStudentAddress.setText(tempStudent.getAddress());
            txtContactNo.setText(tempStudent.getContactNo());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void registerOnAction(ActionEvent actionEvent) throws IOException {

    }

    public void dashBoardOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = this.getClass().getResource("../view/DashBoardForm.fxml");
        Parent root = FXMLLoader.load(resource);
        Scene scene = new Scene(root);
        Stage primaryStage = (Stage) (this.rootContext.getScene().getWindow());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Sipsewana Institute | MINDARTLK Creations");
        primaryStage.centerOnScreen();
        primaryStage.setFullScreen(false);
        primaryStage.setResizable(false);
        Platform.runLater(() -> primaryStage.sizeToScene());
    }

    public void addStudentOnAction(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/SaveStudentForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Stage stage = new Stage();
        stage.setScene(new Scene(load));
        stage.setTitle("Student Form | Sipsewana institute");
        stage.show();
    }
}
