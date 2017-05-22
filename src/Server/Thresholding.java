/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.awt.Color;
import java.awt.image.BufferedImage;

/**
 *
 * @author dominiq
 */
public class Thresholding extends Effect{
    

    public Thresholding(BufferedImage tmp){
            
        super(tmp);
    }
    
    private int colorToRGB(int alpha, int red, int green, int blue) {
    	   
        int newPixel = 0;
        newPixel += alpha;
        newPixel = newPixel << 8;
        newPixel += red; 
        newPixel = newPixel << 8;
        newPixel += green; 
        newPixel = newPixel << 8;
        newPixel += blue;
    
        return newPixel;  
    }
    
    void setEffect(){
        
        int alpha, red, green, blue, threshold = 110, newPixel;
        for(int i=0; i<img.getWidth(); i++) {
            for(int j=0; j<img.getHeight(); j++) {
                red = new Color(img.getRGB(i, j)).getRed();
                alpha = new Color(img.getRGB(i, j)).getAlpha();
                if(red > threshold) {
                    newPixel = 255;
                }
                else {
                    newPixel = 0;
                }
                newPixel = colorToRGB(alpha, newPixel, newPixel, newPixel);
                img.setRGB(i, j, newPixel); 
            }
        }       
    }
}
