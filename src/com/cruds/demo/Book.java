package com.cruds.demo;

import java.util.List;

public class Book {
	
		
		private int ISBN;
		private String title;
		private String category;
		private int NoOfBooks;
		private Author author;
		
		public Book(int iSBN) {
			super();
			ISBN = iSBN;
		}

		public Book(int iSBN, String title, String category, int noOfBooks, Author author) {
			super();
			ISBN = iSBN;
			this.title = title;
			this.category = category;
			NoOfBooks = noOfBooks;
			this.author = author;
		}

		public Book() {
			// TODO Auto-generated constructor stub
		}

		public int getISBN() {
			return ISBN;
		}

		public void setISBN(int iSBN) {
			ISBN = iSBN;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getCategory() {
			return category;
		}

		public void setCategory(String category) {
			this.category = category;
		}

		public int getNoOfBooks() {
			return NoOfBooks;
		}

		public void setNoOfBooks(int noOfBooks) {
			NoOfBooks = noOfBooks;
		}

		public Author getAuthor() {
			return author;
		}

		public void setAuthor(Author author) {
			this.author = author;
		}

		@Override
		public String toString() {
			return "Book [ISBN=" + ISBN + ", title=" + title + ", category=" + category + ", NoOfBooks=" + NoOfBooks
					+ ", author=" + author + "]";
		}

		public Book getBook(int i) {
			// TODO Auto-generated method stub
			return null;
		}

		public boolean create1(Book b) {
			// TODO Auto-generated method stub
			return false;
		}

		public boolean create(Student s) {
			// TODO Auto-generated method stub
			return false;
		}

		public boolean create2(Book b) {
			// TODO Auto-generated method stub
			return false;
		}

		public List<Book> getAll() {
			// TODO Auto-generated method stub
			return null;
		}

		public Book getAuthorname(String searchAuthor) {
			// TODO Auto-generated method stub
			return null;
		}

		public Book getCategory(String searchCategory) {
			// TODO Auto-generated method stub
			return null;
		}

		public Book getTitle(String searchTitle) {
			// TODO Auto-generated method stub
			return null;
		}

		public boolean create(Book b) {
			// TODO Auto-generated method stub
			return false;
		}
	

}
