package nguyenducthanh_ph12794;

public class NVTT extends NhanVien {

    private double doanhSo;
    private double hueHong;

    public NVTT(double doanhSo, String maNV, String tenNV, double luongCB, String kieuNV) {
        super(maNV, tenNV, luongCB, kieuNV);
        this.doanhSo = doanhSo;
    }

    public NVTT(double doanhSo, double hueHong) {
        this.doanhSo = doanhSo;
        this.hueHong = hueHong;
    }

    @Override
    public double getThuNhap() {
        return (luongCB + hueHong) * getThue(luongCB + hueHong);
    }

    
    @Override
    public double getHueHong() {
        return hueHong = doanhSo * 0.1;
    }

    public double getThue(double luong) {
        if (luong < 9000000) {
            return 1;
        } else if (luong <= 15000000) {
            return 0.9;
        } else {
            return 0.88;
        }
    }
    @Override
    public void xuatNV(){
        System.out.printf("| %7s |%21s |%13.0f |%15S |%19.0f |%18.0f |%18.0f |\n",
                        getMaNV(),getTenNV(), getLuongCB(), "Tiep thi",getDoanhSo(), getHueHong(), getThuNhap());

    }

    public double getDoanhSo() {
        return doanhSo;
    }

    public void setDoanhSo(double doanhSo) {
        this.doanhSo = doanhSo;
    }

    public void setHueHong(double hueHong) {
        this.hueHong = hueHong;
    }

    @Override
    public String getMaNV() {
        return maNV;
    }

    @Override
    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    @Override
    public String getTenNV() {
        return tenNV;
    }

    @Override
    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    @Override
    public double getLuongCB() {
        return luongCB;
    }

    @Override
    public void setLuongCB(double luongCB) {
        this.luongCB = luongCB;
    }

    @Override
    public String getKieuNV() {
        return kieuNV;
    }

    @Override
    public void setKieuNV(String kieuNV) {
        this.kieuNV = kieuNV;
    }

}
