package lk.ijse.dep.AssetManagement.dao.custom.impl;

import lk.ijse.dep.AssetManagement.dao.CrudUtil;
import lk.ijse.dep.AssetManagement.dao.custom.EmployeeDAO;
import lk.ijse.dep.AssetManagement.entity.Asset;
import lk.ijse.dep.AssetManagement.entity.Department;
import lk.ijse.dep.AssetManagement.entity.Employee;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    @Override
    public Employee save(Employee entity) throws Exception {
        PreparedStatement pstm= CrudUtil.getPreparedStatement("INSERT INTO employee (emp_name,emp_department,emp_address,emp_telephone,emp_monthly_salary) VALUES(?,?,?,?,?)",
                entity.getEmp_name(),entity.getEmp_department(),entity.getEmp_address(),entity.getEmp_telephone(),entity.getEmp_monthly_salary());
        int i = pstm.executeUpdate();
        if (i>0){
            ResultSet keys = pstm.getGeneratedKeys();
            if (keys.next()){
                int id=keys.getInt(1);
                return new Employee(id,entity.getEmp_name(),entity.getEmp_department(),entity.getEmp_address(),entity.getEmp_telephone(),entity.getEmp_monthly_salary());
            }else {
                throw new RuntimeException("ID Cannot Generated");
            }

        }
        return null;
    }

    @Override
    public boolean update(Employee entity) throws Exception {
        PreparedStatement pstm=CrudUtil.getPreparedStatement("UPDATE employee SET emp_name=?,emp_department=?,emp_address=?,emp_telephone=?,emp_monthly_salary=? WHERE emp_id=?",
                entity.getEmp_name(),entity.getEmp_department(),entity.getEmp_address(),entity.getEmp_telephone(),entity.getEmp_monthly_salary(),entity.getEmp_id());
        return pstm.executeUpdate()>0;
    }

    @Override
    public boolean delete(Integer key) throws Exception {
        PreparedStatement pstm=CrudUtil.getPreparedStatement("DELETE FROM employee WHERE emp_id=?",key);
        return pstm.executeUpdate()>0;
    }

    @Override
    public Employee find(Integer key) throws Exception {
        PreparedStatement pstm=CrudUtil.getPreparedStatement("SELECT * FROM employee WHERE emp_id=?)",key);
        ResultSet resultSet = pstm.executeQuery();
        if (resultSet.next()){
            return new Employee(resultSet.getInt("emp_id"),resultSet.getString("emp_name"),resultSet.getString("emp_department"),resultSet.getString("emp_address"),resultSet.getInt("emp_telephone"),resultSet.getDouble("emp_monthly_salary"));
        }
        else { return null;}
    }

    @Override
    public List<Employee> findAll() throws Exception {
        PreparedStatement pstm=CrudUtil.getPreparedStatement("SELECT * FROM employee");
        ResultSet resultSet = pstm.executeQuery();
        List<Employee> allemployee=new ArrayList<>();
        while (resultSet.next()){
            allemployee.add(new Employee(resultSet.getInt("emp_id"),resultSet.getString("emp_name"),resultSet.getString("emp_department"),resultSet.getString("emp_address"),resultSet.getInt("emp_telephone"),resultSet.getDouble("emp_monthly_salary")));
        }
        return allemployee;
    }
}
