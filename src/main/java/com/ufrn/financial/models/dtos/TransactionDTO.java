package com.ufrn.financial.models.dtos;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record TransactionDTO(@NotNull String cardId, String description, @NotNull BigDecimal value) {
}
