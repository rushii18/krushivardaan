package com.krushivardaan.user.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
public class User {

	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Id
	private Long id;

	@Column(name = "frist_Name")
	private String fristName;

	@Column(name = "last_Name")
	private String lastName;

	@Column(name = "contact_No")
	private String contactNo;

	@Column(name = "email_User")
	private String email;

	@Column(name = "gender_User")
	private String gender;

	@Column(name = "createdby")
	private LocalDateTime createdBy;

	@Column(name = "updatedOn")
	private LocalDateTime updatedOn;

}
