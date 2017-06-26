package com.cs513.zmao.service;

import com.cs513.zmao.entity.ClientInfo;
import com.cs513.zmao.entity.ClientList;

import java.net.Socket;
import java.util.Vector;

public class InputServiceThread extends Thread {
	private Socket socket;
	private ClientInfo clientInfo;
	private ClientList clientList;

	public InputServiceThread(Socket socket, ClientInfo clientInfo, ClientList clientList) {
		this.socket = socket;
		this.clientInfo = clientInfo;
		this.clientList = clientList;
	}

	public void run() {

	}
}
