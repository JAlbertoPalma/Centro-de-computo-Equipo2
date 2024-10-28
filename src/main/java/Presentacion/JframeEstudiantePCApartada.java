/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Presentacion;

import javax.swing.JOptionPane;

/**
 *
 * @author LABCISCO-PC059
 */
public class JframeEstudiantePCApartada extends javax.swing.JFrame {
    private int horasAux; //Auxiliar de Horas.
    private int PCAux;    //Auxiliar de PC.
    /**
     * Creates new form JframeElegirSoftware
     * El contructo pide el numero de PC Y las horas del apartado.
     */
    public JframeEstudiantePCApartada(int PC, int horas) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.horasAux=horas;
        this.PCAux=PC;
        this.jLabelHorasIntroducidas.setText(String.valueOf(horasAux));
        this.jLabelPCElegida.setText(String.valueOf(PCAux));
        
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
        jLabelID = new javax.swing.JLabel();
        jButtonIngresar = new javax.swing.JButton();
        jButtonVolver = new javax.swing.JButton();
        jLabelPCElegida = new javax.swing.JLabel();
        jLabelPC = new javax.swing.JLabel();
        jLabelHorasIntroducidas = new javax.swing.JLabel();
        jLabelHoras = new javax.swing.JLabel();
        jLabelEstudiante = new javax.swing.JLabel();
        jLabelEstudianteE = new javax.swing.JLabel();
        jLabelCarrera = new javax.swing.JLabel();
        jLabelCarreraE = new javax.swing.JLabel();
        jLabelCentroComputo = new javax.swing.JLabel();
        jLabelCentroComputoE = new javax.swing.JLabel();
        jLabelFecha = new javax.swing.JLabel();
        jLabelFechaE = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(750, 400));

        jPanelFondo.setBackground(new java.awt.Color(153, 204, 255));

        jLabelTitulo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitulo.setText("Instituto Tecnologico de Sonora");

        jLabelLogoItson.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLogoItson.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/LogoITSON.png"))); // NOI18N

        jLabelID.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelID.setText("Datos de Apartado");

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

        jLabelPCElegida.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelPCElegida.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPCElegida.setText("PC");
        jLabelPCElegida.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelPC.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelPC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelPC.setText("Equipo Apartado");

        jLabelHorasIntroducidas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelHorasIntroducidas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelHorasIntroducidas.setText("Horas");
        jLabelHorasIntroducidas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelHoras.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelHoras.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelHoras.setText("Tiempo de Apartado");

        jLabelEstudiante.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelEstudiante.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelEstudiante.setText("Estudiante");

        jLabelEstudianteE.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelEstudianteE.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelEstudianteE.setText("Estudiante");
        jLabelEstudianteE.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelCarrera.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelCarrera.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCarrera.setText("Carrera");

        jLabelCarreraE.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelCarreraE.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCarreraE.setText("Carrera");
        jLabelCarreraE.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelCentroComputo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelCentroComputo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCentroComputo.setText("Centro de Computo");

        jLabelCentroComputoE.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelCentroComputoE.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelCentroComputoE.setText("Centro");
        jLabelCentroComputoE.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelFecha.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelFecha.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFecha.setText("Fecha");

        jLabelFechaE.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelFechaE.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFechaE.setText("Fecha");
        jLabelFechaE.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 750, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanelFondoLayout = new javax.swing.GroupLayout(jPanelFondo);
        jPanelFondo.setLayout(jPanelFondoLayout);
        jPanelFondoLayout.setHorizontalGroup(
            jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFondoLayout.createSequentialGroup()
                .addComponent(jLabelLogoItson, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(jLabelTitulo))
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanelFondoLayout.createSequentialGroup()
                .addGap(300, 300, 300)
                .addComponent(jLabelID, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanelFondoLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jLabelPC, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jLabelEstudiante, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jLabelCentroComputo, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanelFondoLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jLabelPCElegida, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jLabelEstudianteE, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jLabelCentroComputoE, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanelFondoLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jLabelHoras, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jLabelCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jLabelFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanelFondoLayout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jLabelHorasIntroducidas, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jLabelCarreraE, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addComponent(jLabelFechaE, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(jLabelLogoItson, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelFondoLayout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addComponent(jLabelID)
                .addGap(15, 15, 15)
                .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelPC)
                    .addComponent(jLabelEstudiante)
                    .addComponent(jLabelCentroComputo))
                .addGap(5, 5, 5)
                .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelPCElegida, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelEstudianteE, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCentroComputoE, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelHoras)
                    .addComponent(jLabelCarrera)
                    .addComponent(jLabelFecha))
                .addGap(5, 5, 5)
                .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelHorasIntroducidas, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCarreraE, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelFechaE, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        JframeEstudianteElegirPC j = new JframeEstudianteElegirPC();
        j.setVisible(true);
    }//GEN-LAST:event_jButtonVolverActionPerformed

    private void jButtonIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIngresarActionPerformed
       JOptionPane.showMessageDialog(rootPane, "PC Reservada.");
       JframeEstudianteIngreso j = new JframeEstudianteIngreso();
       j.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_jButtonIngresarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonIngresar;
    private javax.swing.JButton jButtonVolver;
    private javax.swing.JLabel jLabelCarrera;
    private javax.swing.JLabel jLabelCarreraE;
    private javax.swing.JLabel jLabelCentroComputo;
    private javax.swing.JLabel jLabelCentroComputoE;
    private javax.swing.JLabel jLabelEstudiante;
    private javax.swing.JLabel jLabelEstudianteE;
    private javax.swing.JLabel jLabelFecha;
    private javax.swing.JLabel jLabelFechaE;
    private javax.swing.JLabel jLabelHoras;
    private javax.swing.JLabel jLabelHorasIntroducidas;
    private javax.swing.JLabel jLabelID;
    private javax.swing.JLabel jLabelLogoItson;
    private javax.swing.JLabel jLabelPC;
    private javax.swing.JLabel jLabelPCElegida;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelFondo;
    // End of variables declaration//GEN-END:variables
}