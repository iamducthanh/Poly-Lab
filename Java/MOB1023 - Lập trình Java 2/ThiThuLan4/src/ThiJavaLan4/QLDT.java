package ThiJavaLan4;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings({ "unused", "serial" })
public class QLDT extends JFrame {

	private JPanel contentPane;
	private JTextField textTen;
	private JTextField textGia;
	private JTable table;
	ArrayList<DienThoai> listDT = new ArrayList<DienThoai>();
	DefaultTableModel model = new DefaultTableModel();
	String path = "C:\\Users\\ADMIN\\Desktop\\ThiJava2Output.thanh";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QLDT frame = new QLDT();
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
	@SuppressWarnings("rawtypes")
	JComboBox cbHang = new JComboBox();

	@SuppressWarnings("unchecked")
	public QLDT() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel(" ");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(90, 13, 336, 27);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("T\u00EAn s\u1EA3n ph\u1EA9m");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 51, 98, 21);
		contentPane.add(lblNewLabel_1);

		textTen = new JTextField();
		textTen.setBounds(129, 53, 182, 20);
		contentPane.add(textTen);
		textTen.setColumns(10);

		textGia = new JTextField();
		textGia.setColumns(10);
		textGia.setBounds(129, 117, 182, 20);
		contentPane.add(textGia);

		cbHang.setModel(new DefaultComboBoxModel(new String[] { "Samsung", "Nokia", "Xiaomi", "Vsmart" }));
		cbHang.setBounds(129, 84, 92, 22);
		contentPane.add(cbHang);

		JLabel lblNewLabel_1_1 = new JLabel("H\u00E3ng");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(10, 85, 98, 21);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Gi\u00E1");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(10, 120, 98, 21);
		contentPane.add(lblNewLabel_1_2);

		JButton btnThem = new JButton("Th\u00EAm");
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textTen.setText("");
				textGia.setText("");
				cbHang.setSelectedIndex(0);
			}
		});
		btnThem.setBounds(337, 52, 89, 23);
		contentPane.add(btnThem);

		JButton btnGhi = new JButton("Ghi");
		btnGhi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addd();
				try {
					write();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				fillTable();
			}
		});
		btnGhi.setBounds(337, 83, 89, 23);
		contentPane.add(btnGhi);

		JButton btnMo = new JButton("M\u1EDF");
		btnMo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					read();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				fillTable();
				display(0);
			}
		});
		btnMo.setBounds(337, 116, 89, 23);
		contentPane.add(btnMo);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 165, 416, 87);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		model.addColumn("Tên sản phẩm");
		model.addColumn("Hãng");
		model.addColumn("Giá");
		model.addColumn("Trạng thái");
		
		Text led = new Text(lblNewLabel);
		led.start();

		table.setModel(model);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int r = table.getSelectedRow();
				display(r);
			}
		});
	}

	public void addd() {
		if(checkName(textTen.getText()) && checkGia(textGia.getText())) {
			double giaDouble = Double.parseDouble(textGia.getText());
			String trangThai = (giaDouble > 1000) ? "Tốt" : "Không tốt";
			listDT.add(new DienThoai(textTen.getText(),(String) cbHang.getSelectedItem(),giaDouble,trangThai));
		}
	}

	public boolean checkName(String ten) {
		if (ten.isBlank()) {
			JOptionPane.showMessageDialog(null, "Không được để trống tên");
			return false;
		} else
			return true;
	}

	public boolean checkGia(String gia) {
		try {
			double doubleGia = Double.parseDouble(gia);
			if (doubleGia < 0) {
				JOptionPane.showMessageDialog(null, "Giá phải lớn hơn 0");
				return false;
			} else {
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Nhập sai kiểu gia");
			return false;
		}
	}

	public void display(int r) {
		textTen.setText(listDT.get(r).getTen());
		textGia.setText(String.valueOf(listDT.get(r).getGia()));
		cbHang.setSelectedItem(listDT.get(r).getHang());
		table.setRowSelectionInterval(r, r);
	}

	public void fillTable() {
		model.setRowCount(0);
		for (DienThoai DT : listDT) {
			model.addRow(new Object[] { DT.getTen(), String.valueOf(DT.getGia()), DT.getHang(), DT.getTrangThai() });
		}
	}

	public void write() throws FileNotFoundException, IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
		oos.writeObject(listDT);
		oos.close();
	}

	public void read() throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
		listDT = (ArrayList<DienThoai>) ois.readObject();
		ois.close();
	}
}
