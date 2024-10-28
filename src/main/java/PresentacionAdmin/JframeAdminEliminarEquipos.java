package PresentacionAdmin;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import negocio.exception.NegocioException;
import negocio.interfaces.IComputadoraNegocio;
//import negocio.*;
import persistencia.*;
import persistencia.interfaces.IApartadoDAO;
import persistencia.interfaces.IBloqueoDAO;
import persistencia.interfaces.ICarreraDAO;
import persistencia.interfaces.IComputadoraDAO;
import persistencia.interfaces.IEstudianteDAO;
import persistencia.interfaces.ILaboratorioComputoDAO;
import persistencia.interfaces.IUnidadAcademicaDAO;

/**
 *
 * @author Alberto Palma
 */
public class JframeAdminEliminarEquipos extends javax.swing.JFrame {

    private int pagina = 1;
    private final int LIMITE = 5;
    private int i = 0;
    private int index = 0;

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("conexionBD");

    //Creamos el entity Manager
    EntityManager em = emf.createEntityManager();

    ICarreraDAO carreraDAO = new CarreraDAO(em);
    IEstudianteDAO estudianteDAO = new EstudianteDAO(em);
    IUnidadAcademicaDAO unidadAcademicaDAO = new UnidadAcademicaDAO(em);
    ILaboratorioComputoDAO laboratorioComputoDAO = new LaboratorioComputoDAO(em);
    IComputadoraDAO computadoraDAO = new ComputadoraDAO(em);
    IApartadoDAO apartadoDAO = new ApartadoDAO(em);
    IBloqueoDAO bloqueoDAO = new BloqueoDAO(em);
    EstudianteBloqueoDAO estudianteBloqueoDAO = new EstudianteBloqueoDAO(em);
    IComputadoraNegocio computadoraNegocioAux;

    /**
     * Creates new form frmCliente
     */
    public JframeAdminEliminarEquipos(IComputadoraNegocio computadoraNegocio) {
        initComponents();
        this.computadoraNegocioAux = computadoraNegocio;
        this.cargarMetodosIniciales();
    }

    private void cargarMetodosIniciales() {
        try {
            this.cargarConfiguracionInicialTablaClientes();
            this.cargarClientesEnTabla();
        } catch (NegocioException ex) {
            Logger.getLogger(JframeAdminEliminarEquipos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void cargarConfiguracionInicialTablaClientes() {
//        ActionListener onEditarClickListener = new ActionListener() {
//            final int columnaId = 0;
//
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                //Metodo para editar un cliente
//                editar();
//            }
//        };
//        int indiceColumnaEditar = 5;
//        TableColumnModel modeloColumnas = this.tblEquipos.getColumnModel();
//        modeloColumnas.getColumn(indiceColumnaEditar);
//                .setCellRenderer(new JButtonRenderer("Editar"));
//        modeloColumnas.getColumn(indiceColumnaEditar)
//                .setCellEditor(new JButtonCellEditor("Editar",
//                        onEditarClickListener));
//
//        ActionListener onEliminarClickListener = new ActionListener() {
//            final int columnaId = 0;
//
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                //Metodo para eliminar un cliente
//                eliminarBoton();
//            }
//        };
//        int indiceColumnaEliminar = 6;
//        modeloColumnas = this.tblEquipos.getColumnModel();
//        modeloColumnas.getColumn(indiceColumnaEliminar)
//                .setCellRenderer(new JButtonRenderer("Eliminar"));
//        modeloColumnas.getColumn(indiceColumnaEliminar)
//                .setCellEditor(new JButtonCellEditor("Eliminar",
//                        onEliminarClickListener));
    }

    private int getIdSeleccionadoTablaClientes() {
        int indiceFilaSeleccionada = this.tblEquipos.getSelectedRow();
        if (indiceFilaSeleccionada != -1) {
            DefaultTableModel modelo = (DefaultTableModel) this.tblEquipos.getModel();
            int indiceColumnaId = 0;
            int idSocioSeleccionado = (int) modelo.getValueAt(indiceFilaSeleccionada,
                    indiceColumnaId);
            return idSocioSeleccionado;
        } else {
            return 0;
        }
    }

//    private void registrarAlumno() throws NegocioException {
//        try {
//            // Sentencia SQL para insertar un nuevo cliente en la tabla 'clientes'
//            try ( // Establecer la conexión a la base de datos (reemplaza CADENA_CONEXION, USUARIO y CONTRASEÑA con tus valores)
//                    Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3307/participantes", "root", "rootroot18")) {
//                // Sentencia SQL para insertar un nuevo cliente en la tabla 'cliente'
//                String sentenciaSql = "INSERT INTO alumnos (nombres, apellidoPaterno, apellidoMaterno, estaEliminado) VALUES (?, ?, ?, ?);";
//                // Preparar la sentencia SQL, permitiendo obtener las claves generadas automáticamente
//                PreparedStatement preparedStatement = conexion.prepareStatement(sentenciaSql, Statement.RETURN_GENERATED_KEYS);
//                // Establecer los valores para los parámetros de la sentencia SQL
//                preparedStatement.setString(1, txtNombre.getText());
//                preparedStatement.setString(2, txtPaterno.getText());
//                preparedStatement.setString(3, txtMaterno.getText());
//                // Obtener el estado del CheckBox (activo o inactivo)
//                boolean Activo = cbEliminado.isSelected();
//                preparedStatement.setBoolean(4, false); // Siempre falso al registrar un nuevo cliente
//                
//                // Ejecutar la sentencia SQL de inserción
//                preparedStatement.executeUpdate();
//                
//                // Obtener las claves generadas automáticamente (por ejemplo, el ID del nuevo registro)
//                ResultSet resultado = preparedStatement.getGeneratedKeys();
//                while (resultado.next()) {
//                    // Imprimir el ID generado para el nuevo registro
//                    System.out.println("Cliente registrado con ID: " + resultado.getInt(1));
//                }
//                // Cerrar la conexión
//            }
//        } catch (SQLException ex) {
//            // Capturar y manejar cualquier excepción SQL que ocurra
//            System.out.println("Ocurrió un error: " + ex.getMessage());
//        }
//        cargarClientesEnTabla();
//    }
    private void editar() {
        //Metodo para regresar el alumno seleccionado
        int id = this.getIdSeleccionadoTablaClientes();
    }

    private void eliminarTabla(int seleccionado) {
        boolean aux = true;
        try {
            DefaultTableModel modelo = (DefaultTableModel) this.tblEquipos.getModel();
                    modelo.removeRow(this.tblEquipos.getSelectedRow());
                    this.computadoraNegocioAux.eliminarComputadora((long)this.tblEquipos.getSelectedRow());
                    modelo.fireTableDataChanged();


        } catch (NullPointerException n) {
            JOptionPane.showMessageDialog(rootPane, "Tabla vacia");
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "datos.", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void eliminarBoton() {
        int id = this.getIdSeleccionadoTablaClientes();
        eliminarTabla(id);
        this.i = 0;
        cargarMetodosIniciales();
    }

    private void llenarTablaClientes(List<IComputadoraDAO> computadoraLista) {
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tblEquipos.getModel();

        if (modeloTabla.getRowCount() > 0) {
            for (int i = modeloTabla.getRowCount() - 1; i > -1; i--) {
                modeloTabla.removeRow(i);
            }
        }
        
        if (computadoraLista != null) {
            computadoraLista.forEach(row -> {
                Object[] fila = new Object[5];
                fila[0] = row;
                fila[1] = row.getNombres();
                fila[2] = row.getApellidoPat();
                fila[3] = row.getApellidoMat();
                fila[4] = row.isEliminado();

                modeloTabla.addRow(fila);
            });
        }
    }

    private void cargarClientesEnTabla() throws NegocioException {
        try {
            List<ClienteDTO> clientes = this.clienteNegocio.buscarClientesTabla(index);
            this.llenarTablaClientes(clientes);
        } catch (NegocioException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Información", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPaneEliminarEquipos = new javax.swing.JScrollPane();
        tblEquipos = new javax.swing.JTable();
        btnAnterior = new javax.swing.JButton();
        btnSiguiente = new javax.swing.JButton();
        lblPagina = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        jLabelLogoItson = new javax.swing.JLabel();
        jLabelTitulo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CRUD_Clientes");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblEquipos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Contrasena", "Estatus", "DireccionIP", "NoMaquina", "Eliminar"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPaneEliminarEquipos.setViewportView(tblEquipos);

        getContentPane().add(jScrollPaneEliminarEquipos, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 610, 300));

        btnAnterior.setText("Anterior");
        btnAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorActionPerformed(evt);
            }
        });
        getContentPane().add(btnAnterior, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 390, 80, 30));

        btnSiguiente.setText("Siguiente");
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });
        getContentPane().add(btnSiguiente, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 390, 80, 30));

        lblPagina.setText("Página: 1");
        getContentPane().add(lblPagina, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 390, -1, -1));

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 410, -1, -1));

        jLabelLogoItson.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLogoItson.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/LogoITSON.png"))); // NOI18N
        getContentPane().add(jLabelLogoItson, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabelTitulo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabelTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitulo.setText("Instituto Tecnologico de Sonora");
        getContentPane().add(jLabelTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, -1, -1));

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

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        // TODO add your handling code here:
        List<ClienteDTO> clientes = null;
        try {
            clientes = clienteNegocio.buscarClientesTabla(index);
        } catch (NegocioException ex) {
            Logger.getLogger(JframeAdminEliminarEquipos.class.getName()).log(Level.SEVERE, null, ex);
        }
//        int totalPaginas = (int) Math.ceil((double) clientes.size() / LIMITE);
        if (!clientes.isEmpty()) {
            pagina++;
            index = index + 5;
            try {
                cargarClientesEnTabla();
            } catch (NegocioException ex) {
                Logger.getLogger(JframeAdminEliminarEquipos.class.getName()).log(Level.SEVERE, null, ex);
            }
            lblPagina.setText("Página " + pagina); // Actualiza el texto del JLabel
        }
    }//GEN-LAST:event_btnSiguienteActionPerformed

    private void btnAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorActionPerformed
//        // TODO add your handling code here:
//        if (pagina > 1) {
//            pagina--;
//            index = index-5;
//            lblPagina.setText("Página " + pagina);
//            try {
//                cargarClientesEnTabla();
//            } catch (NegocioException ex) {
//                Logger.getLogger(JframeAdminEliminarEquipos.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
    }//GEN-LAST:event_btnAnteriorActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
//        this.tblEquipos.get
    }//GEN-LAST:event_btnEliminarActionPerformed

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
            java.util.logging.Logger.getLogger(JframeAdminEliminarEquipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JframeAdminEliminarEquipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JframeAdminEliminarEquipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JframeAdminEliminarEquipos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
//                // Crea una instancia de ConexionBD (o la implementación real que estés utilizando)
//                IConexionBD conexionBD = new ConexionBD();
//                // Crea una instancia de AlumnoDAO pasando la conexión como argumento
//                IClienteDAO clienteDAO = (IClienteDAO) new ClienteDAO(conexionBD);
//                // Crea una instancia de AlumnoNegocio pasando el DAO como argumento
//                IClienteNegocio clienteNegocio = new ClienteNegocio(clienteDAO);
//                new JframeAdminEliminarEquipos(clienteNegocio).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JLabel jLabelLogoItson;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPaneEliminarEquipos;
    private javax.swing.JLabel lblPagina;
    private javax.swing.JTable tblEquipos;
    // End of variables declaration//GEN-END:variables
}
