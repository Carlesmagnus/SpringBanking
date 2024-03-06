package com.api.banking.controller;

import com.api.banking.dto.AcctDto;
import com.api.banking.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
