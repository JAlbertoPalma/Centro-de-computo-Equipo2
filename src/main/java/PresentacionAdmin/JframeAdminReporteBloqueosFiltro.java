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
public class JframeAdminReporteBloqueosFiltro extends javax.swing.JFrame {
    private Date fechaInicioAux;
    private Date fechaFinAux;

    /**
     * Creates new form JframeElegirSoftware
     */
    public JframeAdminReporteBloqueosFiltro() {
        initComponents();
        this.setLocationRelativeTo(null);
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
        jLabelFiltros1 = new javax.swing.JLabel();
        jLabelHorario = new javax.swing.JLabel();
        jLabelFechaInicio = new javax.swing.JLabel();
        jLabelFechaFin = new javax.swing.JLabel();
        jButtonAceptar = new javax.swing.JButton();
        jTextFieldFechaInicio = new javax.swing.JTextField();
        jTextFieldFechaFin = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(700, 450));

        jPanelFondo.setBackground(new java.awt.Color(153, 204, 255));
        jPanelFondo.setPreferredSize(new java.awt.Dimension(750, 450));

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

        jLabelFiltros1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelFiltros1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFiltros1.setText("Filtros");

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
                        .addGap(312, 312, 312)
                        .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelHorario, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelFondoLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextFieldFechaInicio, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                                    .addComponent(jLabelFechaFin, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                                    .addComponent(jTextFieldFechaFin, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                                    .addComponent(jLabelFechaInicio, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                                    .addComponent(jButtonAceptar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButtonVolver, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(jPanelFondoLayout.createSequentialGroup()
                        .addGap(294, 294, 294)
                        .addComponent(jLabelFiltros1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(9, Short.MAX_VALUE))
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
                .addComponent(jLabelHorario, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jButtonAceptar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonVolver)
                .addGap(0, 592, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, 759, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 937, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVolverActionPerformed
        JframeAdminMenu j = new JframeAdminMenu();
        j.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonVolverActionPerformed

    private void jButtonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAceptarActionPerformed

        try {
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            this.fechaInicioAux = formato.parse(this.jTextFieldFechaInicio.getText());
            this.fechaFinAux = formato.parse(this.jTextFieldFechaFin.getText());
            JframeAdminReporteBloqueosConfirmacion j = new JframeAdminReporteBloqueosConfirmacion(this.fechaInicioAux, this.fechaFinAux);
            j.setVisible(true);
            this.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Valores no validos en Fechas");
        }


    }//GEN-LAST:event_jButtonAceptarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAceptar;
    private javax.swing.JButton jButtonVolver;
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
