package net.fz.accountservice;

import net.fz.accountservice.entities.Account;
import net.fz.accountservice.enumerations.AccountStatus;
import net.fz.accountservice.repositories.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class AccountDataInitializer implements CommandLineRunner {

    private final AccountRepository accountRepository;

    public AccountDataInitializer(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void run(String... args) {
        if (accountRepository.count() == 0) {

            Account account1 = new Account();
            account1.setCustomerReference("CUST-001");
            account1.setStatus(AccountStatus.ACTIVE);
            account1.setCurrency("EUR");
            account1.setBalance(5000.00);

            Account account2 = new Account();
            account2.setCustomerReference("CUST-002");
            account2.setStatus(AccountStatus.ACTIVE);
            account2.setCurrency("USD");
            account2.setBalance(1500.50);

            Account account3 = new Account();
            account3.setCustomerReference("CUST-003");
            account3.setStatus(AccountStatus.BLOCKED);
            account3.setCurrency("EUR");
            account3.setBalance(100.00);

            accountRepository.save(account1);
            accountRepository.save(account2);
            accountRepository.save(account3);

            System.out.println("Comptes initiaux insérés avec succès !");
        }
    }
}