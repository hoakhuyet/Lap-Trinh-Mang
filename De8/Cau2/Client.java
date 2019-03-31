/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package De8.Cau2;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

/**
 *
 * @author Neik
 */
public class Client {

    private static HangHoa hangHoa;
    private final String HOST = "127.0.0.1";
    private final int PORT = 12345;
    private Registry reg;

    public Client() throws RemoteException, NotBoundException {
        reg = LocateRegistry.getRegistry(HOST, PORT);
        hangHoa = (HangHoa) reg.lookup("haychonradung");
    }

    public static void main(String[] args) throws RemoteException, NotBoundException {
        Client client = new Client();
        Scanner sc = new Scanner(System.in);
        System.out.println(hangHoa.chonHang());
        int count = 0;
        while (true) {
            count++;
            System.out.print("Nhap gia du doan cua ban: ");
            int giaHang = Integer.parseInt(sc.nextLine());
            int c = hangHoa.checkHang(giaHang);
            if (c == 1) {
                System.out.println("Gia su doan cao!");
            } else if (c == -1) {
                System.out.println("Gia du doan thap!");
            } else {
                System.out.println("Ban du doan chinh xac!");
                return;
            }
            if (count > 7) {
                return;
            }
        }
    }
}
