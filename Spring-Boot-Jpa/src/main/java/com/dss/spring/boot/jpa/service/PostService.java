package com.dss.spring.boot.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dss.spring.boot.jpa.domain.PostDomain;
import com.dss.spring.boot.jpa.domain.UserDomain;
import com.dss.spring.boot.jpa.dto.PostDTO;
import com.dss.spring.boot.jpa.repository.PostRepository;
import com.dss.spring.boot.jpa.repository.UserRepository;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private UserRepository userRepository;

	public PostDTO create(PostDTO postDTO) {
		UserDomain user = userRepository.findById(postDTO.getUserId())
				.orElseThrow(() -> new RuntimeException("User not found"));
		PostDomain postDomain = toDomain(postDTO);
		postDomain.setUserId(user.getUserId());
		PostDomain updatedPost = postRepository.save(postDomain);
		return toDTO(updatedPost);
	}

	private PostDomain toDomain(PostDTO postDTO) {
		return PostDomain.builder().postId(postDTO.getPostId()).content(postDTO.getContent()).build();
	}

	private PostDTO toDTO(PostDomain postDomain) {
		return PostDTO.builder().postId(postDomain.getPostId()).content(postDomain.getContent())
				.createdAt(postDomain.getCreatedAt()).updatedAt(postDomain.getUpdatedAt()).build();
	}

}
