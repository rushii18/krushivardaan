package com.krushivardaan.common.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserReelDto {

	private String userName;

	private String caption;

	private LocalDateTime timeStamp;

	private String reelUrl;

}
