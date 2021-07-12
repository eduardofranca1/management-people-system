package com.project.usermanagementsystem.api.controllers;

import com.project.usermanagementsystem.api.dto.AddressDTO;
import com.project.usermanagementsystem.domain.services.AddressService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Address Endpoint")
@AllArgsConstructor(onConstructor = @__(@Autowired))
@RestController
@RequestMapping("/address")
public class AddressController {

    private final AddressService addressService;

    @Operation(summary = "List all address")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AddressDTO> getAll() { return addressService.listAll(); }

    @Operation(summary = "Find address by id")
    @GetMapping("/{addressId}")
    @ResponseStatus(HttpStatus.OK)
    public AddressDTO getById(@PathVariable Long addressId) { return addressService.findById(addressId); }

}
