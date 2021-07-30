package com.edusys.form;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.edusys.dao.impl.NhanVienDao;

@SuppressWarnings("serial")
public class Login extends JFrame {
	private JPanel contentPane;
	private JTextField textUsername;
	private JPasswordField textPassword;
	static Login frame = new Login();
	String change = "Change password";
	JButton btnLogin = new JButton("Đăng nhập");
	StringBuilder error = new StringBuilder();
	boolean check = false;
	public static String vaiTro;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setVisible(true);
					frame.setTitle("Đăng nhập");
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
	Action loginAction = new AbstractAction() {
		@Override
		public void actionPerformed(ActionEvent e) {
			
		}
	};
	private JButton btnCancel;

	public Login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\udpm\\Image\\fpt.png"));
		setTitle("Đăng nhập");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 682, 384);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setFocusable(true);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textUsername = new JTextField(" Username");
		textUsername.setForeground(Color.black);
		textUsername.setBackground(Color.white);
		textUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textUsername.setColumns(10);
		textUsername.setBorder(new LineBorder(Color.WHITE));
		textUsername.setBounds(342, 77, 257, 35);

		contentPane.add(textUsername);

		textPassword = new JPasswordField();
		textPassword.setForeground(Color.black);
		textPassword.setBackground(Color.white);
		textPassword.setText(" Password");
		textPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textPassword.setColumns(10);
		textPassword.setBorder(new LineBorder(Color.WHITE));
		textPassword.setBounds(342, 138, 257, 35);
		contentPane.add(textPassword);

		JLabel lblLogin = new JLabel("XIN CHÀO!");
		lblLogin.setForeground(Color.BLACK);
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblLogin.setBounds(413, 26, 203, 40);
		contentPane.add(lblLogin);
		btnLogin.setIcon(null);

		btnLogin.setForeground(Color.WHITE);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					login();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnLogin.setBorder(new LineBorder(Color.WHITE));
		btnLogin.setBackground(Color.BLACK);
		btnLogin.setBounds(328, 208, 288, 45);
		contentPane.add(btnLogin);

		JLabel lblUser = new JLabel("");
		lblUser.setIcon(new ImageIcon("C:\\udpm\\Image\\ong.png"));
		lblUser.setBounds(34, 0, 237, 340);
		contentPane.add(lblUser);

		textUsername.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (textUsername.getText().equals(" Username")) {
					textUsername.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (textUsername.getText().equals("")) {
					textUsername.setText(" Username");
				}
			}
		});

		textPassword.addFocusListener(new FocusAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void focusGained(FocusEvent e) {
				if (textPassword.getText().equals(" Password")) {
					textPassword.setText("");
				}
			}

			@SuppressWarnings("deprecation")
			@Override
			public void focusLost(FocusEvent e) {
				if (textPassword.getText().equals("")) {
					textPassword.setText(" Password");
				}
			}
		});

		textUsername.addActionListener(loginAction);
		textPassword.addActionListener(loginAction);
//
		btnLogin.setContentAreaFilled(false);
//
		btnCancel = new JButton("Kết thúc");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setContentAreaFilled(false);
		btnCancel.setBorder(new LineBorder(Color.WHITE));
		btnCancel.setBackground(Color.BLACK);
		btnCancel.setBounds(328, 269, 288, 45);
		contentPane.add(btnCancel);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\udpm\\Image\\login.jpg"));
		lblNewLabel.setBounds(-20, -20, 650, 350);
		lblNewLabel.setBackground(Color.black);
		contentPane.add(lblNewLabel);
		
	}
	
	public void login() throws SQLException {
		@SuppressWarnings("deprecation")
		ResultSet nhanVien = new NhanVienDao().getNhanVien(textUsername.getText(), textPassword.getText());
		if(nhanVien.next()) {
			QLDT qldt = new QLDT();
			qldt.setVisible(true);
			qldt.setLocationRelativeTo(null);
			qldt.getVaiTro(nhanVien.getInt(4), nhanVien.getString(1));
			Login.this.dispose();
		} else {
			JOptionPane.showMessageDialog(null, "Bạn nhập sai thông tin đăng nhập!");
		}
	}
}