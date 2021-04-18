
package vistas;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import proyecto_final.Miembro;
import proyecto_final.Administrador;

public class FrmLogin extends javax.swing.JFrame {
    
FondoPanel fondo= new FondoPanel();
    public FrmLogin() {
        this.setContentPane(fondo);
        initComponents();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        LbTitulo = new javax.swing.JLabel();
        LbUsuario = new javax.swing.JLabel();
        LbClave = new javax.swing.JLabel();
        TxtUsuario = new javax.swing.JTextField();
        TxtClave = new javax.swing.JPasswordField();
        BtnLogin = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        LbTitulo.setFont(new java.awt.Font("Roboto", 1, 36)); // NOI18N
        LbTitulo.setForeground(new java.awt.Color(52, 73, 85));
        LbTitulo.setText("LOGIN");

        LbUsuario.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        LbUsuario.setForeground(new java.awt.Color(35, 47, 52));
        LbUsuario.setText("Usuario");

        LbClave.setFont(new java.awt.Font("Roboto", 0, 24)); // NOI18N
        LbClave.setForeground(new java.awt.Color(35, 47, 52));
        LbClave.setText("Clave");

        TxtUsuario.setBackground(new java.awt.Color(255, 255, 255));
        TxtUsuario.setForeground(new java.awt.Color(114, 54, 18));
        TxtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtUsuarioActionPerformed(evt);
            }
        });

        TxtClave.setBackground(new java.awt.Color(255, 255, 255));
        TxtClave.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TxtClaveKeyPressed(evt);
            }
        });

        BtnLogin.setBackground(new java.awt.Color(216, 161, 60));
        BtnLogin.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        BtnLogin.setForeground(new java.awt.Color(35, 47, 52));
        BtnLogin.setText("Ingresar");
        BtnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(TxtClave)
                            .addComponent(TxtUsuario)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(LbClave)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(LbUsuario)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LbTitulo)
                .addGap(260, 260, 260))
            .addGroup(layout.createSequentialGroup()
                .addGap(232, 232, 232)
                .addComponent(BtnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(251, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(LbTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(289, 289, 289)
                .addComponent(LbUsuario)
                .addGap(26, 26, 26)
                .addComponent(TxtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(LbClave)
                .addGap(18, 18, 18)
                .addComponent(TxtClave, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BtnLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLoginActionPerformed
        
        this.iniciarSession();
    }//GEN-LAST:event_BtnLoginActionPerformed

    private void TxtClaveKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtClaveKeyPressed
        if(evt.getKeyCode() == 10){
            this.iniciarSession();
        }
    }//GEN-LAST:event_TxtClaveKeyPressed

    private void TxtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtUsuarioActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmLogin().setVisible(true);
            }
        });
    }
    
    // METODOS DE LA CLASE.
    public void iniciarSession(){
        Miembro miembro = new Administrador();
        if(miembro.IniciarSesion(TxtUsuario.getText().trim(), TxtClave.getText().trim())){
            String usuario = TxtUsuario.getText().trim();
            String rol = miembro.getRol(TxtUsuario.getText().trim());
            String[] datosUsuario = new String[]{usuario, rol};
            
            FrmMain Main = new FrmMain(datosUsuario);
            Main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Main.setLocationRelativeTo(null);
            Main.setVisible(true);
            Main.setExtendedState(MAXIMIZED_BOTH);
            this.dispose();
        }
        else{
            JOptionPane.showMessageDialog(null, "Usuario y/o clave incorrectos");
        }
    }
    class FondoPanel extends JPanel{
    private Image imagen;
    @Override
    public void paint(Graphics g){
    try{
        
        imagen = new ImageIcon(getClass().getResource("/imagenes/programmer-group-computers.jpg")).getImage();
    g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
        
        setOpaque(false);
        super.paint(g);
        
        }catch(Exception e){}
    }
    
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnLogin;
    private javax.swing.JLabel LbClave;
    private javax.swing.JLabel LbTitulo;
    private javax.swing.JLabel LbUsuario;
    private javax.swing.JPasswordField TxtClave;
    private javax.swing.JTextField TxtUsuario;
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}
