package ThiThu;

import java.io.Serializable;

public class DongHo implements Serializable{
	private String tenSP;
	private String hang;
	private double gia;
	
	public DongHo() {
		// TODO Auto-generated constructor stub
	}

	public DongHo(String tenSP, String hang, double gia) {
		super();
		this.tenSP = tenSP;
		this.hang = hang;
		this.gia = gia;
	}

	public String getTenSP() {
		return tenSP;
	}

	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}

	public String getHang() {
		return hang;
	}

	public void setHang(String hang) {
		this.hang = hang;
	}

	public double getGia() {
		return gia;
	}

	public void setGia(double gia) {
		this.gia = gia;
	}

	@Override
	public String toString() {
		return "DongHo [tenSP=" + tenSP + ", hang=" + hang + ", gia=" + gia + "]";
	}
	
	
}
