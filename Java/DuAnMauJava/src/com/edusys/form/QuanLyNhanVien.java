package com.edusys.form;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.edusys.dao.impl.AbstractDao;
import com.edusys.dao.impl.NhanVienDao;
import com.edusys.helper.FormHelper;
import com.edusys.helper.Validate;
import com.edusys.model.NhanVien;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.awt.BorderLayout;

@SuppressWarnings("serial")
public class QuanLyNhanVien extends JInternalFrame {

	private JPanel contentPane;
	private JTable table;
	DefaultTableModel model = new DefaultTableModel();
	private JTextField textUsername;
	private JTextField textPassword;
	private JTextField textHoTen;
	JButton btnSua = new JButton("Sửa");
	JButton btnMoi = new JButton("Mới");
	JButton btnXoa = new JButton("Xóa");
	JButton btnThem = new JButton("Thêm");

	JButton btnHuy = new JButton("Hủy");
	ArrayList<NhanVien> lisNhanViens = new ArrayList<NhanVien>();
	ArrayList<JTextField> list = new ArrayList<JTextField>();
	int current = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuanLyNhanVien frame = new QuanLyNhanVien();
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
	JRadioButton rdbtnTrgPhg = new JRadioButton("Trưởng phòng");
	JRadioButton rdbtnNhanVien = new JRadioButton("Nhân viên");

	public QuanLyNhanVien() {
		setTitle("Quản lý nhân viên");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 597, 392);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));


		JLabel lblQunLNhn = new JLabel("QUẢN LÝ NHÂN VIÊN");
		lblQunLNhn.setForeground(Color.BLUE);
		lblQunLNhn.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblQunLNhn.setBounds(10, 0, 257, 34);
		contentPane.add(lblQunLNhn, BorderLayout.NORTH);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		


		JPanel panel = new JPanel();
		tabbedPane.addTab("Danh sách", null, panel, null);
		panel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);
//
//		JScrollPane scrollPane = new JScrollPane();
//		scrollPane.setBounds(10, 11, 538, 262);
//		panel.add(scrollPane);
//
		table = new JTable();
		scrollPane.setViewportView(table);
		model.addColumn("USERNAME");
		model.addColumn("PASSWORD");
		model.addColumn("HỌ TÊN");
		model.addColumn("VAI TRÒ");
		table.setModel(model);

		JPanel capnhat = new JPanel();
		tabbedPane.addTab("Cập nhật", null, capnhat, null);
		capnhat.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		capnhat.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
//		JPanel panel_1 = new JPanel();
//		panel_1111.add(panel_1, BorderLayout.CENTER);
//		panel_1.setLayout(null);
//
		JLabel lblNewLabel = new JLabel("Mã nhân viên");
		lblNewLabel.setBounds(10, 11, 161, 14);
		panel_1.add(lblNewLabel);

		textUsername = new JTextField();
		textUsername.setBounds(10, 36, 276, 20);
		panel_1.add(textUsername);
		textUsername.setColumns(10);

		JLabel lblPassword = new JLabel("Mật khẩu");
		lblPassword.setBounds(10, 67, 161, 14);
		panel_1.add(lblPassword);

		textPassword = new JTextField();
		textPassword.setColumns(10);
		textPassword.setBounds(10, 92, 276, 20);
		panel_1.add(textPassword);

		JLabel lblNewLabel_1_1 = new JLabel("Họ tên");
		lblNewLabel_1_1.setBounds(10, 123, 161, 14);
		panel_1.add(lblNewLabel_1_1);

		textHoTen = new JTextField();
		textHoTen.setColumns(10);
		textHoTen.setBounds(10, 148, 276, 20);
		panel_1.add(textHoTen);

		JLabel lblNewLabel_1_1_1 = new JLabel("Vai trò");
		lblNewLabel_1_1_1.setBounds(10, 179, 42, 14);
		panel_1.add(lblNewLabel_1_1_1);

		rdbtnTrgPhg.setBounds(20, 200, 113, 23);
		panel_1.add(rdbtnTrgPhg);

		rdbtnNhanVien.setBounds(135, 200, 111, 23);
		panel_1.add(rdbtnNhanVien);

		ButtonGroup gr = new ButtonGroup();
		gr.add(rdbtnNhanVien);
		gr.add(rdbtnTrgPhg);

		btnThem.setEnabled(false);
		btnThem.setBounds(430, 35, 89, 23);
		panel_1.add(btnThem);

		btnSua.setBounds(430, 67, 89, 23);
		panel_1.add(btnSua);
		btnXoa.setBounds(430, 101, 89, 23);
		panel_1.add(btnXoa);
		btnMoi.setBounds(430, 135, 89, 23);
		panel_1.add(btnMoi);

		btnHuy.setBounds(430, 135, 89, 23);
		panel_1.add(btnHuy);
		btnHuy.setVisible(false);

		JButton btnFirst = new JButton("|<");
		btnFirst.setFont(new Font("Tahoma", Font.BOLD, 8));
		btnFirst.setBounds(10, 250, 47, 23);
		panel_1.add(btnFirst);

		JButton btnPre = new JButton("<<");
		btnPre.setFont(new Font("Tahoma", Font.BOLD, 8));
		btnPre.setBounds(67, 249, 50, 23);
		panel_1.add(btnPre);

		JButton btnNext = new JButton(">>");
		btnNext.setFont(new Font("Tahoma", Font.BOLD, 8));
		btnNext.setBounds(127, 250, 50, 23);
		panel_1.add(btnNext);

		JButton btnLast = new JButton(">|");
		btnLast.setFont(new Font("Tahoma", Font.BOLD, 8));
		btnLast.setBounds(187, 250, 47, 23);
		panel_1.add(btnLast);
		loadTable();
		btnXoa.addActionListener(them);

		btnMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormHelper.clear(list);
				btnThem.setEnabled(true);
				btnSua.setEnabled(false);
				btnXoa.setEnabled(false);
				btnMoi.setVisible(false);
				btnHuy.setVisible(true);
			}
		});

		btnSua.addActionListener(them);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int r = table.getSelectedRow();
				display(r);
			}
		});
		rdbtnTrgPhg.setSelected(true);
		list.add(textUsername);
		list.add(textPassword);
		list.add(textHoTen);
		display(0);
		btnThem.addActionListener(them);
		btnFirst.addActionListener(first);
		btnLast.addActionListener(last);
		btnNext.addActionListener(next);
		btnPre.addActionListener(previous);
		btnHuy.addActionListener(huy);
	}
	
	ActionListener huy = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			display(current);
			btnThem.setEnabled(false);
			btnSua.setEnabled(true);
			btnXoa.setEnabled(true);
			btnMoi.setVisible(true);
			btnHuy.setVisible(false);
		}
	};

	ActionListener them = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			StringBuilder error = new StringBuilder();
			if (!Validate.checkNull(textUsername.getText())) {
				error.append("Không được để trống mã nhân viên!\n");
			} else {
				if (e.getActionCommand().equals("Thêm")) {
					try {
						if (AbstractDao.fill("select * from nhanvien where manv = ?", textUsername.getText()).next()) {
							error.append("Mã nhân viên này đã tồn tại!\n");
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
			if (!Validate.checkNull(textPassword.getText())) {
				error.append("Không được để trống password!\n");
			}
			if (!Validate.checkNull(textHoTen.getText())) {
				error.append("Không dược để trống họ tên!\n");
			}

			if (error.toString().isBlank()) {
				String maNV = textUsername.getText();
				String matKhau = textPassword.getText();
				String hoTen = textHoTen.getText();
				String vaiTro = rdbtnTrgPhg.isSelected() ? "1" : "0";
				if (e.getActionCommand().equals("Thêm")) {
					AbstractDao.executeQuery("insert into nhanvien values (?,?,?,?)",
							new Object[] { maNV, matKhau, hoTen, vaiTro });
					JOptionPane.showMessageDialog(null, "Thêm thành công!");
				} else if (e.getActionCommand().equals("Sửa")) {
					AbstractDao.executeQuery("update NhanVien set MatKhau = ?, hoten = ?, VaiTro = ? where Manv = ?",
							new Object[] { matKhau, hoTen, vaiTro, maNV });
					JOptionPane.showMessageDialog(null, "Sửa thành công!");
				} else if (e.getActionCommand().equals("Xóa")) {
					int a = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa?");
					if (a == 0) {
						JOptionPane.showMessageDialog(null, "Xóa thành công!");
						AbstractDao.executeQuery("delete from nhanvien where manv = ?", textUsername.getText());
					}
				}
				btnThem.setEnabled(false);
				btnSua.setEnabled(true);
				btnXoa.setEnabled(true);

				btnHuy.setVisible(false);
				btnMoi.setVisible(true);
				loadTable();
				display(0);
			} else {
				JOptionPane.showMessageDialog(null, error.toString(), "Lỗi", JOptionPane.WARNING_MESSAGE);
			}
		}
	};

	public void display(int r) {
		FormHelper.display(list, model, r, table);
		if (lisNhanViens.get(r).getVaiTro().equals("1")) {
			rdbtnTrgPhg.setSelected(true);
		} else {
			rdbtnNhanVien.setVisible(true);
		}
	}

	public void loadTable() {
		model.setRowCount(0);
		lisNhanViens = new NhanVienDao().fillAll();
		lisNhanViens.forEach((cd) -> {
			model.addRow(new Object[] { cd.getManv(), cd.getPassword(), cd.getHoTen(), cd.getVaiTro() });
		});
	}

	ActionListener first = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			current = 0;
			display(current);
		}
	};

	ActionListener last = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			current = lisNhanViens.size() - 1;
			display(current);
		}
	};

	ActionListener next = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			current += 1;
			if (current == lisNhanViens.size()) {
				current = 0;
			}
			display(current);
		}
	};

	ActionListener previous = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			current -= 1;
			if (current == -1) {
				current = lisNhanViens.size() - 1;
			}
			display(current);
		}
	};
}
