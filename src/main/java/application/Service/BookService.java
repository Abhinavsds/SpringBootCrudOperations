package application.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.Entity.Book;
import application.Repository.BookRepository;

@Service
public class BookService {

	@Autowired
	BookRepository bookRepo;

	// ****************Create OPERATIONS ********************//

	public void addBook(Book book) {
		bookRepo.save(book);
	}

	// ****************READ OPERATIONS ********************//

	public List<Book> findAllBooks() {
		return (List<Book>) bookRepo.findAll();
	}

	public Book findByTitle(String title) {
		return bookRepo.findByTitle(title);
	}

	// ****************Delete Operations***************//
	public void deleteById(int id) {
		bookRepo.deleteById(id);
	}

	public void deleteAllBooks() {

		bookRepo.deleteAll();
	}

}
