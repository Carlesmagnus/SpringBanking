package com.api.banking.controller;

import com.api.banking.dto.AcctDto;
import com.api.banking.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public ResponseEntity<AcctDto> addAccount(@RequestBody AcctDto acctDto){
        return new ResponseEntity<>(accountService.accountCreation(acctDto), HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<AcctDto> getbyId(@PathVariable Long id){
        AcctDto acctDto = accountService.getAccountById(id);
        return ResponseEntity.ok(acctDto);
    }
    @PutMapping("/{id}/deposit")
    public ResponseEntity<AcctDto> deposit(@PathVariable Long id, @RequestBody Map<String, Double> request){
        Double amount = request.get("amount");
        AcctDto acctDto = accountService.depositAmount(id, amount);
        return ResponseEntity.ok(acctDto);
    }
    @PutMapping("/{id}/withdraw")
    public ResponseEntity<AcctDto> withdraw(@PathVariable Long id, @RequestBody Map<String, Double> request){
        double amount = request.get("amount");
        AcctDto acctDto = accountService.withDraw(id, amount);
        return ResponseEntity.ok(acctDto);
    }
    @GetMapping
    public ResponseEntity<List<AcctDto>> getAllAccounts(){
        List<AcctDto> acctDto = accountService.getAllAccounts();
        return ResponseEntity.ok(acctDto);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long id){
        accountService.deleteAccount(id);
        return ResponseEntity.ok("Account is succesfully deleted");
    }
}
