package lk.ijse.dep.AssetManagement.business.custom;

import lk.ijse.dep.AssetManagement.business.SuperBO;
import lk.ijse.dep.AssetManagement.dto.AddAssetDTO;
import lk.ijse.dep.AssetManagement.dto.AssetMainDTO;


import java.util.List;

public interface ManageAssetBO extends SuperBO {
    List <AssetMainDTO> getAssets() throws Exception;
    boolean createAsset(AddAssetDTO dto) throws Exception;
    boolean updateAsset(AddAssetDTO dto) throws Exception;
    boolean deleteAsset(int key) throws Exception;
    AssetMainDTO findAsset(int asset_id) throws Exception;
}
