package bai2;

class SanPham {
	private String maSP;
	private String tenSP;
	private String DVT;
	private double donGia;
	private String nhaCungCap;
	
	public SanPham() {
		// TODO Auto-generated constructor stub
	}
	
	

	public SanPham(String maSP, String tenSP, String dVT, double donGia, String nhaCungCap) {
		super();
		this.maSP = maSP;
		this.tenSP = tenSP;
		DVT = dVT;
		this.donGia = donGia;
		this.nhaCungCap = nhaCungCap;
	}

	public String getMaSP() {
		return maSP;
	}

	public void setMaSP(String maSP) {
		this.maSP = maSP;
	}

	public String getTenSP() {
		return tenSP;
	}

	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}

	public String getDVT() {
		return DVT;
	}

	public void setDVT(String dVT) {
		DVT = dVT;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	public String getNhaCungCap() {
		return nhaCungCap;
	}

	public void setNhaCungCap(String nhaCungCap) {
		this.nhaCungCap = nhaCungCap;
	}
	
	
}
