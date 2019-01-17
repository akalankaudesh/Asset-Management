package lk.ijse.dep.AssetManagement.business.custom;

import lk.ijse.dep.AssetManagement.business.SuperBO;
import lk.ijse.dep.AssetManagement.dto.AddEmployeeDTO;
import lk.ijse.dep.AssetManagement.dto.Employee_Main_DTO;


import java.util.List;

public interface ManageEmployeeBO extends SuperBO {

    List<Employee_Main_DTO> getAssets() throws Exception;
    boolean createEmployee(AddEmployeeDTO dto) throws Exception;
    boolean updateEmployee(AddEmployeeDTO dto) throws Exception;
    boolean deleteEmployee(int key) throws Exception;
    Employee_Main_DTO findEmployee(int emp_id) throws Exception;
}
