package com.dss.spring.boot.jpa.dto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
	
	private Long userId;
	
	private String userName;
	
	private Set<RoleDTO> roles=new HashSet<>();
	
	private List<AddressDTO> address=new ArrayList<>();

}
