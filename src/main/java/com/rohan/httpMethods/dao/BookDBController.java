package com.rohan.httpMethods.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class BookDBController {
	
	@Autowired
	private BookDBService bookDbService;
	
	@GetMapping("/db/books")
	public ResponseEntity<List<Book>> getBooks() {
		List<Book> books = bookDbService.getBooks();
		if (books.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
		}
		return ResponseEntity.of(Optional.of(books));
	}
	
	@GetMapping("/db/books/x{id}")
	@ResponseBody
	public ResponseEntity<Book> getBooksById(@PathVariable("id") int id) {
		 Optional<Book> opt = bookDbService.getBookById(id);
		 if (opt.isEmpty()) 
			 return new ResponseEntity<Book>(HttpStatus.NOT_FOUND);
		 return new ResponseEntity<Book>(opt.get(), 
			      HttpStatus.OK);
	}
	
	@PostMapping("/db/books")
 	public Book addBooks(@RequestBody Book book) {
		book = bookDbService.addBook(book);
		return book;
	}
	
	@DeleteMapping("/db/books/{bookId}")
 	public ResponseEntity<?> deleteBooks(@PathVariable("bookId") int bookId) {
		List<Book> books = bookDbService.deleteBook(bookId);
		if (books == null) {
			ResponseEntity<?> responseEntity= ResponseEntity.noContent().build();
			return responseEntity;
		}
		return new ResponseEntity<>(
				books, 
			      HttpStatus.OK);
	}
	
	@PutMapping("/db/books/{bookId}")
 	public Book updateBooks(@PathVariable("bookId") int bookId, @RequestBody Book book) {
		Book  bookList = bookDbService.updateBook(bookId, book);
		return bookList;
	}
}
