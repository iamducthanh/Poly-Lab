package bai4;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class XSKT extends JFrame {

	private JPanel contentPane;
	private JTextField textTram;
	private JTextField textChuc;
	private JTextField textDonVi;
	private JButton btnTram;
	private JButton btnChuc;
	private JButton btnDonVi;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					XSKT frame = new XSKT();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public XSKT() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 405, 196);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("X\u1ED4 S\u1ED0 KI\u1EBEN THI\u1EBET");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 29));
		lblNewLabel.setBounds(62, 0, 329, 57);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Tr\u0103m");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(94, 54, 58, 28);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Ch\u1EE5c");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(173, 54, 58, 28);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("\u0110\u01A1n v\u1ECB");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_2.setBounds(250, 54, 58, 28);
		contentPane.add(lblNewLabel_1_2);

		textTram = new JTextField();
		textTram.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textTram.setBounds(84, 80, 67, 33);
		textTram.setHorizontalAlignment(JTextField.CENTER);
		contentPane.add(textTram);
		textTram.setColumns(10);

		textChuc = new JTextField();
		textChuc.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textChuc.setColumns(10);
		textChuc.setBounds(162, 80, 67, 33);
		textChuc.setHorizontalAlignment(JTextField.CENTER);
		contentPane.add(textChuc);

		textDonVi = new JTextField();
		textDonVi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textDonVi.setColumns(10);
		textDonVi.setBounds(241, 80, 67, 33);
		textDonVi.setHorizontalAlignment(JTextField.CENTER);
		contentPane.add(textDonVi);

		btnTram = new JButton("Start");
		btnTram.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnTram.setEnabled(false);
				random(textTram);
			}
		});
		btnTram.setBackground(SystemColor.activeCaptionBorder);
		btnTram.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTram.setBounds(84, 124, 67, 30);
		btnTram.setBorder(new BevelBorder(BevelBorder.RAISED));
		contentPane.add(btnTram);

		btnChuc = new JButton("Start");
		btnChuc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnChuc.setEnabled(false);
				random(textChuc);
			}
		});
		btnChuc.setBackground(SystemColor.activeCaptionBorder);
		btnChuc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnChuc.setBorder(new BevelBorder(BevelBorder.RAISED));
		btnChuc.setBounds(162, 124, 67, 30);
		contentPane.add(btnChuc);

		btnDonVi = new JButton("Start");
		btnDonVi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDonVi.setEnabled(false);
				random(textDonVi);
			}
		});
		btnDonVi.setBackground(SystemColor.activeCaptionBorder);
		btnDonVi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDonVi.setBorder(new BevelBorder(BevelBorder.RAISED));
		btnDonVi.setBounds(241, 124, 67, 30);
		contentPane.add(btnDonVi);
	}

	public void random(JTextField txtSo) {
		new Thread() {
			public void run() {
				for (int i = 0; i < 1000; i++) {
					int so = (int) Math.round(Math.random() * 9);
					txtSo.setText(String.valueOf(so));
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}.start();
	}

}
