/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package De1.Cau1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Neik
 */
public class Server {

    private int PORT = 12345;
    private ServerSocket serverSocket;
    private Socket socket;

    public Server() {
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server dang lang nghe tai cong " + PORT);
            socket = serverSocket.accept();
            System.out.println("Da ket noi toi " + socket.getInetAddress());
            DataInputStream din = new DataInputStream(socket.getInputStream());
            DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
            while (true) {
                int a = din.readInt();
                if (a < 0) {
                    return;
                }
                if (a % 2 == 0) {
                    dout.writeBoolean(true);
                } else {
                    dout.writeBoolean(false);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        Server s = new Server();
    }
}
