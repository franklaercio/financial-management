package com.ufrn.financial.repositories;

import com.ufrn.financial.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PersonRepository extends JpaRepository<Person, UUID> {

    Person findByCpf(String cpf);
}
