package nguyenducthanh_ph12794;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class QLNV {

    static ArrayList<NhanVien> ListNV = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    String temp = null;
    int i, size;
    String search, maNV, tenNV, kieuNV;
    double luongCB, doanhSo, hueHong, luongTN, thuNhap;
    String reMaNV = "[n,N]{1}[v,V]{1}[0-9]{5}";
    String reLuong = "[0-9]{0,500}";
    String[] loaiNV = new String[]{"x", "Hanh chinh", "Tiep thi", "Truong phong"};
    TP TP1 = new TP();
    boolean stop = true;

    public void menu() {
        System.out.println("+--------------------MENU--------------------+"
                + "\n| 1. Nhập danh sách nhân viên                |"
                + "\n| 2. Xuất danh sách nhân viên                |"
                + "\n| 3. Tìm kiếm nhân viên                      |"
                + "\n| 4. Xóa nhân viên                           |"
                + "\n| 5. Cập nhật thông tin nhân viên            |"
                + "\n| 6. Sắp xếp nhân viên theo họ tên           |"
                + "\n| 7. Sắp xếp nhân viên theo thu nhập         |"
                + "\n| 8. Xuất 5 nhân viên có thu nhập cao nhất   |"
                + "\n| 9. Xuat nhan vien theo khoang luong        |"
                + "\n| 10. Thoat                                  |"
                + "\n+--------------------------------------------+");
        while (true) {
            System.out.print("Moi chon chuc nang: ");
            String chon = sc.nextLine();
            switch (chon) {
                case "1":
                    System.out.print("So nhan vien can nhap: ");
                    while (true) {
                        temp = sc.nextLine();
                        if (!temp.matches(reLuong)) {
                            System.out.print("Nhap sai so luong nhan vien, nhap lai: ");
                        } else {
                            size = Integer.parseInt(temp);
                            break;
                        }
                    }
                    i = 0;
                    for (; i < size; i++) {
                        System.out.printf("Nhap nhan vien thu %d:\n", ListNV.size() + 1);
                        nhap();
                    }
                    break;
                case "2":
                    xuat(0, ListNV.size());
                    break;
                case "3":
                    timNVTheoMa();
                    break;
                case "4":
                    xoaNhanVien();
                    break;
                case "5":
                    updateTheoMa();
                    break;
                case "6":
                    sapXepTheoTen();
                    break;
                case "7":
                    sapXepTheoThuNhap();
                    thuocTinh();
                    xuatChung(0, ListNV.size());
                    break;
                case "8":
                    xuat5NVThuNhapCaoNhat();
                    break;
                case "9":
                    xuatTheoLuong();
                    break;
                case "10":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Ban chon sai roi chon lai di");
            }
        }

    }

    public void nhap() {
        System.out.print("\tNhap ma nhan vien(VD: nv12345): ");
        while (true) {
            temp = sc.nextLine();
            temp = temp.toLowerCase();
            int j = timKiem(temp);
            if (!temp.matches(reMaNV)) {
                System.out.print("\tBan da nhap sai ma nhan vien hay nhap lai: ");
            } else if (j != ListNV.size()) {
                System.out.print("\tMa nhan vien vua nhap bi trung, hay nhap lai: ");
            } else {
                maNV = temp;
                break;
            }
        }
        System.out.print("\tNhap ten nhan vien: ");
        tenNV = sc.nextLine();
        System.out.print("\tNhap luong co ban: ");
        while (true) {
            temp = sc.nextLine();
            if (!temp.matches(reLuong)) {
                System.out.print("\tBan nhap luong sai roi moi nhap lai: ");
            } else {
                break;
            }
        }
        luongCB = (Double.parseDouble(temp));
        System.out.println("\t\t1. Nhan vien hanh chinh"
                + "\n\t\t2. Nhan vien tiep thi"
                + "\n\t\t3. Truong phong");
        while (true) {
            System.out.print("\tChon kieu nhan vien(1,2,3): ");
            String chon = sc.nextLine();
            switch (chon) {
                case "1":
                    kieuNV = "1";
                    ListNV.add(new NVHC(maNV, tenNV, luongCB, kieuNV));
                    break;
                case "2":
                    kieuNV = "2";
                    System.out.print("\tNhap doanh so: ");
                    while (true) {
                        temp = sc.nextLine();
                        if (!temp.matches(reLuong)) {
                            System.out.print("\tban nhap sai doanh so, nhap lai: ");
                        } else {
                            doanhSo = Double.parseDouble(temp);
                            ListNV.add(new NVTT(doanhSo, maNV, tenNV, luongCB, kieuNV));
                            break;
                        }
                    }
                    break;
                case "3":
                    kieuNV = "3";
                    System.out.print("\tNhap luong trach nhiem: ");
                    while (true) {
                        temp = sc.nextLine();
                        if (!temp.matches(reLuong)) {
                            System.out.print("\tban nhap sai luong trach nhiem, nhap lai: ");
                        } else {
                            luongTN = Double.parseDouble(temp);
                            ListNV.add(new TP(luongTN, maNV, tenNV, luongCB, kieuNV));
                            break;
                        }
                    }
                    break;
                default:
                    System.out.println("\tChon sai kieu nhan vien roi, chon lai!");
            }
            if ("1".equals(chon) || "2".equals(chon) || "3".equals(chon)) {
                break;
            }
        }
    }

    public int timKiem(String ma) {
        i = 0;
        for (; i < ListNV.size(); i++) {
            if (ma.equalsIgnoreCase(ListNV.get(i).maNV)) {
                break;
            }
        }
        return i;
    }

    public void xuat(int n, int size) {
        int j = n;
        for (; j < size; j++) {
            if (ListNV.get(j).kieuNV.equals("1")) {
                while (stop) {
                    System.out.println("----------------------------Nhan vien hanh chinh--------------------------------------\n"
                            + "|   maNV  |        Ho ten        | Luong co ban | Kieu nhan vien |      Thu nhap     |\n"
                            + "--------------------------------------------------------------------------------------");
                    stop = false;
                }
                ListNV.get(j).xuatNV();
            }

        }
        if (j == size && stop == false) {
            System.out.println("--------------------------------------------------------------------------------------");
            System.out.println("");
        }
        j = n;
        stop = true;
        for (; j < size; j++) {
            if (ListNV.get(j).kieuNV.equals("2")) {
                while (stop) {
                    System.out.println("------------------------------------------Nhan vien tiep thi-------------------------------------------------------------------\n"
                            + "|   maNV  |        Ho ten        | Luong co ban | Kieu nhan vien |      Doanh so      |      Hue hong     |      Thu nhap     |\n"
                            + "-------------------------------------------------------------------------------------------------------------------------------");
                    stop = false;
                }
                ListNV.get(j).xuatNV();
            }
        }
        if (j == size && stop == false) {
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("");
        }
        j = n;
        stop = true;
        for (; j < size; j++) {
            if (ListNV.get(j).kieuNV.equals("3")) {
                while (stop) {
                    System.out.println("---------------------------------------------Truong phong-------------------------------------------------\n"
                            + "|   maNV  |        Ho ten        | Luong co ban | Kieu nhan vien | Luong trach nhiem |      Thu nhap     |\n"
                            + "----------------------------------------------------------------------------------------------------------");
                    stop = false;
                }
                ListNV.get(j).xuatNV();
            }
        }
        if (j == size && stop == false) {
            System.out.println("----------------------------------------------------------------------------------------------------------");
            System.out.println("");
        }
        stop = true;
    }

    public void thuocTinh() {
        System.out.println("----------------------------------------------------Danh sach nhan vien------------------------------------------------------\n"
                + "|   maNV  |        Ho ten        | Luong co ban | Kieu nhan vien |     Hue hong     | Luong trach nhiem |      Thu nhap     |\n"
                + "-----------------------------------------------------------------------------------------------------------------------------");

    }

    public void xuatChung(int j, int size) {
        for (; j < size; j++) {
            switch (ListNV.get(j).getKieuNV()) {
                case "1":
                    System.out.printf("| %7s |%21s |%13.0f |%15S |%17s |%18s |%18.0f |\n",
                            ListNV.get(j).getMaNV(), ListNV.get(j).getTenNV(), ListNV.get(j).getLuongCB(), loaiNV[1], loaiNV[0], loaiNV[0], ListNV.get(j).getThuNhap());
                    break;
                case "2":
                    System.out.printf("| %7s |%21s |%13.0f |%15S |%17.0f |%18s |%18.0f |\n",
                            ListNV.get(j).getMaNV(), ListNV.get(j).getTenNV(), ListNV.get(j).getLuongCB(), loaiNV[2], ListNV.get(j).getHueHong(), loaiNV[0], ListNV.get(j).getThuNhap());
                    break;
                default:
                    System.out.printf("| %7s |%21s |%13.0f |%15S |%17s |%18.0f |%18.0f |\n",
                            ListNV.get(j).getMaNV(), ListNV.get(j).getTenNV(), ListNV.get(j).getLuongCB(), loaiNV[3], loaiNV[0], ListNV.get(j).getLuongTN(), ListNV.get(j).getThuNhap());
                    break;
            }
        }
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
    }

    public int timNVTheoMa() {
        System.out.print("Nhap ma nhan vien can tim: ");
        search = sc.nextLine();
        int j = timKiem(search);
        if (j == ListNV.size()) {
            System.out.printf("Khong tim thay nhan vien co ma '%s'!\n", search);
            return j;
        } else {
            System.out.println("Tim thay nhan vien: ");
            xuat(j, j + 1);
            return j;
        }

    }

    public void xoaNhanVien() {
        int j = timNVTheoMa();
        if (j != ListNV.size()) {
            System.out.println("\t1. Xoa\t2. Khong");
            System.out.print("Chon: ");
            String xoa = sc.nextLine();
            if (xoa.equals("1")) {
                ListNV.remove(j);
                System.out.printf("Da xoa nhan vien co ma %s!\n", search);
            }
        }
    }

    public void updateTheoMa() {
        int j = timNVTheoMa();
        if (j != ListNV.size()) {
            System.out.print("\tNhap ten nhan vien: ");
            tenNV = sc.nextLine();
            System.out.print("\tNhap luong co ban: ");
            while (true) {
                temp = sc.nextLine();
                if (!temp.matches(reLuong)) {
                    System.out.print("\tBan nhap luong sai roi moi nhap lai: ");
                } else {
                    break;
                }
            }
            luongCB = (Double.parseDouble(temp));
            System.out.println("\t\t1. Nhan vien hanh chinh"
                    + "\n\t\t2. Nhan vien tiep thi"
                    + "\n\t\t3. Truong phong");
            while (true) {
                System.out.print("\tChon kieu nhan vien(1,2,3): ");
                String chon = sc.nextLine();
                switch (chon) {
                    case "1":
                        kieuNV = "1";
                        ListNV.set(i, (new NVHC(search, tenNV, luongCB, kieuNV)));
                        break;
                    case "2":
                        kieuNV = "2";
                        System.out.print("\tNhap doanh so: ");
                        while (true) {
                            temp = sc.nextLine();
                            if (!temp.matches(reLuong)) {
                                System.out.print("\tban nhap sai doanh so, nhap lai: ");
                            } else {
                                doanhSo = Double.parseDouble(temp);
                                ListNV.set(i, (new NVTT(doanhSo, search, tenNV, luongCB, kieuNV)));
                                break;
                            }
                        }
                        break;
                    case "3":
                        kieuNV = "3";
                        System.out.print("\tNhap luong trach nhiem: ");
                        while (true) {
                            temp = sc.nextLine();
                            if (!temp.matches(reLuong)) {
                                System.out.print("\tban nhap sai luong trach nhiem, nhap lai: ");
                            } else {
                                luongTN = Double.parseDouble(temp);
                                ListNV.set(i, (new TP(luongTN, search, tenNV, luongCB, kieuNV)));
                                break;
                            }
                        }
                        break;
                    default:
                        System.out.println("\tChon sai kieu nhan vien roi, chon lai!");
                }
                if ("1".equals(chon) || "2".equals(chon) || "3".equals(chon)) {
                    break;
                }
            }
        }
    }

//    public void sapXepTheoHoTen() {
//        Collections.sort(ListNV, (t1, t2) -> t1.getTenNV().compareTo(t2.getTenNV()));
//        xuatChung(0, ListNV.size());
//    }
    public void sapXepTheoTen() {
        Collections.sort(ListNV, (a1, a2) -> {
            String ten1 = a1.tenNV.trim().toLowerCase();
            String ten2 = a2.tenNV.trim().toLowerCase();
            int temp1 = ten1.lastIndexOf(" ");
            int temp2 = ten2.lastIndexOf(" ");
            char a = ten1.charAt(temp1 + 1);
            char b = ten2.charAt(temp2 + 1);
            int x = (int) a;
            int y = (int) b;
            return a > b ? 1 : -1;
        });
        thuocTinh();
        xuatChung(0, ListNV.size());
    }

    public void sapXepTheoThuNhap() {
        Collections.sort(ListNV, (o1, o2) -> o1.getThuNhap() > o2.getThuNhap() ? 1 : -1);

    }

    public void xuat5NVThuNhapCaoNhat() {
        sapXepTheoThuNhap();
        int n = ListNV.size() - 5;
        if (n < 0) {
            System.out.printf("Chi co %d nhan vien: \n", ListNV.size());
            xuatChung(0, ListNV.size());
        } else {
            System.out.println("5 Nhan vien co thu nhap cao nhat: ");
            thuocTinh();
            xuatChung(n, ListNV.size());
        }
    }

    public void xuatTheoLuong() {
        double luongMin;
        double luongMax;
        System.out.print("Nhap luong min: ");
        while (true) {
            temp = sc.nextLine();
            if (!temp.matches(reLuong)) {
                System.out.print("Ban nhap sai luong, nhap lai: ");
            } else {
                luongMin = Double.parseDouble(temp);
                break;
            }
        }
        System.out.print("Nhap luong max: ");
        while (true) {
            temp = sc.nextLine();
            if (!temp.matches(reLuong)) {
                System.out.print("Ban nhap sai luong, nhap lai: ");
            } else {
                luongMax = Double.parseDouble(temp);
                break;
            }
        }
        thuocTinh();
        for (int i = 0; i < ListNV.size(); i++) {
            if (ListNV.get(i).getThuNhap() >= luongMin && ListNV.get(i).getThuNhap() <= luongMax) {
                xuatChung(i, i + 1);
            }
        }

    }
}
