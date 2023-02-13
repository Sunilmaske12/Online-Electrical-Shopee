package com.codeo.shop.Dao;

import java.sql.*;
import java.util.*;
import com.codeo.shop.dbutil.ConnectionProvider;
import com.codeo.shop.entity.User;

public class UserDaoImpl implements UserDAO {

	private static final String INSERT_USER = "insert into user_registration(user_name, user_mobno, user_adderess, user_emailid, user_pass,user_type) values(?,?,?,?,?,?)" ;
	private static final String SELECT_ALL_USERS ="select * from user_registration ";
	private static final String DELETE_USER ="delete from user_registration where user_id= ?";
	//private static final String EDIT_USER = "select user_id, user_name, user_mobno, user_adderess, user_emailid, user_pass from user_registration where user_id=?";
    private static  final String UPDATE_USERS_SQL = "update user_registration set user_name = ?,user_mobno= ?, user_adderess =?,user_emailid =?,user_pass =? where user_id =?";
	
	Connection con = null;
	PreparedStatement preparedstatement = null ;
	
	
	public List<User> selectAllUsers() {
		List<User> users = new ArrayList<>();
		
		
	 	try {
				preparedstatement= con.prepareStatement(SELECT_ALL_USERS);
	            ResultSet resultset = preparedstatement.executeQuery();
				
				while(resultset.next())
				{
					int id = resultset.getInt(1);
					String user_name = resultset.getString(2);
					String	user_mobno = resultset.getString(3);
					String user_adderess = resultset.getString(4);
					String user_emailid = resultset.getString(5);
					String user_pass = resultset.getString(6);
					String user_type = resultset.getString(7);
					users.add(new User(id, user_name , user_mobno , user_adderess, user_emailid , user_pass));
					}
				} catch (SQLException e) {
				e.printStackTrace();
			} 
			return users;
	}
	
	
	
	@Override
	public boolean insertUser(User user) {
	boolean status = false;
	con = ConnectionProvider.getconnection();
		PreparedStatement preparedstatement = null;
		int result = 0;
		if(con != null)
		{
			try {
				preparedstatement = con.prepareStatement(INSERT_USER);
				if(preparedstatement!=null)
				{
					preparedstatement.setString(1, user.getUser_name());
					preparedstatement.setString(2, user.getUser_mobno());
					preparedstatement.setString(3, user.getUser_adderess());
					preparedstatement.setString(4, user.getUser_emailid());
					preparedstatement.setString(5, user.getUser_pass());
					preparedstatement.setString(6, user.getUser_type());
				}
				if(preparedstatement!=null)
				{
					result = preparedstatement.executeUpdate();
				}
				
				if(result!=0)
				{
					System.out.println("data is inserted");
				}
				else
				{
					System.out.println("data is not inserted");
				}
				status = true;
			} catch (SQLException e) {
				
				e.printStackTrace();
			}catch (Exception e) {
				
				e.printStackTrace();
			}
		}
		return status;
		
	}
	@Override
	public boolean deleteUser(int id) {
		
		boolean rowDeleted =false;
		con = ConnectionProvider.getconnection();
		PreparedStatement preparedstatement = null ;
	     try {
			preparedstatement= con.prepareStatement(DELETE_USER);
			 preparedstatement.setInt(1, id);
		     rowDeleted = preparedstatement.executeUpdate() > 0;
     
	     } catch (SQLException e) {
			e.printStackTrace();
		}
	    
	     return rowDeleted;
     }
	@Override
	public boolean update(User user) {
		
		boolean flag = false;
		try {
			con = ConnectionProvider.getconnection();
			PreparedStatement preparedStatement = con.prepareStatement(UPDATE_USERS_SQL);
			preparedStatement.executeUpdate();
			flag = true;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	/*
	// edit user 
	@Override
	public User edituser(int id) {
		
		User user = new User ();
		con = ConnectionProvider.getconnection();
		try {
			Statement stmt = con.createStatement();
			ResultSet resultset = stmt.executeQuery(EDIT_USER);
			if(resultset.next())
			{
				user.setId(resultset.getInt("user_id"));
				user.setUser_name(resultset.getString("user_name"));
				user.setUser_mobno(resultset.getString("user_mobno"));
				user.setUser_adderess(resultset.getString("user_adderess"));
				user.setUser_emailid(resultset.getString("user_emailid"));
				user.setUser_pass(resultset.getString("user_pass"));
		 }
			} catch (SQLException e) {
			
		     e.printStackTrace();
		      }
	    return user;
	}  
	*/

	@Override
	public User loginDetails(String user_emailid, String user_pass) {
		User user = new User ();
		Connection con = ConnectionProvider.getconnection();
		//user_id, user_name, user_mobno, user_adderess, user_emailid, user_pass, user_type
		String login = "select user_emailid,user_pass,user_type from user_registration where ";
		try {
			PreparedStatement ps = con.prepareStatement(login);
		  
			ResultSet rs = ps.executeQuery();
			
			if(rs.next())
			{
				user.setUser_emailid(rs.getString("user_emailid"));
				user.setUser_pass(rs.getString("user_pass"));
				user.setUser_type(rs.getString("user_type"));
			
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
        
		
		return user;
	}
	
	
	public static ResultSet getUserDetails(String user_emailid, String user_pass) throws Exception {
		
		Connection con = null;
		con = ConnectionProvider.getconnection();
		
		String query= "select * from user_registration where user_emailid=? and user_pass=?";
		 PreparedStatement ps = con.prepareStatement(query);
		 ps.setString(1,user_emailid );
            ps.setString(2, user_pass);
            ResultSet rs = ps.executeQuery();
		
            return rs;
	
	}
	
	public  static Map<String, Long> total_user() throws SQLException{
		Connection con = null;
		con = ConnectionProvider.getconnection();
		
		String count_query= "select Count(*) from user_registration";
		 PreparedStatement ps;
		
			ps = con.prepareStatement(count_query);
		
		 ResultSet rs = ps.executeQuery();
		 Long usercount = null;
		 while(rs.next()) {
			  usercount=rs.getLong(1);
		 }
		Map<String, Long>  map=new HashMap<String, Long>();
		map.put("Total_User", usercount);
		return map;
				
	}
	
	}


	/*
	public static ResultSet validateUser(String user_emailid, String user_pass, String user_type) {
		
		Connection con = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		con = ConnectionProvider.getconnection();
		String sql = "select * from user_registration where user_emailid=? and user_pass=?";
		try {
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, user_emailid);
			preparedStatement.setString(2, user_pass);
			
			resultSet = preparedStatement.executeQuery();
			
			return resultSet;
			
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
			if (preparedStatement != null) {
			preparedStatement.close();
			}
			if (con != null) {
			con.close();
			}
			}
			catch (SQLException e) {
				e.printStackTrace();
				}
				}
		return resultSet;
	}
}
*/
	/*
	public boolean delete(int id) {
		 boolean status = false;
		con = ConnectionProvider.getconnection();
		
		  PreparedStatement preparedStatement;
		try {
			preparedStatement = con.prepareStatement(DELETE_USER);
			preparedStatement.executeUpdate();
			status =true;
           
		} catch (SQLException e) {
			e.printStackTrace();
		}
			  return true;
		}   */
	
	//for login user and admin
	
	