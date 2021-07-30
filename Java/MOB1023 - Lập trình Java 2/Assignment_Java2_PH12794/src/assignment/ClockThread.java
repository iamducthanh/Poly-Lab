package assignment;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;

public class ClockThread extends Thread {
	private JLabel lblClock;

	public ClockThread(JLabel lblClockJLabel) {
		super();
		this.lblClock = lblClockJLabel;
	}

	public void run() {
		SimpleDateFormat fmClockDate = new SimpleDateFormat("hh:mm:ss aa");
		while (true) {
			lblClock.setText(fmClockDate.format(new Date()));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
