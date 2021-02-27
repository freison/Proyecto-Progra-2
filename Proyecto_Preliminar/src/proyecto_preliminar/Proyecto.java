package proyecto_preliminar;

public class Proyecto{
    // ATRIBUTOS DE LA CLASE.
    private String ID;
    private String nombre;
    private String descripcion;
    private Tarea[] tareasPorHacer;
    private Tarea[] tareasEnProceso;
    private Tarea[] tareasFinalizadas;
    
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
    
    public String nombre(){
        return this.nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
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
}
