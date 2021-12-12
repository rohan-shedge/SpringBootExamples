package com.rohan.httpMethods.inmemory;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.rohan.httpMethods.dao.Author;

@Entity
@Table(name = "Book123")
public class Book123 {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	
	private String    author;
	
	public Book123() {
		super();
	}

	public Book123(int id, String  name, String author) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String  getName() {
		return name;
	}
	public void setName(String  name) {
		this.name = name;
	}
	public String  getAuthor() {
		return author;
	}
	public void setAuthor(String  author) {
		this.author = author;
	}
}
