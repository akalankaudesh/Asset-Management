package lk.ijse.dep.AssetManagement.business.custom.impl;

import lk.ijse.dep.AssetManagement.business.custom.ManageDepartmentBO;
import lk.ijse.dep.AssetManagement.dao.DAOFactory;
import lk.ijse.dep.AssetManagement.dao.custom.DepartmentDAO;
import lk.ijse.dep.AssetManagement.dto.DepatmentDTO;
import lk.ijse.dep.AssetManagement.entity.Department;

import java.util.ArrayList;
import java.util.List;

public class ManageDepartmentBOImpl implements ManageDepartmentBO {

    private DepartmentDAO departmentDAO;

    public ManageDepartmentBOImpl (){
        departmentDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.DEPARTMENT);

    }

    @Override
    public List<DepatmentDTO> getDepartments() throws Exception {
        List<DepatmentDTO> alldepartments=new ArrayList<>();
        List<Department> departments = departmentDAO.findAll();
        for (Department department:departments) {
            alldepartments.add(new DepatmentDTO(department.getDep_id(),department.getDep_name(),department.getDep_description()));
        }
        return alldepartments;
    }

    @Override
    public boolean createDepartment(DepatmentDTO dto) throws Exception {
        Department newDepartment= new Department(dto.getDep_id(),dto.getDep_name(),dto.getDep_description());
        Department save = departmentDAO.save(newDepartment);
        if (save == null){ return false; }
        else { return true; }
    }

    @Override
    public boolean updateDepartment(DepatmentDTO dto) throws Exception {
        boolean update = departmentDAO.update(new Department(dto.getDep_id(), dto.getDep_name(), dto.getDep_description()));
        return update;
    }

    @Override
    public boolean deleteDepartment(String key) throws Exception {
        boolean delete = departmentDAO.delete(key);
        return delete;
    }

    @Override
    public DepatmentDTO findDepartment(String dep_id) throws Exception {
        Department department = departmentDAO.find(dep_id);
        if (department==null){return null;}else { return new DepatmentDTO(department.getDep_id(), department.getDep_name(), department.getDep_description()); }
    }
}
