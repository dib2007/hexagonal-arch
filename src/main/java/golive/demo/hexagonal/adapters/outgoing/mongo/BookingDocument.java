package golive.demo.hexagonal.adapters.outgoing.mongo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document("Booking")
public class BookingDocument {
    @Id
    private String id;
    private String userId;
    private String movieId;
    private String movieName;
    private long startTime;
    private long endTime;
    private List<String> seats;
}
