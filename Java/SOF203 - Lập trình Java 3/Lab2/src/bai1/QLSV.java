package bai1;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

public class QLSV extends JFrame {

	private JPanel contentPane;
	private JTextField textName;
	static QLSV frame = new QLSV();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setVisible(true);
					frame.setFont(new Font("System", Font.PLAIN, 14));
					Font f = frame.getFont();
					FontMetrics fm = frame.getFontMetrics(f);
					int x = fm.stringWidth("Student Detail");
					int y = fm.stringWidth(" ");
					int z = frame.getWidth()/2 - (x/2);
					int w = z/y;
					String pad =" ";
					pad = String.format("%"+w+"s", pad);
					frame.setTitle(pad+"Student Detail");
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
	JTextArea textAddress = new JTextArea();
	JRadioButton rdbtnMale = new JRadioButton("Male");
	JRadioButton rdbtnFemale = new JRadioButton("Female");
	JCheckBox chckbxRead = new JCheckBox("Reading");
	JCheckBox chckbxSing = new JCheckBox("Singing");
	JCheckBox chckbxDancing = new JCheckBox("Dancing");
	JComboBox qualification = new JComboBox();

	public QLSV() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 664, 387);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name: ");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblName.setBounds(10, 16, 100, 19);
		contentPane.add(lblName);
		
		JLabel lblQualifi = new JLabel("Qualification:");
		lblQualifi.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblQualifi.setBounds(384, 16, 115, 19);
		contentPane.add(lblQualifi);
		
		textAddress.setBounds(86, 76, 273, 108);
		textAddress.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPane.add(textAddress);
		
		textName = new JTextField();
		textName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textName.setColumns(10);
		textName.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		textName.setBounds(86, 13, 190, 27);
		contentPane.add(textName);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblAddress.setBounds(10, 81, 100, 19);
		contentPane.add(lblAddress);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(86, 201, 126, 74);
		contentPane.add(panel);
		panel.setLayout(null);
		
		rdbtnMale.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnMale.setBounds(7, 12, 111, 23);
		rdbtnMale.setSelected(true);
		panel.add(rdbtnMale);
		
		rdbtnFemale.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnFemale.setBounds(7, 38, 111, 23);
		panel.add(rdbtnFemale);
		
		ButtonGroup sexRadio = new ButtonGroup();
		sexRadio.add(rdbtnFemale);
		sexRadio.add(rdbtnMale);
		
		JLabel lblSex = new JLabel("Sex:");
		lblSex.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblSex.setBounds(10, 227, 100, 19);
		contentPane.add(lblSex);
		
		qualification.setModel(new DefaultComboBoxModel(new String[] {"Graduate", "Student"}));
		qualification.setFont(new Font("Tahoma", Font.PLAIN, 15));
		qualification.setBounds(509, 17, 131, 22);
		contentPane.add(qualification);
		
		JLabel lblHobby = new JLabel("Hobby:");
		lblHobby.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblHobby.setBounds(384, 81, 115, 19);
		contentPane.add(lblHobby);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(468, 76, 120, 99);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		chckbxRead.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chckbxRead.setBounds(6, 13, 175, 23);
		panel_1.add(chckbxRead);
		
		chckbxSing.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chckbxSing.setBounds(6, 39, 175, 23);
		panel_1.add(chckbxSing);
		
		chckbxDancing.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chckbxDancing.setBounds(6, 65, 175, 23);
		panel_1.add(chckbxDancing);
		
		JButton btnValidate = new JButton("Validate");
		btnValidate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				submit();
			}
		});
		btnValidate.setBounds(242, 301, 89, 23);
		contentPane.add(btnValidate);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();
			}
		});
		btnReset.setBounds(347, 301, 89, 23);
		contentPane.add(btnReset);
	}
	
	public void submit() {
		StringBuilder error = new StringBuilder();
		error.append(checkName(textName.getText()) + checkAddress(textAddress.getText()) + checkSex(rdbtnMale, rdbtnFemale) + checkHobby(chckbxRead, chckbxSing, chckbxDancing));
		if(error.toString().isBlank()) {
			showInfo();
		} else {
			JOptionPane.showMessageDialog(null, error.toString(), "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void showInfo() {
		String qualificationString = (String) qualification.getSelectedItem();
		String sex = "";
		if(rdbtnMale.isSelected()) {
			sex = "Male";
		} else sex = "Female";
		StringBuilder hobby = new StringBuilder();
		if(chckbxRead.isSelected()) {
			hobby.append(chckbxRead.getText() + " ");
		} 
		if(chckbxDancing.isSelected()) {
			hobby.append(chckbxDancing.getText() + " ");
		}
		if(chckbxSing.isSelected()) {
			hobby.append(chckbxSing.getText() + " ");
		}		
		StringBuilder info = new StringBuilder();
		info.append("Name: " + textName.getText() + "\n");
		info.append("Address: " + textAddress.getText() + "\n");
		info.append("Sex: " + sex + "\n");
		info.append("Qualification: " + qualificationString + "\n");
		info.append("Hobby: " + hobby.toString() + "\n");
		JOptionPane.showMessageDialog(null, info.toString() + "\n");
	}
	
	public String checkName(String name) {
		if(name.isBlank()) {
			return "Bạn không được để trống name!\n";
		} else return "";
	}
	
	public String checkAddress(String address) {
		if(address.isBlank()) {
			return "Bạn không được để trống address!\n";
		} else return "";
	}
	
	public String checkSex(JRadioButton male, JRadioButton female) {
		if((male.isSelected() == false) && (female.isSelected()== false)) {
			return "Bạn phải chọn giới tính!\n";
		} else return "";
	}
	
	public String checkHobby(JCheckBox chk1, JCheckBox chk2, JCheckBox chk3) {
		if((chk1.isSelected() == false) && (chk2.isSelected() == false) && (chk3.isSelected() == false)) {
			return "Bạn phải chọn ít nhất 1 hobby!\n";
		} else return "";
	}
	
	public void reset() {
		textName.setText("");
		textAddress.setText("");
		rdbtnMale.setSelected(true);
		chckbxDancing.setSelected(false);
		chckbxRead.setSelected(false);
		chckbxSing.setSelected(false);
		qualification.setSelectedIndex(0);
	}

}
