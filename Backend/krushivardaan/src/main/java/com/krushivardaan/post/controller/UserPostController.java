package com.krushivardaan.post.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krushivardaan.common.apiresponse.ApiResponseDto;
import com.krushivardaan.common.dto.UserPostDto;
import com.krushivardaan.post.entity.UserPost;
import com.krushivardaan.post.service.UserPostService;

@RestController
@RequestMapping("/post")
public class UserPostController {

	@Autowired
	private UserPostService userPostService;

	@PostMapping("/create/user")
	public ResponseEntity<ApiResponseDto<String, UserPostDto>> postCreate(@RequestBody UserPostDto userPostDto) {

		ApiResponseDto ap = new ApiResponseDto<>();
		ap.setInputDate(userPostDto);
		ap.setData(userPostService.createPost(userPostDto));

		return new ResponseEntity<>(ap, HttpStatus.OK);

	}

}
