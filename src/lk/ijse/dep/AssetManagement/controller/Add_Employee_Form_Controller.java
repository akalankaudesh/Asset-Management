package lk.ijse.dep.AssetManagement.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class Add_Employee_Form_Controller {
    public JFXTextField txtempname;
    public JFXTextField txtempaddress;
    public JFXTextField txttelephone;
    public JFXTextField txtsalary;
    public JFXButton btnsave;
    public JFXComboBox cboempdepartment;

    public void gotohome(MouseEvent mouseEvent) throws IOException {
        Parent load = FXMLLoader.load(this.getClass().getResource("/lk/ijse/dep/AssetManagement/view/MainViewForm.fxml"));
        Scene scene=new Scene(load);
        Stage stage= (Stage) btnsave.getScene().getWindow();
        stage.setScene(scene);
    }

    public void savetheemployee(ActionEvent actionEvent) {
    }

    public void Start(MouseEvent mouseEvent) {
    }

    public void End(MouseEvent mouseEvent) {
    }

    public void clearcontent(ActionEvent actionEvent) {
    }

    public void gotoback(ActionEvent actionEvent) throws IOException {
        Parent load = FXMLLoader.load(this.getClass().getResource("/lk/ijse/dep/AssetManagement/view/Main_Employee_Form.fxml"));
        Scene scene=new Scene(load);
        Stage stage= (Stage) btnsave.getScene().getWindow();
        stage.setScene(scene);
    }
}
