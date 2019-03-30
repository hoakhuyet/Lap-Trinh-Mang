/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package De5.Cau2;

/**
 *
 * @author Neik
 */
public class Sach {
    private String maSach;
    private String tenSach;
    private String nhaXuatBan;
    private int soLuongTong;
    private int soLuongMuon;

    public Sach() {
    }

    public Sach(String tenSach, String maSach, String nhaXuatBan, int soLuongTong, int soLuongMuon) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.nhaXuatBan = nhaXuatBan;
        this.soLuongTong = soLuongTong;
        this.soLuongMuon = soLuongMuon;
    }

    public String getMaSach() {
        return maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public String getNhaXuatBan() {
        return nhaXuatBan;
    }

    public int getSoLuongTong() {
        return soLuongTong;
    }

    public int getSoLuongMuon() {
        return soLuongMuon;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public void setNhaXuatBan(String nhaXuatBan) {
        this.nhaXuatBan = nhaXuatBan;
    }

    public void setSoLuongTong(int soLuongTong) {
        this.soLuongTong = soLuongTong;
    }

    public void setSoLuongMuon(int soLuongMuon) {
        this.soLuongMuon = soLuongMuon;
    }
    
    @Override
    public String toString() {
        return String.format("%-15s%-15s%-15s%-15s%-15s", this.maSach, this.tenSach, this.nhaXuatBan, this.soLuongTong, this.soLuongMuon) + "\n";
    }
}
