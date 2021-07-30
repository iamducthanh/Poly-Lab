package com.edusys.form;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.edusys.dao.impl.NhanVienDao;

@SuppressWarnings("serial")
public class ChangePassword extends JFrame {
	static JTextField textUsername;
	private JTextField textPassword;
	static ChangePassword frame = new ChangePassword();
	String change = "Change password";
	JButton btnLogin = new JButton("Đổi mật khẩu");
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
					frame.setTitle("Đổi mật khẩu");
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
	private JTextField textComfirm;

	public ChangePassword() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 682, 420);
		JPanel contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setFocusable(true);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textUsername = new JTextField(" Username");
		textUsername.setEditable(false);
		textUsername.setForeground(Color.black);
		textUsername.setBackground(Color.white);
		textUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textUsername.setColumns(10);
		textUsername.setBorder(new LineBorder(Color.WHITE));
		textUsername.setBounds(360, 76, 268, 27);

		contentPane.add(textUsername);

		textPassword = new JTextField();
		textPassword.setForeground(Color.black);
		textPassword.setBackground(Color.white);
		textPassword.setText(" New Password");
		textPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textPassword.setColumns(10);
		textPassword.setBorder(new LineBorder(Color.WHITE));
		textPassword.setBounds(360, 136, 257, 27);
		contentPane.add(textPassword);

		JLabel lblLogin = new JLabel("ĐỔI MẬT KHẨU");
		lblLogin.setForeground(Color.BLUE);
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblLogin.setBounds(417, 11, 187, 40);
		contentPane.add(lblLogin);

		btnLogin.setForeground(Color.WHITE);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				change();
			}
		});
		btnLogin.setBorder(null);
		btnLogin.setBackground(Color.BLACK);
		btnLogin.setBounds(360, 264, 268, 40);
		contentPane.add(btnLogin);

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
			@Override
			public void focusGained(FocusEvent e) {
				if (textPassword.getText().equals(" New Password")) {
					textPassword.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (textPassword.getText().equals("")) {
					textPassword.setText(" New Password");
				}
			}
		});

		textUsername.addActionListener(loginAction);
		textPassword.addActionListener(loginAction);

//		btnLogin.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseEntered(MouseEvent e) {
//				btnLogin.setBounds(141, 176, 95, 29);
//				btnLogin.setBorder(new LineBorder(new Color(64, 64, 64), 2));
//			}
//
//			@Override
//			public void mouseExited(MouseEvent e) {
//				btnLogin.setBounds(144, 179, 89, 23);
//				btnLogin.setBorder(new LineBorder(new Color(64, 64, 64), 1));
//			}
//		});

		btnLogin.setContentAreaFilled(false);

		btnCancel = new JButton("Hủy");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChangePassword.this.dispose();
			}
		});
//		btnCancel.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseEntered(MouseEvent e) {
//				btnCancel.setBounds(240, 176, 95, 29);
//				btnCancel.setBorder(new LineBorder(new Color(64, 64, 64), 2));
//			}
//
//			@Override
//			public void mouseExited(MouseEvent e) {
//				btnCancel.setBounds(243, 179, 89, 23);
//				btnCancel.setBorder(new LineBorder(new Color(64, 64, 64), 1));
//			}
//		});

		btnCancel.setForeground(Color.WHITE);
		btnCancel.setContentAreaFilled(false);
		btnCancel.setBorder(null);
		btnCancel.setBackground(Color.BLACK);
		btnCancel.setBounds(360, 325, 268, 40);
		contentPane.add(btnCancel);

		textComfirm = new JTextField(" Comfirm password");
		textComfirm.setForeground(Color.BLACK);
		textComfirm.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textComfirm.setColumns(10);
		textComfirm.setBorder(new LineBorder(Color.WHITE));
		textComfirm.setBackground(Color.WHITE);
		textComfirm.setBounds(360, 196, 268, 27);
		contentPane.add(textComfirm);

		textComfirm.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (textComfirm.getText().equals(" Comfirm password")) {
					textComfirm.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (textComfirm.getText().equals("")) {
					textComfirm.setText(" Comfirm password");
				}
			}
		});
		
		JLabel lblUser = new JLabel("");
		lblUser.setIcon(new ImageIcon("C:\\udpm\\Image\\ong.png"));
		lblUser.setBounds(38, 43, 237, 340);
		contentPane.add(lblUser);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\udpm\\Image\\changepass.jpg"));
		lblNewLabel.setBounds(0, -20, 650, 420);
		lblNewLabel.setBackground(Color.black);
		contentPane.add(lblNewLabel);
		

	}

	public void getUser(String user) {
		textUsername.setText(user);
	}

	public void change() {
		if (textComfirm.getText().equals(textPassword.getText())) {
			new NhanVienDao().changePass(textUsername.getText(), textComfirm.getText());
			ChangePassword.this.dispose();
		} else {
			JOptionPane.showMessageDialog(null, "New password và comfirm password phải giống nhau!");
		}
	}
}