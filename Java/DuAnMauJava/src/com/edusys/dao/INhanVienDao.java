package com.edusys.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.edusys.model.NhanVien;

public interface INhanVienDao {
	ArrayList<NhanVien> fillAll();
	ResultSet getNhanVien(String user, String pass);
	boolean changePass(String user, String newPass);
	
}
