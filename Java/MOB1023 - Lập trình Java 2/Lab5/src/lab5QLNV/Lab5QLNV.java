package lab5QLNV;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import lab5.XFile;

public class Lab5QLNV extends JFrame {

	private JPanel contentPane;
	private JTextField textName;
	private JTextField textSalary;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lab5QLNV frame = new Lab5QLNV();
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
	public Lab5QLNV() {
		setBackground(Color.DARK_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 498, 369);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblQunLNhn = new JLabel("QUẢN LÝ NHÂN VIÊN");
		lblQunLNhn.setForeground(Color.RED);
		lblQunLNhn.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblQunLNhn.setBounds(120, 11, 308, 27);
		contentPane.add(lblQunLNhn);

		JLabel lblName = new JLabel("H\u1ECC V\u00C0 T\u00CAN");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblName.setBounds(22, 49, 117, 34);
		contentPane.add(lblName);

		JLabel lblLuong = new JLabel("L\u01AF\u01A0NG");
		lblLuong.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLuong.setBounds(22, 94, 117, 34);
		contentPane.add(lblLuong);

		textName = new JTextField();
		textName.setText("");
		textName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textName.setColumns(10);
		textName.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textName.setBounds(120, 49, 346, 32);
		contentPane.add(textName);

		textSalary = new JTextField();
		textSalary.setText("");
		textSalary.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textSalary.setColumns(10);
		textSalary.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textSalary.setBounds(120, 94, 346, 32);
		contentPane.add(textSalary);

		JButton btnAdd = new JButton("Thêm");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addStaff();
				fillTable(ListStaff.listStaff);
			}
		});
		btnAdd.setForeground(Color.BLACK);
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAdd.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnAdd.setBackground(SystemColor.activeCaptionBorder);
		btnAdd.setBounds(120, 139, 71, 30);
		contentPane.add(btnAdd);

		JButton btnWrite = new JButton("Lưu");
		btnWrite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				write();
			}
		});
		btnWrite.setForeground(Color.BLACK);
		btnWrite.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnWrite.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnWrite.setBackground(SystemColor.activeCaptionBorder);
		btnWrite.setBounds(201, 139, 71, 30);
		contentPane.add(btnWrite);

		JButton btnRead = new JButton("Đọc");
		btnRead.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				read();
			}
		});
		btnRead.setForeground(Color.BLACK);
		btnRead.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRead.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnRead.setBackground(SystemColor.activeCaptionBorder);
		btnRead.setBounds(282, 139, 71, 30);
		contentPane.add(btnRead);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 192, 444, 129);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		table();

	}

	DefaultTableModel model = new DefaultTableModel();

	public void table() {
		JTableHeader header = table.getTableHeader();
		header.setBackground(Color.LIGHT_GRAY);

		model.addColumn("HỌ VÀ TÊN");
		model.addColumn("LƯƠNG");
		table.setModel(model);
	}

	public void addStaff() {
		checkName(textName.getText());
		checkSalary(textSalary.getText());
		if (checkName(textName.getText()) && checkSalary(textSalary.getText())) {
			String fullName = textName.getText();
			double salary = Double.parseDouble(textSalary.getText());
			ListStaff.add(fullName, salary);
		} else {
			JOptionPane.showMessageDialog(null, "Bạn nhập sai dữ liệu đầu vào!");
		}
	}

	public boolean checkName(String fullname) {
		if (fullname.trim().length() <= 0) {
			textName.setBackground(Color.yellow);
			return false;
		} else {
			textName.setBackground(Color.white);
			return true;
		}
	}

	public boolean checkSalary(String luong) {
		try {
			double salary = Double.parseDouble(textSalary.getText());
			if (salary < 0) {
				textSalary.setBackground(Color.yellow);
				return false;
			} else {
				textSalary.setBackground(Color.white);
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			textSalary.setBackground(Color.yellow);
			return false;
		}
	}

	public void fillTable(List<Staff> List) {
		model.setRowCount(0);
		List.forEach((s1) -> {
			DecimalFormat fmSalary = new DecimalFormat("#,###$");
			String luongString = fmSalary.format(s1.getSalary());
			model.addRow(new Object[] { s1.getFullname(), luongString });
		});
	}

	public void write() {
		XFile.writeObject("C:\\Users\\ADMIN\\eclipse-workspace\\Lab5\\src\\lab5QLNV\\ListStaffSave.txt",
				ListStaff.listStaff);
		model.setRowCount(0);
		JOptionPane.showMessageDialog(null, "Lưu thành công");
	}

	public void read() {
		try {
			List<Staff> listStaffRead = new ArrayList<Staff>();
			listStaffRead = (List<Staff>) XFile
					.readObject("C:\\Users\\ADMIN\\eclipse-workspace\\Lab5\\src\\lab5QLNV\\ListStaffSave.txt");
			fillTable(listStaffRead);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
