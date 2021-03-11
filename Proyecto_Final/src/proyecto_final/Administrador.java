
package proyecto_final;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Administrador extends Miembro {
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
    @Override
    public void Agregar(){
        java.sql.Connection cn = null;
        try{
            cn = connection.getConnection();
            
            Statement stmt = cn.createStatement();
            stmt.executeUpdate("Insert into Miembros(nombres, apellidos, usuario, clave, cedula) "
                + "values('"+ this.getNombres() + "', '"+ this.getApellidos()+ "', '"+ this.getUsuario() +"', "
                + "'"+ this.getClave() +"', '"+ this.getCedula() +"')");
            
            System.out.println("Succesfull Query Execution");
            
            this.setMiembroId(this.buscarUltimoMiembro());
            
            String sqlQuery = "Insert into Administradores(MiembroId) values(?)";
            PreparedStatement ps = cn.prepareStatement(sqlQuery);
            ps.setInt(1, this.getMiembroId());
            ps.executeUpdate();

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
    
    /***
     * Calcula el total de Miembros existentes.
     * @return int
     */
    public int totalMiembros(){
        int total = 0;
        java.sql.Connection cn = null;
        try{
            cn = connection.getConnection();
            
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery("select count(*) as Total from Miembros");
            
            //total = rs.getInt("Total");
            
            while(rs.next()){
                total = rs.getInt("Total");
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
        
        return total;
    }
    
    /***
     * Obtiene el Id de Administrador en base al usuario.
     * @param usuario
     * @return int
     */
    @Override
    public int obtenerId(String usuario){
        int Id = 0;
        
        java.sql.Connection cn = null;
        try{
            cn = connection.getConnection();
            
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery("select a.ID from Miembros as m\n" +
                                             "left join Administradores as a\n" +
                                             "on m.ID = a.MIEMBROID\n" +
                                             "where m.usuario =  '"+usuario+"'");
            
            System.out.println("Succesfull Query Execution");
            
            while(rs.next()){
                Id = rs.getInt("ID");
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
        
        return Id;
    }
    
    /***
     * Obtiene el Id de Miembro en base al usuario.
     * @param usuario
     * @return Int
     */
    public int obtenerMiembroId(String usuario){
        int Id = super.obtenerId(usuario);
        
        return Id;
    }
}
