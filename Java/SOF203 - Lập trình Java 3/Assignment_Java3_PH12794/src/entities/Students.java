package entities;

public class Students {
	public String maSV;
	public String hoTen;
	public String email;
	public String soDT;
	public String gioiTinh;
	public String diaChi;
	public byte[] hinh;

	public Students(String maSV, String hoTen, String email, String soDT, String gioiTinh, String diaChi, byte[] hinh) {
		super();
		this.maSV = maSV;
		this.hoTen = hoTen;
		this.email = email;
		this.soDT = soDT;
		this.gioiTinh = gioiTinh;
		this.diaChi = diaChi;
		this.hinh = hinh;
	}

}
