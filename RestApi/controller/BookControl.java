package com.RestApi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.RestApi.entity.Book;
import com.RestApi.service.BookService;

@RestController
public class BookControl {
     
	@Autowired
	BookService BookService;
	
	@GetMapping("/book")
	public ResponseEntity<List<Book>> books(){
		
		List<Book> list= this.BookService.getBooks();
		if(list.size()<=0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));
		
	}
	

	@GetMapping("/book/{id}")
	public ResponseEntity<Book> OneBook(@PathVariable("id") long bid){
	
		Book book=this.BookService.getOneBook(bid);
		if(book==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		return ResponseEntity.of(Optional.of(book));	}
	
	@PostMapping("/book")
	public ResponseEntity<Void> SaveBook(@RequestBody Book book)
	{
		try {
			this.BookService.saveBook(book);
		    return ResponseEntity.status(HttpStatus.OK).build();
		
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	
		
	}
	
	
	@DeleteMapping("/book/{id}")
	public ResponseEntity<Void> delBook(@PathVariable("id") long id)
	{
		try {
			this.BookService.deleteBook(id);
			return ResponseEntity.status(HttpStatus.OK).build();
					
		} catch (Exception e) {
		  e.printStackTrace();
		  return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
     //		this.BookService.deleteBook(id);

	}
	
	@PutMapping("/book")
	public ResponseEntity<Void> updateBook(@RequestBody Book book) {
		try {
			this.BookService.updateBook(book);
			return ResponseEntity.status(HttpStatus.OK).build();
		} catch (Exception e) {
			
			e.printStackTrace();
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	
}
