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
import lk.ijse.dep.AssetManagement.business.custom.ManageAssetBO;
import lk.ijse.dep.AssetManagement.dao.DAOFactory;
import lk.ijse.dep.AssetManagement.dao.custom.AssetDAO;
import lk.ijse.dep.AssetManagement.dao.custom.QueryDAO;
import lk.ijse.dep.AssetManagement.dbconnection.DBConnection;
import lk.ijse.dep.AssetManagement.dto.AddAssetDTO;
import lk.ijse.dep.AssetManagement.dto.AssetMainDTO;
import lk.ijse.dep.AssetManagement.view.effects.Image_Effect;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Asset_Form_Controller {
    public TableView<AssetMainDTO> tblallassets;
    public JFXTextField txtsearchasset;
    public JFXButton btndelete;
    public JFXButton btnviewreport;
    Image_Effect effect=new Image_Effect();

    private ManageAssetBO asset= BOFactory.getInstance().getBO(BOFactory.BOtypes.MANAGE_ASSETS);
    private QueryDAO dao= DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.QUERY);

    public void reset() throws Exception {
            tblallassets.getSelectionModel().clearSelection();
            tblallassets.getItems().setAll(dao.getdata_to_assetmain());
            btndelete.setDisable(true);
            btnviewreport.setDisable(true);
    }

    public void initialize() throws Exception {
        tblallassets.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("asset_id"));
        tblallassets.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("asset_type"));
        tblallassets.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("description"));
        tblallassets.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("department"));
        tblallassets.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("vendor"));
        tblallassets.getItems().setAll(dao.getdata_to_assetmain());

        tblallassets.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<AssetMainDTO>() {
            @Override
            public void changed(ObservableValue<? extends AssetMainDTO> observable, AssetMainDTO oldValue, AssetMainDTO newValue) {
                if (newValue == null){return;}else {
                btndelete.setDisable(false);
                btnviewreport.setDisable(false);
               }
            }
        });
    }

    public void searchassets(MouseEvent mouseEvent) {

    }

    public void Start(MouseEvent mouseEvent) {
        effect.start(mouseEvent);
    }

    public void End(MouseEvent mouseEvent) {
        effect.end(mouseEvent);
    }

    public void gotoaddassets(MouseEvent mouseEvent) throws IOException {
        Parent load = FXMLLoader.load(this.getClass().getResource("/lk/ijse/dep/AssetManagement/view/New_Asset_Form.fxml"));
        Scene scene=new Scene(load);
        Stage stage= (Stage) tblallassets.getScene().getWindow();
        stage.setScene(scene);
    }

    public void viewasreport(ActionEvent actionEvent) throws Exception {
        File file=new File("reports/Asset_Main.jasper");
        System.out.println(file.getAbsoluteFile());
        JasperReport compilereport= (JasperReport) JRLoader.loadObject(file);
        Map<String,Object> para=new HashMap<>();
        para.put("search",txtsearchasset.getText());
        JasperPrint filledreport= JasperFillManager.fillReport(compilereport,para, DBConnection.getInstance().getConnection());
        JasperViewer.viewReport(filledreport,false);

    }

    public void deleteasset(ActionEvent actionEvent) throws Exception {
        Alert delete=new Alert(Alert.AlertType.CONFIRMATION,"Are you sure Want to Delete", ButtonType.OK,ButtonType.CANCEL);
        Optional<ButtonType> type = delete.showAndWait();
        if (type.get()==ButtonType.OK) {
            int asset_id = tblallassets.getSelectionModel().selectedItemProperty().get().getAsset_id();
            asset.deleteAsset(asset_id);
            reset();
        }
    }

    public void gotohome(MouseEvent mouseEvent) throws IOException {
        Parent load = FXMLLoader.load(this.getClass().getResource("/lk/ijse/dep/AssetManagement/view/MainViewForm.fxml"));
        Scene scene=new Scene(load);
        Stage stage= (Stage) tblallassets.getScene().getWindow();
        stage.setScene(scene);
    }

    public void gotoassettypes(ActionEvent actionEvent) throws IOException {
        Parent load = FXMLLoader.load(this.getClass().getResource("/lk/ijse/dep/AssetManagement/view/Asset_Type_Form.fxml"));
        Scene scene=new Scene(load);
        Stage stage= (Stage) tblallassets.getScene().getWindow();
        stage.setScene(scene);
    }

    public void asddddd(KeyEvent keyEvent) throws Exception {
        ObservableList<AssetMainDTO> temp= FXCollections.observableArrayList();
        for (AssetMainDTO qwe:dao.getdata_to_assetmain()) {
            String x=qwe.getAsset_id()+"";
            if (x.startsWith(txtsearchasset.getText()) || qwe.getAsset_type().startsWith(txtsearchasset.getText()) || qwe.getDepartment().startsWith(txtsearchasset.getText())){
            temp.add(new AssetMainDTO(qwe.getAsset_id(),qwe.getAsset_type(),qwe.getDescription(),qwe.getDepartment()
            ,qwe.getVendor()));}
        }
        tblallassets.getItems().setAll(temp);
    }
}
