package lab5;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;

public class Lab5Bai4 extends JFrame {

	private JPanel contentPane;
	private JTextField textPath;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		File file = new File("C:\\Users\\ADMIN\\eclipse-workspace\\Lab5\\src\\lab5\\lab5output.txt");

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lab5Bai4 frame = new Lab5Bai4();
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
	public Lab5Bai4() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("T\u00EAn file");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 21, 66, 14);
		contentPane.add(lblNewLabel);

		textPath = new JTextField();
		textPath.setBounds(74, 11, 352, 29);
		contentPane.add(textPath);
		textPath.setColumns(10);

		textPath.setText("C:\\Users\\ADMIN\\eclipse-workspace\\Lab5\\src\\lab5\\lab5output.txt");

		JLabel lblNiDung = new JLabel("N\u1ED9i dung");
		lblNiDung.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNiDung.setBounds(10, 47, 66, 24);
		contentPane.add(lblNiDung);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 82, 416, 129);
		contentPane.add(textArea);

		JButton btnWrite = new JButton("Lưu");
		btnWrite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				write();
			}

			public void write() {
				String path = textPath.getText();
				String content = textArea.getText();
				try {
					BufferedWriter bw = new BufferedWriter(new FileWriter(path));
					bw.write(content);
					bw.newLine();
					bw.close();
					JOptionPane.showMessageDialog(null, "Ghi file thành công!");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Lỗi ghi file không thành công");
					// TODO: handle exception
				}
			}
		});
		btnWrite.setForeground(Color.BLACK);
		btnWrite.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnWrite.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnWrite.setBackground(SystemColor.activeCaptionBorder);
		btnWrite.setBounds(355, 222, 71, 30);
		contentPane.add(btnWrite);

		JButton btnRead = new JButton("Đọc");
		btnRead.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				read();
			}

			public void read() {
				String path = textPath.getText();
				try {
					BufferedReader br = new BufferedReader(new FileReader(path));
					while (true) {
						String line = br.readLine();
						if (line == null) {
							break;
						} else {
							textArea.append(line);
							textArea.append("\r\n");
						}
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		});
		btnRead.setForeground(Color.BLACK);
		btnRead.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRead.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnRead.setBackground(SystemColor.activeCaptionBorder);
		btnRead.setBounds(274, 222, 71, 30);
		contentPane.add(btnRead);

	}

}
