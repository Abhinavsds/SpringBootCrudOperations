package application.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.Entity.Book;
import application.Entity.BookMongo;
import application.Repository.BookRepositoryMongo;

@Service
public class BookServiceMongo {

	@Autowired
	BookRepositoryMongo bookRepo;

	// ****************Create OPERATIONS ********************//

	public void addBook(BookMongo book) {
		bookRepo.save(book);
	}

	// ****************READ OPERATIONS ********************//

	public List<BookMongo> findAllBooks() {
		return (List<BookMongo>) bookRepo.findAll();
	}


	// ****************Delete Operations***************//
	public void deleteById(int id) {
		bookRepo.deleteById(id);
	}

	public void deleteAllBooks() {

		bookRepo.deleteAll();
	}

}
