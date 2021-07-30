package entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class SanPham {

    private String Masp, Ten, Hsd, TrangThai;
    private double Gia;
    private int SoLuong;

    public SanPham() {
    }

    public SanPham(String masp, String ten, String hsd, double gia, int soLuong) {
        Masp = masp;
        Ten = ten;
        Hsd = hsd;
        Gia = gia;
        SoLuong = soLuong;
    }

    public String getMasp() {
        return Masp;
    }

    public void setMasp(String masp) {
        Masp = masp;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public String getHsd() {
        return Hsd;
    }

    public void setHsd(String hsd) {
        Hsd = hsd;
    }
    
    public String getTrangThai() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = sdf.parse(Hsd);
            Date now = new Date();
            if (date.compareTo(now) >= 0) {
                return "Còn hạn";
            } else {
                return "Hết hạn";
            }
        } catch (ParseException ex) {
            Logger.getLogger(Date.class.getName()).log(Level.SEVERE, null, ex);
        }
        return TrangThai;
    }

    public void setTrangThai(String trangThai) {
        TrangThai = trangThai;
    }

    public double getGia() {
        return Gia;
    }

    public void setGia(double gia) {
        Gia = gia;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int soLuong) {
        SoLuong = soLuong;
    }

    @Override
    public String toString() {
        return "SanPham [Masp=" + Masp + ", Ten=" + Ten + ", Hsd=" + Hsd + ", TrangThai=" + TrangThai + ", Gia=" + Gia
                + ", SoLuong=" + SoLuong + "]";
    }

}
