package lk.ijse.dep.AssetManagement.business.custom.impl;

import lk.ijse.dep.AssetManagement.business.custom.ManageAssetTypeBO;
import lk.ijse.dep.AssetManagement.dao.DAOFactory;
import lk.ijse.dep.AssetManagement.dao.custom.Asset_Type_DAO;
import lk.ijse.dep.AssetManagement.dto.AssetTypeDTO;
import lk.ijse.dep.AssetManagement.entity.Asset;
import lk.ijse.dep.AssetManagement.entity.Asset_Type;

import java.util.ArrayList;
import java.util.List;

public class ManageAssetTypeBOImpl implements ManageAssetTypeBO {
    private Asset_Type_DAO asset_type_dao;

    public ManageAssetTypeBOImpl (){
        asset_type_dao= DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ASSET_TYPE);
    }

    @Override
    public List<AssetTypeDTO> getTypes() throws Exception {

        List<Asset_Type> result = asset_type_dao.findAll();
        List<AssetTypeDTO> Allassets=new ArrayList<>();
        for (Asset_Type asset_type:result) {
            Allassets.add(new AssetTypeDTO(asset_type.getType_id(),asset_type.getType_name(),asset_type.getType_description()));
        }
        return Allassets;
    }

    @Override
    public boolean createAssetType(AssetTypeDTO dto) throws Exception {
        Asset_Type newasset_type= new Asset_Type(dto.getType_id(),dto.getType_name(),dto.getType_description());
        Asset_Type save = asset_type_dao.save(newasset_type);
        if (save == null){ return false; }
        else { return true; }
    }

    @Override
    public boolean updateAssetType(AssetTypeDTO dto) throws Exception {
        boolean update = asset_type_dao.update(new Asset_Type(dto.getType_id(),dto.getType_name(), dto.getType_description()));
        return update;
    }

    @Override
    public boolean deleteAssetType(String key) throws Exception {
        boolean delete = asset_type_dao.delete(key);
        return delete;
    }

    @Override
    public AssetTypeDTO findAssetType(String type_id) throws Exception {
        Asset_Type asset_type = asset_type_dao.find(type_id);
        if (asset_type==null){return null;}
        else { return new AssetTypeDTO(asset_type.getType_id(),asset_type.getType_name(),asset_type.getType_description()); }
    }
}
