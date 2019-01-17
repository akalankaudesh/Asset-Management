package lk.ijse.dep.AssetManagement.business.custom.impl;

import lk.ijse.dep.AssetManagement.business.custom.ManageVendorsBO;
import lk.ijse.dep.AssetManagement.dao.DAOFactory;
import lk.ijse.dep.AssetManagement.dao.custom.VendorDAO;
import lk.ijse.dep.AssetManagement.dto.VendorDTO;
import lk.ijse.dep.AssetManagement.entity.Vendor;

import java.util.ArrayList;
import java.util.List;

public class ManageVendorsBOImpl implements ManageVendorsBO {
    private VendorDAO vendorDAO;
    public ManageVendorsBOImpl(){
        vendorDAO= DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.VENDOR);
    }



    @Override
    public List<VendorDTO> getVendors() throws Exception {
       List<Vendor> get=vendorDAO.findAll();
       List<VendorDTO> allvendors=new ArrayList<>();
        for (Vendor vendor:get) {
            allvendors.add(new VendorDTO(vendor.getVendor_id(),vendor.getVendor_name(),vendor.getVendor_telephone(),vendor.getVendor_email()));
        }
        return allvendors;
    }

    @Override
    public boolean createVendor(VendorDTO dto) throws Exception {
        Vendor newVendor= new Vendor(dto.getVendor_id(),dto.getVendor_name(),dto.getVendor_telephone(),dto.getVendor_email());
        Vendor save = vendorDAO.save(newVendor);
        if (save == null){ return false; }
        else { return true; }
    }

    @Override
    public boolean updateVendor(VendorDTO dto) throws Exception {
        boolean update = vendorDAO.update(new Vendor(dto.getVendor_id(), dto.getVendor_name(), dto.getVendor_telephone(), dto.getVendor_email()));
        return update;
    }

    @Override
    public boolean deleteVendor(String key) throws Exception {
        return vendorDAO.delete(key);
    }

    @Override
    public VendorDTO findVendor(String vendor_id) throws Exception {
        Vendor vendor = vendorDAO.find(vendor_id);
        if (vendor==null){return null;}
        else {
        return new VendorDTO(vendor.getVendor_id(),vendor.getVendor_name(),vendor.getVendor_telephone(),vendor.getVendor_email());
    }
    }
}
