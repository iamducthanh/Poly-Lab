
package nguyenducthanh_ph12794;

public class NVHC extends NhanVien{


    public NVHC(String maNV, String tenNV, double luongCB, String kieuNV) {
        super(maNV, tenNV, luongCB, kieuNV);
    }

    @Override
    public double getThuNhap() {
        return luongCB * getThue(luongCB);
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
    public String getMaNV() {
        return maNV;
    }
    
        @Override
    public void xuatNV(){
        System.out.printf("| %7s |%21s |%13.0f |%15S |%18.0f |\n",
                        getMaNV(), getTenNV(), getLuongCB(), "Hanh chinh", getThuNhap());
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
