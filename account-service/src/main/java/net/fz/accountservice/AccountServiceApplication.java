package net.fz.accountservice;

import net.fz.accountservice.entities.Account;
import net.fz.accountservice.enumerations.AccountStatus;
import net.fz.accountservice.repositories.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class AccountServiceApplication implements CommandLineRunner {

    private final AccountRepository accountRepository;

    public AccountServiceApplication(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void run(String... args) {
        if (accountRepository.count() == 0) {

            Account account1 = new Account(
                    UUID.randomUUID(),
                    "CUST-001",
                    AccountStatus.ACTIVE,
                    "EUR",
                    5000.00
            );

            Account account2 = new Account(
                    UUID.randomUUID(),
                    "CUST-002",
                    AccountStatus.ACTIVE,
                    "USD",
                    1500.50
            );

            Account account3 = new Account(
                    UUID.randomUUID(),
                    "CUST-003",
                    AccountStatus.BLOCKED,
                    "EUR",
                    100.00
            );

            accountRepository.save(account1);
            accountRepository.save(account2);
            accountRepository.save(account3);

            System.out.println(" Comptes initiaux insérés avec succès !");
        }
    }
}