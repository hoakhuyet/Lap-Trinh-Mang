/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package De1.Cau1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Neik
 */
public class Client {

    private String HOST = "127.0.0.1";
    private int PORT = 12345;
    private Socket socket;
    Scanner sc = new Scanner(System.in);

    public Client() {
        try {
            socket = new Socket(HOST, PORT);
            System.out.println("Da ket noi toi Server!");
            DataInputStream din = new DataInputStream(socket.getInputStream());
            DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
            while (true) {
                System.out.print("Nhap mot so nguyen duong bat ky: ");
                try {
                    int a = Integer.parseInt(sc.nextLine());
                    if (a < 0) {
                        System.out.println("So nhap phai lon hon 0!");
                        dout.writeInt(-1);
                        return;
                    }
                    dout.writeInt(a);
                    if (din.readBoolean()) {
                        System.out.println("So ban vua nhap la so chan!");
                    } else {
                        System.out.println("So ban vua nhap la so le!");
                    }
                } catch (NumberFormatException ex) {
                    System.out.println("So ban vua nhap khong hop le!");
                    dout.writeInt(-2);
                    return;
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        Client c = new Client();
    }
}
