package com.springBoot.jsp.OES.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springBoot.jsp.OES.entity.chat;

public interface ChatRepository extends JpaRepository<chat, Integer> {

	List<chat> findByseen(String string);
	
}
