package Modelo;

import java.util.Date;

public class Ingreso {

    public Ingreso() {

    }

    public Ingreso(String tipo_ingreso, String desc_ingreso, double importe_ingreso, String fecha_ingreso,  int id_categoria_ingreso) {
         this.tipo_ingreso = tipo_ingreso;

        this.desc_ingreso = desc_ingreso;
        this.importe_ingreso = importe_ingreso;
        this.fecha_ingreso = fecha_ingreso;
      
        this.id_categoria_ingreso = id_categoria_ingreso;
    }
    
    
    
    

    public String getTipo_ingreso() {
        return tipo_ingreso;
    }

    public void setTipo_ingreso(String tipo_ingreso) {
        this.tipo_ingreso = tipo_ingreso;
    }

    public String getDesc_ingreso() {
        return desc_ingreso;
    }

    public void setDesc_ingreso(String desc_ingreso) {
        this.desc_ingreso = desc_ingreso;
    }

    public double getImporte_ingreso() {
        return importe_ingreso;
    }

    public void setImporte_ingreso(double importe_ingreso) {
        this.importe_ingreso = importe_ingreso;
    }

    public String getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(String fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public int getId_persona() {
        return id_persona;
    }

    public void setId_persona(int id_persona) {
        this.id_persona = id_persona;
    }

    public int getId_categoria_ingreso() {
        return id_categoria_ingreso;
    }

    public void setId_categoria_ingreso(int id_categoria) {
        this.id_categoria_ingreso = id_categoria;
    }

    private String tipo_ingreso;
    private String desc_ingreso;
    private double importe_ingreso;
    private String fecha_ingreso;
    private int id_persona;
    private int id_categoria_ingreso;

}
