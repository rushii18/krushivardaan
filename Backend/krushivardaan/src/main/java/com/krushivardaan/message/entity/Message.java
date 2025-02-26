package com.krushivardaan.message.entity;

import java.time.LocalDateTime;

import com.krushivardaan.message.messagetype.MessageTypo;
import com.krushivardaan.user.entity.User;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Message {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	private User sender;

	@ManyToOne
	private User receiver;

	private String content;
	private LocalDateTime timestamp;

	@Enumerated(EnumType.STRING)
	private MessageTypo type; // TEXT, IMAGE, VIDEO
}