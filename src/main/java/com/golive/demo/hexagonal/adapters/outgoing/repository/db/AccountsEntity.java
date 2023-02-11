package com.golive.demo.hexagonal.adapters.outgoing.repository.db;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity(name = "Account")
@Data
public class AccountsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String accNo;
    private String name;
    private String address;
    private long balance;

}
