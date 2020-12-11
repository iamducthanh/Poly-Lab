package bai2;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;

public class ClockThread extends Thread {
	JButton start = new JButton();

	public ClockThread(JButton start) {
		super();
		this.start = start;
	}

	public void run() {
		SimpleDateFormat fmDate = new SimpleDateFormat("hh:mm:ss aa");
		while (true) {
			Date now = new Date();
			String time = fmDate.format(now);
			start.setText(time);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
