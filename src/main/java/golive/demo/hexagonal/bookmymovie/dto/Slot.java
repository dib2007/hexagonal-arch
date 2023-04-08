package golive.demo.hexagonal.bookmymovie.dto;

import lombok.Data;

@Data
public class Slot {
    private long startTime;
    private long endTime;

    public Slot(long startTime, long endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Slot() {
    }
}
