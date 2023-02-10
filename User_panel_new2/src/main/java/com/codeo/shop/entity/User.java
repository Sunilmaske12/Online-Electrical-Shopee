package com.codeo.shop.entity;

public class User {

      private int id = 0;
      private String user_name=null;
      private String user_mobno = null;
      private String user_adderess = null;
      private String user_emailid= null;
      private String user_pass=null;
	  private String  user_type =null;
	
    /*
	public User(String user_name, String user_mobno, String user_adderess, String user_emailid, String user_pass) {
		super();
		this.user_name = user_name;
		this.user_mobno = user_mobno;
		this.user_adderess = user_adderess;
		this.user_emailid = user_emailid;
		this.user_pass = user_pass;
	}
*/
	public User() {
	
		
	}

	public User(String user_emailid, String user_pass, String user_type) {
		this.user_emailid = user_emailid;
		this.user_pass = user_pass;
		this.user_type = user_type;
	}

	public User(String user_name, String user_mobno, String user_adderess, String user_emailid, String user_pass,
			String user_type) {
		this.user_name = user_name;
		this.user_mobno = user_mobno;
		this.user_adderess = user_adderess;
		this.user_emailid = user_emailid;
		this.user_pass = user_pass;
		this.user_type = user_type;
	}

		public User(int id, String user_name, String user_mobno, String user_adderess, String user_emailid,String user_pass) {
		this.id=id;
		this.user_name = user_name;
		this.user_mobno = user_mobno;
		this.user_adderess = user_adderess;
		this.user_emailid = user_emailid;
		this.user_pass = user_pass;
		}

    public String getUser_type() {
		return user_type;
	}

	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_mobno() {
		return user_mobno;
	}

	public void setUser_mobno(String user_mobno) {
		this.user_mobno = user_mobno;
	}

	public String getUser_adderess() {
		return user_adderess;
	}

	public void setUser_adderess(String user_adderess) {
		this.user_adderess = user_adderess;
	}

	public String getUser_emailid() {
		return user_emailid;
	}

	public void setUser_emailid(String user_emailid) {
		this.user_emailid = user_emailid;
	}

	public String getUser_pass() {
		return user_pass;
	}

	public void setUser_pass(String user_pass) {
		this.user_pass = user_pass;
	  }
   }
