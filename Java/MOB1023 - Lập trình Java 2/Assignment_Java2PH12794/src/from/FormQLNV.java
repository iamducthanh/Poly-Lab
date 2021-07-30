package from;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import assignment.ClockThread;
import assignment.StaffList;
import assignment.Validate;

@SuppressWarnings("serial")
public class FormQLNV extends JFrame {

	protected static final int ERROR_MESSAGE = 0;
	private JTable table;
	private JPanel contentPane;
	private JTextField textCode;
	private JTextField textAge;
	private JTextField textEmail;
	private JTextField textSalary;
	private JTextField textField;
	private JTextField textName = new JTextField();

	private JButton btnLast = new JButton(">|");
	private JButton btnNext = new JButton(">>");
	private JButton btnPrevious = new JButton("<<");
	private JButton btnFirst = new JButton("|<");
	private JButton btnFind = new JButton("Find");
	private JButton btnDelete = new JButton("Delete");
	private JButton btnSave = new JButton("Update");
	private JButton btnSearch = new JButton("T\u00ECm ki\u1EBFm");

	private JLabel lblRecord = new JLabel("Record 0 of 0");
	private JPanel panel = new JPanel();
	private JPanel panel1 = new JPanel();
	private JLabel lblHoTen = new JLabel("H\u1ECC T\u00CAN");

	StaffList staff = new StaffList();
	DefaultTableModel model = new DefaultTableModel();
	DecimalFormat fmSalary = new DecimalFormat("#,###");
	String save = "update";
	Validate validate = new Validate();
	int currentIndex = 0;
	public static String codeSearch;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormQLNV frame = new FormQLNV();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.setTitle("QUẢN LÝ NHÂN VIÊN");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	public FormQLNV() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 671, 599);

		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblQunLNhn = new JLabel("QU\u1EA2N L\u00DD NH\u00C2N VI\u00CAN");
		lblQunLNhn.setForeground(Color.BLACK);
		lblQunLNhn.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblQunLNhn.setBounds(147, 11, 308, 27);
		contentPane.add(lblQunLNhn);

		JLabel lblClock = new JLabel("hh:mm:ss aa");
		lblClock.setForeground(Color.RED);
		lblClock.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblClock.setBounds(530, 24, 117, 27);
		contentPane.add(lblClock);

		ClockThread run = new ClockThread(lblClock);

		panel.setBackground(Color.LIGHT_GRAY);
		panel.setForeground(Color.DARK_GRAY);
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(543, 75, 91, 258);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton btnNew = new JButton("New");
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSave.setText("Save");
				newFrom();
			}
		});
		btnNew.setForeground(SystemColor.menuText);
		btnNew.setBackground(SystemColor.activeCaptionBorder);
		btnNew.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNew.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNew.setBounds(10, 11, 71, 30);
		panel.add(btnNew);

		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				buttonSave();
			}
		});
		btnSave.setBackground(SystemColor.activeCaptionBorder);
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSave.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnSave.setBounds(10, 52, 71, 30);
		panel.add(btnSave);

		btnDelete.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) {
				int staffSelected = table.getSelectedRow();
				staff.delete(staffSelected);
				staff.fillTable(model);
				staff.i = 0;
				display(0);
			}
		});
		btnDelete.setBackground(SystemColor.activeCaptionBorder);
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDelete.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnDelete.setBounds(10, 93, 71, 30);
		panel.add(btnDelete);

		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonFind();
			}
		});
		btnFind.setBackground(SystemColor.activeCaptionBorder);
		btnFind.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnFind.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnFind.setBounds(10, 134, 71, 30);
		panel.add(btnFind);

		JButton btnOpen = new JButton("Open");
		btnOpen.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) {
				JFileChooser open = new JFileChooser();
				int rVal = open.showOpenDialog(null);
				if (rVal == 0) {
					String path = open.getSelectedFile().getPath();
					try {
						staff.open(path);
						table.setModel(staff.fillTable(model));
						display(staff.first());
						move();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, "Không thể đọc file bạn vừa chọn, hãy chọn đúng file!",
								"ERROR", ERROR_MESSAGE);
					}
				}
			}
		});
		btnOpen.setBackground(SystemColor.activeCaptionBorder);
		btnOpen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnOpen.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnOpen.setBounds(10, 175, 71, 30);
		panel.add(btnOpen);

		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) {
				JFileChooser save = new JFileChooser();
				int rVal = save.showSaveDialog(null);
				if (rVal == save.APPROVE_OPTION) {
					File file = save.getSelectedFile();
					try {
						staff.save(file.getPath());
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					System.exit(0);
				} else
					System.exit(0);
			}
		});
		btnExit.setBackground(SystemColor.activeCaptionBorder);
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnExit.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnExit.setBounds(10, 216, 71, 30);
		panel.add(btnExit);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 356, 634, 192);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				currentIndex = row;
				staff.i = row;
				display(row);
			}
		});

		panel1.setBackground(Color.LIGHT_GRAY);
		panel1.setBounds(10, 142, 488, 203);
		contentPane.add(panel1);
		panel1.setLayout(null);

		JLabel lblTuoi = new JLabel("TU\u1ED4I");
		lblTuoi.setBounds(81, 9, 46, 34);
		panel1.add(lblTuoi);
		lblTuoi.setFont(new Font("Tahoma", Font.PLAIN, 16));

		textAge = new JTextField();
		textAge.setBounds(137, 11, 117, 32);
		panel1.add(textAge);
		textAge.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textAge.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textAge.setText("");
		textAge.setColumns(10);

		JLabel lblEmail = new JLabel("EMAIL");
		lblEmail.setBounds(77, 54, 50, 34);
		panel1.add(lblEmail);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));

		textEmail = new JTextField();
		textEmail.setBounds(137, 54, 346, 32);
		panel1.add(textEmail);
		textEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textEmail.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textEmail.setText("");
		textEmail.setColumns(10);

		JLabel lblLuong = new JLabel("L\u01AF\u01A0NG");
		lblLuong.setBounds(68, 101, 59, 34);
		panel1.add(lblLuong);
		lblLuong.setFont(new Font("Tahoma", Font.PLAIN, 16));

		textSalary = new JTextField();
		textSalary.setBounds(137, 97, 117, 32);
		panel1.add(textSalary);
		textSalary.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textSalary.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textSalary.setText("");
		textSalary.setColumns(10);

		btnFirst.setBounds(137, 154, 39, 30);
		panel1.add(btnFirst);
		btnFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				display(staff.first());
			}
		});
		btnFirst.setForeground(Color.BLACK);
		btnFirst.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnFirst.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnFirst.setBackground(SystemColor.activeCaptionBorder);

		btnPrevious.setBounds(186, 154, 59, 30);
		panel1.add(btnPrevious);
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				display(staff.previous());
			}
		});
		btnPrevious.setForeground(Color.BLACK);
		btnPrevious.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnPrevious.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnPrevious.setBackground(SystemColor.activeCaptionBorder);

		btnNext.setBounds(255, 154, 59, 30);
		panel1.add(btnNext);
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				display(staff.next());
			}
		});
		btnNext.setForeground(Color.BLACK);
		btnNext.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNext.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnNext.setBackground(SystemColor.activeCaptionBorder);

		btnLast.setBounds(324, 154, 39, 30);
		panel1.add(btnLast);
		btnLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				display(staff.last());
			}
		});
		btnLast.setForeground(Color.BLACK);
		btnLast.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLast.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnLast.setBackground(SystemColor.activeCaptionBorder);
		lblRecord.setForeground(Color.RED);
		lblRecord.setBounds(373, 164, 110, 14);
		panel1.add(lblRecord);

		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				search();
			}
		});

		textCode = new JTextField();
		textCode.setBounds(147, 67, 117, 32);
		contentPane.add(textCode);
		textCode.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textCode.setText("");
		textCode.setColumns(10);
		textCode.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		JLabel lblMaNhanVien = new JLabel("M\u00C3 NH\u00C2N VI\u00CAN");
		lblMaNhanVien.setBounds(20, 65, 117, 34);
		contentPane.add(lblMaNhanVien);
		lblMaNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 16));

		textName.setBounds(147, 110, 346, 32);
		contentPane.add(textName);
		textName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textName.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textName.setText("");
		textName.setColumns(10);

		lblHoTen.setBounds(75, 108, 66, 34);
		contentPane.add(lblHoTen);
		lblHoTen.setFont(new Font("Tahoma", Font.PLAIN, 16));

		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSearch.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnSearch.setBackground(SystemColor.activeCaptionBorder);
		btnSearch.setBounds(147, 110, 117, 34);
		contentPane.add(btnSearch);

		textField = new JTextField();
		textField.setBounds(147, 59, 274, 29);
		textField.setText("");
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setColumns(10);
		textField.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		table();
		run.start();
		panel1.setVisible(true);
		btnSearch.setVisible(false);

		btnLast.setEnabled(false);
		btnNext.setEnabled(false);
		btnFirst.setEnabled(false);
		btnPrevious.setEnabled(false);
		btnFind.setEnabled(false);
		btnDelete.setEnabled(false);
		
		JLabel background1 = new JLabel();
		background1.setIcon(new ImageIcon("C:\\Users\\ADMIN\\eclipse-workspace\\Assignment_Java2_PH12794\\image\\bkg1.jpg"));
		background1.setBounds(0, 0, 671, 599);
		
		JLabel background2 = new JLabel();
		background2.setIcon(new ImageIcon("C:\\Users\\ADMIN\\eclipse-workspace\\Assignment_Java2_PH12794\\image\\bkg2.jpg"));
		background2.setBounds(0, 0, 488, 203);
		
		JLabel background3 = new JLabel();
		background3.setIcon(new ImageIcon("C:\\Users\\ADMIN\\eclipse-workspace\\Assignment_Java2_PH12794\\image\\bkg3.jpg"));
		background3.setBounds(0, 0, 100, 258);
		
		
		contentPane.add(background1);
		panel1.add(background2);
		panel.add(background3);
		
		
		
	}

	public void move() {
		btnLast.setEnabled(true);
		btnNext.setEnabled(true);
		btnFirst.setEnabled(true);
		btnPrevious.setEnabled(true);
		btnFind.setEnabled(true);
		btnDelete.setEnabled(true);
	}

	public void table() {
		JTableHeader header = table.getTableHeader();
		header.setBackground(Color.LIGHT_GRAY);
		model.addColumn("MÃ");
		model.addColumn("HỌ VÀ TÊN");
		model.addColumn("TUỔI");
		model.addColumn("EMAIL");
		model.addColumn("LƯƠNG");

		table.setModel(model);

		table.getColumnModel().getColumn(0).setPreferredWidth(20);
		table.getColumnModel().getColumn(2).setPreferredWidth(10);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		
	}

	public void newFrom() {
		textCode.setText("");
		textName.setText("");
		textAge.setText("");
		textEmail.setText("");
		textSalary.setText("");
		save = "add";
	}

	@SuppressWarnings("static-access")
	public boolean listAdd() {
		String code = textCode.getText().toUpperCase();
		String name = textName.getText();
		String email = textEmail.getText();
		String age = textAge.getText();
		String salary = textSalary.getText();

		if (validate.checkCode(code) && validate.checkName(name) && validate.checkAge(age) && validate.checkEmail(email)
				&& validate.checkSalary(salary)) {
			System.out.println("done");
			int ageInt = Integer.parseInt(age);
			double luong = Double.parseDouble(salary);
			StaffList.addList(code, name, ageInt, email, luong);
			JOptionPane.showMessageDialog(null, "Thêm mới thành công!");
			save = "update";
			return true;
		}
		return false;
	}

	@SuppressWarnings({ "unused", "static-access" })
	public boolean listUpdate(int row) {
		DecimalFormat fmFormat = new DecimalFormat("###");
		String code = textCode.getText();
		String name = textName.getText();
		String email = textEmail.getText();
		String age = textAge.getText();

		String salary = textSalary.getText().replace(",", "");

		if (validate.checkCodeUpdate(code, row) && validate.checkName(name) && validate.checkAge(age)
				&& validate.checkEmail(email) && validate.checkSalary(salary)) {
			System.out.println("done");
			int ageInt = Integer.parseInt(age);
			double luong = Double.parseDouble(salary);
			StaffList.addList(code, name, ageInt, email, luong);
			save = "update";
			return true;
		}
		return false;
	}

	@SuppressWarnings("static-access")
	public void buttonSave() {
		boolean checkInput = false;
		if (save.equals("add")) {
			if (listAdd()) {
				checkInput = true;
				btnSave.setText("Update");
				move();
				currentIndex = 0;
			}
		} else if (save.equals("update")) {
			int row = table.getSelectedRow();
			if (row < 0) {
				JOptionPane.showMessageDialog(null, "Bạn chưa chọn nhân viên cần update!");
			} else {
				if (listUpdate(row)) {
					checkInput = true;
					currentIndex = row;
					move();
					staff.setList(currentIndex);
				}
			}
		}
		if (checkInput) {
			staff.fillTable(model);
			display(currentIndex);
		}
	}

	@SuppressWarnings("static-access")
	public void display(int currentIndex) {
		textCode.setText(staff.listStaffs.get(currentIndex).getCode());
		textName.setText(staff.listStaffs.get(currentIndex).getName());
		textAge.setText(String.valueOf(staff.listStaffs.get(currentIndex).getAge()));
		textEmail.setText(staff.listStaffs.get(currentIndex).getEmail());
		textSalary.setText(fmSalary.format(staff.listStaffs.get(currentIndex).getSalary()));
		table.setRowSelectionInterval(currentIndex, currentIndex);
		lblRecord.setText(
				"Record " + String.valueOf(currentIndex + 1) + " of " + String.valueOf(staff.listStaffs.size()));
	}

	@SuppressWarnings("static-access")
	public int getCodeSearch(String txtCodeSearch) {
		int i;
		txtCodeSearch = txtCodeSearch.toUpperCase();
		for (i = 0; i < staff.listStaffs.size(); i++) {
			if (staff.listStaffs.get(i).getCode().equalsIgnoreCase(txtCodeSearch)) {
				break;
			}
		}
		return i;
	}

	public void buttonFind() {
		panel.setVisible(false);
		panel1.setVisible(false);
		textName.setVisible(false);
		lblHoTen.setVisible(false);
		btnSearch.setVisible(true);
		textCode.setBounds(147, 67, 217, 32);
		textCode.setText("");
		JOptionPane.showMessageDialog(null, "Nhập mã nhân viên cần tìm");
	}

	@SuppressWarnings("static-access")
	public void search() {
		String search = textCode.getText();
		panel.setVisible(true);
		panel1.setVisible(true);
		textName.setVisible(true);
		lblHoTen.setVisible(true);
		btnSearch.setVisible(false);
		textCode.setBounds(147, 67, 117, 32);
		int i = getCodeSearch(search);
		if (i == staff.listStaffs.size()) {
			display(0);
			JOptionPane.showMessageDialog(null, "Không tìm thấy nhân viên nào có mã " + search);
		} else {
			display(i);
		}
	}
}
