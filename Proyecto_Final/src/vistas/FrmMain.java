//
package vistas;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import proyecto_final.Tarea;

public class FrmMain extends javax.swing.JFrame {
    
    private static DefaultMutableTreeNode root = new DefaultMutableTreeNode("Tareas Asignadas"); 
    private static DefaultTreeModel model;
    private String[] datosUsuario = new String[2];
    
    public FrmMain() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    
    public FrmMain(String[] datosUsuario){
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.datosUsuario = datosUsuario;
        
        LlenarTree();
        initComponents();
        validarRol(datosUsuario[1]);
        TreeTareas.setModel(model);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        BtnProyectos = new javax.swing.JButton();
        BtnMiembros = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TreeTareas = new javax.swing.JTree();
        BtnRefresh = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        BtnProyectos.setBackground(new java.awt.Color(255, 255, 255));
        BtnProyectos.setForeground(new java.awt.Color(0, 51, 255));
        BtnProyectos.setText("PROYECTOS");
        BtnProyectos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnProyectosActionPerformed(evt);
            }
        });

        BtnMiembros.setBackground(new java.awt.Color(255, 255, 255));
        BtnMiembros.setForeground(new java.awt.Color(0, 51, 255));
        BtnMiembros.setText("MIEMBROS");
        BtnMiembros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnMiembrosActionPerformed(evt);
            }
        });

        TreeTareas.setModel(model);
        TreeTareas.setBorder(null);
        TreeTareas.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        jScrollPane2.setViewportView(TreeTareas);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(BtnMiembros, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BtnProyectos, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(724, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnMiembros, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnProyectos, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        BtnRefresh.setText("Refresh");
        BtnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRefreshActionPerformed(evt);
            }
        });

        jMenu1.setText("Miembros");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Projectos");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BtnRefresh)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnRefresh)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnMiembrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnMiembrosActionPerformed
        FrmMiembro miembro = new FrmMiembro();
        miembro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int height = screenSize.height;
        int width = screenSize.width;
        miembro.setSize(width/2, height/2);
        miembro.setLocationRelativeTo(null);
        miembro.setVisible(true);
    }//GEN-LAST:event_BtnMiembrosActionPerformed

    private void BtnProyectosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnProyectosActionPerformed
        FrmProyecto proyecto = new FrmProyecto(this.datosUsuario);
        proyecto.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int height = screenSize.height;
        int width = screenSize.width;
        // miembro.setSize(width/2, height/2);
        proyecto.setLocationRelativeTo(null);
        proyecto.setVisible(true);
    }//GEN-LAST:event_BtnProyectosActionPerformed

    private void BtnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRefreshActionPerformed
        this.LlenarTree();
    }//GEN-LAST:event_BtnRefreshActionPerformed

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
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMain().setVisible(true);
            }
        });
    }
    
    // METODOS DE LA CLASE.
    public void validarRol(String rol){
        if(rol.equals("Editor") || rol.equals("Invitado")){
            this.BtnMiembros.setVisible(false);
        }
    }
    
    public void LlenarTree(){
        Tarea tarea = new Tarea();
        List<List<String>> Datos = tarea.listarTareasPorUsuario(this.datosUsuario[0]);
        
        for(int i=0; i<Datos.size(); i++){
            for(int j=0; j<Datos.get(i).size(); j++){
                if(i==0){
                    DefaultMutableTreeNode nuevo = new DefaultMutableTreeNode(Datos.get(i).get(j) + " -> " + Datos.get(i+1).get(j) + " -> " + Datos.get(i + 2).get(j));
                    root.add(nuevo);
                }
            }
        }
        
        model = new DefaultTreeModel(root);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnMiembros;
    private javax.swing.JButton BtnProyectos;
    private javax.swing.JButton BtnRefresh;
    private javax.swing.JTree TreeTareas;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
