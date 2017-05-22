/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author dominiq
 */
public class Picture_IO {

    Picture openPicture(){
        
        JFileChooser fileChooser = new JFileChooser();
        Picture tmp = null;
        
        if(fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
            
            try {
                tmp = new Picture(ImageIO.read(fileChooser.getSelectedFile()));              
            } catch (IOException ex) {
                Logger.getLogger(Picture_IO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }       
        return tmp;
    }
    
    public void savePicture(Picture result){
        
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Zapisz");
        fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Image files",new String[] { "png", "jpg", "jpeg", "gif" }));
        if(fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION){
            try {
                ImageIO.write(result.getImage(), "jpg", fileChooser.getSelectedFile());
            } catch (IOException ex) {
                Logger.getLogger(ClientGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
