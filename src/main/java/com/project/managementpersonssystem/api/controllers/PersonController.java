package com.project.managementpersonssystem.api.controllers;

import com.project.managementpersonssystem.api.dto.MessageResponseDTO;
import com.project.managementpersonssystem.domain.model.Person;
import com.project.managementpersonssystem.domain.repositories.PersonRepository;
import com.project.managementpersonssystem.domain.services.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/persons")
public class PersonController {

    private final PersonRepository repository;
    private final PersonService service;

    @GetMapping
    public List<Person> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Person getById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping("/cpf/{cpf}")
    public Person getByCpf(@PathVariable String cpf) {
        return service.findByCpf(cpf);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Person create(@RequestBody Person person) {
        return service.create(person);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Person update(@PathVariable Long id, @RequestBody Person person) {
        return service.update(id, person);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public MessageResponseDTO create(@RequestBody Person person) {
//        Person savedPerson = repository.save(person);
//        return MessageResponseDTO
//                .builder()
//                .message("Created person with ID " + savedPerson.getId())
//                .build();
//    }

}

