package com.project.managementpeoplesystem.domain.services.person;

import com.project.managementpeoplesystem.api.dto.PersonDTO;
import com.project.managementpeoplesystem.api.dto.mapper.PersonMapper;
import com.project.managementpeoplesystem.domain.exceptions.ResourceNotFoundException;
import com.project.managementpeoplesystem.domain.model.Person;
import com.project.managementpeoplesystem.domain.repositories.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class FindPersonService {

    private final PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    public List<PersonDTO> listAll() {
        List<Person> people = personRepository.findAll();
        return people.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PersonDTO findById(Long id) {

        Person person = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Person does not found."));

        return personMapper.toDTO(person);
    }

    public PersonDTO findByCpf(String cpf) {
        Person person = personRepository.findOptionalByCpf(cpf).orElseThrow(() -> new ResourceNotFoundException("Person cpf does not found"));

        return personMapper.toDTO(person);
    }

    public PersonDTO findByCity(String city) {
        Person person = personRepository.findAllByAddressCity(city).orElseThrow(() -> new ResourceNotFoundException("City does not found."));

        return personMapper.toDTO(person);
    }

    public PersonDTO findByState(String state) {
        Person person = personRepository.findAllByAddressState(state).orElseThrow(() -> new ResourceNotFoundException("State does not found."));

        return personMapper.toDTO(person);
    }
}
