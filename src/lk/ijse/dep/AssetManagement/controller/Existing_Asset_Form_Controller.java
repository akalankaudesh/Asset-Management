package lk.ijse.dep.AssetManagement.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Existing_Asset_Form_Controller {
    public JFXButton btnback;
    public JFXTextField txtdescripption;
    public JFXTextField txtmodel;
    public JFXTextField txtbrand;
    public JFXTextField txtprice;
    public JFXButton btnupdate;
    public JFXComboBox cbodepartment;
    public JFXComboBox cbovendor;
    public JFXComboBox cboassettype;
    public JFXDatePicker dtpdateselect;

    public void gtotoback(ActionEvent actionEvent) throws IOException {
        Parent load = FXMLLoader.load(this.getClass().getResource("/lk/ijse/dep/AssetManagement/view/AssetForm.fxml"));
        Scene scene=new Scene(load);
        Stage stage= (Stage) btnback.getScene().getWindow();
        stage.setScene(scene);
    }

    public void updatethedb(ActionEvent actionEvent) {
    }

    public void clearcontent(ActionEvent actionEvent) {
    }
}
