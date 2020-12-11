package lab8Bai1;

import java.util.ArrayList;

class Lab8Bai1 {
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		list.add(8);
		list.add(7.2);
		list.add(true);
		list.add("Hello world");
		
		list.forEach((o1) -> System.out.println(o1));
	}
}
