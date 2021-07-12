package com.project.managementpeoplesystem.api.dto;

import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonDTO {

    private Long id;

    @NotEmpty(message = "{firstName.notempty}")
    @Size(min = 2, max = 100)
    private String firstName;

    @NotEmpty(message = "{lastName.notempty}")
    @Size(min = 2, max = 100)
    private String lastName;

    @NotEmpty(message = "{cpf.notempty}")
    @CPF
    private String cpf;

    @NotNull(message = "{birthday.notnull}")
    private String birthday;

    @Valid
    @NotEmpty
    private List<PhoneDTO> phones;

    @Valid
    private AddressDTO address;
}
