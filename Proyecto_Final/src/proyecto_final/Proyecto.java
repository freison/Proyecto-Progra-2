
package proyecto_final;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

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
    /***
     * Retorna el ID del ultimo proyecto agregado.
     * @return int
     */
    public int buscarUltimoProyecto(){
        int Id = 0;
        
        java.sql.Connection cn = null;
        try{
            cn = connection.getConnection();
            
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from Proyectos order by Id desc fetch first row only");
            
            while(rs.next()){
                Id = rs.getInt("ID");
            }

        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally{
            try{
                cn.close();
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }
        
        return Id;
    }
    
    /***
     * Busca un proyecto en base a su nombre.
     * @param proyecto
     * @return List
     */
    public List buscarProyecto(String proyecto){
        List<String> datos = new ArrayList<>();
        
        java.sql.Connection cn = null;
        try{
            cn = connection.getConnection();
            
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from proyectos where nombre = '"+proyecto+"'");
            
            while(rs.next()){
                datos.add(Integer.toString(rs.getInt("ID")));
                datos.add(rs.getString("Nombre"));
                datos.add(rs.getString("Descripcion"));
                datos.add(Boolean.toString(rs.getBoolean("Tipo")));
            }

        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally{
            try{
                cn.close();
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }
        
        return datos;
    }
    
    public void Agregar(String[] datosUsuario, boolean tipo){
        Administrador administrador = new Administrador();
        java.sql.Connection cn = null;
        int MiembroId = administrador.obtenerMiembroId(datosUsuario[0]);
        int AdministradorId = administrador.obtenerId(datosUsuario[0]);
        int ProyectoId = 0;
        try{
            cn = connection.getConnection();
            
            PreparedStatement stmt = cn.prepareStatement("insert into Proyectos(nombre, descripcion, AdministradorId, Tipo) values(?, ?, ?, ?)");
            stmt.setString(1, this.getNombre());
            stmt.setString(2, this.getDescripcion());
            stmt.setInt(3, AdministradorId);
            stmt.setBoolean(4, tipo);
            stmt.executeUpdate();
            
            ProyectoId = this.buscarUltimoProyecto();
            
            String sqlQuery = "insert into Detalle_Proyectos_Participacion(MiembroId, ProyectoId) values(?, ?)";
            PreparedStatement p = cn.prepareStatement(sqlQuery);
            p.setInt(1, MiembroId);
            p.setInt(2, ProyectoId);
            p.executeUpdate();
            
            if(!tipo){
                EstadoTarea estados = new EstadoTarea();
                
                estados.setDescripcion("Por Hacer");
                estados.Agregar(ProyectoId);
                
                estados.setDescripcion("En Proceso");
                estados.Agregar(ProyectoId);
                
                estados.setDescripcion("Finalizado");
                estados.Agregar(ProyectoId);
            }
            
            JOptionPane.showMessageDialog(null, "Proyecto Agregado");

        }catch(Exception e){
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, e.getMessage());
        }finally{
            try{
                cn.close();
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }
    }
    
    public void AgregarDetalleParticipacion(int MiembroId, int ProyectoId){
        java.sql.Connection cn = null;
        try{
            cn = connection.getConnection();
            
            String sqlQuery = "insert into Detalle_Proyectos_Participacion(MiembroId, ProyectoId)\n" +
"values(?, ?)";
            PreparedStatement p = cn.prepareStatement(sqlQuery);
            p.setInt(1, MiembroId);
            p.setInt(2, ProyectoId);
            p.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Detalle Agregado");

        }catch(Exception e){
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, e.getMessage());
        }finally{
            try{
                cn.close();
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }
    }
    
    /***
     * Lista todos los proyectos a los que un usuario pertenece.
     * @param usuario
     * @return List[]
     */
    public List[] Listar(String usuario){
        java.sql.Connection cn = null;
        List<Integer> id = new ArrayList<>();
        List<String> nombres = new ArrayList<>();

        List[] listas = new List[2];

        try {
            cn = connection.getConnection();

            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(
                    "select p.ID, \n" +
                    "    p.Nombre as Nombre\n" +
                    "from Miembros as m\n" +
                    "inner join Detalle_Proyectos_Participacion as dpp\n" +
                    "on m.ID = dpp.MIEMBROID\n" +
                    "inner join Proyectos as p\n" +
                    "on dpp.PROYECTOID = p.ID\n" +
                    "where m.USUARIO = '"+usuario+"'"
            );

            while (rs.next()) {
                id.add(rs.getInt("Id"));
                nombres.add(rs.getString("Nombre"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
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
    
    public List listarMiembros(int Id){
        java.sql.Connection cn = null;
        List<String> nombres = new ArrayList<>();
        try{
            cn = connection.getConnection();
            
            String sqlQuery = "select m.NOMBRES from\n" +
                              "Detalle_Proyectos_Participacion as dpp\n" +
                              "inner join Miembros as m\n" +
                              "on dpp.MIEMBROID = m.ID\n" +
                              "where ProyectoId = ?";
            PreparedStatement ps = cn.prepareStatement(sqlQuery);
            ps.setInt(1, Id);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                nombres.add(rs.getString("Nombres"));
            }

        }catch(Exception e){
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, e.getMessage());
        }finally{
            try{
                cn.close();
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }
        
        return nombres;
    }
    
    public String obtenerCreador(int Id){
        String usuario = "";
        java.sql.Connection cn = null;
        try{
            cn = connection.getConnection();
            
            String sqlQuery = "select m.USUARIO\n" +
                            "from Proyectos as p\n" +
                            "inner join ADMINISTRADORES as a\n" +
                            "on p.ADMINISTRADORID = a.ID\n" +
                            "inner join MIEMBROS as m\n" +
                            "on a.MIEMBROID = m.ID\n" +
                            "where p.ID = ?";
            PreparedStatement ps = cn.prepareStatement(sqlQuery);
            ps.setInt(1, Id);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                usuario = rs.getString("USUARIO");
            }

        }catch(Exception e){
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, e.getMessage());
        }finally{
            try{
                cn.close();
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }
        
        return usuario;
    }
    
    public boolean validarParticipacion(int miembroId, int proyectoId){
        boolean participacion = false;
        
        java.sql.Connection cn = null;
        try{
            cn = connection.getConnection();
            
            String sqlQuery = "select p.NOMBRE\n" +
                            "from PROYECTOS as p\n" +
                            "inner join DETALLE_PROYECTOS_PARTICIPACION as dpp\n" +
                            "on p.ID = dpp.PROYECTOID\n" +
                            "inner join MIEMBROS as m\n" +
                            "on dpp.MIEMBROID = m.ID\n" +
                            "where m.ID = ? and p.ID = ?";
            PreparedStatement ps = cn.prepareStatement(sqlQuery);
            ps.setInt(1, miembroId);
            ps.setInt(2, proyectoId);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                participacion = true;
            }

        }catch(Exception e){
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, e.getMessage());
        }finally{
            try{
                cn.close();
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }
        
        return participacion;
    }
} // Fin de la clase Proyecto.
