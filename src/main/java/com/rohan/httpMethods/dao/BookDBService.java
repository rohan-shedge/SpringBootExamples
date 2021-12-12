package com.rohan.httpMethods.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookDBService {
	

	@Autowired
	BookDBRepository bookdbrepository;

	
	public Optional<Book> getBookById(int bookId) {
		return bookdbrepository.findById(bookId);
	}

	public Book addBook(Book book) {
		book = bookdbrepository.save(book);
		return book;
	}

	public List<Book> deleteBook(int bid) {
		try {
		bookdbrepository.deleteById(bid);
		}catch (Exception e) {
			System.out.println(e);
		}
		return bookdbrepository.findAll();
	}

	public Book updateBook(int bookId, Book book) {
		book.setId(bookId);
		return bookdbrepository.save(book);
	}

	public List<Book> getBooks() {
		List<Book> books = bookdbrepository.findAll();
		return books;
	}

}
