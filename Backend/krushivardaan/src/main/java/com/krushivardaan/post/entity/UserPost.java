package com.krushivardaan.post.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.krushivardaan.user.entity.User;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserPost {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	private String contentUrl; // Image/Video URL

	private String caption;

	private LocalDateTime timestamp;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false) // Foreign key reference to User
	private User user;

//	    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
//	    private List<Comment> comments;
//
//	    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
//	    private List<Like> likes;

}
