package com.edusys.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.edusys.model.HocVien;

public class HocVienMapper implements RowMapper<HocVien>{
	@Override
	public HocVien mapRow(ResultSet resultSet) {
		try {
			String maHV = resultSet.getString(1);
			String maKH = resultSet.getString(2);
			String maNH = resultSet.getString(3);
			String diem = resultSet.getString(4);
			HocVien hocVien = new HocVien(maNH, maKH, maHV, diem);
			return hocVien;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
