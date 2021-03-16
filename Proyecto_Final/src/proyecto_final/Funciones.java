
package proyecto_final;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class Funciones {
    private static Connection connection = new Connection();
    
    // METODOS DE LA CLASE.
    /***
     * Determina el rol de un Miembro en base a su Id.
     * @param Id
     * @return String
     */
    public static String getRol(int Id){
        String rol = "";
        java.sql.Connection cn = null;
        
        try{
            cn = connection.getConnection();
            
            String query = "select Rol from(\n" +
                        "    select m.ID,\n" +
                        "    m.NOMBRES as Nombres,\n" +
                        "    m.APELLIDOS as Apellidos,\n" +
                        "    m.USUARIO as Usuario,\n" +
                        "    m.CEDULA as Cedula,\n" +
                        "case a.ID\n" +
                        "    when is not null then 'Administrador'\n" +
                        "    else\n" +
                        "        case e.ID\n" +
                        "            when is not null then 'Editor'\n" +
                        "            else 'Invitado'\n" +
                        "        end\n" +
                        "end as Rol\n" +
                        "from Miembros as m\n" +
                        "left join Administradores as a on m.ID = a.MIEMBROID\n" +
                        "left join Editores as e on m.ID = e.MIEMBROID\n" +
                        "left join Invitados as i on m.ID = i.MIEMBROID\n" +
                        "where \n" +
                        "m.ID = ?\n" +
                        ") as Rol";
            
            PreparedStatement pstmt = cn.prepareStatement(query);
            pstmt.setInt(1, Id);
            ResultSet rs = pstmt.executeQuery();
            
            while(rs.next()){
                rol = rs.getString("Rol");
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
        return rol;
    }
}
