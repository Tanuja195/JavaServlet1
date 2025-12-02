package com.cdac;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookDao {
	
	// book add ke liye method 
	public boolean addBook(Book b) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dac_dbt","root","root");
		
		System.out.println("Got connection Successfully");
		
		String q = "Insert Into books(title,author,genre,year_published) values(?,?,?,?)";
		
		PreparedStatement pmt = con.prepareStatement(q);
		
		pmt.setString(1, b.getTitle());
		pmt.setString(2, b.getAuthor());
		pmt.setString(3, b.getGenre());
		pmt.setString(4, b.getYear());
		
		int row = pmt.executeUpdate();
		
		boolean status = false;
		
		if(row>0) {
			status = true;
		}
		
		return status;
		
	}
	
	//book view ke liye method
	public ArrayList<Book> viewBooks() throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dac_dbt","root","root");
		
		System.out.println("Got connection Successfully");
		
		String q = "Select * from books";
		
		PreparedStatement pmt = con.prepareStatement(q);
		
		ResultSet rs = pmt.executeQuery();
		
		ArrayList<Book> list = new ArrayList<>();
		
		
		while(rs.next()) {
			
			Book b = new Book(
					
					rs.getInt("id"),  // ye name tags database ke attribute se match hona chahiye
					rs.getString("title"),
					rs.getString("author"),
					rs.getString("genre"),
					rs.getInt("year_published")
					
			);
			list.add(b);
				
		}
		
	return  list;	
	}

}
