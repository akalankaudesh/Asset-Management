package lk.ijse.dep.AssetManagement.dao;

import lk.ijse.dep.AssetManagement.dao.custom.QueryDAO;
import lk.ijse.dep.AssetManagement.dao.custom.impl.*;

public class DAOFactory {

    public enum DAOTypes{
        ASSET_TYPE,ASSET,EMPLOYEE,SERVICE,VENDOR,DEPARTMENT,QUERY
    }

    public static DAOFactory daoFactory;

    private DAOFactory(){

    }
    public static DAOFactory getInstance(){
        if (daoFactory == null){
            daoFactory =new DAOFactory();
        }
        return daoFactory;
    }

    public <T extends SuperDAO> T getDAO(DAOTypes daoTypes){
       switch (daoTypes){
           case ASSET:
               return (T) new  AssetDAOImpl();
           case VENDOR:
               return (T) new VendorDAOImpl();
           case SERVICE:
               return (T) new ServiceDAOImpl();
           case EMPLOYEE:
               return (T) new EmployeeDAOImpl();
           case ASSET_TYPE:
               return (T) new Asset_Type_DAOImpl();
           case DEPARTMENT:
               return (T) new DepartmentDAOImpl();
           case QUERY:
               return (T) new QueryDAOImpl();
               default: return null;
       }

    }

}
