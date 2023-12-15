package com.ufrn.financial.models.dtos;

import com.ufrn.financial.models.enums.FlagEnum;

import java.time.LocalDate;
import java.util.UUID;

public record CardCreateDTO(UUID id, String embossing, String number, String cvv,
                            LocalDate expirationDate, FlagEnum flag, UUID personId) {
}
