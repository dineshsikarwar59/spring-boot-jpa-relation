package com.dss.spring.boot.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dss.spring.boot.jpa.dto.AadhaarDTO;
import com.dss.spring.boot.jpa.service.AadhaarService;

@Controller
@RestController
@RequestMapping("/aadhaar")
public class AadhaarController {
	
	@Autowired
	private AadhaarService aadhaarService;
	
	@PostMapping("/create")
	public AadhaarDTO create(@RequestBody AadhaarDTO aadhaarDTO) {
		return aadhaarService.create(aadhaarDTO);
	}
	
	@GetMapping("get/by/{aadhaarId}")
	public AadhaarDTO getById(@PathVariable Long aadhaarId) {
		return aadhaarService.getById(aadhaarId);
	}
	
	@GetMapping("/all")
	public List<AadhaarDTO> getAall(){
		return aadhaarService.getAll();
	}

}
