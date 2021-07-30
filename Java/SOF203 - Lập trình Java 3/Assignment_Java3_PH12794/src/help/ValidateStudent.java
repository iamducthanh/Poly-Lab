package help;

import form.QLSV;

public class ValidateStudent {
	static boolean check;
	static String reMaSV = "[p,P]{1}[h,H]{1}[0-9]{5}";

	public static String checkMa(String maSV) {
		check = true;
		if (maSV.isBlank()) {
			return "Bạn không được để trống mã sinh viên!\n";
		} else {
			if (!maSV.matches(reMaSV)) {
				return "Bạn phải nhập đúng mã sinh viên: ph12345\n";
			} else {
				check = true;
				QLSV.listStudent.forEach((SV) -> {
					if (SV.maSV.equalsIgnoreCase(maSV)) {
						check = false;
					}
				});
				if (check == false) {
					return "Mã sinh viên này đã tồn tại!\n";
				} else {
					return "";
				}
			}
		}
	}
	
	public static String checkMaUpdate(String maSV, int r, int size) {
		check = true;
		if (maSV.isBlank()) {
			return "Bạn không được để trống mã sinh viên!\n";
		} else {
			if (!maSV.matches(reMaSV)) {
				return "Bạn phải nhập đúng mã sinh viên: ph12345\n";
			} else {
				for(int i = 0;i<size;i++) {
					if(i == r) {
						continue;
					} 
					if(QLSV.listStudent.get(i).maSV.equalsIgnoreCase(maSV)) {
						check = false;
					}
				}
				if (check == false) {
					return "Mã sinh viên này đã tồn tại!\n";
				} else {
					return "";
				}
			}
		}
	}
	
	

	public static String checkTen(String hoTen) {
		if (hoTen.isBlank()) {
			return "Bạn không được để trống họ tên!\n";
		} else {
			return "";
		}
	}

	public static String checkEmail(String email) {
		String checkMail = "^[a-zA-Z][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$";
		if (email.isBlank()) {
			return "Bạn không được để trống email!\n";
		} else {
			if (!email.matches(checkMail)) {
				return "Bạn phải nhập đúng định dạng email!\n";
			} else {
				return "";
			}
		}
	}

	public static String checkSoDT(String soDT) {
		String reSDT = "[0]{1}[1-9]{9}";
		if (soDT.isBlank()) {
			return "Bạn không được để trống số điện thoại!\n";
		} else {
			if (!soDT.matches(reSDT)) {
				return "Bạn phải nhập đúng định dạng số điện thoại!\n";
			} else {
				return "";
			}
		}
	}

	public static String checkDiaChi(String diaChi) {
		if (diaChi.isBlank()) {
			return "Bạn không được để trống địa chỉ!\n";
		} else {
			return "";
		}
	}
}
