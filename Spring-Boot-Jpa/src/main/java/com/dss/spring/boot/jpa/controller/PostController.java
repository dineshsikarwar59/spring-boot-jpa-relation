package com.dss.spring.boot.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dss.spring.boot.jpa.dto.PostDTO;
import com.dss.spring.boot.jpa.service.PostService;

@Controller
@RestController
@RequestMapping("/post")
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@PostMapping("/create")
	public PostDTO create(@RequestBody PostDTO postDTO) {
		return postService.create(postDTO);
	}

}
