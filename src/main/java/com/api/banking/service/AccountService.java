package com.api.banking.service;

import com.api.banking.dto.AcctDto;

public interface AccountService {
    AcctDto accountCreation(AcctDto account);

    AcctDto getAccountById(Long id);
}
