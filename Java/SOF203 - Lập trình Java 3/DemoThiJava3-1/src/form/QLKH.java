package form;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class QLKH extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	DefaultTableModel model = new DefaultTableModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QLKH frame = new QLKH();
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
	JComboBox comboBox = new JComboBox();
	public QLKH() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 603, 454);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Lo\u1EA1i kh\u00E1ch h\u00E0ng");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 25, 120, 22);
		contentPane.add(lblNewLabel);
		
		comboBox.setBounds(152, 25, 82, 22);
		contentPane.add(comboBox);
		
		JLabel lblLoaiKH = new JLabel("Lo\u1EA1i kh\u00E1ch h\u00E0ng");
		lblLoaiKH.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLoaiKH.setBounds(275, 25, 120, 22);
		contentPane.add(lblLoaiKH);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 71, 412, 155);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNew = new JButton("New");
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
			}
		});
		btnNew.setBounds(449, 68, 89, 23);
		contentPane.add(btnNew);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				save();
			}
		});
		btnSave.setBounds(449, 102, 89, 23);
		contentPane.add(btnSave);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete();
			}
		});
		btnDelete.setBounds(449, 136, 89, 23);
		contentPane.add(btnDelete);
		
		JLabel lblNewLabel_1 = new JLabel("Lo\u1EA1i kh\u00E1ch h\u00E0ng");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 250, 120, 22);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblTnKhchHng = new JLabel("T\u00EAn kh\u00E1ch h\u00E0ng");
		lblTnKhchHng.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTnKhchHng.setBounds(10, 283, 120, 22);
		contentPane.add(lblTnKhchHng);
		
		textField = new JTextField();
		textField.setBounds(138, 253, 257, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(138, 286, 257, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(138, 317, 257, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int r = table.getSelectedRow();
				display(r);
			}
		});
		textField_3.setColumns(10);
		textField_3.setBounds(138, 348, 257, 20);
		contentPane.add(textField_3);
		
		JLabel lblNewLabel_2_1 = new JLabel("S\u1ED1 \u0111i\u1EC7n tho\u1EA1i");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(10, 320, 120, 22);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Email");
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2_2.setBounds(10, 351, 120, 22);
		contentPane.add(lblNewLabel_2_2);
		
		loadCombobox();
		table();
		loadTable();
		display(0);
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loadTable();
				display(0);
			}
		});
	}
	
	public void table() {
		model.addColumn("Mã khách hàng");
		model.addColumn("Tên khách hàng");
		model.addColumn("Số điện thoại");
		model.addColumn("Email");
		table.setModel(model);
	}
	
	public void loadCombobox() {
		try {
			Connection conn = DatabaseConnect.connect();
			Statement statement = conn.createStatement();
			ResultSet tbLoaiKH = statement.executeQuery("select * from LoaiKhachHang");
			while(tbLoaiKH.next()) {
				comboBox.addItem(tbLoaiKH.getString(1));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void loadTable() {
		try {
			Connection conn = DatabaseConnect.connect();
			Statement statement = conn.createStatement();
			ResultSet tbKH = statement.executeQuery("select * from KhachHang");
			model.setRowCount(0);
			while(tbKH.next()) {
				if(tbKH.getString(5).equalsIgnoreCase((String) comboBox.getSelectedItem())) {
					model.addRow(new Object[] {tbKH.getString(1), tbKH.getString(2), tbKH.getString(3), tbKH.getString(4)});
				}
			}
			table.setModel(model);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void display(int r) {
		table.setRowSelectionInterval(r, r);
		textField.setText((String) model.getValueAt(r, 0));
		textField_1.setText((String) model.getValueAt(r, 1));
		textField_2.setText((String) model.getValueAt(r, 2));
		textField_3.setText((String) model.getValueAt(r, 3));
	}
	
	public void save() {
		String reSDT = "[0]{1}[1-9]{9}";
		String reEmail = "[a-z]{1,30}@[a-z]{3,5}.[a-z]{1,20}";
		StringBuilder error = new StringBuilder();
		if(textField.getText().isBlank()) {
			error.append("Bạn không được để trống mã khách hàng\n");
		}
		if(textField_1.getText().isBlank()) {
			error.append("Bạn không được để trống tên khách hàng\n");
		} 
		if(!textField_2.getText().matches(reSDT)) {
			error.append("Bạn phải nhập đúng số điện thoại\n");
		}
		if(!textField_3.getText().matches(reEmail)) {
			error.append("Bạn phải nhập đúng định dạng email\n");
		}
		if(! error.toString().isBlank()) {
			JOptionPane.showMessageDialog(null, error.toString());
		} else {
			DatabaseConnect.insert(textField.getText(), textField_1.getText(), textField_2.getText(), textField_3.getText(), String.valueOf(comboBox.getSelectedItem()));
			loadTable();
		}
	}
	
	public void delete() {
		DatabaseConnect.datele(textField.getText());
		loadTable();
		
	}
}
