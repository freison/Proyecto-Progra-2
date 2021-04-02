
package proyecto_final;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

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
    public void Agregar(int proyectoId){
        java.sql.Connection cn = null;
        
        try{
            cn = connection.getConnection();
            
            PreparedStatement stmt = cn.prepareStatement("insert into ESTADOSTAREA(Descripcion, ProyectoId) values(?, ?)");
            stmt.setString(1, this.getDescripcion());
            stmt.setInt(2, proyectoId);
            stmt.executeUpdate();

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
    
    public List listarEstadosPorProyecto(int proyectoId){
        java.sql.Connection cn = null;
        List<Integer> id = new ArrayList<>();
        List<String> descripcion = new ArrayList<>();

        List listas = new ArrayList();

        try {
            cn = connection.getConnection();

            String sqlQuery = "Select * from ESTADOSTAREA where proyectoId = ?";
            PreparedStatement ps = cn.prepareStatement(sqlQuery);
            ps.setInt(1, proyectoId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                id.add(rs.getInt("Id"));
                descripcion.add(rs.getString("Descripcion"));
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

        listas.add(id);
        listas.add(descripcion);

        return listas;
    }
}
