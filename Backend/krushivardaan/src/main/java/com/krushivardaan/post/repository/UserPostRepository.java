package com.krushivardaan.post.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.krushivardaan.post.entity.UserPost;

public interface UserPostRepository extends JpaRepository<UserPost, Long> {

}
