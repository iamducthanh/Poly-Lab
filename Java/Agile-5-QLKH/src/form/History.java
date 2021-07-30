package form;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import File.Xflie;

import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class History extends JDialog {

	private JPanel contentPane;
	DefaultTableModel model = new DefaultTableModel();
	static StringBuilder LichSu = new StringBuilder();
	JTextArea textArea = new JTextArea();
	History frame;
	
	/**
	 * Launch the application.
	 */
	
	public void mainHistory() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new History();
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
	public History() {
		setTitle("Lịch sử");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 340);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("L\u1ECBch s\u1EED");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(20, 11, 354, 28);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 50, 395, 202);
		contentPane.add(scrollPane);
		
		scrollPane.setViewportView(textArea);
		JTableHeader header = new JTableHeader();
		header.setBackground(Color.red);
		model.addColumn("Lịch sử");
		JButton btnQuayLi = new JButton("Quay lại");
		btnQuayLi.setForeground(new Color(0, 0, 0));
		btnQuayLi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnQuayLi.setBorder(new LineBorder(Color.BLACK));
		btnQuayLi.setBackground(Color.BLACK);
		btnQuayLi.setBounds(326, 269, 89, 23);
//		contentPane.add(btnQuayLi);
		JLabel lblBkg = new JLabel();
		lblBkg.setBounds(0, 0, 450, 340);
		lblBkg.setIcon(new ImageIcon("C:\\QLKH\\Image\\background.jpg"));
		contentPane.add(lblBkg);
		btnQuayLi.setContentAreaFilled(false);
//		header1.setBackground(new Color(179, 115, 52, 200));
		
		btnQuayLi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnQuayLi.setBounds(323, 266, 95, 29);
				btnQuayLi.setBorder(new LineBorder(Color.BLACK, 2));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnQuayLi.setBounds(326, 269, 89, 23);
				btnQuayLi.setBorder(new LineBorder(Color.BLACK, 1));
			}
		});
		textArea.setText(QLKH.LichSu.toString());
	}
	
}
