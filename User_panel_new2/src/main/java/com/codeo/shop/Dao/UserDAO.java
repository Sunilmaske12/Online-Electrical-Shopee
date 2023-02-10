package com.codeo.shop.Dao;

import java.sql.ResultSet;
import java.util.List;

import com.codeo.shop.entity.User;

public interface UserDAO {

	List<User> selectAllUsers();

	boolean insertUser(User user);

	boolean deleteUser(int id);

	boolean update(User user);

	//User edituser(int id);

	User loginDetails(String user_emailid,String user_pass);
   
	
}
