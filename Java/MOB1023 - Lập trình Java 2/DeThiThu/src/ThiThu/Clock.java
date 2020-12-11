package ThiThu;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;

public class Clock extends Thread{
	JLabel clockJLabel;
	public Clock() {
		// TODO Auto-generated constructor stub
	}
	public Clock(JLabel clockJLabel) {
		super();
		this.clockJLabel = clockJLabel;
	}
	
	public void run() {
		SimpleDateFormat fm = new SimpleDateFormat("hh:mm:ss aa");
		while(true) {
		Date now = new Date();
		String gio = fm.format(now);
		clockJLabel.setText(gio);
		try {
			sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
}
