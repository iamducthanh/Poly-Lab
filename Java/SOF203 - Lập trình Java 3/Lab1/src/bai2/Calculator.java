package bai2;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class Calculator extends JFrame {

	private JPanel contentPane;
	private JTextField textFN;
	private JTextField textSN;
	private JTextField textOut;
	DecimalFormat fm = new DecimalFormat("#.###");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator frame = new Calculator();
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
	JButton btnTich = new JButton("*");
	JButton btnTong = new JButton("+");
	JButton btnThuong = new JButton("/");
	JButton btnHieu = new JButton("-");
	public Calculator() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 361, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("First number");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 31, 128, 35);
		contentPane.add(lblNewLabel);
		
		textFN = new JTextField();
		textFN.setBounds(148, 31, 187, 30);
		contentPane.add(textFN);
		textFN.setColumns(10);
		
		JLabel lblSecondNumber = new JLabel("Second number");
		lblSecondNumber.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSecondNumber.setBounds(10, 82, 128, 35);
		contentPane.add(lblSecondNumber);
		
		JLabel lblResult = new JLabel("Result");
		lblResult.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblResult.setBounds(10, 128, 128, 35);
		contentPane.add(lblResult);
		
		textSN = new JTextField();
		textSN.setColumns(10);
		textSN.setBounds(148, 82, 187, 30);
		contentPane.add(textSN);
		
		textOut = new JTextField();
		textOut.setEditable(false);
		textOut.setColumns(10);
		textOut.setBounds(148, 133, 187, 30);
		contentPane.add(textOut);
		btnThuong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculator("/");
			}
		});
		
		btnThuong.setBackground(SystemColor.activeCaptionBorder);
		btnThuong.setBounds(295, 187, 40, 23);
		contentPane.add(btnThuong);
		btnTich.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculator("*");
			}
		});
		
		btnTich.setBackground(SystemColor.activeCaptionBorder);
		btnTich.setBounds(245, 187, 40, 23);
		contentPane.add(btnTich);
		btnHieu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculator("-");
			}
		});
		
		btnHieu.setBackground(SystemColor.activeCaptionBorder);
		btnHieu.setBounds(195, 187, 40, 23);
		contentPane.add(btnHieu);
		
		btnTong.setBackground(SystemColor.activeCaptionBorder);
		btnTong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculator("+");
			}
		});
		btnTong.setBounds(144, 187, 41, 23);
		contentPane.add(btnTong);
	}
	
	public boolean checkNull(String number) {
		try {
			@SuppressWarnings("unused")
			double numberDouble = Double.parseDouble(number);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Vui lòng nhập đúng số!");
			return false;
		}
	}
	
	public void calculator(String button) {
		if(checkNull(textFN.getText()) && checkNull(textSN.getText())) {
			double so1 = Double.parseDouble(textFN.getText());
			double so2 = Double.parseDouble(textSN.getText());
			double ketQua = 0;
			textOut.setText("");
			switch (button) {
			case "+":
				ketQua = so1 + so2; ketQua(ketQua);
				break;
			case "-":
				ketQua = so1 - so2; ketQua(ketQua);
				break;
			case "*":
				ketQua = so1 * so2; ketQua(ketQua);
				break; 
			case "/":
				if(so2 == 0) {
					JOptionPane.showMessageDialog(null, "Lỗi phép chia cho 0");
				} else {
					ketQua = so1 / so2; ketQua(ketQua);
				}
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + button);
			}
		}
	}
	
	public void ketQua(double ketQua) {
		JOptionPane.showMessageDialog(null, String.valueOf(ketQua));
			textOut.setText(fm.format(ketQua));
	}
}
