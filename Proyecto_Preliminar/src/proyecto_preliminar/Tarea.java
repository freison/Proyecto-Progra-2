package proyecto_preliminar;

public class Tarea{
    // ATRIBUTOS DE LA CLASE.
    private String ID;
    private String descripcion;
    
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
}// Fin de Clase Tarea.
