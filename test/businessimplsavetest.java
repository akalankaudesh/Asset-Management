import lk.ijse.dep.AssetManagement.business.BOFactory;
import lk.ijse.dep.AssetManagement.business.custom.ManageAssetTypeBO;
import lk.ijse.dep.AssetManagement.dao.DAOFactory;
import lk.ijse.dep.AssetManagement.dao.SuperDAO;
import lk.ijse.dep.AssetManagement.dao.custom.Asset_Type_DAO;
import lk.ijse.dep.AssetManagement.dao.custom.impl.Asset_Type_DAOImpl;
import lk.ijse.dep.AssetManagement.dbconnection.DBConnection;
import lk.ijse.dep.AssetManagement.dto.AssetTypeDTO;
import lk.ijse.dep.AssetManagement.entity.Asset_Type;

import java.util.List;

public class businessimplsavetest {

    public static void main(String[] args) throws Exception {

     //   Asset_Type_DAOImpl dao = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ASSET_TYPE);
         ManageAssetTypeBO manageAssetTypeBO= BOFactory.getInstance().getBO(BOFactory.BOtypes.MANAGE_ASSET_TYPES);
//        DBConnection con=DBConnection.getInstance();
//        System.out.println(con);

      //  boolean assetType = manageAssetTypeBO.createAssetType(new AssetTypeDTO("COM01", "COMPUTER", "ALL COMPUTERS BELONGS TO THIS CATEGORY "));
   // if (assetType ==true){
    //    System.out.println("success");
    //}
//
//        boolean b = manageAssetTypeBO.updateAssetType(new AssetTypeDTO("COM01", "COMPUTER", "All Computer related parts"));
//
//        if (b==true){
//            System.out.println("success");
//        }else {
//            System.out.println("failed");
//        }

//        List<AssetTypeDTO> types = manageAssetTypeBO.getTypes();
        AssetTypeDTO com01 = manageAssetTypeBO.findAssetType("COM01");

        System.out.println(com01);

    }

}
