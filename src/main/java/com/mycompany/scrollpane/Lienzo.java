package com.mycompany.scrollpane;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 *
 * @author jorge
 */
public class Lienzo extends JPanel {
    private static BufferedImage imagen=null;
    @Override
    public void paintComponent(Graphics g){
        
        if(imagen!=null){
             this.setPreferredSize(new Dimension(imagen.getWidth(),imagen.getHeight()));
        }
     
       
        super.paintComponent(g);
        g.drawImage(imagen,0,0,null);
         
        
    }
    public static void setImage(BufferedImage imagen){
        Lienzo.imagen=imagen;
    }
    public static BufferedImage getImage(){
        return imagen;
    }
    public static void removeImage(){
        imagen=null;
    }
}
