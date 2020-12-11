package bai2;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

public class QLUser extends JFrame {
	private JPanel contentPane;
	private JTextField textMaSV;
	private JLabel lblHoTen;
	private JTextField textHoTen;
	private JTextField textEmail;
	private JTextField textSoDT;
	private JLabel lblEmail;
	private JLabel lblSoDT;
	private JButton btnDelete;
	private JButton btnUpdate;
	private JButton btnSave;
	private JButton btnFirst;
	private JButton btnprevious;
	private JButton btnNext;
	private JButton btnLast;
	JButton btnAdd = new JButton("Add     ");
	ArrayList<Users> listUsers = new ArrayList<Users>();
	StringBuilder error = new StringBuilder();
	int current = 0;
	JRadioButton rdbtnNam = new JRadioButton("Nam");
	JRadioButton rdbtnNu = new JRadioButton("Nữ");
	JTextArea textDiaChi = new JTextArea(19, 19);
	private JButton btnCancel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QLUser frame = new QLUser();
					frame.setVisible(true);
					frame.setTitle("Quản lý user");
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
	public QLUser() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 416);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Quản Lý User");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 21));
		lblNewLabel.setBounds(138, 11, 160, 31);
		contentPane.add(lblNewLabel);

		JLabel lblMaSV = new JLabel("Mã SV:");
		lblMaSV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMaSV.setBounds(40, 65, 58, 23);
		contentPane.add(lblMaSV);

		textMaSV = new JTextField();
		textMaSV.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textMaSV.setBounds(108, 65, 172, 27);
		textMaSV.setBorder(null);
		contentPane.add(textMaSV);
		textMaSV.setColumns(10);

		lblHoTen = new JLabel("Họ tên:");
		lblHoTen.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblHoTen.setBounds(40, 103, 58, 23);
		contentPane.add(lblHoTen);

		textHoTen = new JTextField();
		textHoTen.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textHoTen.setColumns(10);
		textHoTen.setBorder(null);
		textHoTen.setBounds(108, 103, 172, 27);
		contentPane.add(textHoTen);

		textEmail = new JTextField();
		textEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textEmail.setColumns(10);
		textEmail.setBorder(null);
		textEmail.setBounds(108, 141, 172, 27);
		contentPane.add(textEmail);

		textSoDT = new JTextField();
		textSoDT.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textSoDT.setColumns(10);
		textSoDT.setBorder(null);
		textSoDT.setBounds(108, 181, 172, 27);
		contentPane.add(textSoDT);

		lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEmail.setBounds(40, 141, 58, 23);
		contentPane.add(lblEmail);

		lblSoDT = new JLabel("Số ĐT:");
		lblSoDT.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSoDT.setBounds(40, 181, 58, 23);
		contentPane.add(lblSoDT);

		btnAdd.setEnabled(false);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					addSV();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnAdd.setIcon(new ImageIcon("C:\\Users\\ADMIN\\eclipse-workspace\\Lab5\\src\\Image\\Button-Add-icon.png"));
		btnAdd.setBackground(SystemColor.activeCaptionBorder);
		btnAdd.setBorder(new BevelBorder(BevelBorder.RAISED));
		btnAdd.setBounds(306, 99, 89, 23);
		contentPane.add(btnAdd);

		btnDelete = new JButton("Delete ");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int comfirm = JOptionPane.showConfirmDialog(null,
						"Bạn có muốn xóa sinh viên " + listUsers.get(current).maSV + "?");
				if (comfirm == 0) {
					delete(textMaSV.getText());
					JOptionPane.showMessageDialog(null, "Xóa thành công!");
				}
			}
		});
		btnDelete.setIcon(new ImageIcon("C:\\Users\\ADMIN\\eclipse-workspace\\Lab5\\src\\Image\\delete.png"));
		btnDelete.setBorder(new BevelBorder(BevelBorder.RAISED));
		btnDelete.setBackground(SystemColor.activeCaptionBorder);
		btnDelete.setBounds(306, 133, 89, 23);
		contentPane.add(btnDelete);

		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update();
			}
		});
		btnUpdate.setIcon(new ImageIcon("C:\\Users\\ADMIN\\eclipse-workspace\\Lab5\\src\\Image\\update.png"));
		btnUpdate.setBorder(new BevelBorder(BevelBorder.RAISED));
		btnUpdate.setBackground(SystemColor.activeCaptionBorder);
		btnUpdate.setBounds(306, 201, 89, 23);
		contentPane.add(btnUpdate);

		btnSave = new JButton("Find    ");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = 0;
				String maFind = JOptionPane.showInputDialog("Nhập mã sinh viên cần tìm: ");
				for(;i<listUsers.size();i++) {
					if(listUsers.get(i).maSV.equalsIgnoreCase(maFind)) {
						current = i;
						display(current);
						JOptionPane.showMessageDialog(null, "Đã tìm thấy!");
						break;
					}
				}
				if(i == listUsers.size()) {
					JOptionPane.showMessageDialog(null, "Không tìm thấy sinh viên nào có mã này!");
				}
			}
		});
		btnSave.setIcon(new ImageIcon("C:\\Users\\ADMIN\\eclipse-workspace\\QLKH\\src\\Image\\find.png"));
		btnSave.setBorder(new BevelBorder(BevelBorder.RAISED));
		btnSave.setBackground(SystemColor.activeCaptionBorder);
		btnSave.setBounds(306, 167, 89, 23);
		contentPane.add(btnSave);

		rdbtnNam.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnNam.setBackground(SystemColor.activeCaptionBorder);
		rdbtnNam.setBounds(118, 219, 58, 23);
		contentPane.add(rdbtnNam);

		JLabel lblGioiTinh = new JLabel("Giới tính:");
		lblGioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGioiTinh.setBounds(40, 219, 76, 23);
		contentPane.add(lblGioiTinh);

		rdbtnNu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnNu.setBackground(SystemColor.activeCaptionBorder);
		rdbtnNu.setBounds(185, 219, 58, 23);
		contentPane.add(rdbtnNu);

		JLabel lblDiaChi = new JLabel("Địa chỉ: ");
		lblDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDiaChi.setBounds(40, 253, 56, 23);
		contentPane.add(lblDiaChi);
		textDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 13));

		textDiaChi.setBounds(108, 254, 287, 58);
		contentPane.add(textDiaChi);

		btnFirst = new JButton("|<");
		btnFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				first();
			}
		});
		btnFirst.setBorder(new BevelBorder(BevelBorder.RAISED));
		btnFirst.setBackground(SystemColor.activeCaptionBorder);
		btnFirst.setBounds(108, 333, 41, 23);
		contentPane.add(btnFirst);

		btnprevious = new JButton("<<");
		btnprevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				previous();
			}
		});
		btnprevious.setBorder(new BevelBorder(BevelBorder.RAISED));
		btnprevious.setBackground(SystemColor.activeCaptionBorder);
		btnprevious.setBounds(159, 333, 41, 23);
		contentPane.add(btnprevious);

		btnNext = new JButton(">>");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				next();
			}
		});
		btnNext.setBorder(new BevelBorder(BevelBorder.RAISED));
		btnNext.setBackground(SystemColor.activeCaptionBorder);
		btnNext.setBounds(210, 333, 41, 23);
		contentPane.add(btnNext);

		btnLast = new JButton(">|");
		btnLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				last();
			}
		});
		rdbtnNam.setSelected(true);
		btnLast.setBorder(new BevelBorder(BevelBorder.RAISED));
		btnLast.setBackground(SystemColor.activeCaptionBorder);
		btnLast.setBounds(261, 333, 41, 23);
		contentPane.add(btnLast);
		try {
			loadData();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(listUsers.size() == 0) {
			textMaSV.setText("");
			textHoTen.setText("");
			textDiaChi.setText("");
			textEmail.setText("");
			textSoDT.setText("");
		} else {
			display(current);
		}

		ButtonGroup gr = new ButtonGroup();
		gr.add(rdbtnNam);
		gr.add(rdbtnNu);

		JButton btnClear = new JButton("Clear   ");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textMaSV.setText("");
				textHoTen.setText("");
				textDiaChi.setText("");
				textEmail.setText("");
				textSoDT.setText("");

				rdbtnNam.setSelected(true);
				btnAdd.setEnabled(true);
				btnCancel.setVisible(true);
				btnDelete.setVisible(false);
				btnUpdate.setVisible(false);
				btnSave.setVisible(false);
			}
		});
		btnClear.setIcon(new ImageIcon("C:\\Users\\ADMIN\\eclipse-workspace\\QLKH\\src\\Image\\clear.png"));
		btnClear.setBorder(new BevelBorder(BevelBorder.RAISED));
		btnClear.setBackground(SystemColor.activeCaptionBorder);
		btnClear.setBounds(306, 65, 89, 23);
		contentPane.add(btnClear);

		btnCancel = new JButton("Cancel");
		btnCancel.setBorder(new BevelBorder(BevelBorder.RAISED));
		btnCancel.setBackground(SystemColor.activeCaptionBorder);
		btnCancel.setBounds(306, 133, 89, 23);
		contentPane.add(btnCancel);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAdd.setEnabled(false);
				btnCancel.setVisible(false);
				btnDelete.setVisible(true);
				btnUpdate.setVisible(true);
				btnSave.setVisible(true);
				display(current);
			}
		});
	}

	public void loadData() throws ClassNotFoundException, SQLException {
		listUsers.removeAll(listUsers);
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection conn = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-NU1HNR3:1433;databaseName=QLUSER", "sa",
				"123");
		Statement statement = conn.createStatement();
		ResultSet User = statement.executeQuery("SELECT * FROM TBUSER");
		while (User.next()) {
			String maSV = User.getString("MASV");
			String hoTen = User.getString("HOTEN");
			String email = User.getString("EMAIL");
			String soDT = User.getString("SODT");
			String gioiTinh = User.getString("GIOITINH");
			String diaChi = User.getString("DIACHI");
			listUsers.add(new Users(maSV, hoTen, email, soDT, gioiTinh, diaChi));
		}
		conn.close();
	}
	
	public void update() {
		String gioiTinh;
		validateUpdate(textMaSV.getText(), textHoTen.getText(), textEmail.getText(), textSoDT.getText(),
				textDiaChi.getText());
		if (error.toString().isBlank()) {
			if (rdbtnNam.isSelected()) {
				gioiTinh = "Nam";
			} else {
				gioiTinh = "Nữ";
			}
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				Connection conn = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=QLUSER", "sa", "123");
				PreparedStatement ps = conn.prepareStatement("UPDATE TBUSER SET HOTEN = ?, EMAIL = ?, SODT = ?, GIOITINH = ?, DIACHI = ? WHERE MASV = ?");
				ps.setString(1, textHoTen.getText());
				ps.setString(2, textEmail.getText());
				ps.setString(3, textSoDT.getText());
				ps.setString(4, gioiTinh);
				ps.setString(5, textDiaChi.getText());
				ps.setString(6, textMaSV.getText());
				ps.execute();
				loadData();
				display(current);
				conn.close();
				JOptionPane.showMessageDialog(null, "Update thành công!");
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			JOptionPane.showMessageDialog(null, error.toString(), "Lỗi", JOptionPane.ERROR_MESSAGE);
		}
	}

	public boolean addSV() throws ClassNotFoundException, SQLException {
		String gioiTinh;
		validateForm(textMaSV.getText(), textHoTen.getText(), textEmail.getText(), textSoDT.getText(),
				textDiaChi.getText());
		if (error.toString().isBlank()) {
			if (rdbtnNam.isSelected()) {
				gioiTinh = "Nam";
			} else {
				gioiTinh = "Nữ";
			}

			btnAdd.setEnabled(false);
			btnCancel.setVisible(false);
			btnDelete.setVisible(true);
			btnUpdate.setVisible(true);
			btnSave.setVisible(true);
			JOptionPane.showMessageDialog(null, "Thêm thành công!");

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-NU1HNR3:1433;databaseName=QLUSER",
					"sa", "123");
			PreparedStatement ps = conn.prepareStatement("INSERT INTO TBUSER VALUES (?,?,?,?,?,?)");
			String maSV = textMaSV.getText();
			ps.setString(1, maSV);
			ps.setString(2, textHoTen.getText());
			ps.setString(3, textEmail.getText());
			ps.setString(4, textSoDT.getText());
			ps.setString(5, gioiTinh);
			ps.setString(6, textDiaChi.getText());
			ps.execute();
			conn.close();
			loadData();
			for(int i=0;i<listUsers.size();i++) {
				if(listUsers.get(i).equals(maSV)) {
					current = i;
					break;
				}
			}
			display(current);
			return true;
		} else {
			JOptionPane.showMessageDialog(null, error.toString(), "Lỗi", JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}
	
	public void delete(String maSV) {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=QLUSER", "sa", "123");
//			Statement statement = conn.createStatement();
//			statement.execute("DELETE FROM TBUSER WHERE MASV = " + maSV);
			PreparedStatement delete = conn.prepareStatement("DELETE FROM TBUSER WHERE MASV = ?");
			delete.setString(1, maSV);
			delete.execute();
			conn.close();
			loadData();
			if(listUsers.size() == 0) {
				textMaSV.setText("");
				textHoTen.setText("");
				textDiaChi.setText("");
				textEmail.setText("");
				textSoDT.setText("");
			} else {
				display(current);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void display(int i) {
		textMaSV.setText(listUsers.get(i).maSV);
		textHoTen.setText(listUsers.get(i).hoTen);
		textEmail.setText(listUsers.get(i).email);
		textSoDT.setText(listUsers.get(i).soDT);
		if (listUsers.get(i).gioiTinh.equalsIgnoreCase("Nam")) {
			rdbtnNam.setSelected(true);
		} else {
			rdbtnNu.setSelected(true);
		}
		textDiaChi.setText(listUsers.get(i).diaChi);

	}

	public void validateForm(String maSV, String hoTen, String email, String soDT, String diaChi) {
		error.setLength(0);
		if (maSV.isBlank()) {
			error.append("Bạn không được để trống mã sinh viên!\n");
		} else {
			listUsers.forEach((SV) -> {
				if (SV.maSV.equalsIgnoreCase(maSV)) {
					error.append("Mã sinh viên này đã tồn tại!\n");
				}
			});
		}
		if (hoTen.isBlank()) {
			error.append("Bạn không được để trống họ tên!\n");
		}
		if (email.isBlank()) {
			error.append("Bạn không được để trống email!\n");
		} else {
			String checkMail = "^[a-zA-Z][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$";
			if (!email.matches(checkMail)) {
				error.append("Vui lòng nhập đúng định dạng email!\n");
			}
		}
		if (soDT.isBlank()) {
			error.append("Bạn không được để trống số điện thoại!\n");
		} else {
			String reSDT = "[0]{1}[1-9]{9}";
			if (!soDT.matches(reSDT)) {
				error.append("Vui lòng nhập đúng dạng số điện thoại!\n");
			}
		}
		if (diaChi.isBlank()) {
			error.append("Bạn không được để trống địa chỉ!\n");
		}

	}
	
	public void validateUpdate(String maSV, String hoTen, String email, String soDT, String diaChi) {
		int a = -1;
		error.setLength(0);
		if (maSV.isBlank()) {
			error.append("Bạn không được để trống mã sinh viên!\n");
		} else {	
			if(!listUsers.get(current).maSV.equalsIgnoreCase(textMaSV.getText())) {
				error.append("Bạn không được thay đổi mã sinh viên!");
			}
		}
		if (hoTen.isBlank()) {
			error.append("Bạn không được để trống họ tên!\n");
		}
		if (email.isBlank()) {
			error.append("Bạn không được để trống email!\n");
		} else {
			String checkMail = "^[a-zA-Z][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$";
			if (!email.matches(checkMail)) {
				error.append("Vui lòng nhập đúng định dạng email!\n");
			}
		}
		if (soDT.isBlank()) {
			error.append("Bạn không được để trống số điện thoại!\n");
		} else {
			String reSDT = "[0]{1}[1-9]{9}";
			if (!soDT.matches(reSDT)) {
				error.append("Vui lòng nhập đúng dạng số điện thoại!\n");
			}
		}
		if (diaChi.isBlank()) {
			error.append("Bạn không được để trống địa chỉ!\n");
		}
	}

	public void first() {
		current = 0;
		display(current);
	}

	public void last() {
		current = listUsers.size() - 1;
		display(current);
	}

	public void next() {
		current += 1;
		if (current == listUsers.size()) {
			current = 0;
		}
		display(current);
	}

	public void previous() {
		current -= 1;
		if (current == -1) {
			current = listUsers.size() - 1;
		}
		display(current);
	}
}
