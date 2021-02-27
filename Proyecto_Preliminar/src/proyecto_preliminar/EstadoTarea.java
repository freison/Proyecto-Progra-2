
package proyecto_preliminar;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EstadoTarea {
    // ATRIBUTOS DE LA CLASE.
    private String ID;
    private String descripcion;
    
    private Connection connection = new Connection();
    
    // CONSTRUCTORES DE LA CLASE.
    // Constructor sin parametros.
    public EstadoTarea(){
        this.ID = "";
        this.descripcion = "";
    }
    
    // Constructor con parametros.
    public EstadoTarea(String ID, String descripcion){
        this.ID = ID;
        this.descripcion = descripcion;
    }
    
    // GETTERS Y SETTERS DE LA CLASE.

    public String getID() {
        return this.ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    // METODOS DE LA CLASE.
    public void Agregar(){
        java.sql.Connection cn = null;
        try{
            cn = connection.getConnection();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally{
            System.out.println("Closing Connection");
            try{
                cn.close();
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }
    }
    
    public String[] Listar(){
        String[] Listado = new String[3];
        java.sql.Connection cn = null;
        try{
            cn = connection.getConnection();
            
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery("Select * from EstadosTarea");
            
            while(rs.next()){
                System.out.println(rs.getString("descripcion"));
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally{
            System.out.println("Closing Connection");
            try{
                cn.close();
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }
        
        return Listado;
    }
}
