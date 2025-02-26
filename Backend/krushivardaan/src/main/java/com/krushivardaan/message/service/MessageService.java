package com.krushivardaan.message.service;

import com.krushivardaan.message.entity.Message;

import com.krushivardaan.message.messagetype.MessageTypo;

public interface MessageService {

	public Message sendMessage(Long senderId, Long receiverId, String content, MessageTypo type);

	public Message scheduleMessage();

}
