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
import lk.ijse.dep.AssetManagement.business.custom.ManageAssetTypeBO;
import lk.ijse.dep.AssetManagement.dto.AssetTypeDTO;
import lk.ijse.dep.AssetManagement.view.effects.Image_Effect;

import java.io.IOException;
import java.util.Optional;

public class Asset_Type_Form_Controller {
    public JFXButton btnsave;
    public JFXTextField txtassettypeid;
    public JFXTextField txtsearchdepartment;
    public JFXTextField txtassettypename;
    public JFXTextField txtassetdescription;
    public TableView <AssetTypeDTO> tblalltypes;
    public JFXButton btndelete;
    public JFXButton btnnewdepartment;

    Image_Effect effect=new Image_Effect();

public void reset() throws Exception {

    txtassettypeid.clear();
    txtassettypename.clear();
    txtassetdescription.clear();
    btnsave.setDisable(true);
    btndelete.setDisable(true);
    tblalltypes.getSelectionModel().clearSelection();
    txtsearchdepartment.clear();
    btnnewdepartment.requestFocus();
    tblalltypes.refresh();
    tblalltypes.getItems().setAll(manageAssetTypeBO.getTypes());

}

    private ManageAssetTypeBO manageAssetTypeBO=BOFactory.getInstance().getBO(BOFactory.BOtypes.MANAGE_ASSET_TYPES);


    public void initialize() throws Exception {

        tblalltypes.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("type_id"));
        tblalltypes.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("type_name"));
        tblalltypes.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("type_description"));

        tblalltypes.getItems().setAll(manageAssetTypeBO.getTypes());

        tblalltypes.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<AssetTypeDTO>() {
            @Override
            public void changed(ObservableValue<? extends AssetTypeDTO> observable, AssetTypeDTO oldValue, AssetTypeDTO newValue) {
                if (newValue ==null){
                    return;
                }

                txtassettypeid.setText(newValue.getType_id());
                txtassettypename.setText(newValue.getType_name());
                txtassetdescription.setText(newValue.getType_description());
                txtassettypeid.setDisable(true);
                txtassettypename.setDisable(false);
                txtassetdescription.setDisable(false);
                btnsave.setDisable(false);
                btndelete.setDisable(false);
            }
        });

    }

    public void saveassettype(ActionEvent actionEvent) throws Exception {

        String x="Cannot Have Empty Fields";
        if (txtassettypeid.getText().trim().isEmpty()){
            new Alert(Alert.AlertType.ERROR,x,ButtonType.OK).show();
            txtassettypeid.requestFocus();
            return;
        }
        if (txtassettypename.getText().trim().isEmpty()){
            new Alert(Alert.AlertType.ERROR,x,ButtonType.OK).show();
            txtassettypename.requestFocus();
            return;
        }
        if (txtassetdescription.getText().trim().isEmpty()){
            new Alert(Alert.AlertType.ERROR,x,ButtonType.OK).show();
            txtassetdescription.requestFocus();
            return;
        }

        if (!(txtassettypeid.isDisable())) {

            ObservableList<AssetTypeDTO> items = tblalltypes.getItems();
            for (AssetTypeDTO assettypes:items) {
                if (assettypes.getType_id().equals(txtassettypeid.getText())){
                    new Alert(Alert.AlertType.ERROR,"Cannot Have Duplicate IDS",ButtonType.OK).show();
                    txtassettypeid.requestFocus();
                    return;
                }
            }

            AssetTypeDTO newassettype = new AssetTypeDTO(txtassettypeid.getText(), txtassettypename.getText(), txtassetdescription.getText());
            boolean res = manageAssetTypeBO.createAssetType(newassettype);
            if (res == true) {
                new Alert(Alert.AlertType.CONFIRMATION, "Added Successfully", ButtonType.OK).showAndWait();
                tblalltypes.scrollTo(newassettype);

            } else {
                new Alert(Alert.AlertType.ERROR, "Unable to Add", ButtonType.OK).show();

            }
        }else {
            AssetTypeDTO selectedItems =  tblalltypes.getSelectionModel().getSelectedItem();
            selectedItems.setType_name(txtassettypename.getText());
            selectedItems.setType_description(txtassetdescription.getText());
            AssetTypeDTO newassettype = new AssetTypeDTO(txtassettypeid.getText(), txtassettypename.getText(), txtassetdescription.getText());
            boolean b = manageAssetTypeBO.updateAssetType(newassettype);
           tblalltypes.refresh();
            if (b == true) {
                new Alert(Alert.AlertType.CONFIRMATION, "Update Successfully", ButtonType.OK).showAndWait();
                tblalltypes.scrollTo(newassettype);
            } else {
                new Alert(Alert.AlertType.ERROR, "Unable to Update", ButtonType.OK).show();
            }
        }
        reset();
    }


    public void enabled(ActionEvent actionEvent) throws Exception {
        reset();
        btnsave.setDisable(false);
        txtassettypeid.setDisable(false);
        txtassettypename.setDisable(false);
        txtassetdescription.setDisable(false);
    }

    public void gotohome(MouseEvent mouseEvent) throws IOException {
        Parent load = FXMLLoader.load(this.getClass().getResource("/lk/ijse/dep/AssetManagement/view/AssetForm.fxml"));
        Scene scene=new Scene(load);
        Stage stage= (Stage) btnsave.getScene().getWindow();
        stage.setScene(scene);
    }

    public void Start(MouseEvent mouseEvent) { effect.start(mouseEvent); }

    public void End(MouseEvent mouseEvent) {effect.end(mouseEvent); }

    public void searchassettypes(MouseEvent mouseEvent) throws Exception {
        AssetTypeDTO assetType = manageAssetTypeBO.findAssetType(txtsearchdepartment.getText());
        if (assetType==null){
           new Alert(Alert.AlertType.ERROR,"Unable to Find the Asset Type",ButtonType.OK).show();
           txtsearchdepartment.requestFocus();
           return;
        }else {
            txtassettypeid.setText(assetType.getType_id());
            txtassettypename.setText(assetType.getType_name());
            txtassetdescription.setText(assetType.getType_description());
            tblalltypes.getSelectionModel().select(assetType);
            txtassettypeid.setDisable(true);
            txtassettypename.setDisable(false);
            txtassetdescription.setDisable(false);
            btnsave.setDisable(false);
            btndelete.setDisable(false);
        }


    }

    public void deletetypes(ActionEvent actionEvent) throws Exception {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Are You Sure Want to Delete this Type ?", ButtonType.OK,ButtonType.CANCEL);
        Optional<ButtonType> msg = alert.showAndWait();
        if (msg.get() == ButtonType.OK){
        boolean b = manageAssetTypeBO.deleteAssetType(txtassettypeid.getText());
        if (!b){
            new Alert(Alert.AlertType.ERROR,"Type Unable to Delete",ButtonType.OK).show();
        }else {
            reset();
        }
        }
    }

    public void typesearching(KeyEvent keyEvent) throws Exception {
        ObservableList<AssetTypeDTO> temp= FXCollections.observableArrayList();
        for (AssetTypeDTO typeDTO: manageAssetTypeBO.getTypes()) {
            if (typeDTO.getType_id().startsWith(txtsearchdepartment.getText())){
                temp.add(typeDTO);
            }
        }
        tblalltypes.setItems(temp);

    }


}
