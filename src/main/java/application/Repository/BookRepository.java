package application.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import application.Entity.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {

	public Book findByTitle(String title);
	
//	@Procedure
//	int firstPro(int id);
	
	@Procedure("firstPro")
	String getTotalCarsByModel(int model);
	
	@Procedure("exportToExcel")
	Book getDataById(int id);
	
//	@Query(value="Select * FROM book where author= ?1",nativeQuery = true)  for native query
	@Query("Select bk FROM book bk where author= ?1")   //using jpl query but for thtis we have to name entity aloso as book.
	List<Book> findByAuthor(String author); 


	
}
