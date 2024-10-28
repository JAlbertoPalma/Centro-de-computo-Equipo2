/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package PresentacionCliente;

import PresentacionAdmin.*;
import javax.persistence.EntityManager;
import javax.swing.JOptionPane;
import negocio.EstudianteNegocio;
import negocio.exception.NegocioException;
import persistencia.EstudianteDAO;
import persistencia.interfaces.IEstudianteDAO;


/**
 *
 * @author LABCISCO-PC059
 */
public class JframePantallaBloqueo extends javax.swing.JFrame {

    private EntityManager ema;
    IEstudianteDAO estudianteDAO = new EstudianteDAO(ema);

    /**
     * Creates new form JframeElegirSoftware
     */
    public JframePantallaBloqueo(EntityManager em) {
        initComponents();
        this.setLocationRelativeTo(null);
        ema = em;
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
        jLabelNoEquipo = new javax.swing.JLabel();
        jLabelNombre = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabelNombre1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(700, 420));

        jPanelFondo.setBackground(new java.awt.Color(153, 204, 255));
        jPanelFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelLogoItson.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanelFondo.add(jLabelLogoItson, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 177, 100));

        jButtonVolver.setText("Volver");
        jButtonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVolverActionPerformed(evt);
            }
        });
        jPanelFondo.add(jButtonVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 260, 100, -1));

        jLabelNoEquipo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelNoEquipo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNoEquipo.setText("XX");
        jPanelFondo.add(jLabelNoEquipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 110, 184, -1));

        jLabelNombre.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNombre.setText("Cisco");
        jPanelFondo.add(jLabelNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 350, 184, -1));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/cisco.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanelFondo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 420));

        jLabelNombre1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelNombre1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelNombre1.setText("Equipo Disponible:");
        jPanelFondo.add(jLabelNombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 220, 184, -1));

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
        JframeMenuSoftware j = new JframeMenuSoftware();
        j.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonVolverActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelLogoItson;
    private javax.swing.JLabel jLabelNoEquipo;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelNombre1;
    private javax.swing.JPanel jPanelFondo;
    // End of variables declaration//GEN-END:variables
}