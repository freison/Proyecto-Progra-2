
package vistas;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import proyecto_final.Proyecto;
import proyecto_final.Tarea;

public class FrmDatosProyecto extends javax.swing.JFrame {
    
    private static DefaultListModel listModel;
    private DefaultListModel listPorHacerModel = new DefaultListModel();
    private DefaultListModel listEnProcesoModel = new DefaultListModel();
    private DefaultListModel listFinalizadoModel = new DefaultListModel();
    private List<List<String>> porHacer = new ArrayList<>();
    private List<List<String>> enProceso = new ArrayList<>();
    private List<List<String>> finalizado = new ArrayList<>();
    private List<String> Datos = new ArrayList<>();
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
        
        this.Datos = datos;
        this.datosUsuario = datosUsuario;
        
        llenarListas();
        
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
        BtnAgregarTarea = new javax.swing.JButton();
        BtnPorHacer_To_EnProceso = new javax.swing.JButton();
        BtnEnProceso_To_Finalizado = new javax.swing.JButton();
        BtnEnProceso_To_PorHacer = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        LbTitulo.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        LbTitulo.setText("Proyecto");

        ListEnProceso.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        ListEnProceso.setForeground(new java.awt.Color(255, 153, 0));
        ListEnProceso.setModel(listEnProcesoModel);
        jScrollPane1.setViewportView(ListEnProceso);

        ListPorHacer.setFont(new java.awt.Font("Open Sans", 0, 14));
        ListPorHacer.setForeground(new java.awt.Color(255, 102, 102));
        ListPorHacer.setModel(listPorHacerModel);
        ListPorHacer.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                ListPorHacerValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(ListPorHacer);

        ListFinalizado.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        ListFinalizado.setForeground(new java.awt.Color(51, 153, 0));
        ListFinalizado.setModel(listFinalizadoModel);
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

        BtnAgregarTarea.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        BtnAgregarTarea.setText("Agregar Tarea");
        BtnAgregarTarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAgregarTareaActionPerformed(evt);
            }
        });

        BtnPorHacer_To_EnProceso.setText(">");
        BtnPorHacer_To_EnProceso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPorHacer_To_EnProcesoActionPerformed(evt);
            }
        });

        BtnEnProceso_To_Finalizado.setText(">");
        BtnEnProceso_To_Finalizado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEnProceso_To_FinalizadoActionPerformed(evt);
            }
        });

        BtnEnProceso_To_PorHacer.setText("<");
        BtnEnProceso_To_PorHacer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEnProceso_To_PorHacerActionPerformed(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(186, 186, 186)
                                .addComponent(BtnPorHacer_To_EnProceso, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(98, 98, 98)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(98, 98, 98)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(168, 168, 168)
                                .addComponent(BtnEnProceso_To_PorHacer, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtnEnProceso_To_Finalizado, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 122, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(LbMiembros)
                        .addGap(60, 60, 60))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BtnAgregarTarea)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnPorHacer_To_EnProceso)
                    .addComponent(BtnEnProceso_To_Finalizado)
                    .addComponent(BtnEnProceso_To_PorHacer))
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnAgregarMiembro, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                    .addComponent(BtnAgregarTarea, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnAgregarMiembroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAgregarMiembroActionPerformed
        FrmMiembro miembro = new FrmMiembro(this.Datos, datosUsuario);
        miembro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int height = screenSize.height;
        int width = screenSize.width;
        miembro.setSize(width/2, height/2);
        miembro.setLocationRelativeTo(null);
        miembro.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BtnAgregarMiembroActionPerformed

    private void BtnAgregarTareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAgregarTareaActionPerformed
        FrmNuevaTarea nuevaTarea = new FrmNuevaTarea(this.Datos);
        nuevaTarea.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int height = screenSize.height;
        int width = screenSize.width;
        // miembro.setSize(width/2, height/2);
        nuevaTarea.setLocationRelativeTo(null);
        nuevaTarea.setVisible(true);
        this.dispose(); // LAST INTERACTION.
    }//GEN-LAST:event_BtnAgregarTareaActionPerformed

    private void ListPorHacerValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_ListPorHacerValueChanged
        
    }//GEN-LAST:event_ListPorHacerValueChanged

    private void BtnPorHacer_To_EnProcesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPorHacer_To_EnProcesoActionPerformed

        System.out.println("Length: " + enProceso.get(0).size());
        
        int index = this.ListPorHacer.getSelectedIndex();
        int tareaId = Integer.parseInt(this.porHacer.get(0).get(index));
        Tarea tarea = new Tarea(); 
        
        this.listEnProcesoModel.addElement(this.porHacer.get(1).get(this.ListPorHacer.getSelectedIndex()));
        this.listPorHacerModel.removeElement(listPorHacerModel.get(index));
        this.enProceso.get(0).add(porHacer.get(0).get(index));
        this.enProceso.get(1).add(porHacer.get(1).get(index));
        this.porHacer.get(0).remove(index);
        this.porHacer.get(1).remove(index);
        
        tarea.modificarEstado(tareaId, 2);
    }//GEN-LAST:event_BtnPorHacer_To_EnProcesoActionPerformed

    private void BtnEnProceso_To_FinalizadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEnProceso_To_FinalizadoActionPerformed
        int index = this.ListEnProceso.getSelectedIndex();
        int tareaId = Integer.parseInt(this.enProceso.get(0).get(index));
        Tarea tarea = new Tarea();
        
        this.listFinalizadoModel.addElement(this.enProceso.get(1).get(this.ListEnProceso.getSelectedIndex()));
        this.listEnProcesoModel.removeElement(listEnProcesoModel.get(index));
        this.finalizado.get(0).add(enProceso.get(0).get(index));
        this.finalizado.get(1).add(enProceso.get(1).get(index));
        this.enProceso.get(0).remove(index);
        this.enProceso.get(1).remove(index);
        
        tarea.modificarEstado(tareaId, 3);
    }//GEN-LAST:event_BtnEnProceso_To_FinalizadoActionPerformed

    private void BtnEnProceso_To_PorHacerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEnProceso_To_PorHacerActionPerformed
        int index = this.ListEnProceso.getSelectedIndex();
        int tareaId = Integer.parseInt(this.enProceso.get(0).get(index));
        Tarea tarea = new Tarea();
        
        this.listPorHacerModel.addElement(this.enProceso.get(1).get(this.ListEnProceso.getSelectedIndex()));
        this.listEnProcesoModel.removeElement(listEnProcesoModel.get(index));
        this.porHacer.get(0).add(enProceso.get(0).get(index));
        this.porHacer.get(1).add(enProceso.get(1).get(index));
        this.enProceso.get(0).remove(index);
        this.enProceso.get(1).remove(index);
        
        tarea.modificarEstado(tareaId, 1);
    }//GEN-LAST:event_BtnEnProceso_To_PorHacerActionPerformed

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
    
    public void llenarListas(){
        Tarea tarea = new Tarea();
        var datosTareas = tarea.listarTareasPorProyecto(Integer.parseInt(this.Datos.get(0)));
        
        List<String> porHacerIdTEMP = new ArrayList<>();
        List<String> porHacerDescripcionesTEMP = new ArrayList<>();
        
        List<String> enProcesoIdTEMP = new ArrayList<>();
        List<String> enProcesoDescripcionesTEMP = new ArrayList<>();
        
        List<String> finalizadoIdTEMP = new ArrayList<>();
        List<String> finalizadoDescripcionesTEMP = new ArrayList<>();
        
        for(int i = 0; i<datosTareas.size(); i++){
            for(int j = 0; j<datosTareas.get(0).size(); j++){
                // Agrega datos (Descripciones) a los JLists
                if(Integer.parseInt(datosTareas.get(2).get(j)) == 1){
                    if(i==1){
                        var elemento = datosTareas.get(1).get(j);
                        listPorHacerModel.addElement(elemento);
                        porHacerDescripcionesTEMP.add(elemento);
                    }
                    else if(i==0){
                        var elemento = datosTareas.get(0).get(j);
                        porHacerIdTEMP.add(elemento);
                    }
                }
                else if(Integer.parseInt(datosTareas.get(2).get(j)) == 2){
                    if(i==1){
                        var elemento = datosTareas.get(1).get(j);
                        listEnProcesoModel.addElement(elemento);
                        enProcesoDescripcionesTEMP.add(elemento);
                    }
                    else if(i==0){
                        var elemento = datosTareas.get(0).get(j);
                        enProcesoIdTEMP.add(elemento);
                    }
                }
                else if(Integer.parseInt(datosTareas.get(2).get(j)) == 3 && i==1){
                    if(i==1){
                        var elemento = datosTareas.get(1).get(j);
                        listFinalizadoModel.addElement(datosTareas.get(1).get(j));
                        finalizadoDescripcionesTEMP.add(elemento);
                    }
                    else if(i==0){
                        var elemento = datosTareas.get(0).get(j);
                        finalizadoIdTEMP.add(elemento);
                    }
                }
            }
        }
        
        this.porHacer.add(porHacerIdTEMP);
        this.porHacer.add(porHacerDescripcionesTEMP);
        
        this.enProceso.add(enProcesoIdTEMP);
        this.enProceso.add(enProcesoDescripcionesTEMP);
        
        this.finalizado.add(finalizadoIdTEMP);
        this.finalizado.add(finalizadoDescripcionesTEMP);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAgregarMiembro;
    private javax.swing.JButton BtnAgregarTarea;
    private javax.swing.JButton BtnEnProceso_To_Finalizado;
    private javax.swing.JButton BtnEnProceso_To_PorHacer;
    private javax.swing.JButton BtnPorHacer_To_EnProceso;
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
