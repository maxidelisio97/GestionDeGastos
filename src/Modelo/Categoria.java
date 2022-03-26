/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;


public class Categoria {
    
    public Categoria(){
        
        
    }

    public Categoria(String nom_categoria, int id_categoria) {
        this.nom_categoria = nom_categoria;
        this.id_categoria = id_categoria;
    }

    
    public Categoria(String nom_categoria) {
        this.nom_categoria = nom_categoria;
    }

    public Categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getNom_categoria() {
        return nom_categoria;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public void setNom_categoria(String nom_categoria) {
        this.nom_categoria = nom_categoria;
    }

    @Override
    public String toString() {
        return  nom_categoria;
    }

  
    private String nom_categoria;
    private int id_categoria;
}
