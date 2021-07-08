package com.project.managementpersonssystem.api.controllers;

import com.project.managementpersonssystem.api.dto.PersonDTO;
import com.project.managementpersonssystem.domain.mapper.PersonMapper;
import com.project.managementpersonssystem.domain.model.Person;
import com.project.managementpersonssystem.domain.repositories.PersonRepository;
import com.project.managementpersonssystem.domain.services.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/persons")
public class PersonController {

    private final PersonRepository repository;
    private final PersonService service;
    private final PersonMapper personMapper;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PersonDTO> getAll() { return personMapper.toCollectionDTO(repository.findAll());  }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PersonDTO getById(@PathVariable Long id) {
        return personMapper.toDTO(service.findById(id));
    }

    @GetMapping("/cpf/{cpf}")
    public Person getByCpf(@PathVariable String cpf) {
        return service.findByCpf(cpf);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PersonDTO create(@Valid @RequestBody Person person) {
        return personMapper.toDTO(service.create(person));
    }

//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public Person create(@RequestBody Person person) {
//        return service.create(person);
//    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PersonDTO update(@Valid @PathVariable Long id, @RequestBody Person person) {
        return personMapper.toDTO(service.update(id, person));
    }

//    @PutMapping("/{id}")
//    @ResponseStatus(HttpStatus.OK)
//    public Person update(@PathVariable Long id, @RequestBody Person person) {
//        return service.update(id, person);
//    }

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

