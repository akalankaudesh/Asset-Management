package lk.ijse.dep.AssetManagement.controller;

import javafx.animation.ScaleTransition;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.effect.DropShadow;
import lk.ijse.dep.AssetManagement.view.effects.Image_Effect;

import java.awt.*;
import java.io.IOException;

public class MainViewFormController {
    public Text lblguide;
    public ImageView imgemployee;
    public ImageView imgasset;
    public ImageView imgdepartment;
    public ImageView imgservices;
    public ImageView imgvendors;

    Image_Effect t=new Image_Effect();

    public void gotoemployee(MouseEvent mouseEvent) throws IOException {
        Parent load = FXMLLoader.load(this.getClass().getResource("/lk/ijse/dep/AssetManagement/view/Main_Employee_Form.fxml"));
        Scene sc=new Scene(load);
        Stage stage= (Stage) imgasset.getScene().getWindow();
        stage.setScene(sc);
    }

    public void Start(MouseEvent mouseEvent) {
        ImageView source = (ImageView) mouseEvent.getSource();
        switch(source.getId()){
            case "imgasset":

                lblguide.setText("Click to add, update, delete, search or view assets");
                break;
            case "imgemployee":

                lblguide.setText("Click to add, update, delete, search or view employees");
                break;
            case "imgdepartment":

                lblguide.setText("Click to add, update, delete, search or view departments");
                break;
            case "imgservices":

                lblguide.setText("Click to add, update, delete, search or view services");
                break;
            case "imgvendors":

                lblguide.setText("Click to add, update, delete, search or view vendors");
                break;
        }
        t.start1(mouseEvent);

    }
    public void End(MouseEvent mouseEvent) {
        t.end1(mouseEvent);
        lblguide.setText("Please select any options");
    }

    public void gotoassets(MouseEvent mouseEvent) throws IOException {
        Parent load = FXMLLoader.load(this.getClass().getResource("/lk/ijse/dep/AssetManagement/view/AssetForm.fxml"));
        Scene sc=new Scene(load);
        Stage stage= (Stage) imgasset.getScene().getWindow();
        stage.setScene(sc);
    }

    public void gotodepartment(MouseEvent mouseEvent) throws IOException {
        Parent parent=FXMLLoader.load(this.getClass().getResource("/lk/ijse/dep/AssetManagement/view/Department_Form.fxml"));
        Scene sc=new Scene(parent);
        Stage st= (Stage) imgasset.getScene().getWindow();
        st.setScene(sc);
    }

    public void gotoservices(MouseEvent mouseEvent) throws IOException {
        Parent form=FXMLLoader.load(this.getClass().getResource("/lk/ijse/dep/AssetManagement/view/Service_Form.fxml"));
        Scene scene=new Scene(form);
        Stage asd= (Stage) imgasset.getScene().getWindow();
        asd.setScene(scene);
    }

    public void gotovendors(MouseEvent mouseEvent) throws IOException {
        Parent parent=FXMLLoader.load(this.getClass().getResource("/lk/ijse/dep/AssetManagement/view/Vendor_Form.fxml"));
        Scene sc=new Scene(parent);
        Stage stage= (Stage) imgasset.getScene().getWindow();
        stage.setScene(sc);
    }


}
