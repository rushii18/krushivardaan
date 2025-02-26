package com.krushivardaan.common.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.krushivardaan.post.entity.UserPost;
import com.krushivardaan.reel.entity.UserReel;

import io.micrometer.common.lang.NonNull;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

	@NotBlank(message = "First name is required")
	@Size(min = 2, max = 50, message = "First name must be between 2 and 50 characters")
	private String firstName;

	@NotBlank(message = "Last name is required")
	@Size(min = 2, max = 50, message = "Last name must be between 2 and 50 characters")
	private String lastName;

	@NotBlank(message = "Contact number is required")
	@Pattern(regexp = "^\\d{10}$", message = "Contact number must be 10 digits")
	private String contactNo;

	@NotBlank(message = "Email is required")
	@Email(message = "Invalid email format")
	private String email;

	@NotBlank(message = "Password is required")
	@Size(min = 8, max = 20, message = "Password must be between 8 and 20 characters")
	private String password;

	@NotBlank(message = "Gender is required")
	@Pattern(regexp = "^(Male|Female|Other)$", message = "Gender must be Male, Female, or Other")
	private String gender;

	private LocalDateTime createdBy;

	private LocalDateTime updatedOn;

	private List<UserPost> userPost;
	
	private List<UserReel> userReels;

}
