/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package De8.Cau2;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author Neik
 */
public class Server {

    private DieuKhien dieuKhien;
    private Registry reg;
    private int PORT = 12345;

    public Server() throws RemoteException, AlreadyBoundException {
        dieuKhien = new DieuKhien();
        reg = LocateRegistry.createRegistry(PORT);
        reg.bind("haychonradung", dieuKhien);
    }
    
    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        Server server = new Server();
    }
}
