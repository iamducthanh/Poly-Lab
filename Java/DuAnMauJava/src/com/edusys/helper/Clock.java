package com.edusys.helper;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;

public class Clock extends Thread{
	JLabel clock;
	
	public Clock(JLabel clock) {
		super();
		this.clock = clock;
	}

	public Clock() {
		super();
	}



	public void run() {
		SimpleDateFormat fm = new SimpleDateFormat("hh:mm:ss aa");
		while (true) {
			Date now = new Date();
			clock.setText(fm.format(now));
		}
	}
}
