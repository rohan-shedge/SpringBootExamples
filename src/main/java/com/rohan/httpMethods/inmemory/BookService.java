package com.rohan.httpMethods.inmemory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class BookService {

	private List<Book123> books = new ArrayList<>();


	BookService() {
		books.add(new Book123(1, "Modern Java", "Rohan"));
		books.add(new Book123(2, "Modern  Science", "Pradnya"));
		books.add(new Book123(3, "Modern  biology", "Mugu"));
 
	}

	public List<Book123> getBooks() {
		return books;
	}

	public Optional<Book123> getBookById(int id) {
		return books.stream().filter(e -> e.getId() == id).findFirst();
	}

	public Book123 addBook(Book123 book) {
		books.add(book);
		return book;
	}

	public List<Book123> deleteBook(int bid) {
		boolean match = books.stream().anyMatch(b -> b.getId() == bid);
		if (!match) {
			return null;
		}

		books = books.stream().filter(book -> book.getId() != bid).collect(Collectors.toList());
		return books;
	}

	public List<Book123> updateBook(int bookId, Book123 book) {
		List<Book123> booklist = books.stream().map(b -> {
			if (b.getId() == bookId) {
				if (book.getAuthor() != null) {
					b.setAuthor(book.getAuthor());
				}
				if (book.getName() != null) {
					b.setName(book.getName());
				}
			}
			return b;
		}).collect(Collectors.toList());
		return booklist;
	}
}
