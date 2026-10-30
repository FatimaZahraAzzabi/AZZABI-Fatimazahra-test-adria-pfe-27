package net.fz.transactionservice.controllers;

import net.fz.transactionservice.entities.Transaction;
import net.fz.transactionservice.repositories.TransactionRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/transactions")
@CrossOrigin("*")
public class TransactionRestController {

    private final TransactionRepository transactionRepository;

    public TransactionRestController(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @GetMapping
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    @GetMapping("/{id}")
    public Transaction getTransaction(@PathVariable UUID id) {
        return transactionRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Transaction saveTransaction(@RequestBody Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @PutMapping("/{id}")
    public Transaction updateTransaction(
            @PathVariable UUID id,
            @RequestBody Transaction transaction) {

        transaction.setId(id);
        return transactionRepository.save(transaction);
    }

    @DeleteMapping("/{id}")
    public void deleteTransaction(@PathVariable UUID id) {
        transactionRepository.deleteById(id);
    }
}