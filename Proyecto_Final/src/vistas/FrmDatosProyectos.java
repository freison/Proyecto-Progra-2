
package vistas;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import proyecto_final.Proyecto;
import proyecto_final.EstadoTarea;
import proyecto_final.Tarea;
import proyecto_final.changeListenner;

public class FrmDatosProyectos extends javax.swing.JFrame {
    
    private static DefaultListModel listModel;
    
    private List<PnLista> listaComponentes = new ArrayList<>();
    private List<List> listaEstados = new ArrayList<>();
    private List<Integer> listaId = new ArrayList<>();
    
    private List listaTareas = new ArrayList();
    
    private changeListenner actualizador;
    
    List<String> datos = new ArrayList<>();
    String[] datosUsuario = new String[2];
    
    private EstadoTarea estado = new EstadoTarea();
    
    private boolean owner = false;

    public FrmDatosProyectos() {
        initComponents();
    }
    
    /***
     * datos contiene de Proyecto: Id, Nombre, Descripcion.
     * datosUsuario contiene de Miembro: usuario, rol.
     * @param datos
     * @param datosUsuario 
     */
    public FrmDatosProyectos(List datos, String[] datosUsuario){
        llenarListaMiembros(Integer.parseInt(datos.get(0).toString()));
        initComponents();
        PnPanel.setLayout(new BoxLayout(this.PnPanel, BoxLayout.X_AXIS));
        
        LbTitulo.setText((datos.get(1).toString().contains("Proyecto"))
                        ?(datos.get(1).toString())
                        :("Proyecto " + datos.get(1)));
        
        this.datos = datos;
        this.datosUsuario = datosUsuario;
        
        llenarPanel();
        
        validarPropietario(Integer.parseInt(datos.get(0).toString()), datosUsuario[0]);
        validarRol(datosUsuario[1]);
        
//        actualizador = new changeListenner("changeListenner", this);
//        actualizador.start();
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
        BtnAgregarMiembro = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListMiembros = new javax.swing.JList<>();
        LbMiembros = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                formFocusLost(evt);
            }
        });

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

        BtnAgregarMiembro.setFont(new java.awt.Font("Open Sans", 1, 12)); // NOI18N
        BtnAgregarMiembro.setText("Agregar Miembro");
        BtnAgregarMiembro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAgregarMiembroActionPerformed(evt);
            }
        });

        ListMiembros.setFont(new java.awt.Font("Open Sans", 1, 14)); // NOI18N
        ListMiembros.setModel(listModel);
        jScrollPane1.setViewportView(ListMiembros);

        LbMiembros.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LbMiembros.setText("Miembros");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(ScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 944, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(LbMiembros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnAgregarMiembro, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LbTitulo)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(LbAgregarLista)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TxtTituloNuevaLista, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnAgregar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LbAgregarLista)
                            .addComponent(TxtTituloNuevaLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnAgregar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(ScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 493, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(BtnAgregarMiembro, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BtnForward)
                            .addComponent(BtnBackward))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(LbMiembros)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAgregarActionPerformed
        int proyectoId = Integer.parseInt(this.datos.get(0));
        estado.setDescripcion(this.TxtTituloNuevaLista.getText().trim());
        estado.Agregar(proyectoId);
        int estadoId = estado.ultimoEstadoPorProyecto(proyectoId);
        
        PnLista panel = new PnLista(this.TxtTituloNuevaLista.getText().trim(),
                estadoId,
                listaComponentes.size(),
                this.datos,
                this.datosUsuario,
                this);
        listaComponentes.add(panel);
        
        this.listaEstados = estado.listarEstadosPorProyecto(
                Integer.parseInt(this.datos.get(0)));
        
        this.llenarLista(estadoId, panel);
        
        PnPanel.add(panel);
        PnPanel.revalidate();
        
        
        
        for(var dato: PnPanel.getComponents()){
            PnLista t = (PnLista)PnPanel.getComponent(0);
            System.out.println(t.getLbTitulo().getText().trim());
        }
    }//GEN-LAST:event_BtnAgregarActionPerformed

    private void BtnForwardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnForwardActionPerformed
        
        Tarea tarea = new Tarea();
        boolean flag = false;
        for(int i=0; (i<listaComponentes.size() && !flag); i++){
            System.out.println("Entry");
            PnLista componeneteActual = listaComponentes.get(i);
            if(listaComponentes.get(i).getSelected() > -1){
                System.out.println(listaComponentes.get(i).getLbTitulo().getText().trim() + " " + 
                        listaComponentes.get(i).getSelected() + " -> " + componeneteActual.getValor());
                
                if((i+1) < listaComponentes.size()){
                    PnLista componenteSiguiente = listaComponentes.get(i+1);
                    int tareaId = Integer.parseInt(componeneteActual.getListaTareas()
                            .get(0).get(componeneteActual.getSelected()).toString());
                    
                    listaComponentes.get(i+1).agregarElemento(componeneteActual.getValor());
                    
                    List tareaAModificar = new ArrayList();
                    tareaAModificar.add(componeneteActual.getListaTareas().get(0).get(componeneteActual.getSelected()));
                    tareaAModificar.add(componeneteActual.getListaTareas().get(1).get(componeneteActual.getSelected()));
                    
                    componenteSiguiente.getListaTareas().get(0).add(tareaAModificar.get(0));
                    componenteSiguiente.getListaTareas().get(1).add(tareaAModificar.get(1));
                    
                    componeneteActual.getListaTareas().get(0).remove(componeneteActual.getSelected());
                    componeneteActual.getListaTareas().get(1).remove(componeneteActual.getSelected());
                    
                    componeneteActual.removerElemento(componeneteActual.getSelected());
                    
                    tarea.modificarEstado(tareaId, Integer.parseInt(this.listaEstados.get(0).get(i+1).toString()));
                    
                    flag = true; // LAST INTERACTION.
                }
                else{
                    System.out.println("Es la ultima lista");
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

    private void BtnAgregarMiembroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAgregarMiembroActionPerformed
        FrmMiembro miembro = new FrmMiembro(this.datos, datosUsuario, true);
        miembro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int height = screenSize.height;
        int width = screenSize.width;
        miembro.setSize(width/2, height/2);
        miembro.setLocationRelativeTo(null);
        miembro.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BtnAgregarMiembroActionPerformed

    private void formFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusLost
        
    }//GEN-LAST:event_formFocusLost

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
    
    // METODOS DE LA CLASE.
    public void llenarListaMiembros(int Id){
        Proyecto proyecto = new Proyecto();
        var nombres = proyecto.listarMiembros(Id);
        listModel = new DefaultListModel();
        
        for(int i=0; i<nombres.size(); i++){
            listModel.addElement(nombres.get(i)); // LAST INTERACTION
        }
    }
    
    /***
     * Obtiene el propietario del proyecto en base a proyecto Id.
     * @param Id
     * @param usuario 
     */
    public void validarPropietario(int Id, String usuario){
        Proyecto proyecto = new Proyecto();
        String propietario = proyecto.obtenerCreador(Id);
        
        if(!propietario.equalsIgnoreCase(usuario)){
            this.BtnAgregarMiembro.setEnabled(false);
            this.BtnAgregarMiembro.setVisible(false);
        }
        else{
            this.owner = true;
        }
    }
    
    public void validarRol(String rol){
        if(rol.equals("Invitado")){
            
            this.ocultarBotones();
        }
        else if(rol.equals("Editor")){
            
        }
        else if(rol.equals("Administrador") && !this.owner){
            
        }
    }
    
    public void ocultarBotones(){
        this.BtnForward.setVisible(false);
        this.BtnBackward.setVisible(false);
    }
    
    public void llenarPanel(){
        this.listaEstados = estado.listarEstadosPorProyecto(
                Integer.parseInt(this.datos.get(0)));
        if(!this.listaEstados.get(0).isEmpty()){
            for(int i = 0; i < listaEstados.get(0).size(); i++){
                estado.setDescripcion(this.listaEstados.get(1).get(i).toString());

                PnLista panel = new PnLista(estado.getDescripcion(),
                        Integer.parseInt(listaEstados.get(0).get(i).toString()),
                        listaComponentes.size(),
                        this.datos,
                        this.datosUsuario,
                        this);
                this.llenarLista(Integer.parseInt(listaEstados.get(0).get(i).toString()), panel);
                listaComponentes.add(panel);

                PnPanel.add(panel);
                PnPanel.revalidate();
            }
        }
    }
    
    public void llenarLista(int estadoId, PnLista componente){
        Tarea tarea = new Tarea();
        List<List> lista = tarea.listarTareasPorEstado(estadoId);
        this.listaTareas.add(tarea);
        
        componente.setListaTareas(lista);
        componente.setModelo();
    }

    public JPanel getPnPanel() {
        return PnPanel;
    }

    public void setPnPanel(JPanel PnPanel) {
        this.PnPanel = PnPanel;
    }

    public List<PnLista> getListaComponentes() {
        return listaComponentes;
    }

    public void setListaComponentes(List<PnLista> listaComponentes) {
        this.listaComponentes = listaComponentes;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAgregar;
    private javax.swing.JButton BtnAgregarMiembro;
    private javax.swing.JButton BtnBackward;
    private javax.swing.JButton BtnForward;
    private javax.swing.JLabel LbAgregarLista;
    private javax.swing.JLabel LbMiembros;
    private javax.swing.JLabel LbTitulo;
    private javax.swing.JList<String> ListMiembros;
    private javax.swing.JPanel PnPanel;
    private javax.swing.JScrollPane ScrollPane;
    private javax.swing.JTextField TxtTituloNuevaLista;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
