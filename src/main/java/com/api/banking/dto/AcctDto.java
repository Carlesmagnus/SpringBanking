package com.api.banking.dto;

import javax.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AcctDto {
    private Long id;
    private String accountHolderName;
    private double balance;
}
