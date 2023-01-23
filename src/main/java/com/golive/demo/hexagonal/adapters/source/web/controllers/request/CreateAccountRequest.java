package com.golive.demo.hexagonal.adapters.source.web.controllers.request;


import lombok.Data;

@Data
public class CreateAccountRequest {
    private String name;
    private String address;
}
