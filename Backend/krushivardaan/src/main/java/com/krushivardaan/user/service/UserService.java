package com.krushivardaan.user.service;

import com.krushivardaan.common.apiresponse.ApiResponseDto;
import com.krushivardaan.common.dto.UserDto;
import com.krushivardaan.user.entity.User;

public interface UserService {

	public UserDto registerUser(UserDto userDto);
	
	public UserDto updateUser(UserDto userDto);
	
	public String deleteUser(String userName); 

}
