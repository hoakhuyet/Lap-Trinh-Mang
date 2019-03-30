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
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Neik
 */
public class Client {

    private static DatagramSocket socket;
    private static DatagramPacket dataPack;
    private static InetAddress HOST;
    private static int PORT;
    private static byte[] buffer;
    private static final String str = "qwertyuiopasdfghjklzxcvbnm";

    public Client() throws IOException {
        HOST = InetAddress.getByName("127.0.0.1");
        PORT = 12345;
        socket = new DatagramSocket();
        buffer = new byte[256];
        
    }

    public static void main(String[] args) throws IOException {
        Client client = new Client();
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap mot ky tu bat ky: ");
        String ch = sc.nextLine();
        if (!str.contains(ch) || ch.length() > 1) {
            System.out.println("Ban phai nhap mot ky tu!");
            return;
        } 
        buffer = ch.getBytes();
        dataPack = new DatagramPacket(buffer, buffer.length, HOST, PORT);
        socket.send(dataPack);
        
        buffer = new byte[256];
        dataPack = new DatagramPacket(buffer, buffer.length);
        socket.receive(dataPack);
        System.out.println(ch + ": " + new String(dataPack.getData(), 0, dataPack.getLength()));
    }
}
