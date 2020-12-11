package bai3;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class SignUp extends JFrame {

	private JPanel contentPane;
	private JTextField textUsename;
	private JTextField textPassword;
	private JTextField textConfirm;
	static SignUp frame = new SignUp();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
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
	public SignUp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 355, 257);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblUsername.setBounds(10, 55, 100, 19);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPassword.setBounds(10, 97, 100, 19);
		contentPane.add(lblPassword);
		
		JLabel lblConfirm = new JLabel("Confirm");
		lblConfirm.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblConfirm.setBounds(10, 135, 100, 19);
		contentPane.add(lblConfirm);
		
		textUsename = new JTextField();
		textUsename.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textUsename.setColumns(10);
		textUsename.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textUsename.setBounds(120, 52, 210, 27);
		contentPane.add(textUsename);
		
		textPassword = new JPasswordField();
		textPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textPassword.setColumns(10);
		textPassword.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textPassword.setBounds(120, 94, 210, 27);
		contentPane.add(textPassword);
		
		textConfirm = new JPasswordField();
		textConfirm.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textConfirm.setColumns(10);
		textConfirm.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textConfirm.setBounds(120, 132, 210, 27);
		contentPane.add(textConfirm);
		
		JLabel lblNewLabel = new JLabel("Sign Up");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(120, 11, 184, 32);
		contentPane.add(lblNewLabel);
		
		JButton btnClear = new JButton("Sign up");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				signUp();
			}
		});
		btnClear.setForeground(Color.BLACK);
		btnClear.setContentAreaFilled(false);
		btnClear.setBorder(new LineBorder(new Color(64, 64, 64), 1));
		btnClear.setBackground(SystemColor.activeCaptionBorder);
		btnClear.setBounds(120, 177, 89, 23);
		contentPane.add(btnClear);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnCancel.setForeground(Color.BLACK);
		btnCancel.setContentAreaFilled(false);
		btnCancel.setBorder(new LineBorder(new Color(64, 64, 64), 1));
		btnCancel.setBackground(SystemColor.activeCaptionBorder);
		btnCancel.setBounds(219, 177, 89, 23);
		contentPane.add(btnCancel);
	}
	
	public void signUp() {
		StringBuilder error = new StringBuilder();
		error.append(checkUsername(textUsename.getText()) + checkPassword(textPassword.getText()) + checkConfirm(textConfirm.getText()));
		if(error.toString().isBlank()) {
			if(!textPassword.getText().equals(textConfirm.getText())) {
				JOptionPane.showMessageDialog(null, "Password và Comfirm phải giống nhau!","Lỗi",JOptionPane.ERROR_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Sign up thành công!");
			}
		} else {
			JOptionPane.showMessageDialog(null, error.toString(), "Lỗi", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public String checkUsername(String username) {
		if(username.isBlank()) {
			return "Bạn không được để trống Username!\n";
		} return "";
	}
	
	public String checkPassword(String password) {
		if(password.isBlank()) {
			return "Bạn không được để trống Password!\n";
		} return "";
	}
	
	public String checkConfirm(String confirm) {
		if(confirm.isBlank()) {
			return "Bạn không được để trống Confirm!\n";
		} return "";
	}
}
