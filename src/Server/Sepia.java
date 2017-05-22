/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;

/**
 *
 * @author dominiq
 */
public class Sepia extends Effect{
    

    public Sepia(BufferedImage tmp){
            
        super(tmp);
    }
    
    void setEffect(){
        
    int sepiaIntensity=30;
    int sepiaDepth = 20;

    int w = img.getWidth();
    int h = img.getHeight();

    WritableRaster raster = img.getRaster();
    int[] pixels = new int[w*h*3];
    raster.getPixels(0, 0, w, h, pixels);

     for (int i=0;i<pixels.length; i+=3){
         
         int r = pixels[i];
         int g = pixels[i+1];
         int b = pixels[i+2];

         int gry = (r + g + b) / 3;
         r = g = b = gry;
         r = r + (sepiaDepth * 2);
         g = g + sepiaDepth;

         if (r>255) r=255;
         if (g>255) g=255;
         if (b>255) b=255;

         b-= sepiaIntensity;

         if (b<0) b=0;
         if (b>255) b=255;

         pixels[i] = r;
         pixels[i+1]= g;
         pixels[i+2] = b;
    }
     
    raster.setPixels(0, 0, w, h, pixels);
    }
}
