package com.ufrn.financial.services;

import com.ufrn.financial.models.Transaction;
import com.ufrn.financial.repositories.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Transaction findById(UUID id) {
        return this.transactionRepository.findById(id).orElseThrow(() -> new RuntimeException("Transaction not found"));
    }
}
