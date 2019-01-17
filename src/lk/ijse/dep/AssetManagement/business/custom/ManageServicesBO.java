package lk.ijse.dep.AssetManagement.business.custom;

import lk.ijse.dep.AssetManagement.business.SuperBO;
import lk.ijse.dep.AssetManagement.dto.ServicesDTO;


import java.util.List;

public interface ManageServicesBO extends SuperBO {
    List<ServicesDTO> getService() throws Exception;
    boolean createService(ServicesDTO dto) throws Exception;
    boolean updateService(ServicesDTO dto) throws Exception;
    boolean deleteService(int key) throws Exception;
    ServicesDTO findService(int dep_id) throws Exception;
}
