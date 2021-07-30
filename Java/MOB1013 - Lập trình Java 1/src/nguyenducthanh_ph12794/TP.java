
package nguyenducthanh_ph12794;

public class TP extends NhanVien{
    private double luongTN;

    public TP(double luongTN, String maNV, String tenNV, double luongCB, String kieuNV) {
        super(maNV, tenNV, luongCB, kieuNV);
        this.luongTN = luongTN;

    }

    public TP() {
    }
    
    

    public TP(double luongTN, double thuNhap) {
        this.luongTN = luongTN;
    }

        @Override
    public void xuatNV(){
        System.out.printf("| %7s |%21s |%13.0f |%15S |%18.0f |%18.0f |\n",
                        getMaNV(), getTenNV(), getLuongCB(), "Truong phong", getLuongTN(), getThuNhap());

    }
     

    @Override
    public double getLuongTN() {
        return luongTN;
    }

    public void setLuongTN(double luongTN) {
        this.luongTN = luongTN;
    }

    @Override
    public double getThuNhap() {
        return (luongCB + luongTN)* getThue(luongCB + luongTN);
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
