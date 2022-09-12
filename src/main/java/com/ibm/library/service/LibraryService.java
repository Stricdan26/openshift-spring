package com.ibm.library.service;

import java.util.List;

import com.ibm.library.model.Book;

public interface LibraryService {

	Book createBook(Book book);

	Long deleteBook(String isbn);

	List<Book> getAllBooks();

	List<Book> getAllBooksSorted();


	List<Book> getAllBooksWithPagination(int pageNo, int pageSize);

	Book getBookById(String id);

	List<Book> getBookByGenre(String genre);

	List<Book> getBookByAuthorOrGenre(String author, String genre);


}
