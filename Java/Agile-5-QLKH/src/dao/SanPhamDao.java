package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entities.SanPham;
import help.DataBaseConnect;

public class SanPhamDao {
	DataBaseConnect db = new DataBaseConnect();
	public static ArrayList<SanPham> loadUser(){
		ArrayList<SanPham> listSP = new ArrayList<SanPham>();
		try {
			Connection conn = DataBaseConnect.Connect();
			Statement st = conn.createStatement();
			String query = "SELECT * FROM SANPHAM";
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				listSP.add(new SanPham(rs.getString(2), rs.getString(3), rs.getString(6), rs.getDouble(4), rs.getInt(5)));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listSP;
	}
	
	public static void saveDB(String masp,String ten,String gia,String soluong,String hsd) throws ClassNotFoundException, SQLException {
		Connection conn = DataBaseConnect.Connect();
		Statement st = conn.createStatement();
		PreparedStatement ps = conn.prepareStatement("insert into sanpham values(?,?,?,?,?)");
		ps.setString(1, masp);
		ps.setString(2, ten);
		ps.setString(3, gia);
		ps.setString(4, soluong);
		ps.setString(5, hsd);
		ps.execute();
		}
	
}