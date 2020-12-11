package thijava;

import java.io.Serializable;

@SuppressWarnings("serial")
class GiaoVien implements Serializable{
	private String tenGV;
	private String boMon;
	private double luong;
	public GiaoVien(String tenGV, String boMon, double luong) {
		super();
		this.tenGV = tenGV;
		this.boMon = boMon;
		this.luong = luong;
	}
	
	public GiaoVien() {
		// TODO Auto-generated constructor stub
	}

	public String getTenGV() {
		return tenGV;
	}

	public void setTenGV(String tenGV) {
		this.tenGV = tenGV;
	}

	public String getBoMon() {
		return boMon;
	}

	public void setBoMon(String boMon) {
		this.boMon = boMon;
	}

	public double getLuong() {
		return luong;
	}

	public void setLuong(double luong) {
		this.luong = luong;
	}

	@Override
	public String toString() {
		return "GiaoVien [tenGV=" + tenGV + ", boMon=" + boMon + ", luong=" + luong + "]";
	}
	
	public String getStatus(double luong) {
		if(luong > 5000) {
			return "Tốt";
		} else {
			return "Bình thường";
		}
	}
}
