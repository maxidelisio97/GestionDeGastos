/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControladorEvento;
import Modelo.BaseDatos;
import Modelo.Gastos;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author ferc
 */
public class detalleGastoTabla extends javax.swing.JPanel {

    public detalleGastoTabla() {
        initComponents();
        
        tablaGastos.setDefaultRenderer(Object.class, new Render());
       // btnVerFactura.setName("v");
        //btnBorrarGasto.setName("borrar");
       
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tablaGastos = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.BorderLayout());

        tablaGastos.setBackground(new java.awt.Color(51, 51, 51));
        tablaGastos.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 12)); // NOI18N
        tablaGastos.setForeground(new java.awt.Color(255, 255, 255));
        tablaGastos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tablaGastos.setRowHeight(25);
        tablaGastos.setSelectionBackground(new java.awt.Color(51, 51, 51));
        tablaGastos.setSelectionForeground(new java.awt.Color(0, 204, 204));
        jScrollPane2.setViewportView(tablaGastos);

        add(jScrollPane2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    
    // public JButton btnVerFactura = new JButton(new ImageIcon(getClass().getResource("/Iconos/acrobat.png")));
     //public JButton btnBorrarGasto = new JButton(new ImageIcon(getClass().getResource("/Iconos/deletito.png")));

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTable tablaGastos;
    // End of variables declaration//GEN-END:variables

}
