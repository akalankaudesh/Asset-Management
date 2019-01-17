package lk.ijse.dep.AssetManagement.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static DBConnection dbConnection;
    private Connection connection;

    private DBConnection() throws Exception{

        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/assets_management","root","1234");
    }

    public static DBConnection getInstance() throws Exception{
            if (dbConnection == null){
                dbConnection =new DBConnection();
            }
            return dbConnection;
    }

    public Connection getConnection() {
        return connection;
    }
}
