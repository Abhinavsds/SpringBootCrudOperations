package application.controller;

import java.util.List;
import java.util.Optional;

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
import application.Repository.BookRepository;
import application.Service.BookService;

@RestController
public class BookController {

	private static final Logger logger=LogManager.getLogger(BookController.class);
	@Autowired
	BookService bookService;

	@Autowired
	BookRepository bookrepo;

	// add book in library
	@RequestMapping(value = "/save")
	private void saveBook(@RequestBody Book book) {
		 
		logger.info("Hello info from Log4j 2 - num : {}", () -> book.getTitle());
		logger.error("Hello error from Log4j 2 - num : {}", () -> book.getTitle());
		logger.fatal("Hello fatal from Log4j 2 - num : {}", () -> book.getTitle());
		logger.debug("Hello debug from Log4j 2 - num : {}", () -> book.getTitle());
		logger.warn("Hello warn from Log4j 2 - num : {}", () -> book.getTitle());
		 
		bookService.addBook(book);
	}

	  
	
	@PutMapping("/book/{title}")
	public ResponseEntity<Book> updateEmployee(@PathVariable(value = "title") String title,
			@RequestBody Book BookDetails) {
		Book book = bookrepo.findByTitle(title);

		book.setAuthor(BookDetails.getAuthor());
		book.setPrice(BookDetails.getPrice());
		final Book updatedBook = bookrepo.save(book);
		return ResponseEntity.ok(updatedBook);
	}

	// fetch book by title
	@RequestMapping(value = "/fetchByTitle/{title}")
	private Book fetchByTitle(@PathVariable String title) {
		return bookService.findByTitle(title);
	}

	@RequestMapping(value = "/pro/{Id}")
	private void procedureResponse(@PathVariable int Id) {
		 System.out.println(bookrepo.getTotalCarsByModel(Id));
	}

	
	// fetch all books
	@RequestMapping(value = "/fetchAll")
	private List<Book> fetchAll() {
		return bookService.findAllBooks();
	}
	
	// fetch all books
		@GetMapping(value = "/fetchbyQuery/{author}")
		private List<Book> fetchbyQuery(@PathVariable String author) {
			return bookrepo.findByAuthor(author);
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
