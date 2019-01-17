package lk.ijse.dep.AssetManagement.business.custom.impl;

import lk.ijse.dep.AssetManagement.business.custom.ManageAssetBO;
import lk.ijse.dep.AssetManagement.dao.DAOFactory;
import lk.ijse.dep.AssetManagement.dao.custom.AssetDAO;
import lk.ijse.dep.AssetManagement.dao.custom.Asset_Type_DAO;
import lk.ijse.dep.AssetManagement.dto.AddAssetDTO;
import lk.ijse.dep.AssetManagement.dto.AssetMainDTO;
import lk.ijse.dep.AssetManagement.entity.Asset;

import java.util.ArrayList;
import java.util.List;

public class ManageAssetBOImpl implements ManageAssetBO {
    private AssetDAO asset;

    public ManageAssetBOImpl() { asset= DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ASSET); }

    @Override
    public List<AssetMainDTO> getAssets() throws Exception {

      List<Asset> all= asset.findAll();
        List <AssetMainDTO> tmpDTO=new ArrayList<>();
        for (Asset assets:all) {
            AssetMainDTO dto=new AssetMainDTO(assets.getAsset_id(),assets.getAsset_type(),assets.getDescription(),assets.getDepartment(),assets.getVendor());
            tmpDTO.add(dto);
        }

        return tmpDTO;
    }

    @Override
    public boolean createAsset(AddAssetDTO dto) throws Exception {

        Asset newasset= new Asset(dto.getAsset_id(),dto.getAsset_type(),dto.getDescription(),dto.getDepartment(),dto.getVendor(),dto.getModel(),dto.getBrand(),dto.getPrice(),dto.getDate());
        Asset save = asset.save(newasset);
        if (save == null){ return false; }
        else { return true; }

    }

    @Override
    public boolean updateAsset(AddAssetDTO dto) throws Exception {
        boolean update = asset.update(new Asset(dto.getAsset_id(), dto.getAsset_type(), dto.getDescription(), dto.getDepartment(), dto.getVendor(), dto.getModel(), dto.getBrand(), dto.getPrice(), dto.getDate()));
        return update;
    }

    @Override
    public boolean deleteAsset(int key) throws Exception {
        boolean delete = asset.delete(key);
        return delete;
    }

    @Override
    public AssetMainDTO findAsset(int asset_id) throws Exception {
        Asset asd= asset.find(asset_id);
        return new AssetMainDTO(asd.getAsset_id(),asd.getAsset_type(),asd.getDescription(),asd.getDepartment(),asd.getVendor());
    }
}
