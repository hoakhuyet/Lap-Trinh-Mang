/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package De1.Cau2;

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

    private String HOST = "127.0.0.1";
    private int PORT = 12345;
    private Registry reg;
    private static Dictionary dictionary;

    public Client() throws RemoteException, NotBoundException {
        reg = LocateRegistry.getRegistry(HOST, PORT);
        dictionary = (Dictionary) reg.lookup("serverDictionary");
    }

    public static void main(String[] args) throws RemoteException, NotBoundException {
        Client c = new Client();
        Scanner sc = new Scanner(System.in);
        String x = "";
        do {
            System.out.println("-----------MENU-------------");
            System.out.println("1.Viet - Anh");
            System.out.println("2.Anh - Viet");
            System.out.println("3.Nghia tieng Viet");
            System.out.println("0.Thoat");
            System.out.println("------------------------------");
            System.out.print("Nhap lua chon: ");
            x = sc.nextLine();
            switch (x) {
                case "1":
                    System.out.print("Nhap nghia tieng Viet: ");
                    String a = sc.nextLine();
                    System.out.println(a + ": " + dictionary.Viet_Anh(a));
                    break;
                case "2":
                    System.out.print("Nhap nghia tieng Anh: ");
                    String b = sc.nextLine();
                    System.out.println(b + ": " + dictionary.Anh_Viet(b));
                    break;
                case "3":
                    System.out.print("Nhap nghia tieng Anh: ");
                    String d = sc.nextLine();
                    System.out.println(d + ": " + dictionary.meaning(d));
                    break;
                default:
                    System.out.println("Khogn tim thay lua chon!");
            }
        } while (!x.equals("0"));
    }
}
