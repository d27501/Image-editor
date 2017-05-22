package Server;

import Client.Picture;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;
import rmi.RMIInterface;

/**
 *
 * @author David
 */  
public class ServerRMI extends UnicastRemoteObject implements RMIInterface{
    
    Database baza1;
    public ServerRMI() throws RemoteException {
        super();
        
        try {
            baza1 = new Database("jdbc:postgresql://localhost/postgres", "postgres", "admin");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ServerRMI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Start(int port,String serverName) {
        try {
            Registry reg = LocateRegistry.createRegistry(port);
            reg.rebind(serverName, new ServerRMI());
            System.out.println("Server uruchomiony");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
  
    @Override
    public Picture sendreceive(Picture o) throws RemoteException{
        
        if(o.id <=0){
            o.id = baza1.insertOriginalPicture(o);
        }
        Picture tmp;
        
        Effect e;
        
        switch(o.mod_type){
            case 1: 
                tmp = baza1.getPicture(o);
                if(tmp == null){
                    e  = new Sepia(o.getImage());
                    e.setEffect();
                    tmp = new Picture(e.getImage(), o.id, o.mod_type);
                    baza1.insertModifiedPicture(tmp);
                    return tmp;
                }else{
                    return tmp;
                }
                
            case 2:
                tmp = baza1.getPicture(o);
                if(tmp == null){
                    e = new Thresholding(o.getImage());
                    e.setEffect();
                    tmp = new Picture(e.getImage(), o.id, o.mod_type);
                    baza1.insertModifiedPicture(tmp);
                    return tmp;
                }else{
                    return tmp;
                }
                
            case 3:
                tmp = baza1.getPicture(o);
                if(tmp == null){
                    e = new GrayScale(o.getImage());
                    e.setEffect();
                    tmp = new Picture(e.getImage(), o.id, o.mod_type);
                    baza1.insertModifiedPicture(tmp);
                    return tmp;
                }else{
                    return tmp;
                }               
                
            case 4:
                tmp = baza1.getPicture(o);
                if(tmp == null){
                    e = new Mirror(o.getImage());
                    e.setEffect();
                    tmp = new Picture(e.getImage(), o.id, o.mod_type);
                    baza1.insertModifiedPicture(tmp);
                    return tmp;
                }else{
                    return tmp;
                }
 
                
            case 5:
                tmp = baza1.getPicture(o);
                if(tmp == null){
                    e = new Negative(o.getImage());
                    e.setEffect();
                    tmp = new Picture(e.getImage(), o.id, o.mod_type);
                    baza1.insertModifiedPicture(tmp);
                    return tmp;
                }else{
                    return tmp;
                }
                
            default:
                return o;
        }  
    }

    
   public static void main(String args[]){
        try {
            ServerRMI server = new ServerRMI();
            server.Start(2000,"ServerRMI");
        } catch (RemoteException ex) {
            Logger.getLogger(ServerRMI.class.getName()).log(Level.SEVERE, null, ex);
        }
   }   
}