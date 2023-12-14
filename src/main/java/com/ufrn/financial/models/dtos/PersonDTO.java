package com.ufrn.financial.models.dtos;

import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.UUID;

public record PersonDTO(UUID id, @NotNull String firstName, @NotNull String lastName, @NotNull @CPF String cpf,
                        @NotNull String email, String phone, String address, String city, String state,
                        String country, String zipcode, @NotNull @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate birthdate) {
}
