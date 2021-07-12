package com.project.managementpeoplesystem.api.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {

    private Long id;

    @NotEmpty(message = "{number.notempty}")
    private String number;

    @NotEmpty(message = "{address.notempty}")
    private String address;

    @NotEmpty(message = "{neighborhood.notempty}")
    private String neighborhood;

    @NotEmpty(message = "{city.notempty}")
    private String city;

    @NotEmpty(message = "{state.notempty}")
    private String state;

    @NotEmpty(message = "{postalCode.notempty}")
    private String postalCode;
}
