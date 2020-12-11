package bai2;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketDemo {
	public static void main(String[] args) {
		main2();
		try {
			ServerSocket serverSocket = new ServerSocket(8989);
			while(true) {
				Socket clientSocket = serverSocket.accept();
				InputStream inputStream = clientSocket.getInputStream();
				
				int data = 0;
				while(data = inputStream.read() != -1) {
					System.out.println(String.valueOf((char)data));
					data = inputStream.read();
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main2() {
		try {
			Socket socket = new Socket("localhost",8989);
			socket.getOutputStream().write("xin chao".getBytes());
			socket.getOutputStream().flush();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
