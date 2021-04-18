
package views;

import controllers.ControllerAgProd;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.ModelConexion;
import views.ViewCotizaciones;

/**
 *
 * @author Carina
 */
public class AgProd extends javax.swing.JFrame {

  DefaultTableModel m;
  
  ModelConexion productoConexion = new ModelConexion();
  ControllerAgProd controlle_productos;
  ViewCotizaciones cotizacion = new ViewCotizaciones();
  
  
  static double total;
  double sub_total;
  double igv;
    
    public AgProd() {
        initComponents();
        this.setLocationRelativeTo(null); 
        total = 0;
        sub_total = 0.0;
        igv = 0.0;
                

    }

    
 
    
  

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpProductosTitulo3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jpBordeTabla1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTAgProd = new javax.swing.JTable();
        jLBuscar = new javax.swing.JLabel();
        jTFBuscar = new javax.swing.JTextField();
        jBAgregar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTFSubtotal = new javax.swing.JTextField();
        jBGuardar = new javax.swing.JButton();
        jTFCantidad = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jBBorrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFocusCycleRoot(false);

        jpProductosTitulo3.setBackground(new java.awt.Color(0, 153, 204));
        jpProductosTitulo3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jpProductosTitulo3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jpProductosTitulo3.setPreferredSize(new java.awt.Dimension(425, 60));

        jLabel7.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Agregar Producto");

        javax.swing.GroupLayout jpProductosTitulo3Layout = new javax.swing.GroupLayout(jpProductosTitulo3);
        jpProductosTitulo3.setLayout(jpProductosTitulo3Layout);
        jpProductosTitulo3Layout.setHorizontalGroup(
            jpProductosTitulo3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpProductosTitulo3Layout.createSequentialGroup()
                .addGap(321, 321, 321)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpProductosTitulo3Layout.setVerticalGroup(
            jpProductosTitulo3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
        );

        jpBordeTabla1.setBackground(new java.awt.Color(0, 153, 204));
        jpBordeTabla1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 13), new java.awt.Color(255, 255, 255))); // NOI18N

        jTAgProd.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(jTAgProd);

        jLBuscar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLBuscar.setForeground(new java.awt.Color(255, 255, 255));
        jLBuscar.setText("Buscar:");

        jBAgregar.setText("Agregar");
        jBAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAgregarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("SUBTOTAL:");

        jTFSubtotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jBGuardar.setText("Guardar");
        jBGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBGuardarActionPerformed(evt);
            }
        });

        jTFCantidad.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Cantidad:");

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nombre", "Marca", "Precio", "Cantidad"
            }
        ));
        jScrollPane1.setViewportView(jTable2);

        jBBorrar.setText("Borrar");
        jBBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBorrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpBordeTabla1Layout = new javax.swing.GroupLayout(jpBordeTabla1);
        jpBordeTabla1.setLayout(jpBordeTabla1Layout);
        jpBordeTabla1Layout.setHorizontalGroup(
            jpBordeTabla1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBordeTabla1Layout.createSequentialGroup()
                .addGroup(jpBordeTabla1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpBordeTabla1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLBuscar)
                        .addGap(70, 70, 70)
                        .addComponent(jTFBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpBordeTabla1Layout.createSequentialGroup()
                        .addGroup(jpBordeTabla1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jpBordeTabla1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpBordeTabla1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(jTFCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jBAgregar)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpBordeTabla1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jBBorrar)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 443, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpBordeTabla1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jpBordeTabla1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jTFSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jpBordeTabla1Layout.createSequentialGroup()
                                    .addComponent(jBGuardar)
                                    .addGap(2, 2, 2))))))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jpBordeTabla1Layout.setVerticalGroup(
            jpBordeTabla1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBordeTabla1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpBordeTabla1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLBuscar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpBordeTabla1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpBordeTabla1Layout.createSequentialGroup()
                        .addGroup(jpBordeTabla1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addGroup(jpBordeTabla1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jpBordeTabla1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jBAgregar)
                                .addComponent(jBBorrar))
                            .addGroup(jpBordeTabla1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(jTFCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(16, 16, 16))
                    .addGroup(jpBordeTabla1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jTFSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jBGuardar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jpBordeTabla1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpProductosTitulo3, javax.swing.GroupLayout.DEFAULT_SIZE, 866, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpProductosTitulo3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jpBordeTabla1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAgregarActionPerformed
            int fsel = jTAgProd.getSelectedRow();
            try {
                String codigo,nombre,marca,precio,cantidad,importe;
                double calcula = 0.0, x = 0.0, igvs = 0.0;
                //int canti=0;
                
                if(fsel==-1){
                    JOptionPane.showMessageDialog(null, "Debe seleccionar un producto", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }else{
                    m = (DefaultTableModel) jTAgProd.getModel();
                    codigo = jTAgProd.getValueAt(fsel, 0).toString();
                    nombre = jTAgProd.getValueAt(fsel, 1).toString();
                    marca = jTAgProd.getValueAt(fsel, 2).toString();
                    precio = jTAgProd.getValueAt(fsel, 3).toString();
                    cantidad = jTFCantidad.getText();
                    
                    //Realizando los calculos
                    x =(Double.parseDouble(precio) * Integer.parseInt(cantidad));
                    importe = String.valueOf(x);
                    
                    
                    m = (DefaultTableModel) jTable2.getModel();
                    String filaelemento[] = {codigo,nombre,marca,precio,cantidad,importe};
                    
                    m.addRow(filaelemento);
                                            
                    calcula = (Double.parseDouble(precio));
                    
                    total = total + calcula;
                    //igvs = total * 0.19;
                    //igv = igvs;
                    sub_total = total - igvs;
                    
                    jTFSubtotal.setText(" "+sub_total); 
                }
                
        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Verificar seleccion del producto", "Advertencia", JOptionPane.ERROR_MESSAGE);
        }
           
         /*  int FC[] = jTAgProd.getSelectedRows();
           String codigo,nombre,marca,precio,cantidad,importe;
           
           for (int i=0; i<FC.length; i++){
               int j = FC[i];
               
               m = (DefaultTableModel)jTAgProd.getModel();
               codigo = jTAgProd.getValueAt(j, 0)+"";
               nombre = jTAgProd.getValueAt(j, 1)+"";
               marca = jTAgProd.getValueAt(j, 2)+"";
               precio = jTAgProd.getValueAt(j, 3)+"";
               cantidad = jTFCantidad.getText();
               
               if (codigo.equals("null")){
                   codigo = "";
               }
               if (nombre.equals("null")){
                   nombre = "";
               }
               if (marca.equals("null")){
                   marca = "";
               }
               if (precio.equals("null")){
                   precio = "";
               }
               if (cantidad.equals("null")){
                   cantidad = "";
               }
               
               boolean todoVacio = false;
               if (codigo.isEmpty()&&
                   nombre.isEmpty() &&
                   marca.isEmpty() &&
                   precio.isEmpty() &&
                   cantidad.isEmpty()) {
                   todoVacio = true;
               }
               if (!todoVacio) {
                   m = (DefaultTableModel)jTable2.getModel();
                   Object fila[] = {codigo,nombre,marca,precio,cantidad};
                   m.addRow(fila); 
               }
           }*/

    }//GEN-LAST:event_jBAgregarActionPerformed

    private void jBGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBGuardarActionPerformed
     int select = jTable2.getSelectedRow();
     
        try {
            if(select==-1)
            {
                JOptionPane.showMessageDialog(null, "Profavor seleccion una fila", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
            } else {
                String produ="";
              int subtotal,codigo,nombre,marca,precio,cantidad;
               
              produ = jTable2.getValueAt(select, 1).toString();
              
              codigo = Integer.parseInt(jTable2.getValueAt(select, 2).toString());
              nombre = Integer.parseInt(jTable2.getValueAt(select, 3).toString());
              marca = Integer.parseInt(jTable2.getValueAt(select, 4).toString());
              precio = Integer.parseInt(jTable2.getValueAt(select, 5).toString());
              cantidad = Integer.parseInt(jTable2.getValueAt(select, 6).toString());
              subtotal = Integer.parseInt(jTFSubtotal.getText());
               
               Object file[]={produ,codigo,nombre,marca,precio,cantidad};
               cotizacion.cot.addRow(file);
               
              
               cotizacion.jTFTotal.setText(String.valueOf(subtotal)); 
            }
            
        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "No se completo la accion", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jBGuardarActionPerformed

    private void jBBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBorrarActionPerformed
        
        this.m.removeRow(this.jTable2.getSelectedRow());
        
    
    }//GEN-LAST:event_jBBorrarActionPerformed

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
            java.util.logging.Logger.getLogger(AgProd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgProd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgProd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgProd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgProd().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jBAgregar;
    public javax.swing.JButton jBBorrar;
    public javax.swing.JButton jBGuardar;
    private javax.swing.JLabel jLBuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JScrollPane jScrollPane3;
    public javax.swing.JTable jTAgProd;
    public javax.swing.JTextField jTFBuscar;
    public javax.swing.JTextField jTFCantidad;
    public javax.swing.JTextField jTFSubtotal;
    public javax.swing.JTable jTable2;
    public javax.swing.JPanel jpBordeTabla1;
    public javax.swing.JPanel jpProductosTitulo3;
    // End of variables declaration//GEN-END:variables
}
