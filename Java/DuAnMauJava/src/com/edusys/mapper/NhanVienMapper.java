package com.edusys.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.edusys.model.NhanVien;

public class NhanVienMapper implements RowMapper<NhanVien>{
	@Override
	public NhanVien mapRow(ResultSet resultSet) {
		try {
			String manv = resultSet.getString(1);
			String password = resultSet.getString(2);
			String hoTen = resultSet.getString(3);
			String vaiTro = resultSet.getString(4);
			NhanVien nhanVien = new NhanVien(manv, password, hoTen, vaiTro);
			return nhanVien;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
