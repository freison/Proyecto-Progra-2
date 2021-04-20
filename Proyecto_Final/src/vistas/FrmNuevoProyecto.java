
package vistas;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import proyecto_final.Proyecto;

public class FrmNuevoProyecto extends javax.swing.JFrame {
    FondoPanelNuevoProyecto fondo= new FondoPanelNuevoProyecto();
    private String[] datosUsuario = new String[2];

    public FrmNuevoProyecto() {
        this.setContentPane(fondo);
        initComponents();
    }
    
    public FrmNuevoProyecto(String[] datosUsuario){
        this.setContentPane(fondo);
        initComponents();
        this.datosUsuario = datosUsuario;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new FondoPanelNuevoProyecto();
        LbTitulo = new javax.swing.JLabel();
        LbNombre = new javax.swing.JLabel();
        TxtNombre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        TxtDescripcion = new javax.swing.JTextField();
        BtnGuardar = new javax.swing.JButton();
        BtnCerrar = new javax.swing.JButton();
        ChkTablero = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        LbTitulo.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        LbTitulo.setForeground(new java.awt.Color(52, 73, 85));
        LbTitulo.setText("Nuevo Proyecto");

        LbNombre.setBackground(new java.awt.Color(255, 255, 255));
        LbNombre.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        LbNombre.setForeground(new java.awt.Color(52, 73, 85));
        LbNombre.setText("Nombre de Proyecto");

        TxtNombre.setBackground(new java.awt.Color(255, 255, 255));
        TxtNombre.setForeground(new java.awt.Color(114, 54, 18));
        TxtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TxtNombreActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(52, 73, 85));
        jLabel1.setText("Descripción");

        TxtDescripcion.setBackground(new java.awt.Color(255, 255, 255));
        TxtDescripcion.setForeground(new java.awt.Color(114, 54, 18));

        BtnGuardar.setBackground(new java.awt.Color(216, 161, 60));
        BtnGuardar.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        BtnGuardar.setForeground(new java.awt.Color(52, 73, 85));
        BtnGuardar.setText("GUARDAR");
        BtnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnGuardarActionPerformed(evt);
            }
        });

        BtnCerrar.setBackground(new java.awt.Color(216, 161, 60));
        BtnCerrar.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        BtnCerrar.setForeground(new java.awt.Color(52, 73, 85));
        BtnCerrar.setText("CERRAR");
        BtnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCerrarActionPerformed(evt);
            }
        });

        ChkTablero.setBackground(new java.awt.Color(204, 204, 204));
        ChkTablero.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        ChkTablero.setForeground(new java.awt.Color(52, 73, 85));
        ChkTablero.setText("Tablero");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(BtnCerrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtnGuardar)
                .addGap(80, 80, 80))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LbTitulo)
                .addGap(246, 246, 246))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TxtNombre)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ChkTablero)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LbNombre)
                            .addComponent(jLabel1))))
                .addGap(385, 559, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TxtDescripcion)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(LbTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 327, Short.MAX_VALUE)
                .addComponent(LbNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(34, 34, 34)
                .addComponent(TxtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ChkTablero)
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnGuardar)
                    .addComponent(BtnCerrar))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCerrarActionPerformed
        FrmProyecto miembro = new FrmProyecto(this.datosUsuario);
        miembro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int height = screenSize.height;
        int width = screenSize.width;
        // miembro.setSize(width/2, height/2);
        miembro.setLocationRelativeTo(null);
        miembro.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BtnCerrarActionPerformed

    private void BtnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGuardarActionPerformed
        Proyecto proyecto = new Proyecto();
        proyecto.setNombre(this.TxtNombre.getText().trim());
        proyecto.setDescripcion(this.TxtDescripcion.getText().trim());
        proyecto.Agregar(datosUsuario, this.ChkTablero.isSelected());
    }//GEN-LAST:event_BtnGuardarActionPerformed

    private void TxtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TxtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TxtNombreActionPerformed

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
            java.util.logging.Logger.getLogger(FrmNuevoProyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmNuevoProyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmNuevoProyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmNuevoProyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmNuevoProyecto().setVisible(true);
            }
        });
        
    }
     class FondoPanelNuevoProyecto extends JPanel{
    private Image imagen;
    @Override
    public void paint(Graphics g){
    try{
        
        imagen = new ImageIcon(getClass().getResource("/imagenes/code2.png")).getImage();
    g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
        
        setOpaque(false);
        super.paint(g);
        
        }catch(Exception e){}
    }
     }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnCerrar;
    private javax.swing.JButton BtnGuardar;
    private javax.swing.JCheckBox ChkTablero;
    private javax.swing.JLabel LbNombre;
    private javax.swing.JLabel LbTitulo;
    private javax.swing.JTextField TxtDescripcion;
    private javax.swing.JTextField TxtNombre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}

