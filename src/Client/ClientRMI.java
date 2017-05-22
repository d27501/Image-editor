package Client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.*;
import rmi.RMIInterface;

  
public class ClientRMI {

    private String address = null, nameServer = null;
    private int port = 0;
    private RMIInterface rmi;
    
    public ClientRMI(String address, String nameServer, int port) {
        this.address = address;
        this.nameServer = nameServer;
        this.port = port;
    }

    public void connect() throws RemoteException, NotBoundException {
        Registry reg = LocateRegistry.getRegistry(address, port);
        rmi = (RMIInterface) reg.lookup(nameServer);
    }
    
    
    public RMIInterface getRmi() {
        return rmi;
    }
   
    
}