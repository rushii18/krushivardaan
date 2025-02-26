package com.krushivardaan.post.service.impl;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.krushivardaan.common.dto.UserPostDto;
import com.krushivardaan.errorcodes.GlobleErrorCodes;
import com.krushivardaan.exception.UserException;
import com.krushivardaan.post.entity.UserPost;
import com.krushivardaan.post.repository.UserPostRepository;
import com.krushivardaan.post.service.UserPostService;
import com.krushivardaan.user.entity.User;
import com.krushivardaan.user.repository.UserRepository;

@Service
public class UserPostServiceImpl implements UserPostService {

	@Autowired
	private UserPostRepository userPostRepository;

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserPostDto createPost(UserPostDto userPostDto) {

		Optional<User> user = userRepository.findByEmail(userPostDto.getUserName());

		if (user.isEmpty()) {
			throw new UserException(GlobleErrorCodes.UserErrorCode.U1.getMessage(),
					GlobleErrorCodes.UserErrorCode.U1.toString(), LocalDateTime.now());
		}
		UserPost createUserPostDto = UserPost.builder().caption(userPostDto.getCaption())
				.contentUrl(userPostDto.getContentUrl()).timestamp(LocalDateTime.now()).user(user.get()).build();

		userPostRepository.save(createUserPostDto);

		UserPostDto userPostDtoNew = new UserPostDto();

		BeanUtils.copyProperties(createUserPostDto, userPostDtoNew);

		return userPostDtoNew;
	}

}
