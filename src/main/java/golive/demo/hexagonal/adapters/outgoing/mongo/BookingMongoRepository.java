package golive.demo.hexagonal.adapters.outgoing.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BookingMongoRepository extends MongoRepository<BookingDocument, String>{
    List<BookingDocument> findByUserId(String userId);
}
