package com.dss.spring.boot.jpa.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PostDTO {
	
	private Long postId;
	
	private String content;
	
	private Long userId;
	
	private LocalDateTime createdAt;
	
	private LocalDateTime updatedAt;

}
