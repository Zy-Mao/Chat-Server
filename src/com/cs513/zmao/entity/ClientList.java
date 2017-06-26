package com.cs513.zmao.entity;

import java.util.Vector;

public class ClientList extends Vector<ClientInfo>{
	public boolean addClient(ClientInfo clientInfo) {
		ClientInfo cursor;
		int size = this.size();
		for (int i = 0; i < size; i++) {
			cursor = (ClientInfo) this.get(i);
			if (cursor.getUsername().equals(clientInfo.getUsername())) {
				return false;
			}
		}
		this.add(clientInfo);
		return true;
	}
}
