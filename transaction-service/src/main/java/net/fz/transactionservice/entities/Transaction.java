package net.fz.transactionservice.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    @Id @GeneratedValue
    private UUID id;
    private UUID accountId;
    private BigDecimal amount;

    private String currency;

    private String merchantCategory;

    private String country;

    private Instant createdAt;



}
