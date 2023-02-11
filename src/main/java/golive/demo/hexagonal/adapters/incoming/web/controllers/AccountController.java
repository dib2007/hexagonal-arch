package golive.demo.hexagonal.adapters.incoming.web.controllers;

import golive.demo.hexagonal.adapters.incoming.web.controllers.request.TransferRequest;
import golive.demo.hexagonal.adapters.incoming.web.controllers.request.CreateAccountRequest;
import golive.demo.hexagonal.bankabc.ports.incoming.BankABCCustomer;
import golive.demo.hexagonal.bankabc.ports.incoming.BankABCEmployee;
import golive.demo.hexagonal.bankabc.dto.AccountDetails;
import golive.demo.hexagonal.bankabc.exception.BankOperationException;
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
