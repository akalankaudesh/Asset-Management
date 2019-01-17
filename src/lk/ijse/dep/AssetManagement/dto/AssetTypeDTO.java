package lk.ijse.dep.AssetManagement.dto;

public class AssetTypeDTO {
    private String type_id;
    private String type_name;
    private String type_description;

    public AssetTypeDTO(String type_id, String type_name, String type_description) {
        this.type_id = type_id;
        this.type_name = type_name;
        this.type_description = type_description;
    }

    public AssetTypeDTO() {
    }

    public String getType_id() {
        return type_id;
    }

    public void setType_id(String type_id) {
        this.type_id = type_id;
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }

    public String getType_description() {
        return type_description;
    }

    public void setType_description(String type_description) {
        this.type_description = type_description;
    }

    @Override
    public String toString() {
        return "AssetTypeDTO{" +
                "type_id='" + type_id + '\'' +
                ", type_name='" + type_name + '\'' +
                ", type_description='" + type_description + '\'' +
                '}';
    }
}
