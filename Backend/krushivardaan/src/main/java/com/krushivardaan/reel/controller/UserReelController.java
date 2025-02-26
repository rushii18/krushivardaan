package com.krushivardaan.reel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krushivardaan.common.apiresponse.ApiResponseDto;
import com.krushivardaan.common.dto.UserReelDto;
import com.krushivardaan.reel.service.UserReelService;

@RestController
@RequestMapping("/reel")
public class UserReelController {

	@Autowired
	private UserReelService userReelService;

	@PostMapping("create/user")
	public ResponseEntity<ApiResponseDto<String, UserReelDto>> getCreateReel(@RequestBody UserReelDto userReelDto) {

		ApiResponseDto ap = new ApiResponseDto();
		ap.setInputDate(userReelDto);

		ap.setData(userReelService.createReel(userReelDto));

		return new ResponseEntity<>(ap, HttpStatus.OK);
	}
}
