package com.dss.spring.boot.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dss.spring.boot.jpa.domain.PostDomain;

@Repository
public interface PostRepository extends JpaRepository<PostDomain, Long> {

}
