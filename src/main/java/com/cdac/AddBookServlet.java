package com.cdac;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AddBookServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		
		res.setContentType("text/html");
		
//		PrintWriter out = res.getWriter();
		
		String title = req.getParameter("title");
		String author = req.getParameter("author");
		String genre = req.getParameter("genre");
		String year = req.getParameter("year");
		
		Book b = new Book(title, author, genre, year);
		
		BookDao bd = new BookDao();
		
		boolean status = false;
		
		try {
			
			status = bd.addBook(b);
			
		} catch (ClassNotFoundException e) 
		{
		
			e.printStackTrace();
			
		} catch (SQLException e) 
		{
			e.printStackTrace();
			
		}
		
		if(status) {
			
			req.setAttribute("book", b);
			
			RequestDispatcher rd = req.getRequestDispatcher("success.jsp");
			
			rd.forward(req, res);
		}
	
		
		
	}

}
