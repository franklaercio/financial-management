package com.ufrn.financial.models.mappers;

import com.ufrn.financial.models.Transaction;
import com.ufrn.financial.models.dtos.TransactionDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TransactionMapper {

    TransactionMapper INSTANCE = Mappers.getMapper(TransactionMapper.class);

    Transaction createToModel(TransactionDTO transactionDTO);

    TransactionDTO modelToDTO(Transaction transaction);

    List<TransactionDTO> modelToDTO(List<Transaction> transactions);
}
