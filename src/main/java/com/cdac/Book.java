package com.cdac;

public class Book {
	int id;
	String title;
	String author;
	String genre;
	String year;
	int year_published;
	//book.html se data aa raha hain 
	public Book(String title, String author, String genre, String year) {
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.year = year;
	}

	//database se data aa raha hain 
	public Book(int id, String title, String author, String genre, int year) {
		
		this.id = id;
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.year_published = year;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getYear_published() {
		return year_published;
	}

	public void setYear_published(int year_published) {
		this.year_published = year_published;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}
	
	

}
