package com.edusys.model;

public class NhanVien {

    private String manv;
    private String password;
    private String hoTen;
    private String vaiTro;

    public NhanVien() {
    }

    
    

    public String getHoTen() {
		return hoTen;
	}




	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}




	public String getVaiTro() {
		return vaiTro;
	}




	public void setVaiTro(String vaiTro) {
		this.vaiTro = vaiTro;
	}




	public NhanVien(String manv, String password, String hoTen, String vaiTro) {
		super();
		this.manv = manv;
		this.password = password;
		this.hoTen = hoTen;
		this.vaiTro = vaiTro;
	}




	public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "NhanVien{" + "manv=" + manv + ", password=" + password + '}';
    }

    
    
}


