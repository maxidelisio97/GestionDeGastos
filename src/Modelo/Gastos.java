
package Modelo;

import java.io.File;
import java.sql.Date;


public class Gastos {
    
    public Gastos(){
        
        
    }

    public Gastos(String tipo_gasto, String descripcion_gasto, double importe, String fecha_vencimiento_gasto, File foto_gasto, int id_categoria) {
        this.tipo_gasto = tipo_gasto;
        this.descripcion_gasto = descripcion_gasto;
        this.importe = importe;
        this.fecha_vencimiento_gasto = fecha_vencimiento_gasto;
        this.foto_gasto = foto_gasto;
      
        this.id_categoria = id_categoria;
    }

    public Gastos(String tipo_gasto, String descripcion_gasto, double importe, String fecha_vencimiento_gasto,int id_categoria) {
        this.tipo_gasto = tipo_gasto;
        this.descripcion_gasto = descripcion_gasto;
        this.importe = importe;
        this.fecha_vencimiento_gasto = fecha_vencimiento_gasto;
       
        this.id_categoria = id_categoria;
    }

    public Gastos(int id_gasto, String tipo_gasto, String descripcion_gasto, double importe, String fecha_vencimiento_gasto, File foto_gasto, int id_categoria) {
        this.id_gasto = id_gasto;
        this.tipo_gasto = tipo_gasto;
        this.descripcion_gasto = descripcion_gasto;
        this.importe = importe;
        this.fecha_vencimiento_gasto = fecha_vencimiento_gasto;
        this.foto_gasto = foto_gasto;
     
        this.id_categoria = id_categoria;
    }

   

    public int getId_gasto() {
        return id_gasto;
    }

    public void setId_gasto(int id_gasto) {
        this.id_gasto = id_gasto;
    }

    
    
    

    public String getTipo_gasto() {
        return tipo_gasto;
    }

    public void setTipo_gasto(String tipo_gasto) {
        this.tipo_gasto = tipo_gasto;
    }

    public String getDescripcion_gasto() {
        return descripcion_gasto;
    }

    public void setDescripcion_gasto(String descripcion_gasto) {
        this.descripcion_gasto = descripcion_gasto;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public String getFecha_vencimiento_gasto() {
        return fecha_vencimiento_gasto;
    }

    public void setFecha_vencimiento_gasto(String fecha_vencimiento_gasto) {
        this.fecha_vencimiento_gasto = fecha_vencimiento_gasto;
    }

    public File getFoto_gasto() {
        return foto_gasto;
    }

    public void setFoto_gasto(File foto_gasto) {
        this.foto_gasto = foto_gasto;
    }

    public int getId_persona() {
        return id_persona;
    }

    public void setId_persona(int id_persona) {
        this.id_persona = id_persona;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    @Override
    public String toString() {
        return this.tipo_gasto;
    }

   
 
    private int id_gasto;
    private String tipo_gasto;
    private String descripcion_gasto;
    private double importe;
    private String fecha_vencimiento_gasto;
    private File foto_gasto;
    private int id_persona;
    private int id_categoria;
}
