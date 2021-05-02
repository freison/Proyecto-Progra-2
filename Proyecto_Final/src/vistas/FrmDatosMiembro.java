
package vistas;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import proyecto_final.Connection;
import proyecto_final.Miembro;
import proyecto_final.Administrador;

public class FrmDatosMiembro extends javax.swing.JFrame {
   
    private static int ID = 0;
    
    // CONSTRUCTOR DE LA CLASE.
    public FrmDatosMiembro(int Id, String nombres, String apellidos,
                    String usuario, String cedula, String rol){
       
        initComponents();;
        ID = Id;
        this.TxtNombres.setText(nombres);
        this.TxtApellidos.setText(apellidos);
        this.TxtUsuario.setText(usuario);
        this.TxtCedula.setText(cedula);
        
        llenarComboBox();
        tipoMiembro(rol);
    }
    public FrmDatosMiembro() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The
     * content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        TxtNombres = new javax.swing.JTextField();
        TxtApellidos = new javax.swing.JTextField();
        BtnCerrar = new javax.swing.JButton();
        TxtUsuario = new javax.swing.JTextField();
        TxtClave = new javax.swing.JTextField();
        TxtCedula = new javax.swing.JTextField();
        TipoMiembroComboBox = new javax.swing.JComboBox<>();
        btnGuardar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Panel.setBackground(new java.awt.Color(0, 42, 104));
        Panel.setToolTipText("Modificar Miembros");

        jLabel3.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(216, 161, 60));
        jLabel3.setText("Apellidos");

        jLabel4.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(216, 161, 60));
        jLabel4.setText("Usuario");

        jLabel5.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(216, 161, 60));
        jLabel5.setText("Clave");

        jLabel6.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(216, 161, 60));
        jLabel6.setText("Cedula");

        TxtNombres.setBackground(new java.awt.Color(255, 255, 255));
        TxtNombres.setForeground(new java.awt.Color(114, 54, 18));

        TxtApellidos.setBackground(new java.awt.Color(255, 255, 255));
        TxtApellidos.setForeground(new java.awt.Color(114, 54, 18));
        TxtApellidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtApellidosActionPerformed(evt);
            }
        });

        BtnCerrar.setBackground(new java.awt.Color(216, 161, 60));
        BtnCerrar.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        BtnCerrar.setForeground(new java.awt.Color(35, 47, 52));
        BtnCerrar.setText("CERRAR");
        BtnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCerrarActionPerformed(evt);
            }
        });

        TxtUsuario.setBackground(new java.awt.Color(255, 255, 255));
        TxtUsuario.setForeground(new java.awt.Color(114, 54, 18));

        TxtClave.setBackground(new java.awt.Color(255, 255, 255));
        TxtClave.setForeground(new java.awt.Color(114, 54, 18));
        TxtClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtClaveActionPerformed(evt);
            }
        });

        TxtCedula.setBackground(new java.awt.Color(255, 255, 255));
        TxtCedula.setForeground(new java.awt.Color(114, 54, 18));
        TxtCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtCedulaActionPerformed(evt);
            }
        });

        TipoMiembroComboBox.setBackground(new java.awt.Color(255, 255, 255));
        TipoMiembroComboBox.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        TipoMiembroComboBox.setForeground(new java.awt.Color(114, 54, 18));
        TipoMiembroComboBox.setName("TipoMiembroComboBox"); // NOI18N
        TipoMiembroComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TipoMiembroComboBoxActionPerformed(evt);
            }
        });

        btnGuardar.setBackground(new java.awt.Color(216, 161, 60));
        btnGuardar.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(35, 47, 52));
        btnGuardar.setText("GUARDAR");
        btnGuardar.setMaximumSize(new java.awt.Dimension(77, 24));
        btnGuardar.setMinimumSize(new java.awt.Dimension(77, 24));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(216, 161, 60));
        jLabel1.setText("Modificar Miembro");

        jLabel2.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(216, 161, 60));
        jLabel2.setText("Nombres");

        jLabel7.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(216, 161, 60));
        jLabel7.setText("Tipo Miembro");

        javax.swing.GroupLayout PanelLayout = new javax.swing.GroupLayout(Panel);
        Panel.setLayout(PanelLayout);
        PanelLayout.setHorizontalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLayout.createSequentialGroup()
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(PanelLayout.createSequentialGroup()
                                .addComponent(BtnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(95, 95, 95)
                                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(TxtApellidos, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                                .addComponent(TxtNombres)
                                .addComponent(TxtUsuario)
                                .addComponent(TxtClave)
                                .addComponent(TxtCedula))
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jLabel1)))
                .addGap(0, 30, Short.MAX_VALUE))
            .addGroup(PanelLayout.createSequentialGroup()
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(TipoMiembroComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelLayout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(jLabel7)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelLayout.setVerticalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(20, 20, 20)
                .addComponent(TxtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel3)
                .addGap(20, 20, 20)
                .addComponent(TxtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel4)
                .addGap(20, 20, 20)
                .addComponent(TxtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel5)
                .addGap(20, 20, 20)
                .addComponent(TxtClave, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(20, 20, 20)
                .addComponent(TxtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(TipoMiembroComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnCerrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCerrarActionPerformed
        
        FrmMiembro miembro = new FrmMiembro();
        miembro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int height = screenSize.height;
        int width = screenSize.width;
        miembro.setSize(width/2, height/2);
        miembro.setLocationRelativeTo(null);
        miembro.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BtnCerrarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        Miembro miembro = new Administrador(); // POLIMORFISMO
        String rolPrevio = miembro.getRol(ID).toString().trim();
        String rol = TipoMiembroComboBox.getSelectedItem().toString().trim();
        
        miembro.actualizarMiembro(ID, this.TxtNombres.getText().toString().trim(), this.TxtApellidos.getText().toString().trim(),
            TxtUsuario.getText().toString().trim(), TxtCedula.getText().toString().trim(),
            TipoMiembroComboBox.getSelectedItem().toString().trim());
        
        if(!rol.equalsIgnoreCase(rolPrevio)){
            miembro.actualizarRol(ID, rolPrevio, rol);
        }
        
        JOptionPane.showMessageDialog(null, "Se ha modificado correctamente");
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void TxtApellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtApellidosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtApellidosActionPerformed

    private void TxtClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtClaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtClaveActionPerformed

    private void TxtCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtCedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtCedulaActionPerformed

    private void TipoMiembroComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TipoMiembroComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TipoMiembroComboBoxActionPerformed

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
            java.util.logging.Logger.getLogger(FrmDatosMiembro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmDatosMiembro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmDatosMiembro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmDatosMiembro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmDatosMiembro().setVisible(true);
            }
        });
    }
    
    // METODOS DE LA CLASE.
    public void llenarComboBox(){
        TipoMiembroComboBox.removeAllItems();
        TipoMiembroComboBox.addItem("Administrador");
        TipoMiembroComboBox.addItem("Editor");
        TipoMiembroComboBox.addItem("Invitado");
    }
    
    public void tipoMiembro(String rol){
        TipoMiembroComboBox.setSelectedIndex(
                rol.equals("Administrador") ? 
                        0 
                        : (rol.equals("Editor") ? 1 
                                : 2)
        );
   
    }
     /*       class FondoPanelDatosMiembro extends JPanel{
    private Image imagen;
    @Override
    public void paint(Graphics g){
    try{
        
        imagen = new ImageIcon(getClass().getResource("/imagenes/fondoazul.jpg")).getImage();
    g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
        
        setOpaque(false);
        super.paint(g);
        
        }catch(Exception e){}
    }
    
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCerrar;
    private javax.swing.JPanel Panel;
    private javax.swing.JComboBox<String> TipoMiembroComboBox;
    private javax.swing.JTextField TxtApellidos;
    private javax.swing.JTextField TxtCedula;
    private javax.swing.JTextField TxtClave;
    private javax.swing.JTextField TxtNombres;
    private javax.swing.JTextField TxtUsuario;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    // End of variables declaration//GEN-END:variables
}
