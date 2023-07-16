package com.springBoot.jsp.OES.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springBoot.jsp.OES.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}

