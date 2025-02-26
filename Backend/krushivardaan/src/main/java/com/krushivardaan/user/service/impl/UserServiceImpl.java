package com.krushivardaan.user.service.impl;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.krushivardaan.common.dto.UserDto;
import com.krushivardaan.errorcodes.GlobleErrorCodes;
import com.krushivardaan.exception.UserException;
import com.krushivardaan.user.entity.User;
import com.krushivardaan.user.repository.UserRepository;
import com.krushivardaan.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDto registerUser(UserDto userDto) {

		Optional<User> updateUser = userRepository.findByEmail(userDto.getEmail());

		if (updateUser.isPresent()) {
			throw new UserException(GlobleErrorCodes.UserErrorCode.U2.getMessage(),
					GlobleErrorCodes.UserErrorCode.U1.toString(), LocalDateTime.now());
		}

		User user = User.builder().firstName(userDto.getFirstName()).lastName(userDto.getLastName())
				.contactNo(userDto.getContactNo()).email(userDto.getEmail()).gender(userDto.getGender())
				.password(userDto.getPassword()).createdBy(LocalDateTime.now()).updatedOn(LocalDateTime.now()).build();

		userRepository.save(user);

		return userDto;
	}

	@Override
	public UserDto updateUser(UserDto userDto) {

		Optional<User> updateUser = userRepository.findByEmail(userDto.getEmail());
		if (updateUser.isEmpty()) {
			throw new UserException(GlobleErrorCodes.UserErrorCode.U1.getMessage(),
					GlobleErrorCodes.UserErrorCode.U1.toString(), LocalDateTime.now());
		}

		User user = updateUser.get();

		user = user.builder().firstName(userDto.getFirstName()).lastName(userDto.getLastName())
				.contactNo(userDto.getContactNo()).gender(userDto.getGender()).updatedOn(LocalDateTime.now()).build();

		userRepository.save(user);

		return userDto;
	}

	@Override
	public String deleteUser(String userName) {
		Optional<User> updateUser = userRepository.findByEmail(userName);
		if (updateUser.isEmpty()) {
			throw new UserException(GlobleErrorCodes.UserErrorCode.U1.getMessage(),
					GlobleErrorCodes.UserErrorCode.U1.toString(), LocalDateTime.now());
		}

		User user = updateUser.get();

		userRepository.delete(user);
		return "Delete User + " + userName;

	}

	@Override
	public String changeUserPassword(String email) {

		Optional<User> updateUser = userRepository.findByEmail(email);
		if (updateUser.isEmpty()) {
			throw new UserException(GlobleErrorCodes.UserErrorCode.U1.getMessage(),
					GlobleErrorCodes.UserErrorCode.U1.toString(), LocalDateTime.now());
		}

		User passwordUpdateduser = updateUser.get();

		passwordUpdateduser = passwordUpdateduser.builder().password(email).build();

		userRepository.save(passwordUpdateduser);

		return "Password change Successful  " + email;
	}

}
