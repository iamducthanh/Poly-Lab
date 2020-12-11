package lab2;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textUse;
	private JTextField textPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	Boolean checkBoolean;
	private JPasswordField passwordField;

	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 50, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblLogin = new JLabel("LOGIN FROM");
		lblLogin.setForeground(Color.BLUE);
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblLogin.setBounds(113, 11, 308, 34);
		contentPane.add(lblLogin);

		JLabel lblUse = new JLabel("Usename");
		lblUse.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUse.setBounds(21, 56, 82, 34);
		contentPane.add(lblUse);

		JLabel lblPass = new JLabel("Password");
		lblPass.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPass.setBounds(21, 106, 82, 34);
		contentPane.add(lblPass);

		textUse = new JTextField();
		textUse.setBounds(113, 56, 300, 32);
		contentPane.add(textUse);
		textUse.setColumns(10);

		textPass = new JPasswordField();
		textPass.setColumns(10);
		textPass.setBounds(121, 136, 300, 32);
		contentPane.add(textPass);

		JCheckBox chckbxRemember = new JCheckBox("Remember me?");
		chckbxRemember.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chckbxRemember.setBounds(113, 160, 169, 23);
		contentPane.add(chckbxRemember);

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkBoolean = chckbxRemember.isSelected();
				login();
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLogin.setBounds(113, 211, 89, 30);
		contentPane.add(btnLogin);

		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chckbxRemember.setSelected(true);
				resert();
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnReset.setBounds(212, 211, 89, 30);
		contentPane.add(btnReset);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(113, 105, 251, 20);
		contentPane.add(passwordField);
	}

	public void login() {
		String useName = "fpt";
		String passWord = "polytechnic";

		String use = textUse.getText();
		String pass = textPass.getText();

		if (use.equals(useName) && pass.equals(passWord)) {
			if (checkBoolean == true) {
				JOptionPane.showMessageDialog(null, "Đăng nhập thành công!\nTài khoản của bạn đã được ghi nhớ!");
			} else {
				JOptionPane.showMessageDialog(null, "Đăng nhập thành công!");
			}
		} else if (use.trim().length() <= 0 || pass.trim().length() <= 0) {
			JOptionPane.showMessageDialog(null, "Bạn chưa nhập tài khoản hoặc mật khẩu!");
		} else {
			JOptionPane.showMessageDialog(null, "Bạn nhập sai tài khoản hoặc mật khẩu!");
		}

	}

	public void resert() {
		textUse.setText("");
		textPass.setText("");
	}
}
