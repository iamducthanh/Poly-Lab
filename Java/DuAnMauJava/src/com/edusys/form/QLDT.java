package com.edusys.form;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.edusys.helper.Clock;
import javax.swing.JDesktopPane;
import java.awt.CardLayout;

@SuppressWarnings("serial")
public class QLDT extends JFrame {

	private JPanel contentPane;
	static int vaiTro;
	static String user;
	JDesktopPane desktopPane = new JDesktopPane();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QLDT frame = new QLDT();
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
	@SuppressWarnings("deprecation")
	public QLDT() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\udpm\\Image\\fpt.png"));
		setTitle("HỆ THỐNG QUẢN LÝ ĐÀO TẠO");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 759, 514);
		setExtendedState(JFrame.MAXIMIZED_BOTH);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		setFocusable(true);
		panel.setLayout(new BorderLayout(0, 0));

//		JPanel panel = new JPanel();
//		panel.setBounds(0, 453, 745, 24);
//		panel.setBackground(new Color(169, 169, 169));
//		contentPane.add(panel);
//		panel.setLayout(null);
//		
		JLabel lblNewLabel = new JLabel("Hệ thống quản lý đào tạo");
		lblNewLabel.setIcon(new ImageIcon("C:\\udpm\\Image\\Info.png"));
		lblNewLabel.setBackground(new Color(211, 211, 211));
		lblNewLabel.setBounds(10, 0, 236, 24);
		panel.add(lblNewLabel, BorderLayout.WEST);

		JLabel lblClock = new JLabel("New label");
		lblClock.setIcon(new ImageIcon("C:\\udpm\\Image\\Alarm.png"));
		lblClock.setBounds(640, 0, 95, 24);
		panel.add(lblClock, BorderLayout.EAST);
		Clock clock = new Clock(lblClock);
		clock.start();

		JToolBar toolBar = new JToolBar();
		contentPane.add(toolBar, BorderLayout.NORTH);
		toolBar.setMargin(new Insets(5, 0, 0, 0));

		JButton btnDangXuat = new JButton("  Đăng xuất  ");
		btnDangXuat.setIcon(new ImageIcon("C:\\udpm\\Image\\exit.png"));
		toolBar.add(btnDangXuat);
		btnDangXuat.setHorizontalTextPosition(SwingConstants.CENTER);
		btnDangXuat.setMargin(new java.awt.Insets(2, 10, 2, 10));
		btnDangXuat.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		btnDangXuat.setContentAreaFilled(false);
		btnDangXuat.setBorder(null);

		JButton btnKetThuc = new JButton("  Kết thúc  ");
		btnKetThuc.setIcon(new ImageIcon("C:\\udpm\\Image\\Stop.png"));
		toolBar.add(btnKetThuc);
		btnKetThuc.setHorizontalTextPosition(SwingConstants.CENTER);
		btnKetThuc.setMargin(new java.awt.Insets(2, 10, 2, 10));
		btnKetThuc.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		btnKetThuc.setContentAreaFilled(false);
		btnKetThuc.setBorder(null);

		JButton btnChuyenDe = new JButton("  Chuyên đề  ");
		btnChuyenDe.setIcon(new ImageIcon("C:\\udpm\\Image\\Lists.png"));
		toolBar.add(btnChuyenDe);
		btnChuyenDe.setHorizontalTextPosition(SwingConstants.CENTER);
		btnChuyenDe.setMargin(new java.awt.Insets(2, 10, 2, 10));
		btnChuyenDe.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		btnChuyenDe.setContentAreaFilled(false);
		btnChuyenDe.setBorder(null);

		JButton btnNguoiHoc = new JButton("  Người học  ");
		btnNguoiHoc.setIcon(new ImageIcon("C:\\udpm\\Image\\Conference.png"));
		toolBar.add(btnNguoiHoc);
		btnNguoiHoc.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNguoiHoc.setMargin(new java.awt.Insets(2, 10, 2, 10));
		btnNguoiHoc.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		btnNguoiHoc.setContentAreaFilled(false);
		btnNguoiHoc.setBorder(null);

		JButton btnKhoaHoc = new JButton("  Khóa học  ");
		btnKhoaHoc.setIcon(new ImageIcon("C:\\udpm\\Image\\Certificate.png"));
		toolBar.add(btnKhoaHoc);
		btnKhoaHoc.setHorizontalTextPosition(SwingConstants.CENTER);
		btnKhoaHoc.setMargin(new java.awt.Insets(2, 10, 2, 10));
		btnKhoaHoc.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		btnKhoaHoc.setContentAreaFilled(false);
		btnKhoaHoc.setBorder(null);

		JButton btnHocVien = new JButton("  Học viên  ");
		btnHocVien.setIcon(new ImageIcon("C:\\udpm\\Image\\User.png"));
		toolBar.add(btnHocVien);
		btnHocVien.setHorizontalTextPosition(SwingConstants.CENTER);
		btnHocVien.setMargin(new java.awt.Insets(2, 10, 2, 10));
		btnHocVien.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		btnHocVien.setContentAreaFilled(false);
		btnHocVien.setBorder(null);

		JButton btnHuongDan = new JButton("  Hướng dẫn  ");
		btnHuongDan.setIcon(new ImageIcon("C:\\udpm\\Image\\Globe.png"));
		toolBar.add(btnHuongDan);
		btnHuongDan.setHorizontalTextPosition(SwingConstants.CENTER);
		btnHuongDan.setMargin(new java.awt.Insets(2, 10, 2, 10));
		btnHuongDan.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
		btnHuongDan.setContentAreaFilled(false);
		btnHuongDan.setBorder(null);

		contentPane.add(desktopPane, BorderLayout.CENTER);
		desktopPane.setLayout(new CardLayout(0, 0));

//        JLabel lblNewLabel_1 = new JLabel("", SwingConstants.CENTER);
//        lblNewLabel_1.setIcon(new ImageIcon("C:\\udpm\\Image\\ong.png"));
//        contentPane.add(lblNewLabel_1, BorderLayout.CENTER);

		JMenu mnNewMenu = new JMenu("Hệ thống");
		menuBar.add(mnNewMenu);

		JMenuItem mntmDoiMK = new JMenuItem("Đổi mật khẩu");
		mntmDoiMK.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mntmDoiMK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChangePassword();
			}
		});
		mntmDoiMK.setIcon(new ImageIcon("C:\\udpm\\Image\\Refresh.png"));
		mnNewMenu.add(mntmDoiMK);

		JMenuItem mntmDangXuat = new JMenuItem("Đăng xuất");
		mntmDangXuat.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mntmDangXuat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dangXuat();
			}
		});
		mntmDangXuat.setIcon(new ImageIcon("C:\\udpm\\Image\\Log out.png"));
		mntmDangXuat.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
		mnNewMenu.add(mntmDangXuat);

		JMenuItem mntmThoat = new JMenuItem("Thoát");
		mntmThoat.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mntmThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mntmThoat.setIcon(new ImageIcon("C:\\udpm\\Image\\Stop.png"));
		mntmThoat.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F10, 0));
		mnNewMenu.add(mntmThoat);

		JMenu mnNewMenu_1 = new JMenu("Quản lý");
		menuBar.add(mnNewMenu_1);

		JMenuItem mntmChuyenDe = new JMenuItem("Chuyển đề");
		mntmChuyenDe.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mntmChuyenDe.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, InputEvent.CTRL_MASK));
		mntmChuyenDe.setIcon(new ImageIcon("C:\\udpm\\Image\\Lists.png"));
		mnNewMenu_1.add(mntmChuyenDe);

		JMenuItem mntmKhoaHoc = new JMenuItem("Khóa học");
		mntmKhoaHoc.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mntmKhoaHoc.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2, InputEvent.CTRL_MASK));
		mntmKhoaHoc.setIcon(new ImageIcon("C:\\udpm\\Image\\Certificate.png"));
		mnNewMenu_1.add(mntmKhoaHoc);

		JMenuItem mntmNguoiHoc = new JMenuItem("Người học");
		mntmNguoiHoc.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mntmNguoiHoc.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3, InputEvent.CTRL_MASK));
		mntmNguoiHoc.setIcon(new ImageIcon("C:\\udpm\\Image\\Conference.png"));
		mnNewMenu_1.add(mntmNguoiHoc);

		JMenuItem mntmHocVien = new JMenuItem("Học viên");
		mntmHocVien.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mntmHocVien.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.CTRL_MASK));
		mntmHocVien.setIcon(new ImageIcon("C:\\udpm\\Image\\User.png"));
		mnNewMenu_1.add(mntmHocVien);

		JSeparator separator = new JSeparator();
		mnNewMenu_1.add(separator);

		JMenuItem mntmNhanVien = new JMenuItem("Nhân viên");
		mntmNhanVien.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mntmNhanVien.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5, InputEvent.CTRL_MASK));
		mntmNhanVien.setIcon(new ImageIcon("C:\\udpm\\Image\\User group.png"));
		mnNewMenu_1.add(mntmNhanVien);

		JMenu mnNewMe = new JMenu("Thống kê");
		menuBar.add(mnNewMe);

		JMenuItem mntmBangDiem = new JMenuItem("Bảng điểm");
		mntmBangDiem.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mntmBangDiem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, InputEvent.SHIFT_MASK));
		mntmBangDiem.setIcon(new ImageIcon("C:\\udpm\\Image\\Card file.png"));
		mnNewMe.add(mntmBangDiem);

		JSeparator separator_1 = new JSeparator();
		mnNewMe.add(separator_1);

		JMenuItem mntmSLNguoiHoc = new JMenuItem("Lượng người học");
		mntmSLNguoiHoc.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mntmSLNguoiHoc.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2, InputEvent.SHIFT_MASK));
		mntmSLNguoiHoc.setIcon(new ImageIcon("C:\\udpm\\Image\\sinhvien.png"));
		mnNewMe.add(mntmSLNguoiHoc);

		JMenuItem mntmDiemChuyenDe = new JMenuItem("Điểm chuyên đề");
		mntmDiemChuyenDe.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mntmDiemChuyenDe.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3, InputEvent.SHIFT_MASK));
		mntmDiemChuyenDe.setIcon(new ImageIcon("C:\\udpm\\Image\\diemchuyende.png"));
		mnNewMe.add(mntmDiemChuyenDe);

		JMenuItem mntmDoanhThu = new JMenuItem("Doanh thu");
		mntmDoanhThu.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mntmDoanhThu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.SHIFT_MASK));
		mntmDoanhThu.setIcon(new ImageIcon("C:\\udpm\\Image\\doanhthu.png"));
		mnNewMe.add(mntmDoanhThu);

		JMenu mnNewMenu_3 = new JMenu("Trợ giúp");
		menuBar.add(mnNewMenu_3);

		JMenuItem mntmNewMenuItem_12 = new JMenuItem("Hướng dẫn sử dụng");
		mntmNewMenuItem_12.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mntmNewMenuItem_12.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		mntmNewMenuItem_12.setIcon(new ImageIcon("C:\\udpm\\Image\\hdsd.png"));
		mnNewMenu_3.add(mntmNewMenuItem_12);

		JSeparator separator_2 = new JSeparator();
		mnNewMenu_3.add(separator_2);

		JMenuItem mntmNewMenuItem_13 = new JMenuItem("Giới thiệu sản phẩm");
		mntmNewMenuItem_13.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mntmNewMenuItem_13.setIcon(new ImageIcon("C:\\udpm\\Image\\Info.png"));
		mnNewMenu_3.add(mntmNewMenuItem_13);

		btnDangXuat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dangXuat();
			}
		});

		btnKetThuc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		btnChuyenDe.addActionListener(openChuyenDe);
		btnNguoiHoc.addActionListener(openNguoiHoc);
		btnKhoaHoc.addActionListener(openKhoaHoc);
		btnHocVien.addActionListener(openHocVien);
		mntmKhoaHoc.addActionListener(openKhoaHoc);
		mntmChuyenDe.addActionListener(openChuyenDe);
		mntmHocVien.addActionListener(openHocVien);
		mntmNguoiHoc.addActionListener(openNguoiHoc);
		mntmBangDiem.addActionListener(openBangDiem);
		mntmSLNguoiHoc.addActionListener(luongNguoiHoc);
		mntmDiemChuyenDe.addActionListener(diemChuyenDe);
		mntmDoanhThu.addActionListener(doanhThu);
		mntmNhanVien.addActionListener(openNhanVien);

	}

	public void ChangePassword() {
		ChangePassword changePassword = new ChangePassword();
		changePassword.setVisible(true);
		changePassword.setLocationRelativeTo(null);
		changePassword.getUser(user);
	}

	public void dangXuat() {
		Login login = new Login();
		login.setVisible(true);
		login.setLocationRelativeTo(null);
		QLDT.this.dispose();
	}

	public void close() {
		try {
			desktopPane.getAllFrames()[0].setVisible(false);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	ActionListener openNhanVien = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (vaiTro == 1) {
				QuanLyNhanVien nhanVien = new QuanLyNhanVien();
				close();
				desktopPane.add(nhanVien);
				nhanVien.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(null, "Bạn không có quyền truy cập mục này!");
			}
		}
	};

	ActionListener openKhoaHoc = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			QuanLyKhoaHoc khoaHoc = new QuanLyKhoaHoc();
			if (vaiTro != 1) {
				khoaHoc.btnXoa.setEnabled(false);
			}
			close();
			desktopPane.add(khoaHoc);
			khoaHoc.setVisible(true);
		}
	};

	ActionListener openChuyenDe = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			QuanLyChuyenDe chuyenDe = new QuanLyChuyenDe();
			if (vaiTro != 1) {
				chuyenDe.btnXoa.setEnabled(false);
			}
			close();
			desktopPane.add(chuyenDe);
			chuyenDe.setVisible(true);
		}
	};

	ActionListener openHocVien = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			QuanLyHocVien hocVien = new QuanLyHocVien();
			if (vaiTro != 1) {
				hocVien.btnXoa.setEnabled(false);
			}
			close();
			desktopPane.add(hocVien);
			hocVien.setVisible(true);
		}
	};

	ActionListener openNguoiHoc = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			QuanLyNguoiHoc nguoiHoc = new QuanLyNguoiHoc();
			if (vaiTro != 1) {
				nguoiHoc.btnXoa.setEnabled(false);
			}
			close();
			desktopPane.add(nguoiHoc);
			nguoiHoc.setVisible(true);
		}
	};

	ActionListener openBangDiem = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			ThongKe thongKe = new ThongKe();
			close();
			desktopPane.add(thongKe);
			thongKe.setVisible(true);

		}
	};

	ActionListener luongNguoiHoc = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			ThongKe thongKe = new ThongKe();
			close();
			desktopPane.add(thongKe);
			thongKe.setVisible(true);
			thongKe.tabbedPane.setSelectedIndex(1);
		}
	};

	ActionListener diemChuyenDe = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			ThongKe thongKe = new ThongKe();
			close();
			desktopPane.add(thongKe);
			thongKe.setVisible(true);
			thongKe.tabbedPane.setSelectedIndex(2);
		}
	};

	ActionListener doanhThu = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (vaiTro == 1) {
				ThongKe thongKe = new ThongKe();
				close();
				desktopPane.add(thongKe);
				thongKe.setVisible(true);
				thongKe.tabbedPane.setSelectedIndex(3);
			} else {
				JOptionPane.showMessageDialog(null, "Bạn không có quyền truy cập mục này!");
			}
		}
	};

	public void getVaiTro(int i, String user) {
		QLDT.vaiTro = i;
		QLDT.user = user;
	}
}
