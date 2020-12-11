package bai1;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class SwingControlDemo {

	private JFrame frame = new JFrame();
	private JLabel header = new JLabel();
	private JLabel status = new JLabel();
	private JPanel control = new JPanel();

	public SwingControlDemo() {
		prepareGUI();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingControlDemo swingControlDemo = new SwingControlDemo();
		swingControlDemo.showCheckBox();

	}

	public void prepareGUI() {
		frame = new JFrame("Vi du Java Swing");
		frame.setVisible(true);
		frame.setSize(400, 200);
		frame.setLayout(new GridLayout(3, 1));
		frame.setLocationRelativeTo(null);

		header = new JLabel("Control in action: Check box", JLabel.CENTER);
		status = new JLabel("", JLabel.CENTER);
		status.setSize(350, 100);
		control = new JPanel();
		control.setLayout(new FlowLayout());

		frame.add(header);
		frame.add(control);
		frame.add(status);

	}

	public void showCheckBox() {
		final JCheckBox chkApple = new JCheckBox("Apple");
		final JCheckBox chkMango = new JCheckBox("Mango");
		final JCheckBox chkPeer = new JCheckBox("Peer");

		chkApple.setMnemonic(KeyEvent.VK_C);
		chkMango.setMnemonic(KeyEvent.VK_M);
		chkPeer.setMnemonic(KeyEvent.VK_P);

		chkApple.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				status.setText("Apple Checkbox: " + (e.getStateChange() == 1 ? "checked" : "unchecked"));
			}
		});
		chkMango.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				status.setText("Mango Checkbox: " + (e.getStateChange() == 1 ? "checked" : "unchecked"));
			}
		});
		chkPeer.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				status.setText("Peer Checkbox: " + (e.getStateChange() == 1 ? "checked" : "unchecked"));
			}
		});

		control.add(chkApple);
		control.add(chkMango);
		control.add(chkPeer);
		frame.setVisible(true);
	}

}
