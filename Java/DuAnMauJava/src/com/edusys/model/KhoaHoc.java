/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edusys.model;

/**
 *
 * @author User
 */
public class KhoaHoc {

    private String maKh, maCD, ghiChu;
    private String hocPhi, thoiLuong;
    private String ngayKG, nguoiTao, ngayTao;

    public KhoaHoc() {
    }

    

    public String getGhiChu() {
		return ghiChu;
	}



	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}



	public KhoaHoc(String maKh, String maCD, String ghiChu, String hocPhi, String thoiLuong, String ngayKG, String nguoiTao,
			String ngayTao) {
		super();
		this.maKh = maKh;
		this.maCD = maCD;
		this.ghiChu = ghiChu;
		this.hocPhi = hocPhi;
		this.thoiLuong = thoiLuong;
		this.ngayKG = ngayKG;
		this.nguoiTao = nguoiTao;
		this.ngayTao = ngayTao;
	}



	public String getMaKh() {
        return maKh;
    }

    public void setMaKh(String maKh) {
        this.maKh = maKh;
    }

    public String getMaCD() {
        return maCD;
    }

    public void setMaCD(String maCD) {
        this.maCD = maCD;
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

    public String getNgayKG() {
        return ngayKG;
    }

    public void setNgayKG(String ngayKG) {
        this.ngayKG = ngayKG;
    }

    public String getNguoiTao() {
        return nguoiTao;
    }

    public void setNguoiTao(String nguoiTao) {
        this.nguoiTao = nguoiTao;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }
}
