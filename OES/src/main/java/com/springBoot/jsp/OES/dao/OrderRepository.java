package com.springBoot.jsp.OES.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springBoot.jsp.OES.entity.Order;
public interface OrderRepository extends JpaRepository<Order, Integer> {

	List<Order> findByseen(String string);
	
	@Query("SELECT SUM(i.Total_Amount) FROM Order i")
	int findSumOfAmount();

}

