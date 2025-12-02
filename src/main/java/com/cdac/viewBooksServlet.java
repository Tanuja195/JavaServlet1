package com.cdac;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class viewBooksServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		res.setContentType("text/html");
		
		BookDao bd = new BookDao();
		
		ArrayList<Book> list = null;
		
		try {
			
			list = bd.viewBooks();
		} catch (ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		
		req.setAttribute("booklist", list);
		RequestDispatcher rd = req.getRequestDispatcher("viewBooks.jsp");
		rd.forward(req, res);
		
	}
	
}
