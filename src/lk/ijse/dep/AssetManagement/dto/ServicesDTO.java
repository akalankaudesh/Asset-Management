package lk.ijse.dep.AssetManagement.dto;

import java.util.Date;

public class ServicesDTO {
    private int service_id;
    private int asset_id;
    private String asset_name;
    private String service_description;
    private Date service_date;
    private double service_cost;

    public ServicesDTO(int service_id, int asset_id, String service_description, Date service_date, double service_cost) {
        this.service_id = service_id;
        this.asset_id = asset_id;
        this.service_description = service_description;
        this.service_date = service_date;
        this.service_cost = service_cost;
    }

    public ServicesDTO(int asset_id, String service_description, Date service_date, double service_cost) {
        this.asset_id = asset_id;
        this.service_description = service_description;
        this.service_date = service_date;
        this.service_cost = service_cost;
    }

    public ServicesDTO() {
    }

    public int getService_id() {
        return service_id;
    }

    public void setService_id(int service_id) {
        this.service_id = service_id;
    }

    public int getAsset_id() {
        return asset_id;
    }

    public void setAsset_id(int asset_id) {
        this.asset_id = asset_id;
    }

    public String getAsset_name() {
        return asset_name;
    }

    public void setAsset_name(String asset_name) {
        this.asset_name = asset_name;
    }

    public String getService_description() {
        return service_description;
    }

    public void setService_description(String service_description) {
        this.service_description = service_description;
    }

    public Date getService_date() {
        return service_date;
    }

    public void setService_date(Date service_date) {
        this.service_date = service_date;
    }

    public double getService_cost() {
        return service_cost;
    }

    public void setService_cost(double service_cost) {
        this.service_cost = service_cost;
    }

    @Override
    public String toString() {
        return "ServicesDTO{" +
                "service_id=" + service_id +
                ", asset_id=" + asset_id +
                ", asset_name='" + asset_name + '\'' +
                ", service_description='" + service_description + '\'' +
                ", service_date=" + service_date +
                ", service_cost=" + service_cost +
                '}';
    }
}
