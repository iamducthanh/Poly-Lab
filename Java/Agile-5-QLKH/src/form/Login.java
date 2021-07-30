package form;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

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

import dao.UserDao;
import entities.User;
import help.DataBaseConnect;
import help.Validate;

@SuppressWarnings("serial")
public class Login extends JFrame {
	private JPanel contentPane;
	private JTextField textUsername;
	private JTextField textPassword;
	private JTextField textComfirm;
	static Login frame = new Login();
	JLabel lblChange = new JLabel();
	String change = "Change password";
	JButton btnChange = new JButton("Change");
	JButton btnLogin = new JButton("Login");
	StringBuilder error = new StringBuilder();
	ArrayList<User> listUser = new ArrayList<User>();
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
					frame.setTitle("Login");
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
			login();
		}
	};
	private JButton btnCancel;
	private JButton btnLoginChange;

	public Login() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 376, 262);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setFocusable(true);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textUsername = new JTextField(" Username");
		textUsername.setForeground(Color.black);
		textUsername.setBackground(Color.white);
		textUsername.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textUsername.setColumns(10);
		textUsername.setBorder(new LineBorder(Color.WHITE));
		textUsername.setBounds(145, 52, 205, 27);

		contentPane.add(textUsername);

		textPassword = new JTextField();
		textPassword.setForeground(Color.black);
		textPassword.setBackground(Color.white);
		textPassword.setText(" Password");
		textPassword.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textPassword.setColumns(10);
		textPassword.setBorder(new LineBorder(Color.WHITE));
		textPassword.setBounds(145, 90, 205, 27);
		contentPane.add(textPassword);

		JLabel lblLogin = new JLabel("User Login");
		lblLogin.setForeground(Color.BLUE);
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblLogin.setBounds(145, 11, 257, 40);
		contentPane.add(lblLogin);

		btnLogin.setForeground(Color.BLACK);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean lo = login();
				if (lo) {
					QLKH qlkh = new QLKH();
					qlkh.mainFrame();
					frame.setVisible(false);
				}
			}
		});
		btnLogin.setBorder(new LineBorder(Color.DARK_GRAY));
		btnLogin.setBackground(Color.BLACK);
		btnLogin.setBounds(144, 179, 89, 23);
		contentPane.add(btnLogin);

		JLabel lblUser = new JLabel("New label");
		lblUser.setIcon(new ImageIcon("C:\\QLKH\\Image\\user.jpg"));
		lblUser.setBounds(13, 52, 122, 150);
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

		lblChange.setText(change);
		lblChange.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblChange.setText("<html><p style=\"text-decoration: underline;\">" + change + "</p></html>");
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblChange.setText("<html><p style=\"text-decoration: none;\">" + change + "</p></html>");
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				changePassword();
			}
		});
		lblChange.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblChange.setForeground(Color.BLUE);
		lblChange.setBounds(145, 128, 141, 14);
		contentPane.add(lblChange);

		textUsername.addActionListener(loginAction);
		textPassword.addActionListener(loginAction);

		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnLogin.setBounds(141, 176, 95, 29);
				btnLogin.setBorder(new LineBorder(new Color(64, 64, 64), 2));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnLogin.setBounds(144, 179, 89, 23);
				btnLogin.setBorder(new LineBorder(new Color(64, 64, 64), 1));
			}
		});

		textComfirm = new JTextField();
		textComfirm.setVisible(false);
		textComfirm.setText(" New Password");
		textComfirm.setForeground(Color.BLACK);
		textComfirm.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textComfirm.setColumns(10);
		textComfirm.setBorder(new LineBorder(Color.WHITE));
		textComfirm.setBackground(Color.WHITE);
		textComfirm.setBounds(145, 128, 205, 27);
		contentPane.add(textComfirm);

		textComfirm.addFocusListener(new FocusAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void focusGained(FocusEvent e) {
				if (textComfirm.getText().equals(" New Password")) {
					textComfirm.setText("");
				}
			}

			@SuppressWarnings("deprecation")
			@Override
			public void focusLost(FocusEvent e) {
				if (textComfirm.getText().equals("")) {
					textComfirm.setText(" New Password");
				}
			}
		});
		btnChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				change();
			}
		});

		btnChange.setForeground(Color.BLACK);
		btnChange.setContentAreaFilled(false);
		btnChange.setBorder(new LineBorder(Color.DARK_GRAY));
		btnChange.setBackground(Color.BLACK);
		btnChange.setBounds(145, 179, 89, 23);
		contentPane.add(btnChange);
		btnChange.setVisible(false);

		btnLogin.setContentAreaFilled(false);

		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancel();
			}
		});
		btnCancel.setForeground(Color.BLACK);
		btnCancel.setContentAreaFilled(false);
		btnCancel.setBorder(new LineBorder(Color.DARK_GRAY));
		btnCancel.setBackground(Color.BLACK);
		btnCancel.setBounds(243, 179, 89, 23);
		contentPane.add(btnCancel);

		btnLoginChange = new JButton("Login");
		btnLoginChange.setForeground(Color.BLACK);
		btnLoginChange.setContentAreaFilled(false);
		btnLoginChange.setBorder(new LineBorder(Color.DARK_GRAY));
		btnLoginChange.setBackground(Color.BLACK);
		btnLoginChange.setBounds(145, 179, 89, 23);
		btnLoginChange.setVisible(false);
		contentPane.add(btnLoginChange);

		btnLoginChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});

		btnCancel.setVisible(false);
		JLabel bkg = new JLabel();
		bkg.setBounds(0, 0, 385, 262);
		bkg.setIcon(new ImageIcon("C:\\QLKH\\Image\\backLogin.jpg"));
		contentPane.add(bkg);
		getUsers();
	}
	
	public void getUsers() {
		listUser.removeAll(listUser);
		listUser = UserDao.loadUser();
	}

	public boolean login() {
		check = false;
		listUser.forEach((user) -> {
			if(user.username.equals(textUsername.getText())) {
				if(user.password.equals(textPassword.getText())) {
					check = true;
					vaiTro = user.vaiTro;
					
				}
			}
		});
		if(check == false) {
			JOptionPane.showMessageDialog(null, "Thông tin đăng nhập không nhập không chính xác!");
		}
		return check;
	}


	public void changePassword() {
		btnLoginChange.setVisible(false);
		lblChange.setText("");
		change = "";
		lblChange.setVisible(false);
		textComfirm.setVisible(true);
		btnLogin.setVisible(false);
		btnChange.setVisible(true);
		btnCancel.setVisible(true);
	}

	public void cancel() {
		lblChange.setText("Change password");
		change = "Change password";
		lblChange.setVisible(true);
		textComfirm.setVisible(false);
		btnLogin.setVisible(true);
		btnChange.setVisible(false);
		btnCancel.setVisible(false);
	}

	@SuppressWarnings("deprecation")
	public void change() {
		listUser.forEach((user) -> {
			if(user.username.equals(textUsername.getText())) {
				if(user.password.equals(textPassword.getText())) {
					try {
						Connection conn = DataBaseConnect.Connect();
						PreparedStatement ps = conn.prepareStatement("update Users Set pass = ? where username = ?");
						ps.setString(1, textComfirm.getText());
						ps.setString(2, textUsername.getText());
						int i = ps.executeUpdate();
						JOptionPane.showMessageDialog(null, "Thay đổi mật khẩu thành công!");
						listUser = UserDao.loadUser();
                                                check = true;
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			}
		});
		if(check == false) {
			JOptionPane.showMessageDialog(null, "Thông tin đăng nhập không nhập không chính xác!");
		}
	}
}
