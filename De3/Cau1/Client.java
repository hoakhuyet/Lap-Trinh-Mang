/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package De3.Cau1;

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

    private static Socket socket;
    private final String HOST = "127.0.0.1";
    private final int PORT = 12345;

    public Client() throws IOException {
        socket = new Socket(HOST, PORT);
        System.out.println("Da ket noi toi Server!");
    }

    public static void main(String[] args) throws IOException {
        Client client = new Client();
        Scanner sc = new Scanner(System.in);
        DataInputStream din = new DataInputStream(socket.getInputStream());
        DataOutputStream dout = new DataOutputStream(socket.getOutputStream());

        System.out.print("Nhap n = ");
        try {
            int n = Integer.parseInt(sc.nextLine());
            if(n < 0) {
                System.out.println("Gia tri nhap khong hop le!");
                dout.writeInt(-1);
            } else {
                dout.writeInt(n);
                
                int giaiThua = din.readInt();
                System.out.println(n + "! = " + giaiThua);
            }
        } catch (NumberFormatException ex) {
            System.out.println("Gia tri nhap khong hop le!");
            dout.writeInt(-1);
        }

    }
}
