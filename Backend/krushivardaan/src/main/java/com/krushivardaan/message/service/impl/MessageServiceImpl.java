package com.krushivardaan.message.service.impl;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import com.krushivardaan.message.entity.Message;
import com.krushivardaan.message.messagetype.MessageTypo;
import com.krushivardaan.message.repository.MessageRepository;
import com.krushivardaan.message.service.MessageService;
import com.krushivardaan.user.entity.User;
import com.krushivardaan.user.repository.UserRepository;

@Service
class MessageServiceImpl implements MessageService {

	@Autowired
	private MessageRepository messageRepository;

	@Autowired
	private SimpMessagingTemplate messagingTemplate;

	@Autowired
	private UserRepository userRepository;

	// send message to according to id
	public Message sendMessage(Long senderId, Long receiverId, String content, MessageTypo type) {

		Optional<User> sender = userRepository.findById(senderId);

//		sender.setId(senderId);
		Optional<User> receiver = userRepository.findById(receiverId);
//		receiver.setId(receiverId);

		Message message = Message.builder().sender(sender.get()).receiver(receiver.get()).content(content)
				.timestamp(LocalDateTime.now()).build();

		messageRepository.save(message);

		// Send message via WebSocket
		messagingTemplate.convertAndSend("/topic/chat/" + receiverId, message);

		return message;
	}

	@Override
	public Message scheduleMessage() {
		// TODO Auto-generated method stub

		return null;
	}

}
