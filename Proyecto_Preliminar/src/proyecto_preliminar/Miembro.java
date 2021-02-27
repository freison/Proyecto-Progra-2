/*
Universidad Fidelitas.
Programacion Cliente Servidor.
Elaborado por: Freison Castro.
Clase Miembro.
*/

package proyecto_preliminar;

import java.util.List;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public abstract class Miembro{
    // ATRIBUTOS DE LA CLASE.
    protected String ID;
    protected String nombres;
    protected String apellidos;
    protected String usuario;
    protected String clave;
    protected String cedula;
    protected Proyecto[] proyectosParticipacion;
    
    private Connection connection = new Connection();
    
    // CONSTRUCTOR DE LA CLASE.
    // Constructor sin parametros.
    public Miembro(){
        this.ID = "";
        this.nombres = "";
        this.apellidos = "";
        this.usuario = "";
        this.clave = "";
        this.cedula = "";
        this.proyectosParticipacion = null;
    }
    
    // Constructor con parametros V1
    public Miembro(String ID, String nombres, String apellidos,
            String usuario, String clave, String cedula){
        this.ID = ID;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.usuario = usuario;
        this.clave = clave;
        this.cedula = cedula;
    }
    
    // Constructor con parametros V2
    public Miembro(String ID, String nombres, String apellidos, 
            String usuario, String clave,String cedula, 
            Proyecto[] proyectosParticipacion){
        this.ID = ID;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.usuario = usuario;
        this.clave = clave;
        this.cedula = cedula;
        this.proyectosParticipacion = proyectosParticipacion;
    }
    
    // GETTERS Y SETTERS DE LA CLASE.
    public String getNombres(){
        return this.nombres;
    }
    
    public void setNombres(String nombres){
        this.nombres = nombres;
    }
    
    public String getApellidos(){
        return this.apellidos;
    }
    
    public void setApellidos(String apellidos){
        this.apellidos = apellidos;
    }
    
    public String getUsuario(){
        return this.usuario;
    }
    
    public void setUsuario(String usuario){
        this.usuario = usuario;
    }
    
    public String getClave(){
        return this.clave;
    }
    
    public void setClave(String clave){
        this.clave = clave;
    }
    
    public String getCedula(){
        return this.cedula;
    }
    
    public void setCedula(String cedula){
        this.cedula = cedula;
    }
    
    public Proyecto[] getProyectosParticipacion(){
        return this.proyectosParticipacion;
    }
    
    public void setProyectosParticipacion(Proyecto[] proyectosParticipacion){
        this.proyectosParticipacion = proyectosParticipacion;
    }
    
    // METODOS DE LA CLASE.
    @Override
    public String toString(){
        return "Nombre: " + this.getNombres()
                + "\nApellidos: " + this.getApellidos()
                + "\nCédula: " + this.getCedula();
    }
    
    public void actualizarMiembro(int Id, String nombres, String apellidos,
                String usuario, String cedula, String rol){
        java.sql.Connection cn = null;
        try{
            cn = connection.getConnection();
            
            Statement stmt = cn.createStatement();
            stmt.executeUpdate("call Update_Miembro('"+Id+"', '"+nombres+"', '"+apellidos+"', '"+usuario+"', '"+cedula+"', '"+rol+"');");
            System.out.println("DONE");
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
    
    public int buscarUltimoMiembro(){
        
        int Id = 0;
        
        java.sql.Connection cn = null;
        try{
            cn = connection.getConnection();
            
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from Miembros order by Id desc limit 1");
            
            while(rs.next()){
                System.out.println(rs.getString("Id"));
                Id = rs.getInt("Id");
            }
            
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
        
        return Id;
    }
    
    public List[] listarMiembros(){
        java.sql.Connection cn = null;
        List<Integer> id = new ArrayList<>();
        List<String> nombres = new ArrayList<>();
        List<String> apellidos = new ArrayList<>();
        List<String> usuarios = new ArrayList<>();
        List<String> cedulas = new ArrayList<>();
        List<String> roles = new ArrayList<>();
        
        List[] listas = new List[6];
        
        try{
            cn = connection.getConnection();
            
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(
                    "select m.Id, m.name as Nombres, "
                     + "m.apellidos as Apellidos, "
                     + "m.usuario as Usuario, "
                     + "m.cedula as Cedula , "
                     + "if(a.Id is not null, \"Administrador\", if(e.Id is not null, \"Editor\", \"Invitado\")) as Rol "
                     + "from Miembros as m "
                     + "LEFT join Administradores as a on m.Id = a.MiembroId "
                     + "LEFT join Editores e on m.Id = e.MiembroId "
                     + "LEFT join Invitados as i on m.Id = i.MiembroId"
            );
            
            while(rs.next()){
                id.add(rs.getInt("Id"));
                nombres.add(rs.getString("Nombres"));
                apellidos.add(rs.getString("Apellidos"));
                usuarios.add(rs.getString("Usuario"));
                cedulas.add(rs.getString("Cedula"));
                roles.add(rs.getString("Rol"));
            }
            
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
        
        listas[0] = id;
        listas[1] = nombres;
        listas[2] = apellidos;
        listas[3] = usuarios;
        listas[4] = cedulas;
        listas[5] = roles;
        
        return listas;
    }
    
    public List[] listarMiembros(String rol){
        java.sql.Connection cn = null;
        List<Integer> id = new ArrayList<>();
        List<String> nombres = new ArrayList<>();
        List<String> apellidos = new ArrayList<>();
        List<String> usuarios = new ArrayList<>();
        List<String> cedulas = new ArrayList<>();
        List<String> roles = new ArrayList<>();
        
        List[] listas = new List[6];
        
        try{
            cn = connection.getConnection();
            
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(
                    "select m.Id, m.name as Nombres, "
                     + "m.apellidos as Apellidos, "
                     + "m.usuario as Usuario, "
                     + "m.cedula as Cedula , "
                     + "if(a.Id is not null, \"Administrador\", if(e.Id is not null, \"Editor\", \"Invitado\")) as Rol "
                     + "from Miembros as m "
                     + "LEFT join Administradores as a on m.Id = a.MiembroId "
                     + "LEFT join Editores e on m.Id = e.MiembroId "
                     + "LEFT join Invitados as i on m.Id = i.MiembroId "
                     + "where "
                     + "(select (if(a.Id is not null, \"Administrador\", if(e.Id is not null, \"Editor\", \"Invitado\")))) = '"+rol+"'"
            );
            
            while(rs.next()){
                id.add(rs.getInt("Id"));
                nombres.add(rs.getString("Nombres"));
                apellidos.add(rs.getString("Apellidos"));
                usuarios.add(rs.getString("Usuario"));
                cedulas.add(rs.getString("Cedula"));
                roles.add(rs.getString("Rol"));
            }
            
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
        
        listas[0] = id;
        listas[1] = nombres;
        listas[2] = apellidos;
        listas[3] = usuarios;
        listas[4] = cedulas;
        listas[5] = roles;
        
        return listas;
    }
    
    public List[] listarMiembros(String rol1, String rol2){
        java.sql.Connection cn = null;
        List<Integer> id = new ArrayList<>();
        List<String> nombres = new ArrayList<>();
        List<String> apellidos = new ArrayList<>();
        List<String> usuarios = new ArrayList<>();
        List<String> cedulas = new ArrayList<>();
        List<String> roles = new ArrayList<>();
        
        List[] listas = new List[6];
        
        try{
            cn = connection.getConnection();
            
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(
                    "select m.Id, m.name as Nombres, "
                     + "m.apellidos as Apellidos, "
                     + "m.usuario as Usuario, "
                     + "m.cedula as Cedula , "
                     + "if(a.Id is not null, \"Administrador\", if(e.Id is not null, \"Editor\", \"Invitado\")) as Rol "
                     + "from Miembros as m "
                     + "LEFT join Administradores as a on m.Id = a.MiembroId "
                     + "LEFT join Editores e on m.Id = e.MiembroId "
                     + "LEFT join Invitados as i on m.Id = i.MiembroId "
                     + "where "
                     + "(select (if(a.Id is not null, \"Administrador\", if(e.Id is not null, \"Editor\", \"Invitado\")))) = '"+rol1+"' OR "
                     + "(select (if(a.Id is not null, \"Administrador\", if(e.Id is not null, \"Editor\", \"Invitado\")))) = '"+rol2+"'"
            );
            
            while(rs.next()){
                id.add(rs.getInt("Id"));
                nombres.add(rs.getString("Nombres"));
                apellidos.add(rs.getString("Apellidos"));
                usuarios.add(rs.getString("Usuario"));
                cedulas.add(rs.getString("Cedula"));
                roles.add(rs.getString("Rol"));
            }
            
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
        
        listas[0] = id;
        listas[1] = nombres;
        listas[2] = apellidos;
        listas[3] = usuarios;
        listas[4] = cedulas;
        listas[5] = roles;
        
        return listas;
    }
    
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
} // Fin de Clase Miembro.
