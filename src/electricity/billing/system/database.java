package electricity.billing.system;

 //import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class database {
     Connection connection;
     Statement statement;
    database(){
        try {
            
            String url = "jdbc:mysql://localhost:3306/bill_system";
            String username = "root";
            String password = "";
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
