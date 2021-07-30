package com.edusys.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.edusys.model.KhoaHoc;

public class KhoaHocMapper implements RowMapper<KhoaHoc>{

	@Override
	public KhoaHoc mapRow(ResultSet resultSet) {
		String hocPhi;
		try {
			String maKh = resultSet.getString(1);
			String maCD = resultSet.getString(2);
			hocPhi = resultSet.getString(3);
			String thoiLuong = resultSet.getString(4);
			String ngayKG = resultSet.getString(5);
			String ghiChu = resultSet.getString(6);
			String nguoiTao = resultSet.getString(7);
			String ngayTao = resultSet.getString(8);
			KhoaHoc khoaHoc = new KhoaHoc(maKh, maCD, ghiChu, hocPhi, thoiLuong, ngayKG, nguoiTao, ngayTao);
			return khoaHoc;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
