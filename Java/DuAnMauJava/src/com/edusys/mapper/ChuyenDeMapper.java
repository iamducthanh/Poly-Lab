package com.edusys.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.edusys.model.ChuyenDe;

public class ChuyenDeMapper implements RowMapper<ChuyenDe>{

	@Override
	public ChuyenDe mapRow(ResultSet resultSet) {
		try {
			String maCD = resultSet.getString(1);
			String tenCD = resultSet.getString(2);
			String hocPhi = resultSet.getString(3);
			String thoiLuong = resultSet.getString(4);
			String hinh = resultSet.getString(5);
			String moTa = resultSet.getString(6);
			ChuyenDe chuyenDe = new ChuyenDe(maCD, tenCD, hocPhi, thoiLuong, hinh, moTa);
			return chuyenDe;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
