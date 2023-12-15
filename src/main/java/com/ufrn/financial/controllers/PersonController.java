package com.ufrn.financial.controllers;

import com.ufrn.financial.models.dtos.PersonDTO;
import com.ufrn.financial.models.mappers.PersonMapper;
import com.ufrn.financial.services.PersonService;
import com.ufrn.financial.utils.AuthUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private final static PersonMapper mapper = PersonMapper.INSTANCE;

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody @Valid PersonDTO data, HttpServletRequest request) {
        var person = this.personService.save(mapper.createToModel(data), AuthUtil.getUuidFromRequest(request));

        return ResponseEntity.ok(mapper.modelToDTO(person));
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody @Valid PersonDTO data) {
        var person = this.personService.update(mapper.updateToModel(data));

        return ResponseEntity.ok(person);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable @Valid String id) {
        this.personService.delete(UUID.fromString(id));
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable @Valid String id) {
        var person = this.personService.findById(UUID.fromString(id));
        return ResponseEntity.ok(mapper.modelToDTO(person));
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<?> findByCpf(@PathVariable @Valid String cpf) {
        var person = this.personService.findByCpf(cpf);
        return ResponseEntity.ok(mapper.modelToDTO(person));
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        var persons = this.personService.findAll();
        return ResponseEntity.ok(mapper.modelsToDTOs(persons));
    }
}
