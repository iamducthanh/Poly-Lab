package bai1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class DemoSocket {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = new ServerSocket(8888);
			System.out.println("Server is connecting...........");
			Socket socket = serverSocket.accept();
			System.out.println("Server is connect");
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			while(true) {
				double so1 = dis.readDouble();
				double so2 = dis.readDouble();
				System.out.println("2 so nhan duoc: " + so1 + so2);
				double sum = so1 + so2;
				dos.writeDouble(sum);
				dos.flush();
				System.out.println("Tong 2 so la: " + sum);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
