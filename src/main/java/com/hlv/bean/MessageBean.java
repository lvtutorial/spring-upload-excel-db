package com.hlv.bean;

import java.util.ArrayList;
import java.util.List;

public class MessageBean {
	protected List<Message> messages;
	public void clearMessages(){
		this.messages=null;
	}
	public List<Message> getMessages() {
		return messages;
	}
	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
	public void addMessage(String status,String message){
		if(messages==null) messages=new ArrayList<Message>();
		messages.add(new Message(status,message));
	}
}
