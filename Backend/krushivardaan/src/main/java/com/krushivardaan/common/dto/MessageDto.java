package com.krushivardaan.common.dto;

import java.time.LocalDateTime;

import com.krushivardaan.message.messagetype.MessageTypo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MessageDto {

	private long sendID;

	private long reciverId;

	private MessageTypo messageTypo;

	private LocalDateTime timestamp;

}
