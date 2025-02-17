package com.krushivardaan.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobleException {

	@ExceptionHandler(value = UserException.class)
	public ResponseEntity<ErrorDto> handleUserException(UserException userException) {

		ErrorDto errorDto = new ErrorDto(userException.getMessage(), "", LocalDateTime.now());

		return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
	}
}
