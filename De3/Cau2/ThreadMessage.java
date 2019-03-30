/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package De3.Cau2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Neik
 */
public class ThreadMessage extends Thread {

    private DatagramSocket socket;
    private DatagramPacket dataPack;
    private InetAddress CLIENT_HOST;
    private int CLIENT_PORT;
    private byte[] buffer;

    public ThreadMessage(DatagramSocket socket, DatagramPacket dataPack) {
        this.socket = socket;
        this.dataPack = dataPack;
        this.CLIENT_HOST = dataPack.getAddress();
        this.CLIENT_PORT = dataPack.getPort();
    }

    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        System.out.println("--------------------");
        while (true) {
            String mess = sc.nextLine();
            buffer = new byte[256];
            buffer = mess.getBytes();
            dataPack = new DatagramPacket(buffer, buffer.length, CLIENT_HOST, CLIENT_PORT);
            try {
                socket.send(dataPack);
            } catch (IOException ex) {
                Logger.getLogger(ThreadMessage.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
