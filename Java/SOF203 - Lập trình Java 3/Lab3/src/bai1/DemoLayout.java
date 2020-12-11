package bai1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DemoLayout extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DemoLayout frame = new DemoLayout();
					frame.setVisible(true);
					frame.setTitle("Demo layout");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	JPanel panel1 = new JPanel();
	public DemoLayout() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel1.setBackground(Color.YELLOW);
		panel1.setBounds(10, 11, 416, 33);
		contentPane.add(panel1);
		panel1.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		JButton btnYellow = new JButton("Yellow");
		panel1.add(btnYellow);
		
		JButton btnGreen = new JButton("Green");
		panel1.add(btnGreen);
		
		JButton btnRed = new JButton("Red");
		panel1.add(btnRed);
		
		JPanel panel2 = new JPanel();
		panel2.setBounds(10, 55, 416, 109);
		contentPane.add(panel2);
		panel2.setLayout(new BorderLayout(0, 0));
		
		JButton btnNorth = new JButton("North");
		panel2.add(btnNorth, BorderLayout.NORTH);
		
		JButton btnWest = new JButton("West");
		panel2.add(btnWest, BorderLayout.WEST);
		
		JButton btnEast = new JButton("East");
		panel2.add(btnEast, BorderLayout.EAST);
		
		JButton btnSouth = new JButton("South");
		panel2.add(btnSouth, BorderLayout.SOUTH);
		
		JButton btnCenter = new JButton("Center");
		panel2.add(btnCenter, BorderLayout.CENTER);
		
		JPanel panel3 = new JPanel();
		panel3.setBounds(10, 175, 416, 41);
		contentPane.add(panel3);
		panel3.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 5, 396, 25);
		panel3.add(textField);
		textField.setColumns(10);
		
		JPanel panel4 = new JPanel();
		panel4.setBounds(10, 227, 416, 98);
		contentPane.add(panel4);
		panel4.setLayout(new GridLayout(2, 0, 0, 0));
		
		JButton btn1 = new JButton("");
		panel4.add(btn1);
		
		JButton btn2 = new JButton("");
		panel4.add(btn2);
		
		JButton btn3 = new JButton("");
		panel4.add(btn3);
		
		JButton btn4 = new JButton("");
		panel4.add(btn4);
		
		JButton btn5 = new JButton("");
		panel4.add(btn5);
		
		JButton btn6 = new JButton("");
		panel4.add(btn6);
		
		JButton btn7 = new JButton("");
		panel4.add(btn7);
		
		JButton btn8 = new JButton("");
		panel4.add(btn8);
		
		JButton btn9 = new JButton("");
		panel4.add(btn9);
		
		JButton btn0 = new JButton("");
		panel4.add(btn0);
		
		btnRed.addActionListener(colorAction);
		btnYellow.addActionListener(colorAction);
		btnGreen.addActionListener(colorAction);
		
		btnCenter.addActionListener(setTextBox);
		btnEast.addActionListener(setTextBox);
		btnSouth.addActionListener(setTextBox);
		btnNorth.addActionListener(setTextBox);
		btnWest.addActionListener(setTextBox);
	}
	
	Action colorAction = new AbstractAction() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String colorString = e.getActionCommand();
			switch (colorString) {
			case "Red": panel1.setBackground(Color.red);
				break;
			case "Yellow": panel1.setBackground(Color.YELLOW);
				break;
			case "Green": panel1.setBackground(Color.green);
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + colorString);
			}
		}
	};
	
	Action setTextBox = new AbstractAction() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String text = e.getActionCommand();
			textField.setText(text);
		}
	};
}
