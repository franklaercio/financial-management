package com.ufrn.financial.models.dtos;

import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

public record TransactionDTO(@NotNull String cardId, String description, @NotNull @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date, @NotNull BigDecimal value) {
}
