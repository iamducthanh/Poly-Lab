package com.edusys.dao;

import java.util.ArrayList;

import com.edusys.model.ChuyenDe;

public interface IChuyenDeDao {
	ArrayList<ChuyenDe> fillAll();
	ArrayList<ChuyenDe> fillByTen(String tencd);
	ArrayList<ChuyenDe> fillByMa(String macd);
}
