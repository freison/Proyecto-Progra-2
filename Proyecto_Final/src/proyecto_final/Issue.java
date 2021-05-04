
package proyecto_final;

import java.time.LocalDate;

public class Issue {
    // ATRIBUTOS DE LA CLASE.
    private String titulo;
    private String descripcion;
    private int proyectoId;
    private int miembroId;
    private LocalDate fechaCreado;
    
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
    
}
