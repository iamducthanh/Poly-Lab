package bai2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class QLStudent extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textName;
	private JTextField textParentName;
	private JTextField textContectNo;
	JLabel lblNewLabel_1 = new JLabel("Address:");
	JTextArea textAddress = new JTextArea();
	ArrayList<Student> listST = new ArrayList<Student>();
	DefaultTableModel model = new DefaultTableModel();
	int current = 0;
	
	JComboBox comboBox = new JComboBox();
	JComboBox comboBox_1 = new JComboBox();
	JButton btnUpdate = new JButton("Update");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QLStudent frame = new QLStudent();
					frame.setLocationRelativeTo(null);
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
	public QLStudent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 743, 448);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 357, 380);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int r = table.getSelectedRow();
				current = r;
				display(current);
			}
		});
		
		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(434, 27, 39, 14);
		contentPane.add(lblNewLabel);
		
		textName = new JTextField();
		textName.setEditable(false);
		textName.setBorder(null);
		textName.setBounds(490, 25, 192, 20);
		contentPane.add(textName);
		textName.setColumns(10);
		
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(422, 60, 51, 14);
		contentPane.add(lblNewLabel_1);
		
		textParentName = new JTextField();
		textParentName.setEditable(false);
		textParentName.setColumns(10);
		textParentName.setBorder(null);
		textParentName.setBounds(490, 150, 228, 20);
		contentPane.add(textParentName);
		
		textContectNo = new JTextField();
		textContectNo.setEditable(false);
		textContectNo.setColumns(10);
		textContectNo.setBorder(null);
		textContectNo.setBounds(490, 181, 192, 20);
		contentPane.add(textContectNo);
		
		JLabel lblNewLabel_1_1 = new JLabel("ParentName:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(395, 152, 78, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("ContactNo:");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_2.setBounds(407, 183, 66, 14);
		contentPane.add(lblNewLabel_1_2);
		
		
		comboBox.setBounds(490, 212, 192, 22);
		contentPane.add(comboBox);
		

		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"1000", "2000", "3000", "4000"}));
		comboBox_1.setBounds(490, 245, 228, 22);
		contentPane.add(comboBox_1);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Standard:");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_2_1.setBounds(415, 215, 58, 14);
		contentPane.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("Fees:");
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1_2_2.setBounds(441, 248, 32, 14);
		contentPane.add(lblNewLabel_1_2_2);
		
		JButton btnNewButton = new JButton("New");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textName.setText("");
				textParentName.setText("");
				textContectNo.setText("");
				comboBox.setSelectedIndex(0);
				comboBox_1.setSelectedIndex(0);
				textAddress.setText("");
			}
		});
		btnNewButton.setBorder(new BevelBorder(BevelBorder.RAISED));
		btnNewButton.setBackground(SystemColor.activeCaptionBorder);
		btnNewButton.setBounds(377, 334, 78, 23);
		contentPane.add(btnNewButton);
		
		btnUpdate.setEnabled(false);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				update();
			}
		});
		btnUpdate.setBorder(new BevelBorder(BevelBorder.RAISED));
		btnUpdate.setBackground(SystemColor.activeCaptionBorder);
		btnUpdate.setBounds(640, 334, 78, 23);
		contentPane.add(btnUpdate);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textAddress.setEditable(true);
				textContectNo.setEditable(true);
				textName.setEditable(true);
				textParentName.setEditable(true);
				btnUpdate.setEnabled(true);
			}
		});
		btnEdit.setBorder(new BevelBorder(BevelBorder.RAISED));
		btnEdit.setBackground(SystemColor.activeCaptionBorder);
		btnEdit.setBounds(552, 334, 78, 23);
		contentPane.add(btnEdit);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insert();
			}
		});
		btnInsert.setBorder(new BevelBorder(BevelBorder.RAISED));
		btnInsert.setBackground(SystemColor.activeCaptionBorder);
		btnInsert.setBounds(464, 334, 78, 23);
		contentPane.add(btnInsert);
		
		JButton btnNext = new JButton("Previous");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				previous();
			}
		});
		btnNext.setBorder(new BevelBorder(BevelBorder.RAISED));
		btnNext.setBackground(SystemColor.activeCaptionBorder);
		btnNext.setBounds(377, 368, 78, 23);
		contentPane.add(btnNext);
		
		JButton btnNewButton_4_1 = new JButton("Next");
		btnNewButton_4_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				next();
			}
		});
		btnNewButton_4_1.setBorder(new BevelBorder(BevelBorder.RAISED));
		btnNewButton_4_1.setBackground(SystemColor.activeCaptionBorder);
		btnNewButton_4_1.setBounds(464, 368, 78, 23);
		contentPane.add(btnNewButton_4_1);
		
		JButton btnNewButton_4_2 = new JButton("Delete");
		btnNewButton_4_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete();
			}
		});
		btnNewButton_4_2.setBorder(new BevelBorder(BevelBorder.RAISED));
		btnNewButton_4_2.setBackground(SystemColor.activeCaptionBorder);
		btnNewButton_4_2.setBounds(552, 368, 78, 23);
		contentPane.add(btnNewButton_4_2);
		
		JButton btnNewButton_4_3 = new JButton("Exit");
		btnNewButton_4_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_4_3.setBorder(new BevelBorder(BevelBorder.RAISED));
		btnNewButton_4_3.setBackground(SystemColor.activeCaptionBorder);
		btnNewButton_4_3.setBounds(640, 368, 78, 23);
		contentPane.add(btnNewButton_4_3);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(490, 56, 228, 83);
		contentPane.add(scrollPane_1);
		textAddress.setEditable(false);
		
		scrollPane_1.setViewportView(textAddress);
		
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection connection = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=KIDSZONESCHOOL", "sa", "123");
			Statement statement = connection.createStatement();
			ResultSet tbStandrad = statement.executeQuery("SELECT * FROM Standards");
			while(tbStandrad.next()) {
				comboBox.addItem(tbStandrad.getString(1));
			}
			connection.close();
		} catch (ClassNotFoundException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		table();
		loadData();
		loadTable();
		display(current);
	}
	
	public void delete() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection connection = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=KIDSZONESCHOOL", "sa", "123");
			PreparedStatement ps = connection.prepareStatement("DELETE FROM Students WHERE Name = ? and Address = ? and PrarentName = ? and contactNo = ?");
			ps.setString(1, listST.get(current).name);
			ps.setString(2, listST.get(current).address);
			ps.setString(3, listST.get(current).parentName);
			ps.setString(4, listST.get(current).contactNo);
			ps.execute();
			loadData();
			loadTable();
			current = 0;
			display(0);
			JOptionPane.showMessageDialog(null, "Xóa thành công!");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void table() {
		model.addColumn("Name");
		model.addColumn("Standard");
		table.setModel(model);
	}
	
	public void loadData() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection connection = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=KIDSZONESCHOOL", "sa", "123");
			Statement statement = connection.createStatement();
			ResultSet tbStudent = statement.executeQuery("SELECT * FROM Students");
			listST.removeAll(listST);
			while(tbStudent.next()) {
				String name = tbStudent.getString(2);
				String address = tbStudent.getString(3);
				String parentName = tbStudent.getString(4);
				String contactNo = tbStudent.getString(5);
				String standard = tbStudent.getString(6);
				String fees = tbStudent.getString(7);
				listST.add(new Student(name, address, parentName, contactNo, standard, fees));
			}
			connection.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void loadTable() {
		model.setRowCount(0);
		listST.forEach((ST) -> {
			model.addRow(new Object[] {ST.name,ST.standard});
		});	
	}
	
	public void update() {
		StringBuilder error = new StringBuilder();
		if(!checkNull(textName.getText())) {
			error.append("Bạn không được để trống name!\n");
		}
		if(!checkNull(textAddress.getText())) {
			error.append("Bạn không được để trống address!\n");
		}
		if(!checkNull(textParentName.getText())) {
			error.append("Bạn không được để trống parent name!\n");
		}
		if(!checkNull(textContectNo.getText())) {
			error.append("Bạn không được để trống contact no!\n");
		}
		if(!error.toString().isBlank()) {
			JOptionPane.showMessageDialog(null, error,"ERROR",JOptionPane.ERROR_MESSAGE);
		} else {
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				Connection connection = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=KIDSZONESCHOOL", "sa", "123");
				PreparedStatement update = connection.prepareStatement
				("UPDATE Students SET Name = ?, Address = ?, PrarentName = ?, ContactNo = ?, Standard = ?, Fees = ? where Name = ? and Address = ? and ContactNo = ?");
				String standrad = (String) comboBox.getSelectedItem();
				String fees = (String) comboBox_1.getSelectedItem();
				update.setString(1, textName.getText());
				update.setString(2, textAddress.getText());
				update.setString(3, textParentName.getText());
				update.setString(4, textContectNo.getText());
				update.setString(5, standrad);
				update.setString(6, fees);
				update.setString(7, listST.get(current).name);
				update.setString(8, listST.get(current).address);
				update.setString(9, listST.get(current).contactNo);
				update.execute();
				loadData();
				loadTable();
				display(current);
				btnUpdate.setEnabled(false);
				textAddress.setEditable(false);
				textContectNo.setEditable(false);
				textName.setEditable(false);
				textParentName.setEditable(false);
				
				JOptionPane.showMessageDialog(null, "Update thành công!");
			} catch (SQLException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void insert() {
		StringBuilder error = new StringBuilder();
		if(!checkNull(textName.getText())) {
			error.append("Bạn không được để trống name!\n");
		}
		if(!checkNull(textAddress.getText())) {
			error.append("Bạn không được để trống address!\n");
		}
		if(!checkNull(textParentName.getText())) {
			error.append("Bạn không được để trống parent name!\n");
		}
		if(!checkNull(textContectNo.getText())) {
			error.append("Bạn không được để trống contact no!\n");
		}
		if(!error.toString().isBlank()) {
			JOptionPane.showMessageDialog(null, error,"ERROR",JOptionPane.ERROR_MESSAGE);
		} else {
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				Connection connection = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=KIDSZONESCHOOL", "sa", "123");
				PreparedStatement insert = connection.prepareStatement("INSERT INTO Students values (?,?,?,?,?,?)");
				String standrad = (String) comboBox.getSelectedItem();
				String fees = (String) comboBox_1.getSelectedItem();
				insert.setString(1, textName.getText());
				insert.setString(2, textAddress.getText());
				insert.setString(3, textParentName.getText());
				insert.setString(4, textContectNo.getText());
				insert.setString(5, standrad);
				insert.setString(6, fees);
				insert.execute();
				connection.close();
				loadData();
				loadTable();
				current = listST.size() - 1;
				display(current);
				JOptionPane.showMessageDialog(null, "Insert thành công!");
			} catch (SQLException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void display(int i) {
		textName.setText(listST.get(i).name);
		textAddress.setText(listST.get(i).address);
		textContectNo.setText(listST.get(i).contactNo);
		textParentName.setText(listST.get(i).parentName);
		comboBox.setSelectedItem(listST.get(i).standard);
		String feeString = listST.get(i).fees.substring(0, 4);
		comboBox_1.setSelectedItem(feeString);
		System.out.println(feeString);
		table.setRowSelectionInterval(i, i);
	}
	
	public void next() {
		current ++;
		if(current == listST.size()) {
			current = 0;
		}
		display(current);
	}
	public void previous() {
		current --;
		if(current == -1) {
			current = listST.size()-1;
		}
		display(current);
	}
	
	public boolean checkNull(String text) {
		if(text.isBlank()) {
			return false;
		} else return true;
	}
}
