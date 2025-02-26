package com.krushivardaan.reel.entity;

import java.time.LocalDateTime;

import com.krushivardaan.user.entity.User;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserReel {

	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Id
	private Long id;

	private String caption;

	private String reelUrl;

	private LocalDateTime timeStamp;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false) // Foreign key reference to User
	private User user;

}
