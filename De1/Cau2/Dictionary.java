/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package De1.Cau2;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Neik
 */
public interface Dictionary extends Remote{
    public String Viet_Anh(String s) throws RemoteException;
    public String Anh_Viet(String s) throws RemoteException;
    public String meaning(String s) throws RemoteException;
}
