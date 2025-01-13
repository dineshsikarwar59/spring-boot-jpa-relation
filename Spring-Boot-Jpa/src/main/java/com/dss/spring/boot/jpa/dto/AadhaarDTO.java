package com.dss.spring.boot.jpa.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class AadhaarDTO {
	
	private Long aadhaarId;
	
	private String aadhaarNumber;
	
	private Long userId;

}
