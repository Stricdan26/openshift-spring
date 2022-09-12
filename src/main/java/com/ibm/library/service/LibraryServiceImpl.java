package com.ibm.library.service;

import com.ibm.library.model.Book;
import com.ibm.library.repo.LibraryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryServiceImpl implements LibraryService {
	
	@Autowired
	private LibraryRepo libraryRepo;


	@Override
	public Book createBook(Book book) {
		return libraryRepo.save(book);
	}

	@Override
	public Long deleteBook(String isbn) {
		return libraryRepo.deleteByIsbn(isbn);
	}

	@Override
	public List<Book> getAllBooksWithPagination(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);

		return libraryRepo.findAll(pageable).getContent();
	}

	@Override
	public List<Book> getAllBooks() {
		return libraryRepo.findAll();
	}

	@Override
	public List<Book> getAllBooksSorted() {
		/*
		 Can plug this into `libraryRepo.findAll(...)` to customize sort
		 Sort sort = Sort.by("author").ascending();
		 */

		return libraryRepo.findAllByOrderByAuthorAsc();
	}


	@Override
	public Book getBookById(String id) {
		return libraryRepo.findById(id).get();
	}

	@Override
	public List<Book> getBookByGenre(String genre) {
		return libraryRepo.findByGenre(genre);
	}

	@Override
	public List<Book> getBookByAuthorOrGenre(String author, String genre) {
		return libraryRepo.findByAuthorOrGenre(author, genre);
	}

}