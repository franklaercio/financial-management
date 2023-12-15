package com.ufrn.financial.models.dtos;

import java.util.UUID;

public record FindTransactionDTO(UUID id, String description, String date, String value) {
}
