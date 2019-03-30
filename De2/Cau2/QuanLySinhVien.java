/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package De2.Cau2;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Neik
 */
public class QuanLySinhVien {

    ArrayList<SinhVien> danhSachSinhVien;

    public QuanLySinhVien() {
        danhSachSinhVien = new ArrayList<>();
    }

    public void themSinhVien(SinhVien sv) {
        danhSachSinhVien.add(sv);
    }

    public String timSinhVien(String hoTen) {
        String str = String.format("%-18s%-18s%-18s%-18s", "sinh vien", "Nam sinh", "Ma sinh vien", "Que quan") + "\n";
        str += "----------------------------------------------------------------\n";
        for (SinhVien sv : this.danhSachSinhVien) {
            if (sv.getHoTen().equals(hoTen)) {
                str += sv.toString();
            }
        }
        return str;
    }

    public String xemDanhSach() {
        String str = String.format("%-18s%-18s%-18s%-18s", "sinh vien", "Nam sinh", "Ma sinh vien", "Que quan") + "\n";
        str += "----------------------------------------------------------------\n";
        for (SinhVien sv : this.danhSachSinhVien) {
            str += sv.toString();
        }
        return str;
    }

    public String timTheoQueQuan(String queQuan) {
        String str = String.format("%-18s%-18s%-18s%-18s", "sinh vien", "Nam sinh", "Ma sinh vien", "Que quan") + "\n";
        str += "----------------------------------------------------------------\n";
        for (SinhVien sv : this.danhSachSinhVien) {
            if (sv.getQueQuan().equals(queQuan)) {
                str += sv.toString();
            }
        }
        return str;
    }

    public String timTheoNamSinh(String namSinh) {
        String str = String.format("%-18s%-18s%-18s%-18s", "sinh vien", "Nam sinh", "Ma sinh vien", "Que quan") + "\n";
        str += "----------------------------------------------------------------\n";
        for (SinhVien sv : this.danhSachSinhVien) {
            if (sv.getNgaySinh().equals(namSinh)) {
                str += sv.toString();
            }
        }
        return str;
    }
}
