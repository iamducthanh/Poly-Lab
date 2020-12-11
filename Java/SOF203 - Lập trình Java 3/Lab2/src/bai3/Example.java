package bai3;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Example extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Example frame = new Example();
					frame.setVisible(true);
					frame.setTitle("JOption Pane Example");
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
	public Example() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 416, 152);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnMessage = new JButton("Message Dialog");
		btnMessage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Please input your name!");
			}
		});
		btnMessage.setBackground(SystemColor.activeCaptionBorder);
		btnMessage.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnMessage.setBounds(10, 11, 186, 33);
		btnMessage.setBorder(new BevelBorder(BevelBorder.RAISED));
		contentPane.add(btnMessage);
		
		JButton btnInput = new JButton("Input Dialog");
		btnInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String yourName = JOptionPane.showInputDialog("Your name is: ");
				if(!yourName.isBlank()) {
					JOptionPane.showMessageDialog(null, "Your name is: "+ yourName);
				}
			}
		});
		btnInput.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnInput.setBorder(new BevelBorder(BevelBorder.RAISED));
		btnInput.setBackground(SystemColor.activeCaptionBorder);
		btnInput.setBounds(206, 11, 186, 33);
		contentPane.add(btnInput);
		
		JButton btnConfirm = new JButton("Confirm Dialog");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ret = JOptionPane.showConfirmDialog(null, "Are you sure?");
				if(ret == JOptionPane.YES_OPTION) {
					JOptionPane.showMessageDialog(null, "You are sure!");
				} else if (ret == JOptionPane.NO_OPTION) {
					JOptionPane.showMessageDialog(null, "You not sure!");
				}
			}
		});
		btnConfirm.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnConfirm.setBorder(new BevelBorder(BevelBorder.RAISED));
		btnConfirm.setBackground(SystemColor.activeCaptionBorder);
		btnConfirm.setBounds(10, 55, 186, 33);
		contentPane.add(btnConfirm);
		
		JButton btnOption = new JButton("Option Dialog");
		btnOption.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] option = {"Java","C++","VB","PHP","Perl"};
				int code = JOptionPane.showOptionDialog(null, "What language do you prefer", "Option dialog box",0, JOptionPane.QUESTION_MESSAGE, null, option, option[4]);
				JOptionPane.showMessageDialog(null, "Answer: "+option[code]);
			}
		});
		btnOption.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnOption.setBorder(new BevelBorder(BevelBorder.RAISED));
		btnOption.setBackground(SystemColor.activeCaptionBorder);
		btnOption.setBounds(206, 55, 186, 33);
		contentPane.add(btnOption);
	}
}
