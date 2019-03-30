/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package De3.Cau2;

import java.util.ArrayList;

/**
 *
 * @author Neik
 */
public class DieuKhien {
    private ArrayList<TaiKhoan> danhSachTaiKhoan;
    
    public DieuKhien() {
        danhSachTaiKhoan = new ArrayList<>();
        danhSachTaiKhoan.add(new TaiKhoan("abc", "123"));
    }
    
    public String dangNhap(String username, String password) {
        for(TaiKhoan t : danhSachTaiKhoan) {
            if(t.getUsername().equals(username) && t.getPassword().equals(password)) {
                return "1";
            }
        }
        return "0";
    }
}
