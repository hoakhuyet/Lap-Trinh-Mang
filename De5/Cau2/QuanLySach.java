/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package De5.Cau2;

import java.util.ArrayList;

/**
 *
 * @author Neik
 */
public class QuanLySach {

    private ArrayList<Sach> thuVien;

    public QuanLySach() {
        thuVien = new ArrayList<>();
        thuVien.add(new Sach("abc", "a001", "xyz", 10, 0));
        thuVien.add(new Sach("giao trinh", "b001", "hvmm", 100, 0));
        thuVien.add(new Sach("xyz", "c001", "abc", 50, 10));
    }

    public String xemDanhSach() {
        String str = String.format("%-15s%-15s%-15s%-15s%-15s", "TenSach", "MaSach", "NhaXuatBan", "TongSoLuong", "SoLuongMuon") + "\n";
        System.out.println("----------------------------------------------------");
        for (Sach sach : thuVien) {
            str += sach.toString();
        }
        return str;
    }

    public String muonSach(String Id) {
        System.out.println("Muon sach!");
        for (Sach sach : thuVien) {
            if (sach.getMaSach().equals(Id)) {
                if (sach.getSoLuongMuon() < sach.getSoLuongTong()) {
                    sach.setSoLuongMuon(sach.getSoLuongMuon() + 1);
                    return "1";
                } else {
                    return "-1";
                }
            }
        }
        return "0";
    }

    public String traSach(String id) {
        for (Sach sach : thuVien) {
            if (sach.getMaSach().equals(id)) {
                if (sach.getSoLuongMuon() > 0) {
                    sach.setSoLuongMuon(sach.getSoLuongMuon() - 1);
                    return "1";
                } else {
                    return "-1";
                }
            }
        }
        return "0";
    }
}
