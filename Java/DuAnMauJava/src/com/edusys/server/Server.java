package com.edusys.server;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Server extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	JTextArea textArea = new JTextArea();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Server frame = new Server();
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
	public Server() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setBounds(10, 77, 96, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setBounds(128, 77, 96, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setBounds(234, 77, 96, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		JLabel lblNewLabel = new JLabel("IP");
		lblNewLabel.setBounds(10, 52, 49, 14);
		contentPane.add(lblNewLabel);

		JLabel lblPost = new JLabel("POST");
		lblPost.setBounds(128, 52, 49, 14);
		contentPane.add(lblPost);

		JLabel lblNewLabel_2 = new JLabel("IP");
		lblNewLabel_2.setBounds(234, 52, 49, 14);
		contentPane.add(lblNewLabel_2);

		JButton btnNewButton = new JButton("Start");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				start1();
			}
		});
		btnNewButton.setBounds(20, 108, 89, 23);
		contentPane.add(btnNewButton);

		textArea.setBounds(20, 157, 406, 82);
		contentPane.add(textArea);
	}

	Thread thread;

	public void start1() {
        SocketListen socketListen = new SocketListen();
        socketListen.start();
	}
}
