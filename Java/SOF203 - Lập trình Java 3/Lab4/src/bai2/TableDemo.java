package bai2;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class TableDemo extends JFrame {

	private JPanel contentPane;
	private final JPanel panel = new JPanel();
	DefaultTableModel model = new DefaultTableModel();
	private JTable table;
	private JTextField textMaSP;
	private JTextField textTenSP;
	private JTextField textDonGia;
	private JTextField textNhaCungCap;
	ArrayList<SanPham> listSP = new ArrayList<SanPham>();
	@SuppressWarnings("rawtypes")
	JComboBox comboBox = new JComboBox();
	StringBuilder error = new StringBuilder();
	DecimalFormat fm = new DecimalFormat("#.###");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TableDemo frame = new TableDemo();
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
	public TableDemo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 472);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		panel.setBackground(new Color(255, 105, 180));
		panel.setBorder(new TitledBorder(null, "Danh Sach San Pham", TitledBorder.CENTER, TitledBorder.TOP,
				new Font("Tahoma", Font.PLAIN, 18), Color.red));
		panel.setBounds(10, 11, 566, 221);
		contentPane.add(panel);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 36, 546, 174);
		panel.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(238, 232, 170));
		panel_1.setBounds(10, 238, 566, 135);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblMaSP = new JLabel("Ma san pham");
		lblMaSP.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMaSP.setBounds(25, 23, 104, 21);
		panel_1.add(lblMaSP);

		JLabel lblTenSanPham = new JLabel("Ten san pham");
		lblTenSanPham.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTenSanPham.setBounds(25, 56, 104, 21);
		panel_1.add(lblTenSanPham);

		JLabel lblDonViTinh = new JLabel("Don vi tinh");
		lblDonViTinh.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDonViTinh.setBounds(25, 92, 104, 21);
		panel_1.add(lblDonViTinh);

		textMaSP = new JTextField();
		textMaSP.setBounds(130, 22, 146, 25);
		panel_1.add(textMaSP);
		textMaSP.setColumns(10);

		textTenSP = new JTextField();
		textTenSP.setColumns(10);
		textTenSP.setBounds(130, 55, 146, 25);
		panel_1.add(textTenSP);

		textDonGia = new JTextField();
		textDonGia.setColumns(10);
		textDonGia.setBounds(410, 22, 146, 25);
		panel_1.add(textDonGia);

		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Chai", "Thung", "Kg", "Lon" }));
		comboBox.setBounds(130, 92, 146, 22);
		panel_1.add(comboBox);

		JLabel lblDonGia = new JLabel("Don gia");
		lblDonGia.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDonGia.setBounds(304, 27, 104, 21);
		panel_1.add(lblDonGia);

		JLabel lblNhaCungCap = new JLabel("Nha cung cap");
		lblNhaCungCap.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNhaCungCap.setBounds(304, 60, 104, 21);
		panel_1.add(lblNhaCungCap);

		textNhaCungCap = new JTextField();
		textNhaCungCap.setColumns(10);
		textNhaCungCap.setBounds(410, 57, 146, 25);
		panel_1.add(textNhaCungCap);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(47, 79, 79));
		panel_2.setBounds(10, 384, 566, 36);
		contentPane.add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		JButton btnNewButton = new JButton("Them san pham");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addSP(listSP.size());
				fillTable();
			}
		});
		panel_2.add(btnNewButton);

		JButton btnXoaSanPham = new JButton("Xoa san pham");
		btnXoaSanPham.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int r = table.getSelectedRow();
				listSP.remove(r);
				fillTable();
				JOptionPane.showMessageDialog(null, "Xóa thành công!");
			}
		});
		panel_2.add(btnXoaSanPham);

		JButton btnDieuChinhThong = new JButton("Dieu chinh thong tin");
		btnDieuChinhThong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update();
			}
		});
		panel_2.add(btnDieuChinhThong);
		table();

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int r = table.getSelectedRow();
				display(r);
			}
		});

		listSP.add(new SanPham("SP01", "Rượu", "Chai", 500000, "Mr.Thanh"));
		listSP.add(new SanPham("SP02", "Chè", "Túi", 400000, "Mr.Thanh"));
		listSP.add(new SanPham("SP03", "Bia", "Lon", 20000, "Mr.Thanh"));
		listSP.add(new SanPham("SP04", "Thuốc", "Bao", 50000, "Mr.Thanh"));
		fillTable();
		display(0);
	}

	public void table() {
		model.addColumn("MaSP");
		model.addColumn("TenSP");
		model.addColumn("DVT");
		model.addColumn("Don Gia Ban");
		model.addColumn("Nha Cung Cap");
		table.setModel(model);
	}

	public void fillTable() {
		model.setRowCount(0);
		listSP.forEach((sp) -> {
			model.addRow(new Object[] { sp.getMaSP(), sp.getTenSP(), sp.getDVT(), fm.format(sp.getDonGia()),
					sp.getNhaCungCap() });
		});
		table.setModel(model);
	}

	public void update() {
		int r = table.getSelectedRow();
		if (addSP(r)) {
			listSP.remove(r + 1);
			fillTable();
			display(r);
			JOptionPane.showMessageDialog(null, "Update thành công!");
		}
	}

	public void display(int i) {
		textMaSP.setText(listSP.get(i).getMaSP());
		textTenSP.setText(listSP.get(i).getTenSP());
		textDonGia.setText(fm.format(listSP.get(i).getDonGia()));
		textNhaCungCap.setText(listSP.get(i).getNhaCungCap());
		comboBox.setSelectedItem(listSP.get(i).getDVT());
		table.setRowSelectionInterval(i, i);
	}

	public boolean addSP(int i) {
		error.setLength(0);
		if (!checkNull(textMaSP.getText()))
			error.append("Bạn không được để trống mã sản phẩm!\n");
		if (!checkNull(textTenSP.getText()))
			error.append("Bạn không được để trống tên sản phẩm!\n");
		if (!checkNull(textDonGia.getText()))
			error.append("Bạn không được để trống đơn giá!\n");
		if (!checkNull(textNhaCungCap.getText()))
			error.append("Bạn không được để trống nhà cung cấp!\n");
		if (error.toString().isBlank()) {
			try {
				double gia = Double.parseDouble(textDonGia.getText());
				listSP.add(i, new SanPham(textMaSP.getText(), textTenSP.getText(), (String) comboBox.getSelectedItem(),
						gia, textNhaCungCap.getText()));
				fillTable();
				return true;
			} catch (Exception e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "Đơn giá phải là số!", "Lỗi", JOptionPane.ERROR_MESSAGE);
				return false;
			}
		} else {
			JOptionPane.showMessageDialog(null, error.toString(), "Lỗi", JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}

	public boolean checkNull(String text) {
		if (text.isBlank()) {
			return false;
		} else
			return true;
	}
}
