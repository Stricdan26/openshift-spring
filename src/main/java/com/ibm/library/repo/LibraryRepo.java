package com.ibm.library.repo;

import java.util.Collection;
import java.util.List;

import com.ibm.library.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryRepo extends MongoRepository<Book, String> {

	Long deleteByIsbn(String isbn);

	List<Book> findByGenre(String genre);

	List<Book> findByAuthorOrGenre (String author, String genre);

	List<Book> findAllByOrderByAuthorAsc();

}
