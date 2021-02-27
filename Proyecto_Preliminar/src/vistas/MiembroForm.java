
package vistas;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import javax.swing.JTable;
import proyecto_preliminar.Administrador;
import java.sql.SQLException;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class MiembroForm extends javax.swing.JFrame {
    
    // ATRIBUTOS DE LA CLASE.
    private static Object[][] miembros;
    private static DefaultTableModel modelo = new DefaultTableModel();
    private static final String nombresDeColumna[] = 
                    {"Id", "Nombres", "Apellidos", "Usuario", "Cedula", "Rol"};

    public MiembroForm() {
        super("Miembros");
        this.LlenarTabla();
        initComponents();
        this.BtnEditar.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        GridMiembros = GridMiembros = new JTable(modelo);
        GridMiembros.setModel(modelo);
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(modelo);
        GridMiembros.setRowSorter(sorter);
        add(new JScrollPane(GridMiembros));
        setPreferredSize(new Dimension(420, 340));
        setSize(300, 350);
        BtnEditar = new javax.swing.JButton();
        BtnRefrescar = new javax.swing.JButton();
        CheckAdministradores = new javax.swing.JCheckBox();
        CheckEditores = new javax.swing.JCheckBox();
        CheckInvitados = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("MIEMBROS");

        jScrollPane1.setViewportView(GridMiembros);

        BtnEditar.setText("Editar");
        BtnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEditarActionPerformed(evt);
            }
        });

        BtnRefrescar.setText("Refrescar");
        BtnRefrescar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRefrescarActionPerformed(evt);
            }
        });

        CheckAdministradores.setText("Administradores");
        CheckAdministradores.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CheckAdministradoresItemStateChanged(evt);
            }
        });

        CheckEditores.setText("Editores");
        CheckEditores.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CheckEditoresItemStateChanged(evt);
            }
        });

        CheckInvitados.setText("Invitados");
        CheckInvitados.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CheckInvitadosItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 764, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(BtnRefrescar)
                                .addGap(60, 60, 60)
                                .addComponent(BtnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(232, 232, 232))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(347, 347, 347))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(CheckAdministradores)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(CheckEditores)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(CheckInvitados)
                                .addGap(52, 52, 52))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CheckAdministradores)
                    .addComponent(CheckEditores)
                    .addComponent(CheckInvitados))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnRefrescar)
                    .addComponent(BtnEditar))
                .addContainerGap(148, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEditarActionPerformed
        int Id = 0;
        String nombres = "";
        String apellidos = "";
        String usuario = "";
        String cedula = "";
        String rol = "";
        try{
            System.out.println(">: " + GridMiembros.getValueAt(GridMiembros.getSelectedRow(), 0));
            Id = Integer.parseInt(GridMiembros.getValueAt(GridMiembros.getSelectedRow(), 0).toString());
            nombres = GridMiembros.getValueAt(GridMiembros.getSelectedRow(), 1).toString();
            apellidos = GridMiembros.getValueAt(GridMiembros.getSelectedRow(), 2).toString();
            usuario = GridMiembros.getValueAt(GridMiembros.getSelectedRow(), 3).toString();
            cedula = GridMiembros.getValueAt(GridMiembros.getSelectedRow(), 4).toString();
            rol = GridMiembros.getValueAt(GridMiembros.getSelectedRow(), 5).toString();
        }catch(IndexOutOfBoundsException | NullPointerException e){
            try{
                System.out.println(">: " + GridMiembros.getModel().getValueAt(0, 0));
                Id = Integer.parseInt(GridMiembros.getModel().getValueAt(0, 0).toString());
                nombres = GridMiembros.getModel().getValueAt(0, 1).toString();
                apellidos = GridMiembros.getModel().getValueAt(0, 2).toString();
                usuario = GridMiembros.getModel().getValueAt(0, 3).toString();
                cedula = GridMiembros.getModel().getValueAt(0, 4).toString();
                rol = GridMiembros.getModel().getValueAt(0, 5).toString();
            }catch(NullPointerException ex){
                
            }
        }finally{
            if(!nombres.isEmpty())
                this.DatosMiembro(Id, nombres, apellidos, usuario, cedula, rol);
        }
    }//GEN-LAST:event_BtnEditarActionPerformed

    private void BtnRefrescarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRefrescarActionPerformed
        this.LlenarTabla();
        GridMiembros.setModel(modelo);
        CheckAdministradores.setSelected(false);
        CheckEditores.setSelected(false);
        CheckInvitados.setSelected(false);
    }//GEN-LAST:event_BtnRefrescarActionPerformed

    private void CheckAdministradoresItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CheckAdministradoresItemStateChanged
        if(evt.getStateChange()==1 && !CheckEditores.isSelected() && !CheckInvitados.isSelected()){
            LlenarTabla("Administrador");
            GridMiembros.setModel(modelo);
            BtnRefrescar.setEnabled(true);
            BtnEditar.setEnabled(false);
        }
        else if(evt.getStateChange()==1 && CheckEditores.isSelected() && !CheckInvitados.isSelected()){
            LlenarTabla("Administrador", "Editor");
            GridMiembros.setModel(modelo);
            BtnRefrescar.setEnabled(true);
            BtnEditar.setEnabled(false);
        }
        else{
            LlenarTabla();
            GridMiembros.setModel(modelo);
            BtnRefrescar.setEnabled(true);
        }
    }//GEN-LAST:event_CheckAdministradoresItemStateChanged

    private void CheckEditoresItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CheckEditoresItemStateChanged
        if(evt.getStateChange()==1 && !CheckAdministradores.isSelected() && !CheckInvitados.isSelected()){
            LlenarTabla("Editor");
            GridMiembros.setModel(modelo);
            BtnRefrescar.setEnabled(true);
            BtnEditar.setEnabled(true);
        }
        else if(evt.getStateChange()==1 && CheckAdministradores.isSelected() && !CheckInvitados.isSelected()){
            LlenarTabla("Editor", "Administrador");
            GridMiembros.setModel(modelo);
            BtnRefrescar.setEnabled(true);
            BtnEditar.setEnabled(false);
        }
        else{
            LlenarTabla();
            GridMiembros.setModel(modelo);
            BtnRefrescar.setEnabled(true);
            BtnEditar.setEnabled(false);
        }
    }//GEN-LAST:event_CheckEditoresItemStateChanged

    private void CheckInvitadosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CheckInvitadosItemStateChanged
        if(evt.getStateChange()==1){
            LlenarTabla("Invitado");
            GridMiembros.setModel(modelo);
            BtnRefrescar.setEnabled(false);
            BtnEditar.setEnabled(true);
        }
        else{
            LlenarTabla();
            GridMiembros.setModel(modelo);
            BtnRefrescar.setEnabled(true);
            BtnEditar.setEnabled(false);
        }
    }//GEN-LAST:event_CheckInvitadosItemStateChanged

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
            java.util.logging.Logger.getLogger(MiembroForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MiembroForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MiembroForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MiembroForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MiembroForm().setVisible(true);
            }
        });
    }
    
    private void LlenarTabla(){
        obtenerDatos();
        modelo = new DefaultTableModel(miembros, nombresDeColumna){
            private static final long serialVersionUID = 1L;
            public Class<?> getColumnClass(int column) {
                return column == 1 ? DefaultComboBoxModel.class : String.class;
            }
        };
        
//        for(int i=0; i<5; i++){
//            for(int j=0; j<5; j++){
//                System.out.println(miembros[i][j]);
//            }
//        }
    }
    
    private void LlenarTabla(String rol){
        obtenerDatos(rol);
        modelo = new DefaultTableModel(miembros, nombresDeColumna){
            private static final long serialVersionUID = 1L;
            public Class<?> getColumnClass(int column) {
                return column == 1 ? DefaultComboBoxModel.class : String.class;
            }
        };
        
//        for(int i=0; i<5; i++){
//            for(int j=0; j<5; j++){
//                System.out.println(miembros[i][j]);
//            }
//        }
    }
    
    private void LlenarTabla(String rol1, String rol2){
        obtenerDatos(rol1, rol2);
        modelo = new DefaultTableModel(miembros, nombresDeColumna){
            private static final long serialVersionUID = 1L;
            public Class<?> getColumnClass(int column) {
                return column == 1 ? DefaultComboBoxModel.class : String.class;
            }
        };
        
//        for(int i=0; i<5; i++){
//            for(int j=0; j<5; j++){
//                System.out.println(miembros[i][j]);
//            }
//        }
    }
    
    // METODOS DE LA CLASE.
    public void obtenerDatos(){
        try{
            Administrador administrador = new Administrador();
            int total = administrador.totalMiembros();
            List[] Datos = administrador.listarMiembros();
            miembros = new Object[total][6];
            
            for(int i=0; i<Datos[0].size(); i++){
                for(int j=0; j<Datos.length; j++){
                    miembros[i][j] = Datos[j].get(i);
                }
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void obtenerDatos(String rol){
        try{
            Administrador administrador = new Administrador();
            int total = administrador.totalMiembros();
            List[] Datos = administrador.listarMiembros(rol);
            miembros = new Object[total][6];
            
            for(int i=0; i<Datos[0].size(); i++){
                for(int j=0; j<Datos.length; j++){
                    miembros[i][j] = Datos[j].get(i);
                }
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public void obtenerDatos(String rol1, String rol2){
        try{
            Administrador administrador = new Administrador();
            int total = administrador.totalMiembros();
            List[] Datos = administrador.listarMiembros(rol1, rol2);
            miembros = new Object[total][6];
            
            for(int i=0; i<Datos[0].size(); i++){
                for(int j=0; j<Datos.length; j++){
                    miembros[i][j] = Datos[j].get(i);
                }
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    // METODOS DE LA CLASE.
    public void DatosMiembro(int Id, String nombres, String apellidos, String usuario,
                String cedula, String rol){
        DatosMiembroForm datosMiembro = new DatosMiembroForm(Id, nombres, apellidos, usuario, cedula, rol);
        datosMiembro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int height = screenSize.height;
        int width = screenSize.width;
        // datosMiembro.setSize(width/2, height/2);
        datosMiembro.setLocationRelativeTo(null);
        datosMiembro.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnEditar;
    private javax.swing.JButton BtnRefrescar;
    private javax.swing.JCheckBox CheckAdministradores;
    private javax.swing.JCheckBox CheckEditores;
    private javax.swing.JCheckBox CheckInvitados;
    private javax.swing.JTable GridMiembros;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
