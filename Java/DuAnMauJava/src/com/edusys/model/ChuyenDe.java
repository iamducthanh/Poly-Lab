package com.edusys.model;

public class ChuyenDe {

    private String maCD;
    private String tenCD;
    private String hocPhi;
    private String thoiLuong;
    private String hinh;
    private String moTa;

    public ChuyenDe(String maCD, String tenCD, String hocPhi, String thoiLuong, String hinh, String moTa) {
        this.maCD = maCD;
        this.tenCD = tenCD;
        this.hocPhi = hocPhi;
        this.thoiLuong = thoiLuong;
        this.hinh = hinh;
        this.moTa = moTa;
    }

    @Override
    public String toString() {
        return "ChuyenDe{" + "maCD=" + maCD + ", tenCD=" + tenCD + ", hocPhi=" + hocPhi + ", thoiLuong=" + thoiLuong + ", hinh=" + hinh + ", moTa=" + moTa + '}';
    }

    public String getMaCD() {
        return maCD;
    }

    public void setMaCD(String maCD) {
        this.maCD = maCD;
    }

    public String getTenCD() {
        return tenCD;
    }

    public void setTenCD(String tenCD) {
        this.tenCD = tenCD;
    }

    public String getHocPhi() {
        return hocPhi;
    }

    public void setHocPhi(String hocPhi) {
        this.hocPhi = hocPhi;
    }

    public String getThoiLuong() {
        return thoiLuong;
    }

    public void setThoiLuong(String thoiLuong) {
        this.thoiLuong = thoiLuong;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

}
