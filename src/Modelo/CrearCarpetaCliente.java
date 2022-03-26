/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.File;

public class CrearCarpetaCliente  {

    public CrearCarpetaCliente(String rutaDirectorio){
        
        directorio = new File(rutaDirectorio);
        directorio.mkdir();
        
    }
    private File directorio;
    
}

