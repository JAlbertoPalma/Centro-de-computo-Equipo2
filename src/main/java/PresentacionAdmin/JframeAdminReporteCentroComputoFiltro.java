/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package PresentacionAdmin;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author LABCISCO-PC059
 */
public class JframeAdminReporteCentroComputoFiltro extends javax.swing.JFrame {

    private String filtrosAux = "";
    String centroComputoAux = ""; //Auxiliar para guardar filtros.
    private List<String> CarrerasAux = new ArrayList<>(); //Auxiliar para guardar filtros.
    private List<String> CentrosComputoAux = new ArrayList<>(); //Auxiliar para guardar filtros.
    private String aux1;
    private Date fechaInicioAux;
    private Date fechaFinAux;

    /**
     * Creates new form JframeElegirSoftware
     */
    public JframeAdminReporteCentroComputoFiltro() {
        initComponents();
        this.setLocationRelativeTo(null);
        CarrerasAux = new ArrayList<>(this.jComboBoxCarreras.getItemCount());
        CentrosComputoAux = new ArrayList<>(this.jComboBoxCentroComputo.getItemCount());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelFondo = new javax.swing.JPanel();
        jLabelLogoItson = new javax.swing.JLabel();
        jButtonVolver = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabelTitulo = new javax.swing.JLabel();
        jLabelCentroComputo = new javax.swing.JLabel();
        jComboBoxCentroComputo = new javax.swing.JComboBox<>();
        jLabelFiltros1 = new javax.swing.JLabel();
        jLabelCarreras = new javax.swing.JLabel();
        jComboBoxCarreras = new javax.swing.JComboBox<>();
        jLabelHorario = new javax.swing.JLabel();
        jLabelFechaInicio = new javax.swing.JLabel();
        jLabelFechaFin = new javax.swing.JLabel();
        jButtonAceptar = new javax.swing.JButton();
        jTextFieldFechaInicio = new javax.swing.JTextField();
        jTextFieldFechaFin = new javax.swing.JTextField();
        jLabeFiltroSeleccionado1 = new javax.swing.JLabel();
        jLabeFiltroSeleccionado2 = new javax.swing.JLabel();
        jButtonLimpiar = new javax.swing.JButton();
        jButtonAñadirCentro = new javax.swing.JButton();
        jButtonAñadirCarrera = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(750, 450));

        jPanelFondo.setBackground(new java.awt.Color(153, 204, 255));

        jLabelLogoItson.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLogoItson.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/LogoITSON.png"))); // NOI18N

        jButtonVolver.setText("Volver");
        jButtonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVolverActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 750, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        jLabelTitulo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitulo.setText("Instituto Tecnologico de Sonora");

        jLabelCentroComputo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelCentroComputo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCentroComputo.setText("Centro de Computo");

        jComboBoxCentroComputo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Centro 1", "Centro 2", "Centro 3", "Centro 4" }));
        jComboBoxCentroComputo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxCentroComputoItemStateChanged(evt);
            }
        });
        jComboBoxCentroComputo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCentroComputoActionPerformed(evt);
            }
        });

        jLabelFiltros1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelFiltros1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFiltros1.setText("Filtros");

        jLabelCarreras.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelCarreras.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCarreras.setText("Carreras");

        jComboBoxCarreras.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "C 1", "C 2", "C 3", "C 4", " " }));
        jComboBoxCarreras.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBoxCarrerasItemStateChanged(evt);
            }
        });
        jComboBoxCarreras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCarrerasActionPerformed(evt);
            }
        });

        jLabelHorario.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelHorario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelHorario.setText("Horario");

        jLabelFechaInicio.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelFechaInicio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFechaInicio.setText("Fecha Inicio");

        jLabelFechaFin.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelFechaFin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFechaFin.setText("Fecha Fin");

        jButtonAceptar.setText("Aceptar");
        jButtonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAceptarActionPerformed(evt);
            }
        });

        jLabeFiltroSeleccionado1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabeFiltroSeleccionado1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabeFiltroSeleccionado2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabeFiltroSeleccionado2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButtonLimpiar.setText("Limpiar Filtros");
        jButtonLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimpiarActionPerformed(evt);
            }
        });

        jButtonAñadirCentro.setText("Añadir");
        jButtonAñadirCentro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAñadirCentroActionPerformed(evt);
            }
        });

        jButtonAñadirCarrera.setText("Añadir");
        jButtonAñadirCarrera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAñadirCarreraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelFondoLayout = new javax.swing.GroupLayout(jPanelFondo);
        jPanelFondo.setLayout(jPanelFondoLayout);
        jPanelFondoLayout.setHorizontalGroup(
            jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFondoLayout.createSequentialGroup()
                .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelLogoItson, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelFondoLayout.createSequentialGroup()
                        .addGap(210, 210, 210)
                        .addComponent(jLabelTitulo))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelFondoLayout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jButtonAñadirCentro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelFondoLayout.createSequentialGroup()
                                .addGap(197, 197, 197)
                                .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonVolver)
                                    .addComponent(jButtonAceptar)))
                            .addGroup(jPanelFondoLayout.createSequentialGroup()
                                .addComponent(jLabeFiltroSeleccionado1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonAñadirCarrera)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabeFiltroSeleccionado2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonLimpiar)
                                .addGap(24, 24, 24)
                                .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(9, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFondoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabelFiltros1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(266, 266, 266))
            .addGroup(jPanelFondoLayout.createSequentialGroup()
                .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelFondoLayout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(jLabelCentroComputo, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jLabelCarreras, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelFondoLayout.createSequentialGroup()
                        .addGap(159, 159, 159)
                        .addComponent(jComboBoxCentroComputo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(105, 105, 105)
                        .addComponent(jComboBoxCarreras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelHorario, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88))
        );
        jPanelFondoLayout.setVerticalGroup(
            jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFondoLayout.createSequentialGroup()
                .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelLogoItson, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelFondoLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelFondoLayout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelFiltros1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCarreras, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelHorario, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCentroComputo, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelFondoLayout.createSequentialGroup()
                        .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxCarreras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxCentroComputo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelFondoLayout.createSequentialGroup()
                                .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabeFiltroSeleccionado2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanelFondoLayout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(jButtonAñadirCarrera))
                                    .addGroup(jPanelFondoLayout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addComponent(jButtonAñadirCentro)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                                .addComponent(jButtonAceptar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonVolver))
                            .addGroup(jPanelFondoLayout.createSequentialGroup()
                                .addComponent(jLabeFiltroSeleccionado1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanelFondoLayout.createSequentialGroup()
                        .addComponent(jLabelFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonLimpiar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVolverActionPerformed
        JframeAdminMenu j = new JframeAdminMenu();
        j.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonVolverActionPerformed

    private void jComboBoxCentroComputoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCentroComputoActionPerformed

    }//GEN-LAST:event_jComboBoxCentroComputoActionPerformed

    private void jComboBoxCarrerasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCarrerasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxCarrerasActionPerformed

    private void jButtonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarActionPerformed

        if (this.centroComputoAux.equalsIgnoreCase("") || this.CentrosComputoAux.isEmpty()) {
            for (int i = 0; i < this.jComboBoxCentroComputo.getItemCount(); i++) {
                this.CentrosComputoAux.add(this.jComboBoxCentroComputo.getItemAt(i));
                this.centroComputoAux = this.CentrosComputoAux.toString();
            }
        }
        if (this.CarrerasAux.isEmpty()) {
            for (int i = 0; i < this.jComboBoxCarreras.getItemCount(); i++) {
                this.CarrerasAux.add(this.jComboBoxCarreras.getItemAt(i));
            }
        }
        try {
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            this.fechaInicioAux = formato.parse(this.jTextFieldFechaInicio.getText());
            this.fechaFinAux = formato.parse(this.jTextFieldFechaFin.getText());
            JframeAdminReporteCentroComputoConfirmacion j = new JframeAdminReporteCentroComputoConfirmacion(this.centroComputoAux, this.CarrerasAux, this.fechaInicioAux, this.fechaFinAux);
            j.setVisible(true);
            this.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Valores no validos en Fechas");
            List<String> vacio = new ArrayList<>(); //Auxiliar vacio.
            this.CarrerasAux = vacio; // Igualación para que el auxiliar de Carreras vuelva a estar vacio.
            this.CentrosComputoAux = vacio;
            CarrerasAux = new ArrayList<>(this.jComboBoxCarreras.getItemCount());
            CentrosComputoAux = new ArrayList<>(this.jComboBoxCentroComputo.getItemCount());
        }


    }//GEN-LAST:event_jButtonAceptarActionPerformed

    private void jComboBoxCentroComputoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxCentroComputoItemStateChanged

    }//GEN-LAST:event_jComboBoxCentroComputoItemStateChanged

    private void jComboBoxCarrerasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBoxCarrerasItemStateChanged

    }//GEN-LAST:event_jComboBoxCarrerasItemStateChanged

    private void jButtonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimpiarActionPerformed

        List<String> vacio = new ArrayList<>(); //Auxiliar vacio.
        CarrerasAux = vacio; // Igualación para que el auxiliar de Carreras vuelva a estar vacio.
        this.jLabeFiltroSeleccionado1.setText(" "); //Devuelve los label de los filtros a vacios.
        this.jLabeFiltroSeleccionado2.setText(" ");
    }//GEN-LAST:event_jButtonLimpiarActionPerformed

    private void jButtonAñadirCentroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAñadirCentroActionPerformed
        //Muestra el centro de Computo elegido.
        this.jLabeFiltroSeleccionado1.setText(this.jComboBoxCentroComputo.getItemAt(this.jComboBoxCentroComputo.getSelectedIndex()));
        this.centroComputoAux = this.jComboBoxCentroComputo.getItemAt(this.jComboBoxCentroComputo.getSelectedIndex());

    }//GEN-LAST:event_jButtonAñadirCentroActionPerformed

    private void jButtonAñadirCarreraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAñadirCarreraActionPerformed
        boolean aux2 = false; //Auxiliar para saber si el valor ya existe en la lista de carreras, false si no existe, true si si existe.
        for (int i = 0; i < CarrerasAux.size(); i++) {
            //If que comprueba si la carrera de la combobox ya existe en la lista o no.
            if (CarrerasAux.get(i).equalsIgnoreCase(this.jComboBoxCarreras.getItemAt(this.jComboBoxCarreras.getSelectedIndex()))) {
                aux2 = true;
            }
        }
        //Si el auxiliar utilizado es false, entonces el valor de la combobox no existe aun en la lista, por lo cual es seguro añadirlo al filtro.
        if (aux2 == false) {
            this.CarrerasAux.add(this.jComboBoxCarreras.getItemAt(this.jComboBoxCarreras.getSelectedIndex()));
            this.jLabeFiltroSeleccionado2.setText(this.CarrerasAux.toString());
        } else {
            JOptionPane.showMessageDialog(rootPane, "Carrera ya añadida al filtro.");
        }

    }//GEN-LAST:event_jButtonAñadirCarreraActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAceptar;
    private javax.swing.JButton jButtonAñadirCarrera;
    private javax.swing.JButton jButtonAñadirCentro;
    private javax.swing.JButton jButtonLimpiar;
    private javax.swing.JButton jButtonVolver;
    private javax.swing.JComboBox<String> jComboBoxCarreras;
    private javax.swing.JComboBox<String> jComboBoxCentroComputo;
    private javax.swing.JLabel jLabeFiltroSeleccionado1;
    private javax.swing.JLabel jLabeFiltroSeleccionado2;
    private javax.swing.JLabel jLabelCarreras;
    private javax.swing.JLabel jLabelCentroComputo;
    private javax.swing.JLabel jLabelFechaFin;
    private javax.swing.JLabel jLabelFechaInicio;
    private javax.swing.JLabel jLabelFiltros1;
    private javax.swing.JLabel jLabelHorario;
    private javax.swing.JLabel jLabelLogoItson;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelFondo;
    private javax.swing.JTextField jTextFieldFechaFin;
    private javax.swing.JTextField jTextFieldFechaInicio;
    // End of variables declaration//GEN-END:variables
}
