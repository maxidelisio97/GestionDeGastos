/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;


public class Categoria_ingreso {

    public Categoria_ingreso(String nom_categoria_ingreso) {
        this.nom_categoria_ingreso = nom_categoria_ingreso;
    }

    public Categoria_ingreso(int id_categoria_ingreso, String nom_categoria_ingreso) {
        this.id_categoria_ingreso = id_categoria_ingreso;
        this.nom_categoria_ingreso = nom_categoria_ingreso;
    }

    public Categoria_ingreso(int id_categoria_ingreso) {
        this.id_categoria_ingreso = id_categoria_ingreso;
    }

    
   

    public int getId_categoria_ingreso() {
        return id_categoria_ingreso;
    }

    public void setId_categoria_ingreso(int id_categoria_ingreso) {
        this.id_categoria_ingreso = id_categoria_ingreso;
    }

    public String getNom_categoria_ingreso() {
        return nom_categoria_ingreso;
    }

    public void setNom_categoria_ingreso(String nom_categoria_ingreso) {
        this.nom_categoria_ingreso = nom_categoria_ingreso;
    }

    @Override
    public String toString() {
        return  nom_categoria_ingreso;
    }
  
    
    private int id_categoria_ingreso;
    private String nom_categoria_ingreso;
    
}
