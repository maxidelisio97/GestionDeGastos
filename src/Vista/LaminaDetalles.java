
package Vista;




public class LaminaDetalles extends javax.swing.JInternalFrame {

    /**
     * Creates new form LaminaDetalles
     */
    public LaminaDetalles() {
        initComponents();
         ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btnTablaGastos = new javax.swing.JButton();
        btnTablaIngreso = new javax.swing.JButton();
        campoBuscar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtSumaGasto = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaGastosIngresos = new javax.swing.JTable();

        jLabel2.setText("jLabel2");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setMinimumSize(new java.awt.Dimension(355, 90));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        btnTablaGastos.setFont(new java.awt.Font("Decker", 1, 14)); // NOI18N
        btnTablaGastos.setForeground(new java.awt.Color(255, 255, 255));
        btnTablaGastos.setBorderPainted(false);
        jPanel1.add(btnTablaGastos);

        btnTablaIngreso.setFont(new java.awt.Font("Decker", 1, 14)); // NOI18N
        btnTablaIngreso.setForeground(new java.awt.Color(255, 255, 255));
        btnTablaIngreso.setBorderPainted(false);
        jPanel1.add(btnTablaIngreso);
        jPanel1.add(campoBuscar);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Saldo");
        jPanel1.add(jLabel1);

        txtSumaGasto.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtSumaGasto.setForeground(new java.awt.Color(255, 0, 51));
        txtSumaGasto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtSumaGasto.setText("$ 0.00");
        jPanel1.add(txtSumaGasto);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        tablaGastosIngresos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablaGastosIngresos);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 626, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 62, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnTablaGastos;
    public javax.swing.JButton btnTablaIngreso;
    public javax.swing.JTextField campoBuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tablaGastosIngresos;
    public javax.swing.JTextField txtSumaGasto;
    // End of variables declaration//GEN-END:variables
}
