package com.project.usermanagementsystem.api.controllers;

import com.project.usermanagementsystem.api.dto.UserDTO;
import com.project.usermanagementsystem.api.dto.MessageResponseDTO;
import com.project.usermanagementsystem.domain.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Tag(name = "User Endpoint")
@RestController
@RequestMapping("/users")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {

    private final UserService userService;

    @Operation(summary = "Create new User")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO create(@RequestBody @Valid UserDTO userDTO) {
        return userService.createPerson(userDTO);
    }

    @Operation(summary = "List all Users")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UserDTO> getAll() { return userService.listAll(); }

    @Operation(summary = "Find user by id")
    @GetMapping("/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public UserDTO getById(@PathVariable Long userId) { return userService.findById(userId); }

    @Operation(summary = "Find user by CPF")
    @GetMapping("/cpf/{cpf}")
    @ResponseStatus(HttpStatus.OK)
    public UserDTO getByCpf(@PathVariable String cpf) { return userService.findByCpf(cpf); }

    @Operation(summary = "List all users by city")
    @GetMapping("/city/{city}")
    @ResponseStatus(HttpStatus.OK)
    public UserDTO getByCities(@PathVariable String city) { return userService.findByCity(city); }

    @Operation(summary = "List all users by state")
    @GetMapping("/state/{state}")
    @ResponseStatus(HttpStatus.OK)
    public UserDTO getByStates(@PathVariable String state) { return userService.findByState(state); }

    @Operation(summary = "Update user by id")
    @PutMapping("/{userId}")
    @ResponseStatus(HttpStatus.OK)
    public MessageResponseDTO update(@PathVariable Long userId, @RequestBody @Valid UserDTO userDTO) {
        return userService.update(userId, userDTO);
    }

    @Operation(summary = "Delete user by id")
    @DeleteMapping("/{userId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long userId) { userService.delete(userId); }

}

