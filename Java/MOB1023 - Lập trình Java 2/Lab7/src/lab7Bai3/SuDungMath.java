package lab7Bai3;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.lang.Math;

public class SuDungMath extends JFrame {

	private JPanel contentPane;
	private JTextField textCard;
	private JTextField textSo2;
	private JTextField textCan;
	private JTextField textLuyThua;
	private JTextField textMin;
	private JTextField textMax;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SuDungMath frame = new SuDungMath();
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
	public SuDungMath() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 399);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Credit Card");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 16, 80, 21);
		contentPane.add(lblNewLabel);
		
		JLabel lblSTh = new JLabel("S\u1ED1 th\u1EE9 2");
		lblSTh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSTh.setBounds(10, 59, 80, 21);
		contentPane.add(lblSTh);
		
		textCard = new JTextField();
		textCard.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textCard.setBounds(118, 11, 297, 32);
		contentPane.add(textCard);
		textCard.setColumns(10);
		
		textSo2 = new JTextField();
		textSo2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textSo2.setColumns(10);
		textSo2.setBounds(118, 54, 297, 32);
		contentPane.add(textSo2);
		
		JLabel lblKtQu = new JLabel("K\u1EBET QU\u1EA2");
		lblKtQu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblKtQu.setBounds(10, 108, 80, 21);
		contentPane.add(lblKtQu);
		
		JLabel lblSTh_1_1 = new JLabel("C\u0103n b\u1EADc 2");
		lblSTh_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSTh_1_1.setBounds(10, 140, 80, 21);
		contentPane.add(lblSTh_1_1);
		
		JLabel lblSTh_1_2 = new JLabel("L\u0169y Th\u1EEBa");
		lblSTh_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSTh_1_2.setBounds(10, 183, 80, 21);
		contentPane.add(lblSTh_1_2);
		
		JLabel lblSTh_1_3 = new JLabel("S\u1ED1 nh\u1ECF nh\u1EA5t");
		lblSTh_1_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSTh_1_3.setBounds(10, 226, 96, 21);
		contentPane.add(lblSTh_1_3);
		
		JLabel lblSTh_1_4 = new JLabel("S\u1ED1 l\u1EDBn nh\u1EA5t");
		lblSTh_1_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSTh_1_4.setBounds(10, 269, 88, 21);
		contentPane.add(lblSTh_1_4);
		
		textCan = new JTextField();
		textCan.setForeground(Color.BLACK);
		textCan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textCan.setColumns(10);
		textCan.setBounds(118, 135, 297, 32);
		contentPane.add(textCan);
		
		textLuyThua = new JTextField();
		textLuyThua.setEnabled(false);
		textLuyThua.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textLuyThua.setColumns(10);
		textLuyThua.setBounds(118, 178, 297, 32);
		contentPane.add(textLuyThua);
		
		textMin = new JTextField();
		textMin.setEnabled(false);
		textMin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textMin.setColumns(10);
		textMin.setBounds(118, 221, 297, 32);
		contentPane.add(textMin);
		
		textMax = new JTextField();
		textMax.setEnabled(false);
		textMax.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textMax.setColumns(10);
		textMax.setBounds(118, 264, 297, 32);
		contentPane.add(textMax);
		
		textCan.setEnabled(false);
		
		JButton btnThcHin = new JButton("Th\u1EF1c hi\u00EAn");
		btnThcHin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				submit();
			}
		});
		btnThcHin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnThcHin.setBounds(118, 307, 118, 32);
		contentPane.add(btnThcHin);
	}
	
	public void submit() {
		try {
			double a = Double.parseDouble(textCard.getText());
			double b = Double.parseDouble(textSo2.getText());
			
			textCan.setText(String.valueOf(Math.sqrt(a)));
			textLuyThua.setText(String.valueOf(Math.pow(a, b)));
			textMin.setText(String.valueOf(Math.min(a, b)));
			textMax.setText(String.valueOf(Math.max(a, b)));
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
