package lk.ijse.dep.AssetManagement.business.custom;

import lk.ijse.dep.AssetManagement.business.SuperBO;
import lk.ijse.dep.AssetManagement.dto.DepatmentDTO;


import java.util.List;

public interface ManageDepartmentBO extends SuperBO {
    List<DepatmentDTO> getDepartments() throws Exception;
    boolean createDepartment(DepatmentDTO dto) throws Exception;
    boolean updateDepartment(DepatmentDTO dto) throws Exception;
    boolean deleteDepartment(String key) throws Exception;
    DepatmentDTO findDepartment(String dep_id) throws Exception;
}
