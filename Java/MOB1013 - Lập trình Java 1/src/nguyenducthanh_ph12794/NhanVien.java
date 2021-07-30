package nguyenducthanh_ph12794;

public abstract class NhanVien {

    protected String maNV;
    protected String tenNV;
    protected double luongCB;
    protected String kieuNV;

    public NhanVien(String maNV, String tenNV, double luongCB, String kieuNV) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.luongCB = luongCB;
        this.kieuNV = kieuNV;
    }

    public NhanVien() {
    }

    public String getMaNV() {
        return maNV;
    }

    public abstract double getThuNhap();
    public abstract void xuatNV();
    public double getLuongTN(){
        return 0;
    };
     public double getHueHong(){
         return 0;
     };


    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public double getLuongCB() {
        return luongCB;
    }

    public void setLuongCB(double luongCB) {
        this.luongCB = luongCB;
    }

    public String getKieuNV() {
        return kieuNV;
    }

    public void setKieuNV(String kieuNV) {
        this.kieuNV = kieuNV;
    }

}
