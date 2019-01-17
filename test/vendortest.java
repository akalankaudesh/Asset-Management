import lk.ijse.dep.AssetManagement.business.BOFactory;
import lk.ijse.dep.AssetManagement.business.custom.ManageVendorsBO;
import lk.ijse.dep.AssetManagement.dto.VendorDTO;

public class vendortest {
    public static void main(String[] args) throws Exception {
        ManageVendorsBO manageVendorsBO= BOFactory.getInstance().getBO(BOFactory.BOtypes.MANAGE_VENDORS);
        boolean vendor = manageVendorsBO.createVendor(new VendorDTO("VEN01", "TECH ZONE", "0112145632", "techzone@gmail.com"));
        System.out.println(vendor);

    }
}
