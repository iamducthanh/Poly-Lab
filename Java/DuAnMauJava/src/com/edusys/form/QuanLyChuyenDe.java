package com.edusys.form;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
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
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.edusys.dao.impl.AbstractDao;
import com.edusys.dao.impl.ChuyenDeDao;
import com.edusys.helper.FormHelper;
import com.edusys.helper.ImageHelper;
import com.edusys.helper.Validate;
import com.edusys.model.ChuyenDe;

@SuppressWarnings("serial")
public class QuanLyChuyenDe extends JInternalFrame {
	InputStream inStream = null;
	OutputStream outStream = null;
	private JPanel contentPane;
	private JTable table;
	DefaultTableModel model = new DefaultTableModel();
	DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
	private JTextField textMa;
	private JTextField textChuyenDe;
	private JTextField textThoiLuong;
	private JTextField textHocPhi;
	ArrayList<ChuyenDe> listChuyenDe = new ArrayList<ChuyenDe>();
	ArrayList<JTextField> list = new ArrayList<JTextField>();
	JLabel lblAnh = new JLabel("");
	String path = "";
	File file1;
	int current = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuanLyChuyenDe frame = new QuanLyChuyenDe();
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
	JButton btnSua = new JButton("Sửa");
	JButton btnMoi = new JButton("Mới");
	JButton btnHuy = new JButton("Hủy");
	JButton btnXoa = new JButton("Xóa");
	JButton btnThem = new JButton("Thêm");
	JTextArea textArea = new JTextArea();

	public QuanLyChuyenDe() {
		setTitle("Quản lý chuyên đề");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 636, 569);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JLabel lblQunLChuyn = new JLabel("QUẢN LÝ CHUYÊN ĐỀ");
		lblQunLChuyn.setForeground(Color.BLUE);
		lblQunLChuyn.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblQunLChuyn.setBounds(10, 11, 257, 34);
		contentPane.add(lblQunLChuyn, BorderLayout.NORTH);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		rightRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);

//
//		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
//		tabbedPane.setBounds(10, 39, 602, 482);
//		contentPane.add(tabbedPane);
//
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("DANH SÁCH", null, scrollPane, null);

		table = new JTable();
		scrollPane.setViewportView(table);
		model.addColumn("MÃ CD");
		model.addColumn("TÊN CD");
		model.addColumn("HỌC PHÍ");
		model.addColumn("THỜI LƯỢNG");
		model.addColumn("HÌNH");
		table.setModel(model);

		JScrollPane scrollPane_1 = new JScrollPane();
		tabbedPane.addTab("Cập nhật", null, scrollPane_1);

		JPanel panel = new JPanel();
		scrollPane_1.setViewportView(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Hình logo");
		lblNewLabel.setBounds(10, 11, 115, 14);
		panel.add(lblNewLabel);

		lblAnh.setIcon(new ImageIcon("C:\\udpm\\Image\\user.jpg"));
		lblAnh.setBackground(Color.DARK_GRAY);
		lblAnh.setBounds(15, 30, 169, 197);
		panel.add(lblAnh);

		JLabel lblMChuyn = new JLabel("Mã chuyên đề");
		lblMChuyn.setBounds(194, 11, 115, 14);
		panel.add(lblMChuyn);

		textMa = new JTextField();
		textMa.setBounds(194, 30, 405, 26);
		panel.add(textMa);
		textMa.setColumns(10);

		JLabel lblNewLabel_2_1 = new JLabel("Tên chuyên đề");
		lblNewLabel_2_1.setBounds(194, 67, 115, 14);
		panel.add(lblNewLabel_2_1);

		textChuyenDe = new JTextField();
		textChuyenDe.setColumns(10);
		textChuyenDe.setBounds(194, 87, 405, 26);
		panel.add(textChuyenDe);

		JLabel lblNewLabel_2_1_1 = new JLabel("Thời lượng (giờ)");
		lblNewLabel_2_1_1.setBounds(194, 124, 115, 14);
		panel.add(lblNewLabel_2_1_1);

		textThoiLuong = new JTextField();
		textThoiLuong.setColumns(10);
		textThoiLuong.setBounds(194, 143, 405, 26);
		panel.add(textThoiLuong);

		JLabel lblNewLabel_2_1_1_1 = new JLabel("Học phí");
		lblNewLabel_2_1_1_1.setBounds(194, 180, 115, 14);
		panel.add(lblNewLabel_2_1_1_1);

		textHocPhi = new JTextField();
		textHocPhi.setColumns(10);
		textHocPhi.setBounds(194, 201, 405, 26);
		panel.add(textHocPhi);

		JLabel lblMTiChuyn = new JLabel("Mô tải chuyên đề");
		lblMTiChuyn.setBounds(10, 238, 115, 14);
		panel.add(lblMTiChuyn);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 263, 590, 121);
		panel.add(scrollPane_2);

		scrollPane_2.setViewportView(textArea);

		btnThem.setEnabled(false);
		btnThem.setBounds(10, 407, 73, 23);
		panel.add(btnThem);

		btnSua.setBounds(93, 407, 73, 23);
		panel.add(btnSua);

		btnXoa.setBounds(176, 407, 73, 23);
		panel.add(btnXoa);

		btnMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormHelper.clear(list);
				textArea.setText("");
				lblAnh.setIcon(null);
				btnThem.setEnabled(true);
				btnSua.setEnabled(false);
				btnXoa.setEnabled(false);
				btnMoi.setVisible(false);
				btnHuy.setVisible(true);

			}
		});
		btnMoi.setBounds(259, 407, 73, 23);
		panel.add(btnMoi);
		btnHuy.setBounds(259, 407, 73, 23);
		panel.add(btnHuy);
		btnHuy.setVisible(false);

		JButton btnPre = new JButton("<<");
		btnPre.setFont(new Font("Tahoma", Font.BOLD, 8));
		btnPre.setBounds(438, 408, 47, 23);
		panel.add(btnPre);

		JButton btnNext = new JButton(">>");
		btnNext.setFont(new Font("Tahoma", Font.BOLD, 8));
		btnNext.setBounds(495, 408, 47, 23);
		panel.add(btnNext);

		JButton btnLast = new JButton(">|");
		btnLast.setFont(new Font("Tahoma", Font.BOLD, 8));
		btnLast.setBounds(552, 408, 47, 23);
		panel.add(btnLast);

		JButton btnFirst = new JButton("|<");
		btnFirst.setFont(new Font("Tahoma", Font.BOLD, 8));
		btnFirst.setBounds(381, 408, 47, 23);
		panel.add(btnFirst);
		loadTable();

		table.getColumnModel().getColumn(0).setPreferredWidth(10);
		table.getColumnModel().getColumn(1).setPreferredWidth(200);
		table.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);

		list.add(textMa);
		list.add(textChuyenDe);
		list.add(textHocPhi);
		list.add(textThoiLuong);

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				display(row);
			}
		});
		lblAnh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFileChooser file = new JFileChooser();
				FileFilter filter = new FileNameExtensionFilter("JPG and PNG", new String[] { "JPG", "PNG" });
//				FileNameExtensionFilter filter = new FileNameExtensionFilter("img", "png", "text");
				file.setFileFilter(filter);

				int i = file.showOpenDialog(null);
				if (i == 0) {
					path = file.getSelectedFile().getPath();
					ImageIcon img = new ImageIcon(path);
					int width = lblAnh.getWidth();
					int height = lblAnh.getHeight();
					Image image = ImageHelper.resize(img.getImage(), width, height);
					lblAnh.setIcon(new ImageIcon(image));
				}
			}
		});
		btnThem.addActionListener(them);
		btnSua.addActionListener(them);
		btnXoa.addActionListener(them);
		display(0);
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
			if (e.getActionCommand().equals("Thêm")) {
				if (!Validate.checkNull(textMa.getText())) {
					error.append("Không được để trống mã chuyên đề!\n");
				} else if (new ChuyenDeDao().fillByMa(textMa.getText()).size() != 0) {
					error.append("Mã chuyên đề này đã tồn tại!\n");
				}
			}
			if (!Validate.checkNull(textChuyenDe.getText())) {
				error.append("Không được để trống tên chuyên đề!\n");
			}
			if (!Validate.checkNull(textThoiLuong.getText())) {
				error.append("Không được để trống thời lượng!\n");
			} else if (!Validate.checkSo(textThoiLuong.getText())) {
				error.append("Nhập sai thời lượng hãy kiểm tra lại!\n");
			}
			if (!Validate.checkNull(textHocPhi.getText())) {
				error.append("Không được để trống học phí!");
			} else if (!Validate.checkSo(textHocPhi.getText())) {
				error.append("Nhập sai học phí hãy kiểm tra lại!\n");
			}

			if (error.toString().isBlank()) {
				String maCD = textMa.getText();
				String tenCD = textChuyenDe.getText();
				String thoiLuong = textThoiLuong.getText();
				String hocPhi = textHocPhi.getText();
				String moTa = textArea.getText();
				if (!path.equals("")) {
					file1 = new File(path);
				}
				if (e.getActionCommand().equals("Thêm")) {
					try {
						inStream = new FileInputStream(new File(path));
						outStream = new FileOutputStream(new File("C:\\udpm\\logo\\" + file1.getName()));

						int length;
						byte[] buffer = new byte[1024];

						// copy the file content in bytes
						while ((length = inStream.read(buffer)) > 0) {
							outStream.write(buffer, 0, length);
						}
					} catch (Exception e1) {
						e1.printStackTrace();
					} finally {
						try {
							inStream.close();
							outStream.close();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					try {
						AbstractDao.executeQuery("insert into chuyende values (?,?,?,?,?,?)",
								new Object[] { maCD, tenCD, hocPhi, thoiLuong, file1.getName(), moTa });
					} catch (Exception ex) {
						AbstractDao.executeQuery("insert into chuyende values (?,?,?,?,?,?)",
								new Object[] { maCD, tenCD, hocPhi, thoiLuong, "", moTa });
					}
					JOptionPane.showMessageDialog(null, "Thêm thành công!");
				} else if (e.getActionCommand().equals("Sửa")) {
					try {
						AbstractDao.executeQuery(
								"update ChuyenDe set tencd = ?, hocphi = ?, thoiluong = ?, hinh = ?, mota = ? where macd = ?",
								new Object[] { tenCD, hocPhi, thoiLuong, file1.getName(), moTa, maCD });
					} catch (Exception ex) {
						AbstractDao.executeQuery(
								"update ChuyenDe set tencd = ?, hocphi = ?, thoiluong = ?, hinh = ?, mota = ? where macd = ?",
								new Object[] { tenCD, hocPhi, thoiLuong, "", moTa, maCD });
					}
					JOptionPane.showMessageDialog(null, "Sửa thành công");
				} else if (e.getActionCommand().equals("Xóa")) {
					if(QLDT.vaiTro == 1) {
						int a = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa?");
						if (a == 0) {
							JOptionPane.showMessageDialog(null, "Xóa thành công!");
							AbstractDao.executeQuery("delete from ChuyenDe where macd = ?", textMa.getText());
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
				loadTable();
				display(0);
				path = "";
			} else {
				JOptionPane.showMessageDialog(null, error.toString(), "Lỗi", JOptionPane.WARNING_MESSAGE);
			}
		}
	};

	public void display(int r) {
		FormHelper.display(list, model, r, table);
		textArea.setText(listChuyenDe.get(r).getMoTa());
		try {
			path = "C:\\udpm\\logo\\" + listChuyenDe.get(r).getHinh();
			ImageIcon img = new ImageIcon(path);
			int width = lblAnh.getWidth();
			int height = lblAnh.getHeight();
			Image image = ImageHelper.resize(img.getImage(), width, height);
			lblAnh.setIcon(new ImageIcon(image));
		} catch (Exception e) {
			lblAnh.setIcon(null);
		}
	}

	public void loadTable() {
		model.setRowCount(0);
		listChuyenDe = new ChuyenDeDao().fillAll();
		listChuyenDe.forEach((cd) -> {
			model.addRow(new Object[] { cd.getMaCD(), cd.getTenCD(), cd.getHocPhi(), cd.getThoiLuong(), cd.getHinh(),
					cd.getMoTa() });
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
			current = listChuyenDe.size() - 1;
			display(current);
		}
	};

	ActionListener next = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			current += 1;
			if (current == listChuyenDe.size()) {
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
				current = listChuyenDe.size() - 1;
			}
			display(current);
		}
	};
}
