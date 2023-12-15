package com.ufrn.financial.controllers;

import com.ufrn.financial.models.dtos.TransactionCardDTO;
import com.ufrn.financial.models.dtos.TransactionDTO;
import com.ufrn.financial.models.mappers.TransactionMapper;
import com.ufrn.financial.services.TransactionService;
import com.ufrn.financial.services.WalletService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final static TransactionMapper mapper = TransactionMapper.INSTANCE;

    private final TransactionService transactionService;

    private final WalletService walletService;

    public TransactionController(TransactionService transactionService, WalletService walletService) {
        this.transactionService = transactionService;
        this.walletService = walletService;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid TransactionDTO transactionDTO) {
        var transactionCardId = this.walletService.createTransaction(UUID.fromString(transactionDTO.cardId()), mapper.createToModel(transactionDTO));
        return ResponseEntity.ok(new TransactionCardDTO(transactionCardId.getTransaction().getId().toString()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable @Valid String id) {
        var transaction = this.transactionService.findById(UUID.fromString(id));
        return ResponseEntity.ok(mapper.getTransactionToDTO(transaction));
    }

    @GetMapping("/person/{id}")
    public ResponseEntity<?> findAllByPersonId(@PathVariable @Valid String id) {
        var transactions = this.walletService.getTransactionsByCardId(UUID.fromString(id));
        return ResponseEntity.ok(mapper.transactionToDTO(transactions));
    }
}
