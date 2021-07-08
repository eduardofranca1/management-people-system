package com.project.managementpersonssystem.domain.services;

import com.project.managementpersonssystem.domain.exceptions.BusinessException;
import com.project.managementpersonssystem.domain.exceptions.ResourceNotFoundException;
import com.project.managementpersonssystem.domain.model.Person;
import com.project.managementpersonssystem.domain.repositories.PersonRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository repository;

    public Person findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person dos not found."));
    }

    public Person findByCpf(String cpf) {
        return repository.findOptionalByCpf(cpf).orElseThrow(() -> new ResourceNotFoundException("Person cpf does not found"));
    }

    public Person create(Person person) {

        boolean existingCpf = repository.findOptionalByCpf(person.getCpf())
                .stream()
                .anyMatch(existingPerson -> !existingPerson.equals(person));

        if (existingCpf) {
            throw new BusinessException("Already have a person with this CPF. Please insert another CPF.");
        }

        return repository.save(person);
    }

    public Person update(Long id, Person person) {

        Person personDB  = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person does not found"));

        BeanUtils.copyProperties(person, personDB, "id", "phones");
        BeanUtils.copyProperties(person.getPhones(), personDB.getPhones(), "id");

        return repository.save(personDB);
    }

    public void delete(Long id) {

        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Person does not found");
        }

        repository.deleteById(id);
    }

}
