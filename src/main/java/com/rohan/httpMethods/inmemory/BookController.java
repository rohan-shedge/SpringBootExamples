package com.rohan.httpMethods.inmemory;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/books")
	@ResponseBody
	public ResponseEntity<List<Book123>> getBooks() {
		List<Book123> books = bookService.getBooks();
		if (books.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).build();
		}
		return ResponseEntity.of(Optional.of(books));
	}
	
	@GetMapping("/books/{id}")
	@ResponseBody
	public ResponseEntity<Book123> getBooks(@PathVariable("id") int id) {
		 Optional<Book123> opt = bookService.getBookById(id);
		 if (opt.isEmpty()) 
			 return new ResponseEntity<Book123>(HttpStatus.NOT_FOUND);
		 return new ResponseEntity<Book123>(opt.get(), 
			      HttpStatus.OK);
	}
	
	@PostMapping("/book")
	@ResponseBody
 	public Book123 addBooks(@RequestBody Book123 book) {
		book = bookService.addBook(book);
		return book;
	}
	
	@DeleteMapping("/books/{bookId}")
	@ResponseBody
 	public ResponseEntity<?> deleteBooks(@PathVariable("bookId") int bookId) {
		List<Book123> books = bookService.deleteBook(bookId);
		if (books == null) {
			ResponseEntity<?> responseEntity= ResponseEntity.noContent().build();
			return responseEntity;
		}
		return new ResponseEntity<>(
				books, 
			      HttpStatus.OK);
	}
	
	@PutMapping("/book/{bookId}")
	@ResponseBody
 	public List<Book123> updateBooks(@PathVariable("bookId") int bookId, @RequestBody Book123 book) {
		List<Book123>  bookList = bookService.updateBook(bookId, book);
		return bookList;
	}
}
