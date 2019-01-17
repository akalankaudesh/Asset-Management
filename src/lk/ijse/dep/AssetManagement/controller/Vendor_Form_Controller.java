package lk.ijse.dep.AssetManagement.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import lk.ijse.dep.AssetManagement.business.BOFactory;
import lk.ijse.dep.AssetManagement.business.custom.ManageVendorsBO;
import lk.ijse.dep.AssetManagement.dto.VendorDTO;
import lk.ijse.dep.AssetManagement.view.effects.Image_Effect;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class Vendor_Form_Controller {
    public TableView <VendorDTO> tblallvendors;
    public JFXTextField txtvendorid;
    public JFXTextField txtvendortelephone;
    public JFXTextField txtvendorname;
    public JFXTextField txtemail;
    public JFXButton btnsave;
    public JFXTextField txtsearchvendor;
    public JFXButton btndelete;
    public JFXButton btnnew;

    private ManageVendorsBO vendor=BOFactory.getInstance().getBO(BOFactory.BOtypes.MANAGE_VENDORS);

    public void initialize() throws Exception {
        tblallvendors.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("vendor_id"));
        tblallvendors.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("vendor_name"));
        tblallvendors.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("vendor_telephone"));
        tblallvendors.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("vendor_email"));
        tblallvendors.getItems().setAll(vendor.getVendors());

        tblallvendors.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<VendorDTO>() {
            @Override
            public void changed(ObservableValue<? extends VendorDTO> observable, VendorDTO oldValue, VendorDTO newValue) {

                if (newValue ==null){return;}else {
                txtvendorid.setText(newValue.getVendor_id());
                txtvendorname.setText(newValue.getVendor_name());
                txtvendortelephone.setText(newValue.getVendor_telephone());
                txtemail.setText(newValue.getVendor_email());
                enabled();
                }
            }
        });
    }


    Image_Effect imageEffect=new Image_Effect();

    public void gotohome(MouseEvent mouseEvent) throws IOException {
        Parent load = FXMLLoader.load(this.getClass().getResource("/lk/ijse/dep/AssetManagement/view/MainViewForm.fxml"));
        Scene scene=new Scene(load);
        Stage stage= (Stage) btnsave.getScene().getWindow();
        stage.setScene(scene);
    }

    public void Start(MouseEvent mouseEvent) { imageEffect.start(mouseEvent); }

    public void End(MouseEvent mouseEvent) {imageEffect.end(mouseEvent); }

    public void savevendor(ActionEvent actionEvent) throws Exception {

        if (txtvendorid.getText().trim().isEmpty()){
            new Alert(Alert.AlertType.ERROR, "Cannot have Empty Fields", ButtonType.OK).show();
            txtvendorid.requestFocus();
            return;
        }
        if (txtvendorname.getText().trim().isEmpty()){
            new Alert(Alert.AlertType.ERROR, "Cannot have Empty Fields", ButtonType.OK).show();
            txtvendorname.requestFocus();
            return;
        }
        if (txtemail.getText().trim().isEmpty()){
            new Alert(Alert.AlertType.ERROR, "Cannot have Empty Fields", ButtonType.OK).show();
            txtemail.requestFocus();
            return;
        }
        if (txtvendortelephone.getText().trim().isEmpty()){
            new Alert(Alert.AlertType.ERROR, "Cannot have Empty Fields", ButtonType.OK).show();
            txtvendortelephone.requestFocus();
            return;
        }


        if (!(txtvendorid.isDisable())) {
            ObservableList<VendorDTO> vendorbto=tblallvendors.getItems();
            for (VendorDTO vendorDTO:vendorbto) {
                if (txtvendorid.getText().equals(vendorDTO.getVendor_id())){
                    new Alert(Alert.AlertType.ERROR, "Cannot have same Vendor id's", ButtonType.OK).show();
                    txtvendorid.requestFocus();
                    return;
                }
            }
            boolean res = this.vendor.createVendor(new VendorDTO(txtvendorid.getText(), txtvendorname.getText(), txtvendortelephone.getText(), txtemail.getText()));
            if (!res) {
                new Alert(Alert.AlertType.ERROR, "Unable to Save Vendor", ButtonType.OK).show();
                txtvendorid.requestFocus();
            } else {
                new Alert(Alert.AlertType.INFORMATION, "Vendor Added", ButtonType.OK).showAndWait();
                reset();
            }
        }else {
            boolean result = this.vendor.updateVendor(new VendorDTO(txtvendorid.getText(), txtvendorname.getText(), txtvendortelephone.getText(), txtemail.getText()));
            if (!result) {
                new Alert(Alert.AlertType.ERROR, "Unable to Update Vendor", ButtonType.OK).show();
            } else {
                new Alert(Alert.AlertType.INFORMATION, "Vendor Updated", ButtonType.OK).show();
                reset();
            }
        }

    }

    public void deleteondb(ActionEvent actionEvent) throws Exception {
        Alert msg=new Alert(Alert.AlertType.CONFIRMATION,"Are You sure Want to Delete ?",ButtonType.OK,ButtonType.CANCEL);
        Optional<ButtonType> asd= msg.showAndWait();
        if (asd.get()==ButtonType.OK) {
            boolean b = vendor.deleteVendor(txtvendorid.getText());
            if (!b){ new Alert(Alert.AlertType.ERROR, "Unable to Delete Vendor", ButtonType.OK).show();}else {
            reset();}
        }
    }

    public void Searchvendors(MouseEvent mouseEvent) throws Exception {
        VendorDTO vendor = this.vendor.findVendor(txtsearchvendor.getText());
        if(vendor==null){new Alert(Alert.AlertType.ERROR,"Unable to Find Vendor",ButtonType.OK).show();
            txtsearchvendor.requestFocus();
            return;
        }
        else {
            txtvendorid.setText(vendor.getVendor_id());
            txtvendorname.setText(vendor.getVendor_name());
            txtvendortelephone.setText(vendor.getVendor_telephone());
            txtemail.setText(vendor.getVendor_email());
            enabled();

        }
    }

    public void enabledvendor(ActionEvent actionEvent) throws Exception {
        reset();
        enabled();
        txtvendorid.setDisable(false);
        btndelete.setDisable(true);
    }

    public void reset() throws Exception {
        txtvendorid.clear();
        txtsearchvendor.clear();
        txtvendorname.clear();
        txtvendortelephone.clear();
        txtemail.clear();
        tblallvendors.getSelectionModel().clearSelection();
        tblallvendors.getItems().setAll(vendor.getVendors());
        txtvendorid.setDisable(true);
        txtvendorname.setDisable(true);
        txtvendorname.setDisable(true);
        txtvendortelephone.setDisable(true);
        txtemail.setDisable(true);
        btnsave.setDisable(true);
        btndelete.setDisable(true);

    }

    public void enabled(){
        txtvendorid.setDisable(true);
        txtvendorname.setDisable(false);
        txtvendorname.setDisable(false);
        txtvendortelephone.setDisable(false);
        txtemail.setDisable(false);
        btnsave.setDisable(false);
        btndelete.setDisable(false);
    }

    public void searchvendor(KeyEvent keyEvent) throws Exception {
        ObservableList<VendorDTO> temp= FXCollections.observableArrayList();
        for (VendorDTO asd:vendor.getVendors()) {
           if (asd.getVendor_id().startsWith(txtsearchvendor.getText())){
            temp.add((asd));
            }
        }
       tblallvendors.setItems(temp);
    }

}
