package com.rohan.httpMethods.dao;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookDBRepository extends JpaRepository<Book, Integer>{
	
	public Optional<Book> findById(int bookId);
}
