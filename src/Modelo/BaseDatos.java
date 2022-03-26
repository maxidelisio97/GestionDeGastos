package Modelo;

import Vista.vistaPrincipal;
import java.sql.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;

public class BaseDatos {

    private Conexion conexion;
    private Statement st;

    private ResultSet rs = null;
    private File foto = null;

    public BaseDatos() {

        conexion = new Conexion();

    }
    
        public void INSERTingreso(Ingreso ingreso) {
        Connection conn;
        PreparedStatement ps;
        try {

            conn = conexion.getConexion();

            ps = conn.prepareStatement("INSERT INTO INGRESO (TIPO_INGRESO,DESCRIPCION_INGRESO,IMPORTE_INGRESO,FECHA_INGRESO,ID_CATEGORIA_INGRESO) VALUES(?,?,?,?,?)");

            ps.setString(1, ingreso.getTipo_ingreso());
            ps.setString(2, ingreso.getDesc_ingreso());
            ps.setDouble(3, ingreso.getImporte_ingreso());
            ps.setString(4, ingreso.getFecha_ingreso());
            ps.setInt(5, ingreso.getId_categoria_ingreso());

            ps.execute();

        } catch (Exception e) {

          e.printStackTrace();
        }

    }

    //CONSULTA PARA AÑADIR CATEGORIA_INGRESO
    public void ingresaCategoria_ingreso(Categoria_ingreso categoria_ingreso) {
        Connection conn;
        PreparedStatement ps;
        try {

            conn = conexion.getConexion();

            ps = conn.prepareStatement("INSERT INTO CATEGORIA_INGRESO (NOM_CATEGORIA_INGRESO) VALUES(?)");

            ps.setString(1, categoria_ingreso.getNom_categoria_ingreso());

            ps.execute();

        } catch (Exception e) {

e.printStackTrace();
        }

    }

    //TIPO DE CATEGORIA

    public void ingresaCategoria(Categoria categoria) {

        Connection conn;
        PreparedStatement ps;
        try {

            conn = conexion.getConexion();

            ps = conn.prepareStatement("INSERT INTO CATEGORIA (NOM_CATEGORIA) VALUES(?)");

            ps.setString(1, categoria.getNom_categoria());

            ps.execute();

        } catch (Exception e) {

           e.printStackTrace();
        }

    }

    public ArrayList<Categoria> añadirCategoriaComboBox() {

        ArrayList<Categoria> nombresCategoria = new ArrayList<Categoria>();

        Connection conn;

        try {
            conn = conexion.getConexion();

            st = conn.createStatement();

            rs = st.executeQuery("SELECT * FROM CATEGORIA");

            while (rs.next()) {

                int id_categoria = rs.getInt("ID_CATEGORIA");

                String nom_categoria = rs.getString("NOM_CATEGORIA");

                Categoria categoria = new Categoria(nom_categoria, id_categoria);

                nombresCategoria.add(categoria);

            }

        } catch (Exception e) {

            e.printStackTrace();
        }
        return nombresCategoria;

    }

   

    public void insertarGasto(Gastos gasto) {

        Connection conn = null;

        PreparedStatement ps = null;

        conn = conexion.getConexion();

        try {

            foto = gasto.getFoto_gasto();

            FileInputStream fis = new FileInputStream(foto);

            ps = conn.prepareStatement("INSERT INTO GASTO (TIPO_GASTO,DESCRIPCION_GASTO,FOTO_GASTO,FECHA_GASTO, IMPORTE_GASTO,ID_CATEGORIA) VALUES(?,?,?,?,?,?)");

            ps.setString(1, gasto.getTipo_gasto());
            ps.setString(2, gasto.getDescripcion_gasto());
            long tamanioFoto = foto.length();
            ps.setBinaryStream(3, fis, tamanioFoto);
            ps.setString(4, gasto.getFecha_vencimiento_gasto());
            ps.setDouble(5, gasto.getImporte());
           
            ps.setInt(6, gasto.getId_categoria());

            ps.executeQuery();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void insertarGastoSinFoto(Gastos gasto) {

        Connection conn = null;

        PreparedStatement ps = null;

        conn = conexion.getConexion();

        try {

            ps = conn.prepareStatement("INSERT INTO GASTO (TIPO_GASTO,DESCRIPCION_GASTO,FECHA_GASTO, IMPORTE_GASTO,ID_CATEGORIA) VALUES (?,?,?,?,?)");

            ps.setString(1, gasto.getTipo_gasto());
            ps.setString(2, gasto.getDescripcion_gasto());
            ps.setString(3, gasto.getFecha_vencimiento_gasto());
            ps.setDouble(4, gasto.getImporte());            
            ps.setInt(5, gasto.getId_categoria());

            ps.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    //INSERTAR INGRESO EN LA CATEGORIA 

    public void UPDATEingreso(Ingreso ingreso) {

        Connection conn = null;

        PreparedStatement ps = null;

        conn = conexion.getConexion();

        try {

            ps = conn.prepareStatement("INSERT INTO INGRESO (TIPO_INGRESO,DESCRIPCION_INGRESO, IMPORTE_INGRESO,FECHA_INGRESO,ID_CATEGORIA_INGRESO) VALUES(?,?,?,?,?)");

            ps.setString(1, ingreso.getTipo_ingreso());
            ps.setString(2, ingreso.getDesc_ingreso());
            ps.setDouble(3, ingreso.getImporte_ingreso());
            ps.setString(4, ingreso.getFecha_ingreso());
           
            ps.setInt(5, ingreso.getId_categoria_ingreso());
            ps.execute();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    //COMBOBOX DE CATEGORIA_INGRESO 
    public ArrayList<Categoria_ingreso> añadirIngresoCategoria() {

        ArrayList<Categoria_ingreso> Cat_ingreso = new ArrayList<Categoria_ingreso>();

        Connection conn;

        try {
            conn = conexion.getConexion();

            st = conn.createStatement();

            rs = st.executeQuery("SELECT DISTINCTROW * FROM CATEGORIA_INGRESO");

            while (rs.next()) {

                int id_ingreso = rs.getInt("ID_CATEGORIA_INGRESO");

                String nom_ingreso = rs.getString("NOM_CATEGORIA_INGRESO");

                Categoria_ingreso cat_ingreso = new Categoria_ingreso(id_ingreso, nom_ingreso);

                Cat_ingreso.add(cat_ingreso);

            }

        } catch (Exception e) {

           e.printStackTrace();
        }
        return Cat_ingreso;

    }

   

    public void actualizaCategoriaGasto(Categoria c) {
        Connection conn = null;

        PreparedStatement ps = null;

        try {
            conn = conexion.getConexion();

            ps = conn.prepareStatement("UPDATE CATEGORIA SET NOM_CATEGORIA = ? WHERE ID_CATEGORIA = ?");

            ps.setString(1, c.getNom_categoria());
            ps.setInt(2, c.getId_categoria());

            ps.executeUpdate();

        } catch (Exception e) {
           e.printStackTrace();

        } finally {
            try {

                ps.close();
                conn.close();

            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }

    }

    public void eliminaCategoriaGasto(Categoria categoria) {
        Connection conn = null;

        PreparedStatement ps = null;

        try {
            conn = conexion.getConexion();

            ps = conn.prepareStatement("DELETE FROM CATEGORIA WHERE ID_CATEGORIA = ?");

            ps.setInt(1, categoria.getId_categoria());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            try {

                ps.close();
                conn.close();

            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }
    }

    public void actualizaCategoriaIngreso(Categoria_ingreso c) {
        Connection conn = null;

        PreparedStatement ps = null;

        try {
            conn = conexion.getConexion();

            ps = conn.prepareStatement("UPDATE CATEGORIA_INGRESO SET NOM_CATEGORIA_INGRESO=? WHERE ID_CATEGORIA_INGRESO = ?");

            ps.setString(1, c.getNom_categoria_ingreso());
            ps.setInt(2, c.getId_categoria_ingreso());

            ps.executeUpdate();

        } catch (Exception e) {
          e.printStackTrace();

        } finally {
            try {

                ps.close();
                conn.close();

            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }

    }

    public void eliminaCategoriaIngreso(Categoria_ingreso categoria) {
        Connection conn = null;

        PreparedStatement ps = null;

        try {
            conn = conexion.getConexion();

            ps = conn.prepareStatement("DELETE FROM CATEGORIA_INGRESO WHERE ID_CATEGORIA_INGRESO = ?");

            ps.setInt(1, categoria.getId_categoria_ingreso());

            ps.executeUpdate();

        } catch (Exception e) {
         e.printStackTrace();

        } finally {
            try {

                ps.close();
                conn.close();

            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }
    }

    public ArrayList getGastos() {

        Connection conn = null;
        Statement st = null;

        ArrayList<Gastos> listaGastos = new ArrayList<Gastos>();

        try {

            conn = conexion.getConexion();

            st = conn.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM GASTO");

            while (rs.next()) {

                String tipo = rs.getString("TIPO_GASTO");
                String descripcion = rs.getString("DESCRIPCION_GASTO");
                String fecha = rs.getString("FECHA_GASTO");
                double importe = rs.getDouble("IMPORTE_GASTO");
               
                int id_categoria = rs.getInt("ID_CATEGORIA");

                Gastos gasto = new Gastos(tipo, descripcion, importe, fecha, id_categoria);

                listaGastos.add(gasto);

            }

        } catch (Exception e) {

           e.printStackTrace();
        } finally {
            try {

                conn.close();

            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }

        return listaGastos;
    }

    public ArrayList getIngresos() {

        Connection conn = null;
        Statement st = null;

        ArrayList<Ingreso> listaIngreso = new ArrayList<Ingreso>();

        try {

            conn = conexion.getConexion();

            st = conn.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM INGRESO");

            while (rs.next()) {

                String tipo = rs.getString("TIPO_INGRESO");
                String descripcion = rs.getString("DESCRIPCION_INGRESO");
                String fecha = rs.getString("FECHA_INGRESO");
                double importe = rs.getDouble("IMPORTE_INGRESO");
              
                int id_categoria = rs.getInt("ID_CATEGORIA_INGRESO");

                Ingreso ingreso = new Ingreso(tipo, descripcion, importe, fecha, id_categoria);

                listaIngreso.add(ingreso);

            }

        } catch (Exception e) {

            e.printStackTrace();
        } finally {
            try {

                conn.close();

            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }

        return listaIngreso;
    }

   public ResultSet dameTablaGasto() {

        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {

            conn = conexion.getConexion();

            st = conn.createStatement();

            rs = st.executeQuery("SELECT  G.TIPO_GASTO, C.NOM_CATEGORIA,G.DESCRIPCION_GASTO, G.FECHA_GASTO, G.IMPORTE_GASTO FROM GASTO G, CATEGORIA C WHERE  G.ID_CATEGORIA=C.ID_CATEGORIA");

        } catch (Exception e) {

           e.printStackTrace();
        } 
        return rs;

    }

    public ResultSet dameTablaIngreso() {

        Connection conn=null;
        Statement st = null;
        ResultSet rs = null;
        try {

            conn = conexion.getConexion();

            st = conn.createStatement();

            rs = st.executeQuery("SELECT I.TIPO_INGRESO, C.NOM_CATEGORIA_INGRESO, I.FECHA_INGRESO, I.IMPORTE_INGRESO FROM INGRESO I,  CATEGORIA_INGRESO C  WHERE I.ID_CATEGORIA_INGRESO=C.ID_CATEGORIA_INGRESO");
                                   

        } catch (Exception e) {

            e.printStackTrace();
        }
        return rs;

    }

    public Blob buscarFoto(int gasto) {
        Blob streamFoto = null;
        Connection conn = null;

        PreparedStatement prep = null;
        try {
            conn = conexion.getConexion();

            String sql = "SELECT FOTO_GASTO FROM GASTO WHERE ID_GASTO=?";

            prep = conn.prepareStatement(sql);
            prep.setInt(1, gasto);

            rs = prep.executeQuery();

              while (rs.next()) {
                streamFoto = rs.getBlob("FOTO_GASTO");

            }
                                                                                                                                                                                                      
         

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                prep.close();
               

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return streamFoto;

    }
    
    
    
    public ResultSet leerPDF(int id){
        
        Connection conn =null;
        PreparedStatement ps = null;
        ResultSet rs =null;
       
        
        try{
            
            conn = conexion.getConexion();
            ps = conn.prepareStatement("SELECT FOTO_GASTO FROM GASTO WHERE ID_GASTO=?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
            
            
            
        }catch(Exception e){
            
        }
        return rs;
    }
    
    public ResultSet obtenerProductosPorCriterio(String criterio) {
        
        Connection conn= null;
        Statement st = null;
      
        try {
            conn = conexion.getConexion();
            String sql = "SELECT * FROM CAT_PRODUCTOS WHERE NOM_PROD LIKE '%" + criterio + "%'";/* OR NOM_PROD LIKE '%" + criterio + "%' ORDER BY NOM_PROD";*/
            st = conn.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {

                String idprod = rs.getString("ID_PROD");
                String nomprod = rs.getString("NOM_PROD");
                String idCodigoProve = rs.getString("ID_PROVEEDOR_PROD");
                int stock = rs.getInt("STOCK_PROD");
                double precioCompra = rs.getDouble("PRECIO_COMPRA_PROD");
                double precioVenta = rs.getDouble("PRECIO_VENTA_PROD");
                double existencia = rs.getDouble("EXISTENCIA_PROD");
                int categoria = rs.getInt("ID_CATEGORIA");
                int idProvee = rs.getInt("ID_PROVEEDOR");
                double iva = rs.getInt("IVA");
                double dolar = rs.getDouble("DOLAR");
                double bon1 = rs.getDouble("BON1");
                double bon2 = rs.getDouble("BON2");
                double bon3 = rs.getDouble("BON3");
                double bon4 = rs.getDouble("BON4");
                double flete = rs.getDouble("FLETE");
                double ganancia = rs.getDouble("GANANCIA");

                st.executeUpdate(sql);

                //Producto producto = new Producto(idprod, nomprod, stock, idCodigoProve, null, precioCompra, precioVenta, existencia, categoria, idProvee, iva, dolar, bon1, bon2, bon3, bon4, flete, ganancia);
                //listaProductos.add(producto);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                st.close();
                conn.close();

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        //return listaProductos;
return null;
    }

    
    public void eliminarGasto(Gastos gasto) {
        Connection conn = null;

        PreparedStatement ps = null;

        try {
            conn = conexion.getConexion();

            ps = conn.prepareStatement("DELETE FROM GASTO WHERE ID_GASTO = ?");

            ps.setInt(1, gasto.getId_gasto());

            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error en delete de gasto");

        } finally {
            try {

                ps.close();
                conn.close();

            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }
    }

    public ResultSet dameTablaGastoPorId(String nombrePersonaComboDetalle) {
    
         

        Connection conn = null;
        PreparedStatement ps=null;
        ResultSet rs = null;
        try {

            conn = conexion.getConexion();

            ps = conn.prepareStatement("SELECT ID_GASTO,NOM_PERSONA,TIPO_GASTO,NOM_CATEGORIA,DESCRIPCION_GASTO,FECHA_GASTO,IMPORTE_GASTO,FOTO_GASTO FROM GASTO INNER JOIN PERSONA ON GASTO.ID_PERSONA=PERSONA.ID_PERSONA INNER JOIN CATEGORIA ON GASTO.ID_CATEGORIA=CATEGORIA.ID_CATEGORIA WHERE NOM_PERSONA=?");

            ps.setString(1, nombrePersonaComboDetalle);

            rs = ps.executeQuery();

            
        } catch (Exception e) {

            System.out.println("Error en select INGRESO");
        } 
        return rs;

    }
    
      public ResultSet selectSumaGasto(String nombrePersonaComboDetalle) {
    
         

        Connection conn = null;
        PreparedStatement ps=null;
        ResultSet rs = null;
        try {

            conn = conexion.getConexion();

            ps = conn.prepareStatement("SELECT SUM(IMPORTE_GASTO) AS IMPORTE_GASTO FROM GASTO INNER JOIN PERSONA ON GASTO.ID_PERSONA=PERSONA.ID_PERSONA WHERE NOM_PERSONA=?");


            
            ps.setString(1, nombrePersonaComboDetalle);

            rs = ps.executeQuery();

            
        } catch (Exception e) {

            System.out.println("Error en select INGRESO");
        } 
        return rs;

    }


}