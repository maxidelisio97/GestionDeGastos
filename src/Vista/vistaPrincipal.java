/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;



/**
 *
 * @author ferc
 */

public class vistaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form vistaPrincipal
     */
    public vistaPrincipal() {
        initComponents();
         setSize(750 , 600);
        setLocationRelativeTo(null);
       
        
        
       

    }
    
  

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        laminaIzquierda = new javax.swing.JPanel();
        btnIngresos = new javax.swing.JButton();
        btnGastos = new javax.swing.JButton();
        btnDetalle = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        escritorio = new javax.swing.JDesktopPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        btnIngresos.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        btnIngresos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/icons8-plus-50.png"))); // NOI18N
        btnIngresos.setText("Ingresos");
        laminaIzquierda.add(btnIngresos);

        btnGastos.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        btnGastos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/icons8-minus-50.png"))); // NOI18N
        btnGastos.setText("Gastos");
        laminaIzquierda.add(btnGastos);

        btnDetalle.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        btnDetalle.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/icons8-bookmark-book-50.png"))); // NOI18N
        btnDetalle.setText("Detalles");
        laminaIzquierda.add(btnDetalle);

        btnSalir.setFont(new java.awt.Font("Decker", 0, 14)); // NOI18N
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/icons8-cancel-50.png"))); // NOI18N
        btnSalir.setText("Salir");
        laminaIzquierda.add(btnSalir);

        getContentPane().add(laminaIzquierda, java.awt.BorderLayout.PAGE_START);

        escritorio.setLayout(new java.awt.BorderLayout());
        getContentPane().add(escritorio, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vistaPrincipal().setVisible(true);
            }
        });
    }

    public LaminaIngreso laminaIngreso = new LaminaIngreso();
    public LaminaGastos laminaGastos = new LaminaGastos();
    public LaminaDetalles laminaDetalles = new LaminaDetalles();
    public detalleGastoTabla detalleGastoTabla = new detalleGastoTabla();
    public LaminaFoto laminaFoto = new LaminaFoto();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnDetalle;
    public javax.swing.JButton btnGastos;
    public javax.swing.JButton btnIngresos;
    public javax.swing.JButton btnSalir;
    public javax.swing.JDesktopPane escritorio;
    public javax.swing.JPanel laminaIzquierda;
    // End of variables declaration//GEN-END:variables

}
