package lk.ijse.dep.AssetManagement.dto;

public class Employee_Main_DTO {
    private int emp_id;
    private String emp_name;
    private String emp_department;
    private double emp_monthly_salary;

    public Employee_Main_DTO(int emp_id, String emp_name, String emp_department, double emp_monthly_salary) {
        this.emp_id = emp_id;
        this.emp_name = emp_name;
        this.emp_department = emp_department;
        this.emp_monthly_salary = emp_monthly_salary;
    }

    public Employee_Main_DTO() {

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

    public double getEmp_monthly_salary() {
        return emp_monthly_salary;
    }

    public void setEmp_monthly_salary(double emp_monthly_salary) {
        this.emp_monthly_salary = emp_monthly_salary;
    }

    @Override
    public String toString() {
        return "Employee_Main_DTO{" +
                "emp_id=" + emp_id +
                ", emp_name='" + emp_name + '\'' +
                ", emp_department='" + emp_department + '\'' +
                ", emp_monthly_salary=" + emp_monthly_salary +
                '}';
    }
}
