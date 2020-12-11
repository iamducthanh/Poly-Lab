package testDB;

import java.sql.*;

class Test {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String connectionURL = "jdbc:sqlserver://DESKTOP-NU1HNR3:1433;databaseName=TESTLAB5";
			Connection conn = DriverManager.getConnection(connectionURL, "sa", "123");
			Statement statement = conn.createStatement();
			ResultSet sinhVien = statement.executeQuery("SELECT * FROM SINHVIEN");
			while(sinhVien.next()) {
				String maSV = sinhVien.getNString("MASV");
				System.out.println(maSV);
			}
			conn.close();
			System.out.println("Kết nối thành công!!!!!!!!!!!!!!!!!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage() + "/n" + e.getClass()+ "/n" +e.getClass());
		}

	}
}
