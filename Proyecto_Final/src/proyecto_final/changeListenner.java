
package proyecto_final;
import vistas.FrmDatosProyectos;

public class changeListenner extends Thread {
    // 1. Atributos: Informacion;
    FrmDatosProyectos referencia;
    
    // 2. Crearlo: Constructor.
    public changeListenner(String name, FrmDatosProyectos referencia){
        super();
        
        this.setName(name);
        this.setPriority(MAX_PRIORITY);
        this.setDaemon(true);
        
        this.referencia = referencia;
    }

    @Override
    public void run() {
        while(true){
            try {
                System.out.println(getName() + " run");
                referencia.getPnPanel().revalidate();
                sleep(3000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
