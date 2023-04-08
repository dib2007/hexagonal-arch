package golive.demo.hexagonal.adapters.outgoing.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieMongoRepository extends MongoRepository<MovieDocument, String> {

}
