
package vistas;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;

public class PnLista extends javax.swing.JPanel {

    public PnLista() {
        initComponents();
    }
    
    public PnLista(String titulo, int estadoId, int index){
        initComponents();
        this.LbTitulo.setText(titulo);
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

        LbTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LbTitulo.setText("Titulo");

        ListLista.setFont(new java.awt.Font("Open Sans", 1, 14)); // NOI18N
        ListLista.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Elemento1", "Elemento2", "Elemento3" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
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
