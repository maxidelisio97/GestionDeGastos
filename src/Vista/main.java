
package Vista;

import Controlador.ControladorEvento;
import Modelo.BaseDatos;
import java.awt.Color;
import javax.swing.UIManager;
import mdlaf.MaterialLookAndFeel;
import mdlaf.themes.JMarsDarkTheme;
import mdlaf.themes.MaterialLiteTheme;
import mdlaf.themes.MaterialOceanicTheme;


public class main {
    
    public static void main(String[] args) {
         try{
            
            UIManager.setLookAndFeel(new MaterialLookAndFeel(new MaterialOceanicTheme()));
            
            		UIManager.put("Table.alternateRowColor", true);
		UIManager.put("Table.alternateRowBackground", Color.RED);
                
        }catch(Exception e){
            
        }
        vistaPrincipal marco =new vistaPrincipal();
        marco.setVisible(true);
       
        BaseDatos bd = new BaseDatos();
      
        
        ControladorEvento controlador = new ControladorEvento(marco,bd);
        
        
        
     
    }    
}
