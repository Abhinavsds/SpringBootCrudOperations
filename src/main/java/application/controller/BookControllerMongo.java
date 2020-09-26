package application.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import application.Entity.Book;
import application.Entity.BookMongo;
import application.Repository.BookRepositoryMongo;
import application.Service.BookServiceMongo;

@RestController
@RequestMapping("mongo")
public class BookControllerMongo {

	private static final Logger logger = LogManager.getLogger(BookControllerMongo.class);
	@Autowired
	BookServiceMongo bookService;

	@Autowired
	BookRepositoryMongo bookrepo;

	// add book in library
	@RequestMapping(value = "/save")
	private void saveBook(@RequestBody BookMongo book) {

		logger.info("Hello info from Log4j 2 - num : {}", () -> book.getTitle());
		logger.error("Hello error from Log4j 2 - num : {}", () -> book.getTitle());
		logger.fatal("Hello fatal from Log4j 2 - num : {}", () -> book.getTitle());
		logger.debug("Hello debug from Log4j 2 - num : {}", () -> book.getTitle());
		logger.warn("Hello warn from Log4j 2 - num : {}", () -> book.getTitle());

		bookService.addBook(book);
	}

	// fetch book by title

	// fetch all books
	@RequestMapping(value = "/fetchAll")
	private List<BookMongo> fetchAll() {
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
