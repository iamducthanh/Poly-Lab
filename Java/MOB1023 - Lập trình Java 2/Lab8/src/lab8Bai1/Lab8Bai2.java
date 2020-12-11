package lab8Bai1;

import java.util.ArrayList;



class Lab8Bai2 {
	public static void main(String[] args) {
		ArrayList<Integer> myarrr = new ArrayList<Integer>();
		for(int i=0;i<10;i++) {
			myarrr.add(i+1);
		}
		
		for (Integer integer : myarrr) {
			System.out.println(integer);
		}
	}
}
