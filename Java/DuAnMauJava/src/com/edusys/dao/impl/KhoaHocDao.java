package com.edusys.dao.impl;

import java.util.ArrayList;

import com.edusys.dao.IKhoaHocDao;
import com.edusys.mapper.KhoaHocMapper;
import com.edusys.model.KhoaHoc;

public class KhoaHocDao implements IKhoaHocDao{
	public ArrayList<KhoaHoc> fillAll(){
		String sql = "select * from khoahoc";
		return new AbstractDao().fillAll(sql, new KhoaHocMapper());
	}
	
	public ArrayList<KhoaHoc> fillByChuyenDe(String macd){
		String sql = "select * from khoahoc where macd = ?";
		return new AbstractDao().fillAll(sql, new KhoaHocMapper(),macd);
	}
}
