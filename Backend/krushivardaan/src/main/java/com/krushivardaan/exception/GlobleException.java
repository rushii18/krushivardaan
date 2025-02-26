package com.krushivardaan.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobleException {

	@ExceptionHandler(value = UserException.class)
	public ResponseEntity<ErrorDto> handleUserException(UserException userException) {

		ErrorDto errorDto = new ErrorDto(userException.getMessage(), userException.getMessage().toString(),
				LocalDateTime.now());

		return new ResponseEntity<>(errorDto, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();

		// Extracting field errors and customizing error message
		for (FieldError error : ex.getBindingResult().getFieldErrors()) {

			errors.put(error.getField(), error.getDefaultMessage());
		}

		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	}
}
