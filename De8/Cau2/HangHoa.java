/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package De8.Cau2;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Neik
 */
public interface HangHoa extends Remote{
    public String chonHang() throws RemoteException;
    public int checkHang(int giaHang) throws RemoteException;
}
