package lab2;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StaffEdition extends JFrame {

	private JPanel contentPane;
	private JTextField lblID;
	private JTextField lblName;
	private JRadioButton rdbtnMale;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StaffEdition frame = new StaffEdition();
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
	public StaffEdition() {
		setTitle("Staff edition");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 592, 433);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblStaffEdition = new JLabel("Staff edition");
		lblStaffEdition.setForeground(Color.BLUE);
		lblStaffEdition.setFont(new Font("Trebuchet MS", Font.BOLD, 30));
		lblStaffEdition.setBounds(107, 21, 191, 24);
		contentPane.add(lblStaffEdition);
		
		JLabel lblStaffID = new JLabel("Staff ID");
		lblStaffID.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblStaffID.setBounds(10, 69, 74, 24);
		contentPane.add(lblStaffID);
		
		JLabel lblFullName = new JLabel("Full name");
		lblFullName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFullName.setBounds(10, 106, 74, 24);
		contentPane.add(lblFullName);
		
		lblID = new JTextField();
		lblID.setBounds(107, 71, 446, 24);
		contentPane.add(lblID);
		lblID.setColumns(10);
		
		lblName = new JTextField();
		lblName.setColumns(10);
		lblName.setBounds(107, 108, 446, 24);
		contentPane.add(lblName);
		
		JLabel lblCountry = new JLabel("Country");
		lblCountry.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCountry.setBounds(10, 141, 74, 24);
		contentPane.add(lblCountry);
		
		JComboBox country = new JComboBox();
		country.setBounds(107, 143, 129, 24);
		String data[] = {"Việt Nam","Korea","Japan","China"};
		country.setModel(new DefaultComboBoxModel(data));
		contentPane.add(country);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGender.setBounds(10, 176, 74, 24);
		contentPane.add(lblGender);
		
		rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnMale.setBounds(107, 174, 57, 23);
		contentPane.add(rdbtnMale);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnFemale.setBounds(187, 174, 111, 23);
		contentPane.add(rdbtnFemale);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnMale);
		bg.add(rdbtnFemale);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblStatus.setBounds(10, 211, 74, 24);
		contentPane.add(lblStatus);
		
		JLabel lblNotes = new JLabel("Notes");
		lblNotes.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNotes.setBounds(10, 246, 74, 24);
		contentPane.add(lblNotes);
		
		JCheckBox chckbxSingle = new JCheckBox("Single?");
		chckbxSingle.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chckbxSingle.setBounds(107, 214, 99, 23);
		contentPane.add(chckbxSingle);
		
		JList list = new JList();
		list.setBounds(158, 252, 1, 1);
		contentPane.add(list);
		
		JTextArea textNotes = new JTextArea();
		textNotes.setBounds(107, 252, 446, 76);
		contentPane.add(textNotes);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnCreate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCreate.setBounds(107, 355, 89, 30);
		contentPane.add(btnCreate);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnUpdate.setBounds(206, 355, 89, 30);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDelete.setBounds(305, 355, 89, 30);
		contentPane.add(btnDelete);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnReset.setBounds(409, 355, 89, 30);
		contentPane.add(btnReset);
		
		
	}
}
