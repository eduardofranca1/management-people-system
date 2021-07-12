package com.project.managementpeoplesystem.domain.services.person;

import com.project.managementpeoplesystem.domain.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeletePersonService {

    private Utils utils;

    @Autowired
    private PersonRepository personRepository;

    public void delete(Long id) {

        utils.verifyIfExists(id);

        personRepository.deleteById(id);
    }
}
