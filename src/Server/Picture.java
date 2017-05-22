/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author dominiq
 */
public class Picture implements java.io.Serializable{
    
    public byte[] tab;
    public int mod_type;
    public int id;
    public String date;
    
    public Picture(BufferedImage tmp){
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            javax.imageio.ImageIO.write(tmp, "jpg", out);
            this.tab = out.toByteArray();
            this.id = 0;
        } catch (IOException ex) {
            Logger.getLogger(Picture.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Picture(BufferedImage tmp, int id){
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            javax.imageio.ImageIO.write(tmp, "jpg", out);
            this.tab = out.toByteArray();
            this.id = id;
        } catch (IOException ex) {
            Logger.getLogger(Picture.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Picture(BufferedImage tmp, int id, int mod_type){
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            javax.imageio.ImageIO.write(tmp, "jpg", out);
            this.tab = out.toByteArray();
            this.id = id;
            this.mod_type = mod_type;
        } catch (IOException ex) {
            Logger.getLogger(Picture.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public Picture(byte [] tab, int id, int mod_type){
       
            this.tab = tab;  
            this.id = id;
            this.mod_type = mod_type;
    }
    
    
    
    public BufferedImage getImage(){
        
        try {         
            ByteArrayInputStream bais = new ByteArrayInputStream(tab);
            return ImageIO.read(bais);     
        } catch (IOException ex) {
            Logger.getLogger(Picture.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void setBytesTab(byte[] tab){
        this.tab = tab;
    }
}
