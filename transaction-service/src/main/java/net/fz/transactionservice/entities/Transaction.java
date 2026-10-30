package net.fz.transactionservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.util.UUID;


@Entity

public class Transaction {
    @Id @GeneratedValue
    private UUID id;
    private UUID accountId;
    private BigDecimal amount;

    private String currency;



}
