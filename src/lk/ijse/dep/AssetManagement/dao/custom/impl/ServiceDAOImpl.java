package lk.ijse.dep.AssetManagement.dao.custom.impl;

import lk.ijse.dep.AssetManagement.dao.CrudUtil;
import lk.ijse.dep.AssetManagement.dao.custom.ServiceDAO;
import lk.ijse.dep.AssetManagement.entity.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class ServiceDAOImpl implements ServiceDAO {
    @Override
    public Service save(Service entity) throws Exception {
        PreparedStatement pstm= CrudUtil.getPreparedStatement("INSERT INTO service (asset_name,service_description,service_date,service_cost) VALUES(?,?,?,?)",
                entity.getAsset_name(),entity.getService_description(),entity.getService_date(),entity.getService_cost());
        int i = pstm.executeUpdate();
        if (i>0){
            ResultSet keys = pstm.getGeneratedKeys();
            if (keys.next()){
                int id=keys.getInt(1);
                return new Service(id,entity.getAsset_name(),entity.getService_description(),entity.getService_date(),entity.getService_cost());
            }else {
                throw new RuntimeException("ID Cannot Generated");
            }

        }
        return null;
    }

    @Override
    public boolean update(Service entity) throws Exception {
        PreparedStatement pstm=CrudUtil.getPreparedStatement("UPDATE service SET asset_name=?,service_description=?,service_date=?,service_cost=? WHERE service_id=?",
                entity.getAsset_name(),entity.getService_description(),entity.getService_date(),entity.getService_cost(),entity.getService_id());
        return pstm.executeUpdate()>0;
    }

    @Override
    public boolean delete(Integer key) throws Exception {
        PreparedStatement pstm=CrudUtil.getPreparedStatement("DELETE FROM service WHERE service_id=?",key);
        return pstm.executeUpdate()>0;
    }

    @Override
    public Service find(Integer key) throws Exception {
        PreparedStatement pstm=CrudUtil.getPreparedStatement("SELECT * FROM service WHERE service_id=?)",key);
        ResultSet resultSet = pstm.executeQuery();
        if (resultSet.next()){
            return new Service(resultSet.getInt("service_id"),resultSet.getInt("asset_name"),resultSet.getString("service_description"),resultSet.getDate("service_date"),resultSet.getDouble("service_cost"));
        }
        else { return null;}

    }

    @Override
    public List<Service> findAll() throws Exception {
        PreparedStatement pstm=CrudUtil.getPreparedStatement("SELECT * FROM employee");
        ResultSet resultSet = pstm.executeQuery();
        List<Service> allservice=new ArrayList<>();
        while (resultSet.next()){
            allservice.add(new Service(resultSet.getInt("service_id"),resultSet.getInt("asset_name"),resultSet.getString("service_description"),resultSet.getDate("service_date"),resultSet.getDouble("service_cost")));
        }
        return allservice;
    }
}
