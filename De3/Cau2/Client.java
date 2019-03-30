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
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 *
 * @author Neik
 */
public class Client {

    private static DatagramSocket socket;
    private static DatagramPacket dataPack;
    private static byte[] buffer;
    private static InetAddress SERVER_HOST;
    private static int SERVER_PORT;

    public Client() throws SocketException, UnknownHostException {
        socket = new DatagramSocket();
        SERVER_PORT = 12345;
        SERVER_HOST = InetAddress.getByName("127.0.0.1");
    }

    public static void main(String[] args) throws IOException {
        Client client = new Client();
        Scanner sc = new Scanner(System.in);
        System.out.print("username: ");
        String username = sc.nextLine();
        System.out.print("password: ");
        String password = sc.nextLine();

        buffer = new byte[256];
        buffer = (username + "$" + password).getBytes();
        dataPack = new DatagramPacket(buffer, buffer.length, SERVER_HOST, SERVER_PORT);
        socket.send(dataPack);

        buffer = new byte[256];
        dataPack = new DatagramPacket(buffer, buffer.length);
        socket.receive(dataPack);
        String loginCheck = new String(dataPack.getData(), 0, dataPack.getLength());
        if (!loginCheck.equals("0")) {
            System.out.println("Dang nhap thanh cong!");
            System.out.println("----------------------");
        } else {
            System.out.println("Dang nhap that bai!");
            return;
        }
        int flag = 1;
        while (true) {
            String mess = sc.nextLine();
            buffer = new byte[256];
            buffer = mess.getBytes();
            dataPack = new DatagramPacket(buffer, buffer.length, SERVER_HOST, SERVER_PORT);
            socket.send(dataPack);
            if (flag == 1) {
                new ClientThread(socket).start();
                flag = 0;
            }
        }
    }
}
