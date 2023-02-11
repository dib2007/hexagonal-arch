package golive.demo.hexagonal.adapters.incoming.web.controllers.request;

import lombok.Data;

@Data
public class TransferRequest {
    private String sourceAcc;
    private String destinationAcc;
    private long amt;
}
