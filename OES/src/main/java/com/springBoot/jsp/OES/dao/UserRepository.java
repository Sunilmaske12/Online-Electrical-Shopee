package com.springBoot.jsp.OES.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springBoot.jsp.OES.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
