package com.codeo.shop.Dao;

import java.util.List;
import java.util.Map;
import com.codeo.shop.entity.User;

public interface UserDAO {

	Map<String, Long> user_count = null;
	List<User> selectAllUsers();

	boolean insertUser(User user);

	boolean deleteUser(int id);

	boolean update(User user);
	
	public static Map<String, Long> getUserCount() {
		return user_count;
	}
	//boolean count_user(User user);
	//User edituser(int id);

	User loginDetails(String user_emailid,String user_pass);
   
	
}
