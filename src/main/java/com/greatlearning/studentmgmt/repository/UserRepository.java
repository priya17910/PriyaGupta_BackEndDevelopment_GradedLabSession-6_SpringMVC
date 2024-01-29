package com.greatlearning.studentmgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.greatlearning.studentmgmt.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	//@Query("select u from User u where u.username = ?1")
	User findByUsername(String username);
}
