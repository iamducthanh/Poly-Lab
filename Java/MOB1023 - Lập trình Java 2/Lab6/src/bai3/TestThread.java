package bai3;

class TestThread {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		EvenThread thread2 = new EvenThread();
		OddThread thread1 = new OddThread();
		thread1.start();
		thread1.join();
		thread2.start();

	}

}
