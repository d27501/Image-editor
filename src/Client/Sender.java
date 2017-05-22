
package Client;


import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import rmi.RMIInterface;


public class Sender {
    
    ClientRMI client;
    RMIInterface rmi;
    
    boolean connectToServer(String ip, int port){
        try {
            client = new ClientRMI(ip, "ServerRMI", port);
            client.connect();
            rmi = client.getRmi();
            JOptionPane.showMessageDialog(null, "Połączono z serwerem.", "Komunikat", JOptionPane.INFORMATION_MESSAGE);
            return true;
       } catch (NotBoundException | RemoteException ex) {
            JOptionPane.showMessageDialog(null, "Błąd logowania.", "Komunikat", JOptionPane.ERROR_MESSAGE);
            java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(Level.SEVERE, null, ex);
            return false;
       }
    }
    
    Picture sendPicture(Picture source){
        
        try {
             Picture tmp = client.getRmi().sendreceive(source);
             if(tmp != null) 
                 return tmp;       
        } catch (RemoteException ex) {
            Logger.getLogger(Sender.class.getName()).log(Level.SEVERE, null, ex);
        }
        return source;
    }
}
