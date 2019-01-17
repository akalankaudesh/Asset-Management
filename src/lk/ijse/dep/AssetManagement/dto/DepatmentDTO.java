package lk.ijse.dep.AssetManagement.dto;

public class DepatmentDTO {
    private String dep_id;
    private String dep_name;
    private String dep_description;

    public DepatmentDTO(String dep_id, String dep_name, String dep_description) {
        this.dep_id = dep_id;
        this.dep_name = dep_name;
        this.dep_description = dep_description;
    }

    public DepatmentDTO() {
    }

    public String getDep_id() {
        return dep_id;
    }

    public void setDep_id(String dep_id) {
        this.dep_id = dep_id;
    }

    public String getDep_name() {
        return dep_name;
    }

    public void setDep_name(String dep_name) {
        this.dep_name = dep_name;
    }

    public String getDep_description() {
        return dep_description;
    }

    public void setDep_description(String dep_description) {
        this.dep_description = dep_description;
    }

    @Override
    public String toString() {
        return "DepatmentDTO{" +
                "dep_id=" + dep_id +
                ", dep_name='" + dep_name + '\'' +
                ", dep_description='" + dep_description + '\'' +
                '}';
    }
}
