package com.dss.spring.boot.jpa.mapper;

import org.springframework.stereotype.Component;

import com.dss.spring.boot.jpa.domain.AadhaarDomain;
import com.dss.spring.boot.jpa.dto.AadhaarDTO;

@Component
public class AadhaarMapper {
	
	public AadhaarDTO toDTO(AadhaarDomain domain) {
		return AadhaarDTO.builder().aadhaarId(domain.getAadhaarId()).aadhaarNumber(domain.getAadhaarNumber()).build();
	}
	
	public AadhaarDomain toDomain(AadhaarDTO dto) {
		return AadhaarDomain.builder().aadhaarId(dto.getAadhaarId()).aadhaarNumber(dto.getAadhaarNumber()).build();
	}
	

}
