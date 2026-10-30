package net.fz.transactionservice;

import net.fz.transactionservice.entities.Transaction;
import net.fz.transactionservice.repositories.TransactionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.Instant;

@Component
public class TransactionDataInitializer implements CommandLineRunner {

    private final TransactionRepository transactionRepository;

    public TransactionDataInitializer(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public void run(String... args) {
        if (transactionRepository.count() == 0) {

            // Pas d'ID passé → JPA le génère automatiquement
            Transaction t1 = new Transaction();
            t1.setAccountId(java.util.UUID.randomUUID());
            t1.setAmount(new BigDecimal("250.00"));
            t1.setCurrency("EUR");
            t1.setMerchantCategory("RETAIL");
            t1.setCountry("MA");
            t1.setCreatedAt(Instant.now());

            Transaction t2 = new Transaction();
            t2.setAccountId(java.util.UUID.randomUUID());
            t2.setAmount(new BigDecimal("1200.50"));
            t2.setCurrency("USD");
            t2.setMerchantCategory("TRAVEL");
            t2.setCountry("US");
            t2.setCreatedAt(Instant.now());

            transactionRepository.save(t1);
            transactionRepository.save(t2);

            System.out.println(" Transactions initiales insérées avec succès !");
        }
    }
}