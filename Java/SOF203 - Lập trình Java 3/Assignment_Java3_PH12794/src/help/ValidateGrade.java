package help;

import java.util.ArrayList;

import entities.StudentGrade;
import form.QLSV;

public class ValidateGrade {
	static boolean check;
	static String reMaSV = "[p,P]{1}[h,H]{1}[0-9]{5}";
	public static String checkMaSV(String maSV, ArrayList<StudentGrade> listGrade) {
		check = true;
		if (maSV.isBlank()) {
			return "Bạn không được để trống mã sinh viên!\n";
		} else {
			if (!maSV.matches(reMaSV)) {
				return "Bạn phải nhập đúng mã sinh viên: ph12345\n";
			} else {
				check = true;
				listGrade.forEach((SV) -> {
					if (SV.maSV.equalsIgnoreCase(maSV)) {
						check = false;
					}
				});
				if (check == false) {
					return "Bạn đã nhập điểm cho sinh viên này rồi!\n";
				} else {
					return "";
				}
			}
		}
	}
	
	public static String checkTen(String ten) {
		if(ten.isBlank()) {
			return "Bạn không được để trống tên!\n";
		} else return "";
	}
	
	public static String checkSo(String tiengAnh, String tinHoc, String GDTC) {
		try {
			double tiengAnhDouble = Double.parseDouble(tiengAnh);
			double tinHocDouble = Double.parseDouble(tinHoc);
			double GDTCDouble = Double.parseDouble(GDTC);
			if(checkDiem(tiengAnhDouble) && checkDiem(tinHocDouble) && checkDiem(GDTCDouble)) {
				return "";
			} else {
				return "Điểm phải trong khoảng 0 - 10!\n";
			}
		} catch (Exception e) {
			// TODO: handle exception
			return "Điểm phải là số!\n";
		}
	}
	
	public static boolean checkDiem(double diem) {
		if(diem < 0 || diem > 10) {
			return false;
		} else return true;
	}
	
	public static String checkSV(String maSV, String ten) {
		int i = 0;
		for(;i<QLSV.listStudent.size();i++) {
			if(QLSV.listStudent.get(i).maSV.equalsIgnoreCase(maSV)) {
				if(QLSV.listStudent.get(i).hoTen.equalsIgnoreCase(ten)) {
					break;
				}
			}
		}
		if(i == QLSV.listStudent.size()) {
			return "Bạn nhập sai thông tin sinh viên hãy kiểm tra lại!\n";
		} else {
			return "";
		}
	}
}
