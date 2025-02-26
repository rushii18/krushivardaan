package com.krushivardaan.common.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserPostDto {

	private String userName;

	private String contentUrl;

	private String caption;

	private LocalDateTime timeStamp;
}
