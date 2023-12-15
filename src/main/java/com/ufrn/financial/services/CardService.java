package com.ufrn.financial.services;

import com.ufrn.financial.models.Card;
import com.ufrn.financial.repositories.CardRepository;
import com.ufrn.financial.repositories.PersonRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CardService {

    private final CardRepository cardRepository;

    private final PersonRepository personRepository;

    public CardService(CardRepository cardRepository, PersonRepository personRepository) {
        this.cardRepository = cardRepository;
        this.personRepository = personRepository;
    }

    @Transactional
    public Card createCard(Card card, UUID userId) {
        var person = this.personRepository.findByUserUuid(userId);
        card.setPerson(person);
        card.setActive(true);

        return this.cardRepository.save(card);
    }

    public Card getCardById(UUID id) {
        return this.cardRepository.findById(id).orElse(null);
    }

    public List<Card> getAllCardsByPersonId(UUID id) {
        return this.cardRepository.findAllByPersonId(id);
    }

    public void delete(UUID id) {
        var card = this.cardRepository.findById(id).orElse(null);
        card.setActive(false);
        this.cardRepository.save(card);
    }
}
