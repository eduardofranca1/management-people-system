package com.project.managementpeoplesystem.domain.services.person;

import com.project.managementpeoplesystem.api.dto.MessageResponseDTO;
import com.project.managementpeoplesystem.api.dto.PersonDTO;
import com.project.managementpeoplesystem.api.dto.mapper.PersonMapper;
import com.project.managementpeoplesystem.domain.exceptions.BusinessException;
import com.project.managementpeoplesystem.domain.model.Person;
import com.project.managementpeoplesystem.domain.repositories.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CreatePersonService {

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

    private MessageResponseDTO createMessageResponse(String s, Long id) {
        return MessageResponseDTO.builder()
                .message(s + id)
                .build();
    }
}
