package com.ufrn.financial.models.mappers;

import com.ufrn.financial.models.Card;
import com.ufrn.financial.models.dtos.CardCreateDTO;
import com.ufrn.financial.models.dtos.CardDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CardMapper {

    CardMapper INSTANCE = Mappers.getMapper(CardMapper.class);

    Card createToModel(CardDTO cardDTO);

    @Mapping(target = "personId", source = "person.id")
    CardCreateDTO modelToDTO(Card card);

    List<CardCreateDTO> cardsToDTO(List<Card> cards);
}
