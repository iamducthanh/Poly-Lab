package com.edusys.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.edusys.model.NguoiHoc;

public interface INguoiHocDao {
	ArrayList<NguoiHoc> fillAll();
	ArrayList<NguoiHoc> fillByYear(String year);
	ArrayList<String>fillMinMaxYear(String year);
	ResultSet fillYear();
	static int findNguoiHoc(ArrayList<NguoiHoc> list, String maNH) {
		return 0;
	}
}
