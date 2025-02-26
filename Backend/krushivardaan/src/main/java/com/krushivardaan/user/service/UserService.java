package com.krushivardaan.user.service;

import com.krushivardaan.common.dto.UserDto;

public interface UserService {

	public UserDto registerUser(UserDto userDto);

	public UserDto updateUser(UserDto userDto);

	public String deleteUser(String userName);

	public String changeUserPassword(String email);

}
