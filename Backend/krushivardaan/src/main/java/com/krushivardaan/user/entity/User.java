package com.krushivardaan.user.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.krushivardaan.post.entity.UserPost;
import com.krushivardaan.reel.entity.UserReel;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Id
	private Long id;

	private String firstName;

	private String lastName;

	private String contactNo;

	private String email;

	private String password;

	private String gender;

	private LocalDateTime createdBy;

	private LocalDateTime updatedOn;

	// One user can have multiple posts
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserPost> userPosts = new ArrayList<>();

    // One user can have multiple reels
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserReel> userReels = new ArrayList<>();

}
