package com.edusys.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.edusys.dao.impl.ChuyenDeDao;
import com.edusys.dao.impl.HocVienDao;
import com.edusys.dao.impl.KhoaHocDao;
import com.edusys.dao.impl.NguoiHocDao;
import com.edusys.dao.impl.NhanVienDao;
import com.edusys.model.ChuyenDe;
import com.edusys.model.HocVien;
import com.edusys.model.KhoaHoc;
import com.edusys.model.NguoiHoc;
import com.edusys.model.NhanVien;

public class ThreadSocket extends Thread {
	Socket socket;
	public ArrayList<ChuyenDe> listChuyenDe = new ChuyenDeDao().fillAll();
	public ArrayList<HocVien> lisHocViens = new HocVienDao().fillAll();
	public ArrayList<KhoaHoc> listKhoaHocs = new KhoaHocDao().fillAll();
	public ArrayList<NguoiHoc> lisNguoiHocs = new NguoiHocDao().fillAll();
	public ArrayList<NhanVien> lisNhanViens = new NhanVienDao().fillAll();

	public ThreadSocket(Socket socket) {
		super();
		this.socket = socket;
		System.out.println("oke");
	}

	public void run() {
		try {
			ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
			for(int i=0;i<listChuyenDe.size();i++) {
				output.writeObject(listChuyenDe.get(i));
			}
			output.writeObject("stop");
			
			for(int i=0;i<lisHocViens.size();i++) {
				output.writeObject(lisHocViens.get(i));
			}
			output.writeObject("stop");
			
			for(int i=0;i<lisNguoiHocs.size();i++) {
				output.writeObject(lisNguoiHocs.get(i));
			}
			output.writeObject("stop");
			
			for(int i=0;i<lisNhanViens.size();i++) {
				output.writeObject(lisNhanViens.get(i));
			}
			output.writeObject("stop");
			
			for(int i=0;i<listKhoaHocs.size();i++) {
				output.writeObject(listKhoaHocs.get(i));
			}
			output.writeObject("stop");
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
