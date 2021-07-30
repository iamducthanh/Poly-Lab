package com.edusys.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.edusys.dao.INguoiHocDao;
import com.edusys.helper.JDBCHelper;
import com.edusys.mapper.NguoiHocMapper;
import com.edusys.model.NguoiHoc;

public class NguoiHocDao implements INguoiHocDao{
	public ArrayList<NguoiHoc> fillAll() {
		String sql = "select * from nguoihoc";
		return new AbstractDao().fillAll(sql, new NguoiHocMapper());
	}

	public ArrayList<NguoiHoc> fillByYear(String year) {
		String sql = "select * from NguoiHoc where YEAR(ngaydk) = ?";
		return new AbstractDao().fillAll(sql, new NguoiHocMapper(), year);
	}

	public ResultSet fillYear() {
		Connection conn = JDBCHelper.connect();
		try {
			PreparedStatement ps = conn.prepareStatement("select distinct YEAR(ngaydk) from NguoiHoc");
			ResultSet resultSet = ps.executeQuery();
			return resultSet;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public ArrayList<String> fillMinMaxYear(String year) {
		Connection conn = JDBCHelper.connect();
		ArrayList<String> ngayDK = new ArrayList<String>();
		try {
			PreparedStatement ps = conn
					.prepareStatement("select min(ngaydk), max(ngaydk) from NguoiHoc where YEAR(ngaydk) = ?");
			ps.setString(1, year);
			ResultSet resultSet = ps.executeQuery();
			while(resultSet.next()) {
				ngayDK.add(resultSet.getString(1));
				ngayDK.add(resultSet.getString(2));
			}
			return ngayDK;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public static int findNguoiHoc(ArrayList<NguoiHoc> list, String maNH) {
		int i = 0;
		for (; i < list.size(); i++) {
			if(list.get(i).getMaNH().equalsIgnoreCase(maNH)) {
				break;
			}
		}
		return i;
	}

}
