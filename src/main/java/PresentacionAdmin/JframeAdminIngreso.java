/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package PresentacionAdmin;

import javax.persistence.EntityManager;
import javax.swing.JOptionPane;
import negocio.EstudianteNegocio;
import negocio.exception.NegocioException;
import persistencia.ApartadoDAO;
import persistencia.BloqueoDAO;
import persistencia.CarreraDAO;
import persistencia.ComputadoraDAO;
import persistencia.EstudianteBloqueoDAO;
import persistencia.EstudianteDAO;
import persistencia.LaboratorioComputoDAO;
import persistencia.PersistenciaException;
import persistencia.UnidadAcademicaDAO;
import persistencia.interfaces.IApartadoDAO;
import persistencia.interfaces.IBloqueoDAO;
import persistencia.interfaces.ICarreraDAO;
import persistencia.interfaces.IComputadoraDAO;
import persistencia.interfaces.IEstudianteDAO;
import persistencia.interfaces.ILaboratorioComputoDAO;
import persistencia.interfaces.IUnidadAcademicaDAO;

/**
 *
 * @author LABCISCO-PC059
 */
public class JframeAdminIngreso extends javax.swing.JFrame {

    private EntityManager ema;
    IEstudianteDAO estudianteDAO = new EstudianteDAO(ema);

    /**
     * Creates new form JframeElegirSoftware
     */
    public JframeAdminIngreso(EntityManager em) {
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
        jLabelTitulo = new javax.swing.JLabel();
        jLabelLogoItson = new javax.swing.JLabel();
        jLabelID = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        jButtonIngresar = new javax.swing.JButton();
        jButtonVolver = new javax.swing.JButton();
        jLabelContraseña = new javax.swing.JLabel();
        jPasswordFieldContraseña = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanelFondo.setBackground(new java.awt.Color(153, 204, 255));

        jLabelTitulo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitulo.setText("Instituto Tecnologico de Sonora");

        jLabelLogoItson.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabelID.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelID.setText("Nombre Completo");

        jTextFieldNombre.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jButtonIngresar.setText("Ingresar");
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

        jLabelContraseña.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelContraseña.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelContraseña.setText("Contraseña");

        jPasswordFieldContraseña.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        javax.swing.GroupLayout jPanelFondoLayout = new javax.swing.GroupLayout(jPanelFondo);
        jPanelFondo.setLayout(jPanelFondoLayout);
        jPanelFondoLayout.setHorizontalGroup(
            jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFondoLayout.createSequentialGroup()
                .addComponent(jLabelLogoItson, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelFondoLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jPasswordFieldContraseña)
                                .addComponent(jTextFieldNombre, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabelID, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelContraseña, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFondoLayout.createSequentialGroup()
                                .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jButtonVolver, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                                    .addComponent(jButtonIngresar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(48, 48, 48))))
                    .addGroup(jPanelFondoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelTitulo)))
                .addContainerGap(226, Short.MAX_VALUE))
        );
        jPanelFondoLayout.setVerticalGroup(
            jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFondoLayout.createSequentialGroup()
                .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelLogoItson, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelFondoLayout.createSequentialGroup()
                        .addComponent(jLabelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelID)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelContraseña)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPasswordFieldContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonIngresar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonVolver)
                .addContainerGap(320, Short.MAX_VALUE))
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
        JframeMenuSoftware j = new JframeMenuSoftware();
        j.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonVolverActionPerformed

    private void jButtonIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonIngresarActionPerformed
        boolean aux1 = false;
        boolean aux2 = false;
        EstudianteNegocio n = new EstudianteNegocio(estudianteDAO);

        try {
            for (long i = 0; i < n.ObtenerListaEstudiantes().size(); i++) {
                if (this.jTextFieldNombre.getText().equalsIgnoreCase(n.obtenerEstudiante(i).getNombres())) {

                    aux1 = true;
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Usuario Inexistente");
                    aux1 = false;
                }
                for (long j = 0; j < n.ObtenerListaEstudiantes().size(); j++) {
                    if (this.jTextFieldNombre.getText().equalsIgnoreCase(n.obtenerEstudiante(j).getNombres())) {
                        aux2 = true;
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Contraseña Incorrecta");
                        aux2 = false;
                    }
                }
                if (aux1 == true && aux2 == true) {
                    JframeAdminMenu j = new JframeAdminMenu(ema);
                    j.setVisible(true);
                    this.dispose();
                }

            }
        } catch (NegocioException p) {

        }


    }//GEN-LAST:event_jButtonIngresarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonIngresar;
    private javax.swing.JButton jButtonVolver;
    private javax.swing.JLabel jLabelContraseña;
    private javax.swing.JLabel jLabelID;
    private javax.swing.JLabel jLabelLogoItson;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanelFondo;
    private javax.swing.JPasswordField jPasswordFieldContraseña;
    private javax.swing.JTextField jTextFieldNombre;
    // End of variables declaration//GEN-END:variables
}
