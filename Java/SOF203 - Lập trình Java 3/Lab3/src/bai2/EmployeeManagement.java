package bai2;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
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
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class EmployeeManagement extends JFrame {

	private JPanel contentPane;
	private JTextField textHo;
	private JTextField textBiDanh;
	private JTextField textTen;
	private JTextField textMatMa;
	static EmployeeManagement frame;
	JTextArea textGhiChu = new JTextArea();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new EmployeeManagement();
					frame.setVisible(true);
					frame.setTitle("Employee Management");
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
	JComboBox comboBox = new JComboBox();
	JRadioButton rdbtnKhongXacDinh = new JRadioButton("Khong xac dinh");
	JRadioButton rdbtnNam = new JRadioButton("Nam");
	JRadioButton rdbtnNu = new JRadioButton("Nu");
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public EmployeeManagement() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 606, 450);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 255, 153));
		panel.setBorder(new TitledBorder(null, "Ho ten", TitledBorder.CENTER, TitledBorder.TOP, new Font("Tahoma", Font.PLAIN, 15), Color.red));
		panel.setBounds(10, 11, 572, 88);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblHo = new JLabel("Ho:");
		lblHo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblHo.setBounds(23, 25, 49, 14);
		panel.add(lblHo);
		
		JLabel lblBiDanh = new JLabel("Bi danh: ");
		lblBiDanh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBiDanh.setBounds(23, 54, 71, 14);
		panel.add(lblBiDanh);
		
		JLabel lblTen = new JLabel("Ten:");
		lblTen.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTen.setBounds(291, 25, 49, 14);
		panel.add(lblTen);
		
		JLabel lblMatMa = new JLabel("Mat ma:");
		lblMatMa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMatMa.setBounds(291, 54, 87, 14);
		panel.add(lblMatMa);
		
		textHo = new JTextField();
		textHo.setBounds(103, 24, 162, 20);
		panel.add(textHo);
		textHo.setColumns(10);
		textHo.setBorder(null);
		
		textBiDanh = new JTextField();
		textBiDanh.setColumns(10);
		textBiDanh.setBounds(103, 53, 162, 20);
		textBiDanh.setBorder(null);
		panel.add(textBiDanh);
		
		textTen = new JTextField();
		textTen.setColumns(10);
		textTen.setBounds(374, 24, 162, 20);
		textTen.setBorder(null);
		panel.add(textTen);
		
		textMatMa = new JPasswordField();
		textMatMa.setColumns(10);
		textMatMa.setBounds(374, 53, 162, 20);
		textMatMa.setBorder(null);
		panel.add(textMatMa);
		
		JPanel panel2 = new JPanel();
		panel2.setBackground(new Color(255, 255, 153));
		panel2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Gioi tinh", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 204)));
		panel2.setBounds(10, 110, 572, 47);
		contentPane.add(panel2);
		panel2.setLayout(null);
		
		rdbtnNam.setBackground(new Color(255, 255, 153));
		rdbtnNam.setBounds(66, 15, 111, 23);
		panel2.add(rdbtnNam);
		
		rdbtnNu.setBackground(new Color(255, 255, 153));
		rdbtnNu.setBounds(179, 15, 111, 23);
		panel2.add(rdbtnNu);
		
		rdbtnKhongXacDinh.setBackground(new Color(255, 255, 153));
		rdbtnKhongXacDinh.setBounds(292, 15, 168, 23);
		panel2.add(rdbtnKhongXacDinh);
		
		ButtonGroup radio = new ButtonGroup();
		radio.add(rdbtnNu);
		radio.add(rdbtnKhongXacDinh);
		radio.add(rdbtnNam);
		
		JPanel panel3 = new JPanel();
		panel3.setBackground(new Color(255, 204, 255));
		panel3.setBorder(new TitledBorder(null, "Thong tin khac", TitledBorder.LEFT, TitledBorder.TOP, new Font("Tahoma", Font.PLAIN, 14), new Color(0, 0, 0)));
		panel3.setBounds(10, 168, 572, 197);
		contentPane.add(panel3);
		panel3.setLayout(null);
		
		JLabel lblBiDanh_1 = new JLabel("Que quan");
		lblBiDanh_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBiDanh_1.setBounds(29, 40, 71, 14);
		panel3.add(lblBiDanh_1);
		
		JLabel lblBiDanh_2 = new JLabel("So thich");
		lblBiDanh_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBiDanh_2.setBounds(29, 74, 71, 14);
		panel3.add(lblBiDanh_2);
		
		JLabel lblBiDanh_3 = new JLabel("Ghi chu");
		lblBiDanh_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblBiDanh_3.setBounds(29, 105, 71, 14);
		panel3.add(lblBiDanh_3);
		
		comboBox.setBackground(new Color(255, 204, 255));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Ninh Thuan", "Ha Noi", "Da Nang", "Ha Tinh"}));
		comboBox.setBounds(122, 38, 164, 22);
		panel3.add(comboBox);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("An choi");
		chckbxNewCheckBox.setBackground(new Color(255, 204, 255));
		chckbxNewCheckBox.setBounds(122, 72, 99, 23);
		panel3.add(chckbxNewCheckBox);
		
		JCheckBox chckbxNhayMua = new JCheckBox("Nhay mua");
		chckbxNhayMua.setBackground(new Color(255, 204, 255));
		chckbxNhayMua.setBounds(236, 72, 99, 23);
		panel3.add(chckbxNhayMua);
		
		JCheckBox chckbxNguNghi = new JCheckBox("Ngu nghi");
		chckbxNguNghi.setBackground(new Color(255, 204, 255));
		chckbxNguNghi.setBounds(348, 72, 99, 23);
		panel3.add(chckbxNguNghi);
		
		textGhiChu.setBounds(122, 102, 363, 75);
		panel3.add(textGhiChu);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();
			}
		});
		btnReset.setBounds(253, 376, 89, 23);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnExit.setBounds(352, 376, 89, 23);
		
		JPanel panel4 = new JPanel();
		panel4.setBackground(Color.WHITE);
		panel4.setBounds(10, 365, 572, 37);
		contentPane.add(panel4);
		panel4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnOK = new JButton("OK");
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ok();
			}
		});
		btnOK.setBounds(154, 376, 89, 23);
		panel4.add(btnOK);
		panel4.add(btnReset);
		panel4.add(btnExit);
		rdbtnNam.setSelected(true);
	}
	
	public void reset() {
		textBiDanh.setText("");
		textHo.setText("");
		textMatMa.setText("");
		textTen.setText("");
		textGhiChu.setText("");
		comboBox.setSelectedIndex(0);
		rdbtnNam.setSelected(true);
	}
	
	public void ok() {
		String gioiTinh;
		if(rdbtnNam.isSelected()) {
			gioiTinh = "Nam";
		} else if(rdbtnNu.isSelected()) {
			gioiTinh = "Nu";
		} else {
			gioiTinh = "Khong xac dinh";
		}
		String thongTin = "Ho ten: " + textHo.getText() + " " + textTen.getText() + "\nQue quan: " + (String) comboBox.getSelectedItem() + "\nGioi tinh: " + gioiTinh;
		JOptionPane.showMessageDialog(null, thongTin,"Thong tin ca nhan", JOptionPane.INFORMATION_MESSAGE);
	}
}
