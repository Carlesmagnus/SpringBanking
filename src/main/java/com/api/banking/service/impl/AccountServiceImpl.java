package com.api.banking.service.impl;

import com.api.banking.dto.AcctDto;
import com.api.banking.entity.Account;
import com.api.banking.entity.mapper.AccountMapper;
import com.api.banking.repository.AccountRepo;
import com.api.banking.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
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

    @Override
    public AcctDto getAccountById(Long id){
        Account account = accountRepo.findById(id).orElseThrow(() -> new RuntimeException("Account doesn't exist"));
        return AccountMapper.maptoAcctDto(account);
    }

    @Override
    public AcctDto depositAmount(Long id, double amount) {
        Account accounts = accountRepo.findById(id).orElseThrow(()-> new RuntimeException("Account does not exist"));
        double total = accounts.getBalance() + amount;
        accounts.setBalance(total);
        Account savedAccount = accountRepo.save(accounts);
        return AccountMapper.maptoAcctDto(savedAccount);
    }

    @Override
    public AcctDto withDraw(Long id, double amount) {
        Account accounts = accountRepo.findById(id).orElseThrow(()-> new RuntimeException("Account does not exist"));

        if(accounts.getBalance() < amount){
            throw new RuntimeException("Insufficient Balance");
        }

        double total = accounts.getBalance() - amount;
        accounts.setBalance(total);
        Account savedAccount = accountRepo.save(accounts);
        return AccountMapper.maptoAcctDto(savedAccount);
    }

    @Override
    public List<AcctDto> getAllAccounts() {
        List<Account> accounts = accountRepo.findAll();
        return accounts.stream().map((account -> AccountMapper.maptoAcctDto(account))).collect(Collectors.toList());
    }

    @Override
    public void deleteAccount(Long id) {
        Account accounts = accountRepo.findById(id).orElseThrow(()-> new RuntimeException("Account does not exist"));
        accountRepo.deleteById(id);
    }
}
