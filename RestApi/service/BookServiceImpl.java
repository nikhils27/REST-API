package com.RestApi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RestApi.Dao.BookDao;
import com.RestApi.entity.Book;

@Service
public class BookServiceImpl implements BookService {
 
    @Autowired
    BookDao book;
	
	@Override
	public List<Book> getBooks() {
		
		return this.book.findAll();
	}

	@Override
	public Book getOneBook(long id) {
		//Book b=this.book.getOne(id);
		return this.book.findById(id).get();
	}

	@Override
	public void saveBook(Book book) {
		this.book.save(book);
		
	}

	@Override
	public void deleteBook(long id) {
		this.book.deleteById(id);
	}
	
	@Override
	public void updateBook(Book book) {
		this.book.save(book);
	}
	

}
