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
import entities.Users;

@SuppressWarnings("serial")
public class Login extends JFrame {
	private JPanel contentPane;
	private JTextField textUsername;
	private JPasswordField textPassword;
	static Login frame = new Login();
	JButton btnLogin = new JButton("Login ");
	StringBuilder error = new StringBuilder();
	ArrayList<Users> listUser = new ArrayList<Users>();
	boolean login = false;
	static String vaiTro;

	/**
	 * Launch the application.
	 */
	public static void mainLogin() {
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

	public Login() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 376, 232);
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
		textUsername.setBounds(145, 62, 205, 27);

		contentPane.add(textUsername);

		textPassword = new JPasswordField();
		textPassword.setForeground(Color.black);
		textPassword.setBackground(Color.white);
		textPassword.setText(" Password");
		textPassword.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textPassword.setColumns(10);
		textPassword.setBorder(new LineBorder(Color.WHITE));
		textPassword.setBounds(145, 100, 205, 27);
		contentPane.add(textPassword);

		JLabel lblLogin = new JLabel("User Login");
		lblLogin.setForeground(Color.BLUE);
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblLogin.setBounds(145, 11, 257, 40);
		contentPane.add(lblLogin);
		btnLogin.setIcon(
				new ImageIcon("C:\\Users\\ADMIN\\eclipse-workspace\\Assignment_Java3_PH12794\\src\\Image\\login.png"));

		btnLogin.setForeground(Color.BLACK);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login();

			}
		});
		btnLogin.setBorder(new LineBorder(Color.DARK_GRAY));
		btnLogin.setBackground(Color.BLACK);
		btnLogin.setBounds(145, 152, 89, 23);
		contentPane.add(btnLogin);

		JLabel lblUser = new JLabel("New label");
		lblUser.setIcon(new ImageIcon(
				"C:\\\\Users\\\\ADMIN\\\\eclipse-workspace\\\\Assignment_Java3_PH12794\\\\src\\Image\\user.jpg"));
		lblUser.setBounds(10, 25, 122, 150);
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

		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnLogin.setBounds(142, 149, 95, 29);
				btnLogin.setBorder(new LineBorder(new Color(64, 64, 64), 2));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnLogin.setBounds(145, 152, 89, 23);
				btnLogin.setBorder(new LineBorder(new Color(64, 64, 64), 1));
			}
		});

		btnLogin.setContentAreaFilled(false);

		JButton btnCancel = new JButton("Cancel ");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnCancel.setIcon(
				new ImageIcon("C:\\Users\\ADMIN\\eclipse-workspace\\Assignment_Java3_PH12794\\src\\Image\\exit.png"));
		btnCancel.setForeground(Color.BLACK);
		btnCancel.setContentAreaFilled(false);
		btnCancel.setBorder(new LineBorder(Color.DARK_GRAY));
		btnCancel.setBackground(Color.BLACK);
		btnCancel.setBounds(244, 152, 89, 23);
		contentPane.add(btnCancel);

		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnCancel.setBounds(241, 149, 95, 29);
				btnCancel.setBorder(new LineBorder(new Color(64, 64, 64), 2));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnCancel.setBounds(244, 152, 89, 23);
				btnCancel.setBorder(new LineBorder(new Color(64, 64, 64), 1));
			}
		});
		JLabel bkg = new JLabel();
		bkg.setBounds(0, 0, 385, 262);
		bkg.setIcon(new ImageIcon(
				"C:\\\\Users\\\\ADMIN\\\\eclipse-workspace\\\\Assignment_Java3_PH12794\\\\src\\Image\\backLogin.jpg"));
		contentPane.add(bkg);
		loadUser();
	}

	public void loadUser() {
		try {
			listUser = UserDao.loadUser();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void login() {
		login = false;
		String username = textUsername.getText();
		@SuppressWarnings("deprecation")
		String password = textPassword.getText();
		listUser.forEach((user) -> {
			if(user.username.equals(username)) {
				if(user.password.equals(password)) {
					login = true;
		vaiTro = user.vaiTro;
		QLSV qlsv = new QLSV();
		qlsv.mainQLSV();
		Login.frame.setVisible(false);
				}
			}
		});
		if(login == false) {
			JOptionPane.showMessageDialog(null, "Thông tin đăng nhập không chính xác!");
		}
	}
}
