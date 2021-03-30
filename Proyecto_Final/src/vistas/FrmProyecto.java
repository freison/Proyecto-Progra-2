
package vistas;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import proyecto_final.Proyecto;

public class FrmProyecto extends javax.swing.JFrame {
    private static DefaultListModel listModel;
    private String[] datosUsuario = new String[2];

    public FrmProyecto() {
        llenarLista();
        initComponents();
        // ListProyectos.setModel(listModel);
    }
    
    public FrmProyecto(String[] datosUsuario){
        this.datosUsuario = datosUsuario;
        
        llenarLista();
        initComponents();
        validarRol(datosUsuario[1]);
        
        this.datosUsuario = datosUsuario;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BtnAgregar = new javax.swing.JButton();
        BtnCerrrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListProyectos = new javax.swing.JList<>();
        LbTitulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        BtnAgregar.setText("AGREGAR");
        BtnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAgregarActionPerformed(evt);
            }
        });

        BtnCerrrar.setText("CERRAR");
        BtnCerrrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCerrrarActionPerformed(evt);
            }
        });

        ListProyectos.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        ListProyectos.setForeground(new java.awt.Color(0, 51, 255));
        ListProyectos.setModel(listModel);
        ListProyectos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        ListProyectos.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                ListProyectosValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(ListProyectos);

        LbTitulo.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        LbTitulo.setText("PROYECTOS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(186, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(BtnCerrrar)
                        .addGap(69, 69, 69)
                        .addComponent(BtnAgregar)
                        .addGap(307, 307, 307))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(145, 145, 145))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(LbTitulo)
                        .addGap(362, 362, 362))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LbTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnAgregar)
                    .addComponent(BtnCerrrar))
                .addGap(43, 43, 43))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAgregarActionPerformed
        FrmNuevoProyecto miembro = new FrmNuevoProyecto(datosUsuario);
        miembro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int height = screenSize.height;
        int width = screenSize.width;
        // miembro.setSize(width/2, height/2);
        miembro.setLocationRelativeTo(null);
        miembro.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BtnAgregarActionPerformed

    private void BtnCerrrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCerrrarActionPerformed
        this.dispose();
        ListProyectos.getModel();
    }//GEN-LAST:event_BtnCerrrarActionPerformed

    private void ListProyectosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_ListProyectosValueChanged
        Proyecto proyecto = new Proyecto();
        var datos = proyecto.buscarProyecto(ListProyectos.getSelectedValue().toString());
        
        FrmDatosProyecto datosProyecto = new FrmDatosProyecto(datos, datosUsuario);
        datosProyecto.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int height = screenSize.height;
        int width = screenSize.width;
        // miembro.setSize(width/2, height/2);
        datosProyecto.setLocationRelativeTo(null);
        datosProyecto.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ListProyectosValueChanged

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
            java.util.logging.Logger.getLogger(FrmProyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmProyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmProyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmProyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmProyecto().setVisible(true);
            }
        });
    }
    
    // METODOS DE LA CLASE.
    public void llenarLista(){
        Proyecto proyecto = new Proyecto();
        listModel = new DefaultListModel();
        var datos = proyecto.Listar(datosUsuario[0]);
        
        if(datos[0].size()>0)
            for(int i=0; i<datos[0].size(); i++){
                listModel.addElement(datos[1].get(i));
            }
    }
    
    public void validarRol(String rol){
        if(rol.equals("Editor") || rol.equals("Invitado")){
            this.BtnAgregar.setVisible(false);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAgregar;
    private javax.swing.JButton BtnCerrrar;
    private javax.swing.JLabel LbTitulo;
    private javax.swing.JList<String> ListProyectos;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
