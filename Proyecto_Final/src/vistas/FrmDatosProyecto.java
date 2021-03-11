
package vistas;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import proyecto_final.Proyecto;

public class FrmDatosProyecto extends javax.swing.JFrame {
    
    private static DefaultListModel listModel;
    private static List<String> Datos = new ArrayList<>();
    private String[] datosUsuario = new String[2];

    public FrmDatosProyecto() {
        initComponents();
    }
    
    /***
     * List datos posee el Id, Nombre y Descripcion del Proyecto
     * []datosUsuario posee el usuario y rol del Miembro.
     * @param datos
     * @param datosUsuario 
     */
    public FrmDatosProyecto(List datos, String[] datosUsuario){
        llenarListaMiembros(Integer.parseInt(datos.get(0).toString()));
        initComponents();
        LbTitulo.setText(LbTitulo.getText() + " " + datos.get(1));
        
        Datos = datos;
        this.datosUsuario = datosUsuario;
        
        validarPropietario(Integer.parseInt(datos.get(0).toString()), datosUsuario[0]);
        validarRol(datosUsuario[1]);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LbTitulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListEnProceso = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        ListPorHacer = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        ListFinalizado = new javax.swing.JList<>();
        LbPorHacer = new javax.swing.JLabel();
        LbEnProceso = new javax.swing.JLabel();
        LbFinalizadas = new javax.swing.JLabel();
        LbMiembros = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        ListMiembros = new javax.swing.JList<>();
        BtnAgregarMiembro = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        LbTitulo.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        LbTitulo.setText("Proyecto");

        ListEnProceso.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        ListEnProceso.setForeground(new java.awt.Color(255, 153, 0));
        ListEnProceso.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(ListEnProceso);

        ListPorHacer.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        ListPorHacer.setForeground(new java.awt.Color(255, 102, 102));
        ListPorHacer.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(ListPorHacer);

        ListFinalizado.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        ListFinalizado.setForeground(new java.awt.Color(51, 153, 0));
        ListFinalizado.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane3.setViewportView(ListFinalizado);

        LbPorHacer.setText("Tareas Por Hacer");

        LbEnProceso.setText("Tareas en Proceso");

        LbFinalizadas.setText("Tareas Finalizadas");

        LbMiembros.setText("Miembros");

        ListMiembros.setModel(listModel);
        jScrollPane5.setViewportView(ListMiembros);

        BtnAgregarMiembro.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        BtnAgregarMiembro.setText("Agregar Miembro");
        BtnAgregarMiembro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAgregarMiembroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(501, 501, 501)
                .addComponent(LbTitulo)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(LbPorHacer)
                        .addGap(249, 249, 249)
                        .addComponent(LbEnProceso)
                        .addGap(222, 222, 222)
                        .addComponent(LbFinalizadas))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(98, 98, 98)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(98, 98, 98)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 122, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(LbMiembros)
                        .addGap(60, 60, 60))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtnAgregarMiembro)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LbTitulo)
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LbPorHacer)
                    .addComponent(LbEnProceso)
                    .addComponent(LbFinalizadas)
                    .addComponent(LbMiembros))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane5)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addComponent(BtnAgregarMiembro, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnAgregarMiembroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAgregarMiembroActionPerformed
        FrmMiembro miembro = new FrmMiembro(Datos, datosUsuario);
        miembro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int height = screenSize.height;
        int width = screenSize.width;
        miembro.setSize(width/2, height/2);
        miembro.setLocationRelativeTo(null);
        miembro.setVisible(true);
        this.dispose(); // LAST INTERACTION.
    }//GEN-LAST:event_BtnAgregarMiembroActionPerformed

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
            java.util.logging.Logger.getLogger(FrmDatosProyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmDatosProyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmDatosProyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmDatosProyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmDatosProyecto().setVisible(true);
            }
        });
    }
    
    // METODOS DE LA CLASE.
    public void llenarListaMiembros(int Id){
        Proyecto proyecto = new Proyecto();
        var nombres = proyecto.listarMiembros(Id);
        listModel = new DefaultListModel();
        
        for(int i=0; i<nombres.size(); i++){
            listModel.addElement(nombres.get(i)); // LAST INTERACTION
        }
    }
    
    public void validarPropietario(int Id, String usuario){
        Proyecto proyecto = new Proyecto();
        String propietario = proyecto.obtenerCreador(Id);
        
        if(!propietario.equalsIgnoreCase(usuario)){
            this.BtnAgregarMiembro.setEnabled(false);
            this.BtnAgregarMiembro.setVisible(false);
        }
    }
    
    public void validarRol(String rol){
        if(rol.equals("Invitado")){
            this.ListPorHacer.setEnabled(false);
            this.ListEnProceso.setEnabled(false);
            this.ListFinalizado.setEnabled(false);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAgregarMiembro;
    private javax.swing.JLabel LbEnProceso;
    private javax.swing.JLabel LbFinalizadas;
    private javax.swing.JLabel LbMiembros;
    private javax.swing.JLabel LbPorHacer;
    private javax.swing.JLabel LbTitulo;
    private javax.swing.JList<String> ListEnProceso;
    private javax.swing.JList<String> ListFinalizado;
    private javax.swing.JList<String> ListMiembros;
    private javax.swing.JList<String> ListPorHacer;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    // End of variables declaration//GEN-END:variables
}
