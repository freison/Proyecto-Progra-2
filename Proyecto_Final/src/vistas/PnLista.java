
package vistas;

import java.awt.Dimension;
import java.awt.Toolkit;
import static java.lang.Thread.sleep;;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.BoxLayout;
import javax.swing.JOptionPane;

public class PnLista extends javax.swing.JPanel {
    private DefaultListModel listModel = new DefaultListModel();
    private List<List> listaTareas = new ArrayList();
    
    FrmDatosProyectos parent;
    
    private List<String> datos = new ArrayList<>();
    private String[] datosUsuario = new String[2];
    
    private int selected = -1;
    private String valor = null;
    
    private int estadoId = 0;
    private int index = -1;
    
    private LocalTime date = LocalTime.now();

    public PnLista() {
        initComponents();
    }
    
    public PnLista(String titulo, int estadoId, int index, 
            List<String> datos, String[] datosUsuario, FrmDatosProyectos parent){
        initComponents();
        this.LbTitulo.setText(titulo);
        this.estadoId = estadoId;
        this.index = index;
        
        this.datos = datos;
        this.datosUsuario = datosUsuario;
        
        this.parent = parent;
    }
    
    public PnLista(String titulo, int estadoId, int index, DefaultListModel model){
        initComponents();
        this.LbTitulo.setText(titulo);
        
        this.estadoId = estadoId;
        this.index = index;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PnPanel = new javax.swing.JPanel();
        LbTitulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListLista = new javax.swing.JList<>();
        BtnEliminar = new javax.swing.JButton();
        BtnAgregarTarea = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(300, 600));

        PnPanel.setBackground(new java.awt.Color(255, 255, 255));
        PnPanel.setForeground(new java.awt.Color(52, 73, 85));
        PnPanel.setMaximumSize(new java.awt.Dimension(400, 400));
        PnPanel.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                PnPanelFocusLost(evt);
            }
        });

        LbTitulo.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        LbTitulo.setForeground(new java.awt.Color(52, 73, 85));
        LbTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LbTitulo.setText("Titulo");

        ListLista.setBackground(new java.awt.Color(255, 255, 255));
        ListLista.setFont(new java.awt.Font("Open Sans", 1, 14)); // NOI18N
        ListLista.setForeground(new java.awt.Color(114, 54, 18));
        ListLista.setModel(listModel);
        ListLista.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        ListLista.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ListLista.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ListListaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                ListListaFocusLost(evt);
            }
        });
        ListLista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ListListaMouseExited(evt);
            }
        });
        jScrollPane1.setViewportView(ListLista);

        BtnEliminar.setBackground(new java.awt.Color(255, 51, 51));
        BtnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        BtnEliminar.setText("X");
        BtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminarActionPerformed(evt);
            }
        });

        BtnAgregarTarea.setBackground(new java.awt.Color(216, 161, 60));
        BtnAgregarTarea.setFont(new java.awt.Font("Open Sans", 1, 14)); // NOI18N
        BtnAgregarTarea.setForeground(new java.awt.Color(52, 73, 85));
        BtnAgregarTarea.setText("Agregar Tarea");
        BtnAgregarTarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAgregarTareaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PnPanelLayout = new javax.swing.GroupLayout(PnPanel);
        PnPanel.setLayout(PnPanelLayout);
        PnPanelLayout.setHorizontalGroup(
            PnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnPanelLayout.createSequentialGroup()
                .addGroup(PnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(LbTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnAgregarTarea, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnEliminar)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PnPanelLayout.setVerticalGroup(
            PnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LbTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtnEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(BtnAgregarTarea, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PnPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PnPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ListListaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ListListaFocusLost
        try{
            this.setSelected(this.ListLista.getSelectedIndex());
            this.setValor(this.ListLista.getSelectedValue().toString());
            this.setDate(LocalTime.now());
            this.parent.setLastIndex(index);
            try {
                sleep(250);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }finally{
                this.ListLista.clearSelection();
            }
        }catch(NullPointerException e){
            JOptionPane.showMessageDialog(null, "Debe de seleccionar una tarea");
        }
    }//GEN-LAST:event_ListListaFocusLost

    private void PnPanelFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PnPanelFocusLost
        
    }//GEN-LAST:event_PnPanelFocusLost

    private void BtnAgregarTareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAgregarTareaActionPerformed
        FrmNuevaTarea nuevaTarea = new FrmNuevaTarea(this.datos, this.datosUsuario, true, this.estadoId);
        nuevaTarea.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int height = screenSize.height;
        int width = screenSize.width;
        // miembro.setSize(width/2, height/2);
        nuevaTarea.setLocationRelativeTo(null);
        nuevaTarea.setVisible(true);
        
        this.parent.dispose();
    }//GEN-LAST:event_BtnAgregarTareaActionPerformed

    private void ListListaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ListListaMouseExited
        
    }//GEN-LAST:event_ListListaMouseExited

    private void ListListaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ListListaFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_ListListaFocusGained

    private void BtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnEliminarActionPerformed


    // GETTERS Y SETTERS DE LA CLASE.
    public JLabel getLbTitulo() {
        return LbTitulo;
    }

    public void setLbTitulo(JLabel LbTitulo) {
        this.LbTitulo = LbTitulo;
    }  

    public JList<String> getListLista() {
        return ListLista;
    }

    public void setListLista(JList<String> ListLista) {
        this.ListLista = ListLista;
    }

    public int getSelected() {
        return selected;
    }

    public void setSelected(int selected) {
        this.selected = selected;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
    
    // METODOS DE LA CLASE.
    public void agregarElemento(String elemento){
        this.listModel.addElement(elemento);
    }
    
    public void removerElemento(int index){
        this.listModel.remove(index);
    }

    public int getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(int estadoId) {
        this.estadoId = estadoId;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public List<List> getListaTareas() {
        return listaTareas;
    }

    public void setListaTareas(List listaTareas) {
        this.listaTareas = listaTareas;
    }

    public LocalTime getDate() {
        return date;
    }

    public void setDate(LocalTime date) {
        this.date = date;
    }
    
    // METODOS DE LA CLASE.
    public void setModelo(){
        for(var dato: this.getListaTareas().get(1)){
            this.listModel.addElement(dato);
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAgregarTarea;
    private javax.swing.JButton BtnEliminar;
    private javax.swing.JLabel LbTitulo;
    private javax.swing.JList<String> ListLista;
    private javax.swing.JPanel PnPanel;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
