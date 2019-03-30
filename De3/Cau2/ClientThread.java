/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package De3.Cau2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Neik
 */
public class ClientThread extends Thread {

    private DatagramSocket socket;
    private DatagramPacket dataPack;
    private byte[] buffer;

    public ClientThread(DatagramSocket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        while (true) {
            buffer = new byte[256];
            dataPack = new DatagramPacket(buffer, buffer.length);
            try {
                socket.receive(dataPack);
                String mess = String.format("%20s", new String(dataPack.getData(), 0, dataPack.getLength()));
                System.out.println(mess);
            } catch (IOException ex) {
                Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
