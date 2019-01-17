package lk.ijse.dep.AssetManagement.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import lk.ijse.dep.AssetManagement.view.effects.Image_Effect;

import java.io.IOException;

public class Main_Employee_Form_Controller {
    public TableView tblallemployee;
    public ImageView imghome;
    public JFXTextField txtsearchemployee;

    Image_Effect effect=new Image_Effect();

    public void gotohome(MouseEvent mouseEvent) throws IOException {
        Parent load = FXMLLoader.load(this.getClass().getResource("/lk/ijse/dep/AssetManagement/view/MainViewForm.fxml"));
        Scene scene=new Scene(load);
        Stage stage= (Stage) imghome.getScene().getWindow();
        stage.setScene(scene);
    }

    public void gotonewemployee(ActionEvent actionEvent) throws IOException {
        Parent load = FXMLLoader.load(this.getClass().getResource("/lk/ijse/dep/AssetManagement/view/Add_Employee_Form.fxml"));
        Scene scene=new Scene(load);
        Stage stage= (Stage) imghome.getScene().getWindow();
        stage.setScene(scene);
    }

    public void deleteemployee(ActionEvent actionEvent) {
    }

    public void searchemployee(MouseEvent mouseEvent) {
    }

    public void Start(MouseEvent mouseEvent) { effect.start(mouseEvent); }

    public void End(MouseEvent mouseEvent) { effect.end(mouseEvent); }

    public void vewasreport(ActionEvent actionEvent) {
    }
}
