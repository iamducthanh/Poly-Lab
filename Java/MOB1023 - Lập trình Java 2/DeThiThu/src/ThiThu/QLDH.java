package ThiThu;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

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
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class QLDH extends JFrame {

	private JPanel contentPane;
	private JTextField textTen;
	private JTextField textGia;
	JComboBox comboBox = new JComboBox();
	private JTable table;
	JLabel lblNewLabel_1 = new JLabel("8");
	DefaultTableModel model = new DefaultTableModel();
	ThiThu.Clock clock = new ThiThu.Clock(lblNewLabel_1);
	ArrayList<DongHo> listDongHo = new ArrayList<DongHo>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QLDH frame = new QLDH();
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
	public QLDH() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 424);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("QU\u1EA2N L\u00CD \u0110\u1ED2NG H\u1ED2");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(162, 11, 147, 40);
		contentPane.add(lblNewLabel);
		
		
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setBounds(319, 22, 107, 24);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("T\u00EAn s\u1EA3n ph\u1EA9m: ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(10, 56, 107, 24);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("H\u00E3ng");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(10, 122, 107, 24);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Gi\u00E1");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_2.setBounds(10, 190, 107, 24);
		contentPane.add(lblNewLabel_2_2);
		
		textTen = new JTextField();
		textTen.setBounds(139, 60, 170, 20);
		contentPane.add(textTen);
		textTen.setColumns(10);
		
		
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Casio", "Seiko"}));
		comboBox.setToolTipText("Casio\r\nSeiko");
		comboBox.setBounds(139, 125, 113, 22);
		contentPane.add(comboBox);
		
		textGia = new JTextField();
		textGia.setColumns(10);
		textGia.setBounds(139, 194, 170, 20);
		contentPane.add(textGia);
		
		JButton btnNewButton = new JButton("Th\u00EAm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearForm();
			}
		});
		btnNewButton.setBounds(329, 57, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnGhi = new JButton("Ghi");
		btnGhi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ghi();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnGhi.setBounds(329, 91, 89, 23);
		contentPane.add(btnGhi);
		
		JButton btnM = new JButton("M\u1EDF");
		btnM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					doc();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnM.setBounds(329, 125, 89, 23);
		contentPane.add(btnM);
		
		JButton btnSpTn = new JButton("S\u1EAFp t\u00EAn");
		btnSpTn.setBounds(329, 159, 89, 23);
		contentPane.add(btnSpTn);
		
		JButton btnSpGi = new JButton("S\u1EAFp gi\u00E1");
		btnSpGi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sapGia();
			}
		});
		btnSpGi.setBounds(329, 193, 89, 23);
		contentPane.add(btnSpGi);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 245, 408, 131);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table();
		clock.start();
		
		
		listDongHo.add(new DongHo("Dong ho 1", "Casio", 100000));
		listDongHo.add(new DongHo("Dong ho 2", "Seiko", 200000));
		listDongHo.add(new DongHo("Dong ho 3", "Casio", 300000));
		listDongHo.add(new DongHo("Dong ho 4", "Seiko", 400000));
		listDongHo.add(new DongHo("Dong ho 5", "Seiko", 500000));
		listDongHo.add(new DongHo("Dong ho 6", "Casio", 600000));
		listDongHo.add(new DongHo("Dong ho 7", "Seiko", 700000));
		listDongHo.add(new DongHo("Dong ho 8", "Casio", 800000));
		fillTable();
		display(0);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				display(row);
			}
		});
	}
	
	public void table() {
		model.addColumn("Tên");
		model.addColumn("Hãng");
		model.addColumn("Giá");
		table.setModel(model);
	}
	
	public void ghi() throws FileNotFoundException, IOException {
		if(checkTen(textTen.getText()) && checkGia(textGia.getText())) {
			listDongHo.add(new DongHo(textTen.getText(),comboBox.getSelectedItem().toString(),Double.parseDouble(textGia.getText())));
		String pathString = "C:\\Users\\ADMIN\\Desktop\\thijava.txt";
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(pathString));
		oos.writeObject(listDongHo);
		oos.close();
		fillTable();
		} else {
			
		}
	}
	
	public void doc() throws FileNotFoundException, IOException {
		String pathString = "C:\\Users\\ADMIN\\Desktop\\thijava.txt";
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(pathString));
		try {
			listDongHo = (ArrayList<DongHo>) ois.readObject();
			fillTable();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void add() {
		
	}
	
	public void display(int row) {
		textTen.setText(listDongHo.get(row).getTenSP());
		textGia.setText(String.valueOf(listDongHo.get(row).getGia()));
		comboBox.setSelectedItem(listDongHo.get(row).getHang());
		table.setRowSelectionInterval(row, row);
	}
	
	public void fillTable() {
		model.setRowCount(0);
		listDongHo.forEach((dongho) -> {
			model.addRow(new Object[] {dongho.getTenSP(),dongho.getHang(),dongho.getGia()});
		});
		display(0);
		
	}
	
	public void sapGia() {
		listDongHo.sort((dh1,dh2) -> {
			return dh1.getGia() < dh2.getGia() ? 1 : -1;
		});
		fillTable();
	}
	
	public void sapTen() {
		Collections.sort(listDongHo,(dh1,dh2) -> dh1.getTenSP().compareTo(dh2.getTenSP()));
		fillTable();
	}
	
	public boolean checkTen(String ten) {
		if(ten.isBlank()) {
			return false;
		} else return true;
	}
	
	public boolean checkGia(String gia) {
		try {
			if(gia.isBlank()) {
				return false;
			} else {
				return true;
			}
		} catch  (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Nhập sai định dang giá");
			return false;
		}
	}
	
	public void clearForm() {
		textGia.setText("");
		textTen.setText("");
		comboBox.setSelectedIndex(0);
	}
	
	
}
