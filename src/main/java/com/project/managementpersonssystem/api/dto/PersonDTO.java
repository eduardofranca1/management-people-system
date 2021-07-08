package com.project.managementpersonssystem.api.dto;

import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class PersonDTO {

    private Long id;

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @NotEmpty
    @CPF
    private String cpf;

    @NotEmpty
    private LocalDate birthday;

    @NotEmpty
    @Valid
//    private PhoneDTO phone;
    private List<PhoneDTO> phones;
}
