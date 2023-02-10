package com.codeo.shop.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.codeo.shop.dbutil.ConnectionProvider;
import com.codeo.shop.entity.Category;

public class CategoryDao implements  CategoryInterface {
 
private String List_Category = "select * from add_category"	;
private String add_category = "insert into add_category(catTitle,catDescriptor) values(?,?)";
	
   Connection con = ConnectionProvider.getconnection();
	Category category = null;
	
	//catId, catTitle, catDescriptor
	public List<Category> getCategoryList() {
		List<Category> list = new ArrayList<Category>();
		Statement stmt;
		try {
			stmt = con.createStatement();
			ResultSet rs = null;
			rs = stmt.executeQuery(List_Category);
			
			while(rs.next())
			{  
				int Id = rs.getInt("catId");
				String cat_title=rs.getString("catTitle");
				String cat_description= rs.getString("catDescriptor");
				list.add(new Category( Id, cat_title,  cat_description )) ;
				System.out.println(cat_title+" "+ cat_description);
		}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public boolean editCategory(Category category) {
		
		return false;
	}

	
	public boolean addcategory(Category category) {
		
		PreparedStatement psmt =null;
		boolean flag = false;
		
		if(con!=null)
		{
		  try {
			psmt = con.prepareStatement(add_category);
			if(psmt!=null)
			{
				psmt.setString(1,category.getCat_title());
				psmt.setString(2, category.getCat_description());
			}
			
			int result= psmt.executeUpdate();
			
			flag = true;
	  } catch (SQLException e) {
			e.printStackTrace();
		} }
		return flag;
	}
	
	
  }
