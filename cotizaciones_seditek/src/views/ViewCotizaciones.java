
package views;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Carina
 */
public class ViewCotizaciones extends javax.swing.JFrame {

     Calendar fecha_actual = new GregorianCalendar();
     DefaultTableModel cot;
     
     //ControllerPruebas controller = new ControllerPruebas();
     ResultSet rs = null;
     Connection con = null;
     PreparedStatement ps = null;
   
    public ViewCotizaciones() {
        initComponents();
        this.setLocationRelativeTo(null); 
        
        //Mostrar la fecha actual
        jDCFecha.setCalendar(fecha_actual);
        //llenarComboClientes();
        cargarCombo();
        
        //llenar Combo Condiciones Comerciales
        cargarComboCondiciones();
    }
    
    // Codigo Para llenar El comboBox con los clientes 
    public void cargarCombo() {
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://z5zm8hebixwywy9d.cbetxkdyhwsb.us-east-1.rds.amazonaws.com/zs24at5q2gx9egvg", "um09y46w14qyg6w2", "mqio1vovph8f7gir");
            System.out.println("Conexion Exitosa");
            
            String sql = "SELECT nombre_cliente FROM Clientes";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                String name = rs.getString("nombre_cliente");
                jCBSelecCliente.addItem(name);
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
}
    
    // Codigo Para llenar El comboBox con las condiciones comerciales
        public void cargarComboCondiciones() {
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://z5zm8hebixwywy9d.cbetxkdyhwsb.us-east-1.rds.amazonaws.com/zs24at5q2gx9egvg", "um09y46w14qyg6w2", "mqio1vovph8f7gir");
            System.out.println("Conexion Exitosa");
            
            String sql = "SELECT Condicion FROM Condiciones_comerciales";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while(rs.next()){
                String name = rs.getString("Condicion");
                jCBConCome.addItem(name);
            }
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
            
        }
}

        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelProductos = new javax.swing.JPanel();
        jTPAgProd = new javax.swing.JTabbedPane();
        jLayeredPane2 = new javax.swing.JLayeredPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLNoCotizacion = new javax.swing.JLabel();
        jTFNoCotiacion = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jCBSelecCliente = new javax.swing.JComboBox<>();
        jLTelefono = new javax.swing.JLabel();
        jTFTelefono = new javax.swing.JTextField();
        jLAtencion = new javax.swing.JLabel();
        jTFAtencion = new javax.swing.JTextField();
        jLRFC = new javax.swing.JLabel();
        jTFRFC = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTFEmpresa = new javax.swing.JTextField();
        jLFecha = new javax.swing.JLabel();
        jLCelular = new javax.swing.JLabel();
        jLEmail = new javax.swing.JLabel();
        jTFCelular = new javax.swing.JTextField();
        jTFEmail = new javax.swing.JTextField();
        jBAgreProduct = new javax.swing.JButton();
        jBAgrServ = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jDCFecha = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTDetalleCoti = new javax.swing.JTable();
        jLTelefonoEmpr = new javax.swing.JLabel();
        jTFTelEmp = new javax.swing.JTextField();
        jLValidez = new javax.swing.JLabel();
        jTFValidez = new javax.swing.JTextField();
        jLPromoEsp = new javax.swing.JLabel();
        jTFPromoEsp = new javax.swing.JTextField();
        jLCondCome = new javax.swing.JLabel();
        jBAgregar = new javax.swing.JButton();
        jBGuardar = new javax.swing.JButton();
        jBPrint = new javax.swing.JButton();
        jCBConCome = new javax.swing.JComboBox<>();
        jTFTotal = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTFSubtotal2 = new javax.swing.JTextField();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jpBorde = new javax.swing.JPanel();
        jpPieDePagina1 = new javax.swing.JPanel();
        jpProductosTitulo1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jpBordeTabla = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableProductos = new javax.swing.JTable();
        jTFBuscar = new javax.swing.JTextField();
        jBBuscar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jCBMes = new javax.swing.JComboBox<>();
        jLRangDate = new javax.swing.JLabel();
        jDCRangoDate = new com.toedter.calendar.JDateChooser();
        jBBuscFecha = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLayeredPane2.setPreferredSize(new java.awt.Dimension(1200, 600));

        jPanel2.setBackground(new java.awt.Color(0, 153, 204));

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Cotización");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLNoCotizacion.setText("No. Cotización:");

        jLabel3.setText("Selecciona cliente:");

        jCBSelecCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar Cliente" }));
        jCBSelecCliente.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jCBSelecClientePopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        jLTelefono.setText("Telefono:");

        jTFTelefono.setEditable(false);
        jTFTelefono.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        jLAtencion.setText("Atención:");

        jTFAtencion.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTFAtencion.setEnabled(false);

        jLRFC.setText("RFC:");

        jTFRFC.setEditable(false);
        jTFRFC.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        jLabel4.setText("Empresa:");

        jTFEmpresa.setEditable(false);
        jTFEmpresa.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        jLFecha.setText("Fecha:");

        jLCelular.setText("Celular:");

        jLEmail.setText("Email:");

        jTFCelular.setEditable(false);
        jTFCelular.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        jTFEmail.setEditable(false);
        jTFEmail.setDisabledTextColor(new java.awt.Color(0, 0, 0));

        jBAgreProduct.setText("Agregar Producto");

        jBAgrServ.setText("Agregar Servicio");

        jTDetalleCoti.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Producto", "Marca", "Precio", "Cantidad"
            }
        ));
        jScrollPane1.setViewportView(jTDetalleCoti);

        jLTelefonoEmpr.setText("Teléfono Empresa:");

        jLValidez.setText("Validez de la oferta:");

        jLPromoEsp.setText("Promoción Especial:");

        jLCondCome.setText("Condiciones Comerciales:");

        jBAgregar.setText("Agregar");
        jBAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBAgregarActionPerformed(evt);
            }
        });

        jBGuardar.setText("Guardar");

        jBPrint.setText("Imprimir");

        jCBConCome.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar Condición Comercial" }));

        jTFTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("TOTAL:");

        jTFSubtotal2.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jLayeredPane2.setLayer(jPanel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLNoCotizacion, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jTFNoCotiacion, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jCBSelecCliente, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLTelefono, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jTFTelefono, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLAtencion, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jTFAtencion, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLRFC, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jTFRFC, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jTFEmpresa, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLFecha, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLCelular, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLEmail, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jTFCelular, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jTFEmail, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jBAgreProduct, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jBAgrServ, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jSeparator1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jDCFecha, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jScrollPane1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLTelefonoEmpr, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jTFTelEmp, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLValidez, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jTFValidez, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLPromoEsp, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jTFPromoEsp, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLCondCome, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jBAgregar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jBGuardar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jBPrint, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jCBConCome, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jTFTotal, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jLabel6, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane2.setLayer(jTFSubtotal2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane2Layout = new javax.swing.GroupLayout(jLayeredPane2);
        jLayeredPane2.setLayout(jLayeredPane2Layout);
        jLayeredPane2Layout.setHorizontalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane2Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                                .addComponent(jLTelefonoEmpr)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTFTelEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(99, 99, 99)
                                .addComponent(jLValidez))
                            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                                .addComponent(jLCondCome)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jCBConCome, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                                .addComponent(jBAgregar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jBGuardar)
                                .addGap(18, 18, 18)
                                .addComponent(jBPrint))
                            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                                .addComponent(jTFValidez, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60)
                                .addComponent(jLPromoEsp)
                                .addGap(18, 18, 18)
                                .addComponent(jTFPromoEsp, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jTFSubtotal2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(61, 61, 61)
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(jTFTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(503, 503, 503))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane2Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jLayeredPane2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1))
                    .addGroup(jLayeredPane2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(jLTelefono)
                                .addGap(18, 18, 18)
                                .addComponent(jTFTelefono))
                            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLNoCotizacion)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jCBSelecCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTFNoCotiacion, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(36, 36, 36)
                        .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLAtencion)
                            .addComponent(jLRFC)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTFAtencion)
                            .addComponent(jTFRFC, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                            .addComponent(jTFEmpresa))
                        .addGap(30, 30, 30)
                        .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLCelular)
                            .addComponent(jLEmail)
                            .addComponent(jLFecha))
                        .addGap(18, 18, 18)
                        .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTFCelular)
                            .addComponent(jTFEmail)
                            .addComponent(jDCFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jBAgreProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 131, Short.MAX_VALUE)
                            .addComponent(jBAgrServ, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jScrollPane1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jLayeredPane2Layout.setVerticalGroup(
            jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLNoCotizacion)
                        .addComponent(jTFNoCotiacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLAtencion)
                        .addComponent(jTFAtencion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLFecha)
                        .addComponent(jBAgreProduct))
                    .addComponent(jDCFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jCBSelecCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLRFC)
                        .addComponent(jTFRFC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLCelular)
                        .addComponent(jTFCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jBAgrServ)))
                .addGap(18, 18, 18)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTFTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLTelefono)
                    .addComponent(jLabel4)
                    .addComponent(jTFEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLEmail)
                    .addComponent(jTFEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane2Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLTelefonoEmpr)
                            .addComponent(jTFTelEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLValidez)
                            .addComponent(jTFValidez, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane2Layout.createSequentialGroup()
                            .addGap(23, 23, 23)
                            .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTFTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6)
                                .addComponent(jTFSubtotal2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addComponent(jTFPromoEsp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(35, 35, 35))
                        .addGroup(jLayeredPane2Layout.createSequentialGroup()
                            .addGap(91, 91, 91)
                            .addComponent(jLPromoEsp))))
                .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane2Layout.createSequentialGroup()
                        .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBGuardar)
                            .addComponent(jBPrint))
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane2Layout.createSequentialGroup()
                        .addGroup(jLayeredPane2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLCondCome)
                            .addComponent(jCBConCome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBAgregar))
                        .addGap(36, 36, 36))))
        );

        jTPAgProd.addTab("Productos", jLayeredPane2);

        jpBorde.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        jpBorde.setOpaque(false);

        jpPieDePagina1.setBackground(new java.awt.Color(0, 153, 204));
        jpPieDePagina1.setPreferredSize(new java.awt.Dimension(452, 60));

        javax.swing.GroupLayout jpPieDePagina1Layout = new javax.swing.GroupLayout(jpPieDePagina1);
        jpPieDePagina1.setLayout(jpPieDePagina1Layout);
        jpPieDePagina1Layout.setHorizontalGroup(
            jpPieDePagina1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jpPieDePagina1Layout.setVerticalGroup(
            jpPieDePagina1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        jpProductosTitulo1.setBackground(new java.awt.Color(0, 153, 204));
        jpProductosTitulo1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jpProductosTitulo1.setPreferredSize(new java.awt.Dimension(425, 60));

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Registros Cotizaciones");

        javax.swing.GroupLayout jpProductosTitulo1Layout = new javax.swing.GroupLayout(jpProductosTitulo1);
        jpProductosTitulo1.setLayout(jpProductosTitulo1Layout);
        jpProductosTitulo1Layout.setHorizontalGroup(
            jpProductosTitulo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpProductosTitulo1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpProductosTitulo1Layout.setVerticalGroup(
            jpProductosTitulo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpProductosTitulo1Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                .addContainerGap())
        );

        jpBordeTabla.setBackground(new java.awt.Color(0, 153, 204));
        jpBordeTabla.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 13), new java.awt.Color(255, 255, 255))); // NOI18N

        jTableProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "No. Cotización", "Fecha", "Autorizo", "Cliente ", "Empresa", "Subtotal", "Total", "Acciones"
            }
        ));
        jScrollPane2.setViewportView(jTableProductos);

        jBBuscar.setText("Buscar");

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Busqueda por mes:");

        jCBMes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona Mes", "Enero ", "Febreo ", "Marzo", "Abril", "Mayo ", "Junio", "Julio ", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre " }));

        jLRangDate.setForeground(new java.awt.Color(255, 255, 255));
        jLRangDate.setText("Rango de Fecha:");

        jDCRangoDate.setDateFormatString("yyyy/MM/dd");

        jBBuscFecha.setText("Buscar");

        jDateChooser1.setDateFormatString("yyyy/MM/dd");

        javax.swing.GroupLayout jpBordeTablaLayout = new javax.swing.GroupLayout(jpBordeTabla);
        jpBordeTabla.setLayout(jpBordeTablaLayout);
        jpBordeTablaLayout.setHorizontalGroup(
            jpBordeTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBordeTablaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpBordeTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jpBordeTablaLayout.createSequentialGroup()
                        .addComponent(jTFBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBBuscar)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jCBMes, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jpBordeTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpBordeTablaLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 466, Short.MAX_VALUE)
                                .addComponent(jDCRangoDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpBordeTablaLayout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addComponent(jLRangDate)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBBuscFecha)))
                .addContainerGap())
        );
        jpBordeTablaLayout.setVerticalGroup(
            jpBordeTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBordeTablaLayout.createSequentialGroup()
                .addGroup(jpBordeTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpBordeTablaLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jpBordeTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTFBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBBuscar)
                            .addComponent(jLabel5)
                            .addComponent(jCBMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jpBordeTablaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLRangDate)
                        .addGap(15, 15, 15)
                        .addGroup(jpBordeTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jDCRangoDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBBuscFecha))))
                .addGap(15, 15, 15)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpBordeLayout = new javax.swing.GroupLayout(jpBorde);
        jpBorde.setLayout(jpBordeLayout);
        jpBordeLayout.setHorizontalGroup(
            jpBordeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpBordeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpBordeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jpPieDePagina1, javax.swing.GroupLayout.DEFAULT_SIZE, 1363, Short.MAX_VALUE)
                    .addComponent(jpProductosTitulo1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 1363, Short.MAX_VALUE)
                    .addComponent(jpBordeTabla, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jpBordeLayout.setVerticalGroup(
            jpBordeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpBordeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpProductosTitulo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpBordeTabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jpPieDePagina1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLayeredPane1.setLayer(jpBorde, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpBorde, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpBorde, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTPAgProd.addTab("Registros", jLayeredPane1);

        javax.swing.GroupLayout jPanelProductosLayout = new javax.swing.GroupLayout(jPanelProductos);
        jPanelProductos.setLayout(jPanelProductosLayout);
        jPanelProductosLayout.setHorizontalGroup(
            jPanelProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelProductosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTPAgProd)
                .addContainerGap())
        );
        jPanelProductosLayout.setVerticalGroup(
            jPanelProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelProductosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTPAgProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 973, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelProductos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCBSelecClientePopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jCBSelecClientePopupMenuWillBecomeInvisible
       
        //Código para mostrar los datos requeridos para la realizacion de una cotización a un cliente 
        String item = (String)jCBSelecCliente.getSelectedItem();
       String sql = "Select telefono_cliente, telefono_empresa, email_cliente, rfc_cliente, empresa_cliente FROM Clientes where nombre_cliente = ? ";
       try {
           ps = con.prepareStatement(sql);
           ps.setString(1, item);
           rs = ps.executeQuery();
           
           if(rs.next()){
               String firstname = rs.getString("telefono_cliente");
               jTFCelular.setText(firstname);
               String empresa = rs.getString("telefono_empresa");
               jTFTelefono.setText(empresa);
               String email = rs.getString("email_cliente");
               jTFEmail.setText(email);
               String rfc = rs.getString("rfc_cliente");
               jTFRFC.setText(rfc);
               String nomempresa = rs.getString("empresa_cliente");
               jTFEmpresa.setText(nomempresa);
               
           }
       
       } catch(SQLException e){
           
       }
    }//GEN-LAST:event_jCBSelecClientePopupMenuWillBecomeInvisible

    private void jBAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBAgregarActionPerformed
        
        
        
             /* try{
             String value = JOptionPane.showInputDialog(this, "Ingresa una Condición Comercial");
             
             jCBConCome.addItem(value);
             
             PreparedStatement ps = con.prepareStatement("Insert into Condiciones_comerciales(Condicion) VALUES (?)");
             ps.setString(1, value);
             ps.executeUpdate();
             JOptionPane.showMessageDialog(null, "Datos guardados");
             
             } catch (SQLException ex) {
             Logger.getLogger(ViewCotizaciones.class.getName()).log(Level.SEVERE, null, ex);
             }*/
             

       
       String msg = JOptionPane.showInputDialog(null, "Ingresa una Condición Comercial");
       System.out.println(msg);
    }//GEN-LAST:event_jBAgregarActionPerformed

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
            java.util.logging.Logger.getLogger(ViewCotizaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewCotizaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewCotizaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewCotizaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewCotizaciones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jBAgrServ;
    public javax.swing.JButton jBAgreProduct;
    public javax.swing.JButton jBAgregar;
    public javax.swing.JButton jBBuscFecha;
    public javax.swing.JButton jBBuscar;
    public javax.swing.JButton jBGuardar;
    public javax.swing.JButton jBPrint;
    public javax.swing.JComboBox<String> jCBConCome;
    public javax.swing.JComboBox<String> jCBMes;
    public javax.swing.JComboBox<String> jCBSelecCliente;
    public com.toedter.calendar.JDateChooser jDCFecha;
    public com.toedter.calendar.JDateChooser jDCRangoDate;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLAtencion;
    private javax.swing.JLabel jLCelular;
    private javax.swing.JLabel jLCondCome;
    private javax.swing.JLabel jLEmail;
    private javax.swing.JLabel jLFecha;
    private javax.swing.JLabel jLNoCotizacion;
    private javax.swing.JLabel jLPromoEsp;
    private javax.swing.JLabel jLRFC;
    private javax.swing.JLabel jLRangDate;
    private javax.swing.JLabel jLTelefono;
    private javax.swing.JLabel jLTelefonoEmpr;
    private javax.swing.JLabel jLValidez;
    private javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLayeredPane jLayeredPane2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelProductos;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    public javax.swing.JTable jTDetalleCoti;
    public javax.swing.JTextField jTFAtencion;
    public javax.swing.JTextField jTFBuscar;
    public javax.swing.JTextField jTFCelular;
    public javax.swing.JTextField jTFEmail;
    public javax.swing.JTextField jTFEmpresa;
    public javax.swing.JTextField jTFNoCotiacion;
    public javax.swing.JTextField jTFPromoEsp;
    public javax.swing.JTextField jTFRFC;
    public javax.swing.JTextField jTFSubtotal2;
    public javax.swing.JTextField jTFTelEmp;
    public javax.swing.JTextField jTFTelefono;
    public javax.swing.JTextField jTFTotal;
    public javax.swing.JTextField jTFValidez;
    public javax.swing.JTabbedPane jTPAgProd;
    public javax.swing.JTable jTableProductos;
    public javax.swing.JPanel jpBorde;
    public javax.swing.JPanel jpBordeTabla;
    public javax.swing.JPanel jpPieDePagina1;
    public javax.swing.JPanel jpProductosTitulo1;
    // End of variables declaration//GEN-END:variables
}
