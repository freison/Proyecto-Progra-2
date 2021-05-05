
package proyecto_final;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import javax.swing.JOptionPane;
import proyecto_final.Connection;

public class Issue {
    // ATRIBUTOS DE LA CLASE.
    private String titulo;
    private String descripcion;
    private int proyectoId;
    private int miembroId;
    private LocalDate fechaCreado;
    
    private Connection connection = new Connection();
    
    // CONSTRUCTORES DE LA CLASE.
    // Constructor sin parametros.
    public Issue(){
        
    }
    
    // Constructor con parametros V1.
    public Issue(String titulo, String descripcion, int proyectoId, int miembroId, LocalDate fechaCreado){
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.proyectoId = proyectoId;
        this.miembroId = miembroId;
        this.fechaCreado = fechaCreado;
    }
    
    // GETTERS Y SETTERS DE LA CLASE.
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getProyectoId() {
        return proyectoId;
    }

    public void setProyectoId(int proyectoId) {
        this.proyectoId = proyectoId;
    }

    public int getMiembroId() {
        return miembroId;
    }

    public void setMiembroId(int miembroId) {
        this.miembroId = miembroId;
    }

    public LocalDate getFechaCreado() {
        return fechaCreado;
    }

    public void setFechaCreado(LocalDate fechaCreado) {
        this.fechaCreado = fechaCreado;
    }
    
    // METODOS DE LA CLASE.
    public void Agregar(){
        java.sql.Connection cn = null;
        
        try{
            cn = connection.getConnection();
            
            PreparedStatement stmt = cn.prepareStatement(
                    "insert into ISSUES(TITULO, DESCRIPCION, PROYECTOID, MIEMBROID, FECHA_CREADO, ESTADO) values(?, ?, ?, ?, ?, ?)"
            );
            stmt.setString(1, this.getTitulo());
            stmt.setString(2, this.getDescripcion());
            stmt.setInt(3, this.getProyectoId());
            stmt.setInt(4, this.getMiembroId());
            stmt.setDate(5, java.sql.Date.valueOf(fechaCreado));
            stmt.setBoolean(6, true);
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
    
    public void Listar(){
        
    }
}
