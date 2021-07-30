package dao;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.sql.rowset.serial.SerialBlob;

import entities.Students;
import help.DataBaseConnection;

public class StudentDao {
	public static ArrayList<Students> loadData() throws ClassNotFoundException, SQLException{
		ArrayList<Students> listStudent = new ArrayList<Students>();
		Connection connection = DataBaseConnection.Connect();
		Statement statement = connection.createStatement();
		ResultSet tbStudent = statement.executeQuery("select * from SinhVien");
		while(tbStudent.next()) {
			String maSV = tbStudent.getString(1);
			String hoTen = tbStudent.getString(2);
			String email = tbStudent.getString(3);
			String soDT = tbStudent.getString(4);
			String gioiTinh = tbStudent.getString(5);
			String diaChi = tbStudent.getString(6);
			byte[] hinh = tbStudent.getBytes(7);
			listStudent.add(new Students(maSV, hoTen, email, soDT, gioiTinh, diaChi, hinh));
		}
		connection.close();
		return listStudent;
	}
	
	public static void insert(String maSV, String hoTen, String email, String soDT, String gioiTinh, String diaChi, byte[] imageByte) throws ClassNotFoundException, SQLException {
		Connection connection = DataBaseConnection.Connect();
		PreparedStatement insert = connection
				.prepareStatement("INSERT INTO SinhVien VALUES (?,?,?,?,?,?,?)");
		insert.setString(1, maSV);
		insert.setString(2, hoTen);
		insert.setString(3, email);
		insert.setString(4, soDT);
		insert.setString(5, gioiTinh);
		insert.setString(6, diaChi);
		if (imageByte == null) {
			Blob hinh = null;
			insert.setBlob(7, hinh);
		} else {
			insert.setBlob(7, new SerialBlob(imageByte));
		}
		insert.execute();
		connection.close();
	}
	
	public static void delete(String maSV) throws ClassNotFoundException, SQLException {
		Connection connection = DataBaseConnection.Connect();
		PreparedStatement delete = connection.prepareStatement("DELETE FROM SinhVien WHERE MaSinhVien = ?");
		delete.setString(1, maSV);
		delete.execute();
		connection.close();
	}
	
	public static void update(String maSV, String hoTen, String email, String soDT, String gioiTinh, String diaChi, byte[] imageByte, String maSV1) throws ClassNotFoundException, SQLException {
		Connection connection = DataBaseConnection.Connect();
		PreparedStatement update = connection
				.prepareStatement("UPDATE SinhVien SET MaSinhVien = ?,HoTen = ?,Email = ?,SoDT = ?,GioiTinh = ?,DiaChi = ?,Hinh = ? WHERE MaSinhVien = ?");
		update.setString(1, maSV);
		update.setString(2, hoTen);
		update.setString(3, email);
		update.setString(4, soDT);
		update.setString(5, gioiTinh);
		update.setString(6, diaChi);
		if (imageByte == null) {
			Blob hinh = null;
			update.setBlob(7, hinh);
		} else {
			update.setBlob(7, new SerialBlob(imageByte));
		}
		update.setString(8, maSV1);
		update.execute();
		connection.close();
	}
}
