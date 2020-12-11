import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class bai4 extends JFrame {

	private JPanel contentPane;
	private JTextField textFirstName;
	private JTextField textLastName;
	private JTextField textContact;
	private JTextField textHighest;
	private JTextField textSpec;
	private JTextField textEntoll;
	private JTextField textHobbies;
	private JTextField textSport;
	JTextArea textAddress = new JTextArea();
	StringBuilder error = new StringBuilder();
	StringBuilder infor = new StringBuilder();
	static bai4 frame = new bai4();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
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
	public bai4() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 679);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaptionBorder);
		panel.setBounds(10, 11, 566, 35);
		contentPane.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("STUDENT REGISTRATION");
		lblNewLabel.setForeground(Color.MAGENTA);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.activeCaptionBorder);
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Personal Details", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(10, 43, 566, 248);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		textFirstName = new JTextField();
		textFirstName.setBounds(160, 23, 322, 27);
		textFirstName.setBorder(null);
		panel_1.add(textFirstName);
		textFirstName.setColumns(10);
		
		textLastName = new JTextField();
		textLastName.setColumns(10);
		textLastName.setBounds(160, 61, 322, 27);
		textLastName.setBorder(null);
		panel_1.add(textLastName);
		
		textContact = new JTextField();
		textContact.setColumns(10);
		textContact.setBounds(160, 102, 322, 27);
		textContact.setBorder(null);
		panel_1.add(textContact);
		
		textAddress.setBounds(160, 140, 322, 92);
		panel_1.add(textAddress);
		
		JLabel lblFirstName = new JLabel("First name");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblFirstName.setBounds(62, 27, 125, 14);
		panel_1.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last name");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblLastName.setBounds(62, 65, 125, 14);
		panel_1.add(lblLastName);
		
		JLabel lblContact = new JLabel("Contact");
		lblContact.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblContact.setBounds(62, 103, 125, 14);
		panel_1.add(lblContact);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAddress.setBounds(62, 143, 125, 14);
		panel_1.add(lblAddress);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Acamedic Details", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBackground(SystemColor.activeCaptionBorder);
		panel_2.setBounds(10, 302, 566, 144);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		textHighest = new JTextField();
		textHighest.setColumns(10);
		textHighest.setBorder(null);
		textHighest.setBounds(215, 24, 322, 27);
		panel_2.add(textHighest);
		
		textSpec = new JTextField();
		textSpec.setColumns(10);
		textSpec.setBorder(null);
		textSpec.setBounds(215, 60, 322, 27);
		panel_2.add(textSpec);
		
		textEntoll = new JTextField();
		textEntoll.setColumns(10);
		textEntoll.setBorder(null);
		textEntoll.setBounds(215, 100, 322, 27);
		panel_2.add(textEntoll);
		
		JLabel lblHighest = new JLabel("Highest Qualification");
		lblHighest.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHighest.setBounds(39, 28, 179, 14);
		panel_2.add(lblHighest);
		
		JLabel lblSpec = new JLabel("Specification");
		lblSpec.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSpec.setBounds(39, 64, 125, 14);
		panel_2.add(lblSpec);
		
		JLabel lblEnroll = new JLabel("Enroll For");
		lblEnroll.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEnroll.setBounds(39, 104, 125, 14);
		panel_2.add(lblEnroll);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBorder(new TitledBorder(null, "Acamedic Details", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2_1.setBackground(SystemColor.activeCaptionBorder);
		panel_2_1.setBounds(10, 457, 566, 108);
		contentPane.add(panel_2_1);
		panel_2_1.setLayout(null);
		
		textHobbies = new JTextField();
		textHobbies.setColumns(10);
		textHobbies.setBorder(null);
		textHobbies.setBounds(164, 25, 345, 27);
		panel_2_1.add(textHobbies);
		
		textSport = new JTextField();
		textSport.setColumns(10);
		textSport.setBorder(null);
		textSport.setBounds(164, 63, 345, 27);
		panel_2_1.add(textSport);
		
		JLabel lblHobbies = new JLabel("Hobbies");
		lblHobbies.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblHobbies.setBounds(44, 31, 125, 14);
		panel_2_1.add(lblHobbies);
		
		JLabel lblSport = new JLabel("Sport");
		lblSport.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSport.setBounds(44, 69, 125, 14);
		panel_2_1.add(lblSport);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_3.setBackground(SystemColor.activeCaptionBorder);
		panel_3.setBounds(10, 576, 566, 59);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				save();
			}
		});
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSave.setBackground(SystemColor.activeCaptionBorder);
		btnSave.setBounds(109, 11, 89, 39);
		btnSave.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_3.add(btnSave);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnReset.setBackground(SystemColor.activeCaptionBorder);
		btnReset.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnReset.setBounds(239, 11, 89, 39);
		panel_3.add(btnReset);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnExit.setBackground(SystemColor.activeCaptionBorder);
		btnExit.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnExit.setBounds(368, 11, 89, 39);
		panel_3.add(btnExit);
	}
	
	public boolean checkNull(String text) {
		if(text.isBlank()) {
			return false;
		} else return true;
	}
	
	public void save() {
		if(!checkNull(textFirstName.getText())) error.append("Bạn không được để trống First name!\n");
		if(!checkNull(textLastName.getText())) error.append("Bạn không được để trống Last name!\n");
		if(!checkNull(textContact.getText())) error.append("Bạn không được để trống Contact!\n");
		if(!checkNull(textAddress.getText())) error.append("Bạn không được để trống Address!\n");
		if(!checkNull(textHighest.getText())) error.append("Bạn không được để trống Highest Qualification!\n");
		if(!checkNull(textSpec.getText())) error.append("Bạn không được để trống Specification!\n");
		if(!checkNull(textEntoll.getText())) error.append("Bạn không được để trống Enroll For!\n");
		if(!checkNull(textHobbies.getText())) error.append("Bạn không được để trống Hobbies!\n");
		if(!checkNull(textSport.getText())) error.append("Bạn không được để trống Sport!");
		if(error.length() == 0) {
			infor.append("First name: " + textFirstName.getText());
			infor.append("\nLast name: " + textLastName.getText());
			infor.append("\nContact: " + textContact.getText());
			infor.append("\nAddress: " + textAddress.getText());
			infor.append("\nHighest Qualification: " + textHighest.getText());
			infor.append("\nSpecification: " + textSpec.getText());
			infor.append("\nEnroll: " + textEntoll.getText());
			infor.append("\nHobbies: " + textHobbies.getText());
			infor.append("\nSport: " + textSport.getText());
			JOptionPane.showMessageDialog(null, infor.toString(),"Thông tin", JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, error.toString(),"ERROR", JOptionPane.ERROR_MESSAGE);
			error.setLength(0);
		}
	}
	
	public void reset() {
		textFirstName.setText("");
		textLastName.setText("");
		textContact.setText("");
		textAddress.setText("");
		textHighest.setText("");
		textSpec.setText("");
		textEntoll.setText("");
		textHobbies.setText("");
		textSport.setText("");
	}

}
