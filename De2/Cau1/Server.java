/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package De2.Cau1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Neik
 */
public class Server {

    private int PORT = 12345;
    private static DatagramSocket serverSocket;

    public Server() {
        try {
            serverSocket = new DatagramSocket(PORT);
            System.out.println("Server dang lang nghe tai cong " + PORT);
        } catch (SocketException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) throws IOException {
        Server s = new Server();
        
        byte[] buffer = new byte[256];
        DatagramPacket dataPack = new DatagramPacket(buffer, buffer.length);
        serverSocket.receive(dataPack);
        InetAddress recv_add = dataPack.getAddress();
        int recv_port = dataPack.getPort();
        int a = Integer.parseInt(new String(dataPack.getData(), 0, dataPack.getLength()));
        dataPack = new DatagramPacket(buffer, buffer.length);
        serverSocket.receive(dataPack);
        int b = Integer.parseInt(new String(dataPack.getData(), 0, dataPack.getLength()));

        Integer mul = a * b;
        buffer = mul.toString().getBytes();
        dataPack = new DatagramPacket(buffer, buffer.length, recv_add, recv_port);
        serverSocket.send(dataPack);
    }
}
