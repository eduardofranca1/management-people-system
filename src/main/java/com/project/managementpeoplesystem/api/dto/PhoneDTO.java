package com.project.managementpeoplesystem.api.dto;

import com.project.managementpeoplesystem.domain.model.enums.PhoneType;
import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PhoneDTO {

    private Long id;

    @Enumerated(EnumType.STRING)
    private PhoneType type;

    @NotEmpty(message = "{number.notempty}")
    @Size(min = 12, max = 13)
    private String number;
}
