package com.dao;

import java.sql.*;

import com.entity.User;
//import com.entity;

public class UserDAO {
	
	private Connection conn;

	public UserDAO(Connection conn) {
		super();
		this.conn = conn;
		// TODO Auto-generated constructor stub
	}
	
	public boolean userRegister(User u) {
		boolean f = false;
		try {
			
			String sql = "insert into user(name,email,password) values(?,?,?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,u.getName());
			ps.setString(2, u.getEmail());
			ps.setString(3, u.getPassword());
			
			int i = -1;
			i = ps.executeUpdate();
			
			if(i==1) {
				f=true;
			}
			else {
				System.out.println(i);
			}
			
		}catch(Exception e) {
			System.out.println("UserDAO: userRegister : Not working.");
			System.out.println(e.getMessage());
		}
		return f;
	}
	
	public User loginUser(String e,String p) {
		User user=null;
		
		try {
			String sql = "select * from user where email=? and password=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,e);
			ps.setString(2,p);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				user = new User();
				user.setId(rs.getInt(1));
				user.setName(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setPassword(rs.getString(4));
			}
		}catch(Exception e2) {
			System.out.println("UserDAO: loginUser : Not working");
			System.out.println(e2.getMessage());
		}
		return user;
	}
	
	
}
