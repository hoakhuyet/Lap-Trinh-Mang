/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package De2.Cau2;

/**
 *
 * @author Neik
 */
public class SinhVien {

    private String hoTen;
    private String ngaySinh;
    private String maSinhVien;
    private String queQuan;

    public SinhVien() {
    }

    public SinhVien(String hoTen, String ngaySinh, String maSinhVien, String queQuan) {
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.maSinhVien = maSinhVien;
        this.queQuan = queQuan;
    }

    public String getHoTen() {
        return hoTen;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public String getMaSinhVien() {
        return maSinhVien;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public void setMaSinhVien(String maSinhVien) {
        this.maSinhVien = maSinhVien;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    @Override
    public String toString() {
        return String.format("%-18s%-18s%-18s%-18s", this.hoTen, this.ngaySinh, this.ngaySinh, this.queQuan) + "\n";
    }
}
