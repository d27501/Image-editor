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
public class GrayScale extends Effect{
    

    public GrayScale(BufferedImage tmp){
        
        super(tmp);
    }
    
    @Override
    void setEffect(){
        
        int width = img.getWidth();
        int height = img.getHeight();

        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                 int p = img.getRGB(x,y);

                 int a = (p>>24)&0xff;
                 int r = (p>>16)&0xff;
                 int g = (p>>8)&0xff;
                 int b = p&0xff;

                 int avg = (r+g+b)/3;

                 p = (a<<24) | (avg<<16) | (avg<<8) | avg;

                 img.setRGB(x, y, p);
            }
        }
    }
    
}
