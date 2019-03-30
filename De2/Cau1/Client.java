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
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Neik
 */
public class Client {

    private static DatagramSocket socket;
    private static int PORT = 12345;
    private static InetAddress HOST;
    static Scanner sc;

    public Client() throws UnknownHostException {
        sc = new Scanner(System.in);
        HOST = InetAddress.getByName("127.0.0.1");
        try {
            socket = new DatagramSocket();
        } catch (SocketException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) throws IOException {
        Client c = new Client();
        try {
            System.out.print("Nhap so thu nhat: ");
            Integer a = Integer.parseInt(sc.nextLine());
            System.out.print("Nhap so thu hai: ");
            Integer b = Integer.parseInt(sc.nextLine());

            byte[] buffer = new byte[256];
            buffer = a.toString().getBytes();
            DatagramPacket dataPack = new DatagramPacket(buffer, buffer.length, HOST, PORT);
            socket.send(dataPack);
            buffer = b.toString().getBytes();
            dataPack = new DatagramPacket(buffer, buffer.length, HOST, PORT);
            socket.send(dataPack);

            dataPack = new DatagramPacket(buffer, buffer.length);
            socket.receive(dataPack);
            String mul = new String(dataPack.getData(), 0, dataPack.getLength());
            System.out.println("Ket qua phep nhan la: " + mul);
        } catch (NumberFormatException ex) {
            
        }
    }
}
