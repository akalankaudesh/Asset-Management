package lk.ijse.dep.AssetManagement.dao.custom.impl;

import lk.ijse.dep.AssetManagement.dao.CrudUtil;
import lk.ijse.dep.AssetManagement.dao.custom.DepartmentDAO;
import lk.ijse.dep.AssetManagement.entity.Asset_Type;
import lk.ijse.dep.AssetManagement.entity.Department;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDAOImpl implements DepartmentDAO {
    @Override
    public Department save(Department entity) throws Exception {
        PreparedStatement pstm= CrudUtil.getPreparedStatement("INSERT INTO department (dep_id,dep_name,dep_description) VALUES(?,?,?)",
                entity.getDep_id(),entity.getDep_name(),entity.getDep_description());
        int i = pstm.executeUpdate();
        if (i>0){
            return new Department(entity.getDep_id(),entity.getDep_name(),entity.getDep_description());
        }else { return null; }

    }

    @Override
    public boolean update(Department entity) throws Exception {
        PreparedStatement pstm=CrudUtil.getPreparedStatement("UPDATE department SET dep_name=?,dep_description=? WHERE type_id=?",
                entity.getDep_name(),entity.getDep_description(),entity.getDep_id());
        return pstm.executeUpdate()>0;
    }

    @Override
    public boolean delete(String key) throws Exception {
        PreparedStatement pstm=CrudUtil.getPreparedStatement("DELETE FROM department WHERE dep_id=?",key);
        return pstm.executeUpdate()>0;
    }


    @Override
    public Department find(String key) throws Exception {
        PreparedStatement pstm=CrudUtil.getPreparedStatement("SELECT * FROM department WHERE dep_id=?)",key);
        ResultSet resultSet = pstm.executeQuery();
        if (resultSet.next()){
            return new Department(resultSet.getString("dep_id"),resultSet.getString("dep_name"),resultSet.getString("dep_description"));
        }
        else { return null;}
    }

    @Override
    public List<Department> findAll() throws Exception {
        PreparedStatement pstm=CrudUtil.getPreparedStatement("SELECT * FROM department");
        ResultSet resultSet = pstm.executeQuery();
        List<Department> alldepartment=new ArrayList<>();
        while (resultSet.next()){
            alldepartment.add(new Department(resultSet.getString("dep_id"),resultSet.getString("dep_name"),resultSet.getString("dep_description")));
        }
        return alldepartment;
    }
}
