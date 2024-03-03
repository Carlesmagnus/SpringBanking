package com.api.banking.service.impl;

import com.api.banking.dto.AcctDto;
import com.api.banking.entity.Account;
import com.api.banking.entity.mapper.AccountMapper;
import com.api.banking.repository.AccountRepo;
import com.api.banking.service.AccountService;

public class AccountServiceImpl implements AccountService {

    private AccountRepo accountRepo;

    public AccountServiceImpl(AccountRepo accountRepo) {
        this.accountRepo = accountRepo;
    }

    @Override
    public AcctDto accountCreation(AcctDto accountDto) {
        Account account = AccountMapper.mapToAcct(accountDto);
        Account saveAccount = accountRepo.save(account);
        return AccountMapper.maptoAcctDto(saveAccount);
    }
}
