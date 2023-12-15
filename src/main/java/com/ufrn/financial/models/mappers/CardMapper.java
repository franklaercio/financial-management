package com.ufrn.financial.models.mappers;

import com.ufrn.financial.models.Card;
import com.ufrn.financial.models.dtos.CardDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CardMapper {

    CardMapper INSTANCE = Mappers.getMapper(CardMapper.class);

    Card createToModel(CardDTO cardDTO);

    CardDTO modelToDTO(Card card);
}
