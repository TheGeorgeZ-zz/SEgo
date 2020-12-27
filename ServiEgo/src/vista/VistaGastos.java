/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.GastoJpaController;
import controlador.TipoGastoJpaController;
import controlador.exceptions.NonexistentEntityException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Gasto;
import modelo.TipoGasto;
import templates.vistaTemplate;

/**
 *
 * @author Familia
 */
public class VistaGastos extends javax.swing.JDialog {

    public GastoJpaController controladorGasto = new GastoJpaController(); 
    public TipoGastoJpaController controladorTipoGasto = new TipoGastoJpaController(); 
    public Gasto gastoSeleccionado;
    public List<TipoGasto> listaTipoGasto = new ArrayList<>();
    Icon iconoMostrar;
    public vistaTemplate vistaImg = new vistaTemplate();
        
    public VistaGastos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        actualizarComboBox();
        llenarTabla();
        this.setTitle("VENTANA GASTOS");
        this.setLocationRelativeTo(VistaGastos.this);//para que aparezca centrado
        this.setResizable(false);//para que no se modifique el tamaño del frame
        fecha_gasto.setDate(new Date());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaGastos = new javax.swing.JTable();
        fecha_gasto = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        btnCrear = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtObservaciones = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jComboBoxTipoGasto = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtValorGasto = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 51, 51));

        jLabel5.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 16)); // NOI18N
        jLabel5.setText("Fecha:");

        tablaGastos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablaGastosMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tablaGastos);

        fecha_gasto.setDateFormatString("yyyy-MM-dd");

        jLabel11.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 24)); // NOI18N
        jLabel11.setText("Gastos:");

        btnCrear.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 12)); // NOI18N
        btnCrear.setText("CREAR");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        btnActualizar.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 12)); // NOI18N
        btnActualizar.setText("ACTUALIZAR");
        btnActualizar.setEnabled(false);
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 12)); // NOI18N
        btnEliminar.setText("ELIMINAR");
        btnEliminar.setEnabled(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnLimpiar.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 12)); // NOI18N
        btnLimpiar.setText("LIMPIAR");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        txtObservaciones.setColumns(20);
        txtObservaciones.setRows(5);
        txtObservaciones.setText("Sin observaciones.");
        jScrollPane2.setViewportView(txtObservaciones);

        jLabel6.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 16)); // NOI18N
        jLabel6.setText("Observaciones:");

        jComboBoxTipoGasto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxTipoGastoActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 16)); // NOI18N
        jLabel7.setText("Tipo gasto:");

        jLabel12.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 16)); // NOI18N
        jLabel12.setText("Valor gasto:");

        txtValorGasto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtValorGastoKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jScrollPane2)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel12)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(fecha_gasto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtValorGasto)
                                            .addComponent(jComboBoxTipoGasto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(btnCrear)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnActualizar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEliminar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnLimpiar)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(10, 10, 10))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 739, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(fecha_gasto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txtValorGasto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxTipoGasto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnActualizar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnEliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablaGastosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaGastosMousePressed

        int fila = tablaGastos.getSelectedRow();
        int codigo = Integer.parseInt(tablaGastos.getValueAt(fila, 0).toString());
        gastoSeleccionado = controladorGasto.findGasto(codigo);
        if(gastoSeleccionado == null){
            JOptionPane.showMessageDialog(this, "El gasto no existe, por favor cierre la ventana y vuelva a abrirla.");
        }else{            
            fecha_gasto.setDate(gastoSeleccionado.getFechaGasto());
            txtValorGasto.setText(gastoSeleccionado.getValorGasto()+"");
            txtObservaciones.setText(gastoSeleccionado.getObservacionesGasto());
            jComboBoxTipoGasto.setSelectedItem(gastoSeleccionado.getCodigoTipoGasto().getNombreTipoGasto());
        }
        
        btnCrear.setEnabled(false);
        btnActualizar.setEnabled(true);
        btnEliminar.setEnabled(true);
        
    }//GEN-LAST:event_tablaGastosMousePressed

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        
        try {
            Gasto nuevoGasto = new Gasto();
            nuevoGasto.setFechaGasto(fecha_gasto.getDate());
            nuevoGasto.setValorGasto(Integer.parseInt(txtValorGasto.getText()));            
            //Si no hay observaciones
            String observa = txtObservaciones.getText();
            if("".equals(observa)){
                observa = "Sin observaciones.";
            }                
            nuevoGasto.setObservacionesGasto(observa);
            int c = jComboBoxTipoGasto.getSelectedIndex();
            //restamos 1 a lo que tenemos seleccionado ya que es un array y comienza desde 0
            //Y nosotros tenemos en la posición 0 el "Seleccione una Opción"
            nuevoGasto.setCodigoTipoGasto(listaTipoGasto.get(c-1));
            controladorGasto.create(nuevoGasto);
            limpiar();
            iconoMostrar = vistaImg.iconoExcepcion("success");
            JOptionPane.showMessageDialog(null, "El gasto ha sido creado con éxito", "MENSAJE DE INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE, iconoMostrar);            
            llenarTabla();
        } catch (Exception e) {
            Logger.getLogger(VistaGastos.class.getName()).log(Level.SEVERE, null, e);
        }
        
    }//GEN-LAST:event_btnCrearActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void jComboBoxTipoGastoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxTipoGastoActionPerformed
        
        try {
            String tipogasto = jComboBoxTipoGasto.getSelectedItem().toString();
            String nueva = "";
            if (tipogasto.equals("OTRA")) {
                TipoGasto nuevaCategoria = new TipoGasto();
                nueva = JOptionPane.showInputDialog("Ingrese nuevo tipo de gasto");
                TipoGasto tipoGastoExiste = controladorTipoGasto.consultarxNombre(nueva);
                if(tipoGastoExiste != null){
                    jComboBoxTipoGasto.setSelectedIndex(0);
                    throw new Exception("Ya hay un tipo de gasto con ese nombre");
                }
                nuevaCategoria.setNombreTipoGasto(nueva);
                controladorTipoGasto.create(nuevaCategoria);
                actualizarComboBox();
                jComboBoxTipoGasto.setSelectedItem(nueva);
            }
        } catch (Exception e) {
            iconoMostrar = vistaImg.iconoExcepcion("error");
            JOptionPane.showMessageDialog(null, e.getMessage(), "MENSAJE DE INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE, iconoMostrar);
        }
                
    }//GEN-LAST:event_jComboBoxTipoGastoActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        
        iconoMostrar = vistaImg.iconoExcepcion("pregunta");
        int quiere = JOptionPane.showConfirmDialog(null, "¿Está seguro?", "ELIGE UNA OPCIÓN", 0, HEIGHT, iconoMostrar);
        switch (quiere) {
            case 0:
                try {
                    controladorGasto.destroy(gastoSeleccionado.getCodigoGasto());
                    iconoMostrar = vistaImg.iconoExcepcion("success");
                    JOptionPane.showMessageDialog(null, "El gasto ha sido eliminado con éxito", "MENSAJE DE INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE, iconoMostrar);
                    limpiar();
                    llenarTabla();
                } catch (NonexistentEntityException ex) {
                    Logger.getLogger(VistaGastos.class.getName()).log(Level.SEVERE, null, ex);
                } break;
            case 1:
                //no
                break;
            default:
                break;
        }
        
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
              
        try {
            // TODO add your handling code here:
            gastoSeleccionado.setFechaGasto(fecha_gasto.getDate());
            gastoSeleccionado.setValorGasto(Integer.parseInt(txtValorGasto.getText()));
             //Si no hay observaciones
            String observa = txtObservaciones.getText();
            if("".equals(observa)){
                observa = "Sin observaciones.";
            }                
            gastoSeleccionado.setObservacionesGasto(observa);
            TipoGasto tipoGastoBuscado = controladorTipoGasto.consultarxNombre(jComboBoxTipoGasto.getSelectedItem()+"");
            gastoSeleccionado.setCodigoTipoGasto(tipoGastoBuscado);
            
            controladorGasto.edit(gastoSeleccionado);
            iconoMostrar = vistaImg.iconoExcepcion("success");
            JOptionPane.showMessageDialog(null, "El gasto ha sido actualizado con éxito", "MENSAJE DE INFORMACIÓN", JOptionPane.INFORMATION_MESSAGE, iconoMostrar);
            limpiar();
            llenarTabla();
        } catch (Exception ex) {
            Logger.getLogger(VistaGastos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void txtValorGastoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtValorGastoKeyTyped
        
        char c = evt.getKeyChar();

        if (c < '0' || c > '9') {
            evt.consume();//esto es para que solo pueda ingresar numeros
        }
                
    }//GEN-LAST:event_txtValorGastoKeyTyped

    public void llenarTabla(){
        List<Gasto> listaGasto = controladorGasto.findGastoEntities();
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Id");
        modelo.addColumn("Fecha gasto");
        modelo.addColumn("Valor gasto");
        modelo.addColumn("Observaciónes");
        modelo.addColumn("Tipo gasto");
        String[] datos = new String[5];
        for (Gasto p : listaGasto) {
            DateFormat fecha = new SimpleDateFormat("yyyy-MM-dd");
            String convertido = fecha.format(p.getFechaGasto());
            datos[0] = p.getCodigoGasto()+"";
            datos[1] = convertido;
            datos[2] = p.getValorGasto()+"";
            datos[3] = p.getObservacionesGasto();      
            datos[4] = p.getCodigoTipoGasto().getNombreTipoGasto();
            modelo.addRow(datos);
        }        
        tablaGastos.setModel(modelo);
    
    }
    
    private void limpiar(){
        fecha_gasto.setDate(new Date());
        txtValorGasto.setText("");
        txtObservaciones.setText("");
        jComboBoxTipoGasto.setSelectedIndex(0);
        btnCrear.setEnabled(true);
        btnActualizar.setEnabled(false);
        btnEliminar.setEnabled(false);
        
    }
    
    public void actualizarComboBox(){
        //llenar el combo box de las categorias registradas
        jComboBoxTipoGasto.removeAllItems();
        listaTipoGasto = controladorTipoGasto.findTipoGastoEntities();
        jComboBoxTipoGasto.addItem("Seleccione una opción");        
        for (TipoGasto c : listaTipoGasto) {
            jComboBoxTipoGasto.addItem(c.getNombreTipoGasto());
        }
        jComboBoxTipoGasto.addItem("OTRA");

    }
    
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
            java.util.logging.Logger.getLogger(VistaGastos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaGastos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaGastos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaGastos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VistaGastos dialog = new VistaGastos(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLimpiar;
    private com.toedter.calendar.JDateChooser fecha_gasto;
    private javax.swing.JComboBox jComboBoxTipoGasto;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaGastos;
    private javax.swing.JTextArea txtObservaciones;
    private javax.swing.JTextField txtValorGasto;
    // End of variables declaration//GEN-END:variables
}
