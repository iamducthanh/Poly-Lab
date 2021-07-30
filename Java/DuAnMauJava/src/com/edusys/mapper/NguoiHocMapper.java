package com.edusys.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.edusys.model.NguoiHoc;

public class NguoiHocMapper implements RowMapper<NguoiHoc>{
	@Override
	public NguoiHoc mapRow(ResultSet resultSet) {
		try {
			String maNH = resultSet.getString(1);
			String hoTen = resultSet.getString(2);
			String gioiTinh = resultSet.getString(4);
			String ngaySinh = resultSet.getString(3);
			String soDT = resultSet.getString(5);
			String email = resultSet.getString(6);
			String ghiChu = resultSet.getString(7);
			String ngayDK = resultSet.getString(8);
			String maNV = resultSet.getString(9);
			NguoiHoc nguoiHoc = new NguoiHoc(maNH, hoTen, ngaySinh, gioiTinh, soDT, email, ngayDK, ghiChu, maNV);
			return nguoiHoc;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
