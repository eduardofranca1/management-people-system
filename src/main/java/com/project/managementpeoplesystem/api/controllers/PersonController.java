package com.project.managementpeoplesystem.api.controllers;

import com.project.managementpeoplesystem.api.dto.PersonDTO;
import com.project.managementpeoplesystem.api.dto.MessageResponseDTO;
import com.project.managementpeoplesystem.domain.services.PersonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Tag(name = "Person Endpoint")
@RestController
@RequestMapping("/persons")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonController {

    private final PersonService personService;

    @Operation(summary = "Create a Person")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO create(@RequestBody @Valid PersonDTO personDTO) {
        return personService.createPerson(personDTO);
    }

    @Operation(summary = "List all People")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PersonDTO> getAll() { return personService.listAll(); }

    @Operation(summary = "Find a person by id")
    @GetMapping("/{personId}")
    @ResponseStatus(HttpStatus.OK)
    public PersonDTO getById(@PathVariable Long personId) { return personService.findById(personId); }

    @Operation(summary = "Find a person by CPF")
    @GetMapping("/cpf/{cpf}")
    @ResponseStatus(HttpStatus.OK)
    public PersonDTO getByCpf(@PathVariable String cpf) { return personService.findByCpf(cpf); }

    @Operation(summary = "List all people by city")
    @GetMapping("/city/{city}")
    @ResponseStatus(HttpStatus.OK)
    public PersonDTO getByCities(@PathVariable String city) { return personService.findByCity(city); }

    @Operation(summary = "List all people by state")
    @GetMapping("/state/{state}")
    @ResponseStatus(HttpStatus.OK)
    public PersonDTO getByStates(@PathVariable String state) { return personService.findByState(state); }

    @Operation(summary = "Update a person by id")
    @PutMapping("/{personId}")
    @ResponseStatus(HttpStatus.OK)
    public MessageResponseDTO update(@PathVariable Long personId, @RequestBody @Valid PersonDTO personDTO) {
        return personService.update(personId, personDTO);
    }

    @Operation(summary = "Delete person by id")
    @DeleteMapping("/{personId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long personId) { personService.delete(personId); }

}

