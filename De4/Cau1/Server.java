/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package De4.Cau1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 *
 * @author Neik
 */
public class Server {

    private static DatagramSocket socket;
    private static DatagramPacket dataPack;
    private static InetAddress CLIENT_HOST;
    private static int PORT = 12345;
    private static int CLIENT_PORT = 12345;

    private static byte[] buffer;

    public Server() throws SocketException {
        socket = new DatagramSocket(PORT);
        System.out.println("Server dang lang nghe tai " + PORT);
        buffer = new byte[256];
    }

    public static void main(String[] args) throws IOException {
        Server server = new Server();
        dataPack = new DatagramPacket(buffer, buffer.length);
        socket.receive(dataPack);

        CLIENT_HOST = dataPack.getAddress();
        CLIENT_PORT = dataPack.getPort();

        System.out.println(new String(dataPack.getData(), 0, dataPack.getLength()));
    }
}
