package com.project.managementpersonssystem.api.dto;

import com.project.managementpersonssystem.domain.model.enums.PhoneType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
public class PhoneDTO {

    private Long id;

    @Enumerated(EnumType.STRING)
    private PhoneType type;

    @NotEmpty
    @Size(min = 13, max = 14)
    private String number;
}
