package lk.ijse.dep.AssetManagement.dao.custom.impl;

import lk.ijse.dep.AssetManagement.dao.CrudUtil;
import lk.ijse.dep.AssetManagement.dao.custom.AssetDAO;
import lk.ijse.dep.AssetManagement.entity.Asset;
import lk.ijse.dep.AssetManagement.entity.Asset_Type;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AssetDAOImpl implements AssetDAO {
    @Override
    public Asset save(Asset entity) throws Exception {
        PreparedStatement pstm= CrudUtil.getPreparedStatement("INSERT INTO assets (asset_type,asset_description,asset_department,asset_vendor,asset_model,asset_brand,asset_price,asset_date) VALUES(?,?,?,?,?,?,?,?)",
                entity.getAsset_type(),entity.getDescription(),entity.getDepartment(),entity.getVendor(),entity.getModel(),entity.getBrand(),entity.getPrice(),entity.getDate());
        int i = pstm.executeUpdate();
        if (i>0){
            ResultSet keys = pstm.getGeneratedKeys();
            if (keys.next()){
                int id=keys.getInt(1);
                return new Asset(id,entity.getAsset_type(),entity.getDescription(),entity.getDepartment(),entity.getVendor(),entity.getModel(),entity.getBrand(),entity.getPrice(),entity.getDate());
            }else {
                throw new RuntimeException("ID Cannot Generated");
            }

        }
        return null;

    }

    @Override
    public boolean update(Asset entity) throws Exception {
        PreparedStatement pstm=CrudUtil.getPreparedStatement("UPDATE assets SET asset_type=?,asset_description=?,asset_department=?,asset_vendor=?,asset_model=?,asset_brand=?,asset_price=?,asset_date=? WHERE  asset_id=?",
                entity.getAsset_type(),entity.getDescription(),entity.getDepartment(),entity.getVendor(),entity.getModel(),entity.getBrand(),entity.getPrice(),entity.getDate(),entity.getAsset_id());
        return pstm.executeUpdate()>0;
    }

    @Override
    public boolean delete(Integer key) throws Exception {
        PreparedStatement pstm=CrudUtil.getPreparedStatement("DELETE FROM assets WHERE asset_id=?",key);
        return pstm.executeUpdate()>0;
    }

    @Override
    public Asset find(Integer key) throws Exception {
        PreparedStatement pstm=CrudUtil.getPreparedStatement("SELECT * FROM assets WHERE asset_id=?)",key);
        ResultSet resultSet = pstm.executeQuery();
        if (resultSet.next()){
            return new Asset(resultSet.getInt("asset_id"),resultSet.getString("asset_type"),resultSet.getString("asset_description"),resultSet.getString("asset_department"),resultSet.getString("asset_vendor"),resultSet.getString("asset_model"),resultSet.getString("asset_brand"),resultSet.getDouble("asset_price"),resultSet.getDate("asset_date"));
        }
        else { return null;}
    }

    @Override
    public List<Asset> findAll() throws Exception {
        PreparedStatement pstm=CrudUtil.getPreparedStatement("SELECT * FROM assets");
        ResultSet resultSet = pstm.executeQuery();
        List<Asset> allAsset=new ArrayList<>();
        while (resultSet.next()){
            allAsset.add(new Asset(resultSet.getInt("asset_id"),resultSet.getString("asset_type"),resultSet.getString("asset_description"),resultSet.getString("asset_department"),resultSet.getString("asset_vendor"),resultSet.getString("asset_model"),resultSet.getString("asset_brand"),resultSet.getDouble("asset_price"),resultSet.getDate("asset_date")));
        }
        return allAsset;
    }
}
