package com.krushivardaan.user.controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.krushivardaan.common.apiresponse.ApiResponseDto;
import com.krushivardaan.common.dto.UserDto;
import com.krushivardaan.user.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/register/user")
	public ResponseEntity<ApiResponseDto<String, UserDto>> userRegister(@Valid @RequestBody UserDto userDto) {

		ApiResponseDto apiResponseDto = new ApiResponseDto<>();

		apiResponseDto.setInputDate(userDto);
		UserDto createdUser = userService.registerUser(userDto);

		apiResponseDto.setData(createdUser);

		return new ResponseEntity<>(apiResponseDto, HttpStatus.OK);

	}

	@PutMapping("/update/user")
	public ResponseEntity<ApiResponseDto<String, UserDto>> userUpdate(@RequestBody UserDto userDto) {

		ApiResponseDto apiResponseDto = new ApiResponseDto<>();

		apiResponseDto.setInputDate(userDto);
		UserDto updateUser = userService.updateUser(userDto);

		apiResponseDto.setData(updateUser);

		return new ResponseEntity<>(apiResponseDto, HttpStatus.OK);

	}

	@DeleteMapping("/delete/user")
	public ResponseEntity<ApiResponseDto<String, UserDto>> deleteUser(@Valid @RequestParam String email) {

		ApiResponseDto apiResponseDto = new ApiResponseDto<>();

		apiResponseDto.setInputDate(email);
		String deletedUser = userService.deleteUser(email);

		apiResponseDto.setData(deletedUser);

		return new ResponseEntity<>(apiResponseDto, HttpStatus.OK);

	}

}
