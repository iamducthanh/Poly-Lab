package lab7Bai4;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

@SuppressWarnings({ "serial" })
public class Lab7Bai4 extends JFrame {

	private JPanel contentPane;
	private JTextField textNumber;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lab7Bai4 frame = new Lab7Bai4();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public Lab7Bai4() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 139);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textNumber = new JTextField();
		textNumber.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textNumber.setColumns(10);
		textNumber.setBounds(116, 11, 297, 32);
		contentPane.add(textNumber);
		
		JLabel lblNewLabel = new JLabel("Credit Card");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(10, 21, 80, 21);
		contentPane.add(lblNewLabel);
		
		JButton btnThcHin = new JButton("Th\u1EF1c hi\u00EAn");
		btnThcHin.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if(XPoly.isCardNumber(textNumber.getText())) {
					JOptionPane.showMessageDialog(null, "Dãy số hợp lệ!");
				} else {
					JOptionPane.showMessageDialog(null, "Dãy số không hợp lệ!");
				}
			}
		});
		btnThcHin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnThcHin.setBounds(116, 54, 118, 32);
		contentPane.add(btnThcHin);
	}
}
