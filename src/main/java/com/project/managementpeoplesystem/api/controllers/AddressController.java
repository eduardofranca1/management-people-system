package com.project.managementpeoplesystem.api.controllers;

import com.project.managementpeoplesystem.api.dto.AddressDTO;
import com.project.managementpeoplesystem.domain.services.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor(onConstructor = @__(@Autowired))
@RestController
@RequestMapping("/address")
public class AddressController {

    private final AddressService addressService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AddressDTO> getAll() { return addressService.listAll(); }

    @GetMapping("/{addressId}")
    @ResponseStatus(HttpStatus.OK)
    public AddressDTO getById(@PathVariable Long addressId) { return addressService.findById(addressId); }

}
