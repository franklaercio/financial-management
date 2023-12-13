package com.ufrn.financial.models.dtos;

import jakarta.validation.constraints.NotNull;

public record AuthDTO(@NotNull(message = "Username cannot be null") String username, @NotNull(message = "Password cannot be null") String password) {
}
