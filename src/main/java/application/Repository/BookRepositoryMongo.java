package application.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import application.Entity.BookMongo;

@Repository
public interface BookRepositoryMongo extends MongoRepository<BookMongo, Integer> {

}
