package form;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import File.Xflie;
import dao.SanPhamDao;
import entities.SanPham;
import help.DataBaseConnect;
import help.Text;
import help.Validate;

@SuppressWarnings("serial")
public class QLKH extends JFrame {

    private JPanel contentPane;
    private JTextField textHanSuDung;
    private JTextField textMaSP;
    private JTextField textTen;
    private JTextField textGia;
    private JTextField textSoLuong;
    private JTable table;
    DefaultTableModel model = new DefaultTableModel();
    public static List<SanPham> list = SanPhamDao.loadUser();
    SanPham SP = new SanPham();
    StringBuilder error = new StringBuilder();
    String path = "C:\\QLKH\\File\\File.txt";
    ArrayList<String> listFile = new ArrayList();
    static StringBuilder LichSu = new StringBuilder();
    static QLKH frame = new QLKH();

    ;

	/**
	 * Launch the application.
	 */
	public void mainFrame() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame.setTitle("CHI TIẾT KH�?CH KHO HÀNG");
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
    JButton btnMoi = new JButton("  Mới     ");
    JButton btnAdd = new JButton(" Thêm   ");
    JButton btnUpdate = new JButton("  Sửa     ");
    JButton btnDelete = new JButton("  Xóa      ");
    JButton btnHistory = new JButton(" Lịch sử");
    JButton btnOpen = new JButton(" Mở       ");
    JButton btnFind = new JButton(" Tìm       ");
    JButton btnExit = new JButton(" Đăng Xuất");

    MouseListener hover = new MouseListener() {

        @Override
        public void mouseExited(MouseEvent e) {
            // TODO Auto-generated method stub
            JButton btnHover = (JButton) e.getComponent();
            int x = btnHover.getX();
            int y = btnHover.getY();
            int width = btnHover.getWidth();
            int height = btnHover.getHeight();
            btnHover.setBounds(x + 3, y + 3, width - 6, height - 6);
            btnHover.setBorder(new LineBorder(new Color(64, 64, 64), 1));
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            // TODO Auto-generated method stub
            JButton btnHover = (JButton) e.getComponent();
            int x = btnHover.getX();
            int y = btnHover.getY();
            int width = btnHover.getWidth();
            int height = btnHover.getHeight();
            btnHover.setBounds(x - 3, y - 3, width + 6, height + 6);
            btnHover.setBorder(new LineBorder(new Color(64, 64, 64), 2));
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void mousePressed(MouseEvent e) {
            // TODO Auto-generated method stub

        }

        @Override
        public void mouseReleased(MouseEvent e) {
            // TODO Auto-generated method stub

        }

    };

    public QLKH() {
        setBackground(SystemColor.activeCaptionBorder);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 692, 560);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblQLKH = new JLabel("CHI TIẾT KHO HÀNG");
        lblQLKH.setForeground(Color.BLUE);
        lblQLKH.setFont(new Font("Tahoma", Font.BOLD, 19));
        lblQLKH.setBounds(100, 24, 477, 40);
        contentPane.add(lblQLKH);

        Text text = new Text(lblQLKH);

        JLabel lblTTCT = new JLabel("Thông tin chi tiết");
        lblTTCT.setFont(new Font("Tahoma", Font.BOLD, 17));
        lblTTCT.setBounds(10, 87, 272, 19);
        contentPane.add(lblTTCT);

        JLabel lblMaSP = new JLabel("Mã sản phẩm");
        lblMaSP.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblMaSP.setBounds(24, 121, 100, 19);
        contentPane.add(lblMaSP);

        JLabel lblTen = new JLabel("Tên");
        lblTen.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblTen.setBounds(24, 159, 100, 19);
        contentPane.add(lblTen);

        JLabel lblGia = new JLabel("Giá");
        lblGia.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblGia.setBounds(24, 197, 100, 19);
        contentPane.add(lblGia);

        JLabel lblSoLuong = new JLabel("Số lượng");
        lblSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblSoLuong.setBounds(24, 235, 100, 19);
        contentPane.add(lblSoLuong);

        JLabel lblHanSuDung = new JLabel("Hạn sử dụng");
        lblHanSuDung.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblHanSuDung.setBounds(24, 273, 100, 19);
        contentPane.add(lblHanSuDung);

        textHanSuDung = new JTextField();
        textHanSuDung.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textHanSuDung.setBounds(147, 269, 292, 27);
        contentPane.add(textHanSuDung);
        textHanSuDung.setColumns(10);

        textMaSP = new JTextField();
        textMaSP.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textMaSP.setColumns(10);
        textMaSP.setBounds(147, 117, 292, 27);
        contentPane.add(textMaSP);

        textTen = new JTextField();
        textTen.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textTen.setColumns(10);
        textTen.setBounds(147, 155, 292, 27);
        contentPane.add(textTen);

        textGia = new JTextField();
        textGia.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textGia.setColumns(10);
        textGia.setBounds(147, 193, 292, 27);
        contentPane.add(textGia);

        textSoLuong = new JTextField();
        textSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 15));
        textSoLuong.setColumns(10);
        textSoLuong.setBounds(147, 231, 292, 27);
        contentPane.add(textSoLuong);
        text.start();
        btnMoi.setEnabled(false);

        btnMoi.setForeground(Color.BLACK);

        btnMoi.setBackground(SystemColor.activeCaptionBorder);
        btnMoi.setBounds(468, 121, 89, 23);
        contentPane.add(btnMoi);

        JScrollPane scrollPaneFormTable = new JScrollPane();
        scrollPaneFormTable.setBounds(10, 350, 658, 157);
        scrollPaneFormTable.setBackground(new Color(0, 0, 0, 0));
        contentPane.add(scrollPaneFormTable);

        table = new JTable();
        scrollPaneFormTable.setViewportView(table);
        btnAdd.setEnabled(false);
        btnAdd.setForeground(Color.BLACK);

        btnAdd.setBackground(SystemColor.activeCaptionBorder);
        btnAdd.setBounds(468, 159, 89, 23);
        contentPane.add(btnAdd);
        btnUpdate.setEnabled(false);
        btnUpdate.setForeground(Color.BLACK);

        btnUpdate.setBackground(SystemColor.activeCaptionBorder);
        btnUpdate.setBounds(468, 197, 89, 23);
        contentPane.add(btnUpdate);
        btnDelete.setEnabled(false);
        btnDelete.setForeground(Color.BLACK);

        btnDelete.setBackground(SystemColor.activeCaptionBorder);
        btnDelete.setBounds(468, 235, 89, 23);
        contentPane.add(btnDelete);
        btnHistory.setEnabled(false);
        btnHistory.setForeground(Color.BLACK);

        btnHistory.setBackground(SystemColor.activeCaptionBorder);
        btnHistory.setBounds(567, 197, 89, 23);
        contentPane.add(btnHistory);

        JLabel lblDanhSch = new JLabel("Danh sách");
        lblDanhSch.setFont(new Font("Tahoma", Font.BOLD, 17));
        lblDanhSch.setBounds(10, 320, 272, 19);
        contentPane.add(lblDanhSch);

        btnMoi.setBorder(new LineBorder(new Color(64, 64, 64), 1));
        btnAdd.setBorder(new LineBorder(Color.DARK_GRAY));
        btnDelete.setBorder(new LineBorder(Color.DARK_GRAY));
        btnHistory.setBorder(new LineBorder(new Color(64, 64, 64)));
        btnUpdate.setBorder(new LineBorder(Color.DARK_GRAY));

        btnMoi.setContentAreaFilled(false);
        btnHistory.setContentAreaFilled(false);
        btnDelete.setContentAreaFilled(false);
        btnUpdate.setContentAreaFilled(false);
        btnAdd.setContentAreaFilled(false);

        textGia.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        textHanSuDung.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        textMaSP.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        textSoLuong.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        textTen.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
        btnOpen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                moForm();
                filltable();
            }
        });
        btnOpen.setForeground(Color.BLACK);

        btnOpen.setIcon(new ImageIcon("C:\\QLKH\\Image\\open.png"));
        btnOpen.setContentAreaFilled(false);
        btnOpen.setBorder(new LineBorder(new Color(64, 64, 64)));
        btnOpen.setBackground(SystemColor.activeCaptionBorder);
        btnOpen.setBounds(567, 121, 89, 23);
        contentPane.add(btnOpen);
        btnFind.setEnabled(false);
        btnFind.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                find();
            }
        });

        btnFind.setIcon(new ImageIcon("C:\\QLKH\\Image\\find.png"));
        btnFind.setForeground(Color.BLACK);
        btnFind.setContentAreaFilled(false);
        btnFind.setBorder(new LineBorder(new Color(64, 64, 64)));
        btnFind.setBackground(SystemColor.activeCaptionBorder);
        btnFind.setBounds(567, 159, 89, 23);
        contentPane.add(btnFind);
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                logout();
            }
        });
        btnExit.setForeground(Color.BLACK);

        btnExit.setIcon(new ImageIcon("C:\\QLKH\\Image\\exit.png"));
        btnExit.setContentAreaFilled(false);
        btnExit.setBorder(new LineBorder(new Color(64, 64, 64)));
        btnExit.setBackground(SystemColor.activeCaptionBorder);
        btnExit.setBounds(567, 235, 89, 23);
        contentPane.add(btnExit);

        // action
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                error.setLength(0);
                error.append(Validate.checkMa(textMaSP.getText()));
                error.append(Validate.checkTen(textTen.getText()));
                error.append(Validate.checkGia(textGia.getText()));
                error.append(Validate.checkSL(textSoLuong.getText()));
                error.append(Validate.checkHSD(textHanSuDung.getText()));

                if (error.length() == 0) {
                    try {
                        SanPhamDao.saveDB(textMaSP.getText(), textTen.getText(), textGia.getText(), textSoLuong.getText(),
                                textHanSuDung.getText());
                        loadList();
                        filltable();
                    } catch (ClassNotFoundException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    } catch (SQLException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }

                } else {
                    JOptionPane.showMessageDialog(null, error.toString(), "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnMoi.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textGia.setText("");
                textHanSuDung.setText("");
                textMaSP.setText("");
                textSoLuong.setText("");
                textTen.setText("");
                textMaSP.setEditable(true);
                textHanSuDung.setEditable(true);
                btnAdd.setEnabled(true);
                if (Login.vaiTro.equals("kho")) {
                    btnDelete.setEnabled(false);
                    btnUpdate.setEnabled(false);
                }
            }
        });

        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Update();
            }
        });

        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                delete();
            }
        });

        btnHistory.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                load();
                History history = new History();
                history.mainHistory();
            }
        });

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int r = table.getSelectedRow();
                display(r);
                if (Login.vaiTro.equals("kho")) {
                    btnDelete.setEnabled(true);
                    btnUpdate.setEnabled(true);
                }
                btnAdd.setEnabled(false);
                textMaSP.setEditable(false);
                textHanSuDung.setEditable(false);
            }
        });

        JComboBox comboBox = new JComboBox();
        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (comboBox.getSelectedIndex() == 0) {
                    sapXepSoLuong();
                } else {
                    sortbyDate();
                }
            }
        });
        comboBox.setModel(new DefaultComboBoxModel(new String[]{"Số lượng", "Hạn sử dụng"}));
        comboBox.setBounds(231, 317, 138, 22);
        contentPane.add(comboBox);

        JLabel lblSpXpTheo = new JLabel("Sắp xếp theo:");
        lblSpXpTheo.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblSpXpTheo.setBounds(121, 320, 100, 19);
        contentPane.add(lblSpXpTheo);
        table();
        image();
        hover();
    }

    public void moForm() {
        if (Login.vaiTro.equals("kho")) {
            btnAdd.setEnabled(true);
            btnDelete.setEnabled(true);
            btnMoi.setEnabled(true);
            btnUpdate.setEnabled(true);
            btnFind.setEnabled(true);
            btnHistory.setEnabled(true);
        } else if (Login.vaiTro.equals("kinh doanh")) {
            btnFind.setEnabled(true);
            btnHistory.setEnabled(true);
        }
    }

    public void load() {
        try {
            listFile.removeAll(listFile);
            LichSu.setLength(0);
            ArrayList<String> listFile = (ArrayList<String>) Xflie.readObject(path);
            for (int i = 0; i < listFile.size(); i++) {
                LichSu.append(listFile.get(i));
            }
            System.out.println(LichSu.toString() + "\n");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            LichSu.append("");
            try {
                Xflie.writeObject(path, listFile);
            } catch (FileNotFoundException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
    }

    protected void delete() {
        try {
            error.setLength(0);
            error.append(Validate.checkGia(textGia.getText()));
            error.append(Validate.checkSL(textSoLuong.getText()));
            if (error.length() > 0) {
                JOptionPane.showMessageDialog(null, error.toString());
                return;
            }
            int check = JOptionPane.showConfirmDialog(null, "Bạn Có Chắc Chắn Muốn xóa Không", "Thông Báo",
                    JOptionPane.YES_NO_OPTION);
            if (check == JOptionPane.YES_OPTION) {
                Connection con = DataBaseConnect.Connect();
                String sql = "delete sanpham where masp=? and hsd=?";
                PreparedStatement pt = con.prepareStatement(sql);
                pt.setString(1, textMaSP.getText());
                pt.setString(2, textHanSuDung.getText());
                boolean a = pt.execute();
                if (a == true) {
                    JOptionPane.showMessageDialog(null, "Delete Thành Công");
                } else {
                    JOptionPane.showMessageDialog(null, "Delete không Thành Công");
                }
                loadList();
                filltable();
            }
        } catch (Exception e) {

        }

    }

    public void login() {
        if (Login.vaiTro.equals("kho")) {
            btnAdd.setEnabled(true);
            btnDelete.setEnabled(true);
            btnMoi.setEnabled(true);
            btnUpdate.setEnabled(true);
        } else if (Login.vaiTro.equals("kinh doanh")) {
            btnAdd.setEnabled(false);
            btnDelete.setEnabled(false);
            btnMoi.setEnabled(false);
            btnUpdate.setEnabled(false);
        }
    }

    public void display(int i) {
        textMaSP.setText(list.get(i).getMasp());
        textGia.setText(String.valueOf(list.get(i).getGia()));
        textHanSuDung.setText(list.get(i).getHsd());
        textSoLuong.setText(String.valueOf(list.get(i).getSoLuong()));
        textTen.setText(list.get(i).getTen());
        table.setRowSelectionInterval(i, i);
    }

    boolean find = false;

    public void find() {
        find = false;
        String masp = JOptionPane.showInputDialog(null, "Mời Bạn Nhập Mã sảm phẩm");

        if (masp != null) {
            model.setRowCount(0);
            for (SanPham x : list) {
                if (masp.equalsIgnoreCase(x.getMasp())) {
                    model.addRow(new Object[]{x.getMasp(), x.getTen(), x.getGia(), x.getSoLuong(), x.getHsd(),
                        x.getTrangThai()});
                    find = true;
                }
            }
            if (find == true) {
                JOptionPane.showMessageDialog(null, "Đã tìm thấy!");
            } else {
                JOptionPane.showMessageDialog(null, "Không tìm thấy!");
            }
            display(0);
        }
    }

    public void table() {
        JTableHeader header = table.getTableHeader();
        header.setBackground(new Color(179, 115, 52, 200));
        model.addColumn("Mã sản phẩm");
        model.addColumn("Tên");
        model.addColumn("Giá");
        model.addColumn("Số lượng");
        model.addColumn("Hạn sử dụng");
        model.addColumn("Trạng thái");
        table.setModel(model);
    }

    public void loadList() {
        list.removeAll(list);
        list = SanPhamDao.loadUser();
    }

    public void filltable() {
        model.setRowCount(0);
        for (SanPham sp : list) {
            model.addRow(new Object[]{sp.getMasp(), sp.getTen(), sp.getGia(), sp.getSoLuong(), sp.getHsd(),
                sp.getTrangThai()});
        }
        btnAdd.setEnabled(false);
        textMaSP.setEditable(false);
        textHanSuDung.setEditable(false);
        if (Login.vaiTro.equals("kho")) {
            btnDelete.setEnabled(true);
            btnUpdate.setEnabled(true);
        }
        display(0);
    }

    public void image() {
        btnMoi.setIcon(new ImageIcon("C:\\QLKH\\Image\\clear.png"));
        btnHistory.setIcon(new ImageIcon("C:\\QLKH\\Image\\history.png"));
        btnAdd.setIcon(new ImageIcon("C:\\QLKH\\Image\\luu.png"));
        btnUpdate.setIcon(new ImageIcon("C:\\QLKH\\Image\\update.png"));
        btnDelete.setIcon(new ImageIcon("C:\\QLKH\\Image\\delete.png"));
        JLabel bkg = new JLabel();
        bkg.setIcon(new ImageIcon("C:\\QLKH\\Image\\background.jpg"));
        bkg.setBounds(0, 0, 678, 523);
        contentPane.add(bkg);
    }

    public void hover() {
        btnAdd.addMouseListener(hover);
        btnDelete.addMouseListener(hover);
        btnHistory.addMouseListener(hover);
        btnMoi.addMouseListener(hover);
        btnUpdate.addMouseListener(hover);
        btnExit.addMouseListener(hover);
        btnOpen.addMouseListener(hover);
        btnFind.addMouseListener(hover);
    }

    protected void Update() {
        String ma = textMaSP.getText();
        String hsd = textHanSuDung.getText();
        try {
            error.setLength(0);
            error.append(Validate.checkGia(textGia.getText()));
            error.append(Validate.checkSL(textSoLuong.getText()));
            if (error.toString().length() > 0) {
                JOptionPane.showMessageDialog(null, error.toString());
                return;
            }
            int soluongCu = 0;
            int soluongmoi = Integer.parseInt(textSoLuong.getText());
            for (SanPham x : list) {
                if (x.getMasp().equalsIgnoreCase(ma) && x.getHsd().equalsIgnoreCase(hsd)) {
                    soluongCu = x.getSoLuong();
                }
            }
            Connection con = DataBaseConnect.Connect();
            String sql = "update sanpham set soluong =? , gia=? where masp=? and hsd=?";
            PreparedStatement pt = con.prepareStatement(sql);
            pt.setString(1, textSoLuong.getText());
            pt.setString(2, textGia.getText());
            pt.setString(3, textMaSP.getText());
            pt.setString(4, textHanSuDung.getText());
            int a = pt.executeUpdate();
            if (a != 1) {
                JOptionPane.showMessageDialog(null, "Update Thành Công");
            } else {
                if ((soluongmoi - soluongCu) != 0) {
                    try {
                        listFile.removeAll(listFile);
                        LichSu.setLength(0);
                        listFile = (ArrayList<String>) Xflie.readObject(path);
                        Date now = new Date();
                        String string = "\n" + textTen.getText() + " Đã Thay Đổi " + (soluongmoi - soluongCu) + " Vào "
                                + now;
                        listFile.add(string);
                        for (int i = 0; i < listFile.size(); i++) {
                            LichSu.append(listFile.get(i));
                        }
                        Xflie.writeObject(path, listFile);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                loadList();
                filltable();
                JOptionPane.showMessageDialog(null, "Update Thành Công");
            }
        } catch (Exception e) {

        }
    }

    public void sortbyDate() {
        list = SanPhamDao.loadUser();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Collections.sort(list, (sp1, sp2) -> {
            try {
                return sdf.parse(sp1.getHsd()).compareTo(sdf.parse(sp2.getHsd()));
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return 0;
        });
        filltable();
    }

    public void logout() {
        Login.frame.setVisible(true);
        frame.setVisible(false);
        btnAdd.setEnabled(false);
        btnDelete.setEnabled(false);
        btnMoi.setEnabled(false);
        btnUpdate.setEnabled(false);
        btnHistory.setEnabled(false);
        btnFind.setEnabled(false);
    }

    public void sapXepSoLuong() {
        Collections.sort(list, (sp1, sp2) -> {
            return sp1.getSoLuong() < sp2.getSoLuong() ? 1 : -1;
        });
        filltable();
    }
}
