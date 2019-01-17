package lk.ijse.dep.AssetManagement.dao.custom.impl;

import lk.ijse.dep.AssetManagement.dao.CrudUtil;
import lk.ijse.dep.AssetManagement.dao.custom.VendorDAO;
import lk.ijse.dep.AssetManagement.entity.Vendor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class VendorDAOImpl implements VendorDAO {
    @Override
    public Vendor save(Vendor entity) throws Exception {
        PreparedStatement pstm= CrudUtil.getPreparedStatement("INSERT INTO vendor (vendor_id,venodr_name,venodr_telephone,venodr_email) VALUES(?,?,?,?)",
                entity.getVendor_id(),entity.getVendor_name(),entity.getVendor_telephone(),entity.getVendor_email());
        int i = pstm.executeUpdate();
        if (i>0){
            return new Vendor(entity.getVendor_id(),entity.getVendor_name(),entity.getVendor_telephone(),entity.getVendor_email());
        }else { return null; }
    }

    @Override
    public boolean update(Vendor entity) throws Exception {
        PreparedStatement pstm=CrudUtil.getPreparedStatement("UPDATE vendor SET venodr_name=?,venodr_telephone=?,venodr_email=? WHERE vendor_id=?",
                entity.getVendor_name(),entity.getVendor_telephone(),entity.getVendor_email(),entity.getVendor_id());
        return pstm.executeUpdate()>0;
    }

    @Override
    public boolean delete(String key) throws Exception {
        PreparedStatement pstm=CrudUtil.getPreparedStatement("DELETE FROM vendor WHERE vendor_id=?",key);
        return pstm.executeUpdate()>0;
    }

    @Override
    public Vendor find(String key) throws Exception {
        PreparedStatement pstm=CrudUtil.getPreparedStatement("SELECT * FROM vendor WHERE vendor_id=?",key);
        ResultSet resultSet = pstm.executeQuery();
        if (resultSet.next()){
            return new Vendor(resultSet.getString("vendor_id"),resultSet.getString("venodr_name"),resultSet.getString("venodr_telephone"),resultSet.getString("venodr_email"));
        }
        else { return null;}
    }

    @Override
    public List<Vendor> findAll() throws Exception {
        PreparedStatement pstm=CrudUtil.getPreparedStatement("SELECT * FROM vendor");
        ResultSet resultSet = pstm.executeQuery();
        List<Vendor> allVendor=new ArrayList<>();
        while (resultSet.next()){
            allVendor.add(new Vendor(resultSet.getString("vendor_id"),resultSet.getString("venodr_name"),resultSet.getString("venodr_telephone"),resultSet.getString("venodr_email")));
        }
        return allVendor;
    }
}
