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

/**
 *
 * @author Neik
 */
public class Server {

    private static DatagramSocket socket;
    private static DatagramPacket dataPack;
    private static DieuKhien dieuKhien;
    private final int SERVER_PORT = 12345;
    private static InetAddress CLIENT_HOST;
    private static int CLIENT_PORT;
    private static byte[] buffer;

    public Server() throws SocketException {
        dieuKhien = new DieuKhien();
        socket = new DatagramSocket(SERVER_PORT);
        System.out.println("Server dang lang nghe tai cong " + SERVER_PORT);
    }

    public static void main(String[] args) throws IOException {
        Server server = new Server();
        int flag = 0;

        buffer = new byte[256];
        dataPack = new DatagramPacket(buffer, buffer.length);
        socket.receive(dataPack);
        CLIENT_HOST = dataPack.getAddress();
        CLIENT_PORT = dataPack.getPort();
        String[] taikhoan = (new String(dataPack.getData(), 0, dataPack.getLength())).split("\\$");
        String checkLogin = dieuKhien.dangNhap(taikhoan[0], taikhoan[1]);
        buffer = new byte[256];
        buffer = checkLogin.getBytes();
        dataPack = new DatagramPacket(buffer, buffer.length, CLIENT_HOST, CLIENT_PORT);
        socket.send(dataPack);
        while (true && checkLogin.equals("1")) {
            buffer = new byte[256];
            dataPack = new DatagramPacket(buffer, buffer.length);
            socket.receive(dataPack);
            String mess = String.format("%20s", new String(dataPack.getData(), 0, dataPack.getLength()));
            System.out.println(mess);
            if (flag == 0) {
                new ThreadMessage(socket, dataPack).start();
                flag = 1;
            }
        }
    }
}
