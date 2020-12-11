package form;
import java.sql.*;

import javax.swing.JOptionPane;

public class DatabaseConnect {
	public static Connection connect() throws ClassNotFoundException, SQLException {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection conn = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=QLKhachHang","sa","123");
		return conn;
	}
	
	public static void insert(String maKH, String ten, String sdt, String email, String loaiKH) {
		try {
			Connection conn = connect();
			PreparedStatement ps = conn.prepareStatement("insert into KhachHang values (?,?,?,?,?)");
			ps.setString(1, maKH);
			ps.setString(2, ten);
			ps.setString(3, sdt);
			ps.setString(4, email);
			ps.setString(5, loaiKH);
			ps.execute();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Khách hàng này đã tồn tại");
		}
		
	}
	
	public static void datele(String maKH) {
		try {
			Connection conn = connect();
			PreparedStatement ps = conn.prepareStatement("delete from KhachHang where [MaKhachHang] = ?");
			ps.setString(1, maKH);
			ps.execute();
			JOptionPane.showMessageDialog(null, "xóa thành công");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Khách hàng này đã tồn tại");
		}
		
	}
}
