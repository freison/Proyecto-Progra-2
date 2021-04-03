
package vistas;

import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BoxLayout;

public class FrmDatosProyectos extends javax.swing.JFrame {
    
    private List<PnLista> listaComponentes = new ArrayList<>();

    public FrmDatosProyectos() {
        initComponents();
    }
    
    public FrmDatosProyectos(List datos, String[] datosUsuario){
//        llenarListaMiembros(Integer.parseInt(datos.get(0).toString()));
        initComponents();
        PnPanel.setLayout(new BoxLayout(this.PnPanel, BoxLayout.X_AXIS));
//        LbTitulo.setText(LbTitulo.getText() + " " + datos.get(1));
//        
//        this.Datos = datos;
//        this.datosUsuario = datosUsuario;
//        
//        llenarListas();
//        
//        validarPropietario(Integer.parseInt(datos.get(0).toString()), datosUsuario[0]);
//        validarRol(datosUsuario[1]);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ScrollPane = new javax.swing.JScrollPane();
        PnPanel = new javax.swing.JPanel();
        LbTitulo = new javax.swing.JLabel();
        LbAgregarLista = new javax.swing.JLabel();
        TxtTituloNuevaLista = new javax.swing.JTextField();
        BtnAgregar = new javax.swing.JButton();
        BtnForward = new javax.swing.JButton();
        BtnBackward = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout PnPanelLayout = new javax.swing.GroupLayout(PnPanel);
        PnPanel.setLayout(PnPanelLayout);
        PnPanelLayout.setHorizontalGroup(
            PnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 942, Short.MAX_VALUE)
        );
        PnPanelLayout.setVerticalGroup(
            PnPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 491, Short.MAX_VALUE)
        );

        ScrollPane.setViewportView(PnPanel);

        LbTitulo.setFont(new java.awt.Font("Open Sans", 1, 16)); // NOI18N
        LbTitulo.setText("Proyecto");

        LbAgregarLista.setFont(new java.awt.Font("Open Sans", 0, 14)); // NOI18N
        LbAgregarLista.setText("Agregar Lista");

        BtnAgregar.setText("Agregar");
        BtnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAgregarActionPerformed(evt);
            }
        });

        BtnForward.setFont(new java.awt.Font("Open Sans", 1, 24)); // NOI18N
        BtnForward.setText(">");
        BtnForward.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnForwardActionPerformed(evt);
            }
        });

        BtnBackward.setFont(new java.awt.Font("Open Sans", 1, 24)); // NOI18N
        BtnBackward.setText("<");
        BtnBackward.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBackwardActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(ScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 944, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 244, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LbTitulo)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LbAgregarLista)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TxtTituloNuevaLista, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnAgregar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BtnBackward)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtnForward)
                .addGap(513, 513, 513))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LbTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LbAgregarLista)
                    .addComponent(TxtTituloNuevaLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BtnAgregar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnForward)
                    .addComponent(BtnBackward))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAgregarActionPerformed
      
        PnLista panel = new PnLista(this.TxtTituloNuevaLista.getText().trim(), 1, listaComponentes.size());
        listaComponentes.add(panel);
        
        PnPanel.add(panel);
        PnPanel.revalidate();
        
        
        
        for(var dato: PnPanel.getComponents()){
            PnLista t = (PnLista)PnPanel.getComponent(0);
            System.out.println(t.getLbTitulo().getText().trim());
        }
    }//GEN-LAST:event_BtnAgregarActionPerformed

    private void BtnForwardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnForwardActionPerformed
        
        for(int i=0; i<listaComponentes.size(); i++){
            PnLista componeneteActual = listaComponentes.get(i);
            if(listaComponentes.get(i).getSelected() > -1){
                System.out.println(listaComponentes.get(i).getLbTitulo().getText().trim() + " " + 
                        listaComponentes.get(i).getSelected() + " -> " + componeneteActual.getValor());
                
                if((i+1) < listaComponentes.size()){
                    listaComponentes.get(i+1).agregarElemento(componeneteActual.getValor());
                    componeneteActual.removerElemento(componeneteActual.getSelected());
                }
                else{
                    System.out.println("Es la ultima lista"); // LAST INTERACTION.
                }
                
                listaComponentes.get(i).setSelected(-1);
            }
        }
    }//GEN-LAST:event_BtnForwardActionPerformed

    private void BtnBackwardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBackwardActionPerformed
        for(int i=0; i < listaComponentes.size(); i++){
            PnLista componenteActual = listaComponentes.get(i);
            if(componenteActual.getSelected() > -1){
                if((i-1) >= 0){
                    listaComponentes.get(i-1).agregarElemento(componenteActual.getValor());
                    componenteActual.removerElemento(componenteActual.getSelected());
                }
                else{
                    System.out.println("Es la primer lista");
                }
                
                componenteActual.setSelected(-1);
            }
        }
    }//GEN-LAST:event_BtnBackwardActionPerformed

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
            java.util.logging.Logger.getLogger(FrmDatosProyectos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmDatosProyectos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmDatosProyectos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmDatosProyectos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmDatosProyectos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAgregar;
    private javax.swing.JButton BtnBackward;
    private javax.swing.JButton BtnForward;
    private javax.swing.JLabel LbAgregarLista;
    private javax.swing.JLabel LbTitulo;
    private javax.swing.JPanel PnPanel;
    private javax.swing.JScrollPane ScrollPane;
    private javax.swing.JTextField TxtTituloNuevaLista;
    // End of variables declaration//GEN-END:variables
}
