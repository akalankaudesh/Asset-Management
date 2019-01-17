package lk.ijse.dep.AssetManagement.business;

import lk.ijse.dep.AssetManagement.business.custom.impl.*;

public class BOFactory {
     public enum BOtypes{
         MANAGE_ASSETS,MANAGE_ASSET_TYPES,MANAGE_DEPARTMENTS,MANAGE_EMPLOYEES,MANAGE_SERVICES,MANAGE_VENDORS
     }

     private static BOFactory boFactory;

    public BOFactory() {
    }

    public static BOFactory getInstance(){
        if (boFactory==null){
            boFactory=new BOFactory();
        }
        return boFactory;
    }

    public <T extends SuperBO> T getBO(BOtypes bOtypes){
        switch (bOtypes){
            case MANAGE_ASSETS: return (T) new ManageAssetBOImpl();
            case MANAGE_VENDORS: return (T) new ManageVendorsBOImpl();
            case MANAGE_SERVICES: return (T) new ManageServicesBOImpl();
            case MANAGE_EMPLOYEES: return (T) new ManageEmployeeBOImpl();
            case MANAGE_ASSET_TYPES: return (T) new ManageAssetTypeBOImpl();
            case MANAGE_DEPARTMENTS: return (T) new ManageDepartmentBOImpl();
            default: return null;
        }
    }

}
