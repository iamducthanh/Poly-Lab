package bai3;

public class EvenThread extends Thread {
	public void run() {
		int i = 2;
		while (i <= 10) {
			System.out.println(i + "\t");
			i += 2;
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
