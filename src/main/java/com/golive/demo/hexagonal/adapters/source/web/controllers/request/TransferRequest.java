package com.golive.demo.hexagonal.adapters.source.web.controllers.request;

import lombok.Data;

@Data
public class TransferRequest {
    private String sourceAcc;
    private String destinationAcc;
    private long amt;
}
