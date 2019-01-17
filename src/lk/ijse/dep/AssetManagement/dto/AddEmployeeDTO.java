package lk.ijse.dep.AssetManagement.dto;

public class AddEmployeeDTO {
    private int emp_id;
    private String emp_name;
    private String emp_department;
    private String emp_address;
    private int emp_telephone;
    private double emp_monthly_salary;

    public AddEmployeeDTO(int emp_id, String emp_name, String emp_department, String emp_address, int emp_telephone, double emp_monthly_salary) {
        this.emp_id = emp_id;
        this.emp_name = emp_name;
        this.emp_department = emp_department;
        this.emp_address = emp_address;
        this.emp_telephone = emp_telephone;
        this.emp_monthly_salary = emp_monthly_salary;
    }

    public AddEmployeeDTO() {
    }

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public String getEmp_department() {
        return emp_department;
    }

    public void setEmp_department(String emp_department) {
        this.emp_department = emp_department;
    }

    public String getEmp_address() {
        return emp_address;
    }

    public void setEmp_address(String emp_address) {
        this.emp_address = emp_address;
    }

    public int getEmp_telephone() {
        return emp_telephone;
    }

    public void setEmp_telephone(int emp_telephone) {
        this.emp_telephone = emp_telephone;
    }

    public double getEmp_monthly_salary() {
        return emp_monthly_salary;
    }

    public void setEmp_monthly_salary(double emp_monthly_salary) {
        this.emp_monthly_salary = emp_monthly_salary;
    }

    @Override
    public String toString() {
        return "AddEmployeeDTO{" +
                "emp_id=" + emp_id +
                ", emp_name='" + emp_name + '\'' +
                ", emp_department='" + emp_department + '\'' +
                ", emp_address='" + emp_address + '\'' +
                ", emp_telephone=" + emp_telephone +
                ", emp_monthly_salary=" + emp_monthly_salary +
                '}';
    }
}
