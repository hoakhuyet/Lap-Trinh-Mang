/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package De8.Cau2;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Neik
 */
public class DieuKhien extends UnicastRemoteObject implements HangHoa {

    private ArrayList<MatHang> danhSachHang;
    private Random random;
    private MatHang temp;

    public DieuKhien() throws RemoteException {
        danhSachHang = new ArrayList<>();
        random = new Random();
        danhSachHang.add(new MatHang("h01", "laptop", 1200));
        danhSachHang.add(new MatHang("h02", "mouse", 250));
        danhSachHang.add(new MatHang("h03", "keyboard", 520));
    }

    @Override
    public String chonHang() throws RemoteException {
        int r = random.nextInt(3);
        temp = danhSachHang.get(r);
        String str = "MAT HANG:\n";
        str += String.format("%-12s%-12s", "MaHang", "TenHang") + "\n";
        str += String.format("%-12s%-12s", temp.getMaHang(), temp.getTenHang()) + "\n";
        return str;
    }

    @Override
    public int checkHang(int giaHang) throws RemoteException {
        if (giaHang > temp.getGiaHang()) {
            return 1;
        } else if (giaHang < temp.getGiaHang()) {
            return -1;
        }
        return 0;
    }
}
