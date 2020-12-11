package lab2;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class StaffManagement extends JFrame {

	private JPanel contentPane;
	private JTextField textID;
	private JTextField textName;
	private JTable table_1;
	private JTable table;
	private JTable table_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StaffManagement frame = new StaffManagement();
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
	public StaffManagement() {
		setTitle("Staff management");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 635, 545);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblStaffManagement = new JLabel("Staff management");
		lblStaffManagement.setForeground(Color.BLUE);
		lblStaffManagement.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblStaffManagement.setBounds(26, 11, 308, 34);
		contentPane.add(lblStaffManagement);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 67, 592, 433);
		contentPane.add(tabbedPane);

		JPanel panel = new JPanel();
		tabbedPane.addTab("Edition", null, panel, null);
		panel.setLayout(null);

		JPanel contentPane_3 = new JPanel();
		contentPane_3.setBounds(343, 5, 1, 1);
		contentPane_3.setLayout(null);
		contentPane_3.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.add(contentPane_3);

		JLabel lblNewLabel_2 = new JLabel("Staff list");
		lblNewLabel_2.setForeground(Color.BLUE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel_2.setBounds(20, 11, 308, 34);
		contentPane_3.add(lblNewLabel_2);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(20, 60, 582, 205);
		contentPane_3.add(scrollPane_1);

		JLabel lblStaffEdition = new JLabel("Staff edition");
		lblStaffEdition.setForeground(Color.BLUE);
		lblStaffEdition.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		lblStaffEdition.setBounds(113, 28, 191, 24);
		panel.add(lblStaffEdition);

		JLabel lblID = new JLabel("Staff ID");
		lblID.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblID.setBounds(23, 63, 74, 24);
		panel.add(lblID);

		JLabel lblName = new JLabel("Full name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblName.setBounds(23, 98, 74, 24);
		panel.add(lblName);

		JLabel lblCountry = new JLabel("Country");
		lblCountry.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCountry.setBounds(23, 133, 74, 24);
		panel.add(lblCountry);

		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGender.setBounds(23, 168, 74, 24);
		panel.add(lblGender);

		JLabel lblStatus = new JLabel("Status");
		lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblStatus.setBounds(23, 203, 74, 24);
		panel.add(lblStatus);

		JLabel lblNotes = new JLabel("Notes");
		lblNotes.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNotes.setBounds(23, 238, 74, 24);
		panel.add(lblNotes);

		textID = new JTextField();
		textID.setColumns(10);
		textID.setBounds(113, 63, 446, 24);
		panel.add(textID);

		textName = new JTextField();
		textName.setColumns(10);
		textName.setBounds(113, 102, 446, 24);
		panel.add(textName);

		JComboBox country = new JComboBox();
		country.setModel(new DefaultComboBoxModel(new String[] { "Việt Nam", "China", "Korea", "Japan" }));
		country.setBounds(113, 136, 129, 24);
		panel.add(country);

		JRadioButton rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnMale.setBounds(113, 171, 57, 23);
		panel.add(rdbtnMale);

		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnFemale.setBounds(179, 171, 111, 23);
		panel.add(rdbtnFemale);

		JCheckBox chckbxSingle = new JCheckBox("Single?");
		chckbxSingle.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chckbxSingle.setBounds(113, 206, 99, 23);
		panel.add(chckbxSingle);

		JTextArea textNotes = new JTextArea();
		textNotes.setBounds(113, 240, 446, 76);
		panel.add(textNotes);

		JButton btnCreate = new JButton("Create");
		btnCreate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCreate.setBounds(173, 345, 89, 30);
		panel.add(btnCreate);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnUpdate.setBounds(272, 345, 89, 30);
		panel.add(btnUpdate);

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDelete.setBounds(371, 345, 89, 30);
		panel.add(btnDelete);

		JButton btnReset = new JButton("Reset");
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnReset.setBounds(470, 345, 89, 30);
		panel.add(btnReset);

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("List", null, panel_1, null);
		panel_1.setLayout(null);
		
		JPanel contentPane_2 = new JPanel();
		contentPane_2.setBounds(293, 5, 1, 1);
		contentPane_2.setLayout(null);
		contentPane_2.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel_1.add(contentPane_2);
		
		JLabel lblNewLabel_1 = new JLabel("Staff list");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel_1.setBounds(20, 11, 308, 34);
		contentPane_2.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 60, 582, 205);
		contentPane_2.add(scrollPane);
		
		JLabel lblStaffList = new JLabel("Staff list");
		lblStaffList.setForeground(Color.BLUE);
		lblStaffList.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblStaffList.setBounds(46, 17, 308, 34);
		panel_1.add(lblStaffList);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(46, 83, 489, 219);
		panel_1.add(scrollPane_2);
		
		table_2 = new JTable();
		scrollPane_2.setViewportView(table_2);
		
		JButton btnStore = new JButton("Store");
		btnStore.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnStore.setBounds(446, 348, 89, 30);
		panel_1.add(btnStore);
		
		JButton btnLoad = new JButton("Load");
		btnLoad.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLoad.setBounds(335, 348, 89, 30);
		panel_1.add(btnLoad);
		
		

		contentTable();
	}
	
	public void contentTable() {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("ID");
		model.addColumn("FULLNAME");
		model.addColumn("COUNTRY");
		model.addColumn("GENDER");
		model.addColumn("STATUS");
		
		model.addRow(new Object[] {"NV01","Nguyễn Nghiệm","Việt Nam","Male","Married"});
		model.addRow(new Object[] {"NV02","Lê Thị Phương Thảo","Korea","Female","Married"});
		model.addRow(new Object[] {"NV03","Nguyễn Đình Thiên Long","China","Male","Single"});
		model.addRow(new Object[] {"NV04","Nguyễn Đình Hoàng Long","Japan","Male","Single"});
		
		table_2.setModel(model);
		
		table_2.getColumnModel().getColumn(0).setPreferredWidth(15);
		table_2.getColumnModel().getColumn(1).setPreferredWidth(100);

		

	}
}
