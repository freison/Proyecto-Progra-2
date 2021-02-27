
package proyecto_preliminar;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {
    // ATRIBUTOS DE LA CLASE.
    private Connection connection = null;
    
    // CONSTRUCTOR DE LA CLASE.
    public Connection(){
        
    }
    
    // METODOS DE LA CLASE.
    public java.sql.Connection getConnection(){
        java.sql.Connection connection = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/proyecto_preliminar", "root", "");
            System.out.println("Successfull Connection");
//            Statement stmt = connection.createStatement();
//            ResultSet rs = stmt.executeQuery("Select * from EstadosTarea");
//            
//            while(rs.next()){
//                System.out.println(rs.getString("descripcion"));
//            }
        }catch(Exception e){
            System.out.println("Error trying to connect: " + e.getMessage());
        }
        
        return connection;
    }
}
