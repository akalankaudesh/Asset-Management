package lk.ijse.dep.AssetManagement.dao.custom.impl;

import lk.ijse.dep.AssetManagement.dao.CrudUtil;
import lk.ijse.dep.AssetManagement.dao.custom.Asset_Type_DAO;
import lk.ijse.dep.AssetManagement.entity.Asset_Type;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Asset_Type_DAOImpl implements Asset_Type_DAO {
    @Override
    public Asset_Type save(Asset_Type entity) throws Exception {
        PreparedStatement pstm=CrudUtil.getPreparedStatement("INSERT INTO asset_types (type_id,type_name,type_description) VALUES(?,?,?)",
                entity.getType_id(),entity.getType_name(),entity.getType_description());
        int i = pstm.executeUpdate();
        if (i>0){
        return new Asset_Type(entity.getType_id(),entity.getType_name(),entity.getType_description());
        }else { return null; }

    }

    @Override
    public boolean update(Asset_Type entity) throws Exception {
        PreparedStatement pstm=CrudUtil.getPreparedStatement("UPDATE asset_types SET type_name=?,type_description=? WHERE type_id=?",
                entity.getType_name(),entity.getType_description(),entity.getType_id());
        return pstm.executeUpdate()>0;
    }

    @Override
    public boolean delete(String key) throws Exception {
        PreparedStatement pstm=CrudUtil.getPreparedStatement("DELETE FROM asset_types WHERE type_id=?",key);
        return pstm.executeUpdate()>0;
    }

    @Override
    public Asset_Type find(String key) throws Exception {
        PreparedStatement pstm=CrudUtil.getPreparedStatement("SELECT * FROM asset_types WHERE type_id=?",key);
        ResultSet resultSet = pstm.executeQuery();
        if (resultSet.next()){
            return new Asset_Type(resultSet.getString("type_id"),resultSet.getString("type_name"),resultSet.getString("type_description"));
        }
        else { return null;}
    }

    @Override
    public List<Asset_Type> findAll() throws Exception {
        PreparedStatement pstm=CrudUtil.getPreparedStatement("SELECT * FROM asset_types");
        ResultSet resultSet = pstm.executeQuery();
        List<Asset_Type> alltypes=new ArrayList<>();
        while (resultSet.next()){
            alltypes.add(new Asset_Type(resultSet.getString("type_id"),resultSet.getString("type_name"),resultSet.getString("type_description")));
        }
        return alltypes;
    }
}
