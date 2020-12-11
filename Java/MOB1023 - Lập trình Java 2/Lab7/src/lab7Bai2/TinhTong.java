package lab7Bai2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TinhTong extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textTong;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TinhTong frame = new TinhTong();
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
	public TinhTong() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setBounds(133, 11, 293, 41);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField_1.setColumns(10);
		textField_1.setBounds(133, 63, 293, 41);
		contentPane.add(textField_1);
		
		textTong = new JTextField();
		textTong.setEnabled(false);
		textTong.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textTong.setColumns(10);
		textTong.setBounds(133, 115, 293, 41);
		contentPane.add(textTong);
		
		JButton btnNewButton = new JButton("T\u00EDnh T\u1ED5ng");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					double so1 = Double.parseDouble(textField.getText());
					double so2 = Double.parseDouble(textField_1.getText());
					double tong = so1 + so2;
					int tongInt = (int) tong;
					if(tong % tongInt == 0) {
						textTong.setText(String.valueOf(tongInt));
					} else {
						textTong.setText(String.valueOf(tong));
					}
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "Nhập sai định dạng số");
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(133, 181, 118, 41);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("S\u1ED1 1:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(31, 22, 66, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblS = new JLabel("S\u1ED1 2:");
		lblS.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblS.setBounds(31, 74, 66, 30);
		contentPane.add(lblS);
		
		JLabel lblTng = new JLabel("T\u1ED5ng:");
		lblTng.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTng.setBounds(31, 126, 66, 30);
		contentPane.add(lblTng);
	}
}
