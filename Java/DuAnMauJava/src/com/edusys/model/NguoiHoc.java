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
public class NguoiHoc {
    private String maNH, hoTen, ngaySinh,gioiTinh;
    private String soDT;
    private String email, ngayDK,ghiChu, maNV;

    public NguoiHoc() {
    }

	public NguoiHoc(String maNH, String hoTen, String ngaySinh, String gioiTinh, String soDT, String email,
			String ngayDK, String ghiChu, String maNV) {
		super();
		this.maNH = maNH;
		this.hoTen = hoTen;
		this.ngaySinh = ngaySinh;
		this.gioiTinh = gioiTinh;
		this.soDT = soDT;
		this.email = email;
		this.ngayDK = ngayDK;
		this.ghiChu = ghiChu;
		this.maNV = maNV;
	}

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}

	public String getMaNH() {
		return maNH;
	}

	public void setMaNH(String maNH) {
		this.maNH = maNH;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getSoDT() {
		return soDT;
	}

	public void setSoDT(String soDT) {
		this.soDT = soDT;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNgayDK() {
		return ngayDK;
	}

	public void setNgayDK(String ngayDK) {
		this.ngayDK = ngayDK;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

    
}
