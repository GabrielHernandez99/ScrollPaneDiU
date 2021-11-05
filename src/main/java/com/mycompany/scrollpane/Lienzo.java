/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.scrollpane;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Entrar
 */
public class Lienzo extends JPanel {
    private BufferedImage imagen;

    public Lienzo(){
        try{
            imagen=ImageIO.read(new URL("https://static.wikia.nocookie.net/lossimpson/images/b/bd/Homer_Simpson.png/revision/latest?cb=20100522180809&path-prefix=es"));
        } catch (IOException ex){
            System.out.println("error"+ ex);
        }
    }
    
@Override
public void paint(Graphics g){
    this.setPreferredSize(new Dimension (imagen.getWidth(),imagen.getHeight()));
    super.paint(g);
    g.drawImage(imagen, 0, 0, null);
    repaint();
    }
}
