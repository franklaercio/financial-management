package com.ufrn.financial.models.mappers;

import com.ufrn.financial.models.Transaction;
import com.ufrn.financial.models.dtos.FindTransactionDTO;
import com.ufrn.financial.models.dtos.TransactionDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Set;

@Mapper
public interface TransactionMapper {

    TransactionMapper INSTANCE = Mappers.getMapper(TransactionMapper.class);

    Transaction createToModel(TransactionDTO transactionDTO);

    @Mapping(target = "date", source = "date", qualifiedByName = "dateTimeFormat")
    FindTransactionDTO getTransactionToDTO(Transaction transaction);

    Set<FindTransactionDTO> transactionToDTO(Set<Transaction> transactions);

    @Named("dateTimeFormat")
    default String dateTimeFormat(LocalDateTime dateTime) {
        return dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
}
