package help;

import javax.swing.JLabel;

public class Text extends Thread {
	JLabel lbJLabel;
	String textTen = "                     CHI TIẾT KHO HÀNG                     ";
	int i = 1;
	String textString = "";

	public Text(JLabel lbJLabel) {
		super();
		this.lbJLabel = lbJLabel;
		this.lbJLabel.setText(textTen);
	}

	public void run() {
		while (true) {
			try {
				Thread.sleep(150);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			StringBuilder textBuilder = new StringBuilder();
			textBuilder.append(textTen.substring(i, textTen.length()));
			textBuilder.append(textTen.substring(0, i));
			i = i + 1;
			lbJLabel.setText(textBuilder.toString());
			if(i == textTen.length()) {
				i = 1;
			}
		}
	}
}
