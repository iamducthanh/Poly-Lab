package com.edusys.helper;

public class Validate {
	
	public static boolean checkNull(String text) {
		if(text.isBlank()) {
			return false;
		} else return true;
	}
	
	public static boolean checkNgay(String ngay) {
		String reDa = "^\\d{4}\\-(0?[1-9]|1[012])\\-(0?[1-9]|[12][0-9]|3[01])$";

			if(!ngay.matches(reDa)) {
				return false;
			} else {
				return true;
			}
		
	}
	
	public static boolean checkEmail(String email) {
		String reEmail =  "^[a-zA-Z][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$";
		if(!email.matches(reEmail)) {
			return false;
		} else {
			return true;
		}
	}
	
	public static boolean checkSDT(String SDT) {
		String reSDT = "[0]{1}[1-9]{9}";
		if(!SDT.matches(reSDT)) {
			return false;
		} else {
			return true;
		}
	}
	
	public static boolean checkSo(String So) {
		try {
			if(Double.parseDouble(So) < 0) {
				return false;
			} else {
				return true;
			}
		} catch (Exception e) {
			return false;
		}
	}

}
