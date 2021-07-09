package com.project.managementpersonssystem.domain.services;

import com.project.managementpersonssystem.api.dto.MessageResponseDTO;
import com.project.managementpersonssystem.api.dto.PersonDTO;
import com.project.managementpersonssystem.api.dto.mapper.PersonMapper;
import com.project.managementpersonssystem.domain.exceptions.BusinessException;
import com.project.managementpersonssystem.domain.exceptions.ResourceNotFoundException;
import com.project.managementpersonssystem.domain.model.Person;
import com.project.managementpersonssystem.domain.repositories.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonService {

    private final PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    public MessageResponseDTO createPerson(PersonDTO personDTO) {

        Person person = personMapper.toModel(personDTO);

        boolean existingCpf = personRepository.findOptionalByCpf(person.getCpf())
                .stream()
                .anyMatch(existingPerson -> !existingPerson.equals(person));

        if (existingCpf) {
            throw new BusinessException("Already have a person with this CPF. Please insert another CPF.");
        }

        Person savedPerson = personRepository.save(person);

        return createMessageResponse("Person successfully created with ID ", savedPerson.getId());
    }

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

    public MessageResponseDTO update(Long id, PersonDTO personDTO) {

        Person personDB  = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person does not found"));

        BeanUtils.copyProperties(personDTO, personDB, "id", "phone");

        personRepository.save(personDB);

        return createMessageResponse("Person successfully updated with ID " , personDB.getId());
    }

    public void delete(Long id) {

        verifyIfExists(id);

        personRepository.deleteById(id);
    }

    private void verifyIfExists(Long id) {
        personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person does not found"));
    }

    private MessageResponseDTO createMessageResponse(String s, Long id2) {
        return MessageResponseDTO.builder()
                .message(s + id2)
                .build();
    }

}
