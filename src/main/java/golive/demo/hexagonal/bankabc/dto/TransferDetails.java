package golive.demo.hexagonal.bankabc.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TransferDetails {
    private String transactionId;
    private String sourceAccountNo;
    private String destinationAccountNo;
    private long amount;
    private TransferState transferState;
}
