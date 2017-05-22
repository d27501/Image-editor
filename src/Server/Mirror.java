/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.awt.image.BufferedImage;

/**
 *
 * @author dominiq
 */
public class Mirror extends Effect{
    
    
    public Mirror(BufferedImage tmp){
        
        super(tmp);
    }
    
    void setEffect(){
        
        int width = img.getWidth();
        int height = img.getHeight();
    
        BufferedImage mimg = new BufferedImage(width*2, height, BufferedImage.TYPE_INT_ARGB);
    
        for(int y = 0; y < height; y++){
             for(int lx = 0, rx = width*2 - 1; lx < width; lx++, rx--){
        
                int p = img.getRGB(lx, y);
                mimg.setRGB(lx, y, p);
                mimg.setRGB(rx, y, p);
            }
        }
        img = mimg;
    }
}
