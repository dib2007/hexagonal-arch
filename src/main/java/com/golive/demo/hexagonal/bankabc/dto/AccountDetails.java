package com.golive.demo.hexagonal.bankabc.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccountDetails {
    private String accNo;
    private String name;
    private String address;
}
