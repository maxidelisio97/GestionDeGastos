package Controlador;

import Modelo.BaseDatos;
import Modelo.Categoria;
import Modelo.Categoria_ingreso;
import Modelo.Gastos;
import Modelo.Ingreso;

import Vista.LaminaDetalles;
import Vista.LaminaGastos;
import Vista.LaminaIngreso;

import Vista.vistaPrincipal;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

public class ControladorEvento {

    private vistaPrincipal vista;
    private BaseDatos modelo;
    private ResultSet rs = null;
    private File imgArticleFile;
    private LaminaIngreso ifi;
    private LaminaGastos ifg;
    private LaminaDetalles ifd;

    private Categoria categoria = null;
    private Categoria_ingreso categoria_ingreso = null;

    public ControladorEvento() {
    }

    public ControladorEvento(vistaPrincipal vista, BaseDatos modelo) {

        this.vista = vista;
        ifi = new LaminaIngreso();
        ifg = new LaminaGastos();
        ifd = new LaminaDetalles();
        this.modelo = modelo;

        cargarModeloCategoria();
        cargarModeloCategoria_Ingreso();

        modeloTablaIngreso.addColumn("Tipo");
        modeloTablaIngreso.addColumn("Categoria");
        modeloTablaIngreso.addColumn("Fecha");
        modeloTablaIngreso.addColumn("Importe");

        modeloTablaGasto.addColumn("Tipo");
        modeloTablaGasto.addColumn("Categoria");
        modeloTablaGasto.addColumn("Descripción");
        modeloTablaGasto.addColumn("Fecha");
        modeloTablaGasto.addColumn("Importe");

//BOTON PRINCIPAL GASTOS
        this.vista.btnGastos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                abrirFrameGasto(e);

            }
        });

        //BOTON DE AÑADIR INGRESO
        this.vista.btnIngresos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                abrirFrameIngreso(e);
            }

        });

// BOTON DE DETALLES DE INGRESOS-GASTOS
        this.vista.btnDetalle.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                abrirFrameDetalle(e);
            }

        });

//BOTON DE AÑADIR CATEGORIA_INGRESO
        this.ifi.btnCategoriaIngreso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String categoria_ingreso = JOptionPane.showInputDialog("Añadir tipo de ingreso");

                recibeNuevaCategoria_ingreso(categoria_ingreso.toUpperCase());

                addCategoriaIngreso(new Categoria_ingreso(categoria_ingreso.toUpperCase()));

            }

        });

//BOTON QUE ACTUALIZA LA CATEGORIA DE GASTO
        this.ifg.btnActualizarCategoriaGasto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                enviaCategoriaGastoActualizada();

            }

        });
//BOTON QUE ACTUALIZA LA CATEGORIA DE INGRESO
        this.ifi.btnActualizarCategoriaIngreso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                actualizaCategoriaIngreso();

            }

        });
//BOTON SALIR    
        this.vista.btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.exit(0);

            }

        });
//BOTON QUE ELIMINA UNA CATEGORIA DE GASTO
        this.ifg.btnEliminarCategoriaGasto.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                eliminaCategoriaGasto();
            }
        });
//BOTON QUE ELIMINAR UNA CATEGORIA DE INGRESO
        this.ifi.btnEliminarCategoriaIngreso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                eliminarCategoriaIngreso();

            }

        });
//BOTON QUE AGREGA CATEGORIA DE GASTOS
        this.ifg.btnCategoria.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                añadirCategoria(e);

            }

        });

        /*  this.ifd.comboDetalle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                limpiarTabla();

                String nombre = ifd.comboDetalle.getSelectedItem().toString();

                cargarTablaSegunId(nombre);

                sumarGastos(nombre);

            }

        });*/
//BOTON QUE GUARDA LOS DATOS DE GASTOS
        this.ifg.btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarGasto(e);

            }
        });

        this.ifi.btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarIngreso(e);

            }
        });

// BOTON QUE GUARDA LA FOTO DE LA FACTURA
        this.ifg.LabelGuardarFactura.addMouseListener(new MouseAdapter() {

            public void mousePressed(MouseEvent e) {

                JFileChooser chooser = new JFileChooser();

                FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivo que soporta", "jpg", "png", "gif", "pdf");

                chooser.setFileFilter(filter);

                System.out.println(filter.getDescription());

                int returnVal = chooser.showOpenDialog(vista.laminaGastos);

                if (returnVal == JFileChooser.APPROVE_OPTION) {

                    imgArticleFile = chooser.getSelectedFile();

                }

            }

        });

//BOTON DE DETALLES
        this.ifd.btnTablaGastos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {                
                ifd.txtSumaGasto.setForeground(Color.RED);
               limpiarTablaGasto(modeloTablaGasto);
                cargarModeloTablaGasto();
                 
                sumatoria = 0;
                double sumatoria = getSaldoGasto();
                ifd.txtSumaGasto.setText(String.valueOf(sumatoria));
            }
        });
//BOTON PRINCIPAL DE INGRESO
        this.ifd.btnTablaIngreso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ifd.txtSumaGasto.setForeground(Color.GREEN);
                limpiarTablaIngreso(modeloTablaIngreso);
                cargarModeloTablaIngreso();
                sumatoria = 0;

                double sumatoria = getSaldoIngreso();
                ifd.txtSumaGasto.setText(String.valueOf(sumatoria));

            }

        });

    }

    public void recibeNuevaCategoria_ingreso(String categoria) {

        Categoria_ingreso categoria_ingreso = new Categoria_ingreso(categoria);

        modelo.ingresaCategoria_ingreso(categoria_ingreso);

    }
    double sumatoria = 0;

    private double getSaldoIngreso() {
        int numFilas = modeloTablaIngreso.getRowCount();
        for (int i = 0; i < numFilas; i++) {

            double importe = (double) modeloTablaIngreso.getValueAt(i, 3);
            sumatoria += (importe);
        }
        return sumatoria;

    }
    
    private double getSaldoGasto() {
 int numFilas = modeloTablaGasto.getRowCount() ;
      for(int i=0;i<numFilas;i++){ 
          
        double importe = (double) modeloTablaGasto.getValueAt(i, 4);
        sumatoria += (importe);
      }
      return sumatoria;

    }

    private void LimpiarLista() {
        int numFilas = modeloTablaIngreso.getRowCount();
        if (numFilas > 0) {
            for (int i = numFilas - 1; i < 0; i--) {
                modeloTablaIngreso.removeRow(i);
            }

        }
    }

//METODO QUE AÑADE CATEGORIA 
    public void recibeNuevaCategoria(String categoria) {

        Categoria nuevaCategoria = new Categoria(categoria);

        modelo.ingresaCategoria(nuevaCategoria);
    }

// METODO QUE CARGA EL COMBO BOX DE CATEGORIAS
    public void cargarModeloCategoria() {
        listaCategorias = new ArrayList<>();
        listaCategorias = modelo.añadirCategoriaComboBox();

        for (Categoria c : listaCategorias) {
            ifg.modeloCategoriasGastos.addElement(c);

        }

    }

//METODO QUE CARGA EL COMBOBOX DE CATEGORIAS DE INGRESO
    public void cargarModeloCategoria_Ingreso() {

        listaIngreso = new ArrayList<>();

        listaIngreso = modelo.añadirIngresoCategoria();

        for (Categoria_ingreso i : listaIngreso) {
            ifi.modeloCategoriaIngreso.addElement(i);

        }

    }

//METODO PARA ACTUALIZAR EL COMBOBOX DE CATEGORIAS DE GASTO
    public void addCategoriaGasto(Categoria categoria) {
        ifg.modeloCategoriasGastos.addElement(categoria);
        ifg.modeloCategoriasGastos.setSelectedItem(categoria);

    }

//METODO PARA ACTUALIZAR EL COMBOBOX DE CATEGORIAS DE INGRESO
    public void addCategoriaIngreso(Categoria_ingreso categoria_ingreso) {
        ifi.modeloCategoriaIngreso.addElement(categoria_ingreso);

        ifi.modeloCategoriaIngreso.setSelectedItem(categoria_ingreso);

    }

//ACTUALIZA UNA CATEGORIA DE GASTO
    private void enviaCategoriaGastoActualizada() {

        Categoria categoria = (Categoria) vista.laminaGastos.comboCategoria.getSelectedItem();

        String categoriaActualizada = JOptionPane.showInputDialog("Actualiza categoria");

        Categoria c = new Categoria(categoriaActualizada.toUpperCase(), categoria.getId_categoria());

        modelo.actualizaCategoriaGasto(c);

        ifg.modeloCategoriasGastos.removeAllElements();

        cargarModeloCategoria();

    }

//ELIMINAR LA CATEGORIA DE GASTO
    private void eliminaCategoriaGasto() {

        Categoria c = (Categoria) vista.laminaGastos.comboCategoria.getSelectedItem();

        Categoria categoria = new Categoria(c.getId_categoria());

        modelo.eliminaCategoriaGasto(categoria);

        ifg.modeloCategoriasGastos.removeAllElements();

        cargarModeloCategoria();

    }

//ELIMINAR LA CATEGORIA DE INGRESO    
    private void eliminarCategoriaIngreso() {

        Categoria_ingreso c = (Categoria_ingreso) ifi.comboCategoriaIngreso.getSelectedItem();

        Categoria_ingreso categoria = new Categoria_ingreso(c.getId_categoria_ingreso());

        modelo.eliminaCategoriaIngreso(categoria);

        ifi.modeloCategoriaIngreso.removeAllElements();

        cargarModeloCategoria_Ingreso();

    }

//ACTUALIZA CATEGORIA DE INGRESO
    private void actualizaCategoriaIngreso() {

        Categoria_ingreso categoria = (Categoria_ingreso) ifi.comboCategoriaIngreso.getSelectedItem();

        String categoriaActualizada = JOptionPane.showInputDialog("Actualiza categoria");

        Categoria_ingreso c = new Categoria_ingreso(categoria.getId_categoria_ingreso(), categoriaActualizada.toUpperCase());

        modelo.actualizaCategoriaIngreso(c);

        ifi.modeloCategoriaIngreso.removeAllElements();

        cargarModeloCategoria_Ingreso();

    }

//CARGA EL MODELO DE LA TABLA DE GASTO
    private void cargarModeloTablaGasto() {

        ResultSet rs = modelo.dameTablaGasto();

        try {
            ResultSetMetaData rsm = rs.getMetaData();
            int numColumnas = rsm.getColumnCount();

            //modeloTablaGastos.addColumn("X");
            while (rs.next()) {

                Object fila[] = new Object[numColumnas];

                for (int i = 0; i < numColumnas; i++) {

                    fila[0] = rs.getObject(1);
                    fila[1] = rs.getObject(2);
                    fila[2] = rs.getObject(3);
                    fila[3] = rs.getObject(4);
                    fila[4] = rs.getObject(5);
                    //fila[7] = vista.detalleGastoTabla.btnVerFactura;
                    //fila[8]=vista.detalleGastoTabla.btnBorrarGasto;
                }

                modeloTablaGasto.addRow(fila);
                ifd.tablaGastosIngresos.setModel(modeloTablaGasto);
            }
        } catch (Exception ex) {
            Logger.getLogger(ControladorEvento.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

//INGRESO TABLA -------------- MODELO
    private void cargarModeloTablaIngreso() {

        ResultSet rs = modelo.dameTablaIngreso();

        try {
            ResultSetMetaData metaData = rs.getMetaData();

            int numColumnas = metaData.getColumnCount();

            while (rs.next()) {

                Object fila[] = new Object[numColumnas];

                for (int i = 0; i < numColumnas; i++) {

                    fila[0] = rs.getObject(1);
                    fila[1] = rs.getObject(2);
                    fila[2] = rs.getObject(3);
                    fila[3] = rs.getObject(4);

                }

                modeloTablaIngreso.addRow(fila);
                ifd.tablaGastosIngresos.setModel(modeloTablaIngreso);

            }
        } catch (Exception ex) {
            System.out.println(ex);

        }

    }

    public void sumarGastos(String nombreSeleccionado) {

        ResultSet rs = modelo.selectSumaGasto(nombreSeleccionado);
        double importe = 0;
        try {

            while (rs.next()) {

                importe = rs.getDouble("IMPORTE_GASTO");
            }

            vista.laminaDetalles.txtSumaGasto.setText(String.valueOf(importe));

        } catch (Exception e) {

            e.printStackTrace();
        }

    }

    private void cargarTablaSegunId(String nombrePersonaComboDetalle) {

        ResultSet rs = modelo.dameTablaGastoPorId(nombrePersonaComboDetalle);

        try {
            ResultSetMetaData rsm = rs.getMetaData();
            int numColumnas = rsm.getColumnCount();

            while (rs.next()) {

                Object fila[] = new Object[numColumnas];

                for (int i = 0; i < numColumnas; i++) {

                    fila[0] = rs.getObject(1);
                    fila[1] = rs.getObject(2);
                    fila[2] = rs.getObject(3);
                    fila[3] = rs.getObject(4);
                    fila[4] = rs.getObject(5);
                    fila[5] = rs.getObject(6);
                    fila[6] = rs.getObject(7);
                    //fila[7] = vista.detalleGastoTabla.btnVerFactura;
                    //fila[8]=vista.detalleGastoTabla.btnBorrarGasto;
                }

                ifg.modeloTablaGastos.addRow(fila);

            }
        } catch (Exception ex) {
            Logger.getLogger(ControladorEvento.class.getName()).log(Level.SEVERE, null, ex);

        }

    }

    public void verFotoGasto(int gasto) {

        ImageIcon ImagenGasto = null;

        JLabel label = new JLabel();
        byte[] b = null;

        try {

            ResultSet rs = modelo.leerPDF(gasto);

            while (rs.next()) {

                b = rs.getBytes("FOTO_GASTO");
            }
            InputStream is = new ByteArrayInputStream(b);
            int tamanio = is.available();
            byte[] PDF = new byte[tamanio];

            is.read(PDF, 0, tamanio);

            FileOutputStream escritura = new FileOutputStream("archivo.pdf");
            escritura.write(b);

            //ImageIcon icono2 = new ImageIcon(ImagenGasto.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_DEFAULT));
            //label.setIcon(ImagenGasto);
        } catch (Exception e) {

            e.printStackTrace();
        }

    }

    private void tablaGastosMouseClicked(java.awt.event.MouseEvent evt) {
        int rown = vista.detalleGastoTabla.tablaGastos.rowAtPoint(evt.getPoint());
        int column = vista.detalleGastoTabla.tablaGastos.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY() / vista.detalleGastoTabla.tablaGastos.getRowHeight();

        if (row < vista.detalleGastoTabla.tablaGastos.getRowCount() && row >= 0 && column < vista.detalleGastoTabla.tablaGastos.getColumnCount() && column >= 0) {
            Object value = vista.detalleGastoTabla.tablaGastos.getValueAt(row, column);

            if (value instanceof JButton) {

                ((JButton) value).doClick();
                JButton boton = (JButton) value;

                if (boton.getName().equals("v")) {

                    int codigo = (int) vista.detalleGastoTabla.tablaGastos.getValueAt(rown, 0);

                    verFotoGasto(codigo);

                    try {
                        Desktop.getDesktop().open(new File("archivo.pdf"));
                    } catch (IOException ex) {
                        Logger.getLogger(ControladorEvento.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
        }

    }

    //METODO QUE GUARDA EL INGRESO
    private void guardarIngreso(ActionEvent e) {

        String seleccion = "";

        if (ifg.radioEfectivo.isSelected()) {

            seleccion = "Efectivo";
        } else if (ifg.radioTarjeta.isSelected()) {
            seleccion = "Ahorro";
        }

        String descripcion = ifi.txtDescripcion.getText().toUpperCase();

        String fecha = ((JTextField) ifi.txtFechaIngresada.getDateEditor().getUiComponent()).getText();

        double importe = Double.parseDouble(ifi.lblImporteIngreso.getText());

        categoria_ingreso = (Categoria_ingreso) ifi.comboCategoriaIngreso.getSelectedItem();

        Ingreso ingreso = new Ingreso(seleccion, descripcion, importe, fecha, categoria_ingreso.getId_categoria_ingreso());

        modelo.INSERTingreso(ingreso);

    }

    private void guardarGasto(ActionEvent e) {
        String seleccion = "";

        if (ifg.radioEfectivo.isSelected()) {

            seleccion = "EFECTIVO";
        } else if (ifg.radioTarjeta.isSelected()) {
            seleccion = "TARJETA";
        }

        String descripcion = ifg.txtDescripcion.getText().toUpperCase();

        String fecha = ((JTextField) ifg.campoFecha.getDateEditor().getUiComponent()).getText();

        double importe = Double.parseDouble(ifg.txtImporte.getText());

        categoria = (Categoria) ifg.comboCategoria.getSelectedItem();

        if (imgArticleFile == null) {

            Gastos gasto = new Gastos(seleccion, descripcion, importe, fecha, categoria.getId_categoria());

            modelo.insertarGastoSinFoto(gasto);

            JOptionPane.showMessageDialog(null, "NO INGRESASTE NINGUNA FACTURA");

        } else {

            Gastos gasto = new Gastos(seleccion, descripcion, importe, fecha, imgArticleFile, categoria.getId_categoria());

            modelo.insertarGasto(gasto);

            JOptionPane.showMessageDialog(null, "SE GUARDO CORRECTAMENTE SU GASTO");
        }
    }

    private void añadirCategoria(ActionEvent e) {

        String nombre = JOptionPane.showInputDialog("Añadir Categoria de Gasto");

        recibeNuevaCategoria(nombre.toUpperCase());

        addCategoriaGasto(new Categoria(nombre));

    }

    private void abrirFrameGasto(ActionEvent e) {

        vista.escritorio.removeAll();
        vista.escritorio.repaint();
        vista.escritorio.add(BorderLayout.CENTER, this.ifg);
        vista.escritorio.getDesktopManager().maximizeFrame(this.ifg);
        this.ifg.show();

    }

    private void abrirFrameIngreso(ActionEvent e) {

        vista.escritorio.removeAll();
        vista.escritorio.repaint();
        vista.escritorio.add(BorderLayout.CENTER, this.ifi);
        vista.escritorio.getDesktopManager().maximizeFrame(this.ifi);
        this.ifi.show();

    }

    private void abrirFrameDetalle(ActionEvent e) {

        vista.escritorio.removeAll();
        vista.escritorio.repaint();
        vista.escritorio.add(BorderLayout.CENTER, this.ifd);
        vista.escritorio.getDesktopManager().maximizeFrame(this.ifd);
        this.ifd.show();

    }

    public void limpiarTablaIngreso(DefaultTableModel modelo) {
        int filas = modelo.getRowCount();       
        if (filas > 0) {
            for (int i = filas - 1; i >= 0; i--) {
                modelo.removeRow(i);
            }
        }

    }
  

    public void limpiarTablaGasto(DefaultTableModel modelo) {       
        int filas = modelo.getRowCount();       
        if (filas > 0) {
            for (int i = filas - 1; i >= 0; i--) {
                modelo.removeRow(i);
            }
        }

    }
 

    private DefaultComboBoxModel modeloPersona = new DefaultComboBoxModel();
    private DefaultTableModel modeloTablaGasto = new DefaultTableModel();
    private DefaultTableModel modeloTablaIngreso = new DefaultTableModel();
    private ArrayList<Categoria_ingreso> listaIngreso;
    private ArrayList<Categoria> listaCategorias;

}
