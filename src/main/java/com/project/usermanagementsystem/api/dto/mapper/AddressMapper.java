package com.project.usermanagementsystem.api.dto.mapper;

import com.project.usermanagementsystem.api.dto.AddressDTO;
import com.project.usermanagementsystem.domain.model.Address;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

    AddressDTO toDTO(Address dto);
}
