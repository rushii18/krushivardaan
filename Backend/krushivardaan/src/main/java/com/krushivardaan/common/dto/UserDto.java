package com.krushivardaan.common.dto;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;

@Builder
@Data

public class UserDto {

	private String fristName;

	private String lastName;

	private String contactNo;

	private String email;

	private String gender;

	private LocalDateTime createdBy;

	private LocalDateTime updatedOn;

}
