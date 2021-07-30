package com.edusys.model;

import java.util.ArrayList;

import com.edusys.dao.impl.ChuyenDeDao;
import com.edusys.dao.impl.HocVienDao;
import com.edusys.dao.impl.KhoaHocDao;
import com.edusys.dao.impl.NguoiHocDao;
import com.edusys.dao.impl.NhanVienDao;

public class ListModel {
	public ArrayList<ChuyenDe> listChuyenDe = new ArrayList<ChuyenDe>();
	public ArrayList<HocVien> lisHocViens = new ArrayList<HocVien>();
	public ArrayList<KhoaHoc> listKhoaHocs = new ArrayList<KhoaHoc>();
	public ArrayList<NguoiHoc> lisNguoiHocs = new ArrayList<NguoiHoc>();
	public ArrayList<NhanVien> lisNhanViens = new ArrayList<NhanVien>();
	public void loadList() {
		listChuyenDe = new ChuyenDeDao().fillAll();
		lisHocViens = new HocVienDao().fillAll();
		listKhoaHocs = new KhoaHocDao().fillAll();
		lisNguoiHocs = new NguoiHocDao().fillAll();
		lisNhanViens = new NhanVienDao().fillAll();
	}

}
