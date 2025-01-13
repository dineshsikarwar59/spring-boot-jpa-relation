package com.dss.spring.boot.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dss.spring.boot.jpa.domain.AadhaarDomain;
import com.dss.spring.boot.jpa.domain.UserDomain;
import com.dss.spring.boot.jpa.dto.AadhaarDTO;
import com.dss.spring.boot.jpa.mapper.AadhaarMapper;
import com.dss.spring.boot.jpa.repository.AadhaarRepository;
import com.dss.spring.boot.jpa.repository.UserRepository;

@Service
public class AadhaarService {

	@Autowired
	private AadhaarRepository aadhaarRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AadhaarMapper aadhaarMapper;

	public AadhaarDTO create(AadhaarDTO aadhaarDTO) {
		UserDomain userDomain = userRepository.findById(aadhaarDTO.getUserId())
				.orElseThrow(() -> new RuntimeException("User Not Found"));
		AadhaarDomain aadhaardomain = aadhaarMapper.toDomain(aadhaarDTO);
		aadhaardomain.setUser(userDomain);
		AadhaarDomain updatedAadhaar = aadhaarRepository.save(aadhaardomain);
		return aadhaarMapper.toDTO(updatedAadhaar);
	}

	public AadhaarDTO getById(Long aadhaarId) {
		AadhaarDomain aadhaarDomain = aadhaarRepository.findById(aadhaarId)
				.orElseThrow(() -> new RuntimeException("Aadhaar not found"));
		return aadhaarMapper.toDTO(aadhaarDomain);
	}

	public List<AadhaarDTO> getAll() {
		List<AadhaarDomain> domains = aadhaarRepository.findAll();
		return domains.stream().map(aadhaarMapper::toDTO).toList();
	}

}
