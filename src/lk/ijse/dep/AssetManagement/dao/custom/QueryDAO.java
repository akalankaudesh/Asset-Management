package lk.ijse.dep.AssetManagement.dao.custom;

import lk.ijse.dep.AssetManagement.dao.SuperDAO;
import lk.ijse.dep.AssetManagement.dto.AssetMainDTO;

import java.util.List;
import java.util.Optional;

public interface QueryDAO extends SuperDAO {

   List<AssetMainDTO> getdata_to_assetmain() throws Exception;

}
