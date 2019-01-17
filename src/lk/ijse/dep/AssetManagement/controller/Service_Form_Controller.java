package lk.ijse.dep.AssetManagement.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import lk.ijse.dep.AssetManagement.business.BOFactory;
import lk.ijse.dep.AssetManagement.business.custom.ManageServicesBO;
import lk.ijse.dep.AssetManagement.dto.ServicesDTO;
import lk.ijse.dep.AssetManagement.view.effects.Image_Effect;

import java.io.IOException;
import java.util.Optional;

public class Service_Form_Controller {
    public TableView <ServicesDTO>tblallservices;
    public JFXTextField txtsearchservices;
    public ImageView imgsearch;
    public JFXButton btnaddnewservice;
    public JFXButton btnviewreport;
    public JFXButton btndeleteservice;

    Image_Effect imageEffect=new Image_Effect();
    ManageServicesBO servicesBO= BOFactory.getInstance().getBO(BOFactory.BOtypes.MANAGE_SERVICES);

    public void initialize() throws Exception {
        tblallservices.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("service_id"));
        tblallservices.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("asset_id"));
        tblallservices.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("service_description"));
        tblallservices.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("service_cost"));
        tblallservices.getItems().setAll(servicesBO.getService());

        tblallservices.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<ServicesDTO>() {
            @Override
            public void changed(ObservableValue<? extends ServicesDTO> observable, ServicesDTO oldValue, ServicesDTO newValue) {
                if (newValue==null){return;}else {
                    btndeleteservice.setDisable(false);
                    btnviewreport.setDisable(false);
                }
            }
        });
    }

    public void gotohome(MouseEvent mouseEvent) throws IOException {
        Parent load = FXMLLoader.load(this.getClass().getResource("/lk/ijse/dep/AssetManagement/view/MainViewForm.fxml"));
        Scene scene=new Scene(load);
        Stage stage= (Stage) btnaddnewservice.getScene().getWindow();
        stage.setScene(scene);
    }

    public void Start(MouseEvent mouseEvent) {imageEffect.start(mouseEvent); }

    public void End(MouseEvent mouseEvent) {imageEffect.end(mouseEvent); }

    public void searchservice(MouseEvent mouseEvent) {

    }

    public void viewreport(ActionEvent actionEvent) {

    }

    public void deleterecord(ActionEvent actionEvent) throws Exception {

        Alert asd=new Alert(Alert.AlertType.CONFIRMATION,"Are You sure Want to Delete", ButtonType.OK,ButtonType.CANCEL);
        Optional<ButtonType> buttonType = asd.showAndWait();
        if (buttonType.get()==ButtonType.OK){
        int x=tblallservices.getSelectionModel().selectedItemProperty().get().getAsset_id();
        servicesBO.deleteService(x);
        btndeleteservice.setDisable(true);
        btnaddnewservice.setDisable(true);
        tblallservices.getSelectionModel().clearSelection();
        tblallservices.getItems().setAll(servicesBO.getService());
        }

    }

    public void gotoaddservice(ActionEvent actionEvent) throws IOException {
        Parent load = FXMLLoader.load(this.getClass().getResource("/lk/ijse/dep/AssetManagement/view/Add_Service_Form.fxml"));
        Scene scene=new Scene(load);
        Stage stage= (Stage) btnaddnewservice.getScene().getWindow();
        stage.setScene(scene);

    }
}
