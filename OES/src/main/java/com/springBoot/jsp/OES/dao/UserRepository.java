package com.springBoot.jsp.OES.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springBoot.jsp.OES.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	List<User> findByseen(String string);

}
