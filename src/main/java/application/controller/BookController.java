package application.controller;

import java.util.List;

import org.jboss.logging.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import application.Entity.Book;
import application.Service.BookService;

@RestController
public class BookController {

	@Autowired
	BookService bookService;

	// add book in library
	@RequestMapping(value = "/save")
	private void saveBook(@RequestBody Book book) {
		bookService.addBook(book);
	}

	// fetch book by title
	@RequestMapping(value = "/fetchByTitle/{title}")
	private Book fetchByTitle(@RequestParam String title) {
		return bookService.findByTitle(title);
	}

	// fetch all books
	@RequestMapping(value = "/fetchAll")
	private List<Book> fetchAll() {
		return bookService.findAllBooks();
	}

	// Delete All books
	@RequestMapping(value = "/deleteAll")
	private void deleteAll() {
		bookService.deleteAllBooks();
	}

	// delete book by Id
	@RequestMapping(value = "/deleteById/{id}")
	private void deleteById(@RequestParam int id) {
		bookService.deleteById(id);
	}

}
