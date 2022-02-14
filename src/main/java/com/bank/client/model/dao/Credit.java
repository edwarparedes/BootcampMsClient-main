package com.bank.client.model.dao;

import lombok.Data;

@Data
public class Credit {

    private String nameProduct;
    private String cardNumber;
    private String typeCredit;
    private String accountNumber;
    private Double balance;
    private Double creditLimit;

}
