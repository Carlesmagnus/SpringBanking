package com.api.banking.controller;

import com.api.banking.dto.AcctDto;
import com.api.banking.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
