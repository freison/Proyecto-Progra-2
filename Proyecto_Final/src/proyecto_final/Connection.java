
package proyecto_final;

import java.sql.*;
import java.sql.DriverManager;

public class Connection {
    
    
    public java.sql.Connection getConnection(){
        java.sql.Connection connection = null;
        try{
            String dbURL = "jdbc:derby://localhost:1527/proyecto_preliminar;create=true";
            String user = "root";
            String password = "root";
            connection = DriverManager.getConnection(dbURL, user, password);
            
            System.out.println("Successfull Connection");
            
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        
        return connection;
    }
}
