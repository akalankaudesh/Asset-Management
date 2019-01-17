package lk.ijse.dep.AssetManagement.dao;

import lk.ijse.dep.AssetManagement.dbconnection.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class CrudUtil {

    private CrudUtil(){

    }
    public static PreparedStatement getPreparedStatement(String sql,Object... params ) throws Exception{
    Connection connection= DBConnection.getInstance().getConnection();
    PreparedStatement pstm=connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
    int parametcount=getparamCount(sql);
        if (parametcount !=params.length){
         throw new RuntimeException(" Parameter Count is Mismatch");
        }
        for (int i = 0; i <parametcount ; i++) {
            pstm.setObject(i+1,params[i]);
        }
        return pstm;
    }

    private static int getparamCount(String sql){
    return sql.concat(" ").split("[?]").length-1;
    }

}
