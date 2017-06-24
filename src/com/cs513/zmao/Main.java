package com.cs513.zmao;

import com.cs513.zmao.entity.ClientInfo;
import com.cs513.zmao.service.InputServiceThread;
import com.cs513.zmao.service.OutputServiceThread;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class Main {

	public static void main(String[] args) {
        int inputPort = 12345;
		int outputPort = 13456;
        ServerSocket inputServerSocket;
		ServerSocket outputServerSocket;
        Socket inputSocket;
		Socket outputSocket;
		Vector clientList = new Vector<ClientInfo>();

		try {
			inputServerSocket = new ServerSocket(inputPort);
			outputServerSocket = new ServerSocket(outputPort);
			System.out.println("Chat server initial complete.");
			while (true) {
                inputSocket = inputServerSocket.accept();
				outputSocket = outputServerSocket.accept();
				System.out.println("An user connected.");
				ClientInfo clientInfo = new ClientInfo("ip", "user1", inputSocket, outputSocket);
				clientList.add(clientInfo);
				InputServiceThread inputServiceThread = new InputServiceThread(inputSocket, clientInfo, clientList);
				OutputServiceThread outputServiceThread = new OutputServiceThread(outputSocket, clientInfo, clientList);
				inputServiceThread.start();
				outputServiceThread.start();
			}
		} catch (Exception e) {
			System.out.println("Chat server initial failed");
//            System.exit(1);
		}
	}
}
