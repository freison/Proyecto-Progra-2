
package vistas;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import proyecto_final.Administrador;
import proyecto_final.Proyecto;

public class FrmMiembro extends javax.swing.JFrame {

    // ATRIBUTOS DE LA CLASE.
    private static Object[][] miembros;
    private static DefaultTableModel modelo = new DefaultTableModel();
    private static final String nombresDeColumna[] = 
                    {"Id", "Nombres", "Apellidos", "Usuario", "Cedula", "Rol"};
    
    private static List<String> Datos;
    private String[] datosUsuario = new String[2];
    private boolean tipo = false;

    public FrmMiembro() {
        this.LlenarTabla();
        initComponents();
        this.BtnEditar.setEnabled(false);
        this.BtnAgregarMiembro.setEnabled(false);
        this.BtnAgregarMiembro.setVisible(false);
        this.BtnCerrar.setEnabled(false);
        this.BtnCerrar.setVisible(false);
        modelo.addTableModelListener(GridMiembros);
    }
    
    public FrmMiembro(List<String> datos, String[] datosUsuario, boolean tipo){
        this.LlenarTabla();
        initComponents();
        this.BtnEditar.setEnabled(false);
        this.BtnEditar.setVisible(false);
        this.BtnAgregar.setEnabled(false);
        this.BtnAgregar.setVisible(false);
        this.BtnRefrescar.setEnabled(false);
        this.BtnRefrescar.setVisible(false);
        modelo.addTableModelListener(GridMiembros);
        
        Datos = datos;
        this.datosUsuario = datosUsuario;
        this.tipo = tipo;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        LbTitulo = new javax.swing.JLabel();
        CheckInvitados = new javax.swing.JCheckBox();
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
        BtnAgregar = new javax.swing.JButton();
        TxtBuscar = new javax.swing.JTextField();
        BtnAgregarMiembro = new javax.swing.JButton();
        BtnCerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        LbTitulo.setBackground(new java.awt.Color(255, 255, 255));
        LbTitulo.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        LbTitulo.setForeground(new java.awt.Color(35, 47, 52));
        LbTitulo.setText("MIEMBROS");

        CheckInvitados.setBackground(new java.awt.Color(255, 255, 255));
        CheckInvitados.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        CheckInvitados.setForeground(new java.awt.Color(35, 47, 52));
        CheckInvitados.setText("Invitados");
        CheckInvitados.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CheckInvitadosItemStateChanged(evt);
            }
        });

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setForeground(new java.awt.Color(114, 54, 18));

        GridMiembros.setBackground(new java.awt.Color(255, 255, 255));
        GridMiembros.setForeground(new java.awt.Color(114, 54, 18));
        jScrollPane1.setViewportView(GridMiembros);

        BtnEditar.setBackground(new java.awt.Color(216, 161, 60));
        BtnEditar.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        BtnEditar.setForeground(new java.awt.Color(35, 47, 52));
        BtnEditar.setText("Editar");
        BtnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEditarActionPerformed(evt);
            }
        });

        BtnRefrescar.setBackground(new java.awt.Color(216, 161, 60));
        BtnRefrescar.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        BtnRefrescar.setForeground(new java.awt.Color(35, 47, 52));
        BtnRefrescar.setText("Refrescar");
        BtnRefrescar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRefrescarActionPerformed(evt);
            }
        });

        CheckAdministradores.setBackground(new java.awt.Color(255, 255, 255));
        CheckAdministradores.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        CheckAdministradores.setForeground(new java.awt.Color(35, 47, 52));
        CheckAdministradores.setText("Administradores");
        CheckAdministradores.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CheckAdministradoresItemStateChanged(evt);
            }
        });
        CheckAdministradores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckAdministradoresActionPerformed(evt);
            }
        });

        CheckEditores.setBackground(new java.awt.Color(255, 255, 255));
        CheckEditores.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        CheckEditores.setForeground(new java.awt.Color(35, 47, 52));
        CheckEditores.setText("Editores");
        CheckEditores.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CheckEditoresItemStateChanged(evt);
            }
        });
        CheckEditores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckEditoresActionPerformed(evt);
            }
        });

        BtnAgregar.setBackground(new java.awt.Color(216, 161, 60));
        BtnAgregar.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        BtnAgregar.setForeground(new java.awt.Color(35, 47, 52));
        BtnAgregar.setText("Agregar");
        BtnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAgregarActionPerformed(evt);
            }
        });

        TxtBuscar.setBackground(new java.awt.Color(255, 255, 255));
        TxtBuscar.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        TxtBuscar.setForeground(new java.awt.Color(114, 54, 18));
        TxtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TxtBuscarKeyPressed(evt);
            }
        });

        BtnAgregarMiembro.setBackground(new java.awt.Color(216, 161, 60));
        BtnAgregarMiembro.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        BtnAgregarMiembro.setForeground(new java.awt.Color(35, 47, 52));
        BtnAgregarMiembro.setText("Agregar a Proyecto");
        BtnAgregarMiembro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAgregarMiembroActionPerformed(evt);
            }
        });

        BtnCerrar.setBackground(new java.awt.Color(216, 161, 60));
        BtnCerrar.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        BtnCerrar.setForeground(new java.awt.Color(35, 47, 52));
        BtnCerrar.setText("Cerrar");
        BtnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LbTitulo)
                        .addGap(240, 240, 240))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addGap(16, 16, 16)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(BtnAgregarMiembro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(BtnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(BtnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(BtnRefrescar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(BtnCerrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(CheckAdministradores)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                                .addComponent(CheckEditores)
                                .addGap(48, 48, 48)
                                .addComponent(CheckInvitados)
                                .addGap(35, 35, 35)
                                .addComponent(TxtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(LbTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CheckInvitados)
                    .addComponent(CheckEditores)
                    .addComponent(CheckAdministradores)
                    .addComponent(TxtBuscar))
                .addGap(73, 73, 73)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(BtnAgregarMiembro, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BtnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BtnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BtnRefrescar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BtnCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CheckInvitadosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CheckInvitadosItemStateChanged
        // Valida que checkbox estan seleccionados y muestra los datos en base a ello.
        if(evt.getStateChange()==1 && !CheckAdministradores.isSelected() && !CheckEditores.isSelected()){
            LlenarTabla("Invitado");
            GridMiembros.setModel(modelo);
            BtnRefrescar.setEnabled(false);
            BtnEditar.setEnabled(true);
        }
        else if(evt.getStateChange()==1 && CheckAdministradores.isSelected() && !CheckEditores.isSelected()){
            LlenarTabla("Invitado", "Administrador");
            GridMiembros.setModel(modelo);
            BtnRefrescar.setEnabled(false);
            BtnEditar.setEnabled(false);
        }
        else if(evt.getStateChange()==1 && !CheckAdministradores.isSelected() && CheckEditores.isSelected()){
            LlenarTabla("Invitado", "Editor");
            GridMiembros.setModel(modelo);
            BtnRefrescar.setEnabled(false);
            BtnEditar.setEnabled(true);
        }
        else if(!CheckInvitados.isSelected() && CheckAdministradores.isSelected() && CheckEditores.isSelected()){
            LlenarTabla("Administrador", "Editor");
            GridMiembros.setModel(modelo);
            BtnRefrescar.setEnabled(false);
            BtnEditar.setEnabled(false);
        }
        else if(!CheckInvitados.isSelected() && CheckAdministradores.isSelected() && !CheckEditores.isSelected()){
            LlenarTabla("Administrador");
            GridMiembros.setModel(modelo);
            BtnRefrescar.setEnabled(false);
            BtnEditar.setEnabled(false);
        }
        else if(!CheckInvitados.isSelected() && !CheckAdministradores.isSelected() && CheckEditores.isSelected()){
            LlenarTabla("Editor");
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
        // GridMiembros = new JTable(modelo);
        this.LlenarTabla();
        GridMiembros.setModel(modelo);
        BtnRefrescar.setEnabled(true);
        BtnEditar.setEnabled(true);
        
        modelo.fireTableDataChanged();
        modelo.fireTableStructureChanged();
    }//GEN-LAST:event_BtnRefrescarActionPerformed
    
    private void CheckAdministradoresItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CheckAdministradoresItemStateChanged
        if(evt.getStateChange()==1 && !CheckEditores.isSelected() && !CheckInvitados.isSelected()){
            LlenarTabla("Administrador");
            GridMiembros.setModel(modelo);
            BtnRefrescar.setEnabled(false);
            BtnEditar.setEnabled(false);
        }
        else if(evt.getStateChange()==1 && CheckEditores.isSelected() && !CheckInvitados.isSelected()){
            LlenarTabla("Administrador", "Editor");
            GridMiembros.setModel(modelo);
            BtnRefrescar.setEnabled(false);
            BtnEditar.setEnabled(false);
        }
        else if(evt.getStateChange()==1 && !CheckEditores.isSelected() && CheckInvitados.isSelected()){
            LlenarTabla("Administrador", "Invitado");
            GridMiembros.setModel(modelo);
            BtnRefrescar.setEnabled(false);
            BtnEditar.setEnabled(false);
        }
        else if(!CheckAdministradores.isSelected() && CheckEditores.isSelected() && CheckInvitados.isSelected()){
            LlenarTabla("Editor", "Invitado");
            GridMiembros.setModel(modelo);
            BtnRefrescar.setEnabled(false);
            BtnEditar.setEnabled(true);
        }
        else if(!CheckAdministradores.isSelected() && CheckEditores.isSelected() && !CheckInvitados.isSelected()){
            LlenarTabla("Editor");
            GridMiembros.setModel(modelo);
            BtnRefrescar.setEnabled(false);
            BtnEditar.setEnabled(true);
        }
        else if(!CheckAdministradores.isSelected() && !CheckEditores.isSelected() && CheckInvitados.isSelected()){
            LlenarTabla("Invitado");
            GridMiembros.setModel(modelo);
            BtnRefrescar.setEnabled(false);
            BtnEditar.setEnabled(true);
        }
        else{
            LlenarTabla();
            GridMiembros.setModel(modelo);
            BtnRefrescar.setEnabled(true);
            BtnEditar.setEnabled(true);
        }
    }//GEN-LAST:event_CheckAdministradoresItemStateChanged

    private void CheckEditoresItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CheckEditoresItemStateChanged
        if(evt.getStateChange()==1 && !CheckAdministradores.isSelected() && !CheckInvitados.isSelected()){
            LlenarTabla("Editor");
            GridMiembros.setModel(modelo);
            BtnRefrescar.setEnabled(false);
            BtnEditar.setEnabled(true);
        }
        else if(evt.getStateChange()==1 && CheckAdministradores.isSelected() && !CheckInvitados.isSelected()){
            LlenarTabla("Editor", "Administrador");
            GridMiembros.setModel(modelo);
            BtnRefrescar.setEnabled(false);
            BtnEditar.setEnabled(false);
        }
        else if(evt.getStateChange()==1 && !CheckAdministradores.isSelected() && CheckInvitados.isSelected()){
            LlenarTabla("Editor", "Invitado");
            GridMiembros.setModel(modelo);
            BtnRefrescar.setEnabled(false);
            BtnEditar.setEnabled(true);
        }
        else if(!CheckEditores.isSelected() && CheckAdministradores.isSelected() && CheckInvitados.isSelected()){
            LlenarTabla("Administrador", "Invitado");
            GridMiembros.setModel(modelo);
            BtnRefrescar.setEnabled(false);
            BtnEditar.setEnabled(false);
        }
        else if(!CheckEditores.isSelected() && CheckAdministradores.isSelected() && !CheckInvitados.isSelected()){
            LlenarTabla("Administrador");
            GridMiembros.setModel(modelo);
            BtnRefrescar.setEnabled(false);
            BtnEditar.setEnabled(false);
        }
        else if(!CheckEditores.isSelected() && !CheckAdministradores.isSelected() && CheckInvitados.isSelected()){
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
    }//GEN-LAST:event_CheckEditoresItemStateChanged

    private void BtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAgregarActionPerformed
        FrmNuevoMiembro nuevoMiembro = new FrmNuevoMiembro();
        nuevoMiembro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        nuevoMiembro.setLocationRelativeTo(null);
        nuevoMiembro.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BtnAgregarActionPerformed

    private void TxtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtBuscarKeyPressed
        DefaultTableModel model = (DefaultTableModel) GridMiembros.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(model);
        GridMiembros.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(TxtBuscar.getText().trim()));
    }//GEN-LAST:event_TxtBuscarKeyPressed

    private void BtnAgregarMiembroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAgregarMiembroActionPerformed
        int miembroId = 0;
        int proyectoId = Integer.parseInt(Datos.get(0).toString());
        
        try{
            System.out.println(">: " + GridMiembros.getValueAt(GridMiembros.getSelectedRow(), 0));
            miembroId = Integer.parseInt(GridMiembros.getValueAt(GridMiembros.getSelectedRow(), 0).toString());
        }catch(IndexOutOfBoundsException | NullPointerException e){
            try{
                System.out.println(">: " + GridMiembros.getModel().getValueAt(0, 0));
                miembroId = Integer.parseInt(GridMiembros.getModel().getValueAt(0, 0).toString());
            }catch(NullPointerException ex){

            }
        }finally{
            Proyecto proyecto = new Proyecto();
            if(!proyecto.validarParticipacion(miembroId, proyectoId))
                proyecto.AgregarDetalleParticipacion(miembroId, proyectoId);
            else
                JOptionPane.showMessageDialog(null, "Miembro seleccionado\n ya pertenece a este proyecto");
        }
    }//GEN-LAST:event_BtnAgregarMiembroActionPerformed

    private void BtnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCerrarActionPerformed
        if(!tipo){
            FrmDatosProyecto datosMiembro = new FrmDatosProyecto(Datos, datosUsuario);
            datosMiembro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            int height = screenSize.height;
            int width = screenSize.width;
            // datosMiembro.setSize(width/2, height/2);
            datosMiembro.setLocationRelativeTo(null);
            datosMiembro.setVisible(true);
            this.dispose();
        }
        else{
            FrmDatosProyectos datosMiembro = new FrmDatosProyectos(Datos, datosUsuario);
            datosMiembro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            int height = screenSize.height;
            int width = screenSize.width;
            // datosMiembro.setSize(width/2, height/2);
            datosMiembro.setLocationRelativeTo(null);
            datosMiembro.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_BtnCerrarActionPerformed

    private void CheckEditoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckEditoresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CheckEditoresActionPerformed

    private void CheckAdministradoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckAdministradoresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CheckAdministradoresActionPerformed

    // METODOS DE LA CLASE.
    public void DatosMiembro(int Id, String nombres, String apellidos, String usuario,
                String cedula, String rol){
        FrmDatosMiembro datosMiembro = new FrmDatosMiembro(Id, nombres, apellidos, usuario, cedula, rol);
        datosMiembro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int height = screenSize.height;
        int width = screenSize.width;
        // datosMiembro.setSize(width/2, height/2);
        datosMiembro.setLocationRelativeTo(null);
        datosMiembro.setVisible(true);
        this.dispose();
    }
    
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
            java.util.logging.Logger.getLogger(FrmMiembro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMiembro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMiembro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMiembro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMiembro().setVisible(true);
            }
        });
    }
    
    // METODOS DE LA CLASE.
    private void LlenarTabla(){
        obtenerDatos();
        modelo = new DefaultTableModel(miembros, nombresDeColumna){
            private static final long serialVersionUID = 1L;
            public Class<?> getColumnClass(int column) {
                return column == 1 ? DefaultTableModel.class : String.class; // DefaultComboBoxModel
            }
        };
        
        // modelo.insertRow(modelo.getRowCount(), miembros[miembros.length-1]);
        
//        for(int i=0; i<miembros.length; i++){
//            for(int j=0; j<6; j++){
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
    
    public void obtenerDatos(){
        try{
            Administrador administrador = new Administrador();
            int total = administrador.totalMiembros();
            List[] Datos = administrador.listarMiembros();
            System.out.println(Datos[1].get(total-1));
            // System.out.println(total);
            // System.out.println(Datos[0].size() + " - " + Datos.length);
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
    
    public void reloadTable(){
        GridMiembros = new JTable();
        LlenarTabla();
        GridMiembros.setModel(modelo);
        BtnRefrescar.setEnabled(false);
        BtnEditar.setEnabled(false);
        
        System.out.println("ON CLOSE");
    }
        

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAgregar;
    private javax.swing.JButton BtnAgregarMiembro;
    private javax.swing.JButton BtnCerrar;
    private javax.swing.JButton BtnEditar;
    private javax.swing.JButton BtnRefrescar;
    private javax.swing.JCheckBox CheckAdministradores;
    private javax.swing.JCheckBox CheckEditores;
    private javax.swing.JCheckBox CheckInvitados;
    private javax.swing.JTable GridMiembros;
    private javax.swing.JLabel LbTitulo;
    private javax.swing.JTextField TxtBuscar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
