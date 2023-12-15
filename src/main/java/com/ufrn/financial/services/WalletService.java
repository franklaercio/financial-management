package com.ufrn.financial.services;

import com.ufrn.financial.models.Card;
import com.ufrn.financial.models.Transaction;
import com.ufrn.financial.models.TransactionCard;
import com.ufrn.financial.repositories.CardRepository;
import com.ufrn.financial.repositories.TransactionCardRepository;
import com.ufrn.financial.repositories.TransactionRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
public class WalletService {

    private final CardRepository cardRepository;

    private final TransactionRepository transactionRepository;

    private final TransactionCardRepository transactionCardRepository;

    public WalletService(CardRepository cardRepository, TransactionRepository transactionRepository, TransactionCardRepository transactionCardRepository) {
        this.cardRepository = cardRepository;
        this.transactionRepository = transactionRepository;
        this.transactionCardRepository = transactionCardRepository;
    }

    @Transactional
    public TransactionCard createTransaction(UUID cardId, Transaction transaction) {
        var transactionSaved = this.transactionRepository.save(transaction);
        var cardSaved = this.cardRepository.findById(cardId).orElse(null);
        return this.transactionCardRepository.save(new TransactionCard(transactionSaved, cardSaved));
    }

    public Set<Transaction> getTransactionsByCardId(UUID cardId) {
        Optional<Card> cardOptional = cardRepository.findById(cardId);
        if (cardOptional.isPresent()) {
            Card card = cardOptional.get();
            return card.getTransactions();
        }
        return Collections.emptySet();
    }
}