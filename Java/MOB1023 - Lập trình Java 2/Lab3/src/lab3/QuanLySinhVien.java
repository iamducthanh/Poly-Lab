package lab3;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class QuanLySinhVien extends JFrame {

	private JPanel contentPane;
	private JTextField textName;
	private JTextField textDiem;
	private JTextField textHocLuc;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuanLySinhVien frame = new QuanLySinhVien();
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
	JCheckBox chckbxThuong = new JCheckBox("C\u00F3 ph\u1EA7n th\u01B0\u1EDFng?");

	public QuanLySinhVien() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 589);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblQun = new JLabel("QU\u1EA2N L\u00DD SINH VI\u00CAN");
		lblQun.setBounds(149, 11, 308, 34);
		lblQun.setForeground(Color.RED);
		lblQun.setFont(new Font("Tahoma", Font.BOLD, 26));
		contentPane.add(lblQun);

		JLabel lblName = new JLabel("H\u1ECC V\u00C0 T\u00CAN");
		lblName.setBounds(15, 61, 109, 34);
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(lblName);

		textName = new JTextField();
		textName.setBounds(120, 56, 444, 32);
		textName.setColumns(10);
		contentPane.add(textName);

		JLabel lblDiem = new JLabel("\u0110I\u1EC2M");
		lblDiem.setBounds(15, 110, 109, 34);
		lblDiem.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(lblDiem);

		JLabel lblNganh = new JLabel("NG\u00C0NH");
		lblNganh.setBounds(15, 155, 109, 34);
		lblNganh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(lblNganh);

		JLabel lblHocLuc = new JLabel("H\u1ECCC L\u1EF0C");
		lblHocLuc.setBounds(15, 200, 109, 34);
		lblHocLuc.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(lblHocLuc);

		textDiem = new JTextField();
		textDiem.setBounds(120, 106, 444, 32);
		textDiem.setColumns(10);
		contentPane.add(textDiem);

		textHocLuc = new JTextField();
		textHocLuc.setBackground(Color.WHITE);
		textHocLuc.setFont(new Font("Tahoma", Font.BOLD, 14));
		textHocLuc.setForeground(Color.BLACK);
		textHocLuc.setBounds(120, 196, 444, 32);
		textHocLuc.setColumns(10);
		contentPane.add(textHocLuc);

		JComboBox comboBoxNganh = new JComboBox();
		comboBoxNganh.setBounds(120, 155, 189, 25);
		comboBoxNganh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		String[] comboBoxNganhString = new String[] { "\u1EE8ng d\u1EE5ng ph\u1EA7n m\u1EC1m",
				"Thi\u1EBFt k\u1EBF website", "Thi\u1EBFt k\u1EBF \u0111\u1ED3 h\u1ECDa" };
		comboBoxNganh.setModel(new DefaultComboBoxModel(comboBoxNganhString));
		contentPane.add(comboBoxNganh);

		chckbxThuong.setBounds(120, 241, 216, 23);
		chckbxThuong.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(chckbxThuong);

		JButton btnThm = new JButton("Th\u00EAm");
		btnThm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (addStudent((String) comboBoxNganh.getSelectedItem())) {
					textName.setText("");
					textDiem.setText("");
					textHocLuc.setText("");
					comboBoxNganh.setSelectedIndex(0);
					chckbxThuong.setSelected(false);
				}
			}
		});
		btnThm.setBounds(120, 271, 71, 30);
		btnThm.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(btnThm);

		JButton btnXa = new JButton("X\u00F3a");
		btnXa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeStudent();
			}
		});
		btnXa.setBounds(201, 271, 57, 30);
		btnXa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(btnXa);

		JButton btnRemove_1_1 = new JButton("C\u1EADp nh\u1EADt");
		btnRemove_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(comboBoxNganh.getSelectedIndex());
				System.out.println(comboBoxNganhString[comboBoxNganh.getSelectedIndex()]);
				updateStudent(comboBoxNganhString[comboBoxNganh.getSelectedIndex()]);

			}
		});
		btnRemove_1_1.setBounds(268, 271, 109, 30);
		btnRemove_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(btnRemove_1_1);

		JButton btnRemove_1_2 = new JButton("L\u00E0m m\u1EDBi");
		btnRemove_1_2.setBounds(387, 271, 89, 30);
		btnRemove_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nhapMoi();
			}

			public void nhapMoi() {
				textName.setText("");
				textDiem.setText("");
				textHocLuc.setText("");
				comboBoxNganh.setSelectedIndex(0);
				chckbxThuong.setSelected(false);
			}
		});
		btnRemove_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		contentPane.add(btnRemove_1_2);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(15, 322, 550, 158);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				textName.setText(listStudents.get(row).name);
				textDiem.setText((String) listStudents.get(row).stringMarks());
				textHocLuc.setText(listStudents.get(row).getGrade(listStudents.get(row).marks));
				for (int i = 0; i < comboBoxNganhString.length; i++) {
					if (listStudents.get(row).major == comboBoxNganhString[i]) {
						comboBoxNganh.setSelectedIndex(i);
					}
				}
				chckbxThuong.setSelected(listStudents.get(row).isBonus(listStudents.get(row).marks));
			}
		});

		JButton btnSpXpTheo = new JButton("Sắp xếp theo điểm");
		btnSpXpTheo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sapXepTheoDiem(i);
			}
		});
		textHocLuc.setEnabled(false);
		chckbxThuong.setEnabled(false);

		btnSpXpTheo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSpXpTheo.setBounds(15, 491, 160, 30);
		contentPane.add(btnSpXpTheo);

		JButton btnRemove_1_1_1 = new JButton("Sắp xếp theo tên");
		btnRemove_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sapXepTheoTen();
			}
		});
		btnRemove_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRemove_1_1_1.setBounds(185, 491, 160, 30);
		contentPane.add(btnRemove_1_1_1);
		tableColums();
		getCheck(chckbxThuong.isSelected());

	}

	public void showinfo() {
		int index = table.getSelectedRow();
		Student sv = listStudents.get(index);
		textName.setText(sv.name);
		textDiem.setText("" + sv.marks);
	}

	public boolean getCheck(boolean checkThuong) {
		return checkThuong;
	}

	DefaultTableModel model = new DefaultTableModel();

	public void tableColums() {
		model.addColumn("HỌ VÀ TÊN");
		model.addColumn("ĐIỂM");
		model.addColumn("NGÀNH");
		model.addColumn("HỌC LỰC");
		model.addColumn("THƯỞNG");
		table.setModel(model);
	}

	List<Student> listStudents = new ArrayList<Student>();
	Student SV = new Student();
	String nameString;
	double marks;
	String majorString;
	String gradeString;
	String bonusString;
	int i = 0;
	Scanner scanner = new Scanner(System.in);

	public boolean addStudent(String major) {

		if (checkInput() && checkMarks()) {
			majorString = major;
			listStudents.add(new Student(nameString, marks, majorString));
			textHocLuc.setText(SV.getGrade(marks));
			chckbxThuong.setSelected(SV.isBonus(marks));
			fillToTable();
			return true;
		} else
			return false;
	}

	public boolean checkInput() {
		nameString = textName.getText();
		String markString = textDiem.getText();
		if (nameString.trim().length() <= 0 || markString.trim().length() <= 0) {
			JOptionPane.showMessageDialog(null, "Bạn không được để trống dữ liệu");
			return false;
		} else {
			return true;
		}
	}

	public boolean checkMarks() {
		String markString = textDiem.getText();
		try {
			marks = Double.parseDouble(markString);
			if (marks > 10 || marks < 0) {
				JOptionPane.showMessageDialog(null, "Bạn nhập sai điểm!");
				return false;
			} else {
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Bạn nhập sai kiểu dữ liệu của điểm!");
			return false;
		}
	}

	public void fillToTable() {
		model.setRowCount(0);
		listStudents.forEach((o1) -> {
			if (o1.isBonus(o1.marks)) {
				bonusString = "Có";
			} else {
				bonusString = "Không";
			}
			model.addRow(new Object[] { o1.name, o1.marks, o1.major, o1.getGrade(o1.marks), bonusString });
		});
		table.getColumnModel().getColumn(4).setPreferredWidth(20);
		table.getColumnModel().getColumn(3).setPreferredWidth(20);
		table.getColumnModel().getColumn(2).setPreferredWidth(70);
		table.getColumnModel().getColumn(1).setPreferredWidth(15);
	}

	public void removeStudent() {
		int row = table.getSelectedRow();
		if (row < 0) {
			JOptionPane.showMessageDialog(null, "Bạn chưa chọn sinh viên cần xóa!");
		} else {
			System.out.println(row);
			listStudents.remove(row);
			fillToTable();
		}
	}

	public void updateStudent(String major) {
		int row = table.getSelectedRow();
		System.out.println(row);
		if (row < 0) {
			JOptionPane.showMessageDialog(null, "Bạn chưa chọn sinh viên cần update");
		} else {
			int size = listStudents.size();
			addStudent(major);
			if (size != listStudents.size()) {
				listStudents.get(row).setName(listStudents.get(size).name);
				listStudents.get(row).setMarks(listStudents.get(size).marks);
				listStudents.get(row).setMajor(listStudents.get(size).major);
				listStudents.remove(size);
				fillToTable();
			}
		}
	}

	public void sapXepTheoDiem(int i) {
		if (i == 0) {
			Collections.sort(listStudents, (o1, o2) -> {
				return o1.marks > o2.marks ? 1 : -1;
			});
			this.i = 1;
		} else {
			Collections.sort(listStudents, (o2, o1) -> {
				return new Double(o1.marks).compareTo(new Double(o2.marks));
			});
			this.i = 0;
		}
		fillToTable();
	}

	public void sapXepTheoTen() {
		Collections.sort(listStudents, (o1, o2) -> {
			char tenO1 = o1.name.charAt(o1.name.lastIndexOf(" ") + 1);
			char tenO2 = o2.name.charAt(o2.name.lastIndexOf(" ") + 1);
			return tenO1 - tenO2;
		});
		fillToTable();
	}
}
