package lk.ijse.dep.AssetManagement.business.custom.impl;

import lk.ijse.dep.AssetManagement.business.custom.ManageEmployeeBO;
import lk.ijse.dep.AssetManagement.dto.AddEmployeeDTO;
import lk.ijse.dep.AssetManagement.dto.Employee_Main_DTO;

import java.util.List;

public class ManageEmployeeBOImpl implements ManageEmployeeBO {
    @Override
    public List<Employee_Main_DTO> getAssets() throws Exception {
        return null;
    }

    @Override
    public boolean createEmployee(AddEmployeeDTO dto) throws Exception {
        return false;
    }

    @Override
    public boolean updateEmployee(AddEmployeeDTO dto) throws Exception {
        return false;
    }

    @Override
    public boolean deleteEmployee(int key) throws Exception {
        return false;
    }

    @Override
    public Employee_Main_DTO findEmployee(int emp_id) throws Exception {
        return null;
    }
}
