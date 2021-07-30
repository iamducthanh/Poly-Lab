package com.edusys.dao.impl;

import java.util.ArrayList;

import com.edusys.dao.IChuyenDeDao;
import com.edusys.mapper.ChuyenDeMapper;
import com.edusys.model.ChuyenDe;

public class ChuyenDeDao implements IChuyenDeDao{
	public ArrayList<ChuyenDe> fillAll(){
		String sql = "select * from chuyende";
		return new AbstractDao().fillAll(sql, new ChuyenDeMapper());
	}
	
	public ArrayList<ChuyenDe> fillByTen(String tencd){
		String sql = "select * from chuyende where tencd = ?";
		return new AbstractDao().fillAll(sql, new ChuyenDeMapper(), tencd);
	}
	
	public ArrayList<ChuyenDe> fillByMa(String macd){
		String sql = "select * from chuyende where macd = ?";
		return new AbstractDao().fillAll(sql, new ChuyenDeMapper(), macd);
	}
	
}
