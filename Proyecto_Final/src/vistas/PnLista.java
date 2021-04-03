
package vistas;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;

public class PnLista extends javax.swing.JPanel {
    private DefaultListModel listModel = new DefaultListModel();
    
    private int selected = -1;
    private String valor = null;

    public PnLista() {
        initComponents();
    }
    
    public PnLista(String titulo, int estadoId, int index){
        initComponents();
        this.LbTitulo.setText(titulo);
        listModel.addElement("Element1");
        listModel.addElement("Element2");
        listModel.addElement("Element3");
    }
    
    public PnLista(String titulo, int estadoId, int index, DefaultListModel model){
        initComponents();
        this.LbTitulo.setText(titulo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PnPanel = new javax.swing.JPanel();
        LbTitulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListLista = new javax.swing.JList<>();
        BtnForward = new javax.swing.JButton();
        BtnBackward = new javax.swing.JButton();
        BtnAgregarTarea = new javax.swing.JButton();

        PnPanel.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                PnPanelFocusLost(evt);
            }
        });

        LbTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LbTitulo.setText("Titulo");

        ListLista.setFont(new java.awt.Font("Open Sans", 1, 14)); // NOI18N
        ListLista.setModel(listModel);
        ListLista.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        ListLista.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ListLista.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ListListaFocusLost(evt);
            }
        });
        jScrollPane1.setViewportView(ListLista);

        BtnForward.setText(">");

        BtnBackward.setText("<");

        BtnAgregarTarea.setFont(new java.awt.Font("Open Sans", 1, 14)); // NOI18N
        BtnAgregarTarea.setText("Agregar Tarea");

        javax.swing.GroupLayout PnPanelLayout = new javax.swing.GroupLayout(PnPanel);
        PnPanel.setLayout(PnPanelLayout);
        PnPanelLayout.setHorizontalGroup(
            PnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LbTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(PnPanelLayout.createSequentialGroup()
                .addGroup(PnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BtnAgregarTarea, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PnPanelLayout.createSequentialGroup()
                        .addComponent(BtnBackward)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnForward))
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
                .addGroup(PnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnForward)
                    .addComponent(BtnBackward))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
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
                .addComponent(PnPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ListListaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ListListaFocusLost
        this.setSelected(this.ListLista.getSelectedIndex());
        this.setValor(this.ListLista.getSelectedValue().toString());
        try {
            sleep(300);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        this.ListLista.clearSelection();
    }//GEN-LAST:event_ListListaFocusLost

    private void PnPanelFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PnPanelFocusLost
        
    }//GEN-LAST:event_PnPanelFocusLost


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
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAgregarTarea;
    private javax.swing.JButton BtnBackward;
    private javax.swing.JButton BtnForward;
    private javax.swing.JLabel LbTitulo;
    private javax.swing.JList<String> ListLista;
    private javax.swing.JPanel PnPanel;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
