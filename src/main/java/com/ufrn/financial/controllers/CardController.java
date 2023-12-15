package com.ufrn.financial.controllers;

import com.ufrn.financial.models.dtos.CardDTO;
import com.ufrn.financial.models.mappers.CardMapper;
import com.ufrn.financial.services.CardService;
import com.ufrn.financial.services.WalletService;
import com.ufrn.financial.utils.AuthUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/cards")
public class CardController {

    private final static CardMapper mapper = CardMapper.INSTANCE;

    private final CardService cardService;

    private final WalletService walletService;

    public CardController(CardService cardService, WalletService walletService) {
        this.cardService = cardService;
        this.walletService = walletService;
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody @Valid CardDTO data, HttpServletRequest request) {
        var person = this.cardService.createCard(mapper.createToModel(data), AuthUtil.getUuidFromRequest(request));

        return ResponseEntity.ok(mapper.modelToDTO(person));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable @Valid String id) {
        var card = this.cardService.getCardById(UUID.fromString(id));
        return ResponseEntity.ok(mapper.modelToDTO(card));
    }

    @GetMapping("/person/{id}")
    public ResponseEntity<?> findAllByPersonId(@PathVariable @Valid String id) {
        var cards = this.walletService.getTransactionsByCard(UUID.fromString(id));
        return ResponseEntity.ok(cards);
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestBody @Valid String id) {
        this.cardService.delete(UUID.fromString(id));
        return ResponseEntity.ok().build();
    }
}
