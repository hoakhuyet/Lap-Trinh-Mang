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

/**
 *
 * @author Neik
 */
public class Server {

    private static DatagramSocket socket;
    private static DatagramPacket dataPack;
    private final int SERVER_PORT = 12345;
    private static InetAddress CLIENT_HOST;
    private static int CLIENT_PORT;
    private static byte[] buffer;
    private static QuanLySach quanLy;

    public Server() throws SocketException {
        quanLy = new QuanLySach();
        socket = new DatagramSocket(SERVER_PORT);
        System.out.println("Server dang lang nghe tai cong " + SERVER_PORT);
        buffer = new byte[512];
    }

    public static void main(String[] args) throws SocketException, IOException {
        Server server = new Server();

        while (true) {
            dataPack = new DatagramPacket(buffer, buffer.length);
            socket.receive(dataPack);
            CLIENT_HOST = dataPack.getAddress();
            CLIENT_PORT = dataPack.getPort();

            String n = new String(dataPack.getData(), 0, dataPack.getLength());
            switch (n) {
                case "1":
                    buffer = new byte[512];
                    buffer = quanLy.xemDanhSach().getBytes();
                    System.out.println(quanLy.xemDanhSach());
                    dataPack = new DatagramPacket(buffer, buffer.length, CLIENT_HOST, CLIENT_PORT);
                    socket.send(dataPack);
                    break;
                case "2":
                    buffer = new byte[512];
                    dataPack = new DatagramPacket(buffer, buffer.length);
                    socket.receive(dataPack);
                    String idMuon = new String(dataPack.getData(), 0, dataPack.getLength());

                    buffer = new byte[256];
                    buffer = quanLy.muonSach(idMuon).getBytes();
                    dataPack = new DatagramPacket(buffer, buffer.length, CLIENT_HOST, CLIENT_PORT);
                    socket.send(dataPack);
                    break;
                case "3":
                    buffer = new byte[512];
                    dataPack = new DatagramPacket(buffer, buffer.length);
                    socket.receive(dataPack);
                    String idTra = new String(dataPack.getData(), 0, dataPack.getLength());

                    buffer = new byte[256];
                    buffer = quanLy.traSach(idTra).getBytes();
                    dataPack = new DatagramPacket(buffer, buffer.length, CLIENT_HOST, CLIENT_PORT);
                    socket.send(dataPack);
                    break;
                case "0":
                    return;
            }
        }

    }
}
