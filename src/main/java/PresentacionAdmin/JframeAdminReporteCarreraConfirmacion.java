/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package PresentacionAdmin;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;

/**
 *
 * @author LABCISCO-PC059
 */
public class JframeAdminReporteCarreraConfirmacion extends javax.swing.JFrame {
    private EntityManager ema;
    private String filtrosAux = "";
    List<String> CarrerasAux = new ArrayList<>(); //Auxiliar para guardar filtros.
    private String aux1;
    private Date fechaInicioAux;
    private Date fechaFinAux;

    /**
     * Creates new form JframeElegirSoftware El contructo pide el numero de PC Y
     * las horas del apartado.
     */
    public JframeAdminReporteCarreraConfirmacion(List<String> Carreras,Date fechaInicio,Date fechaFin,EntityManager em) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.CarrerasAux = Carreras;
        this.fechaInicioAux = fechaInicio;
        this.fechaFinAux = fechaFin;
        this.jLabelCarreraE.setText(CarrerasAux.toString());
        this.jLabelFechaInicioE.setText(this.fechaInicioAux.toString());
        this.jLabelFechaFinE.setText(this.fechaFinAux.toString());
        this.ema=em;
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
        jLabelTitulo = new javax.swing.JLabel();
        jLabelLogoItson = new javax.swing.JLabel();
        jLabelDatosReporte = new javax.swing.JLabel();
        jButtonIngresar = new javax.swing.JButton();
        jButtonVolver = new javax.swing.JButton();
        jLabelCentroElegido = new javax.swing.JLabel();
        jLabelCentroComputo = new javax.swing.JLabel();
        jLabelCarrera = new javax.swing.JLabel();
        jLabelCarreraE = new javax.swing.JLabel();
        jLabelFechaFin = new javax.swing.JLabel();
        jLabelFechaFinE = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabelFechaInicio = new javax.swing.JLabel();
        jLabelFechaInicioE = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanelFondo.setBackground(new java.awt.Color(153, 204, 255));

        jLabelTitulo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitulo.setText("Instituto Tecnologico de Sonora");

        jLabelLogoItson.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLogoItson.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/LogoITSON.png"))); // NOI18N

        jLabelDatosReporte.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelDatosReporte.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDatosReporte.setText("Datos de Reporte");

        jButtonIngresar.setText("Aceptar");
        jButtonIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonIngresarActionPerformed(evt);
            }
        });

        jButtonVolver.setText("Volver");
        jButtonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVolverActionPerformed(evt);
            }
        });

        jLabelCentroElegido.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelCentroElegido.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCentroElegido.setText("Centro");
        jLabelCentroElegido.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelCentroComputo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelCentroComputo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCentroComputo.setText("Centro de Computo");

        jLabelCarrera.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelCarrera.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCarrera.setText("Carreras");

        jLabelCarreraE.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelCarreraE.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCarreraE.setText("Carrera");
        jLabelCarreraE.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelFechaFin.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelFechaFin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFechaFin.setText("Fecha Fin");

        jLabelFechaFinE.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelFechaFinE.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFechaFinE.setText("Fecha Fin");
        jLabelFechaFinE.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabelFechaInicio.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelFechaInicio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFechaInicio.setText("Fecha Inicio");

        jLabelFechaInicioE.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelFechaInicioE.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFechaInicioE.setText("Fecha Inicio");
        jLabelFechaInicioE.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 750, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanelFondoLayout = new javax.swing.GroupLayout(jPanelFondo);
        jPanelFondo.setLayout(jPanelFondoLayout);
        jPanelFondoLayout.setHorizontalGroup(
            jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFondoLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(300, 300, 300)
                .addComponent(jLabelDatosReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanelFondoLayout.createSequentialGroup()
                .addGap(240, 240, 240)
                .addComponent(jLabelTitulo))
            .addComponent(jLabelLogoItson, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanelFondoLayout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(jLabelCentroComputo, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabelFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanelFondoLayout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(jLabelCentroElegido, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabelFechaInicioE, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanelFondoLayout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(jLabelCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabelFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanelFondoLayout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(jLabelCarreraE, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabelFechaFinE, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanelFondoLayout.createSequentialGroup()
                .addGap(340, 340, 340)
                .addComponent(jButtonIngresar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanelFondoLayout.createSequentialGroup()
                .addGap(340, 340, 340)
                .addComponent(jButtonVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanelFondoLayout.setVerticalGroup(
            jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFondoLayout.createSequentialGroup()
                .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelFondoLayout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelFondoLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabelDatosReporte))
                    .addComponent(jLabelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelLogoItson, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelFondoLayout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelCentroComputo)
                    .addComponent(jLabelFechaInicio))
                .addGap(5, 5, 5)
                .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelCentroElegido, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelFechaInicioE, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelCarrera)
                    .addComponent(jLabelFechaFin))
                .addGap(5, 5, 5)
                .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelCarreraE, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelFechaFinE, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addComponent(jButtonIngresar)
                .addGap(7, 7, 7)
                .addComponent(jButtonVolver))
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
        JframeAdminReporteCarreraFiltro j = new JframeAdminReporteCarreraFiltro(ema);
        j.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonVolverActionPerformed

    private void jButtonIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIngresarActionPerformed
        JOptionPane.showMessageDialog(rootPane, "Reporte generado");
        JframeAdminMenu j = new JframeAdminMenu(ema);
        j.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonIngresarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonIngresar;
    private javax.swing.JButton jButtonVolver;
    private javax.swing.JLabel jLabelCarrera;
    private javax.swing.JLabel jLabelCarreraE;
    private javax.swing.JLabel jLabelCentroComputo;
    private javax.swing.JLabel jLabelCentroElegido;
    private javax.swing.JLabel jLabelDatosReporte;
    private javax.swing.JLabel jLabelFechaFin;
    private javax.swing.JLabel jLabelFechaFinE;
    private javax.swing.JLabel jLabelFechaInicio;
    private javax.swing.JLabel jLabelFechaInicioE;
    private javax.swing.JLabel jLabelLogoItson;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelFondo;
    // End of variables declaration//GEN-END:variables
}
