/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package De8.Cau2;

/**
 *
 * @author Neik
 */
public class MatHang {
    private String maHang;
    private String tenHang;
    private int giaHang;

    public MatHang() {
    }

    public MatHang(String maHang, String tenHang, int giaHang) {
        this.maHang = maHang;
        this.tenHang = tenHang;
        this.giaHang = giaHang;
    }

    public String getMaHang() {
        return maHang;
    }

    public String getTenHang() {
        return tenHang;
    }

    public int getGiaHang() {
        return giaHang;
    }

    public void setMaHang(String maHang) {
        this.maHang = maHang;
    }

    public void setTenHang(String tenHang) {
        this.tenHang = tenHang;
    }

    public void setGiaHang(int giaHang) {
        this.giaHang = giaHang;
    }
    
    @Override
    public String toString() {
        return String.format("%-12s%-12s%-12d", this.maHang, this.tenHang, this.giaHang) + "\n";
    }
}
