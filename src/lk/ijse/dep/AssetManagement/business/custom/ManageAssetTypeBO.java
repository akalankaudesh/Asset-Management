package lk.ijse.dep.AssetManagement.business.custom;

import lk.ijse.dep.AssetManagement.business.SuperBO;
import lk.ijse.dep.AssetManagement.dto.AssetTypeDTO;
import lk.ijse.dep.AssetManagement.entity.Asset_Type;

import java.util.List;

public interface ManageAssetTypeBO extends SuperBO {

    List<AssetTypeDTO> getTypes() throws Exception;
    boolean createAssetType(AssetTypeDTO dto) throws Exception;
    boolean updateAssetType(AssetTypeDTO dto) throws Exception;
    boolean deleteAssetType(String key) throws Exception;
    AssetTypeDTO findAssetType(String type_id) throws Exception;

}
