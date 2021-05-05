
package vistas.Issues;

import java.awt.Color;
import java.util.List;

public class PnIssue extends javax.swing.JPanel {

    public PnIssue() {
        initComponents();
    }
    
    public PnIssue(List issue) {
        initComponents();
        
        this.LbTitulo.setText(issue.get(1).toString());
        this.LbDescripcion.setText(issue.get(2).toString());
        this.LbEstado.setBackground(
                (boolean)issue.get(4) ? Color.GREEN : Color.red
        );
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LbTitulo = new javax.swing.JLabel();
        LbDescripcion = new javax.swing.JLabel();
        LbEstado = new javax.swing.JLabel();

        LbTitulo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        LbTitulo.setText("Título");

        LbDescripcion.setText("Descripción");

        LbEstado.setText("Estado");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LbTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LbEstado, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(LbDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(LbTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(LbEstado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LbDescripcion)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    @Override
    public String toString(){
        return this.LbTitulo.getText().trim();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LbDescripcion;
    private javax.swing.JLabel LbEstado;
    private javax.swing.JLabel LbTitulo;
    // End of variables declaration//GEN-END:variables
}
