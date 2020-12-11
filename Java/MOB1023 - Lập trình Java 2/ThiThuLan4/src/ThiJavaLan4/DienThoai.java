package ThiJavaLan4;

import java.io.Serializable;

@SuppressWarnings("serial")
class DienThoai implements Serializable{
	private String ten;
	private String Hang;
	private double gia;
	private String trangThai;
	
	public DienThoai() {
		// TODO Auto-generated constructor stub
	}

	public DienThoai(String ten, String hang, double gia, String trangThai) {
		super();
		this.ten = ten;
		Hang = hang;
		this.gia = gia;
		this.trangThai = trangThai;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getHang() {
		return Hang;
	}

	public void setHang(String hang) {
		Hang = hang;
	}

	public double getGia() {
		return gia;
	}

	public void setGia(double gia) {
		this.gia = gia;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

}
