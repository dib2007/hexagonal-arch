package golive.demo.hexagonal.adapters.outgoing.mongo;

import golive.demo.hexagonal.bookmymovie.dto.Slot;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document("Movie")
public class MovieDocument {
    @Id
    private String id;
    private String movieName;
    private List<String> actors;
    private List<Slot> slots;
}
