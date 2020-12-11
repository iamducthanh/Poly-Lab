package lab5;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		List<Students> list1 = new ArrayList<>();
		list1.add(new Students("Tuấn", 5, "CNTT"));
		list1.add(new Students("Cường", 7.5, "TKTW"));
		list1.add(new Students("Hạnh", 8.5, "CNTT"));
		XFile.writeObject("C:\\Users\\ADMIN\\eclipse-workspace\\Lab5\\listStudent.txt", list1);
		System.out.println("write thanh cong");

		try {
			List<Students> list2 = new ArrayList<>();
			list2 = (List<Students>) XFile.readObject("C:\\Users\\ADMIN\\eclipse-workspace\\Lab5\\listStudent.txt");
			list2.forEach((o1) -> {
				System.out.println(o1.toString());
			});
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
