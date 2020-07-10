package application.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import application.Entity.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {

	public Book findByTitle(String title);
}
