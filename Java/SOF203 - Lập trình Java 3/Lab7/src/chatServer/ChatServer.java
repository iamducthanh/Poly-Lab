package chatServer;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import chat.ChatMessageSocket;
import chatClient1.ChatClient1;

public class ChatServer extends JFrame {

	private JPanel contentPane;
	private JTextField textPort;
	private JTextField textField_1;
	ChatMessageSocket chatMessageSocket;
	JTextPane textPane = new JTextPane();
	public JTextField txtName = new JTextField();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChatServer frame = new ChatServer();
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
	ActionListener send = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(!textField_1.getText().isBlank()) {
				chatMessageSocket.send(textField_1.getText());
			}
		}
	};
	
	public ChatServer() {
		setTitle("Chat Server");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Port No:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(24, 23, 62, 20);
		contentPane.add(lblNewLabel);
		
		txtName.setText("Server");
		txtName.setColumns(10);
		txtName.setBounds(216, 25, 95, 23);
		contentPane.add(txtName);
		
		textPort = new JTextField();
		textPort.setText("9888");
		textPort.setBounds(96, 24, 56, 23);
		contentPane.add(textPort);
		textPort.setColumns(10);
		
		JButton btnNewButton = new JButton("Start");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ServerSocket serverSocket = new ServerSocket(Integer.parseInt(textPort.getText()));
					
					Thread th = new Thread() {
						public void run() {
							while(true) {
								textPane.setText(textPane.getText() + "Waiting concection.......");
								Socket socket;
								try {
									socket = serverSocket.accept();
									textPane.setText(textPane.getText() + "Client connected!");
									chatMessageSocket = new ChatMessageSocket(txtName.getText(),socket, textPane);
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
						}
					};
					th.start();
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(321, 24, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblClientSay = new JLabel("Client say:");
		lblClientSay.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblClientSay.setBounds(24, 63, 118, 20);
		contentPane.add(lblClientSay);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 94, 386, 121);
		contentPane.add(scrollPane);
		textPane.setFont(new Font("Consolas", Font.PLAIN, 14));
		
		scrollPane.setViewportView(textPane);
		
		JButton btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textField_1.getText().isBlank()) {
					chatMessageSocket.send(textField_1.getText());
				}
			}
		});
		btnSend.setBounds(320, 229, 89, 23);
		contentPane.add(btnSend);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(24, 230, 288, 23);
		contentPane.add(textField_1);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblName.setBounds(166, 23, 49, 20);
		contentPane.add(lblName);
		textField_1.addActionListener(send);
	}
}
