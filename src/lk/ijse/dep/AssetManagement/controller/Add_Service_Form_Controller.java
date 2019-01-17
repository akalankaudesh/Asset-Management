package lk.ijse.dep.AssetManagement.controller;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import lk.ijse.dep.AssetManagement.business.BOFactory;
import lk.ijse.dep.AssetManagement.business.custom.ManageServicesBO;
import lk.ijse.dep.AssetManagement.dto.ServicesDTO;
import lk.ijse.dep.AssetManagement.view.effects.Image_Effect;

import java.io.IOException;
import java.sql.Date;

public class Add_Service_Form_Controller {
    public JFXTextField txtassetid;
    public JFXTextField txtdescription;
    public JFXTextField txtassetname;
    public JFXTextField txtcost;
    public JFXDatePicker dtpservicedate;
    public TableView tblassdservices;

    Image_Effect effect=new Image_Effect();

    private ManageServicesBO servicesBO= BOFactory.getInstance().getBO(BOFactory.BOtypes.MANAGE_SERVICES);

    public void gotohome(MouseEvent mouseEvent) throws IOException {
        Parent load = FXMLLoader.load(this.getClass().getResource("/lk/ijse/dep/AssetManagement/view/MainViewForm.fxml"));
        Scene scene=new Scene(load);
        Stage stage= (Stage) tblassdservices.getScene().getWindow();
        stage.setScene(scene);
    }

    public void saveondb(ActionEvent actionEvent) throws Exception {
        if (txtassetid.getText().trim().isEmpty()){
            new Alert(Alert.AlertType.ERROR,"Cannot have empty fields", ButtonType.OK).showAndWait();
            txtassetid.requestFocus();
            return;
        }
        if (txtcost.getText().trim().isEmpty()){
            new Alert(Alert.AlertType.ERROR,"Cannot have empty fields", ButtonType.OK).showAndWait();
            txtcost.requestFocus();
            return;
        }
//        if (!dtpservicedate.isPressed()){
//            new Alert(Alert.AlertType.ERROR,"Cannot have empty fields", ButtonType.OK).showAndWait();
//            dtpservicedate.requestFocus();
//            return;
//        }

        ServicesDTO newservice = new ServicesDTO(Integer.parseInt(txtassetid.getText()),txtdescription.getText(), Date.valueOf(dtpservicedate.getValue()), Double.parseDouble(txtcost.getText()));
        boolean service = servicesBO.createService(newservice);
        if (!service){new Alert(Alert.AlertType.ERROR,"Unable to Save", ButtonType.OK).showAndWait();
        }else {new Alert(Alert.AlertType.INFORMATION,"Service Saved", ButtonType.OK).showAndWait();
            Parent load = FXMLLoader.load(this.getClass().getResource("/lk/ijse/dep/AssetManagement/view/Service_Form.fxml"));
            Scene scene=new Scene(load);
            Stage stage= (Stage) tblassdservices.getScene().getWindow();
            stage.setScene(scene);
        }
    }

    public void Start(MouseEvent mouseEvent) {effect.start(mouseEvent); }

    public void End(MouseEvent mouseEvent) {effect.end(mouseEvent); }

    public void clearcontent(ActionEvent actionEvent) {
        txtassetid.clear();
        txtassetname.clear();
        txtdescription.clear();
        txtcost.clear();
    }

    public void gotoback(ActionEvent actionEvent) throws IOException {
        Parent load = FXMLLoader.load(this.getClass().getResource("/lk/ijse/dep/AssetManagement/view/Service_Form.fxml"));
        Scene scene=new Scene(load);
        Stage stage= (Stage) tblassdservices.getScene().getWindow();
        stage.setScene(scene);
    }
}
