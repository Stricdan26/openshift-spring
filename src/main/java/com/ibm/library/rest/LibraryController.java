package com.ibm.library.rest;

import com.ibm.library.model.Book;
import com.ibm.library.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class LibraryController {

	@Autowired
	private LibraryService libraryService;


	/*#################*/
	/* POST MAPPINGS   */
	/*#################*/

	/**
	 * Creates a book and adds it to the repository
	 * @param book The JSON of the book document to add in the requestbody
	 * @return The book that was added
	 */
	@PostMapping("/create")
	public Book createBook(@RequestBody Book book) {
		return libraryService.createBook(book);
	}


	/*#################*/
	/* GET MAPPINGS   */
	/*#################*/

	/**
	 * Returns all the books in the database
	 * @return A list of all books
	 */
	@GetMapping("/all")
	public List<Book> getAllBooks() {
		return libraryService.getAllBooks();
	}

	@GetMapping("/allPage")
	public List<Book> getAllBooksWithPagination(@RequestParam int pageNo, @RequestParam int pageSize) {
		return libraryService.getAllBooksWithPagination(pageNo, pageSize);
	}

	@GetMapping("/getById/{id}")
	public Book getBookById(@PathVariable("id") String id) {
		return libraryService.getBookById(id);
	}

	@GetMapping("/getByGenre/{genre}")
	public List<Book> getBookByGenre(@PathVariable String genre) {
		return libraryService.getBookByGenre(genre);
	}


	@GetMapping("/getByAuthorOrGenre")
	public List<Book> getBookByAuthorOrGenre(@RequestParam String author, @RequestParam String genre) {
		return libraryService.getBookByAuthorOrGenre(author, genre);
	}

	@GetMapping("/getAllSorted")
	public List<Book> getAllSorted() {
		return libraryService.getAllBooksSorted();
	}

	/*#################*/
	/* DELETE MAPPINGS*/
	/*#################*/

	/**
	 *	Deletes books with the specified ISBN number
	 * @param isbn The isbn of the book to delete
	 * @return Number of documents deleted
	 */
	@DeleteMapping("delete/{isbn}")
	public Long deleteBook(@PathVariable String isbn) {
		return libraryService.deleteBook(isbn);
	}
}
