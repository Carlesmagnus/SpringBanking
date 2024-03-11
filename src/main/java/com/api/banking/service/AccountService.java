package com.api.banking.service;

import com.api.banking.dto.AcctDto;

import java.util.List;

public interface AccountService {
    AcctDto accountCreation(AcctDto account);

    AcctDto getAccountById(Long id);

    AcctDto depositAmount(Long id, double amount);

    AcctDto withDraw(Long id, double amount);

    List<AcctDto> getAllAccounts();

    void deleteAccount(Long id);
}
