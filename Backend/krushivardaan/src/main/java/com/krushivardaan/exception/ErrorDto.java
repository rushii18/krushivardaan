package com.krushivardaan.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDto {

	private String errorMessage;

	private String errorCode;

	private LocalDateTime timeStamp;
}
