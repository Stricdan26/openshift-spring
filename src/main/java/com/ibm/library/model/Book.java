package com.ibm.library.model;

import com.ibm.library.exception.BadValue;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "book")
public class Book {

	@Id
	public String id;
	@Field(name = "isbn") 	//Not necessary when names match
	public String isbn;
	public String title;
	public String author;
	public String notes;
	public String genre;

	public Book(){

	}
	public Book(String isbn, String title, String author, String genre) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.genre = genre;
	}
	
	public String getIsbn() {
		return isbn;
	}
	
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public double calculateLateFee(int numDaysLate) throws BadValue {
		if (numDaysLate < 0)
			throw new BadValue();
		if (genre.equals("FICTION"))
			return (numDaysLate / 2.0) * 0.75;
		else
			return (numDaysLate / 1.5) * 0.8;
	}
	
}
