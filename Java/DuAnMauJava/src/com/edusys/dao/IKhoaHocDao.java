package com.edusys.dao;

import java.util.ArrayList;

import com.edusys.model.KhoaHoc;

public interface IKhoaHocDao {
	ArrayList<KhoaHoc> fillAll();
	ArrayList<KhoaHoc> fillByChuyenDe(String macd);
}
