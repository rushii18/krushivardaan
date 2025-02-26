package com.krushivardaan.reel.service.impl;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.krushivardaan.common.dto.UserReelDto;
import com.krushivardaan.errorcodes.GlobleErrorCodes;
import com.krushivardaan.exception.UserException;
import com.krushivardaan.reel.entity.UserReel;
import com.krushivardaan.reel.repository.UserReelRepository;
import com.krushivardaan.reel.service.UserReelService;
import com.krushivardaan.user.entity.User;
import com.krushivardaan.user.repository.UserRepository;

@Service
public class UserReelServiceImpl implements UserReelService {

	@Autowired
	private UserReelRepository userReelRepository;

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserReelDto createReel(UserReelDto UserReelDto) {

		Optional<User> user = userRepository.findByEmail(UserReelDto.getUserName());

		if (user.isEmpty()) {
			throw new UserException(GlobleErrorCodes.UserErrorCode.U1.getMessage(),
					GlobleErrorCodes.UserErrorCode.U1.toString(), LocalDateTime.now());
		}

		UserReel createUserReel = UserReel.builder().caption(UserReelDto.getCaption()).reelUrl(UserReelDto.getReelUrl())
				.user(user.get())
				.timeStamp(LocalDateTime.now()).build();

		userReelRepository.save(createUserReel);

		UserReelDto userReelDtoNew = new UserReelDto();
		userReelDtoNew.setTimeStamp(LocalDateTime.now());
		userReelDtoNew.setUserName(user.get().getEmail());

		BeanUtils.copyProperties(createUserReel, userReelDtoNew);

		return UserReelDto;
	}

}
