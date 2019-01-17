package lk.ijse.dep.AssetManagement.dto;

import java.util.Date;

public class AssetMainDTO {

    private int asset_id;
    private String asset_type;
    private String description;
    private String department;
    private String vendor;

    public AssetMainDTO(int asset_id, String asset_type, String description, String department, String vendor) {
        this.asset_id = asset_id;
        this.asset_type = asset_type;
        this.description = description;
        this.department = department;
        this.vendor = vendor;
    }

    public AssetMainDTO() {
    }

    public int getAsset_id() {
        return asset_id;
    }

    public void setAsset_id(int asset_id) {
        this.asset_id = asset_id;
    }

    public String getAsset_type() {
        return asset_type;
    }

    public void setAsset_type(String asset_type) {
        this.asset_type = asset_type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    @Override
    public String toString() {
        return "AssetMainDTO{" +
                "asset_id=" + asset_id +
                ", asset_type='" + asset_type + '\'' +
                ", description='" + description + '\'' +
                ", department='" + department + '\'' +
                ", vendor='" + vendor + '\'' +
                '}';
    }
}
