
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListProyectos = new javax.swing.JList<>();
        LbTitulo = new javax.swing.JLabel();
        BtnAgregar = new javax.swing.JButton();
        BtnCerrrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        ListProyectos.setBackground(new java.awt.Color(255, 255, 255));
        ListProyectos.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        ListProyectos.setForeground(new java.awt.Color(114, 54, 18));
        ListProyectos.setModel(listModel);
        ListProyectos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        ListProyectos.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                ListProyectosValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(ListProyectos);

        LbTitulo.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        LbTitulo.setForeground(new java.awt.Color(52, 73, 85));
        LbTitulo.setText("PROYECTOS");

        BtnAgregar.setBackground(new java.awt.Color(216, 161, 60));
        BtnAgregar.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        BtnAgregar.setForeground(new java.awt.Color(52, 73, 85));
        BtnAgregar.setText("AGREGAR");
        BtnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAgregarActionPerformed(evt);
            }
        });

        BtnCerrrar.setBackground(new java.awt.Color(216, 161, 60));
        BtnCerrrar.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        BtnCerrrar.setForeground(new java.awt.Color(52, 73, 85));
        BtnCerrrar.setText("CERRAR");
        BtnCerrrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCerrrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGap(64, 64, 64)
                            .addComponent(BtnAgregar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BtnCerrrar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGap(30, 30, 30)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(215, 215, 215)
                        .addComponent(LbTitulo)))
                .addGap(30, 30, 30))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(LbTitulo)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnAgregar)
                    .addComponent(BtnCerrrar))
                .addContainerGap(50, Short.MAX_VALUE))
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
        
        if(Boolean.parseBoolean(datos.get(datos.size() - 1).toString())){
            FrmDatosProyectos datosProyecto = new FrmDatosProyectos(datos, datosUsuario);
            datosProyecto.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            int height = screenSize.height;
            int width = screenSize.width;
            // miembro.setSize(width/2, height/2);
            datosProyecto.setLocationRelativeTo(null);
            datosProyecto.setVisible(true);
            this.dispose();
        }
        else{
            FrmDatosProyecto datosProyecto = new FrmDatosProyecto(datos, datosUsuario);
            datosProyecto.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            int height = screenSize.height;
            int width = screenSize.width;
            // miembro.setSize(width/2, height/2);
            datosProyecto.setLocationRelativeTo(null);
            datosProyecto.setVisible(true);
            this.dispose();
        }
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
