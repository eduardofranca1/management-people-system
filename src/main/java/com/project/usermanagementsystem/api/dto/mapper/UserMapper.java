package com.project.usermanagementsystem.api.dto.mapper;

import com.project.usermanagementsystem.api.dto.UserDTO;
import com.project.usermanagementsystem.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "birthday", source = "birthday", dateFormat = "dd-MM-yyyy")
    User toModel(UserDTO dto);

    UserDTO toDTO(User dto);
}

