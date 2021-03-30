
package proyecto_final;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Tarea {
    // ATRIBUTOS DE LA CLASE.
    private String ID;
    private String descripcion;
    
    private Connection connection = new Connection();
    
    // CONSTRUCTORES DE LA CLASE.
    // Constructor sin parametros.
    public Tarea(){
        this.ID = "";
        this.descripcion = "";
    }
    
    // Constructor con parametros.
    public Tarea(String ID, String descripcion){
        this.ID = ID;
        this.descripcion = descripcion;
    }
    
    // GETTERS Y SETTERS DE LA CLASE.
    public String getID(){
        return this.ID;
    }
    
    public void setID(String ID){
        this.ID = ID;
    }
    
    public String getDescripcion(String Descripcion){
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
    
    // METODOS DE LA CLASE.
    public void Agregar(String descripcion, int EstadoTareaId, int ProyectoId){
        java.sql.Connection cn = null;
        try{
            cn = connection.getConnection();
            
            String sqlQuery = "insert into TAREAS(Descripcion, EstadoTareaId, ProyectoId) values(?, ?, ?)";
            PreparedStatement ps = cn.prepareStatement(sqlQuery);
            ps.setString(1, descripcion);
            ps.setInt(2, EstadoTareaId);
            ps.setInt(3, ProyectoId);
            ps.executeUpdate();

        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally{
            try{
                cn.close();
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }
    }
    
    public void AgregarDetalle(int MiembroId, int TareaId){
        java.sql.Connection cn = null;
        try{
            cn = connection.getConnection();
            
            String sqlQuery = "insert into DETALLE_TAREAS_MIEMBRO(MiembroId, TareaId) values(?, ?)";
            PreparedStatement ps = cn.prepareStatement(sqlQuery);
            ps.setInt(1, MiembroId);
            ps.setInt(2, TareaId);
            ps.executeUpdate();

        }catch(Exception e){
            System.out.println(e.getMessage());
        }finally{
            try{
                cn.close();
            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        }
    }
    
    public int buscarUltimaTarea(){
        int Id = 0;
        
        java.sql.Connection cn = null;
        try {
            cn = connection.getConnection();

            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from Tareas order by Id desc fetch first row only");

            while (rs.next()) {
                System.out.println(rs.getInt("Id"));
                Id = rs.getInt("Id");
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
        
        return Id;
    }
    
    public List<String> buscarTareaPorId(int tareaId){
        java.sql.Connection cn = null;
        
        List<String> tarea = new ArrayList<>();

        try {
            cn = connection.getConnection();

            String sqlQuery = "select * from Tareas where id = ?";
            
            PreparedStatement ps = cn.prepareStatement(sqlQuery);
            ps.setInt(1, tareaId);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                tarea.add(rs.getString("Descripcion"));
                tarea.add(Integer.toString(rs.getInt("EstadoTareaId")));
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
        
        return tarea;
    }
    
    public List<List<String>> listarTareasPorUsuario(String usuario){
        List<List<String>> lista = new ArrayList<>();
        
        java.sql.Connection cn = null;
        List<String> tareas = new ArrayList<>();
        List<String> proyectos = new ArrayList<>();
        List<String> estados = new ArrayList<>();

        try {
            cn = connection.getConnection();

            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(
                    "select t.DESCRIPCION as Tarea,\n" +
                    "    p.NOMBRE as Proyecto,\n" +
                    "    case t.ESTADOTAREAID\n" +
                    "        when = 1 then 'Por Hacer'\n" +
                    "        else\n" +
                    "            case t.ESTADOTAREAID\n" +
                    "                when = 2 then 'En Proceso'\n" +
                    "                else 'Finalizada'\n" +
                    "            end\n" +
                    "        end as Estado\n" +
                    "from PROYECTOS as p\n" +
                    "inner join Tareas as t\n" +
                    "on p.ID = t.PROYECTOID\n" +
                    "inner join DETALLE_TAREAS_MIEMBRO as dtm\n" +
                    "on t.ID = dtm.TAREAID\n" +
                    "inner join MIEMBROS as m\n" +
                    "on dtm.MIEMBROID = m.ID\n" +
                    "where m.usuario = '"+usuario+"'"
            );

            while (rs.next()) {
                tareas.add(rs.getString("TAREA"));
                proyectos.add(rs.getString("PROYECTO"));
                estados.add(rs.getString("ESTADO"));
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

        lista.add(tareas);
        lista.add(proyectos);
        lista.add(estados);
        
        return lista;
    }
    
    public List<List<String>> listarTareasPorProyecto(int proyectoId){
        List<List<String>> lista = new ArrayList<>();
        
        java.sql.Connection cn = null;
        List<String> Id = new ArrayList<>();
        List<String> descripciones = new ArrayList<>();
        List<String> estados = new ArrayList<>();

        try {
            cn = connection.getConnection();

            String sqlQuery = "select t.ID,\n" +
                            "    t.DESCRIPCION,\n" +
                            "    t.ESTADOTAREAID\n" +
                            "from TAREAS as t\n" +
                            "inner join PROYECTOS as p\n" +
                            "on t.PROYECTOID = p.ID\n" +
                            "where p.ID = ?";
            
            PreparedStatement ps = cn.prepareStatement(sqlQuery);
            ps.setInt(1, proyectoId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Id.add(Integer.toString(rs.getInt("ID")));
                descripciones.add(rs.getString("DESCRIPCION"));
                estados.add(Integer.toString(rs.getInt("ESTADOTAREAID")));
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

        lista.add(Id);
        lista.add(descripciones);
        lista.add(estados);
        
        return lista;
    }
    
    public List listarDetalles(int tareaId){
        List<List<String>> lista = new ArrayList<>();
        
        java.sql.Connection cn = null;
        List<String> Id = new ArrayList<>();
        List<String> nombres = new ArrayList<>();

        try {
            cn = connection.getConnection();

            String sqlQuery = "select m.ID, m.NOMBRES\n" +
                            "from DETALLE_TAREAS_MIEMBRO as dtm\n" +
                            "inner join MIEMBROS as m\n" +
                            "on dtm.MIEMBROID = m.ID\n" +
                            "where dtm.TAREAID = ?";
            
            PreparedStatement ps = cn.prepareStatement(sqlQuery);
            ps.setInt(1, tareaId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Id.add(Integer.toString(rs.getInt("ID")));
                nombres.add(rs.getString("NOMBRES"));
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

        lista.add(Id);
        lista.add(nombres);
        
        return lista;
    }
    
    public int listarUltimoDetalle(int tareaId){
        java.sql.Connection cn = null;
        
        int detalleId = 0;

        try {
            cn = connection.getConnection();

            String sqlQuery = "select m.ID, m.NOMBRES\n" +
                            "from DETALLE_TAREAS_MIEMBRO as dtm\n" +
                            "inner join MIEMBROS as m\n" +
                            "on dtm.MIEMBROID = m.ID\n" +
                            "where dtm.TAREAID = ?";
            
            PreparedStatement ps = cn.prepareStatement(sqlQuery);
            ps.setInt(1, tareaId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                detalleId = rs.getInt("ID");
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
        
        return detalleId;
    }
    
    public void modificarEstado(int tareaId, int nuevoEstado){        
        java.sql.Connection cn = null;

        try {
            cn = connection.getConnection();

            String sqlQuery = "update Tareas set ESTADOTAREAID = ? where Id = ?";
            
            PreparedStatement ps = cn.prepareStatement(sqlQuery);
            ps.setInt(1, nuevoEstado);
            ps.setInt(2, tareaId);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                cn.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    public void modificarTarea(String descripcion, int tareaId){
        java.sql.Connection cn = null;

        try {
            cn = connection.getConnection();

            String sqlQuery = "update TAREAS set DESCRIPCION = ? where Id = ?";
            
            PreparedStatement ps = cn.prepareStatement(sqlQuery);
            ps.setString(1, descripcion);
            ps.setInt(2, tareaId);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                cn.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    public void eliminarDetalle(int detalleId){
        java.sql.Connection cn = null;

        try {
            cn = connection.getConnection();

            String sqlQuery = "delete from DETALLE_TAREAS_MIEMBRO where MIEMBROID = ?";
            
            PreparedStatement ps = cn.prepareStatement(sqlQuery);
            ps.setInt(1, detalleId);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                cn.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
