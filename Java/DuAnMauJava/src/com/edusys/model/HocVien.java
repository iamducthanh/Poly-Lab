/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edusys.model;

public class HocVien {

    private String maHV;
    private String maKH, maNH;
    private String diem;

    public HocVien() {
    }

    public HocVien(String maNH, String maKH, String maHV, String diem) {
        this.maNH = maNH;
        this.maKH = maKH;
        this.maHV = maHV;
        this.diem = diem;
    }

	public String getMaHV() {
		return maHV;
	}

	public void setMaHV(String maHV) {
		this.maHV = maHV;
	}

	public String getMaKH() {
		return maKH;
	}

	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}

	public String getMaNH() {
		return maNH;
	}

	public void setMaNH(String maNH) {
		this.maNH = maNH;
	}

	public String getDiem() {
		return diem;
	}

	public void setDiem(String diem) {
		this.diem = diem;
	}
	
	public String getXepLoai() {
		if(Double.parseDouble(diem) >= 9) {
			return "Xuất sắc";
		} else if(Double.parseDouble(diem) >= 8) {
			return "Giỏi";
		} else if(Double.parseDouble(diem) >= 6.5) {
			return "Khá";
		} else if(Double.parseDouble(diem) >= 5) {
			return "Trung bình";
		} else  {
			return "Kém";
		}
	}

    

}
