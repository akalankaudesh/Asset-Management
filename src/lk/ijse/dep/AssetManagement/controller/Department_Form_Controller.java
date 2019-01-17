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
import lk.ijse.dep.AssetManagement.business.custom.ManageDepartmentBO;
import lk.ijse.dep.AssetManagement.dto.DepatmentDTO;
import lk.ijse.dep.AssetManagement.view.effects.Image_Effect;

import java.io.IOException;
import java.util.Optional;

public class Department_Form_Controller {
    public JFXButton btnsave;
    public JFXTextField txtdepname;
    public JFXTextField txtdepdescription;
    public JFXButton btnclear;
    public JFXTextField txtdepartmentid;
    public JFXTextField txtsearchdepartment;
    public TableView <DepatmentDTO> tblalldepartments;
    public JFXButton btnnewdepartment;

    private ManageDepartmentBO departmentBO=BOFactory.getInstance().getBO(BOFactory.BOtypes.MANAGE_DEPARTMENTS);

    Image_Effect effect=new Image_Effect();

    public void clear(){
        txtdepartmentid.clear();
        txtdepname.clear();
        txtdepdescription.clear();
        txtsearchdepartment.clear();
    }

    public void reset() throws Exception {
        btnsave.setDisable(true);
        btnclear.setDisable(true);
        txtdepartmentid.setDisable(true);
        tblalldepartments.getSelectionModel().clearSelection();
        tblalldepartments.getItems().setAll(departmentBO.getDepartments());
        clear();
        btnnewdepartment.requestFocus();
    }

    public void initialize() throws Exception {

        tblalldepartments.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("dep_id"));
        tblalldepartments.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("dep_name"));
        tblalldepartments.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("dep_description"));
        tblalldepartments.getItems().setAll(departmentBO.getDepartments());
        btnnewdepartment.requestFocus();

        tblalldepartments.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<DepatmentDTO>() {
            @Override
            public void changed(ObservableValue<? extends DepatmentDTO> observable, DepatmentDTO oldValue, DepatmentDTO asd) {
                if (asd==null){return;}else {
                    txtdepartmentid.setText(asd.getDep_id());
                    txtdepname.setText(asd.getDep_name());
                    txtdepdescription.setText(asd.getDep_description());
                    txtdepartmentid.setDisable(true);
                    btnsave.setDisable(false);
                    btnclear.setDisable(false);
                }
            }
        });
    }

    public void savedepatment(ActionEvent actionEvent) throws Exception {

        if (txtdepartmentid.getText().trim().isEmpty()){
            new Alert(Alert.AlertType.ERROR, "Cannot have Empty Fields").showAndWait();
            txtdepartmentid.requestFocus();
            return;
        }
        if (txtdepname.getText().trim().isEmpty()){
            new Alert(Alert.AlertType.ERROR, "Cannot have Empty Fields").showAndWait();
            txtdepname.requestFocus();
            return;
        }
        if (txtdepdescription.getText().trim().isEmpty()){
            new Alert(Alert.AlertType.ERROR, "Cannot have Empty Fields").showAndWait();
            txtdepdescription.requestFocus();
            return;
        }

        if (!(txtdepartmentid.isDisable())) {
            DepatmentDTO depatmentDTO = new DepatmentDTO(txtdepartmentid.getText(), txtdepname.getText(), txtdepdescription.getText());
            boolean department = departmentBO.createDepartment(depatmentDTO);
            if (!department) {
                new Alert(Alert.AlertType.ERROR, "Unable To Save Department").showAndWait();
            } else {
                new Alert(Alert.AlertType.INFORMATION, "Department Saved").showAndWait();
                reset();
                tblalldepartments.scrollTo(depatmentDTO);
            }
        }
        else {
            DepatmentDTO update = new DepatmentDTO(txtdepartmentid.getText(), txtdepname.getText(), txtdepdescription.getText());
            boolean updateDepartment = departmentBO.updateDepartment(update);
            if (!updateDepartment){
                new Alert(Alert.AlertType.ERROR, "Unable To Update Department").showAndWait();
            }else {
                new Alert(Alert.AlertType.INFORMATION, "Department Update").showAndWait();
                reset();
                tblalldepartments.scrollTo(update);
            }
        }
    }

    public void clearcontent(ActionEvent actionEvent) throws Exception {
        Alert delete=new Alert(Alert.AlertType.CONFIRMATION,"Are You Sure Want to Delete", ButtonType.OK,ButtonType.CANCEL);
        Optional<ButtonType> type = delete.showAndWait();
        if (type.get()==ButtonType.OK){
        departmentBO.deleteDepartment(txtdepartmentid.getText());
        reset();
        }else { btnclear.requestFocus();}

    }

    public void enabled(ActionEvent actionEvent) throws Exception {
    reset();
    txtdepartmentid.setDisable(false);
    btnsave.setDisable(false);
    btnclear.setDisable(true);
    }

    public void gotohome(MouseEvent mouseEvent) throws IOException {
        Parent load = FXMLLoader.load(this.getClass().getResource("/lk/ijse/dep/AssetManagement/view/MainViewForm.fxml"));
        Scene scene=new Scene(load);
        Stage stage= (Stage) btnsave.getScene().getWindow();
        stage.setScene(scene);
    }

    public void Start(MouseEvent mouseEvent) { effect.start(mouseEvent); }

    public void End(MouseEvent mouseEvent) { effect.end(mouseEvent); }

    public void searchdepartment(MouseEvent mouseEvent) {

    }

    public void searchdepartments(KeyEvent keyEvent) throws Exception {
        ObservableList<DepatmentDTO> temp= FXCollections.observableArrayList();
        for (DepatmentDTO dep:departmentBO.getDepartments()) {
         if (dep.getDep_id().startsWith(txtsearchdepartment.getText())){
             temp.add(new DepatmentDTO(dep.getDep_id(),dep.getDep_name(),dep.getDep_description()));
         }
        }
        tblalldepartments.getItems().setAll(temp);
    }
}
