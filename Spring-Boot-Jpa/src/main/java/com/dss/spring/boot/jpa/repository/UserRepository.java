package com.dss.spring.boot.jpa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dss.spring.boot.jpa.domain.UserDomain;

@Repository
public interface UserRepository extends JpaRepository<UserDomain, Long>{
	
	@Query("SELECT u FROM UserDomain u WHERE u.id = :userId")
	Optional<UserDomain> findByIdWithoutFetchingRoles(@Param("userId") Long userId);


}
