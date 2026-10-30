
package net.fz.accountservice.controllers;

import net.fz.accountservice.entities.Account;
import net.fz.accountservice.repositories.AccountRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin("*")
public class AccountRestController {

    private final AccountRepository accountRepository;

    public AccountRestController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @GetMapping("/accounts")
    public List<Account> getAllBankAccounts() {
        return accountRepository.findAll();
    }

    @GetMapping("/accounts/{id}")
    public Account getBankAccountById(@PathVariable UUID id) {
        return accountRepository.findById(id).orElse(null);
    }

    @PostMapping("/accounts")
    public Account save(@RequestBody Account account) {
        return accountRepository.save(account);
    }
}
