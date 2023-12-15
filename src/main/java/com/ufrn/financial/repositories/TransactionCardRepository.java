package com.ufrn.financial.repositories;

import com.ufrn.financial.models.TransactionCard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TransactionCardRepository extends JpaRepository<TransactionCard, UUID> {
}
