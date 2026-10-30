package net.fz.transactionservice;

import net.fz.transactionservice.entities.Transaction;
import net.fz.transactionservice.repositories.TransactionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.UUID;

@Component
public class TransactionDataInitializer implements CommandLineRunner {

    private final TransactionRepository transactionRepository;

    public TransactionDataInitializer(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public void run(String... args) {
        if (transactionRepository.count() == 0) {

            Transaction t1 = new Transaction(
                    UUID.randomUUID(),
                    UUID.randomUUID(), // accountId (à lier à un vrai compte si besoin)
                    new BigDecimal("250.00"),
                    "EUR",
                    "RETAIL",
                    "MA",
                    Instant.now()
            );

            Transaction t2 = new Transaction(
                    UUID.randomUUID(),
                    UUID.randomUUID(),
                    new BigDecimal("1200.50"),
                    "USD",
                    "TRAVEL",
                    "US",
                    Instant.now()
            );

            transactionRepository.save(t1);
            transactionRepository.save(t2);

            System.out.println(" Transactions initiales insérées avec succès !");
        }
    }
}