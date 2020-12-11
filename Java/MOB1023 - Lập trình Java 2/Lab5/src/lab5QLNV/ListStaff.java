package lab5QLNV;

import java.util.ArrayList;
import java.util.List;

public class ListStaff {
	public static List<Staff> listStaff = new ArrayList<Staff>();

	public static void add(String fullName, double salary) {
		listStaff.add(new Staff(fullName, salary));
	}
}
