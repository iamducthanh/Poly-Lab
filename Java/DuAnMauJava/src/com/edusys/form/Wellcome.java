package com.edusys.form;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class Wellcome extends JFrame {

	private JPanel contentPane;
	JProgressBar progressBar = new JProgressBar();
	static Wellcome frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Wellcome();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Wellcome() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 285);
		setTitle("Xin chào");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\udpm\\Image\\Logo_FPT_Polytechnic.png"));
		lblNewLabel.setBounds(-10, 0, 446, 217);
		contentPane.add(lblNewLabel);
		
		progressBar.setForeground(new Color(255, 127, 80));
		progressBar.setStringPainted(true);
		progressBar.setBounds(0, 215, 436, 37);
		contentPane.add(progressBar);
		
		javax.swing.Timer timer = new javax.swing.Timer(10, setVlue);
		timer.start();
	}
	
	
	ActionListener setVlue = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int value = progressBar.getValue();
			value = value + 1;
			progressBar.setValue(value);
			if(value == 100) {
				Login login = new Login();
				login.setVisible(true);
				login.setLocationRelativeTo(null);
				Wellcome.this.dispose();
			}
		}
	};
}
