package com.ufrn.financial.services;

import com.ufrn.financial.models.Person;
import com.ufrn.financial.models.User;
import com.ufrn.financial.repositories.PersonRepository;
import com.ufrn.financial.repositories.UserRepository;
import com.ufrn.financial.utils.UpdateUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    private final UserRepository userRepository;

    public PersonService(PersonRepository personRepository, UserRepository userRepository) {
        this.personRepository = personRepository;
        this.userRepository = userRepository;
    }

    public Person save(Person person, UUID userId) {
        UserDetails user = this.userRepository.findByUuid(userId);
        person.setUser((User) user);

        return this.personRepository.save(person);
    }

    public Person update(Person person) {
        Person personFounded = findById(person.getId());
        UpdateUtils.update(personFounded, person, Person.class.getDeclaredFields());

        return this.personRepository.save(personFounded);
    }

    public Person findById(UUID id) {
        return this.personRepository.findById(id).orElse(null);
    }

    public Person findByCpf(String cpf) {
        return this.personRepository.findByCpf(cpf);
    }

    public void delete(UUID id) {
        this.personRepository.deleteById(id);
    }

    public List<Person> findAll() {
        return this.personRepository.findAll();
    }
}
