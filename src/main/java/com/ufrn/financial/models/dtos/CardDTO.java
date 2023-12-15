package com.ufrn.financial.models.dtos;

import com.ufrn.financial.models.enums.FlagEnum;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public record CardDTO(@NotNull String number, @NotNull String embossing, @NotNull String cvv, @NotNull FlagEnum flag, @NotNull @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate expirationDate) {
}
