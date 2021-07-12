package com.project.usermanagementsystem.utils;

import com.project.usermanagementsystem.api.dto.UserDTO;
import com.project.usermanagementsystem.domain.model.User;

import java.time.LocalDate;
import java.util.Collections;

public class UserUtils {

    private static final String FIRST_NAME = "Rodrigo";
    private static final String LAST_NAME = "Peleias";
    private static final String CPF_NUMBER = "369.333.878-79";
    private static final long PERSON_ID = 1L;
    public static final LocalDate BIRTHDAY = LocalDate.of(2010, 10, 1);

    public static UserDTO createFakeDTO() {
        return UserDTO.builder()
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF_NUMBER)
                .birthday("04-04-2010")
                .phones(Collections.singletonList(PhoneUtils.createFakeDTO()))
                .address(AddressUtils.createFakeDTO())
                .build();
    }

    public static User createFakeEntity() {
        return User.builder()
                .id(PERSON_ID)
                .firstName(FIRST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF_NUMBER)
                .birthday(BIRTHDAY)
                .phones(Collections.singletonList(PhoneUtils.createFakeEntity()))
                .address(AddressUtils.createFakeEntity())
                .build();
    }
}