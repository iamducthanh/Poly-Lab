package com.edusys.dao;

import java.util.ArrayList;

import com.edusys.model.HocVien;

public interface IHocVienDao {
	ArrayList<HocVien> fillAll();
	ArrayList<HocVien> fillByKhoaHoc(String maKH);
}
