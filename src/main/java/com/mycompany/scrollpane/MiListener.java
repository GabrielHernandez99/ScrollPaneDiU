/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.scrollpane;

import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.io.File;
import javax.swing.JViewport;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

/**
 *
 * @author jorge
 */
public class MiListener implements AdjustmentListener{
    private File file;
    private JViewport vp;
    @Override
    public void adjustmentValueChanged(AdjustmentEvent arg0) {
        EstadisticasImagen.calculaEstadisticas(toMat(), vp.getViewPosition(),vp.getExtentSize());
        MainFrame.refreshStats();
    }
    
    private Mat toMat(){
        
         Mat mat= Imgcodecs.imread(file.getAbsolutePath()); 
         return mat;
    }
    public void setViewPort(JViewport vp){
        this.vp=vp;
    }
    public void setFile(File file){
       this.file=file;
    }
}