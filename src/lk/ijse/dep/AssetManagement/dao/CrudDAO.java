package lk.ijse.dep.AssetManagement.dao;

import lk.ijse.dep.AssetManagement.entity.Super_Entity;

import java.util.List;

public interface CrudDAO < T extends Super_Entity, ID >extends SuperDAO {
    T save(T entity) throws Exception;
    boolean update(T entity) throws Exception;
    boolean delete(ID key) throws Exception;
    T find(ID key) throws Exception;
    List<T> findAll() throws Exception;

}
