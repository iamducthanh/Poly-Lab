package lab7Bai4;

class XPoly {
	@Deprecated
	public static boolean isCardNumber(String number) {
		try {
			int so = Integer.parseInt(number);
			int sum = 0;
			for (int i = 0; i < number.length(); i++) {
				sum = sum + (so % 10);
				so = so / 10;
			}
			if (sum % 2 == 0) {
				return true;
			} else
				return false;
		} catch (Exception e) {
			return false;
		}
	}
}
