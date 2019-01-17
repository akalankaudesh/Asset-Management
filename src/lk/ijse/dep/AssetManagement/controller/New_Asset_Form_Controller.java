package lk.ijse.dep.AssetManagement.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import lk.ijse.dep.AssetManagement.business.BOFactory;
import lk.ijse.dep.AssetManagement.business.custom.ManageAssetBO;
import lk.ijse.dep.AssetManagement.business.custom.ManageAssetTypeBO;
import lk.ijse.dep.AssetManagement.business.custom.ManageDepartmentBO;
import lk.ijse.dep.AssetManagement.business.custom.ManageVendorsBO;
import lk.ijse.dep.AssetManagement.dto.AddAssetDTO;
import lk.ijse.dep.AssetManagement.dto.AssetTypeDTO;
import lk.ijse.dep.AssetManagement.dto.DepatmentDTO;
import lk.ijse.dep.AssetManagement.dto.VendorDTO;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class New_Asset_Form_Controller {
    public JFXButton btnback;
    public JFXTextField txtassettype;
    public JFXTextField txtdescription;
    public JFXTextField txtmodel;
    public JFXTextField txtbrand;
    public JFXTextField txtprice;
    public JFXComboBox cbodepartment;
    public JFXComboBox cbovendor;
    public JFXDatePicker dtpdateselect;
    public JFXComboBox cboassettype;

    private ManageDepartmentBO departmentBO= BOFactory.getInstance().getBO(BOFactory.BOtypes.MANAGE_DEPARTMENTS);
    private ManageAssetTypeBO assetTypeBO=BOFactory.getInstance().getBO(BOFactory.BOtypes.MANAGE_ASSET_TYPES);
    private ManageVendorsBO vendorsBO=BOFactory.getInstance().getBO(BOFactory.BOtypes.MANAGE_VENDORS);
    private ManageAssetBO addAsset=BOFactory.getInstance().getBO(BOFactory.BOtypes.MANAGE_ASSETS);

    List<DepatmentDTO> dep;
    List<AssetTypeDTO> assettypes;
    List<VendorDTO> venders;

    public void initialize() throws Exception {

        List tempvendor=new ArrayList();
        List tempdep=new ArrayList();
        List tempassettype=new ArrayList();
        this.dep = departmentBO.getDepartments();
        this.assettypes = assetTypeBO.getTypes();
        this.venders=vendorsBO.getVendors();

        for (AssetTypeDTO assetTypeDTO:assettypes) {
            tempassettype.add(assetTypeDTO.getType_name());
        }
        cboassettype.getItems().setAll(tempassettype);

        for (DepatmentDTO dto:dep) {
            tempdep.add(dto.getDep_name());
        }
        cbodepartment.getItems().setAll(tempdep);

        for (VendorDTO asdf:venders) {
            tempvendor.add(asdf.getVendor_name());
        }
        cbovendor.getItems().setAll(tempvendor);
    }

    public void gotoback(ActionEvent actionEvent) throws IOException {

        Parent load = FXMLLoader.load(this.getClass().getResource("/lk/ijse/dep/AssetManagement/view/AssetForm.fxml"));
        Scene scene=new Scene(load);
        Stage stage= (Stage) btnback.getScene().getWindow();
        stage.setScene(scene);
    }

    public void saveasset(ActionEvent actionEvent) throws Exception {
        if (cboassettype.getSelectionModel().isEmpty()){
            new Alert(Alert.AlertType.ERROR,"Cannot Have Empty Fields",ButtonType.OK).show();
            return;
        }
        if (cbovendor.getSelectionModel().isEmpty()){
            new Alert(Alert.AlertType.ERROR,"Cannot Have Empty Fields",ButtonType.OK).show();
            return;
        }
        if (cbodepartment.getSelectionModel().isEmpty()){
            new Alert(Alert.AlertType.ERROR,"Cannot Have Empty Fields",ButtonType.OK).show();
            return;
        }
        if (txtdescription.getText().trim().isEmpty()){
            new Alert(Alert.AlertType.ERROR,"Cannot Have Empty Fields",ButtonType.OK).show();
            return;
        }
        if (txtprice.getText().trim().isEmpty()){
            new Alert(Alert.AlertType.ERROR,"Cannot Have Empty Fields",ButtonType.OK).show();
            return;
        }

        String type="";
        String department="";
        String vendor="";
        for (AssetTypeDTO typeDTO:assettypes) {
            if (cboassettype.getSelectionModel().getSelectedItem().equals(typeDTO.getType_name())){
                type=typeDTO.getType_id();
            }
        }
        for (DepatmentDTO depatment:dep) {
            if (cbodepartment.getSelectionModel().getSelectedItem().equals(depatment.getDep_name())){
                department=depatment.getDep_id();
            }
        }
        for (VendorDTO ven:venders) {
            if (cbovendor.getSelectionModel().getSelectedItem().equals(ven.getVendor_name())){
                vendor=ven.getVendor_id();
            }
        }


        AddAssetDTO newasset = new AddAssetDTO(type, txtdescription.getText(), department, vendor, txtmodel.getText(), txtbrand.getText(), Double.parseDouble(txtprice.getText()), Date.valueOf(dtpdateselect.getValue()));
        boolean asset = addAsset.createAsset(newasset);
        if (!asset){
            new Alert(Alert.AlertType.ERROR,"Unable to Save", ButtonType.OK).showAndWait();
        }else {
            new Alert(Alert.AlertType.INFORMATION,"Asset Saved", ButtonType.OK).showAndWait();
            Parent load = FXMLLoader.load(this.getClass().getResource("/lk/ijse/dep/AssetManagement/view/AssetForm.fxml"));
            Scene scene=new Scene(load);
            Stage stage= (Stage) btnback.getScene().getWindow();
            stage.setScene(scene);
        }


    }

    public void clearcontent(ActionEvent actionEvent) {
        cboassettype.getSelectionModel().clearSelection();
        cbodepartment.getSelectionModel().clearSelection();
        cbovendor.getSelectionModel().clearSelection();
        txtdescription.clear();
        txtprice.clear();
        txtbrand.clear();
        txtmodel.clear();
    }
}
