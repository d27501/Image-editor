package rmi;

import Client.Picture;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author David
 */  
public interface RMIInterface extends Remote{
   
    public Picture sendreceive(Picture o) throws RemoteException;
  

}