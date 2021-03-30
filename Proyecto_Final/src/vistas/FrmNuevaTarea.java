
package vistas;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import proyecto_final.Administrador;
import proyecto_final.Tarea;

public class FrmNuevaTarea extends javax.swing.JFrame {
    
    private static Object[][] miembros;
    private static DefaultTableModel modelo = new DefaultTableModel();
    private static DefaultListModel listModel = new DefaultListModel();
    private static final String nombresDeColumna[] = 
                    {"Id", "Nombres", "Apellidos", "Rol"};
    
    private List<String> datos = new ArrayList<>();
    private String[] datosUsuario = new String[2];

    public FrmNuevaTarea() {
        this.LlenarTabla();
        initComponents();
    }
    
    public FrmNuevaTarea(List<String> datos, String[] datosUsuario){
        this.datos = datos;
        this.datosUsuario = datosUsuario;
        this.LlenarTabla();
        initComponents();
        this.ListMiembrosAgregados.removeAll();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel = new javax.swing.JPanel();
        LbTitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableMiembros = new javax.swing.JTable(modelo);
        LbDescripcion = new javax.swing.JLabel();
        TxtDescripcion = new javax.swing.JTextField();
        LbMiembros = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        ListMiembrosAgregados = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        BtnAgregar = new javax.swing.JButton();
        BtnCerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        LbTitle.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        LbTitle.setForeground(new java.awt.Color(0, 0, 0));
        LbTitle.setText("Tarea");

        TableMiembros.setModel(modelo);
        jScrollPane1.setViewportView(TableMiembros);

        LbDescripcion.setText("Descripción");

        LbMiembros.setText("Miembros");

        ListMiembrosAgregados.setModel(listModel);
        jScrollPane2.setViewportView(ListMiembrosAgregados);

        jLabel1.setText("Miembros Agregados");

        BtnAgregar.setBackground(new java.awt.Color(51, 153, 0));
        BtnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        BtnAgregar.setText("Agregar");
        BtnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAgregarActionPerformed(evt);
            }
        });

        BtnCerrar.setText("Cerrar");
        BtnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelLayout = new javax.swing.GroupLayout(Panel);
        Panel.setLayout(PanelLayout);
        PanelLayout.setHorizontalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelLayout.createSequentialGroup()
                        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(LbTitle)
                                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(TxtDescripcion, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LbDescripcion, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)))
                            .addComponent(LbMiembros))
                        .addGap(50, 50, 50)
                        .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelLayout.createSequentialGroup()
                        .addComponent(BtnAgregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(BtnCerrar)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        PanelLayout.setVerticalGroup(
            PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelLayout.createSequentialGroup()
                .addComponent(LbTitle)
                .addGap(7, 7, 7)
                .addComponent(LbDescripcion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TxtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LbMiembros)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE))
                .addGap(40, 40, 40))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnAgregar)
                    .addComponent(BtnCerrar))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAgregarActionPerformed
        int MiembroId = obtenerIdSeleccionado();
        Tarea tarea = new Tarea();
        int ultimaTareaId = 0;
        if(TxtDescripcion.isEnabled()){
            tarea.Agregar(TxtDescripcion.getText().trim(), 1, Integer.parseInt(this.datos.get(0)));
            
            ultimaTareaId = tarea.buscarUltimaTarea();
            tarea.AgregarDetalle(MiembroId, ultimaTareaId);
            
            listModel.addElement(TableMiembros.getValueAt(TableMiembros.getSelectedRow(), 1));
            
            this.TxtDescripcion.setEnabled(false);
        }
        else{
            ultimaTareaId = tarea.buscarUltimaTarea();
            tarea.AgregarDetalle(MiembroId, ultimaTareaId);
            listModel.addElement(TableMiembros.getValueAt(TableMiembros.getSelectedRow(), 1));
        }
    }//GEN-LAST:event_BtnAgregarActionPerformed

    private void BtnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCerrarActionPerformed
        FrmDatosProyecto datosMiembro = new FrmDatosProyecto(datos, datosUsuario);
        datosMiembro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int height = screenSize.height;
        int width = screenSize.width;
        // datosMiembro.setSize(width/2, height/2);
        datosMiembro.setLocationRelativeTo(null);
        datosMiembro.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BtnCerrarActionPerformed

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
            java.util.logging.Logger.getLogger(FrmNuevaTarea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmNuevaTarea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmNuevaTarea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmNuevaTarea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmNuevaTarea().setVisible(true);
            }
        });
    }
    
    // METODOS DE LA CLASE.
    private void LlenarTabla(){
        obtenerDatos();
        modelo = new DefaultTableModel(miembros, nombresDeColumna){
            private static final long serialVersionUID = 1L;
            public Class<?> getColumnClass(int column) {
                return column == 1 ? DefaultTableModel.class : String.class;
            }
        };
    }
    
    public void obtenerDatos(){
        try{
            Administrador administrador = new Administrador();
            int total = administrador.totalMiembros();
            List[] Datos = administrador.listarMiembrosPorProyecto(Integer.parseInt(datos.get(0)));
            miembros = new Object[Datos[0].size()][4];
            
            for(int i=0; i<Datos[0].size(); i++){
                int k = 0;
                for(int j=0; j<Datos.length; j++){
                    if(j!=3 && j!=4){
                        miembros[i][k] = Datos[j].get(i);
                        k++;
                    }
                }
            }
        }catch(Exception e){
            System.out.println(e.getMessage() + "Problem here");
        }
    }
    
    public int obtenerIdSeleccionado(){
        int Id = 0;
        
        try{
            Id = Integer.parseInt(TableMiembros.getValueAt(TableMiembros.getSelectedRow(), 0).toString());
        }catch(IndexOutOfBoundsException e){
            JOptionPane.showMessageDialog(null, "Debe seleccionar un Miembro");
        }
        
        return Id;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAgregar;
    private javax.swing.JButton BtnCerrar;
    private javax.swing.JLabel LbDescripcion;
    private javax.swing.JLabel LbMiembros;
    private javax.swing.JLabel LbTitle;
    private javax.swing.JList<String> ListMiembrosAgregados;
    private javax.swing.JPanel Panel;
    private javax.swing.JTable TableMiembros;
    private javax.swing.JTextField TxtDescripcion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
