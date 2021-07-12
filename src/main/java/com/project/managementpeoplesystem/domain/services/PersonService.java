//package com.project.managementpeoplesystem.domain.services;
//
//import com.project.managementpeoplesystem.api.dto.PersonDTO;
//import com.project.managementpeoplesystem.domain.exceptions.ResourceNotFoundException;
//import com.project.managementpeoplesystem.domain.model.Person;
//import com.project.managementpeoplesystem.api.dto.MessageResponseDTO;
//import com.project.managementpeoplesystem.api.dto.mapper.PersonMapper;
//import com.project.managementpeoplesystem.domain.exceptions.BusinessException;
//import com.project.managementpeoplesystem.domain.repositories.PersonRepository;
//import lombok.AllArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//@AllArgsConstructor(onConstructor = @__(@Autowired))
//public class PersonService {
//
//    private final PersonRepository personRepository;
//
//    private final PersonMapper personMapper = PersonMapper.INSTANCE;
//
//    public MessageResponseDTO createPerson(PersonDTO personDTO) {
//
//        Person person = personMapper.toModel(personDTO);
//
//        boolean existingCpf = personRepository.findOptionalByCpf(person.getCpf())
//                .stream()
//                .anyMatch(existingPerson -> !existingPerson.equals(person));
//
//        if (existingCpf) {
//            throw new BusinessException("Already have a person with this CPF. Please insert another CPF.");
//        }
//
//        Person savedPerson = personRepository.save(person);
//
//        return createMessageResponse("Person successfully created with ID ", savedPerson.getId());
//    }
//
//    public List<PersonDTO> listAll() {
//        List<Person> people = personRepository.findAll();
//        return people.stream()
//                .map(personMapper::toDTO)
//                .collect(Collectors.toList());
//    }
//
//    public PersonDTO findById(Long id) {
//
//        Person person = personRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Person does not found."));
//
//        return personMapper.toDTO(person);
//    }
//
//    public PersonDTO findByCpf(String cpf) {
//        Person person = personRepository.findOptionalByCpf(cpf).orElseThrow(() -> new ResourceNotFoundException("Person cpf does not found"));
//
//        return personMapper.toDTO(person);
//    }
//
//    public MessageResponseDTO update(Long id, PersonDTO personDTO) {
//
//        verifyIfExists(id);
//
//        Person updatedPerson = personMapper.toModel(personDTO);
//        Person savedPerson = personRepository.save(updatedPerson);
//
//        return createMessageResponse("Person successfully updated with ID ", savedPerson.getId());
//
//        Person personDB = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person does not found"));
//
//        BeanUtils.copyProperties(personDTO, personDB, "id", "phones");
//
//        personRepository.save(personDB);
//
//        return createMessageResponse("Person successfully updated with ID " , personDB.getId());
//    }
//
//    public void delete(Long id) {
//
//        verifyIfExists(id);
//
//        personRepository.deleteById(id);
//    }
//
//    private void verifyIfExists(Long id) {
//        personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person does not found"));
//    }
//
//    private MessageResponseDTO createMessageResponse(String s, Long id) {
//        return MessageResponseDTO.builder()
//                .message(s + id)
//                .build();
//    }
//
//}
