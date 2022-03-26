/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.Color;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;




public class Render extends DefaultTableCellRenderer {
    
   

@Override
public Component getTableCellRendererComponent(JTable table,Object value,boolean isSelected,boolean hasFocus,int row, int column){
                                 
       if(value instanceof JButton){
           
           JButton btn = (JButton) value;
           if(isSelected){
               
               btn.setForeground(Color.GREEN);
               
           }else{
            
               btn.setBackground(Color.BLACK);
               btn.setForeground(UIManager.getColor("Button.background"));
           }
           
           return btn;
       } else if(value instanceof ImageIcon){
           
           ImageIcon icono = (ImageIcon) value;
           
       }
        
    return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    
}
}