/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package De3.Cau1;

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

    private static ServerSocket serverSocket;
    private static Socket socket;
    private final int PORT = 12345;

    public Server() throws IOException {
        serverSocket = new ServerSocket(PORT);
        System.out.println("Server dang lang nghe tai cong " + PORT);
    }

    public static void main(String[] args) throws IOException {
        Server server = new Server();
        socket = serverSocket.accept();
        System.out.println("Da ket noi toi " + socket.getInetAddress());
        DataInputStream din = new DataInputStream(socket.getInputStream());
        DataOutputStream dout = new DataOutputStream(socket.getOutputStream());

        int n = din.readInt();
        if(n < 0) {
            return;
        }
        int giaiThua = 1;
        for (int i = 1; i <= n; i++) {
            giaiThua *= i;
        }
        dout.writeInt(giaiThua);
    }
}
