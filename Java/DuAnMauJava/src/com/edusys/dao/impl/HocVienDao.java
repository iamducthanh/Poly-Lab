package com.edusys.dao.impl;

import java.util.ArrayList;

import com.edusys.dao.IHocVienDao;
import com.edusys.mapper.HocVienMapper;
import com.edusys.model.HocVien;

public class HocVienDao implements IHocVienDao{
	public ArrayList<HocVien> fillAll(){
		String sql = "select * from hocvien";
		return new AbstractDao().fillAll(sql, new HocVienMapper());
	}
	
	public ArrayList<HocVien> fillByKhoaHoc(String maKH){
		String sql = "select * from hocvien where makh = ?";
		return new AbstractDao().fillAll(sql, new HocVienMapper(), maKH);
	}
}
