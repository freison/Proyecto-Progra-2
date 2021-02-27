/*
Proyecto preliminar.
Programación Cliente Servidor.
Universidad Fidélitas.
Elaborado por: Freison Castro, Jose Carlo, Joshua
Hola mundo

*/
package proyecto_preliminar;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import vistas.MainForm;
import vistas.NuevoMiembroForm;
import vistas.MiembroForm;

public class Proyecto_Preliminar {

    public static void main(String[] args) {
//        Administrador ad = new Administrador("01", "Freison", "Castro", "000");
//        // ad.setNombres("Freison Antonio");
//        System.out.println(ad.getNombres());
//        
//        Invitado invitado = new Invitado("02", "Antonio", "Sanchez", "111");
//        System.out.println(ad.getNombres());
//        System.out.println(invitado.getNombres());

          LoadMainForm();
    }
    
    public static void LoadMainForm(){
        MiembroForm Main = new MiembroForm();
        Main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension screeSize = Toolkit.getDefaultToolkit().getScreenSize();
        int height = screeSize.height;
        int width = screeSize.width;
        Main.setSize(width/2, height/2);
        Main.setLocationRelativeTo(null);
        Main.setVisible(true);
    }
}
