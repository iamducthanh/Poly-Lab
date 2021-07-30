package com.edusys.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketListen extends Thread{

	@Override
	public void run() {
		// TODO Auto-generated method stub

		try {

			ServerSocket serverSocket = new ServerSocket(4343);
			while(true) {
				Socket socket = serverSocket.accept();
				ThreadSocket threadSocket = new ThreadSocket(socket);
				threadSocket.start();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
