package com.ufrn.financial.repositories;

import com.ufrn.financial.models.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CardRepository extends JpaRepository<Card, UUID> {

    List<Card> findAllByPersonId(UUID id);
}
