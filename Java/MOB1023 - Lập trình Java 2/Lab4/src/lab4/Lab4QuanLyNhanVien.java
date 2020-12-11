package lab4;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Lab4QuanLyNhanVien extends JFrame {

	private JPanel contentPane;
	private JTextField textName;
	private JTextField textNgaySinh;
	private JTextField textLuong;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lab4QuanLyNhanVien frame = new Lab4QuanLyNhanVien();
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
	public Lab4QuanLyNhanVien() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 551, 278);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblQun = new JLabel("QUẢN LÝ SINH VIÊN");
		lblQun.setForeground(Color.RED);
		lblQun.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblQun.setBounds(112, 11, 308, 34);
		contentPane.add(lblQun);

		JLabel lblName = new JLabel("HỌ VÀ TÊN");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblName.setBounds(10, 52, 109, 34);
		contentPane.add(lblName);

		JLabel lblNgaySinh = new JLabel("NG\u00C0Y SINH");
		lblNgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNgaySinh.setBounds(10, 97, 109, 34);
		contentPane.add(lblNgaySinh);

		JLabel lblLuong = new JLabel("L\u01AF\u01A0NG");
		lblLuong.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLuong.setBounds(10, 142, 109, 34);
		contentPane.add(lblLuong);

		textName = new JTextField();
		textName.setColumns(10);
		textName.setBounds(112, 56, 415, 32);
		contentPane.add(textName);

		textNgaySinh = new JTextField();
		textNgaySinh.setColumns(10);
		textNgaySinh.setBounds(112, 97, 415, 32);
		contentPane.add(textNgaySinh);

		textLuong = new JTextField();
		textLuong.setColumns(10);
		textLuong.setBounds(112, 142, 415, 32);
		contentPane.add(textLuong);

		JButton btnKiemTra = new JButton("KI\u1EC2M TRA");
		btnKiemTra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				kiemTra();
			}

			private void kiemTra() {
				checkName();
				checkLuong();
				checkNgaySinh();
				if (!checkName() || !checkLuong() || !checkNgaySinh()) {
					JOptionPane.showMessageDialog(null, "Bạn không được để trống dữ liệu!");
				} else if(reNgaySinh() && reLuong()){
					JOptionPane.showMessageDialog(null, "Successfully");
				}

			}

			public boolean reLuong() {
				String reLuongString = "[0-9]{0,50}";
				if (!textLuong.getText().matches(reLuongString)) {
					textLuong.setBackground(Color.YELLOW);
					JOptionPane.showMessageDialog(null, "Bạn nhập sai kiểu dữ liệu lương");
					return false;
				} else {
					textLuong.setBackground(Color.white);
					return true;
				}
			}

			public boolean reNgaySinh() {  
				XDate xDate = new XDate();
				try {
				xDate.parse(textNgaySinh.getText(), "dd-MM-yyyy");
				textLuong.setBackground(Color.white);
				return true;
				}catch (Exception e) {
					textNgaySinh.setBackground(Color.YELLOW);
					JOptionPane.showMessageDialog(null, "Bạn nhập sai ngày sinh dd/mm/yyyy");
					return false;
				}
			}

			public boolean checkName() {
				if (textName.getText().trim().length() <= 0) {
					textName.setBackground(Color.YELLOW);
					return false;
				} else {
					textName.setBackground(Color.white);
					return true;
				}
			}

			public boolean checkLuong() {
				if (textLuong.getText().trim().length() <= 0) {
					textLuong.setBackground(Color.YELLOW);
					return false;
				} else {
					textLuong.setBackground(Color.white);
					return true;
				}
			}

			public boolean checkNgaySinh() {
				if (textNgaySinh.getText().trim().length() <= 0) {
					textNgaySinh.setBackground(Color.YELLOW);
					return false;
				} else {
					textNgaySinh.setBackground(Color.white);
					return true;
				}
			}
		});
		btnKiemTra.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnKiemTra.setBounds(112, 190, 117, 34);
		contentPane.add(btnKiemTra);
	}
}
