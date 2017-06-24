package com.cs513.zmao.entity;

import java.net.Socket;

public class ClientInfo {
	private String ip;
	private String username;
	private Socket inputSocket;
	private Socket outputSocket;

	public ClientInfo(String ip, String username, Socket inputSocket, Socket outputSocket) {
		this.ip = ip;
		this.username = username;
		this.inputSocket = inputSocket;
		this.outputSocket = outputSocket;
	}

	public Socket getInputSocket() {
		return inputSocket;
	}

	public void setInputSocket(Socket inputSocket) {
		this.inputSocket = inputSocket;
	}

	public Socket getOutputSocket() {
		return outputSocket;
	}

	public void setOutputSocket(Socket outputSocket) {
		this.outputSocket = outputSocket;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
