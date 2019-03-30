/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package De1.Cau2;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Neik
 */
public class Dictionaries extends UnicastRemoteObject implements Dictionary{

    private TuDien t = new TuDien();
    public Dictionaries() throws RemoteException {
        super();
    }
    
    @Override
    public String Viet_Anh(String s) throws RemoteException {
        for(Word word : t.getTuDien()) {
            if(word.getVietnamese().equals(s))
                return word.getEnglish();
        }
        return "";
    }

    @Override
    public String Anh_Viet(String s) throws RemoteException {
        for(Word word: t.getTuDien()) {
            if(word.getEnglish().equals(s)) 
                return word.getVietnamese();
        }
        return "";
    }

    @Override
    public String meaning(String s) throws RemoteException {
        for(Word word : t.getTuDien()) {
            if(word.getEnglish().equals(s))
                return word.getMeaning();
        }
        return "";
    }
}
