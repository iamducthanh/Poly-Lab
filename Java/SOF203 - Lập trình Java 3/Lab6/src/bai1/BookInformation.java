package bai1;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class BookInformation extends JFrame {

	private JPanel contentPane;
	private JTextField textTitle;
	private JTable table;
	DefaultTableModel model = new DefaultTableModel();
	ArrayList<Book> listBook = new ArrayList<Book>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookInformation frame = new BookInformation();
					frame.setTitle("Book Information");
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
	public BookInformation() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 358);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Filter",
				TitledBorder.LEADING, TitledBorder.TOP, new Font("Tahoma", Font.BOLD, 12), Color.BLACK));
		panel.setBounds(22, 11, 378, 92);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Title:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(20, 33, 49, 14);
		panel.add(lblNewLabel);

		textTitle = new JTextField();
		textTitle.setBorder(null);
		textTitle.setBounds(65, 29, 292, 24);
		panel.add(textTitle);
		textTitle.setColumns(10);

		JButton btnSearch = new JButton("Search");
		btnSearch.setBorder(new BevelBorder(BevelBorder.RAISED));
		btnSearch.setBackground(SystemColor.activeCaptionBorder);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSearch();
			}
		});
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSearch.setBounds(410, 38, 89, 23);
		contentPane.add(btnSearch);

		JButton btnExit = new JButton("Exit");
		btnExit.setBackground(SystemColor.activeCaptionBorder);
		btnExit.setBorder(new BevelBorder(BevelBorder.RAISED));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnExit.setBounds(509, 38, 67, 23);
		contentPane.add(btnExit);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 114, 554, 148);
		contentPane.add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		table();

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cofirm = JOptionPane.showConfirmDialog(null, "Do you want to Delete?");
				if(cofirm == 0) {
					delete();
				}
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnDelete.setBorder(new BevelBorder(BevelBorder.RAISED));
		btnDelete.setBackground(SystemColor.activeCaptionBorder);
		btnDelete.setBounds(487, 273, 89, 23);
		contentPane.add(btnDelete);
		
		loadData();
	}

	public void table() {
		model.addColumn("ID");
		model.addColumn("Title");
		model.addColumn("Price");
		table.setModel(model);
	}

	public void loadData() {
		listBook.removeAll(listBook);
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=BOOKINFORMATION",
					"sa", "123");
			Statement statement = conn.createStatement();
			ResultSet tbBook = statement.executeQuery("SELECT * FROM TBBOOK");
			while(tbBook.next()) {
				int ID = Integer.parseInt(tbBook.getString("ID"));
				String title = tbBook.getString("TITLE");
				double price = Double.parseDouble(tbBook.getString("PRICE"));
				listBook.add(new Book(ID, title, price));
			}
			conn.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		loadTable();
	}
	
	public void loadTable() {
		model.setRowCount(0);
		listBook.forEach((book) -> {
			model.addRow(new Object[] {book.ID,book.title,book.price});
		});
		table.setModel(model);
		display(0);
	}
		
	public void btnSearch() {
		if(!textTitle.getText().isBlank()) {
			int i = find();
			if(i == listBook.size()) {
				JOptionPane.showMessageDialog(null, "The book is not available!","ERROR",JOptionPane.WARNING_MESSAGE);
			} else {
				display(i);
				JOptionPane.showMessageDialog(null, "Đã tìm thấy!");
			}
		}
	}
	
	public void delete() {
		int r = table.getSelectedRow();
		int ID = listBook.get(r).ID;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection connection = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=BOOKINFORMATION", "sa", "123");
			PreparedStatement ps = connection.prepareStatement("DELETE FROM TBBOOK WHERE ID = ?");
			ps.setString(1, String.valueOf(ID));
			ps.execute();
			connection.close();
			ps.close();
			loadData();
			loadTable();
			JOptionPane.showMessageDialog(null, "Xóa thành công!");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public int find() {
		int i = 0;
		for (; i < listBook.size(); i++) {
			if (listBook.get(i).title.equalsIgnoreCase(textTitle.getText())) {
				break;
			}
		}
		return i;
	}
	
	public void display(int r) {
		table.setRowSelectionInterval(r, r);
	}
}
