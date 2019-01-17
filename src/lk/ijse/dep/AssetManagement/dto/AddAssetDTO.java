package lk.ijse.dep.AssetManagement.dto;

import java.util.Date;

public class AddAssetDTO {

    private int asset_id;
    private String asset_type;
    private String description;
    private String department;
    private String vendor;
    private String model;
    private String brand;
    private double price;
    private Date date;

    public AddAssetDTO(String asset_type, String description, String department, String vendor, String model, String brand, double price, Date date) {
        this.asset_type = asset_type;
        this.description = description;
        this.department = department;
        this.vendor = vendor;
        this.model = model;
        this.brand = brand;
        this.price = price;
        this.date = date;
    }

    public AddAssetDTO(int asset_id, String asset_type, String description, String department, String vendor, String model, String brand, double price, Date date) {
        this.asset_id = asset_id;
        this.asset_type = asset_type;
        this.description = description;
        this.department = department;
        this.vendor = vendor;
        this.model = model;
        this.brand = brand;
        this.price = price;
        this.date = date;
    }

    public AddAssetDTO() {
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

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "AddAssetDTO{" +
                "asset_id=" + asset_id +
                ", asset_type='" + asset_type + '\'' +
                ", description='" + description + '\'' +
                ", department='" + department + '\'' +
                ", vendor='" + vendor + '\'' +
                ", model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                ", date=" + date +
                '}';
    }
}
