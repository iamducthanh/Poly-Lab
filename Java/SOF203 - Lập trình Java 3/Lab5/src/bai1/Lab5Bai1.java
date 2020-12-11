package bai1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Lab5Bai1 {
	public static void main(String[] args) {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url = "jdbc:sqlserver://DESKTOP-NU1HNR3:1433;databaseName=QLSINHVIEN";
			Connection conn = DriverManager.getConnection(url, "sa", "123");
			Statement statement = conn.createStatement();
			ResultSet SinhVien = statement.executeQuery("SELECT * FROM SINHVIEN");
			System.out.printf("%-10s %-20s %-20s %-12s %-3s  %-20s \n", "MASV", "HOTEN", "EMAIL", "SODT", "GIOITINH", "DIACHI");
			while(SinhVien.next()) {
				String maSV = SinhVien.getString("MASV");
				String hoTen = SinhVien.getString("HOTEN");
				String email = SinhVien.getString("EMAIL");
				String soDT = SinhVien.getString("SODT");
				String gioiTinh = SinhVien.getString("GIOITINH");
				String diaChi = SinhVien.getString("DIACHI");
				System.out.printf("%-5s %-20s %-20s %-12s %-8s  %-20s \n", maSV, hoTen, email, soDT, gioiTinh, diaChi);
			}
			conn.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
