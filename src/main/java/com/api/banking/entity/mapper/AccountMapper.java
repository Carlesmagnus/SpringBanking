package com.api.banking.entity.mapper;

import com.api.banking.dto.AcctDto;
import com.api.banking.entity.Account;

public class AccountMapper {
    public static Account mapToAcct(AcctDto acctDto){
     Account account= new Account(
     acctDto.getId(),
        acctDto.getAccountHolderName(),
        acctDto.getBalance());
     return account;
    }

    public static AcctDto maptoAcctDto(Account account){
        AcctDto acctDto = new AcctDto(
                account.getId(),
                account.getAccountHolderName(),
                account.getBalance());
        return acctDto;
    }
}
