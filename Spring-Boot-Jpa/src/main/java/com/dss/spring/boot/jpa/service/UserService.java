package com.dss.spring.boot.jpa.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.hibernate.proxy.HibernateProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dss.spring.boot.jpa.domain.AddressDomain;
import com.dss.spring.boot.jpa.domain.RoleDomain;
import com.dss.spring.boot.jpa.domain.UserDomain;
import com.dss.spring.boot.jpa.dto.AddressDTO;
import com.dss.spring.boot.jpa.dto.RoleDTO;
import com.dss.spring.boot.jpa.dto.UserDTO;
import com.dss.spring.boot.jpa.repository.AadhaarRepository;
import com.dss.spring.boot.jpa.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public UserDTO create(UserDTO userDTO) {
		UserDomain userDomain = new UserDomain();
		userDomain.setUserId(userDTO.getUserId());
		userDomain.setUserName(userDTO.getUserName());
		Set<RoleDomain> roles = new HashSet<>();
		userDTO.getRoles().forEach(role -> {
			RoleDomain roleDomain = new RoleDomain();
			roleDomain.setRoleId(role.getRoleId());
			roleDomain.setRole(role.getRole());
			roles.add(roleDomain);
		});
		userDomain.setRoles(roles);
		List<AddressDomain> address=new  ArrayList<AddressDomain>();
		userDTO.getAddress().forEach(a->{
			AddressDomain addressDomain=new AddressDomain();
			addressDomain.setAddressId(a.getAddressId());
			addressDomain.setCity(a.getCity());
			addressDomain.setUser(userDomain);
			address.add(addressDomain);
		});
		userDomain.setAddressDomain(address);
		UserDomain updatedUser = userRepository.save(userDomain);
		return convertToDTO(updatedUser);
	}

	private UserDTO convertToDTO(UserDomain domain) {
		UserDTO dto=new UserDTO();
		Set<RoleDTO> roles=new HashSet<>();
		dto.setUserId(domain.getUserId());
		dto.setUserName(domain.getUserName());
		domain.getRoles().forEach(role->{
			RoleDTO roleDTO=new RoleDTO();
			roleDTO.setRoleId(role.getRoleId());
			roleDTO.setRole(role.getRole());
			roles.add(roleDTO);
		});
		dto.setRoles(roles);
		List<AddressDTO> address=new ArrayList<>();
		domain.getAddressDomain().forEach(a->{
			AddressDTO addressDTO=new AddressDTO();
			addressDTO.setAddressId(a.getAddressId());
			addressDTO.setCity(a.getCity());
			address.add(addressDTO);
		});
		dto.setAddress(address);
		return dto;
	}


	public UserDTO getById(Long userId) {
		UserDomain domain = userRepository.findById(userId)
				.orElseThrow(() -> new RuntimeException("user is not present"));
		return convertToDTO(domain);
	}

}
