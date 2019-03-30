/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package De2.Cau2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Neik
 */
public class Client {

    private String HOST = "127.0.0.1";
    private int PORT = 12345;
    private static Socket socket;

    public Client() throws IOException {
        socket = new Socket(HOST, PORT);
        System.out.println("Da ket noi toi server!");
    }

    public static void main(String[] args) throws IOException {
        Client client = new Client();
        DataInputStream din = new DataInputStream(socket.getInputStream());
        DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
        Scanner sc = new Scanner(System.in);
        String n;
        while (true) {
            System.out.println("----------MENU------------");
            System.out.println("1. Them sinh vien");
            System.out.println("2. Tim kiem sinh vien");
            System.out.println("3. Xem danh sach sinh vien");
            System.out.println("4. Tim sinh vien theo que quan");
            System.out.println("5. Tim kien sinh vien theo nam sinh");
            System.out.println("---------------------------");
            System.out.print("Nhap lua chon: ");
            n = sc.nextLine();
            switch (n) {
                case "1":
                    dout.writeUTF("1");
                    String sv = "";
                    System.out.print("Nhap ho ten sinh vien: ");
                    sv += sc.nextLine() + "$";
                    System.out.print("Nhap ngay sinh: ");
                    sv += sc.nextLine() + "$";
                    System.out.print("Nhap ma sinh vien: ");
                    sv += sc.nextLine() + "$";
                    System.out.print("Nhap que quan: ");
                    sv += sc.nextLine();
                    dout.writeUTF(sv);
                    break;
                case "2":
                    dout.writeUTF("2");
                    System.out.print("Nhap ten sinh vien can tim kiem: ");
                    String tenSv = sc.nextLine();
                    dout.writeUTF(tenSv);
                    String sinhVienTimKiem = din.readUTF();
                    System.out.println("\nDANH SACH SINH VIEN: ");
                    System.out.println(sinhVienTimKiem);
                    break;
                case "3":
                    dout.writeUTF("3");
                    System.out.println("\nDANH SACH SINH VIEN: ");
                    String danhSach = din.readUTF();
                    System.out.println(danhSach);
                    break;
                case "4":
                    dout.writeUTF("4");
                    System.out.print("Nhap que quan sinh vien: ");
                    String queQuan = sc.nextLine();
                    dout.writeUTF(queQuan);
                    String sinhVienTheoQue = din.readUTF();
                    System.out.println("\nDANH SACH SINH VIEN: ");
                    System.out.println(sinhVienTheoQue);
                    break;
                case "5":
                    dout.writeUTF("5");
                    System.out.println("Nhap nam sinh sinh vien: ");
                    String namSinh = sc.nextLine();
                    dout.writeUTF(namSinh);
                    String sinhVienTheoNamSinh = din.readUTF();
                    System.out.println("\nDANH SACH SINH VIEN: ");
                    System.out.println(sinhVienTheoNamSinh);
                    break;
                case "0":
                    dout.writeUTF("0");
                    return;
                default:
                    System.out.println("Gia tri nhap khong hop le!!");
            }

        }
    }
}
