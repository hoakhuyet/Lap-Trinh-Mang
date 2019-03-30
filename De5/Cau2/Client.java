/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package De5.Cau2;

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
    private static InetAddress SERVER_HOST;
    private static int SERVER_PORT;
    private static byte[] buffer;

    public Client() throws SocketException, UnknownHostException {
        socket = new DatagramSocket();
        SERVER_HOST = InetAddress.getByName("127.0.0.1");
        SERVER_PORT = 12345;
        buffer = new byte[512];
    }

    public static void main(String[] args) throws SocketException, UnknownHostException, IOException {
        Client client = new Client();
        Scanner sc = new Scanner(System.in);
        String n;
        while (true) {
            System.out.println("\n------------MENU-------------");
            System.out.println("1. Xem dach sach thu vien");
            System.out.println("2. Muon Sach");
            System.out.println("3. Tra Sach");
            System.out.println("-------------------------------");
            System.out.print("Nhap lua chon: ");
            n = sc.nextLine();
            if ("1230".contains(n)) {
                buffer = n.getBytes();
                dataPack = new DatagramPacket(buffer, buffer.length, SERVER_HOST, SERVER_PORT);
                socket.send(dataPack);
            }
            switch (n) {
                case "1":
                    buffer = new byte[512];
                    dataPack = new DatagramPacket(buffer, buffer.length);
                    socket.receive(dataPack);
                    String contents = new String(dataPack.getData(), 0, dataPack.getLength());
                    System.out.println("\nDANH SACH THU VIEN:");
                    System.out.println(contents);
                    break;
                case "2":
                    System.out.print("Nhap Id sach can muon: ");
                    String idMuon = sc.nextLine();
                    buffer = new byte[256];
                    buffer = idMuon.getBytes();
                    dataPack = new DatagramPacket(buffer, buffer.length, SERVER_HOST, SERVER_PORT);
                    socket.send(dataPack);

                    buffer = new byte[256];
                    dataPack = new DatagramPacket(buffer, buffer.length);
                    socket.receive(dataPack);
                    String flag = new String(dataPack.getData(), 0, dataPack.getLength());
                    if (flag.equals("1")) {
                        System.out.println("Muon sach thanh cong!");
                    } else if (flag.equals("-1")) {
                        System.out.println("Sach tam thoi dang het!");
                    } else {
                        System.out.println("Khong tim thay sach can muon!");
                    }
                    break;
                case "3":
                    System.out.print("Nhap Id sach can tra: ");
                    String idTra = sc.nextLine();
                    buffer = new byte[256];
                    buffer = idTra.getBytes();
                    dataPack = new DatagramPacket(buffer, buffer.length, SERVER_HOST, SERVER_PORT);
                    socket.send(dataPack);

                    buffer = new byte[256];
                    dataPack = new DatagramPacket(buffer, buffer.length);
                    socket.receive(dataPack);
                    String _flag = new String(dataPack.getData(), 0, dataPack.getLength());
                    if (_flag.equals("1")) {
                        System.out.println("Tra sach thanh cong!");
                    } else {
                        System.out.println("Tra sach that bai!");
                    }
                    break;
                case "0":
                    return;
            }
        }
    }
}
