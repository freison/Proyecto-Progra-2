/***
 * Universidad Fidélitas.
 * Proyecto Programación Cliente Servidor.
 * Elaborado por:
 * - Freison Castro Sánchez
 * - Jose Carlo Morales Morales
 * - Joshua Vega
 */

package proyecto_final;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import vistas.FrmMiembro;
import vistas.FrmNuevoMiembro;
import vistas.FrmMain;
import vistas.FrmLogin;

public class Proyecto_Final {

    public static void main(String[] args) {
        
        LoadMainForm();
    }
    
    public static void LoadMainForm(){
        FrmLogin Main = new FrmLogin();
        Main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension screeSize = Toolkit.getDefaultToolkit().getScreenSize();
        int height = screeSize.height;
        int width = screeSize.width;
        // Main.setSize(width/2, height/2);
        Main.setLocationRelativeTo(null);
        Main.setVisible(true);
    }
}
