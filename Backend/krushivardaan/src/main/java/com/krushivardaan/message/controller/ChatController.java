package com.krushivardaan.message.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.krushivardaan.common.apiresponse.ApiResponseDto;
import com.krushivardaan.message.entity.Message;
import com.krushivardaan.message.messagetype.MessageTypo;
import com.krushivardaan.message.service.MessageService;

@RestController
@RequestMapping("/chat")
public class ChatController {

	@Autowired
	private MessageService messageService;

	@PostMapping("/send")
	public ResponseEntity<ApiResponseDto<String, Message>> sendMessage(@RequestParam Long senderId,
			@RequestParam Long receiverId, @RequestParam String content,
			@RequestParam(name = "type", defaultValue = "TEXT") MessageTypo type) {

		ApiResponseDto apiResponseDto = new ApiResponseDto<>();

		apiResponseDto.setInputDate(receiverId);

		Message message = messageService.sendMessage(senderId, receiverId, content, type);
		apiResponseDto.setData(message);
		return new ResponseEntity(message, HttpStatus.OK);
	}
}
