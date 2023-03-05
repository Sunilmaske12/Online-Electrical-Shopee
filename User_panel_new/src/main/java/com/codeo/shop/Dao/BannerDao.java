package com.codeo.shop.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.codeo.shop.dbutil.ConnectionProvider;
import com.codeo.shop.entity.Banner;
import com.codeo.shop.entity.Product;

public class BannerDao {
	
	static Connection con=ConnectionProvider.getconnection();
	static PreparedStatement psmt=null;
	public static boolean addBanner(Banner banner) {
		boolean flag=false;
		
		
	String insert_query="insert into Banner (B_Name, Status, Banner_Image) values (?,?,?)";
		try {
			
			if(con!=null) {
				psmt=con.prepareStatement(insert_query);
				if(psmt!=null) {
					psmt.setString(1, banner.getBanner_name());
					psmt.setString(2, banner.getAction());
					psmt.setString(3, banner.getBanner_image());
				}
				int result=psmt.executeUpdate();
				flag=true;
			}
			
			
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return flag;
	}

	public static boolean delete(int id) throws SQLException {
		boolean flag=false;
		String delete_query="delete from banner where B_Id="+id;
		if(con!=null) {
			psmt=con.prepareStatement(delete_query);
			psmt.executeUpdate();
			flag=true;
			
		}
		return flag;
	}
	
	
	
	//get all banners
	 public List <Banner> getAllBanner()
		{
			List<Banner> list = new ArrayList<Banner>();
			Banner banner = null;
		
	try {
		String select_banner="select * from banner";
		Statement statement = con.createStatement();
		ResultSet resultset =null;
		resultset =statement.executeQuery(select_banner);
		//prod_id, prod_name, prod_description, prod_price, prod_discount, prod_quantity, prod_imageName
		while(resultset.next())
		{
			banner = new Banner();
			banner.setBanner_no(resultset.getInt("B_Id"));
			banner.setBanner_name(resultset.getString("B_Name"));
			banner.setDate(resultset.getString("Date"));
			banner.setAction(resultset.getString("Status"));
			banner.setBanner_image(resultset.getString("Banner_Image"));
		    list.add(banner);
		}
	} 
	catch (SQLException e) {
		e.printStackTrace();
	}
		return list;
		}

	public static boolean edit(int id, String b_name,String B_Image) throws SQLException {
		boolean flag=false;
		String update_query="update banner set  Status='b_Image'  where B_Id="+id;
		if(con!=null) {
			psmt=con.prepareStatement(update_query);
			psmt.executeUpdate();
			flag=true;
			
		}
		return flag;
	}
	
	
	public Banner getBannerById(int B_id) {
	    Connection con = ConnectionProvider.getconnection();
	    PreparedStatement stmt = null;
	    Banner banner = new Banner();

	    try {
	        stmt = con.prepareStatement("SELECT * FROM banner WHERE B_id= ?");
	        stmt.setInt(1, B_id);
	        ResultSet rs = stmt.executeQuery();

	        if (rs.next()) {
	           banner.setBanner_no(rs.getInt("B_Id"));
	           banner.setBanner_name(rs.getString("B_Name"));
	           banner.setBanner_image(rs.getString("Banner_Image"));
	           banner.setAction(rs.getString("Status"));
	          
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return banner;
	}

	public boolean activeBanner(String b_id) throws SQLException {
		boolean flag=false;
		String query="update banner set Status='Active' where B_Id="+b_id;
		psmt=con.prepareStatement(query);
		int result=psmt.executeUpdate();
		if(result!=0) {
			flag=true;
		}
		return flag;
	}
	
	public boolean inactiveBanner(String b_id) throws SQLException {
		boolean flag=false;
		String query="update banner set Status='In-Active' where B_Id="+b_id;
		psmt=con.prepareStatement(query);
		int result=psmt.executeUpdate();
		if(result!=0) {
			flag=true;
		}
		return flag;
	}

}
