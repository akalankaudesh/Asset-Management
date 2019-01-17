package lk.ijse.dep.AssetManagement.entity;

public class Vendor extends Super_Entity {
    private String vendor_id;
    private String vendor_name;
    private String vendor_telephone;
    private String vendor_email;

    public Vendor(String vendor_id, String vendor_name, String vendor_telephone, String vendor_email) {
        this.vendor_id = vendor_id;
        this.vendor_name = vendor_name;
        this.vendor_telephone = vendor_telephone;
        this.vendor_email = vendor_email;
    }

    public Vendor() {
    }

    public String getVendor_id() {
        return vendor_id;
    }

    public void setVendor_id(String vendor_id) {
        this.vendor_id = vendor_id;
    }

    public String getVendor_name() {
        return vendor_name;
    }

    public void setVendor_name(String vendor_name) {
        this.vendor_name = vendor_name;
    }

    public String getVendor_telephone() {
        return vendor_telephone;
    }

    public void setVendor_telephone(String vendor_telephone) {
        this.vendor_telephone = vendor_telephone;
    }

    public String getVendor_email() {
        return vendor_email;
    }

    public void setVendor_email(String vendor_email) {
        this.vendor_email = vendor_email;
    }

    @Override
    public String toString() {
        return "Vendor{" +
                "vendor_id='" + vendor_id + '\'' +
                ", vendor_name='" + vendor_name + '\'' +
                ", vendor_telephone='" + vendor_telephone + '\'' +
                ", vendor_email='" + vendor_email + '\'' +
                '}';
    }
}
