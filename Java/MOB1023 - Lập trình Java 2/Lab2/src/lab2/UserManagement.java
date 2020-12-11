package lab2;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class UserManagement extends JFrame {

	private JPanel contentPane;
	private JTextField textUse;
	private JPasswordField textPass;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserManagement frame = new UserManagement();
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
	Boolean radio1;
	Boolean radio2;

	public UserManagement() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 531, 394);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblUserManagement = new JLabel("User Management");
		lblUserManagement.setForeground(Color.BLUE);
		lblUserManagement.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblUserManagement.setBounds(10, 11, 308, 34);
		contentPane.add(lblUserManagement);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 51, 497, 295);
		contentPane.add(tabbedPane);

		ButtonGroup group = new ButtonGroup();

		JPanel panel = new JPanel();
		tabbedPane.addTab("EDITION", null, panel, null);
		panel.setLayout(null);

		JLabel lblUse = new JLabel("Usename");
		lblUse.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUse.setBounds(21, 25, 82, 34);
		panel.add(lblUse);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPassword.setBounds(21, 78, 82, 34);
		panel.add(lblPassword);

		textUse = new JTextField();
		textUse.setColumns(10);
		textUse.setBounds(113, 25, 346, 32);
		panel.add(textUse);

		textPass = new JPasswordField();
		textPass.setColumns(10);
		textPass.setBounds(113, 80, 346, 32);
		panel.add(textPass);

		JLabel lblRole = new JLabel("Role");
		lblRole.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRole.setBounds(21, 124, 82, 34);
		panel.add(lblRole);

		JRadioButton rdbtnUser = new JRadioButton("User");
		rdbtnUser.setFont(new Font("Tahoma", Font.PLAIN, 17));
		rdbtnUser.setBounds(113, 133, 66, 23);
		panel.add(rdbtnUser);

		JRadioButton rdbtnAdmin = new JRadioButton("Admin");
		rdbtnAdmin.setFont(new Font("Tahoma", Font.PLAIN, 17));
		rdbtnAdmin.setBounds(181, 133, 111, 23);
		panel.add(rdbtnAdmin);
		group.add(rdbtnUser);
		group.add(rdbtnAdmin);

		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				radio1 = rdbtnUser.isSelected();
				radio2 = rdbtnAdmin.isSelected();

				login();
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAdd.setBounds(96, 186, 66, 30);
		panel.add(btnAdd);

		JButton btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeTable();
			}
		});
		btnRemove.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnRemove.setBounds(172, 186, 89, 30);
		panel.add(btnRemove);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateTable();
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnUpdate.setBounds(271, 186, 89, 30);
		panel.add(btnUpdate);

		JButton btnResert = new JButton("Reset");
		btnResert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearForm();
			}

		});
		btnResert.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnResert.setBounds(370, 186, 89, 30);
		panel.add(btnResert);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("List", null, panel_1, null);
		panel_1.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 472, 245);
		panel_1.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		tableUse();
		fillTable();

	}

	public void tableUse() {

		model.addColumn("USERNAME");
		model.addColumn("PASSWORD");
		model.addColumn("ROLE");

		table.setModel(model);
	}

	ArrayList<Users> listUser = new ArrayList<Users>();
	boolean check = true;

	public void login() {
		System.out.println(radio1);
		System.out.println(radio2);

		String useName = textUse.getText();
		String pass = textPass.getText();
		String role = null;

		if (useName.trim().length() <= 0 || pass.trim().length() <= 0) {
			JOptionPane.showMessageDialog(null, "Bạn chưa nhập Usename hoặc Password!");
		} else if (radio1 == false && radio2 == false) {
			JOptionPane.showMessageDialog(null, "Bạn chưa chọn Role!");
		} else {
			if (radio1 == true) {
				role = "User";
			} else {
				role = "Admin";
			}
			checkTrung(useName, pass, role);
		}

	}

	public void checkTrung(String user, String pass, String role) {
		listUser.forEach((o1) -> {
			if (o1.getUser().equalsIgnoreCase(user)) {
				check = false;
			}
		});
		if (check == true) {
			readForm(user, pass, role);
			JOptionPane.showMessageDialog(null, "Thêm thành công!");
		} else {
			JOptionPane.showMessageDialog(null, "Người dùng này đã tồn tại!");
			check = true;
		}
	}

	public void readForm(String user, String pass, String role) {
		listUser.add(new Users(user, pass, role));
		fillTable();
	}

	DefaultTableModel model = new DefaultTableModel();

	public void fillTable() {
		int size = model.getRowCount();
		for (int i = size - 1; i >= 0; i--)
			model.removeRow(i);
		listUser.forEach((o1) -> {
			String userString = o1.getUser();
			String passString = o1.getPass();
			String roleString = o1.getRole();
			model.addRow(new Object[] { userString, passString, roleString });
		});
		writeForm();
	}

	public void writeForm() {
		table.setModel(model);
		textUse.setText("");
		textPass.setText("");
	}

	public void clearForm() {
		listUser.clear();
		fillTable();
		JOptionPane.showMessageDialog(null, "Đã reset xong!");
	}

	public void removeTable() {
		int r = table.getSelectedRow();
		if(r < 0) {
			JOptionPane.showMessageDialog(null, "Bạn chưa chọn đối tượng cần xóa!");
		}else {
			System.out.println(r);
			model.removeRow(r);
			JOptionPane.showMessageDialog(null, "Xóa thành công username " + listUser.get(r).getUser());
			listUser.remove(r);
			writeForm();
		}
	}

	public void updateTable() {
		int r = table.getSelectedRow();
		if(r < 0) {
			JOptionPane.showMessageDialog(null, "Bạn chưa chọn đối tượng cần update!");
		}else {
			int size1 = listUser.size();
			login();
			int size2 = listUser.size();
			if (size1 != size2) {
				size2 = size2 - 1;
				System.out.println(r);
				String userString = listUser.get(size2).getUser();
				String passString = listUser.get(size2).getPass();
				String roleString = listUser.get(size2).getRole();

				listUser.get(r).setUser(userString);
				listUser.get(r).setPass(passString);
				listUser.get(r).setRole(roleString);
				listUser.remove(size2);
				fillTable();
			}
		}

	}
}
