package com.golive.demo.hexagonal.adapters.source.web.controllers;

import com.golive.demo.hexagonal.adapters.source.web.controllers.request.CreateAccountRequest;
import com.golive.demo.hexagonal.adapters.source.web.controllers.request.TransferRequest;
import com.golive.demo.hexagonal.bankABC.BankABCCustomer;
import com.golive.demo.hexagonal.bankABC.BankABCEmployee;
import com.golive.demo.hexagonal.bankABC.dto.AccountDetails;
import com.golive.demo.hexagonal.bankABC.exception.BankOperationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class AccountController {

    @Autowired
    BankABCCustomer bankABCCustomer;

    @Autowired
    BankABCEmployee bankABCEmployee;

    @PostMapping(path = "/api/v1/accounts", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<String> createAccount(@RequestBody CreateAccountRequest createAccountRequest) throws BankOperationException {
        String accNo = bankABCEmployee.createAccount(AccountDetails.builder()
                .name(createAccountRequest.getName())
                .address(createAccountRequest.getAddress())
                .build());
        return ResponseEntity.ok(accNo);
    }

    @DeleteMapping(path = "/api/v1/accounts/{accNo}", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Void> deleteAccount(@PathVariable(name = "accNo") String accNo) throws BankOperationException {
        bankABCEmployee.deleteAccount(accNo);
        return ResponseEntity.ok(null);
    }

    @GetMapping(path = "/api/v1/accounts/{accNo}/balance")
    ResponseEntity<Long> getBalance(@PathVariable String accNo) throws BankOperationException {
        return ResponseEntity.ok(bankABCCustomer.getBalance(accNo));
    }

    @PostMapping(path = "/api/v1/accounts/transfers", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Void> transfer(@RequestBody TransferRequest transferRequest) throws BankOperationException {
        bankABCCustomer.transfer(transferRequest.getSourceAcc(), transferRequest.getDestinationAcc(), transferRequest.getAmt());
        return ResponseEntity.ok(null);
    }
}
