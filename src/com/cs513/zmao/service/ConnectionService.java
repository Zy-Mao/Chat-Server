package com.cs513.zmao.service;

import com.cs513.zmao.entity.ClientInfo;
import com.cs513.zmao.entity.ClientList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Vector;

public class ConnectionService {

	public static String readData(Socket inputSocket) {
		BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(new InputStreamReader(inputSocket.getInputStream()));
			String s = bufferedReader.readLine();
			System.out.println("Read input: " + s);
			return s;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static boolean sendData(Socket outputSocket, String message) {
		PrintWriter printWriter = null;
		try {
			printWriter = new PrintWriter(outputSocket.getOutputStream(), true);
			printWriter.println(message);
			System.out.println("Write output: " + message);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static String initialUserName(ClientInfo clientInfo, ClientList clientList) {
		String message = readData(clientInfo.getInputSocket());
		if (message.startsWith(ConnectionCode.SET_USERNAME)) {
			String userName = message.substring(3);
			clientInfo.setUsername(userName);
			if (clientList.addClient(clientInfo)) {
				sendData(clientInfo.getOutputSocket(), ConnectionCode.SUCCESS);
				return ConnectionCode.SUCCESS;
			} else {
				sendData(clientInfo.getOutputSocket(), ConnectionCode.RETRY);
				return ConnectionCode.RETRY;
			}
		} else {
			System.out.println("Error: Client did not set user name.");
			return ConnectionCode.ERROR;
		}
	}
}
