package lk.ijse.dep.AssetManagement.business.custom.impl;

import lk.ijse.dep.AssetManagement.business.custom.ManageServicesBO;
import lk.ijse.dep.AssetManagement.dao.DAOFactory;
import lk.ijse.dep.AssetManagement.dao.custom.ServiceDAO;
import lk.ijse.dep.AssetManagement.dto.ServicesDTO;
import lk.ijse.dep.AssetManagement.entity.Service;

import java.util.ArrayList;
import java.util.List;

public class ManageServicesBOImpl implements ManageServicesBO {

    ServiceDAO serviceDAO= DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.SERVICE);
    @Override
    public List<ServicesDTO> getService() throws Exception {

        List<ServicesDTO> returnlist=new ArrayList<>();
        List<Service> services = serviceDAO.findAll();
        for (Service asd:services) {
            returnlist.add(new ServicesDTO(asd.getService_id(),asd.getAsset_name(),asd.getService_description(),asd.getService_date(),asd.getService_cost()));
        }
        return returnlist;
    }

    @Override
    public boolean createService(ServicesDTO dto) throws Exception {
        Service save = serviceDAO.save(new Service(dto.getService_id(), dto.getAsset_id(), dto.getService_description(), dto.getService_date(), dto.getService_cost()));
        if (save==null){return false;}else {return true;}
    }

    @Override
    public boolean updateService(ServicesDTO dto) throws Exception {
        Service update = serviceDAO.save(new Service(dto.getService_id(), dto.getAsset_id(), dto.getService_description(), dto.getService_date(), dto.getService_cost()));
        boolean update1 = serviceDAO.update(update);
        return update1;
    }

    @Override
    public boolean deleteService(int key) throws Exception {
        boolean delete = serviceDAO.delete(key);
        return delete;
    }

    @Override
    public ServicesDTO findService(int dep_id) throws Exception {
        Service service = serviceDAO.find(dep_id);
        return new ServicesDTO(service.getService_id(),service.getAsset_name(),service.getService_description(),service.getService_date(),service.getService_cost());
    }
}
