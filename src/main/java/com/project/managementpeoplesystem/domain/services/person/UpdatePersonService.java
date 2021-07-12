package com.project.managementpeoplesystem.domain.services.person;

import com.project.managementpeoplesystem.api.dto.MessageResponseDTO;
import com.project.managementpeoplesystem.api.dto.PersonDTO;
import com.project.managementpeoplesystem.api.dto.mapper.PersonMapper;
import com.project.managementpeoplesystem.domain.model.Person;
import com.project.managementpeoplesystem.domain.repositories.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdatePersonService {

    private Utils utils;

    @Autowired
    private PersonRepository personRepository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    public MessageResponseDTO update(Long id, PersonDTO personDTO) {

        utils.verifyIfExists(id);

        Person updatedPerson = personMapper.toModel(personDTO);
        Person savedPerson = personRepository.save(updatedPerson);

        return utils.createMessageResponse("Person successfully updated with ID ", savedPerson.getId());

//        Person personDB = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person does not found"));
//
//        BeanUtils.copyProperties(personDTO, personDB, "id", "phones");
//
//        personRepository.save(personDB);
//
//        return createMessageResponse("Person successfully updated with ID " , personDB.getId());
    }
}
