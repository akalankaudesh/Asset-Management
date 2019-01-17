package lk.ijse.dep.AssetManagement.dao.custom.impl;

import javafx.collections.FXCollections;
import lk.ijse.dep.AssetManagement.dao.CrudUtil;
import lk.ijse.dep.AssetManagement.dao.custom.QueryDAO;
import lk.ijse.dep.AssetManagement.dto.AssetMainDTO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class QueryDAOImpl implements QueryDAO {
    @Override
    public List<AssetMainDTO> getdata_to_assetmain() throws Exception {
        PreparedStatement preparedStatement = CrudUtil.getPreparedStatement("SELECT assets.asset_id,   asset_types.type_name,    assets.asset_description,  department.dep_name,   vendor.venodr_name FROM assets" +
                " INNER JOIN asset_types ON assets.asset_type =asset_types.type_id"+
                " INNER JOIN department ON assets.asset_department=department.dep_id"+
                " INNER JOIN vendor ON assets.asset_vendor=vendor.vendor_id");
        ResultSet resultSet = preparedStatement.executeQuery();
        List<AssetMainDTO> res= new ArrayList<>();
        while (resultSet.next()){
        res.add(new AssetMainDTO(resultSet.getInt("asset_id"),resultSet.getString("type_name"),resultSet.getString("asset_description"),resultSet.getString("dep_name"),resultSet.getString("venodr_name")));
        }
        return res;
    }

}
