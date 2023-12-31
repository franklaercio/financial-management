package com.ufrn.financial.repositories;

import com.ufrn.financial.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, Long> {

    UserDetails findByUsername(String username);

    UserDetails findByUuid(UUID uuid);
}
