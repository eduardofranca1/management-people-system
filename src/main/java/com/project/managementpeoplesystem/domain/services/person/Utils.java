package com.project.managementpeoplesystem.domain.services.person;

import com.project.managementpeoplesystem.api.dto.MessageResponseDTO;
import com.project.managementpeoplesystem.domain.exceptions.ResourceNotFoundException;
import com.project.managementpeoplesystem.domain.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class Utils {

    @Autowired
    private PersonRepository personRepository;

    public void verifyIfExists(Long id) {
        personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person does not found"));
    }

    public MessageResponseDTO createMessageResponse(String s, Long id) {
        return MessageResponseDTO.builder()
                .message(s + id)
                .build();
    }
}
