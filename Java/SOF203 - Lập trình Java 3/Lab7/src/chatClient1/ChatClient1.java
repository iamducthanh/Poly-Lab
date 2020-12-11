package chatClient1;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import chat.ChatMessageSocket;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;

public class ChatClient1 extends JFrame {

	private JPanel contentPane;
	private JTextField textPort;
	private JTextField textMess;
	ChatMessageSocket chatMessageSocket;
	JTextPane textPane = new JTextPane();
	private JTextField txtName;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChatClient1 frame = new ChatClient1();
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
			if(!textMess.getText().isBlank()) {
				chatMessageSocket.send(textMess.getText());
			}
		}
	};
	public ChatClient1() {
		setTitle("Chat client");
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
		
		textPort = new JTextField();
		textPort.setText("9888");
		textPort.setBounds(96, 24, 62, 23);
		contentPane.add(textPort);
		textPort.setColumns(10);
		
		JButton btnConnect = new JButton("Connect");
		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Socket socket = new Socket("127.0.0.1", Integer.parseInt(textPort.getText()));
					chatMessageSocket = new ChatMessageSocket(txtName.getText(), socket, textPane);
					textPane.setText(textPane.getText() + "Connected!");
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (UnknownHostException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnConnect.setBounds(320, 23, 89, 23);
		contentPane.add(btnConnect);
		
		JLabel lblClientSay = new JLabel("Server:");
		lblClientSay.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblClientSay.setBounds(24, 63, 118, 20);
		contentPane.add(lblClientSay);
		
		JButton btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!textMess.getText().isBlank()) {
					chatMessageSocket.send(textMess.getText());
				}
			}
		});
		btnSend.setBounds(320, 229, 89, 23);
		contentPane.add(btnSend);
		
		textMess = new JTextField();
		textMess.setColumns(10);
		textMess.setBounds(24, 230, 288, 23);
		contentPane.add(textMess);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 94, 386, 121);
		contentPane.add(scrollPane);
		textPane.setFont(new Font("Consolas", Font.PLAIN, 14));
		
		scrollPane.setViewportView(textPane);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblName.setBounds(168, 23, 51, 20);
		contentPane.add(lblName);
		
		txtName = new JTextField();
		txtName.setText("Th\u00E0nh");
		txtName.setColumns(10);
		txtName.setBounds(220, 23, 90, 23);
		contentPane.add(txtName);
		textMess.addActionListener(send);
	}
}
