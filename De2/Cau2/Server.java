/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package De2.Cau2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Neik
 */
public class Server {

    private int PORT = 12345;
    private static ServerSocket serverSocket;
    private static Socket socket;
    private static QuanLySinhVien quanLy;

    public Server() throws IOException {
        this.quanLy = new QuanLySinhVien();
        this.serverSocket = new ServerSocket(PORT);
        System.out.println("Server dang lang nghe tai cong " + PORT);
    }

    public static void main(String[] args) throws IOException {
        Server server = new Server();
        socket = serverSocket.accept();
        System.out.println("Da ket noi toi " + socket.getInetAddress());
        DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
        DataInputStream din = new DataInputStream(socket.getInputStream());
        while (true) {
            String n = din.readUTF();
            switch (n) {
                case "1":
                    String[] s = din.readUTF().split("\\$");
                    SinhVien sv = new SinhVien(s[0], s[1], s[2], s[3]);
                    quanLy.themSinhVien(sv);
                    System.out.println("Da them sinh vien vao danh sach!");
                    break;
                case "2":
                    String hoTen = din.readUTF();
                    dout.writeUTF(quanLy.timSinhVien(hoTen));
                    break;
                case "3":
                    dout.writeUTF(quanLy.xemDanhSach());
                    break;
                case "4":
                    String queQuan = din.readUTF();
                    dout.writeUTF(quanLy.timTheoQueQuan(queQuan));
                    break;
                case "5":
                    String namSinh = din.readUTF();
                    dout.writeUTF(quanLy.timTheoNamSinh(namSinh));
                    break;
                case "0":
                    return;
            }
        }
    }
}
