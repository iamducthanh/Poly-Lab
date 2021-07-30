package com.edusys.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.edusys.dao.INhanVienDao;
import com.edusys.helper.JDBCHelper;
import com.edusys.mapper.NhanVienMapper;
import com.edusys.model.NhanVien;

public class NhanVienDao implements INhanVienDao{
	public ArrayList<NhanVien> fillAll(){
		String sql = "select * from nhanvien";
		return new AbstractDao().fillAll(sql, new NhanVienMapper());
	}
	
	public ResultSet getNhanVien(String user, String pass) {
		Connection conn = JDBCHelper.connect();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from nhanvien where manv = ? and matkhau = ?");
			ps.setString(1, user);
			ps.setString(2, pass);
			ResultSet NhanVien = ps.executeQuery();
			return NhanVien;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean changePass(String user, String newPass) {
		Connection conn = JDBCHelper.connect();
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement("update nhanvien set matkhau = ? where manv = ?");
			ps.setString(1, newPass);
			ps.setString(2, user);
			JOptionPane.showMessageDialog(null, "Đổi mật khẩu thành công!");
			return ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

}
