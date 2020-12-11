package lab2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.Scrollable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class StaffList extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StaffList frame = new StaffList();
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
	public StaffList() {
		setTitle("Staff list");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 639, 435);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblStaffList = new JLabel("Staff list");
		lblStaffList.setForeground(Color.BLUE);
		lblStaffList.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblStaffList.setBounds(20, 11, 308, 34);
		contentPane.add(lblStaffList);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 60, 582, 205);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnStore = new JButton("Store");
		btnStore.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnStore.setBounds(513, 289, 89, 30);
		contentPane.add(btnStore);
		
		JButton btnLoad = new JButton("Load");
		btnLoad.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLoad.setBounds(414, 289, 89, 30);
		contentPane.add(btnLoad);

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
		
		
		
		table.setModel(model);
		table.getColumnModel().getColumn(0).setPreferredWidth(5);
		table.getColumnModel().getColumn(2).setPreferredWidth(20);
		table.getColumnModel().getColumn(3).setPreferredWidth(20);
		table.getColumnModel().getColumn(4).setPreferredWidth(20);
	}
}
