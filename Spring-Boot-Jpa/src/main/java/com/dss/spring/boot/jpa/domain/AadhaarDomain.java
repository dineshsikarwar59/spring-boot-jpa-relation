package com.dss.spring.boot.jpa.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="aadhaar")
public class AadhaarDomain {
	
	@Id
	@Column(name="aadhaar_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long aadhaarId;
	
	@Column(name="aadhaar_number")
	private String aadhaarNumber;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id")
	private UserDomain user;

}
