package com.springBoot.jsp.OES.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springBoot.jsp.OES.dao.UserRepository;
import com.springBoot.jsp.OES.entity.User;


@Service
public class UserServicesImpl implements UserServices {
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void saveUser(User user) {
             userRepository.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public void deleteUserById(int id) {
		userRepository.deleteById(id);		
	}

	@Override
	public int getNewUserCount() {
		List<User> newUser = userRepository.findByseen("No");
		return newUser.size();
	}

	@Override
	public int getUserCount() {
		List<User> allUser=userRepository.findAll();
		return allUser.size();
	}

}
