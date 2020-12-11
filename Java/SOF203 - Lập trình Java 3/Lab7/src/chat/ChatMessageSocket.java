package chat;

import java.awt.Font;
import java.awt.FontMetrics;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JTextPane;


public class ChatMessageSocket {
	private String name;
	private Socket socket;
	private JTextPane txtMessage;
	private PrintWriter out;
	private BufferedReader read;
	
	public ChatMessageSocket(String name, Socket socket, JTextPane txtMessage) throws IOException {
		super();
		this.name = name;
		this.socket = socket;
		this.txtMessage = txtMessage;
		
		out = new PrintWriter(socket.getOutputStream());
		read = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		receive();
	}
	
	public void receive() {
		Thread th = new Thread() {
			public void run() {
				while(true) {
					String line;
					try {
						line = read.readLine();
						JFrame frame = new JFrame();
						frame.setFont(new Font("Consolas", Font.PLAIN, 14));
						Font f = frame.getFont();
						FontMetrics fm = frame.getFontMetrics(f);
						int w = txtMessage.getWidth() -2;
						int wLine = fm.stringWidth(line);
						int y = fm.stringWidth(" ");
						int wRong = (w - wLine);
						int wChuoi = wRong / y;
						String pad = " ";
						pad = String.format("%"+wChuoi+"s", pad);
						if(line != null) {
							txtMessage.setText(txtMessage.getText() + "\n" + pad + line);
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		th.start();
	}
	
	public void send(String message) {
		String current = txtMessage.getText();
		txtMessage.setText(current + "\n" + name + ": " + message);
		out.println(message + " :" + name);
		out.flush();
	}
	
	public void close() {
		out.close();
		try {
			read.close();
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
