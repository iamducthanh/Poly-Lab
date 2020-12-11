package bai1;

public class MyThread implements Runnable {
	@Override
	public void run() {
		int i = 1;
		while (i <= 10) {
			System.out.println(i + "\t");
			i++;
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
