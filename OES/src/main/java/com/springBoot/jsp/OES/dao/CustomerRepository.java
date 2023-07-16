package com.springBoot.jsp.OES.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springBoot.jsp.OES.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
