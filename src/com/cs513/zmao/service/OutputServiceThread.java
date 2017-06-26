package com.cs513.zmao.service;

import com.cs513.zmao.entity.ClientInfo;
import com.cs513.zmao.entity.ClientList;

import java.net.Socket;
import java.util.Vector;

public class OutputServiceThread extends Thread {
	private Socket socket;
	private ClientInfo clientInfo = null;
	private ClientList clientList;

	public OutputServiceThread(Socket socket, ClientInfo clientInfo, ClientList clientList) {
		this.socket = socket;
		this.clientInfo = clientInfo;
		this.clientList = clientList;
	}

	public void run() {
		this.initialConnection();
		while (true) {

		}
	}

	private void initialConnection() {
		ConnectionService.sendData(this.getSocket(), ConnectionCode.SUCCESS);
		if (clientInfo.getUsername() == null) {
			while (true) {
				String returnedCode = ConnectionService.initialUserName(this.getClientInfo(), this.getClientList());
				if (returnedCode.equals(ConnectionCode.SUCCESS)) {
					break;
				} else if (!returnedCode.equals(ConnectionCode.RETRY)){
					//Close connection.
					System.exit(-1);
					break;
				}
			}
			System.out.println("Client user name sets as " + this.getClientInfo().getUsername());
			InputServiceThread inputServiceThread = new InputServiceThread(
					this.getClientInfo().getInputSocket(), this.getClientInfo(), this.getClientList());
			inputServiceThread.start();
		}
	}

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	public ClientInfo getClientInfo() {
		return clientInfo;
	}

	public void setClientInfo(ClientInfo clientInfo) {
		this.clientInfo = clientInfo;
	}

	public ClientList getClientList() {
		return clientList;
	}

	public void setClientList(ClientList clientList) {
		this.clientList = clientList;
	}
}
