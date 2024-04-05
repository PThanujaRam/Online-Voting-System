package com.klu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.klu.entity.User;
import com.klu.entity.CandidateVoteCount;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByAdharNumber(Long adharNumber);
	User findByUsername(String username);
	
}
