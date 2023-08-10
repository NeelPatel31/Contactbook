package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import com.entity.Contact;
import com.mysql.cj.protocol.Resultset;

public class ContactDAO {
	private Connection conn;

	public ContactDAO(Connection conn) {
		super();
		this.conn = conn;
	} 
	
	public boolean saveContact(Contact c) {
		boolean f = false;
		
		try {
			String sql="insert into contact(name,email,phno,about,userid) values(?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, c.getName());
			ps.setString(2, c.getEmail());
			ps.setString(3, c.getPhno());
			ps.setString(4, c.getAbout());
			ps.setInt(5, c.getUserId());
			
			
			int i = ps.executeUpdate();
			if(i==1) {
				f=true;
			}
			
		} catch (Exception e) {
			System.out.println("ContactDAO: Problem occurred");
		}
		
		return f;
	}
	
	public List<Contact> getAllContacts(int uId){
		List<Contact> list = new ArrayList<Contact>();
		Contact c = null;
		try {
			String sql = "select * from contact where userid=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, uId);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				c = new Contact();
				c.setId(rs.getInt(1));
				c.setName(rs.getString(2));
				c.setEmail(rs.getString(3));
				c.setPhno(rs.getString(4));
				c.setAbout(rs.getString(5));
				
				list.add(c);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		return list;
	}
	
	
	
	
	public Contact getContactById(int cid) {
		Contact c = new Contact();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from contact where id=?");
			ps.setInt(1, cid);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				c.setId(rs.getInt(1));
				c.setName(rs.getString(2));
				c.setEmail(rs.getString(3));
				c.setPhno(rs.getString(4));
				c.setAbout(rs.getString(5));
			}
			
		} catch (Exception e) {
			System.out.println("ContactDAO: getContactById: Problem");
		}
		System.out.println("ContactDAO: Contact fatched...");
		return c;
	}
	
	
	public boolean updateContact(Contact c) {
		boolean f = false;
		try {
			System.out.println("ContactDAO: In updateContact funtion...");
			String sql = "update contact set name=?, email=?, phno=?, about=? where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, c.getName());
			ps.setString(2, c.getEmail());
			ps.setString(3, c.getPhno());
			ps.setString(4, c.getAbout());
//			String idString = String(c.getId());
			ps.setInt(5, c.getId());
			System.out.println(c.getName()+" "+c.getEmail()+" "+c.getPhno()+" "+c.getAbout()+" "+c.getId());
			System.out.println("ContactDAO: In updateContact funtion...");
			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
				System.out.println("value is true::::::");
			}
			System.out.println("value is false:::::");
		} catch (Exception e) {
			System.out.println("ContactDAO: updateContact : Problem occurred");
		}
		System.out.println("ContactDAO: End of the updateContact function...");
		return f;
	}

	public boolean deleteContactById(int id) {
		boolean f = false;
		
		try {
			String sql = "delete from contact where id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			
			int i = ps.executeUpdate();
			if(i==1) {
				f = true;
			}
			
		} catch (Exception e) {
			System.out.println("deletContactbyId: catch "+e.getMessage());
		}
		
		return f;
	}
	
	
	
	
	
}
