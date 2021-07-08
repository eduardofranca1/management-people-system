package com.project.managementpersonssystem.domain.mapper;

import com.project.managementpersonssystem.api.dto.PersonDTO;
import com.project.managementpersonssystem.domain.model.Person;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PersonMapper {

    @Autowired
    private ModelMapper modelMapper;

    public PersonDTO toDTO(Person person) {
        return modelMapper.map(person, PersonDTO.class);
    }

    public List<PersonDTO> toCollectionDTO(List<Person> persons) {
        return persons.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

//    public PersonRequestDTO toRequestDTO (Person person) { return modelMapper.map(person, PersonRequestDTO.class); }
//
//    public Person fromRequestDTO(PersonRequestDTO person) { return modelMapper.map(person, Person.class); }

}
