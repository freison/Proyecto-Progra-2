package vistas;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import proyecto_final.Proyecto;
import proyecto_final.Tarea;
import proyecto_final.EstadoTarea;
import vistas.Issues.FrmNuevoIssue;

public class FrmDatosProyecto extends javax.swing.JFrame {

    FondoPanelDatosProyecto fondo = new FondoPanelDatosProyecto();
    private static DefaultListModel listModel;
    private DefaultListModel listPorHacerModel = new DefaultListModel();
    private DefaultListModel listEnProcesoModel = new DefaultListModel();
    private DefaultListModel listFinalizadoModel = new DefaultListModel();
    private List<List<String>> porHacer = new ArrayList<>();
    private List<List<String>> enProceso = new ArrayList<>();
    private List<List<String>> finalizado = new ArrayList<>();
    private List<String> Datos = new ArrayList<>();
    private String[] datosUsuario = new String[2];

    int proyectoId = 0;

    private EstadoTarea estados = new EstadoTarea();
    private List<List> datosEstado;

    private boolean owner = false;

    public FrmDatosProyecto() {
        this.setContentPane(fondo);
        initComponents();
    }

    /**
     * *
     * List datos posee el Id, Nombre y Descripcion del Proyecto
     * []datosUsuario posee el usuario y rol del Miembro.
     *
     * @param datos
     * @param datosUsuario
     */
    public FrmDatosProyecto(List datos, String[] datosUsuario) {
        llenarListaMiembros(Integer.parseInt(datos.get(0).toString()));
        initComponents();
        LbTitulo.setText(LbTitulo.getText() + " " + datos.get(1));

        this.Datos = datos;
        this.datosUsuario = datosUsuario;

        proyectoId = Integer.parseInt(this.Datos.get(0));

        datosEstado = estados.listarEstadosPorProyecto(proyectoId);

        llenarListas();

        validarPropietario(Integer.parseInt(datos.get(0).toString()), datosUsuario[0]);
        validarRol(datosUsuario[1]);
    }
    
    public FrmDatosProyecto(List datos, String[] datosUsuario, int tabIndex) {
        llenarListaMiembros(Integer.parseInt(datos.get(0).toString()));
        initComponents();
        LbTitulo.setText(LbTitulo.getText() + " " + datos.get(1));

        this.Datos = datos;
        this.datosUsuario = datosUsuario;

        proyectoId = Integer.parseInt(this.Datos.get(0));

        datosEstado = estados.listarEstadosPorProyecto(proyectoId);

        llenarListas();

        validarPropietario(Integer.parseInt(datos.get(0).toString()), datosUsuario[0]);
        validarRol(datosUsuario[1]);
        this.TabPanel.setSelectedIndex(tabIndex);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TabPanel = new javax.swing.JTabbedPane();
        PnPanelTareasProyecto = new FondoPanelDatosProyecto();
        LbTitulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListEnProceso = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        ListPorHacer = new javax.swing.JList<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        ListFinalizado = new javax.swing.JList<>();
        LbPorHacer = new javax.swing.JLabel();
        LbEnProceso = new javax.swing.JLabel();
        LbFinalizadas = new javax.swing.JLabel();
        LbMiembros = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        ListMiembros = new javax.swing.JList<>();
        BtnAgregarMiembro = new javax.swing.JButton();
        BtnAgregarTarea = new javax.swing.JButton();
        BtnPorHacer_To_EnProceso = new javax.swing.JButton();
        BtnEnProceso_To_Finalizado = new javax.swing.JButton();
        BtnEnProceso_To_PorHacer = new javax.swing.JButton();
        BtnFinalizado_To_EnProceso = new javax.swing.JButton();
        PnIssues = new javax.swing.JPanel();
        BtnNewIssue = new java.awt.Button();
        jScrollPane4 = new javax.swing.JScrollPane();
        ListIssues = new javax.swing.JList<>();
        PnDetallesIssue = new javax.swing.JPanel();
        LbIssueTitulo = new javax.swing.JLabel();
        LbDescripcion = new javax.swing.JLabel();
        BtnAgregarComentarioAIssue = new javax.swing.JButton();
        ScrollComentariosIssue = new javax.swing.JScrollPane();
        PnComentariosIssue = new javax.swing.JPanel();
        PnRescursos = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));

        PnPanelTareasProyecto.setBackground(new java.awt.Color(255, 255, 255));

        LbTitulo.setFont(new java.awt.Font("Open Sans", 1, 36)); // NOI18N
        LbTitulo.setForeground(new java.awt.Color(52, 73, 85));
        LbTitulo.setText("Proyecto");

        ListEnProceso.setBackground(new java.awt.Color(255, 255, 255));
        ListEnProceso.setFont(new java.awt.Font("Open Sans", 1, 14)); // NOI18N
        ListEnProceso.setForeground(new java.awt.Color(114, 54, 18));
        ListEnProceso.setModel(listEnProcesoModel);
        jScrollPane1.setViewportView(ListEnProceso);

        ListPorHacer.setBackground(new java.awt.Color(255, 255, 255));
        ListPorHacer.setFont(new java.awt.Font("Open Sans", 1, 14)); // NOI18N
        ListPorHacer.setForeground(new java.awt.Color(255, 102, 102));
        ListPorHacer.setModel(listPorHacerModel);
        ListPorHacer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ListPorHacerMouseClicked(evt);
            }
        });
        ListPorHacer.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                ListPorHacerValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(ListPorHacer);

        ListFinalizado.setBackground(new java.awt.Color(255, 255, 255));
        ListFinalizado.setFont(new java.awt.Font("Open Sans", 1, 14)); // NOI18N
        ListFinalizado.setForeground(new java.awt.Color(0, 153, 51));
        ListFinalizado.setModel(listFinalizadoModel);
        jScrollPane3.setViewportView(ListFinalizado);

        LbPorHacer.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        LbPorHacer.setForeground(new java.awt.Color(52, 73, 85));
        LbPorHacer.setText("Tareas Por Hacer");

        LbEnProceso.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        LbEnProceso.setForeground(new java.awt.Color(52, 73, 85));
        LbEnProceso.setText("Tareas en Proceso");

        LbFinalizadas.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        LbFinalizadas.setForeground(new java.awt.Color(52, 73, 85));
        LbFinalizadas.setText("Tareas Finalizadas");

        LbMiembros.setFont(new java.awt.Font("Open Sans", 0, 18)); // NOI18N
        LbMiembros.setForeground(new java.awt.Color(52, 73, 85));
        LbMiembros.setText("Miembros");

        ListMiembros.setBackground(new java.awt.Color(255, 255, 255));
        ListMiembros.setForeground(new java.awt.Color(114, 54, 18));
        ListMiembros.setModel(listModel);
        jScrollPane5.setViewportView(ListMiembros);

        BtnAgregarMiembro.setBackground(new java.awt.Color(216, 161, 60));
        BtnAgregarMiembro.setFont(new java.awt.Font("Open Sans", 1, 14)); // NOI18N
        BtnAgregarMiembro.setForeground(new java.awt.Color(35, 47, 52));
        BtnAgregarMiembro.setText("Agregar Miembro");
        BtnAgregarMiembro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAgregarMiembroActionPerformed(evt);
            }
        });

        BtnAgregarTarea.setBackground(new java.awt.Color(216, 161, 60));
        BtnAgregarTarea.setFont(new java.awt.Font("Open Sans", 1, 14)); // NOI18N
        BtnAgregarTarea.setForeground(new java.awt.Color(35, 47, 52));
        BtnAgregarTarea.setText("Agregar Tarea");
        BtnAgregarTarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAgregarTareaActionPerformed(evt);
            }
        });

        BtnPorHacer_To_EnProceso.setBackground(new java.awt.Color(216, 161, 60));
        BtnPorHacer_To_EnProceso.setForeground(new java.awt.Color(35, 47, 52));
        BtnPorHacer_To_EnProceso.setText(">");
        BtnPorHacer_To_EnProceso.setToolTipText("");
        BtnPorHacer_To_EnProceso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPorHacer_To_EnProcesoActionPerformed(evt);
            }
        });

        BtnEnProceso_To_Finalizado.setBackground(new java.awt.Color(216, 161, 60));
        BtnEnProceso_To_Finalizado.setForeground(new java.awt.Color(35, 47, 52));
        BtnEnProceso_To_Finalizado.setText(">");
        BtnEnProceso_To_Finalizado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEnProceso_To_FinalizadoActionPerformed(evt);
            }
        });

        BtnEnProceso_To_PorHacer.setBackground(new java.awt.Color(216, 161, 60));
        BtnEnProceso_To_PorHacer.setForeground(new java.awt.Color(35, 47, 52));
        BtnEnProceso_To_PorHacer.setText("<");
        BtnEnProceso_To_PorHacer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEnProceso_To_PorHacerActionPerformed(evt);
            }
        });

        BtnFinalizado_To_EnProceso.setBackground(new java.awt.Color(216, 161, 60));
        BtnFinalizado_To_EnProceso.setForeground(new java.awt.Color(35, 47, 52));
        BtnFinalizado_To_EnProceso.setText("<");
        BtnFinalizado_To_EnProceso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnFinalizado_To_EnProcesoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PnPanelTareasProyectoLayout = new javax.swing.GroupLayout(PnPanelTareasProyecto);
        PnPanelTareasProyecto.setLayout(PnPanelTareasProyectoLayout);
        PnPanelTareasProyectoLayout.setHorizontalGroup(
            PnPanelTareasProyectoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnPanelTareasProyectoLayout.createSequentialGroup()
                .addGroup(PnPanelTareasProyectoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PnPanelTareasProyectoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(PnPanelTareasProyectoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(LbPorHacer)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnPanelTareasProyectoLayout.createSequentialGroup()
                                .addComponent(BtnAgregarTarea)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(BtnPorHacer_To_EnProceso, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(PnPanelTareasProyectoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PnPanelTareasProyectoLayout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addComponent(BtnEnProceso_To_PorHacer, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(BtnEnProceso_To_Finalizado, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnPanelTareasProyectoLayout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(PnPanelTareasProyectoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LbEnProceso)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(LbTitulo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PnPanelTareasProyectoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PnPanelTareasProyectoLayout.createSequentialGroup()
                        .addGroup(PnPanelTareasProyectoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LbFinalizadas))
                        .addGroup(PnPanelTareasProyectoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PnPanelTareasProyectoLayout.createSequentialGroup()
                                .addGap(144, 144, 144)
                                .addComponent(LbMiembros)
                                .addGap(156, 156, 156))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnPanelTareasProyectoLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(PnPanelTareasProyectoLayout.createSequentialGroup()
                        .addComponent(BtnFinalizado_To_EnProceso, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(356, 356, 356)
                        .addComponent(BtnAgregarMiembro)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PnPanelTareasProyectoLayout.setVerticalGroup(
            PnPanelTareasProyectoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PnPanelTareasProyectoLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(PnPanelTareasProyectoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PnPanelTareasProyectoLayout.createSequentialGroup()
                        .addComponent(LbTitulo)
                        .addGap(18, 18, 18)
                        .addGroup(PnPanelTareasProyectoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(PnPanelTareasProyectoLayout.createSequentialGroup()
                                .addComponent(LbMiembros)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PnPanelTareasProyectoLayout.createSequentialGroup()
                        .addGroup(PnPanelTareasProyectoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(PnPanelTareasProyectoLayout.createSequentialGroup()
                                .addGroup(PnPanelTareasProyectoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(LbEnProceso)
                                    .addComponent(LbFinalizadas))
                                .addGap(6, 6, 6))
                            .addGroup(PnPanelTareasProyectoLayout.createSequentialGroup()
                                .addComponent(LbPorHacer)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(PnPanelTareasProyectoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(PnPanelTareasProyectoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(PnPanelTareasProyectoLayout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(PnPanelTareasProyectoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PnPanelTareasProyectoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(BtnPorHacer_To_EnProceso)
                                .addComponent(BtnEnProceso_To_PorHacer)
                                .addComponent(BtnEnProceso_To_Finalizado)
                                .addComponent(BtnFinalizado_To_EnProceso))
                            .addComponent(BtnAgregarMiembro)))
                    .addGroup(PnPanelTareasProyectoLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(BtnAgregarTarea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        TabPanel.addTab("Tareas", PnPanelTareasProyecto);

        BtnNewIssue.setBackground(new java.awt.Color(255, 255, 153));
        BtnNewIssue.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BtnNewIssue.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        BtnNewIssue.setLabel("Agregar");
        BtnNewIssue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnNewIssueActionPerformed(evt);
            }
        });

        ListIssues.setBackground(new java.awt.Color(255, 255, 255));
        ListIssues.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        ListIssues.setForeground(new java.awt.Color(51, 51, 51));
        ListIssues.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane4.setViewportView(ListIssues);

        PnDetallesIssue.setBackground(new java.awt.Color(255, 255, 204));

        LbIssueTitulo.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        LbIssueTitulo.setForeground(new java.awt.Color(0, 0, 0));
        LbIssueTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LbIssueTitulo.setText("jLabel1");

        LbDescripcion.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        LbDescripcion.setForeground(new java.awt.Color(0, 0, 0));
        LbDescripcion.setText("jLabel1");

        BtnAgregarComentarioAIssue.setBackground(new java.awt.Color(0, 153, 0));
        BtnAgregarComentarioAIssue.setForeground(new java.awt.Color(255, 255, 255));
        BtnAgregarComentarioAIssue.setText("+");
        BtnAgregarComentarioAIssue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAgregarComentarioAIssueActionPerformed(evt);
            }
        });

        ScrollComentariosIssue.setBackground(new java.awt.Color(255, 153, 51));

        PnComentariosIssue.setBackground(new java.awt.Color(255, 204, 51));

        javax.swing.GroupLayout PnComentariosIssueLayout = new javax.swing.GroupLayout(PnComentariosIssue);
        PnComentariosIssue.setLayout(PnComentariosIssueLayout);
        PnComentariosIssueLayout.setHorizontalGroup(
            PnComentariosIssueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 826, Short.MAX_VALUE)
        );
        PnComentariosIssueLayout.setVerticalGroup(
            PnComentariosIssueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 341, Short.MAX_VALUE)
        );

        ScrollComentariosIssue.setViewportView(PnComentariosIssue);

        javax.swing.GroupLayout PnDetallesIssueLayout = new javax.swing.GroupLayout(PnDetallesIssue);
        PnDetallesIssue.setLayout(PnDetallesIssueLayout);
        PnDetallesIssueLayout.setHorizontalGroup(
            PnDetallesIssueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnDetallesIssueLayout.createSequentialGroup()
                .addGroup(PnDetallesIssueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PnDetallesIssueLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(LbIssueTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(PnDetallesIssueLayout.createSequentialGroup()
                        .addGroup(PnDetallesIssueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LbDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ScrollComentariosIssue))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnAgregarComentarioAIssue, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        PnDetallesIssueLayout.setVerticalGroup(
            PnDetallesIssueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnDetallesIssueLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LbIssueTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LbDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PnDetallesIssueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PnDetallesIssueLayout.createSequentialGroup()
                        .addComponent(BtnAgregarComentarioAIssue)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(ScrollComentariosIssue)))
        );

        javax.swing.GroupLayout PnIssuesLayout = new javax.swing.GroupLayout(PnIssues);
        PnIssues.setLayout(PnIssuesLayout);
        PnIssuesLayout.setHorizontalGroup(
            PnIssuesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnIssuesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PnIssuesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane4)
                    .addComponent(BtnNewIssue, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PnDetallesIssue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PnIssuesLayout.setVerticalGroup(
            PnIssuesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnIssuesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PnIssuesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PnIssuesLayout.createSequentialGroup()
                        .addComponent(jScrollPane4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BtnNewIssue, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(PnDetallesIssue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        TabPanel.addTab("Issues", PnIssues);

        javax.swing.GroupLayout PnRescursosLayout = new javax.swing.GroupLayout(PnRescursos);
        PnRescursos.setLayout(PnRescursosLayout);
        PnRescursosLayout.setHorizontalGroup(
            PnRescursosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1150, Short.MAX_VALUE)
        );
        PnRescursosLayout.setVerticalGroup(
            PnRescursosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 555, Short.MAX_VALUE)
        );

        TabPanel.addTab("Recursos", PnRescursos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TabPanel)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TabPanel)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnAgregarMiembroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAgregarMiembroActionPerformed
        FrmMiembro miembro = new FrmMiembro(this.Datos, datosUsuario, false);
        miembro.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int height = screenSize.height;
        int width = screenSize.width;
        miembro.setSize(width / 2, height / 2);
        miembro.setLocationRelativeTo(null);
        miembro.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BtnAgregarMiembroActionPerformed

    private void BtnAgregarTareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAgregarTareaActionPerformed
        FrmNuevaTarea nuevaTarea = new FrmNuevaTarea(this.Datos, this.datosUsuario);
        nuevaTarea.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int height = screenSize.height;
        int width = screenSize.width;
        // miembro.setSize(width/2, height/2);
        nuevaTarea.setLocationRelativeTo(null);
        nuevaTarea.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BtnAgregarTareaActionPerformed

    private void ListPorHacerValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_ListPorHacerValueChanged

    }//GEN-LAST:event_ListPorHacerValueChanged

    private void BtnPorHacer_To_EnProcesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPorHacer_To_EnProcesoActionPerformed

        System.out.println("Length: " + enProceso.get(0).size());

        int index = this.ListPorHacer.getSelectedIndex();
        if(index>-1){
            int tareaId = Integer.parseInt(this.porHacer.get(0).get(index));
            Tarea tarea = new Tarea();

            this.listEnProcesoModel.addElement(this.porHacer.get(1).get(this.ListPorHacer.getSelectedIndex()));
            this.listPorHacerModel.removeElement(listPorHacerModel.get(index));
            this.enProceso.get(0).add(porHacer.get(0).get(index));
            this.enProceso.get(1).add(porHacer.get(1).get(index));
            this.porHacer.get(0).remove(index);
            this.porHacer.get(1).remove(index);

            tarea.modificarEstado(tareaId, (int) datosEstado.get(0).get(1));
        }
        else{
            JOptionPane.showMessageDialog(null, "Debe seleccionar una tarea");
        }
    }//GEN-LAST:event_BtnPorHacer_To_EnProcesoActionPerformed

    private void BtnEnProceso_To_FinalizadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEnProceso_To_FinalizadoActionPerformed
        int index = this.ListEnProceso.getSelectedIndex();
        if(index > -1){
            int tareaId = Integer.parseInt(this.enProceso.get(0).get(index));
            Tarea tarea = new Tarea();

            this.listFinalizadoModel.addElement(this.enProceso.get(1).get(this.ListEnProceso.getSelectedIndex()));
            this.listEnProcesoModel.removeElement(listEnProcesoModel.get(index));
            this.finalizado.get(0).add(enProceso.get(0).get(index));
            this.finalizado.get(1).add(enProceso.get(1).get(index));
            this.enProceso.get(0).remove(index);
            this.enProceso.get(1).remove(index);

            tarea.modificarEstado(tareaId, (int) datosEstado.get(0).get(2));
        }
        else{
            JOptionPane.showMessageDialog(null, "Debe seleccionar una tarea");
        }
    }//GEN-LAST:event_BtnEnProceso_To_FinalizadoActionPerformed

    private void BtnEnProceso_To_PorHacerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEnProceso_To_PorHacerActionPerformed
        int index = this.ListEnProceso.getSelectedIndex();
        if(index > -1){
            int tareaId = Integer.parseInt(this.enProceso.get(0).get(index));
            Tarea tarea = new Tarea();

            this.listPorHacerModel.addElement(this.enProceso.get(1).get(this.ListEnProceso.getSelectedIndex()));
            this.listEnProcesoModel.removeElement(listEnProcesoModel.get(index));
            this.porHacer.get(0).add(enProceso.get(0).get(index));
            this.porHacer.get(1).add(enProceso.get(1).get(index));
            this.enProceso.get(0).remove(index);
            this.enProceso.get(1).remove(index);

            tarea.modificarEstado(tareaId, (int) datosEstado.get(0).get(0));
        }
        else{
            JOptionPane.showMessageDialog(null, "Debe seleccionar una tarea");
        }
    }//GEN-LAST:event_BtnEnProceso_To_PorHacerActionPerformed

    private void BtnFinalizado_To_EnProcesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnFinalizado_To_EnProcesoActionPerformed
        int index = this.ListFinalizado.getSelectedIndex();
        if(index > -1){
        int tareaId = Integer.parseInt(this.finalizado.get(0).get(index));
        Tarea tarea = new Tarea();

        this.listEnProcesoModel.addElement(this.finalizado.get(1).get(this.ListFinalizado.getSelectedIndex()));
        this.listFinalizadoModel.removeElement(listFinalizadoModel.get(index));
        this.enProceso.get(0).add(finalizado.get(0).get(index));
        this.enProceso.get(1).add(finalizado.get(1).get(index));
        this.finalizado.get(0).remove(index);
        this.finalizado.get(1).remove(index);

        tarea.modificarEstado(tareaId, (int) datosEstado.get(0).get(1));
        }
        else{
            JOptionPane.showMessageDialog(null, "Debe seleccionar una tarea");
        }
    }//GEN-LAST:event_BtnFinalizado_To_EnProcesoActionPerformed

    private void ListPorHacerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ListPorHacerMouseClicked

        Tarea tarea = new Tarea();
        int index = this.ListPorHacer.getSelectedIndex();
        int tareaId = 0;
        try {
            tareaId = Integer.parseInt(this.porHacer.get(0).get(index));
        } catch (IndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una tarea");
        }

        if (evt.getButton() == MouseEvent.BUTTON3 && this.owner) {
            try {
                FrmNuevaTarea nuevaTarea = new FrmNuevaTarea(this.Datos, this.datosUsuario, tareaId);
                nuevaTarea.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                int height = screenSize.height;
                int width = screenSize.width;
                // miembro.setSize(width/2, height/2);
                nuevaTarea.setLocationRelativeTo(null);
                nuevaTarea.setVisible(true);
                this.dispose();
            } catch (IndexOutOfBoundsException e) {
                JOptionPane.showMessageDialog(null, "Debe seleccionar una tarea");
            }
        } // Implementar rol.
        else if (evt.getButton() == MouseEvent.BUTTON3 && tarea.validarDetalleAsignado(this.datosUsuario[0], tareaId)) {
            try {
                FrmNuevaTarea nuevaTarea = new FrmNuevaTarea(this.Datos, this.datosUsuario, tareaId);
                nuevaTarea.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                int height = screenSize.height;
                int width = screenSize.width;
                // miembro.setSize(width/2, height/2);
                nuevaTarea.setLocationRelativeTo(null);
                nuevaTarea.setVisible(true);
                this.dispose();
            } catch (IndexOutOfBoundsException e) {
                JOptionPane.showMessageDialog(null, "No ha sido asignado a esta tarea");
            }
        } else if (evt.getButton() == MouseEvent.BUTTON3 && !tarea.validarDetalleAsignado(this.datosUsuario[0], tareaId)) {
            JOptionPane.showMessageDialog(null, "No ha sido asignado a esta tarea");
        }
    }//GEN-LAST:event_ListPorHacerMouseClicked

    private void BtnNewIssueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnNewIssueActionPerformed
        FrmNuevoIssue issue = new FrmNuevoIssue(this.Datos, this.datosUsuario);
        issue.setLocationRelativeTo(null);
        issue.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BtnNewIssueActionPerformed

    private void BtnAgregarComentarioAIssueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAgregarComentarioAIssueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnAgregarComentarioAIssueActionPerformed

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
            java.util.logging.Logger.getLogger(FrmDatosProyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmDatosProyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmDatosProyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmDatosProyecto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmDatosProyecto().setVisible(true);
            }
        });
    }

    // METODOS DE LA CLASE.
    public void llenarListaMiembros(int Id) {
        Proyecto proyecto = new Proyecto();
        var nombres = proyecto.listarMiembros(Id);
        listModel = new DefaultListModel();

        for (int i = 0; i < nombres.size(); i++) {
            listModel.addElement(nombres.get(i)); // LAST INTERACTION
        }
    }

    /**
     * *
     * Obtiene el propietario del proyecto en base a proyecto Id.
     *
     * @param Id
     * @param usuario
     */
    public void validarPropietario(int Id, String usuario) {
        Proyecto proyecto = new Proyecto();
        String propietario = proyecto.obtenerCreador(Id);

        if (!propietario.equalsIgnoreCase(usuario)) {
            this.BtnAgregarMiembro.setEnabled(false);
            this.BtnAgregarMiembro.setVisible(false);
        } else {
            this.owner = true;
        }
    }

    public void validarRol(String rol) {
        if (rol.equals("Invitado")) {
            this.mostrarListas(false);

            this.ocultarBotones();
        } else if (rol.equals("Editor")) {
            this.mostrarListas(true);

            this.BtnAgregarTarea.setVisible(false);
        } else if (rol.equals("Administrador") && !this.owner) {
            this.mostrarListas(true);
        }
    }

    public void llenarListas() {
        Tarea tarea = new Tarea();
        var datosTareas = tarea.listarTareasPorProyecto(proyectoId);

        List<String> porHacerIdTEMP = new ArrayList<>();
        List<String> porHacerDescripcionesTEMP = new ArrayList<>();

        List<String> enProcesoIdTEMP = new ArrayList<>();
        List<String> enProcesoDescripcionesTEMP = new ArrayList<>();

        List<String> finalizadoIdTEMP = new ArrayList<>();
        List<String> finalizadoDescripcionesTEMP = new ArrayList<>();

        for (int i = 0; i < datosTareas.size(); i++) {
            for (int j = 0; j < datosTareas.get(0).size(); j++) {
                // Agrega datos (Descripciones) a los JLists
                if (Integer.parseInt(datosTareas.get(2).get(j)) == (int) datosEstado.get(0).get(0)) {
                    if (i == 1) {
                        var elemento = datosTareas.get(1).get(j);
                        listPorHacerModel.addElement(elemento);
                        porHacerDescripcionesTEMP.add(elemento);
                    } else if (i == 0) {
                        var elemento = datosTareas.get(0).get(j);
                        porHacerIdTEMP.add(elemento);
                    }
                } else if (Integer.parseInt(datosTareas.get(2).get(j)) == (int) datosEstado.get(0).get(1)) {
                    if (i == 1) {
                        var elemento = datosTareas.get(1).get(j);
                        listEnProcesoModel.addElement(elemento);
                        enProcesoDescripcionesTEMP.add(elemento);
                    } else if (i == 0) {
                        var elemento = datosTareas.get(0).get(j);
                        enProcesoIdTEMP.add(elemento);
                    }
                } else if (Integer.parseInt(datosTareas.get(2).get(j)) == (int) datosEstado.get(0).get(2)) {
                    if (i == 1) {
                        var elemento = datosTareas.get(1).get(j);
                        listFinalizadoModel.addElement(datosTareas.get(1).get(j));
                        finalizadoDescripcionesTEMP.add(elemento);
                    } else if (i == 0) {
                        var elemento = datosTareas.get(0).get(j);
                        finalizadoIdTEMP.add(elemento);
                    }
                }
            }
        }

        this.porHacer.add(porHacerIdTEMP);
        this.porHacer.add(porHacerDescripcionesTEMP);

        this.enProceso.add(enProcesoIdTEMP);
        this.enProceso.add(enProcesoDescripcionesTEMP);

        this.finalizado.add(finalizadoIdTEMP);
        this.finalizado.add(finalizadoDescripcionesTEMP);
    }

    public void ocultarBotones() {
        this.BtnPorHacer_To_EnProceso.setVisible(false);
        this.BtnEnProceso_To_PorHacer.setVisible(false);
        this.BtnEnProceso_To_Finalizado.setVisible(false);
        this.BtnFinalizado_To_EnProceso.setVisible(false);

        this.BtnAgregarTarea.setVisible(false);
    }

    public void mostrarListas(boolean mostrar) {
        this.ListPorHacer.setEnabled(mostrar);
        this.ListEnProceso.setEnabled(mostrar);
        this.ListFinalizado.setEnabled(mostrar);
    }

    class FondoPanelDatosProyecto extends JPanel {

        private Image imagen;

        @Override
        public void paint(Graphics g) {
            try {

                imagen = new ImageIcon(getClass().getResource("/imagenes/code1.png")).getImage();
                g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);

                setOpaque(false);
                super.paint(g);

            } catch (Exception e) {
            }
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAgregarComentarioAIssue;
    private javax.swing.JButton BtnAgregarMiembro;
    private javax.swing.JButton BtnAgregarTarea;
    private javax.swing.JButton BtnEnProceso_To_Finalizado;
    private javax.swing.JButton BtnEnProceso_To_PorHacer;
    private javax.swing.JButton BtnFinalizado_To_EnProceso;
    private java.awt.Button BtnNewIssue;
    private javax.swing.JButton BtnPorHacer_To_EnProceso;
    private javax.swing.JLabel LbDescripcion;
    private javax.swing.JLabel LbEnProceso;
    private javax.swing.JLabel LbFinalizadas;
    private javax.swing.JLabel LbIssueTitulo;
    private javax.swing.JLabel LbMiembros;
    private javax.swing.JLabel LbPorHacer;
    private javax.swing.JLabel LbTitulo;
    private javax.swing.JList<String> ListEnProceso;
    private javax.swing.JList<String> ListFinalizado;
    private javax.swing.JList<String> ListIssues;
    private javax.swing.JList<String> ListMiembros;
    private javax.swing.JList<String> ListPorHacer;
    private javax.swing.JPanel PnComentariosIssue;
    private javax.swing.JPanel PnDetallesIssue;
    private javax.swing.JPanel PnIssues;
    private javax.swing.JPanel PnPanelTareasProyecto;
    private javax.swing.JPanel PnRescursos;
    private javax.swing.JScrollPane ScrollComentariosIssue;
    private javax.swing.JTabbedPane TabPanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    // End of variables declaration//GEN-END:variables
}
