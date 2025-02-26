package com.krushivardaan.errorcodes;

public class GlobleErrorCodes {

	public enum UserErrorCode {

		U1("USER_NOT_FOUND"), U2("User Already Created");

		private final String message;

		UserErrorCode(String message) {
			this.message = message;

		}

		public String getMessage() {
			return message;
		}

	}
}
