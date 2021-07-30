package com.edusys.form;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.edusys.dao.impl.AbstractDao;
import com.edusys.dao.impl.ChuyenDeDao;
import com.edusys.dao.impl.KhoaHocDao;
import com.edusys.helper.FormHelper;
import com.edusys.helper.Validate;
import com.edusys.model.ChuyenDe;
import com.edusys.model.KhoaHoc;

@SuppressWarnings("serial")
public class QuanLyKhoaHoc extends JInternalFrame {

	private JPanel contentPane;
	private JTextField textChuyenDe;
	private JTextField textHocPhi;
	private JTextField textNguoiTao;
	private JTextField textKhaiGiang;
	private JTextField textThoiLuong;
	private JTextField textNgayTao;
	private JTable table;
	JButton btnSua = new JButton("Sửa");
	JButton btnMoi = new JButton("Mới");
	JButton btnXoa = new JButton("Xóa");
	JButton btnThem = new JButton("Thêm");

	JButton btnHuy = new JButton("Hủy");
	DefaultTableModel model = new DefaultTableModel();
	ArrayList<KhoaHoc> listKhoaHocs = new ArrayList<KhoaHoc>();
	ArrayList<ChuyenDe> listChuyenDe = new ArrayList<ChuyenDe>();
	JComboBox<String> comboBox = new JComboBox<String>();
	ArrayList<JTextField> list = new ArrayList<JTextField>();
	SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");
	int current = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuanLyKhoaHoc frame = new QuanLyKhoaHoc();
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
	JTextArea textArea = new JTextArea();

	public QuanLyKhoaHoc() {
		setTitle("Quản lý khóa học");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 636, 479);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel top = new JPanel();
		contentPane.add(top, BorderLayout.NORTH);
		top.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(10, 32, 602, 43);
		top.add(panel, BorderLayout.SOUTH);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadKhoaHoc();
				textChuyenDe.setText((String) comboBox.getSelectedItem());
				listChuyenDe.forEach((cd) -> {
					if (cd.getTenCD().equals(comboBox.getSelectedItem())) {
						textHocPhi.setText(cd.getHocPhi());
						textThoiLuong.setText(cd.getThoiLuong());

					}
				});
				if (listKhoaHocs.size() == 0) {
					textArea.setText("");
					textKhaiGiang.setText("");
					textNgayTao.setText("");
					textNguoiTao.setText("");
				} else {
					display(0);
				}
			}
		});

		comboBox.setBounds(10, 11, 582, 22);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel.createSequentialGroup()
						.addContainerGap().addComponent(comboBox, 0, 588, Short.MAX_VALUE).addContainerGap()));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel
						.createSequentialGroup().addContainerGap().addComponent(comboBox, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(7, Short.MAX_VALUE)));
		panel.setLayout(gl_panel);

		JLabel lblChuyn = new JLabel("CHUYÊN ĐỀ");
		lblChuyn.setForeground(Color.RED);
		lblChuyn.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblChuyn.setBounds(10, 0, 257, 34);
		top.add(lblChuyn, BorderLayout.NORTH);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Danh sách", null, panel_1, null);
		panel_1.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane_1 = new JScrollPane();
		panel_1.add(scrollPane_1, BorderLayout.CENTER);

		table = new JTable();
		scrollPane_1.setViewportView(table);
		model.addColumn("MÃ KH");
		model.addColumn("THỜI LƯỢNG");
		model.addColumn("HỌC PHÍ");
		model.addColumn("KHAI GIẢNG");
		model.addColumn("TẠO BỞI");
		model.addColumn("NGÀY TẠO");
		table.setModel(model);

		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Cập nhật", null, panel_2, null);
		panel_2.setLayout(null);

		JLabel lblNewLabel = new JLabel("Chuyên đề");
		lblNewLabel.setBounds(10, 11, 98, 14);
		panel_2.add(lblNewLabel);

		textChuyenDe = new JTextField();
		textChuyenDe.setEditable(false);
		textChuyenDe.setColumns(10);
		textChuyenDe.setBounds(10, 36, 285, 26);
		panel_2.add(textChuyenDe);

		JLabel lblNewLabel_1 = new JLabel("Học phí");
		lblNewLabel_1.setBounds(10, 73, 98, 14);
		panel_2.add(lblNewLabel_1);

		textHocPhi = new JTextField();
		textHocPhi.setEditable(false);
		textHocPhi.setColumns(10);
		textHocPhi.setBounds(10, 98, 285, 26);
		panel_2.add(textHocPhi);

		JLabel lblNewLabel_1_1 = new JLabel("Người tạo");
		lblNewLabel_1_1.setBounds(10, 135, 98, 14);
		panel_2.add(lblNewLabel_1_1);

		textNguoiTao = new JTextField();
		textNguoiTao.setEditable(false);
		textNguoiTao.setColumns(10);
		textNguoiTao.setBounds(10, 160, 285, 26);
		panel_2.add(textNguoiTao);

		textKhaiGiang = new JTextField();
		textKhaiGiang.setColumns(10);
		textKhaiGiang.setBounds(305, 36, 282, 26);
		panel_2.add(textKhaiGiang);

		textThoiLuong = new JTextField();
		textThoiLuong.setEditable(false);
		textThoiLuong.setColumns(10);
		textThoiLuong.setBounds(305, 98, 282, 26);
		panel_2.add(textThoiLuong);

		textNgayTao = new JTextField();
		textNgayTao.setEditable(false);
		textNgayTao.setColumns(10);
		textNgayTao.setBounds(305, 160, 282, 26);
		panel_2.add(textNgayTao);

		JLabel lblKhaiGing = new JLabel("Khai giảng");
		lblKhaiGing.setBounds(305, 11, 98, 14);
		panel_2.add(lblKhaiGing);

		JLabel lblThiLnggi = new JLabel("Thời lượng (giờ)");
		lblThiLnggi.setBounds(305, 73, 98, 14);
		panel_2.add(lblThiLnggi);

		JLabel lblNgyTo = new JLabel("Ngày tạo");
		lblNgyTo.setBounds(305, 135, 98, 14);
		panel_2.add(lblNgyTo);

		JLabel lblNewLabel_1_1_1 = new JLabel("Ghi chú");
		lblNewLabel_1_1_1.setBounds(10, 197, 98, 14);
		panel_2.add(lblNewLabel_1_1_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 222, 577, 48);
		panel_2.add(scrollPane);

		scrollPane.setViewportView(textArea);

		btnThem.setEnabled(false);
		btnThem.setBounds(10, 281, 73, 23);
		panel_2.add(btnThem);

		btnSua.setBounds(93, 281, 73, 23);
		panel_2.add(btnSua);

		btnXoa.setBounds(176, 281, 73, 23);
		panel_2.add(btnXoa);

		btnMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				btnThem.setEnabled(true);
				btnSua.setEnabled(false);
				btnXoa.setEnabled(false);
				btnMoi.setVisible(false);
				btnHuy.setVisible(true);
				textKhaiGiang.setText("");
				textNgayTao.setText("");
				textNgayTao.setText(fm.format(new Date()));
				textNguoiTao.setText(QLDT.user);
			}
		});
		btnMoi.setBounds(259, 281, 73, 23);
		panel_2.add(btnMoi);

		btnHuy.setBounds(259, 281, 73, 23);
		panel_2.add(btnHuy);
		btnHuy.setVisible(false);

		JButton btnLast = new JButton(">|");
		btnLast.setFont(new Font("Tahoma", Font.BOLD, 8));
		btnLast.setBounds(540, 281, 47, 23);
		panel_2.add(btnLast);

		JButton btnNext = new JButton(">>");
		btnNext.setFont(new Font("Tahoma", Font.BOLD, 8));
		btnNext.setBounds(483, 281, 47, 23);
		panel_2.add(btnNext);

		JButton btnPre = new JButton("<<");
		btnPre.setFont(new Font("Tahoma", Font.BOLD, 8));
		btnPre.setBounds(426, 281, 47, 23);
		panel_2.add(btnPre);

		btnThem.addActionListener(them);
		btnSua.addActionListener(them);

		JButton btnFirst = new JButton("|<");
		btnFirst.setFont(new Font("Tahoma", Font.BOLD, 8));
		btnFirst.setBounds(369, 281, 47, 23);
		panel_2.add(btnFirst);
		listChuyenDe = new ChuyenDeDao().fillAll();
		loadChuyenDe();
		loadKhoaHoc();

		list.add(new JTextField());
		list.add(textThoiLuong);
		list.add(textHocPhi);
		list.add(textKhaiGiang);
		list.add(textNguoiTao);
		list.add(textNgayTao);

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int r = table.getSelectedRow();
				display(r);
			}
		});

		display(0);
		btnXoa.addActionListener(them);
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
			if (!Validate.checkNull(textKhaiGiang.getText())) {
				error.append("Không được để trống khai giảng!\n");
			} else if (!Validate.checkNgay(textKhaiGiang.getText())) {
				error.append("Nhập sai định dạng ngày khai giảng (yyyy-mm-dd)!\n");
			}
			if (!Validate.checkNull(textNgayTao.getText())) {
				error.append("Không được để trống ngày tạo!\n");
			} else if (!Validate.checkNgay(textNgayTao.getText())) {
				error.append("Nhập sai định dạng ngày tạo (yyyy-mm-dd)!\n");
			}

			if (error.toString().isBlank()) {
				String maCD = null;
				ResultSet resultSet = AbstractDao.fill("select macd from chuyende where tencd = ?",
						(String) comboBox.getSelectedItem());
				try {
					while (resultSet.next()) {
						maCD = resultSet.getString(1);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String hocPhi = textHocPhi.getText();
				String thoiLuong = textThoiLuong.getText();
				String ngayKG = textKhaiGiang.getText();
				String ghiChu = textArea.getText();
				String maNV = textNguoiTao.getText();
				String ngayTao = textNgayTao.getText();
				if (e.getActionCommand().equals("Thêm")) {
					AbstractDao.executeQuery(
							"insert into khoahoc(macd,hocphi,thoiluong,ngaykg,ghichu,manv,ngaytao) values (?,?,?,?,?,?,?)",
							new Object[] { maCD, hocPhi, thoiLuong, ngayKG, ghiChu, maNV, ngayTao });
					JOptionPane.showMessageDialog(null, "Thêm thành công!");
				} else if (e.getActionCommand().equals("Sửa")) {
					int r = table.getSelectedRow();
					String maKH = (String) model.getValueAt(r, 0);
					AbstractDao.executeQuery(
							"update khoahoc set hocphi = ?, ngayKG = ?, thoiluong = ?, ngaytao = ?, ghichu = ? where makh = ?",
							new Object[] { hocPhi, ngayKG, thoiLuong, ngayTao, ghiChu, maKH });
					JOptionPane.showMessageDialog(null, "Sửa thành công");
				} else if (e.getActionCommand().equals("Xóa")) {
					if(QLDT.vaiTro == 1) {
						int a = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa?");
						if (a == 0) {
							JOptionPane.showMessageDialog(null, "Xóa thành công!");
							int r = table.getSelectedRow();
							String maKH = (String) model.getValueAt(r, 0);
							AbstractDao.executeQuery("delete from khoahoc where makh = ?", maKH);
						}
					} else {
						JOptionPane.showMessageDialog(null, "Bạn không có quyền xóa!");
					}
				}
				btnThem.setEnabled(false);
				btnSua.setEnabled(true);
				btnXoa.setEnabled(true);

				btnHuy.setVisible(false);
				btnMoi.setVisible(true);
				loadKhoaHoc();
				display(0);
			} else {
				JOptionPane.showMessageDialog(null, error.toString(), "Lỗi", JOptionPane.WARNING_MESSAGE);
			}
		}
	};

	public void display(int r) {
		try {
			FormHelper.display(list, model, r, table);
			textArea.setText(listKhoaHocs.get(r).getGhiChu());

		} catch (Exception e) {
			FormHelper.clear(list);
			textArea.setText("");
		}
	}

	public void loadChuyenDe() {
		listChuyenDe.forEach((cd) -> {
			comboBox.addItem(cd.getTenCD());
		});
	}

	String macd = null;

	public void loadKhoaHoc() {
		listKhoaHocs.removeAll(listKhoaHocs);
		model.setRowCount(0);
		listChuyenDe.forEach((cd) -> {
			if (cd.getTenCD().equals((String) comboBox.getSelectedItem())) {
				macd = cd.getMaCD();
			}
		});

		listKhoaHocs = new KhoaHocDao().fillByChuyenDe(macd);
		macd = null;
		listKhoaHocs.forEach((cd) -> {
			model.addRow(new Object[] { cd.getMaKh(), cd.getThoiLuong(), cd.getHocPhi(), cd.getNgayKG(),
					cd.getNguoiTao(), cd.getNgayTao() });

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
			current = listKhoaHocs.size() - 1;
			display(current);
		}
	};

	ActionListener next = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			current += 1;
			if (current == listKhoaHocs.size()) {
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
				current = listKhoaHocs.size() - 1;
			}
			display(current);
		}
	};
}
