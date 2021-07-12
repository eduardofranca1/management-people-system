package com.project.managementpeoplesystem.api.controllers;

import com.project.managementpeoplesystem.api.dto.PersonDTO;
import com.project.managementpeoplesystem.api.dto.MessageResponseDTO;
import com.project.managementpeoplesystem.domain.services.person.CreatePersonService;
import com.project.managementpeoplesystem.domain.services.person.DeletePersonService;
import com.project.managementpeoplesystem.domain.services.person.FindPersonService;
import com.project.managementpeoplesystem.domain.services.person.UpdatePersonService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/persons")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonController {

    private final CreatePersonService createPersonService;
    private final FindPersonService findPersonService;
    private final UpdatePersonService updatePersonService;
    private final DeletePersonService deletePersonService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO create(@RequestBody @Valid PersonDTO personDTO) {
        return createPersonService.createPerson(personDTO);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PersonDTO> getAll() { return findPersonService.listAll(); }

    @GetMapping("/{personId}")
    @ResponseStatus(HttpStatus.OK)
    public PersonDTO getById(@PathVariable Long personId) { return findPersonService.findById(personId); }

    @GetMapping("/cpf/{cpf}")
    @ResponseStatus(HttpStatus.OK)
    public PersonDTO getByCpf(@PathVariable String cpf) { return findPersonService.findByCpf(cpf); }

    @GetMapping("/city/{city}")
    @ResponseStatus(HttpStatus.OK)
    public PersonDTO getByCities(@PathVariable String city) { return findPersonService.findByCity(city); }

    @GetMapping("/state/{state}")
    @ResponseStatus(HttpStatus.OK)
    public PersonDTO getByStates(@PathVariable String state) { return findPersonService.findByState(state); }

    @PutMapping("/{personId}")
    @ResponseStatus(HttpStatus.OK)
    public MessageResponseDTO update(@PathVariable Long personId, @RequestBody @Valid PersonDTO personDTO) {
        return updatePersonService.update(personId, personDTO);
    }

    @DeleteMapping("/{personId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long personId) { deletePersonService.delete(personId); }

}

