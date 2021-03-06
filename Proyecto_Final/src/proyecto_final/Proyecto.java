
package proyecto_final;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Proyecto {
    // ATRIBUTOS DE LA CLASE.
    private String ID;
    private String nombre;
    private String descripcion;
    private Tarea[] tareasPorHacer;
    private Tarea[] tareasEnProceso;
    private Tarea[] tareasFinalizadas;
    
    private Connection connection = new Connection();
    
    // CONSTRUCTORES DE LA CLASE.
    // Constructor sin parametros.
    public Proyecto(){
        this.ID = "";
        this.nombre = "";
        this.descripcion = "";
        this.tareasPorHacer = null;
        this.tareasEnProceso = null;
        this.tareasFinalizadas = null;
    }
    
    // Constructor con parametros V1.
    public Proyecto(String ID, String nombre, String descripcion,
            Tarea[] tareasPorHacer, Tarea[] tareasEnProceso,
            Tarea[] tareasFinalizadas){
        this.ID = ID;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tareasPorHacer = tareasPorHacer;
        this.tareasEnProceso = tareasEnProceso;
        this.tareasFinalizadas = tareasFinalizadas;
    }
    
    // GETTERS Y SETTERS DE LA CLASE.
    public String getID(){
        return this.ID;
    }
    
    public void setID(String ID){
        this.ID = ID;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public String getDescripcion(){
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
    
    public Tarea[] getTareasPorHacer(){
        return this.tareasPorHacer;
    }
    
    public void setTareasPorHacer(Tarea[] tareasPorHacer){
        this.tareasPorHacer = tareasPorHacer;
    }
    
    public Tarea[] getTareasEnProceso(){
        return this.tareasEnProceso;
    }
    
    public void setTareasEnProceso(Tarea[] tareasEnProceso){
        this.tareasEnProceso = tareasEnProceso;
    }
    
    // METODOS DE LA CLASE.
    public void Agregar(){
        java.sql.Connection cn = null;
        try{
            cn = connection.getConnection();
            
            Statement stmt = cn.createStatement();
            stmt.executeUpdate("insert into Proyectos(nombre, descripcion) values('"+this.getNombre()+"', '"+this.getDescripcion()+"')");
            
            System.out.println("Succesfull Query Execution");

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
    
    public List[] Listar(){
        java.sql.Connection cn = null;
        List<Integer> id = new ArrayList<>();
        List<String> nombres = new ArrayList<>();

        List[] listas = new List[2];

        try {
            cn = connection.getConnection();

            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(
                    "select Id, Nombre as Nombres from Proyectos"
            );

            while (rs.next()) {
                id.add(rs.getInt("Id"));
                nombres.add(rs.getString("Nombres"));
            }

            System.out.println("Succesfull Query Execution");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Closing Connection");
            try {
                cn.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        listas[0] = id;
        listas[1] = nombres;

        return listas;
    }
} // Fin de la clase Proyecto.
