package ThiJavaLan4;

import java.awt.Color;

import javax.swing.JLabel;

@SuppressWarnings("unused")
class Text extends Thread {
	JLabel lbJLabel;
	String text = "          QUẢN LÝ ĐIỆN THOẠI          ";
	int i = 1;
	String textString = "";

	public Text(JLabel lbJLabel) {
		super();
		this.lbJLabel = lbJLabel;
		this.lbJLabel.setText(text);
	}

	public void run() {
		while (true) {
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			StringBuilder textBuilder = new StringBuilder();
			textBuilder.append(text.substring(i, text.length()));
			textBuilder.append(text.substring(0, i));
			i = i + 1;
			lbJLabel.setText(textBuilder.toString());
			if(i == text.length()) {
				i = 1;
			}
		}
	}
}
