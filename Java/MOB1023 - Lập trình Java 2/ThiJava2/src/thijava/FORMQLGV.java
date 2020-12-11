package thijava;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class FORMQLGV extends JFrame {

	private JPanel contentPane;
	private JTextField textTen;
	private JLabel lblTen;
	private JTextField textLuong;
	private JTable table;
	ArrayList<GiaoVien> listGV = new ArrayList<GiaoVien>();
	DefaultTableModel model = new DefaultTableModel();
	String path = "C:\\Users\\ADMIN\\Desktop\\ThiJava2Output.thanh";
	@SuppressWarnings("rawtypes")
	JComboBox cboMon = new JComboBox();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FORMQLGV frame = new FORMQLGV();
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public FORMQLGV() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 347);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblQLGV = new JLabel("New label");
		lblQLGV.setForeground(Color.BLUE);
		lblQLGV.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblQLGV.setBounds(79, 11, 292, 27);
		contentPane.add(lblQLGV);
		
		textTen = new JTextField();
		textTen.setBounds(136, 58, 188, 20);
		contentPane.add(textTen);
		textTen.setColumns(10);
		
		lblTen = new JLabel("Tên giáo viên");
		lblTen.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblTen.setBounds(10, 52, 116, 27);
		contentPane.add(lblTen);
		
		textLuong = new JTextField();
		textLuong.setColumns(10);
		textLuong.setBounds(136, 142, 188, 20);
		contentPane.add(textLuong);
		
		cboMon.setModel(new DefaultComboBoxModel(new String[] {"UD", "WEB", "MOBILE"}));
		cboMon.setBounds(136, 98, 127, 22);
		contentPane.add(cboMon);
		
		JLabel lblBoMon = new JLabel("Bộ môn");
		lblBoMon.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblBoMon.setBounds(10, 95, 116, 27);
		contentPane.add(lblBoMon);
		
		JLabel lblLuong = new JLabel("Lương");
		lblLuong.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblLuong.setBounds(10, 136, 116, 27);
		contentPane.add(lblLuong);
		
		JButton btnMo = new JButton("Mở");
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
		btnMo.setBounds(337, 57, 89, 23);
		contentPane.add(btnMo);
		
		JButton btnGhi = new JButton("Ghi");
		btnGhi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(addList()) {
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
			}
		});
		btnGhi.setBounds(337, 98, 89, 23);
		contentPane.add(btnGhi);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteGV();
			}
		});
		btnXoa.setBounds(337, 139, 89, 23);
		contentPane.add(btnXoa);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 183, 416, 116);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		model.addColumn("Tên giáo viên");
		model.addColumn("Bộ môn");
		model.addColumn("Lương");
		model.addColumn("Trạng Thái");
		
		table.setModel(model);
		Text tx = new Text(lblQLGV);
		tx.start();
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int r = table.getSelectedRow();
				display(r);
			}
		});
		
	}
	
	public void display(int r) {
		textTen.setText(listGV.get(r).getTenGV());
		textLuong.setText(String.valueOf(listGV.get(r).getLuong()));
		cboMon.setSelectedItem(listGV.get(r).getBoMon());
		table.setRowSelectionInterval(r, r);
	}
	
	public boolean addList() {
		if(checkName(textTen.getText()) && checkLuong(textLuong.getText())) {
			double luongDouble = Double.parseDouble(textLuong.getText());
			String boMon = (String) cboMon.getSelectedItem();
			listGV.add(new GiaoVien(textTen.getText(),boMon,luongDouble));
			return true;
		} else return false;
	}
	
	public boolean checkName(String name) {
		if(name.isBlank()) {
			JOptionPane.showMessageDialog(null, "Không được để trống tên");
			return false;
		} else return true;
	}
	
	public boolean checkLuong(String luong) {
		try {
			double luongDouble = Double.parseDouble(luong);
			if(luongDouble <= 1000) {
				JOptionPane.showMessageDialog(null, "Lương phải lớn hơn 1000");
				return false;
			} else return true;
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Vui lòng nhập đúng lương");
			return false;
		}
	}
	
	public void write() throws FileNotFoundException, IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
		oos.writeObject(listGV);
		oos.close();
	}
	

	public void fillTable() {
		model.setRowCount(0);
		for (GiaoVien GV : listGV) {
			model.addRow(new Object[] {GV.getTenGV(),GV.getBoMon(),GV.getLuong(),GV.getStatus(GV.getLuong())});
		}
	}

	@SuppressWarnings("unchecked")
	public void read() throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
		listGV = (ArrayList<GiaoVien>) ois.readObject();
		ois.close();
	}
	
	public void deleteGV() {
		int r = table.getSelectedRow();
		if(r < 0) {
			JOptionPane.showMessageDialog(null, "Bạn chưa chọn giáo viên cần xóa!");
		} else {
		listGV.remove(r);
		fillTable();
		display(0);
		JOptionPane.showMessageDialog(null, "Xóa thành công!");
		try {
			write();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
}
