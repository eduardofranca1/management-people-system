package com.project.managementpeoplesystem.api.dto.mapper;

import com.project.managementpeoplesystem.api.dto.AddressDTO;
import com.project.managementpeoplesystem.domain.model.Address;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

    AddressDTO toDTO(Address dto);
}
