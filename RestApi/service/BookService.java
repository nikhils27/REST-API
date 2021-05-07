package com.RestApi.service;

import java.util.List;

import com.RestApi.entity.Book;

public interface BookService {

	 public List<Book> getBooks();
	 
	 public Book getOneBook(long id);
	 
	 public void saveBook(Book book);
	 
	 public void deleteBook(long id);
	 
	 public void updateBook(Book book);
}
