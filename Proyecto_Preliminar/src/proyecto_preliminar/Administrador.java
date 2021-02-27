package proyecto_preliminar;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Administrador extends Miembro{
    // ATRIBUTOS DE LA CLASE.
    private Proyecto[] proyectosCreados;
    private int MiembroId;
    
    Connection connection = new Connection();
    
    // CONSTRUCTORES DE LA CLASE.
    // Constructor sin parametros
    public Administrador(){
        super();
    }
    
    // Constructor con parametros V1
    public Administrador(String ID, String nombres, String apellidos,
            String usuario, String clave, String cedula){
        super(ID, nombres, apellidos, usuario, clave, cedula);
    }
    
    // Constructor con parametros V2.
    public Administrador(Proyecto[] proyectosCreados){
        super();
        this.proyectosCreados = proyectosCreados;
    }
    
    // Constructor con parametros V3.
    public Administrador(String ID, String nombres, String apellidos, 
            String usuario, String clave, String cedula,
            Proyecto[] proyectosCreados){
        super(ID, nombres, apellidos, usuario, clave, cedula, proyectosCreados);
        this.proyectosCreados = proyectosCreados;
    }
    
    // GETTERS Y SETTERS DE LA CLASE.
    public Proyecto[] getProyectosCreados(){
        return this.proyectosCreados;
    }
    
    public void setProyectosCreados(Proyecto[] proyectosCreados){
        this.proyectosCreados = proyectosCreados;
    }
    
    public int getMiembroId(){
        return this.MiembroId;
    }
    
    public void setMiembroId(int MiembroId){
        this.MiembroId = MiembroId;
    }
    
    // METODOS DE LA CLASE.
    public void Agregar(){
        java.sql.Connection cn = null;
        try{
            cn = connection.getConnection();
            
            Statement stmt = cn.createStatement();
            stmt.executeUpdate("Insert into Miembros(name, apellidos, usuario, clave, cedula) "
                + "values('"+ this.getNombres() + "', '"+ this.getApellidos()+ "', '"+ this.getUsuario() +"', "
                + "'"+ this.getClave() +"', '"+ this.getCedula() +"');");
            
            System.out.println("Succesfull Query Execution");
            
            this.setMiembroId(this.buscarUltimoMiembro());
            
            stmt = cn.createStatement();
            stmt.executeUpdate("Insert into Administradores(MiembroId) "
                + "values('"+ this.getMiembroId() +"')");
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
    
    public void Modificar(){
    
    }
    
    public void Listar(){
    
    }
} // Fin de la clase
