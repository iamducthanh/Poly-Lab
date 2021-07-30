package form;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.table.DefaultTableModel;

import dao.GradeDao;
import dao.StudentDao;
import entities.StudentGrade;
import entities.Students;
import help.ImageEdit;
import help.ValidateGrade;
import help.ValidateStudent;

@SuppressWarnings("serial")
public class QLSV extends JFrame {
	int current = 0;
	private JPanel contentPane;
	private JTextField textMaSV;
	private JTextField textHoTen;
	private JTextField textEmail;
	private JTextField textSoDT;
	private JTable table;
	DefaultTableModel model1 = new DefaultTableModel();
	DefaultTableModel model2 = new DefaultTableModel();
	private JTextField textMaSVSearch;
	private JTextField textMaSV2;
	private JTextField textGDTC;
	private JTextField textHoTen2;
	private JTextField textTiengAnh;
	private JTextField textTinHoc;
	private JTable table_1;
	JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	JPanel panelQLSV = new JPanel();
	JPanel panelQLD = new JPanel();
	static QLSV frame;
	public static ArrayList<Students> listStudent = new ArrayList<Students>();
	static ArrayList<StudentGrade> listGrade = new ArrayList<StudentGrade>();
	JRadioButton rdbtnNam = new JRadioButton("Nam");
	JRadioButton rdbtnNu = new JRadioButton("Nữ");
	JTextArea textDiaChi = new JTextArea();
	JLabel lblAvatar = new JLabel("Avatar", JLabel.CENTER);
	byte[] imageByte = null;
	JLabel lblDiemTB = new JLabel("");
	DecimalFormat fm = new DecimalFormat("#.#");
	JButton btnSave_1 = new JButton("Save   ");
	JButton btnCancel = new JButton("Cancel");
	JButton btnUpdate_1 = new JButton("Update");
	JButton btnDelete_1 = new JButton("Delete");

	/**
	 * Launch the application.
	 */
	public void mainQLSV() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new QLSV();
					frame.setLocationRelativeTo(null);
					frame.setTitle("Quản lý sinh viên");
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
	public QLSV() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 798, 634);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 786, 22);
		contentPane.add(menuBar);

		JMenu mnHeThong = new JMenu("H\u1EC7 th\u1ED1ng");
		menuBar.add(mnHeThong);

		JMenuItem mntmDangXuat = new JMenuItem("\u0110\u0103ng xu\u1EA5t");
		mntmDangXuat.setIcon(new ImageIcon(
				"C:\\Users\\ADMIN\\eclipse-workspace\\Assignment_Java3_PH12794\\src\\Image\\logout1.png"));
		mnHeThong.add(mntmDangXuat);

		JMenuItem mntmThoat = new JMenuItem("Tho\u00E1t");
		mntmThoat.setIcon(
				new ImageIcon("C:\\Users\\ADMIN\\eclipse-workspace\\Assignment_Java3_PH12794\\src\\Image\\exit.png"));
		mnHeThong.add(mntmThoat);

		JMenu mnQuanLy = new JMenu("Qu\u1EA3n l\u00FD");
		menuBar.add(mnQuanLy);

		JMenuItem mntmQLSV = new JMenuItem("Qu\u1EA3n l\u00FD sinh vi\u00EAn");
		mntmQLSV.setIcon(new ImageIcon(
				"C:\\Users\\ADMIN\\eclipse-workspace\\Assignment_Java3_PH12794\\src\\Image\\student1.png"));
		mnQuanLy.add(mntmQLSV);

		JMenu mnTroGiup = new JMenu("Tr\u1EE3 gi\u00FAp");
		menuBar.add(mnTroGiup);

		JMenuItem mntmGioiThieu = new JMenuItem("Gi\u1EDBi thi\u1EC7u");
		mntmGioiThieu.setIcon(
				new ImageIcon("C:\\Users\\ADMIN\\eclipse-workspace\\Assignment_Java3_PH12794\\src\\Image\\hoi1.png"));
		mnTroGiup.add(mntmGioiThieu);

		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(0, 23, 786, 51);
		contentPane.add(toolBar);

		JButton btnDangXuat = new JButton("  ");
		btnDangXuat.setHorizontalAlignment(SwingConstants.LEADING);
		btnDangXuat.setToolTipText("");
		btnDangXuat.setContentAreaFilled(false);
		btnDangXuat.setBorder(null);
		btnDangXuat.setIcon(
				new ImageIcon("C:\\Users\\ADMIN\\eclipse-workspace\\Assignment_Java3_PH12794\\src\\Image\\logout.png"));
		toolBar.add(btnDangXuat);

		JButton btnStudent = new JButton("  ");
		btnStudent.setContentAreaFilled(false);
		btnStudent.setBorder(null);
		btnStudent.setIcon(new ImageIcon(
				"C:\\Users\\ADMIN\\eclipse-workspace\\Assignment_Java3_PH12794\\src\\Image\\student.png"));
		toolBar.add(btnStudent);

		JButton btnDiem = new JButton("  ");
		btnDiem.setContentAreaFilled(false);
		btnDiem.setBorder(null);
		btnDiem.setIcon(
				new ImageIcon("C:\\Users\\ADMIN\\eclipse-workspace\\Assignment_Java3_PH12794\\src\\Image\\diem.png"));
		toolBar.add(btnDiem);

		JButton btnGioiThieu = new JButton("");
		btnGioiThieu.setContentAreaFilled(false);
		btnGioiThieu.setBorder(null);
		btnGioiThieu.setIcon(
				new ImageIcon("C:\\Users\\ADMIN\\eclipse-workspace\\Assignment_Java3_PH12794\\src\\Image\\hoi.png"));
		toolBar.add(btnGioiThieu);

		tabbedPane.setBounds(10, 85, 763, 500);
		contentPane.add(tabbedPane);

		panelQLSV.setLayout(null);

		JLabel lblQLSV = new JLabel("Quản lý sinh viên");
		lblQLSV.setForeground(Color.BLUE);
		lblQLSV.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblQLSV.setBounds(10, 11, 292, 24);
		panelQLSV.add(lblQLSV);

		JLabel lblMaSV = new JLabel("Mã sinh viên");
		lblMaSV.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMaSV.setBounds(70, 49, 74, 19);
		panelQLSV.add(lblMaSV);

		JLabel lblDiaChi = new JLabel("Địa chỉ");
		lblDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDiaChi.setBounds(102, 215, 42, 19);
		panelQLSV.add(lblDiaChi);

		textMaSV = new JTextField();
		textMaSV.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textMaSV.setColumns(10);
		textMaSV.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textMaSV.setBounds(165, 46, 230, 23);
		panelQLSV.add(textMaSV);

		textHoTen = new JTextField();
		textHoTen.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textHoTen.setColumns(10);
		textHoTen.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textHoTen.setBounds(165, 80, 230, 23);
		panelQLSV.add(textHoTen);

		textEmail = new JTextField();
		textEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textEmail.setColumns(10);
		textEmail.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textEmail.setBounds(165, 114, 230, 23);
		panelQLSV.add(textEmail);

		textSoDT = new JTextField();
		textSoDT.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textSoDT.setColumns(10);
		textSoDT.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textSoDT.setBounds(165, 148, 230, 23);
		panelQLSV.add(textSoDT);

		btnStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!Login.vaiTro.equals("Cán bộ đào tạo")) {
					JOptionPane.showMessageDialog(null, "Bạn không có quyền truy cập vào mục này!", "Cảnh báo",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});

		btnDiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!Login.vaiTro.equals("Giảng viên")) {
					JOptionPane.showMessageDialog(null, "Bạn không có quyền truy cập vào mục này!", "Cảnh báo",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});

		rdbtnNam.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnNam.setBounds(175, 180, 60, 23);
		panelQLSV.add(rdbtnNam);

		rdbtnNu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnNu.setBounds(235, 180, 111, 23);
		panelQLSV.add(rdbtnNu);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(165, 216, 230, 69);
		panelQLSV.add(scrollPane);

		textDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textDiaChi.setBorder(new BevelBorder(BevelBorder.LOWERED));
		scrollPane.setViewportView(textDiaChi);

		JLabel lblHoTen = new JLabel("Họ tên");
		lblHoTen.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblHoTen.setBounds(104, 83, 40, 19);
		panelQLSV.add(lblHoTen);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEmail.setBounds(111, 117, 33, 19);
		panelQLSV.add(lblEmail);

		JLabel lblSoDT = new JLabel("Số điện thoại");
		lblSoDT.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSoDT.setBounds(66, 151, 78, 19);
		panelQLSV.add(lblSoDT);

		JLabel lblGioiTinh = new JLabel("Giới tính");
		lblGioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblGioiTinh.setBounds(95, 183, 49, 19);
		panelQLSV.add(lblGioiTinh);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_1.setBounds(481, 45, 128, 158);
		panelQLSV.add(panel_1);
		panel_1.setLayout(null);

		lblAvatar.setIcon(
				new ImageIcon("C:\\Users\\ADMIN\\eclipse-workspace\\Assignment_Java3_PH12794\\src\\Image\\user.jpg"));
		lblAvatar.setBounds(6, 6, 115, 147);
		panel_1.add(lblAvatar);

		JButton btnNew = new JButton("New   ");
		btnNew.setIcon(
				new ImageIcon("C:\\Users\\ADMIN\\eclipse-workspace\\Assignment_Java3_PH12794\\src\\Image\\clear.png"));
		btnNew.setBorder(new BevelBorder(BevelBorder.RAISED));
		btnNew.setBounds(453, 224, 89, 23);
		panelQLSV.add(btnNew);

		JButton btnSave = new JButton("Save    ");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSave.setIcon(
				new ImageIcon("C:\\Users\\ADMIN\\eclipse-workspace\\Assignment_Java3_PH12794\\src\\Image\\luu.png"));
		btnSave.setBorder(new BevelBorder(BevelBorder.RAISED));
		btnSave.setBounds(552, 224, 89, 23);
		panelQLSV.add(btnSave);

		JButton btnDelete = new JButton("Delete");
		btnDelete.setIcon(
				new ImageIcon("C:\\Users\\ADMIN\\eclipse-workspace\\Assignment_Java3_PH12794\\src\\Image\\delete.png"));
		btnDelete.setBorder(new BevelBorder(BevelBorder.RAISED));
		btnDelete.setBounds(453, 252, 89, 23);
		panelQLSV.add(btnDelete);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.setIcon(
				new ImageIcon("C:\\Users\\ADMIN\\eclipse-workspace\\Assignment_Java3_PH12794\\src\\Image\\update.png"));
		btnUpdate.setBorder(new BevelBorder(BevelBorder.RAISED));
		btnUpdate.setBounds(552, 252, 89, 23);
		panelQLSV.add(btnUpdate);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 303, 738, 158);
		panelQLSV.add(scrollPane_1);

		table = new JTable();
		scrollPane_1.setViewportView(table);
		table();
		ButtonGroup gr = new ButtonGroup();
		gr.add(rdbtnNam);
		gr.add(rdbtnNu);

		panelQLD.setLayout(null);

		JLabel lblQunLim = new JLabel("Quản lý điểm");
		lblQunLim.setForeground(Color.BLUE);
		lblQunLim.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblQunLim.setBounds(10, 11, 292, 24);
		panelQLD.add(lblQunLim);

		textMaSV2 = new JTextField();
		textMaSV2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textMaSV2.setColumns(10);
		textMaSV2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textMaSV2.setBounds(143, 131, 230, 23);
		panelQLD.add(textMaSV2);

		textGDTC = new JTextField();
		textGDTC.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textGDTC.setColumns(10);
		textGDTC.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textGDTC.setBounds(143, 267, 230, 23);
		panelQLD.add(textGDTC);

		textHoTen2 = new JTextField();
		textHoTen2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textHoTen2.setColumns(10);
		textHoTen2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textHoTen2.setBounds(143, 165, 230, 23);
		panelQLD.add(textHoTen2);

		textTiengAnh = new JTextField();
		textTiengAnh.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textTiengAnh.setColumns(10);
		textTiengAnh.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textTiengAnh.setBounds(143, 199, 230, 23);
		panelQLD.add(textTiengAnh);

		textTinHoc = new JTextField();
		textTinHoc.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textTinHoc.setColumns(10);
		textTinHoc.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textTinHoc.setBounds(143, 233, 230, 23);
		panelQLD.add(textTinHoc);

		JLabel lblMaSV_1_1 = new JLabel("Mã sinh viên");
		lblMaSV_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMaSV_1_1.setBounds(50, 133, 74, 19);
		panelQLD.add(lblMaSV_1_1);

		JLabel lblHoTen_1 = new JLabel("Họ tên");
		lblHoTen_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblHoTen_1.setBounds(84, 167, 40, 19);
		panelQLD.add(lblHoTen_1);

		JLabel lblTingAnh = new JLabel("Tiếng anh");
		lblTingAnh.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTingAnh.setBounds(65, 201, 59, 19);
		panelQLD.add(lblTingAnh);

		JLabel lblTinHc = new JLabel("Tin học");
		lblTinHc.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTinHc.setBounds(79, 235, 49, 19);
		panelQLD.add(lblTinHc);

		JLabel lblGdtc = new JLabel("GDTC");
		lblGdtc.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblGdtc.setBounds(89, 269, 39, 19);
		panelQLD.add(lblGdtc);

		JPanel panel_3 = new JPanel();
		panel_3.setBorder(
				new TitledBorder(null, "T\u00ECm ki\u1EBFm", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(65, 46, 633, 58);
		panelQLD.add(panel_3);
		panel_3.setLayout(null);

		textMaSVSearch = new JTextField();
		textMaSVSearch.setBounds(161, 24, 284, 23);
		panel_3.add(textMaSVSearch);
		textMaSVSearch.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textMaSVSearch.setColumns(10);
		textMaSVSearch.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));

		JLabel lblMaSV_1 = new JLabel("Mã sinh viên");
		lblMaSV_1.setBounds(62, 26, 74, 19);
		panel_3.add(lblMaSV_1);
		lblMaSV_1.setFont(new Font("Tahoma", Font.PLAIN, 13));

		JButton btnSearch = new JButton("Search");
		btnSearch.setIcon(
				new ImageIcon("C:\\Users\\ADMIN\\eclipse-workspace\\Assignment_Java3_PH12794\\src\\Image\\find.png"));
		btnSearch.setBounds(477, 25, 89, 23);
		panel_3.add(btnSearch);
		btnSearch.setBorder(new BevelBorder(BevelBorder.RAISED));

		JButton btnNew_2 = new JButton("New   ");
		btnNew_2.setIcon(
				new ImageIcon("C:\\Users\\ADMIN\\eclipse-workspace\\Assignment_Java3_PH12794\\src\\Image\\clear.png"));
		btnNew_2.setBorder(new BevelBorder(BevelBorder.RAISED));
		btnNew_2.setBounds(557, 132, 89, 23);
		panelQLD.add(btnNew_2);
		btnSave_1.setEnabled(false);

		btnSave_1.setIcon(
				new ImageIcon("C:\\Users\\ADMIN\\eclipse-workspace\\Assignment_Java3_PH12794\\src\\Image\\luu.png"));
		btnSave_1.setBorder(new BevelBorder(BevelBorder.RAISED));
		btnSave_1.setBounds(557, 166, 89, 23);
		panelQLD.add(btnSave_1);

		btnDelete_1.setIcon(
				new ImageIcon("C:\\Users\\ADMIN\\eclipse-workspace\\Assignment_Java3_PH12794\\src\\Image\\delete.png"));
		btnDelete_1.setBorder(new BevelBorder(BevelBorder.RAISED));
		btnDelete_1.setBounds(557, 200, 89, 23);
		panelQLD.add(btnDelete_1);

		btnUpdate_1.setIcon(
				new ImageIcon("C:\\Users\\ADMIN\\eclipse-workspace\\Assignment_Java3_PH12794\\src\\Image\\update.png"));
		btnUpdate_1.setBorder(new BevelBorder(BevelBorder.RAISED));
		btnUpdate_1.setBounds(557, 234, 89, 23);
		panelQLD.add(btnUpdate_1);

		JLabel lblMaSV_1_1_1 = new JLabel("Điểm trung bình");
		lblMaSV_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMaSV_1_1_1.setBounds(417, 167, 108, 19);
		panelQLD.add(lblMaSV_1_1_1);

		lblDiemTB.setForeground(Color.BLUE);
		lblDiemTB.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDiemTB.setFont(new Font("Tahoma", Font.BOLD, 38));
		lblDiemTB.setBounds(400, 179, 94, 73);
		panelQLD.add(lblDiemTB);

		JButton btnFirst = new JButton("");
		btnFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				first();
			}
		});
		btnFirst.setContentAreaFilled(false);
		btnFirst.setBorder(null);
		btnFirst.setIcon(new ImageIcon(
				"C:\\Users\\ADMIN\\eclipse-workspace\\Assignment_Java3_PH12794\\src\\Image\\previous.png"));
		btnFirst.setBounds(143, 310, 49, 34);
		panelQLD.add(btnFirst);

		JButton btnPrevious = new JButton("");
		btnPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				previous();
			}
		});
		btnPrevious.setContentAreaFilled(false);
		btnPrevious.setBorder(null);
		btnPrevious.setIcon(new ImageIcon(
				"C:\\Users\\ADMIN\\eclipse-workspace\\Assignment_Java3_PH12794\\src\\Image\\previous1.png"));
		btnPrevious.setBounds(202, 310, 49, 34);
		panelQLD.add(btnPrevious);

		JButton btnNext = new JButton("");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				next();
			}
		});
		btnNext.setContentAreaFilled(false);
		btnNext.setBorder(null);
		btnNext.setIcon(
				new ImageIcon("C:\\Users\\ADMIN\\eclipse-workspace\\Assignment_Java3_PH12794\\src\\Image\\next.png"));
		btnNext.setBounds(261, 310, 49, 34);
		panelQLD.add(btnNext);

		JButton btnLast = new JButton("");
		btnLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				last();
			}
		});
		btnLast.setContentAreaFilled(false);
		btnLast.setBorder(null);
		btnLast.setIcon(
				new ImageIcon("C:\\Users\\ADMIN\\eclipse-workspace\\Assignment_Java3_PH12794\\src\\Image\\Last.png"));
		btnLast.setBounds(320, 310, 49, 34);
		panelQLD.add(btnLast);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 373, 738, 88);
		panelQLD.add(scrollPane_2);

		table_1 = new JTable();
		scrollPane_2.setViewportView(table_1);

		JLabel lblNewLabel = new JLabel("3 sinh viên có điểm trung bình cao nhất");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 355, 359, 14);
		panelQLD.add(lblNewLabel);
		table2();
		login();
		btnDangXuat.addActionListener(logout);
		mntmDangXuat.addActionListener(logout);
		rdbtnNam.setSelected(true);
		btnSave.addActionListener(saveStudent);
		textMaSV2.setEditable(false);
		textHoTen2.setEditable(false);
		btnCancel.setVisible(false);
		btnCancel.setBorder(new BevelBorder(BevelBorder.RAISED));
		btnCancel.setBounds(557, 200, 89, 23);
		panelQLD.add(btnCancel);

		lblAvatar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				getAvatar();
			}
		});

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int r = table.getSelectedRow();
				display(r);
			}
		});

		btnNew.addActionListener(this.btnNew);
		btnNew_2.addActionListener(btnNew2);
		btnDelete.addActionListener(delete);
		btnUpdate.addActionListener(update);
		btnSearch.addActionListener(search);
		btnCancel.addActionListener(cancel);
		btnSave_1.addActionListener(saveGrade);
		btnUpdate_1.addActionListener(updateGrade);
		btnDelete_1.addActionListener(deleteGrade);
	}
	
	ActionListener updateGrade = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			StringBuilder error = new StringBuilder();
			String tiengAnh = textTiengAnh.getText();
			String tinHoc = textTinHoc.getText();
			String GDTC = textGDTC.getText();
			error.append(ValidateGrade.checkSo(tiengAnh, tinHoc, GDTC));
			if(!error.toString().isBlank()) {
				JOptionPane.showMessageDialog(null, error.toString(),"Lỗi",JOptionPane.ERROR_MESSAGE);
			} else {
				try {
					GradeDao.update(textMaSV2.getText(), tiengAnh, tinHoc, GDTC);
					loadData2();
					loadTable2();
					JOptionPane.showMessageDialog(null, "Update thành công!");
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	};
	
	ActionListener search = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			int i;
			if(!textMaSVSearch.getText().isBlank()) {
				String search = textMaSVSearch.getText();
				for(i=0;i<listGrade.size();i++) {
					if(listGrade.get(i).maSV.equalsIgnoreCase(search)) {
						break;
					}
				}
				if(i == listGrade.size()) {
					JOptionPane.showMessageDialog(null, "Không tìm thấy sinh viên có mã: "+ search);
				} else {
					display2(i);
					JOptionPane.showMessageDialog(null, "Đã tìm thấy!");
				}
			}
		}
	};

	ActionListener btnNew = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			textMaSV.setText("");
			textHoTen.setText("");
			textEmail.setText("");
			textSoDT.setText("");
			textDiaChi.setText("");
			rdbtnNam.setSelected(true);
			lblAvatar.setIcon(null);
			imageByte = null;
		}
	};
	
	ActionListener btnNew2 = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			btnSave_1.setEnabled(true);
			textMaSV2.setText("");
			textMaSV2.setEditable(true);
			textHoTen2.setText("");
			textHoTen2.setEditable(true);
			textTiengAnh.setText("");
			textTinHoc.setText("");
			textGDTC.setText("");
			btnCancel.setVisible(true);
			btnDelete_1.setVisible(false);
			btnUpdate_1.setVisible(false);
			lblDiemTB.setText("");
		}
	};
	
	ActionListener cancel = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			btnSave_1.setEnabled(false);
			textMaSV2.setEditable(false);
			textHoTen2.setEditable(false);
			btnCancel.setVisible(false);
			btnDelete_1.setVisible(true);
			btnUpdate_1.setVisible(true);
			display2(current);
		}
	};

	public void getAvatar() {
		JFileChooser chooser = new JFileChooser();
		chooser.setFileFilter(new FileFilter() {

			@Override
			public String getDescription() {
				// TODO Auto-generated method stub
				return "Image file (*.jpg)";
			}

			@Override
			public boolean accept(File f) {
				// TODO Auto-generated method stub
				if (f.isDirectory()) {
					return true;
				} else {
					return f.getName().toLowerCase().endsWith(".jpg");
				}
			}
		});
		int rVal = chooser.showOpenDialog(null);

		if (rVal == 0) {
			ImageIcon icon = new ImageIcon(chooser.getSelectedFile().getPath());
			Image img = ImageEdit.resize(icon.getImage(), lblAvatar.getWidth(), lblAvatar.getHeight());
			ImageIcon resizeIcon = new ImageIcon(img);
			lblAvatar.setIcon(resizeIcon);
			try {
				imageByte = ImageEdit.getByteImage(img, "jpg");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	ActionListener delete = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			int r = table.getSelectedRow();
			int comfirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa sinh viên này!");
			if (comfirm == 0) {
				try {
					StudentDao.delete(listStudent.get(r).maSV);
					loadData();
					loadTable();
					display(0);
					JOptionPane.showMessageDialog(null, "Xóa thành công!");
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	};
	
	ActionListener deleteGrade = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			int r = table.getSelectedRow();
			int comfirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn điểm của sinh viên này!");
			if (comfirm == 0) {
				try {
					GradeDao.delete(textMaSV2.getText());
					loadData2();
					loadTable2();
					display2(0);
					JOptionPane.showMessageDialog(null, "Xóa thành công!");
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	};
	
	ActionListener saveStudent = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			StringBuilder error = new StringBuilder();
			String maSV = textMaSV.getText();
			String hoTen = textHoTen.getText();
			String email = textEmail.getText();
			String soDT = textSoDT.getText();
			String gioiTinh = rdbtnNam.isSelected() == true ? "Nam" : "Nữ";
			String diaChi = textDiaChi.getText();

			error.append(ValidateStudent.checkMa(maSV));
			error.append(ValidateStudent.checkTen(hoTen));
			error.append(ValidateStudent.checkEmail(email));
			error.append(ValidateStudent.checkSoDT(soDT));
			error.append(ValidateStudent.checkDiaChi(diaChi));
			if (!error.toString().isBlank()) {
				JOptionPane.showMessageDialog(null, error, "Lỗi", JOptionPane.ERROR_MESSAGE);
			} else {
				try {
					StudentDao.insert(maSV, hoTen, email, soDT, gioiTinh, diaChi, imageByte);
					loadData();
					loadTable();
					display(0);
					imageByte = null;
					JOptionPane.showMessageDialog(null, "Thêm thành công!");
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	};
	
	ActionListener saveGrade = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			StringBuilder error = new StringBuilder();
			String maSV = textMaSV2.getText();
			String hoTen = textHoTen2.getText();
			String tiengAnh = textTiengAnh.getText();
			String tinHoc = textTinHoc.getText();
			String GDTC = textGDTC.getText();
			error.append(ValidateGrade.checkMaSV(maSV, listGrade));
			error.append(ValidateGrade.checkTen(hoTen));
			error.append(ValidateGrade.checkSo(tiengAnh, tinHoc, GDTC));
			error.append(ValidateGrade.checkSV(maSV, hoTen));
			if(error.toString().isBlank()) {
				try {
					GradeDao.insertGrade(maSV, tiengAnh, tinHoc, GDTC);
					loadData2();
					loadTable2();
					cancel.actionPerformed(e);
					JOptionPane.showMessageDialog(null, "Save thành công!");
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else {
				JOptionPane.showMessageDialog(null, error.toString(),"Lỗi",JOptionPane.ERROR_MESSAGE);
			}
		}
	};

	public void loadData() {
		listStudent.removeAll(listStudent);
		try {
			listStudent = StudentDao.loadData();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void loadData2() {
		listGrade.removeAll(listGrade);
		try {
			listGrade = GradeDao.loadGrade();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void loadTable() {
		model1.setRowCount(0);
		listStudent.forEach((ST) -> {
			model1.addRow(new Object[] { ST.maSV, ST.hoTen, ST.email, ST.soDT, ST.gioiTinh, ST.diaChi });
		});
		table.setModel(model1);
	}
	
	public void loadTable2() {
		model2.setRowCount(0);
		ArrayList<StudentGrade> listTop = new ArrayList<>();
		listTop = listGrade;
		Collections.sort(listTop, (o1, o2) -> {
			return o1.getDTB() < o2.getDTB() ? 1 : -1;
		});
		for(int i=0;i<3;i++) {
			model2.addRow(new Object[] { listTop.get(i).maSV, listStudent.get(getHoTen(listTop.get(i).maSV)).hoTen, listTop.get(i).tiengAnh, listTop.get(i).tinHoc, listTop.get(i).GDTC, fm.format(listTop.get(i).getDTB())});
		}
		table_1.setModel(model2);
	}
	
	public int getHoTen(String maSV) {
		int i = 0;
		for (; i < listStudent.size(); i++) {
			if(listStudent.get(i).maSV.equalsIgnoreCase(maSV)) {
				return i;
			}
		}
		return i;
	}

	public void display(int i) {
		textMaSV.setText(listStudent.get(i).maSV);
		textHoTen.setText(listStudent.get(i).hoTen);
		textEmail.setText(listStudent.get(i).email);
		textSoDT.setText(listStudent.get(i).soDT);
		textDiaChi.setText(listStudent.get(i).diaChi);
		if (listStudent.get(i).gioiTinh.equals("Nam")) {
			rdbtnNam.setSelected(true);
		} else
			rdbtnNu.setSelected(true);
		Image icon;
		try {
			icon = ImageEdit.getImage(listStudent.get(i).hinh, "img");
			ImageIcon imageIcon = new ImageIcon(icon);
			lblAvatar.setIcon(imageIcon);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			lblAvatar.setIcon(null);
		}
		imageByte = listStudent.get(i).hinh;
		table.setRowSelectionInterval(i, i);
	}
	
	public void display2(int i) {
		textHoTen2.setText(listStudent.get(getHoTen(listGrade.get(i).maSV)).hoTen);
		textMaSV2.setText(listGrade.get(i).maSV);
		textTiengAnh.setText(String.valueOf(listGrade.get(i).tiengAnh));
		textTinHoc.setText(String.valueOf(listGrade.get(i).tinHoc));
		textGDTC.setText(String.valueOf(listGrade.get(i).GDTC));
		lblDiemTB.setText(fm.format(listGrade.get(i).getDTB()));
	}

	ActionListener logout = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			int comfirm = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn đăng xuất?");
			if (comfirm == 0) {
				frame.setVisible(false);
				Login.frame.setVisible(true);
			}
		}
	};

	ActionListener update = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			int r = table.getSelectedRow();
			StringBuilder error = new StringBuilder();
			String maSV = textMaSV.getText();
			String hoTen = textHoTen.getText();
			String email = textEmail.getText();
			String soDT = textSoDT.getText();
			String gioiTinh = rdbtnNam.isSelected() == true ? "Nam" : "Nữ";
			String diaChi = textDiaChi.getText();

			error.append(ValidateStudent.checkMaUpdate(maSV, r, listStudent.size()));
			error.append(ValidateStudent.checkTen(hoTen));
			error.append(ValidateStudent.checkEmail(email));
			error.append(ValidateStudent.checkSoDT(soDT));
			error.append(ValidateStudent.checkDiaChi(diaChi));
			if (!error.toString().isBlank()) {
				JOptionPane.showMessageDialog(null, error, "Lỗi", JOptionPane.ERROR_MESSAGE);
			} else {
				try {
					String maSV1 = listStudent.get(r).maSV;
					StudentDao.update(maSV, hoTen, email, soDT, gioiTinh, diaChi, imageByte, maSV1);
					loadData();
					loadTable();
					display(0);
					JOptionPane.showMessageDialog(null, "Update thành công!");
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	};

	public void login() {
		if (Login.vaiTro.equals("Giảng viên")) {
			tabbedPane.addTab("Quản lý điểm", null, panelQLD, null);
			loadData();
			loadData2();
			loadTable2();
			display2(0);
		} else if (Login.vaiTro.equals("Cán bộ đào tạo")) {
			tabbedPane.addTab("Quản lý sinh viên", new ImageIcon("Qu\u1EA3n l\u00FD sinh vi\u00EAn"), panelQLSV, null);
			loadData();
			loadTable();
			display(0);
		}
	}

	public void table2() {
		model2.addColumn("Mã SV");
		model2.addColumn("Họ tên");
		model2.addColumn("Tiếng anh");
		model2.addColumn("Tin học");
		model2.addColumn("GDTC");
		model2.addColumn("Điểm TB");
		table_1.setModel(model2);
	}

	public void table() {
		model1.addColumn("Mã SV");
		model1.addColumn("Họ tên");
		model1.addColumn("Email");
		model1.addColumn("Số ĐT");
		model1.addColumn("Giới tính");
		model1.addColumn("Địa chỉ");
		table.setModel(model1);
	}
	
	public void first() {
		current = 0;
		display2(current);
	}

	public void last() {
		current = listGrade.size() - 1;
		display2(current);
	}

	public void next() {
		current += 1;
		if (current == listGrade.size()) {
			current = 0;
		}
		display2(current);
	}

	public void previous() {
		current -= 1;
		if (current == -1) {
			current = listGrade.size() - 1;
		}
		display2(current);
	}
}
