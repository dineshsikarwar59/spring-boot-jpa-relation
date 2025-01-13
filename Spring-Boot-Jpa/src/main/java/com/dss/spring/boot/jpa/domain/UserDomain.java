package com.dss.spring.boot.jpa.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Table(name = "user")
@Entity
public class UserDomain {

	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;

	@Column(name = "user_name")
	private String userName;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "user_role", // Join table name
			joinColumns = @JoinColumn(name = "user_id"), // Foreign key column for Student
			inverseJoinColumns = @JoinColumn(name = "role_id") // Foreign key column for Course
	)
	private Set<RoleDomain> roles = new HashSet<>();

	//Bidirectional
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<AddressDomain> addressDomain = new ArrayList<>();

	//Unidirectional
	@OneToMany(cascade =CascadeType.ALL,fetch = FetchType.LAZY)
	//@JoinColumn(name = "user_id",nullable = false) // Adds a foreign key in the Post table
	private List<PostDomain> posts = new ArrayList<>();
	
	@OneToOne(mappedBy = "user",cascade =CascadeType.ALL,fetch = FetchType.LAZY)
	private AadhaarDomain aadhaar;

}
