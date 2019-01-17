package lk.ijse.dep.AssetManagement.business.custom;

import lk.ijse.dep.AssetManagement.business.SuperBO;
import lk.ijse.dep.AssetManagement.dto.VendorDTO;


import java.util.List;

public interface ManageVendorsBO extends SuperBO {

    List<VendorDTO> getVendors() throws Exception;
    boolean createVendor(VendorDTO dto) throws Exception;
    boolean updateVendor(VendorDTO dto) throws Exception;
    boolean deleteVendor(String key) throws Exception;
    VendorDTO findVendor(String vendor_id) throws Exception;
}
