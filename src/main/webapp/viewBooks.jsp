<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.cdac.Book" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Book</title>
</head>
<body>

<h1>List Of All Books</h1>

<table border="1">

	<tr>
		<th>ID</th>
		<th>Book Title</th>
		<th>Book Author</th>
		<th>Book Genre</th>
		<th>Published year</th>
	</tr>
	
	<%
    ArrayList<Book> list = (ArrayList<Book>)request.getAttribute("booklist");
	
	if(list != null && !list.isEmpty()){
	for(Book b : list ){
	%>
	
	<tr>
		<td><%= b.getId() %></td>
		<td><%= b.getTitle() %></td>
		<td><%= b.getAuthor() %></td>
		<td><%= b.getGenre() %></td>
		<td><%= b.getYear_published() %></td>
	</tr>
	
	
	<%
	}
	}
	%>
	
</table>


</body>
</html>