
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
    private int lastIndex = -1;

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

        jPanel1 = new javax.swing.JPanel();
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
        setTitle("Proyecto");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                formFocusLost(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        PnPanel.setBackground(new java.awt.Color(255, 255, 255));

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

        LbTitulo.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        LbTitulo.setForeground(new java.awt.Color(52, 73, 85));
        LbTitulo.setText("Proyecto");

        LbAgregarLista.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        LbAgregarLista.setForeground(new java.awt.Color(52, 73, 85));
        LbAgregarLista.setText("Agregar Lista");

        TxtTituloNuevaLista.setBackground(new java.awt.Color(255, 255, 255));
        TxtTituloNuevaLista.setForeground(new java.awt.Color(114, 54, 18));

        BtnAgregar.setBackground(new java.awt.Color(216, 161, 60));
        BtnAgregar.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        BtnAgregar.setForeground(new java.awt.Color(35, 47, 52));
        BtnAgregar.setText("Agregar");
        BtnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAgregarActionPerformed(evt);
            }
        });

        BtnForward.setBackground(new java.awt.Color(216, 161, 60));
        BtnForward.setFont(new java.awt.Font("Open Sans", 1, 24)); // NOI18N
        BtnForward.setForeground(new java.awt.Color(35, 47, 52));
        BtnForward.setText(">");
        BtnForward.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnForwardActionPerformed(evt);
            }
        });

        BtnBackward.setBackground(new java.awt.Color(216, 161, 60));
        BtnBackward.setFont(new java.awt.Font("Open Sans", 1, 24)); // NOI18N
        BtnBackward.setForeground(new java.awt.Color(35, 47, 52));
        BtnBackward.setText("<");
        BtnBackward.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnBackwardActionPerformed(evt);
            }
        });

        BtnAgregarMiembro.setBackground(new java.awt.Color(216, 161, 60));
        BtnAgregarMiembro.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        BtnAgregarMiembro.setForeground(new java.awt.Color(35, 47, 52));
        BtnAgregarMiembro.setText("Agregar Miembro");
        BtnAgregarMiembro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAgregarMiembroActionPerformed(evt);
            }
        });

        ListMiembros.setBackground(new java.awt.Color(255, 255, 255));
        ListMiembros.setFont(new java.awt.Font("Open Sans", 1, 14)); // NOI18N
        ListMiembros.setModel(listModel);
        jScrollPane1.setViewportView(ListMiembros);

        LbMiembros.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        LbMiembros.setForeground(new java.awt.Color(52, 73, 85));
        LbMiembros.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LbMiembros.setText("Miembros");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(LbTitulo)
                            .addComponent(LbAgregarLista))
                        .addGap(47, 47, 47)
                        .addComponent(TxtTituloNuevaLista, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(BtnAgregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LbMiembros, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 944, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(BtnBackward)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(BtnForward)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BtnAgregarMiembro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(LbTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnAgregar)
                    .addComponent(TxtTituloNuevaLista, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LbAgregarLista)
                    .addComponent(LbMiembros))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnAgregarMiembro, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnForward)
                    .addComponent(BtnBackward))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Abre una nueva instancia de FrmNuevaTarea.
     * @param evt 
     */
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

    /***
     * Modifica el estado de una tarea,
     * moviendola al siguiente panel.
     * @param evt 
     */
    private void BtnForwardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnForwardActionPerformed
        
        Tarea tarea = new Tarea();
        boolean flag = false;
        for(int i=0; (i<listaComponentes.size() && !flag); i++){
            PnLista componeneteActual = listaComponentes.get(i);
            if((listaComponentes.get(i).getSelected() > -1 && (i+1)<listaComponentes.size() && this.getLastIndex() == i)){ // && this.isUltimoSeleccionado(i)
                
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
                    
                    flag = true;
                }
                else{
                    System.out.println("Es la ultima lista");
                }
                
                listaComponentes.get(i).setSelected(-1);
            }
        }
    }//GEN-LAST:event_BtnForwardActionPerformed

    /***
     * Modifica el estado de una tarea,
     * moviendola al panel previo.
     * @param evt 
     */
    private void BtnBackwardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnBackwardActionPerformed
        Tarea tarea = new Tarea();
        boolean flag = false;
        
        for(int i=0; (i < listaComponentes.size() && !flag); i++){
            PnLista componenteActual = listaComponentes.get(i);
            if(componenteActual.getSelected() > -1 && (i-1)>=0 && this.getLastIndex() == i){
                if((i-1) >= 0){
                    PnLista componenteSiguiente = listaComponentes.get(i-1);
                    int tareaId = Integer.parseInt(componenteActual.getListaTareas()
                                    .get(0).get(componenteActual.getSelected()).toString());
                    
                    listaComponentes.get(i-1).agregarElemento(componenteActual.getValor());
                    
                    List tareaAModificar = new ArrayList();
                    tareaAModificar.add(componenteActual.getListaTareas().get(0).get(componenteActual.getSelected()));
                    tareaAModificar.add(componenteActual.getListaTareas().get(1).get(componenteActual.getSelected()));
                    
                    componenteSiguiente.getListaTareas().get(0).add(tareaAModificar.get(0));
                    componenteSiguiente.getListaTareas().get(1).add(tareaAModificar.get(1));
                    
                    componenteActual.getListaTareas().get(0).remove(componenteActual.getSelected());
                    componenteActual.getListaTareas().get(1).remove(componenteActual.getSelected());
                    
                    componenteActual.removerElemento(componenteActual.getSelected());
                    
                    tarea.modificarEstado(tareaId, Integer.parseInt(this.listaEstados.get(0).get(i-1).toString()));
                    
                    flag = true;
                }
                else{
                    System.out.println("Es la primer lista");
                }
                
                componenteActual.setSelected(-1);
            }
        }
    }//GEN-LAST:event_BtnBackwardActionPerformed

    /***
     * Abre una nueva instancia de FrmMiembros
     * @param evt 
     */
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
    
    // GETTERS Y SETTERS.
    public int getLastIndex(){
        return this.lastIndex;
    }
    
    public void setLastIndex(int lastIndex){
        this.lastIndex = lastIndex;
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
    
    public boolean isUltimoSeleccionado(int indice){
        PnLista mayor = listaComponentes.get(indice);
        System.out.println(listaComponentes.get(indice).getLbTitulo().getText().trim() + 
                               " : " + listaComponentes.get(indice).getDate());
        
        for(int i = 1; i < listaComponentes.size(); i++){
            System.out.println(listaComponentes.get(i).getLbTitulo().getText().trim() + 
                               " : " + listaComponentes.get(i).getDate());
            if(listaComponentes.get(i).getDate().compareTo(mayor.getDate()) == 1){
                return false;
            }
        }
        System.out.println("");
        
        return true;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
