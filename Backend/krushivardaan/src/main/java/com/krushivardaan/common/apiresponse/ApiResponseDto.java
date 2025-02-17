package com.krushivardaan.common.apiresponse;

import lombok.Data;

@Data

public class ApiResponseDto<T, R> {

	private T inputDate;

	private R data;

}
