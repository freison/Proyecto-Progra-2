/** *
 * Universidad Fidélitas.
 * Proyecto Programación Cliente Servidor.
 *
 * Clase Abstracta Miembro
 */
package proyecto_final;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public abstract class Miembro {

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
    public Miembro() {
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
            String usuario, String clave, String cedula) {
        this.ID = ID;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.usuario = usuario;
        this.clave = clave;
        this.cedula = cedula;
    }

    // Constructor con parametros V2
    public Miembro(String ID, String nombres, String apellidos,
            String usuario, String clave, String cedula,
            Proyecto[] proyectosParticipacion) {
        this.ID = ID;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.usuario = usuario;
        this.clave = clave;
        this.cedula = cedula;
        this.proyectosParticipacion = proyectosParticipacion;
    }

    // GETTERS Y SETTERS DE LA CLASE.
    public String getNombres() {
        return this.nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return this.apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getUsuario() {
        return this.usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return this.clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getCedula() {
        return this.cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public Proyecto[] getProyectosParticipacion() {
        return this.proyectosParticipacion;
    }

    public void setProyectosParticipacion(Proyecto[] proyectosParticipacion) {
        this.proyectosParticipacion = proyectosParticipacion;
    }

    // METODOS DE LA CLASE.
    @Override
    public String toString() {
        return "Nombre: " + this.getNombres()
                + "\nApellidos: " + this.getApellidos()
                + "\nCédula: " + this.getCedula()
                + "\nUsuario: " + this.getUsuario();
    }

    public abstract void Agregar();

    /**
     * *
     * Metodo que retorna el Id del ultimo miembro agregado.
     *
     * @return int
     */
    public int buscarUltimoMiembro() {
        int Id = 0;

        java.sql.Connection cn = null;
        try {
            cn = connection.getConnection();

            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from Miembros order by Id desc fetch first row only");

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

        System.out.println(Id == 105);
        return Id;
    }

    /**
     * *
     * Metodo que lista todos los Miembros con su datos.
     *
     * @return List[]
     */
    public List[] listarMiembros() {
        java.sql.Connection cn = null;
        List<Integer> id = new ArrayList<>();
        List<String> nombres = new ArrayList<>();
        List<String> apellidos = new ArrayList<>();
        List<String> usuarios = new ArrayList<>();
        List<String> cedulas = new ArrayList<>();
        List<String> roles = new ArrayList<>();

        List[] listas = new List[6];

        try {
            cn = connection.getConnection();

            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(
                    "select m.ID,\n"
                    + "    m.NOMBRES as Nombres,\n"
                    + "    m.APELLIDOS as Apellidos,\n"
                    + "    m.USUARIO as Usuario,\n"
                    + "    m.CEDULA as Cedula,\n"
                    + "case a.ID\n"
                    + "    when is not null then 'Administrador'\n"
                    + "    else\n"
                    + "        case e.ID\n"
                    + "            when is not null then 'Editor'\n"
                    + "            else 'Invitado'\n"
                    + "        end\n"
                    + "end as Rol\n"
                    + "from Miembros as m\n"
                    + "left join Administradores as a on m.ID = a.MIEMBROID\n"
                    + "left join Editores as e on m.ID = e.MIEMBROID\n"
                    + "left join Invitados as i on m.ID = i.MIEMBROID"
            );

            while (rs.next()) {
                id.add(rs.getInt("Id"));
                nombres.add(rs.getString("Nombres"));
                apellidos.add(rs.getString("Apellidos"));
                usuarios.add(rs.getString("Usuario"));
                cedulas.add(rs.getString("Cedula"));
                roles.add(rs.getString("Rol"));
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
        listas[2] = apellidos;
        listas[3] = usuarios;
        listas[4] = cedulas;
        listas[5] = roles;

        return listas;
    }
    
    public List[] listarMiembrosPorProyecto(int ProyectoId) {
        java.sql.Connection cn = null;
        List<Integer> id = new ArrayList<>();
        List<String> nombres = new ArrayList<>();
        List<String> apellidos = new ArrayList<>();
        List<String> usuarios = new ArrayList<>();
        List<String> cedulas = new ArrayList<>();
        List<String> roles = new ArrayList<>();

        List[] listas = new List[6];

        try {
            cn = connection.getConnection();
            
            String sqlQuery = "select m.ID,\n" +
                            "    m.NOMBRES,\n" +
                            "    m.APELLIDOS,\n" +
                            "    m.USUARIO,\n" +
                            "    m.CEDULA,\n" +
                            "    case a.ID\n" +
                            "        when is not null then 'Administrador'\n" +
                            "        else\n" +
                            "            case e.ID\n" +
                            "                when is not null then 'Editor'\n" +
                            "                else 'Invitado'\n" +
                            "            end\n" +
                            "        end as Rol\n" +
                            "from PROYECTOS as p\n" +
                            "inner join DETALLE_PROYECTOS_PARTICIPACION as dmp\n" +
                            "on p.ID = dmp.PROYECTOID\n" +
                            "inner join MIEMBROS as m\n" +
                            "on dmp.MIEMBROID = m.ID\n" +
                            "left join ADMINISTRADORES as a\n" +
                            "on m.ID = a.MIEMBROID\n" +
                            "left join EDITORES as e\n" +
                            "on m.ID = e.MIEMBROID\n" +
                            "left join INVITADOS as i\n" +
                            "on m.ID = i.MIEMBROID\n" +
                            "where p.ID = ? and \n" +
                            "case a.ID\n" +
                            "when is not null then 'Administrador'\n" +
                            "else\n" +
                            "    case e.ID\n" +
                            "        when is not null then 'Editor'\n" +
                            "        else 'Invitado'\n" +
                            "    end\n" +
                            "end != 'Invitado'";
            
            PreparedStatement ps = cn.prepareStatement(sqlQuery);
            ps.setInt(1, ProyectoId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                id.add(rs.getInt("Id"));
                nombres.add(rs.getString("Nombres"));
                apellidos.add(rs.getString("Apellidos"));
                usuarios.add(rs.getString("Usuario"));
                cedulas.add(rs.getString("Cedula"));
                roles.add(rs.getString("Rol"));
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
        listas[2] = apellidos;
        listas[3] = usuarios;
        listas[4] = cedulas;
        listas[5] = roles;

        return listas;
    }

    /**
     * *
     * Metodo que lista todos los miembros de un rol en especifico.
     *
     * @param rol
     * @return List[]
     */
    public List[] listarMiembros(String rol) {
        java.sql.Connection cn = null;
        List<Integer> id = new ArrayList<>();
        List<String> nombres = new ArrayList<>();
        List<String> apellidos = new ArrayList<>();
        List<String> usuarios = new ArrayList<>();
        List<String> cedulas = new ArrayList<>();
        List<String> roles = new ArrayList<>();

        List[] listas = new List[6];

        try {
            cn = connection.getConnection();

            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(
                    "select m.ID,\n"
                    + "    m.NOMBRES as Nombres,\n"
                    + "    m.APELLIDOS as Apellidos,\n"
                    + "    m.USUARIO as Usuario,\n"
                    + "    m.CEDULA as Cedula,\n"
                    + "case a.ID\n"
                    + "    when is not null then 'Administrador'\n"
                    + "    else\n"
                    + "        case e.ID\n"
                    + "            when is not null then 'Editor'\n"
                    + "            else 'Invitado'\n"
                    + "        end\n"
                    + "end as Rol\n"
                    + "from Miembros as m\n"
                    + "left join Administradores as a on m.ID = a.MIEMBROID\n"
                    + "left join Editores as e on m.ID = e.MIEMBROID\n"
                    + "left join Invitados as i on m.ID = i.MIEMBROID\n"
                    + "where \n"
                    + "case a.ID\n"
                    + "    when is not null then 'Administrador'\n"
                    + "    else\n"
                    + "        case e.ID\n"
                    + "            when is not null then 'Editor'\n"
                    + "            else 'Invitado'\n"
                    + "        end\n"
                    + "end = '" + rol + "'"
            );

            while (rs.next()) {
                id.add(rs.getInt("Id"));
                nombres.add(rs.getString("Nombres"));
                apellidos.add(rs.getString("Apellidos"));
                usuarios.add(rs.getString("Usuario"));
                cedulas.add(rs.getString("Cedula"));
                roles.add(rs.getString("Rol"));
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
        listas[2] = apellidos;
        listas[3] = usuarios;
        listas[4] = cedulas;
        listas[5] = roles;

        return listas;
    }

    /**
     * *
     * Metodo que lista todos los miembros de dos roles especificados.
     *
     * @param rol1
     * @param rol2
     * @return List[]
     */
    public List[] listarMiembros(String rol1, String rol2) {
        java.sql.Connection cn = null;
        List<Integer> id = new ArrayList<>();
        List<String> nombres = new ArrayList<>();
        List<String> apellidos = new ArrayList<>();
        List<String> usuarios = new ArrayList<>();
        List<String> cedulas = new ArrayList<>();
        List<String> roles = new ArrayList<>();

        List[] listas = new List[6];

        try {
            cn = connection.getConnection();

            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(
                    "select m.ID,\n"
                    + "    m.NOMBRES as Nombres,\n"
                    + "    m.APELLIDOS as Apellidos,\n"
                    + "    m.USUARIO as Usuario,\n"
                    + "    m.CEDULA as Cedula,\n"
                    + "case a.ID\n"
                    + "    when is not null then 'Administrador'\n"
                    + "    else\n"
                    + "        case e.ID\n"
                    + "            when is not null then 'Editor'\n"
                    + "            else 'Invitado'\n"
                    + "        end\n"
                    + "end as Rol\n"
                    + "from Miembros as m\n"
                    + "left join Administradores as a on m.ID = a.MIEMBROID\n"
                    + "left join Editores as e on m.ID = e.MIEMBROID\n"
                    + "left join Invitados as i on m.ID = i.MIEMBROID\n"
                    + "where \n"
                    + "case a.ID\n"
                    + "    when is not null then 'Administrador'\n"
                    + "    else\n"
                    + "        case e.ID\n"
                    + "            when is not null then 'Editor'\n"
                    + "            else 'Invitado'\n"
                    + "        end\n"
                    + "end = '" + rol1 + "' or \n"
                    + "case a.ID\n"
                    + "    when is not null then 'Administrador'\n"
                    + "    else\n"
                    + "        case e.ID\n"
                    + "            when is not null then 'Editor'\n"
                    + "            else 'Invitado'\n"
                    + "        end\n"
                    + "end = '" + rol2 + "'"
            );

            while (rs.next()) {
                id.add(rs.getInt("Id"));
                nombres.add(rs.getString("Nombres"));
                apellidos.add(rs.getString("Apellidos"));
                usuarios.add(rs.getString("Usuario"));
                cedulas.add(rs.getString("Cedula"));
                roles.add(rs.getString("Rol"));
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
        listas[2] = apellidos;
        listas[3] = usuarios;
        listas[4] = cedulas;
        listas[5] = roles;

        return listas;
    }

    /**
     * *
     * Metodo que actualiza un Miembro en especifico.
     *
     * @param Id
     * @param nombres
     * @param apellidos
     * @param usuario
     * @param cedula
     * @param rol
     */
    public void actualizarMiembro(int Id, String nombres, String apellidos, String usuario,
            String cedula, String rol) {
        java.sql.Connection cn = null;

        try {
            cn = connection.getConnection();

            String query = "update Miembros\n"
                    + "    set Nombres = ?, "
                    + "    Apellidos = ?, "
                    + "    usuario = ?, "
                    + "    cedula = ? "
                    + "    where Id = ?";

            PreparedStatement pstmt = cn.prepareStatement(query);
            pstmt.setString(1, nombres);
            pstmt.setString(2, apellidos);
            pstmt.setString(3, usuario);
            pstmt.setString(4, cedula);
            pstmt.setInt(5, Id);
            pstmt.executeUpdate();

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

    /**
     * *
     * Metodo que Actualiza el rol de un Miembro en especifico.
     *
     * @param Id
     * @param rolPrevio
     * @param rol
     */
    public void actualizarRol(int Id, String rolPrevio, String rol) {
        java.sql.Connection cn = null;
        String query = "";

        try {
            cn = connection.getConnection();

            if (rolPrevio.equals("Administrador")) {
                query = "Delete from Administradores where MiembroId = ?";
            } else if (rolPrevio.equals("Editor")) {
                query = "Delete from Editores where MiembroId = ?";
            } else {
                query = "Delete from Invitados where MiembroId = ?";
            }

            PreparedStatement pstmt = cn.prepareStatement(query);
            pstmt.setInt(1, Id);
            pstmt.executeUpdate();

            if (rol.equals("Administrador")) {
                query = "Insert into Administradores(MiembroId) values(?)";
            } else if (rol.equals("Editor")) {
                query = "Insert into Editores(MiembroId) values(?)";
            } else {
                query = "Insert into Invitados(MiembroId) values(?)";
            }

            PreparedStatement pst = cn.prepareStatement(query);
            pst.setInt(1, Id);
            pst.executeUpdate();

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

    /**
     * *
     * Metodo que retorna el Rol de un Miembro en especifico.
     *
     * @param Id
     * @return String
     */
    public String getRol(int Id) {
        String rol = "";
        java.sql.Connection cn = null;

        try {
            cn = connection.getConnection();

            String query = "select Rol from(\n"
                    + "    select m.ID,\n"
                    + "    m.NOMBRES as Nombres,\n"
                    + "    m.APELLIDOS as Apellidos,\n"
                    + "    m.USUARIO as Usuario,\n"
                    + "    m.CEDULA as Cedula,\n"
                    + "case a.ID\n"
                    + "    when is not null then 'Administrador'\n"
                    + "    else\n"
                    + "        case e.ID\n"
                    + "            when is not null then 'Editor'\n"
                    + "            else 'Invitado'\n"
                    + "        end\n"
                    + "end as Rol\n"
                    + "from Miembros as m\n"
                    + "left join Administradores as a on m.ID = a.MIEMBROID\n"
                    + "left join Editores as e on m.ID = e.MIEMBROID\n"
                    + "left join Invitados as i on m.ID = i.MIEMBROID\n"
                    + "where \n"
                    + "m.ID = ?\n"
                    + ") as Rol";

            PreparedStatement pstmt = cn.prepareStatement(query);
            pstmt.setInt(1, Id);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                rol = rs.getString("Rol");
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
        return rol;
    }
    
    /***
     * Retorna el rol de un Miembro en base al usuario.
     * @param usuario
     * @return String
     */
    public String getRol(String usuario) {
        String rol = "";
        java.sql.Connection cn = null;

        try {
            cn = connection.getConnection();

            String query = "select Rol from(\n"
                    + "    select m.ID,\n"
                    + "    m.NOMBRES as Nombres,\n"
                    + "    m.APELLIDOS as Apellidos,\n"
                    + "    m.USUARIO as Usuario,\n"
                    + "    m.CEDULA as Cedula,\n"
                    + "case a.ID\n"
                    + "    when is not null then 'Administrador'\n"
                    + "    else\n"
                    + "        case e.ID\n"
                    + "            when is not null then 'Editor'\n"
                    + "            else 'Invitado'\n"
                    + "        end\n"
                    + "end as Rol\n"
                    + "from Miembros as m\n"
                    + "left join Administradores as a on m.ID = a.MIEMBROID\n"
                    + "left join Editores as e on m.ID = e.MIEMBROID\n"
                    + "left join Invitados as i on m.ID = i.MIEMBROID\n"
                    + "where \n"
                    + "m.USUARIO = ?\n"
                    + ") as Rol";

            PreparedStatement pstmt = cn.prepareStatement(query);
            pstmt.setString(1, usuario);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                rol = rs.getString("Rol");
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
        return rol;
    }
    
    /***
     * Inicia sesion en el sistema
     * @param usuario
     * @param clave
     * @return boolean
     */
    public boolean IniciarSesion(String usuario, String clave){
        boolean flag = false;
        java.sql.Connection cn = null;

        try {
            cn = connection.getConnection();

            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery(
                    "select * from Miembros where usuario = '"+usuario+"' and clave = '"+clave+"'"
            );

            while (rs.next()) {
                flag = true;
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
        
        return flag;
    }
    
    /**
     * Obtiene el Id de Miembro en base al usuario.
     * @param usuario
     * @return 
     */
    public int obtenerId(String usuario){
        int Id = 0;
        
        java.sql.Connection cn = null;
        try{
            cn = connection.getConnection();
            
            Statement stmt = cn.createStatement();
            ResultSet rs = stmt.executeQuery("select m.ID from Miembros as m\n" +
                                             "where m.usuario =   '"+usuario+"'");
            
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
    
}// Fin de Clase Abstracta Miembro.
