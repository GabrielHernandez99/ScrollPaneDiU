/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.scrollpane;


import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import org.opencv.core.Core;
import static org.opencv.core.Core.mean;
import static org.opencv.core.Core.minMaxLoc;
import static org.opencv.core.Core.split;
import org.opencv.core.Mat;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
/**
 *
 * @author jorge
 */

public class EstadisticasImagen {

    public final int fAzul = 0;
    public final int fVerde = 1;
    public final int fRojo = 2;

    private final int[] Componentes = {fRojo, fVerde, fAzul};

    private static int maximo[] = new int[3];
    private static int minimo[] = new int[3];
    private static int promedio[] = new int[3];
    
    public static int[] getMinimo() {
        return minimo;
    }

    public static int[] getPromedio() {
        return promedio;
    }
    public static int[] getMaximo() {
        return maximo;
    }

   

    public static void calculaEstadisticas(Mat imagenColor, Point esqSupIzda,
            Dimension dimVista) {

        // crea la imagen actual del viewport
        Mat Simagen = new Mat(imagenColor, new Rect(esqSupIzda.x, esqSupIzda.y,
                dimVista.width, dimVista.height));

        // separa canales
        ArrayList<Mat> bgr = new ArrayList<>();
        split(Simagen, bgr);

      
        EstadisticasImagen res = new EstadisticasImagen();

        for (int c : res.Componentes) {
            //máximo y mínimo del canal c de la Simagen
            Core.MinMaxLocResult minmax = minMaxLoc(bgr.get(c));
            //premodio del canal c de la Simagen
            Scalar prom_scalar = mean(bgr.get(c));

            EstadisticasImagen.maximo[c] = (int) minmax.maxVal;
            EstadisticasImagen.minimo[c] = (int) minmax.minVal;
            EstadisticasImagen.promedio[c] = (int) prom_scalar.val[0];
        }
    }

}